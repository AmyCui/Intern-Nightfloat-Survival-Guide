package org.ovmedicine.internnfguide;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChapterCardView {

    //region fields
    @BindView(R.id.card_image) ImageView mCardImg;
    @BindView(R.id.chapter_title) TextView mCardTitle;
    @BindView(R.id.card_expand_button) ToggleButton mExpandToggleBtn;
    @BindView(R.id.card_subsessions_listview) GridView mSubsessionsList;
    @BindView(R.id.card_expandable_layout) FrameLayout mExpandableLayout;
    private Context mContext;
    //endregion

    //region Constructor
    public ChapterCardView(View rootView, Context context){
        mContext = context;
        ButterKnife.bind(this, rootView);

        setExpandableLayoutVisiblity();

        //set up expand more/less toggle button for subsessions listview
        mExpandToggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setExpandableLayoutVisiblity();
            }
        });

        //setup default card image
        mCardImg.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.testimage2));

    }
    //endregion


    //region public methods
    public void setSubsessionList(final String listData, String listClickData){
        if(listData != null) {
            //parse list data
            final ArrayList subsessionList = parseStringToList(listData);
            ArrayList subsessionURLList = new ArrayList();
            if(listClickData != null)
                subsessionURLList = parseStringToList(listClickData);

            //create adapter
            ArrayAdapter adapter = new ArrayAdapter<String>(mContext,
                    android.R.layout.simple_list_item_1,
                    subsessionList);
            if (mSubsessionsList != null) {
                //set adapter
                mSubsessionsList.setAdapter(adapter);
                //update list height to fit all list content
                setListViewHeightBasedOnItems(mSubsessionsList);
            }
            // set list item onclicklistener to launch details view
            final ArrayList finalSubsessionURLList = subsessionURLList;
            mSubsessionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(mContext, DetailsActivity.class);
                    String url = "";
                    if(finalSubsessionURLList != null && finalSubsessionURLList.size() > position)
                        url =  (String)finalSubsessionURLList.get(position);

                    String listItemText = (String) subsessionList.get(position);
                    // send list item text, current chapter section list, and the url to the details view
                    intent.putExtra(Intent.EXTRA_TEXT, new String[]{listItemText, listData,url});
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public void setCardImage(String imageName){
        if(imageName != null && mCardImg != null){
            int id = mContext.getResources().getIdentifier("org.ovmedicine.internnfguide:drawable/" + imageName, null, null);
            mCardImg.setImageResource(id);
        }
    }

    public void setCardTitle(String text){
        if(mCardTitle != null && text != null){
            mCardTitle.setText(text);
        }
    }
    //endregion

    //region private methods
    private ArrayList parseStringToList(String data){
        ArrayList<String> result = new ArrayList<String>();
        String[] splitResult = data.split(",");
        for(String substring : splitResult){
            result.add(substring);
        }
        return result;
    }
    private void setExpandableLayoutVisiblity(){
        // if expand is true, show expandable layout containing subsessions listview
        if(mExpandToggleBtn.isChecked()){
            mExpandableLayout.setVisibility(View.VISIBLE);
        }
        // if expand is set to false, then hide the expandable layout
        else{
            mExpandableLayout.setVisibility(View.GONE);
        }
    }

    public static boolean setListViewHeightBasedOnItems(GridView gridView) {

        ArrayAdapter listAdapter = (ArrayAdapter) gridView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, gridView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }
            // Set list height.
            ViewGroup.LayoutParams params = gridView.getLayoutParams();
            params.height = totalItemsHeight;
            gridView.setLayoutParams(params);
            gridView.requestLayout();

            return true;

        } else {
            return false;
        }

    }
        //endregion

}
