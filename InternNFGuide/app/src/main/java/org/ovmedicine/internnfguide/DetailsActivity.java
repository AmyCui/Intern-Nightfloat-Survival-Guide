package org.ovmedicine.internnfguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    private static final String ASSETS_FOLDER_URL = "file:///android_asset/html/";

    @BindView(R.id.details_webview) WebView mContentWebview;
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavView;
    @BindView(R.id.bottom_sheet_list) ListView mSectionListView;


    private String mCurrentSectionName;
    private String mChapterSectionString;
    private ArrayList mChapterSectionList;
    private String mSectionUrl;
    private String mChapterSectionUrlString;
    private ArrayList mChapterSectionUrlList;
    private ArrayList mCompleteChapterSectionList;
    private ArrayList mCompleteChapterSectionUrlList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);


        //get the passed in html url from list item
        String[] input = getIntent().getStringArrayExtra(Intent.EXTRA_TEXT);

        mCurrentSectionName = input[0];
        mChapterSectionString = input[1];
        mSectionUrl = ASSETS_FOLDER_URL + input[2];
        mChapterSectionUrlString = input[3];

        //set title
        setTitle(mCurrentSectionName);

        //extract chapter section list and subsection list
        if(mChapterSectionString != null && !mChapterSectionString.isEmpty())
        {
            mCompleteChapterSectionList = new ArrayList();
            mChapterSectionList = parseStringToList(mChapterSectionString);

            mCompleteChapterSectionUrlList = new ArrayList();
            mChapterSectionUrlList = parseStringToList(mChapterSectionUrlString);

            for(int i=0; i<mChapterSectionList.size();i++){
                String listitem = (String)mChapterSectionList.get(i);
                mCompleteChapterSectionList.add(listitem);

                String listItemUrl = ASSETS_FOLDER_URL + (String)mChapterSectionUrlList.get(i);
                mCompleteChapterSectionUrlList.add(listItemUrl);

                String sublistString = AppData.SectionsLookupMap.get(listitem);
                if (sublistString != null) {
                    ArrayList sublist = parseStringToList(sublistString);
                    for (int j = 0; j < sublist.size(); j++) {
                        mCompleteChapterSectionList.add("     " + sublist.get(j));
                    }
                }

                String sublistUrlString = AppData.SectionsUrlLookupMap.get(listitem);
                if(sublistUrlString != null){
                    ArrayList subUrllist = parseStringToList(sublistUrlString);
                    for (int j = 0; j < subUrllist.size(); j++) {
                        mCompleteChapterSectionUrlList.add(ASSETS_FOLDER_URL + subUrllist.get(j));
                    }
                }
            }
        }


        //load content web view

        if(!mSectionUrl.isEmpty()) {
            mContentWebview.loadUrl(mSectionUrl);

            //Toast.makeText(this, "File " + mSectionUrl + " loaded", Toast.LENGTH_SHORT).show();
        }

        // test url
        //mContentWebview.loadUrl("file:///android_asset/test.html");

        //set up bottom sheet listview
        if(mCompleteChapterSectionList != null)
        {
            ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    mCompleteChapterSectionList);
            mSectionListView.setAdapter(adapter);
            mSectionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(mCompleteChapterSectionUrlList != null && !mCompleteChapterSectionUrlList.isEmpty()){
                        mCurrentSectionName = (String)mCompleteChapterSectionList.get(position);
                        setTitle(mCurrentSectionName);
                        mContentWebview.loadUrl((String)mCompleteChapterSectionUrlList.get(position));
                        //Toast.makeText(getApplicationContext(), "File " + (String)mCompleteChapterSectionUrlList.get(position) + " loaded! ", Toast.LENGTH_SHORT).show();
                        //collapse bottom sheet
                        toggleSubsectionListViewVisibility();
                    }
                }
            });
        }


        //set up bottom navigation view
        if(mCompleteChapterSectionList != null && !mCompleteChapterSectionList.isEmpty()){
            toggleSubsectionListViewVisibility();
            mBottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.nav_menu_show_subsections:
                            toggleSubsectionListViewVisibility();
                            break;
                    }
                    return true;
                }
            });
        }else{
            //Hide bottom navigation bar if no subsections available
            mBottomNavView.setVisibility(View.GONE);
        }
    }



    //region private methods
    private ArrayList parseStringToList(String data){
        ArrayList<String> result = new ArrayList<String>();
        String[] splitResult = data.split(",");
        for(String substring : splitResult){
            result.add(substring);
        }
        return result;
    }

    private void toggleSubsectionListViewVisibility(){
        if(mSectionListView.getVisibility() == View.VISIBLE)
            mSectionListView.setVisibility(View.GONE);
        else
            mSectionListView.setVisibility(View.VISIBLE);
    }
    //endregion
}
