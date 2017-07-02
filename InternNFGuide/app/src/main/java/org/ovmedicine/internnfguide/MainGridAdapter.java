package org.ovmedicine.internnfguide;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainGridAdapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList mListData;
    private int mLayoutResourceId;

    //region Constructor
    public MainGridAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        mContext = context;
        mListData = data;
        mLayoutResourceId = layoutResourceId;
    }
    //endregion

    //region Adapter Functions
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View itemView = view;
        // inflate views if not already inflated
        if(itemView == null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            itemView = inflater.inflate(mLayoutResourceId, parent, false);
        }
        // setup cardview
        String[] viewData = (String[]) mListData.get(position);
        ChapterCardView cardView = new ChapterCardView(itemView, mContext);

        if(viewData[MainGridCardItems.card_image_file_name.ordinal()] != null)
            cardView.setCardImage(viewData[MainGridCardItems.card_image_file_name.ordinal()]);
        if(viewData[MainGridCardItems.card_title.ordinal()] != null){
            cardView.setCardTitle(viewData[MainGridCardItems.card_title.ordinal()]);
        }
        String subsessionList = viewData[MainGridCardItems.card_subsession_list.ordinal()];
        String subsessionUrlList = viewData[MainGridCardItems.card_subsession_url_list.ordinal()];
        if(subsessionList != null)
            cardView.setSubsessionList(subsessionList,subsessionUrlList);

        return itemView;
    }


    public void SetData(ArrayList newdata)
    {
        mListData.clear();
        mListData = newdata;
    }

    @Override
    public void clear() {
        super.clear();
        mListData.clear();
    }

    @Override
    public void addAll(Object[] items) {
        super.addAll(items);
        mListData = new ArrayList();
        for(int i=0; i< items.length; i++)
        {
            mListData.add(i, items[i]);
        }
    }

    @Nullable
    @Override
    public String[] getItem(int position) {
        return (String[])mListData.get(position);
    }
    //endregion



    //region Main Grid Items Enum
    public static enum MainGridCardItems{
        card_image_file_name,
        card_title,
        card_subsession_list,
        card_subsession_url_list,
    }
    //endregion
}
