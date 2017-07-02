package org.ovmedicine.internnfguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.details_webview) WebView mContentWebview;
    @BindView(R.id.bottom_navigation) BottomNavigationView mBottomNavView;
    @BindView(R.id.bottom_sheet_list) ListView mSectionListView;

    private String mSectionName;
    private String mChapterSectionString;
    private ArrayList mChapterSectionList;
    private String mSectionUrl;
    private ArrayList mCompleteChapterSectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        //get the passed in html url from list item
        String[] input = getIntent().getStringArrayExtra(Intent.EXTRA_TEXT);
        mSectionName = input[0];
        mChapterSectionString = input[1];
        mSectionUrl = input[2];
        //extract chapter section list and subsection list
        if(mChapterSectionString != null && !mChapterSectionString.isEmpty())
        {
            mCompleteChapterSectionList = new ArrayList();
            mChapterSectionList = parseStringToList(mChapterSectionString);
            for(int i=0; i<mChapterSectionList.size();i++){
                String listitem = (String)mChapterSectionList.get(i);
                mCompleteChapterSectionList.add(listitem);

                String sublistString = AppData.SectionsLookupMap.get(listitem);
                if (sublistString != null) {
                    ArrayList sublist = parseStringToList(sublistString);
                    for (int j = 0; j < sublist.size(); j++) {
                        mCompleteChapterSectionList.add("     " + sublist.get(j));
                    }
                }
            }
        }


        //load content web view
        //uncomment the following lines when data is ready
//        if(!mSectionUrl.isEmpty())
//            mContentWebview.loadUrl(mSectionUrl);
        // test url
        mContentWebview.loadUrl("file:///android_asset/test.html");

        //set up bottom sheet listview
        if(mCompleteChapterSectionList != null)
        {
            ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    mCompleteChapterSectionList);
            mSectionListView.setAdapter(adapter);
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
}
