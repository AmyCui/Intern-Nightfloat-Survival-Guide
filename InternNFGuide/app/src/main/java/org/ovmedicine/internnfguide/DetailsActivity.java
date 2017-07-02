package org.ovmedicine.internnfguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.details_webview) WebView mContentWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        //get the passed in html url from list item
        String contenturl = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        //uncomment the follwoing lines when data is ready
//        if(!contenturl.isEmpty())
//            mContentWebview.loadUrl(contenturl);
        // test url
        mContentWebview.loadUrl("file:///android_asset/test.html");
    }
}
