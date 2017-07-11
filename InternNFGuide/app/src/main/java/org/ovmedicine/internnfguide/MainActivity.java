package org.ovmedicine.internnfguide;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.grid_view) GridView mChaptersGrid;
    private MainGridAdapter mGridAdapter;
    AlertDialog mDisclaimerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Support Action Bar
        getSupportActionBar().setTitle(R.string.app_name_actionbar_title);

        ButterKnife.bind(this);

        //set up cards
        ArrayList data = getAppData();
        mGridAdapter = new MainGridAdapter(this, R.layout.grid_item_cardview, data);
        mChaptersGrid.setAdapter(mGridAdapter);

        //display if hasn't accepted
        displayDisclaimer( );
    }

    @Override
    protected void onResume() {
        super.onResume();
        //display if hasn't accepted
        displayDisclaimer( );
    }

    private ArrayList getAppData(){
        ArrayList result = new ArrayList();

        int numOfChapters = AppData.ChapterTitlesList.size();

        for(int i=0 ; i<numOfChapters; i++){
            String[] cardData = new String[MainGridAdapter.MainGridCardItems.values().length];
            cardData[MainGridAdapter.MainGridCardItems.card_title.ordinal()] = AppData.ChapterTitlesList.get(i);
            cardData[MainGridAdapter.MainGridCardItems.card_subsession_list.ordinal()] = AppData.SubsessionsTitleList.get(i);
            cardData[MainGridAdapter.MainGridCardItems.card_subsession_url_list.ordinal()] = AppData.SubsessionsUrlList.get(i);
            result.add(cardData);
        }

        return result;
    }

    private void displayDisclaimer() {
        AlertDialog.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(getResources().getString(R.string.disclaimer_title))
                .setMessage(getResources().getString(R.string.disclaimer_text))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue and remember the user's setting
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        preferences.edit().putBoolean(getString(R.string.disclaimer_setting_key), true).apply();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Remember the user's setting
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        preferences.edit().putBoolean(getString(R.string.disclaimer_setting_key), false).apply();
                        // quit app
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert);
        if(mDisclaimerDialog == null)
            mDisclaimerDialog = builder.create();

        //get disclaimer preference
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean disclaimer_accepted = preferences.getBoolean(getResources().getString(R.string.disclaimer_setting_key),false);
        if(!disclaimer_accepted && !mDisclaimerDialog.isShowing())
            mDisclaimerDialog.show();
    }

}
