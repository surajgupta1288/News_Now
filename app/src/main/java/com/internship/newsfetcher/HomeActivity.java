package com.internship.newsfetcher;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.internship.newsfetcher.utils.CustomTabs;

import java.util.Locale;

public class HomeActivity extends AppCompatActivity {
    private TextView mTvTitle,mTvDescription;
    private ImageView mIvImage;
    private String newsDescription,newsTitle,newsImage,newsUrl;
    private ImageView mIvShare,mIvWebView,mIvSpeak;
    private TextToSpeech textToSpeech;

    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mIvShare=findViewById(R.id.share);
        mIvWebView=findViewById(R.id.opnWeb);
        mIvSpeak=findViewById(R.id.speak);

        textToSpeech=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });
        mIvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_SEND);
                intent2.setType("text/plain");
                intent2.putExtra(Intent.EXTRA_TEXT, newsUrl);
                startActivity(Intent.createChooser(intent2, "Share via"));

            }
        });
        mIvWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                CustomTabs.openTab(HomeActivity.this,newsUrl);
//                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
//                CustomTabsIntent customTabsIntent = builder.build();
//                customTabsIntent.launchUrl(HomeActivity.this, Uri.parse(newsUrl));
            }
        });
        mIvSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                textToSpeech.speak(newsTitle, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        mTvTitle=findViewById(R.id.tv_title);
        mTvDescription=findViewById(R.id.tv_description);
        mIvImage=findViewById(R.id.iv_news_image);
       newsDescription= getIntent().getStringExtra("NEWS_DESCRIPTION");//* HEAR GET TEXT
       newsTitle= getIntent().getStringExtra("NEWS_TITLE"); //* WE GET THE TEXT AND STORE INSIDE  newsTitle REF// FOR USE TEXT TO SPEECH
        newsImage=getIntent().getStringExtra("NEWS_IMAGE"); //* WE GET THE TEXT AND STORE INSIDE  newsRef //
        newsUrl=getIntent().getStringExtra("NEWS_URL");


        Log.i(TAG, "onCreate::::::: newsDescription for checking null "+newsDescription);


        if (newsTitle == null ) {
            mTvTitle.setVisibility(View.GONE);
        }else {
            mTvTitle.setVisibility(View.VISIBLE);
            mTvTitle.setText(newsTitle);
        }
        if(newsDescription.equals("null")){
            mTvDescription.setVisibility(View.GONE);

        }else {
            mTvDescription.setVisibility(View.VISIBLE);
            mTvDescription.setText(newsDescription); //*HEAR SET TEXT
        }
//        newsImage=mIvImage.
                Glide.with(this).load(newsImage).placeholder(R.drawable.news_logo).error(R.drawable.news_logo).into(mIvImage);

/**
 *when image not loading or apk don,t get image
 *.placeholder(R.drawable.ic_launcher_background).error(R.drawable.news_logo).
 * ic_launcher_background for  place holder default image
 * news_logo for apk dont get image means image not upload in apk by server
 * it is use in API DATA ADAPTER GLIDE IMAGE INITIALIZATION ALL PLACES
 * */



    }

    public void onPause(){
        if(textToSpeech !=null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onPause();
    }
}