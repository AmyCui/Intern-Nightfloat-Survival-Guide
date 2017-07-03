package org.ovmedicine.internnfguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.grid_view) GridView mChaptersGrid;
    private MainGridAdapter mGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ArrayList data = getAppData();

        mGridAdapter = new MainGridAdapter(this, R.layout.grid_item_cardview, data);

        mChaptersGrid.setAdapter(mGridAdapter);
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

}
