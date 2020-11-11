package com.internship.newsfetcher;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.internship.newsfetcher.adapter.ApiDataAdapter;
import com.internship.newsfetcher.model.ApiData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ApiDataAdapter.OnItemClickListener {
    private Toolbar toolbar;
    private static final String TAG = "MainActivity";
    private ArrayList<ApiData>apiDataArrayList;
    private RecyclerView rvNewsList;
    ApiDataAdapter apiDataAdapter;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar=findViewById(R.id.progress_circular);
        progressBar.setVisibility(View.GONE);


        rvNewsList=findViewById(R.id.rv_list);

        rvNewsList.setLayoutManager(new LinearLayoutManager(this));
        apiDataArrayList=new ArrayList<>();
         apiDataAdapter=new ApiDataAdapter();
        apiDataAdapter.setmContext(this);
        apiDataAdapter.setApiDataArrayList(apiDataArrayList);
        apiDataAdapter.setItemClickListener(this);
        rvNewsList.setAdapter(apiDataAdapter);

        String  newsType = getIntent().getStringExtra("TYPE");

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(newsType);
        }
        AndroidNetworking.initialize(getApplicationContext()); //* INITIALIZATION FIRST NETWORKING METHOD

        if (newsType.equals("Technology")){
            getTechnology();
        }else if(newsType.equals("Entertainment")){

            getEntertainment();
        }else if (newsType.equals("Sports")){
            getSports();
        }else if (newsType.equals("Science")){
            getScience();
        }else if (newsType.equals("Business")){
            getBusiness();
        }else if(newsType.equals("Health")){
            getHealth();
        }















    }

    private void getTechnology() {

        progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.get("http://newsapi.org/v2/top-headlines")
                .addQueryParameter("country", "in")
                .addQueryParameter("category","technology")
                .addQueryParameter("apiKey","f4a2a805b45144249c9cc9b48e5b0bbd")
                .setTag("GetTechnology") //* THROUGH THIS TAG WE ARE CHANGE API THROUGH IF ELSE CONDITION//
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        progressBar.setVisibility(View.GONE);
                        JSONArray jsonArray=response.optJSONArray("articles");
                           if(jsonArray!=null&&jsonArray.length()>0){
                               for (int i=0;i<jsonArray.length();i++){
                                   String title = jsonArray.optJSONObject(i).optString("title");
                                   String description=jsonArray.optJSONObject(i).optString("description");
                                   String urlToImage=jsonArray.optJSONObject(i).optString("urlToImage");
                                   String url=jsonArray.optJSONObject(i).optString("url");

                                   ApiData data = new ApiData();
                                   data.description = description;//* HEAR IM NOT NOT SET VALUE BECAUSE I DECLARE VARIABLE PUBLIC IN APIDATA CLASS//
                                   data.title=title;
                                   data.url=url;
                                   data.urlToImage=urlToImage;
                                   apiDataArrayList.add(data);
                               }
                               apiDataAdapter.notifyDataSetChanged();
                       }
                    }

                    @Override
                    public void onError(ANError anError) {

                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onError: "+anError.getErrorDetail() );

                    }
                });

    }

    private void getHealth() {

        progressBar.setVisibility(View.VISIBLE);
            AndroidNetworking.get("http://newsapi.org/v2/top-headlines")
                    .addQueryParameter("country", "in")
                    .addQueryParameter("category","health")
                    .addQueryParameter("apiKey","f4a2a805b45144249c9cc9b48e5b0bbd")
                    .setTag("Science")
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {

                            progressBar.setVisibility(View.GONE);
                            JSONArray jsonArray=response.optJSONArray("articles");
                            if(jsonArray!=null&&jsonArray.length()>0){
                                for (int i=0;i<jsonArray.length();i++){
                                    String title = jsonArray.optJSONObject(i).optString("title");
                                    String description=jsonArray.optJSONObject(i).optString("description");
                                    String urlToImage=jsonArray.optJSONObject(i).optString("urlToImage");
                                    String url=jsonArray.optJSONObject(i).optString("url");

                                    ApiData data = new ApiData();
                                    data.description = description;
                                    data.title=title;
                                    data.urlToImage=urlToImage;
                                    data.url=url;
                                    apiDataArrayList.add(data);
                                }
                                apiDataAdapter.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onError(ANError anError) {

                            progressBar.setVisibility(View.GONE);
                            Log.e(TAG, "onError: "+anError.getErrorDetail() );

                        }
                    });

    }

    private void getBusiness() {

        progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.get("http://newsapi.org/v2/top-headlines")
                .addQueryParameter("country", "in")
                .addQueryParameter("category","business")
                .addQueryParameter("apiKey","f4a2a805b45144249c9cc9b48e5b0bbd")
                .setTag("Science")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        progressBar.setVisibility(View.GONE);
                        JSONArray jsonArray=response.optJSONArray("articles");
                        if(jsonArray!=null&&jsonArray.length()>0){
                            for (int i=0;i<jsonArray.length();i++){
                                String title = jsonArray.optJSONObject(i).optString("title");
                                String description=jsonArray.optJSONObject(i).optString("description");
                                String urlToImage=jsonArray.optJSONObject(i).optString("urlToImage");
                                String url=jsonArray.optJSONObject(i).optString("url");

                                ApiData data = new ApiData();
                                data.description = description;
                                data.title=title;
                                data.urlToImage=urlToImage;
                                data.url=url;
                                apiDataArrayList.add(data);
                            }
                            apiDataAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onError: "+anError.getErrorDetail() );

                    }
                });



    }

    private void getScience() {

        progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.get("http://newsapi.org/v2/top-headlines")
                .addQueryParameter("country", "in")
                .addQueryParameter("category","science")
                .addQueryParameter("apiKey","f4a2a805b45144249c9cc9b48e5b0bbd")
                .setTag("Science")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        progressBar.setVisibility(View.GONE);
                        JSONArray jsonArray=response.optJSONArray("articles");
                        if(jsonArray!=null&&jsonArray.length()>0){
                            for (int i=0;i<jsonArray.length();i++){
                                String title = jsonArray.optJSONObject(i).optString("title");
                                String description=jsonArray.optJSONObject(i).optString("description");
                                String urlToImage=jsonArray.optJSONObject(i).optString("urlToImage");
                                String url=jsonArray.optJSONObject(i).optString("url");

                                ApiData data = new ApiData();
                                data.description = description;
                                data.title=title;
                                data.urlToImage=urlToImage;
                                data.url=url;
                                apiDataArrayList.add(data);
                            }
                            apiDataAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onError: "+anError.getErrorDetail() );

                    }
                });


    }

    private void getSports() {

        progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.initialize(getApplicationContext());
        AndroidNetworking.get("http://newsapi.org/v2/top-headlines")
                .addQueryParameter("country", "in")
                .addQueryParameter("category","sports")
                .addQueryParameter("apiKey","f4a2a805b45144249c9cc9b48e5b0bbd")
                .setTag("Sports")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        progressBar.setVisibility(View.GONE);
                        JSONArray jsonArray=response.optJSONArray("articles");
                        if(jsonArray!=null&&jsonArray.length()>0){
                            for (int i=0;i<jsonArray.length();i++){
                                String title = jsonArray.optJSONObject(i).optString("title");
                                String description=jsonArray.optJSONObject(i).optString("description");
                                String urlToImage=jsonArray.optJSONObject(i).optString("urlToImage");
                                String url=jsonArray.optJSONObject(i).optString("url");

                                ApiData data = new ApiData();
                                data.description = description;
                                data.title=title;
                                data.urlToImage=urlToImage;
                                data.url=url;
                                apiDataArrayList.add(data);
                            }
                            apiDataAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onError: "+anError.getErrorDetail() );

                    }
                });
    }

    private void getEntertainment() {

        progressBar.setVisibility(View.VISIBLE);
        AndroidNetworking.get("http://newsapi.org/v2/top-headlines")
                .addQueryParameter("country", "in")
                .addQueryParameter("category","entertainment")
                .addQueryParameter("apiKey","f4a2a805b45144249c9cc9b48e5b0bbd")
                .setTag("sports")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        progressBar.setVisibility(View.GONE);
                        JSONArray jsonArray=response.optJSONArray("articles");
                        if(jsonArray!=null&&jsonArray.length()>0){
                            for (int i=0;i<jsonArray.length();i++){
                                String title = jsonArray.optJSONObject(i).optString("title");
                                String description=jsonArray.optJSONObject(i).optString("description");
                                String urlToImage=jsonArray.optJSONObject(i).optString("urlToImage");
                                String url=jsonArray.optJSONObject(i).optString("url");

                                ApiData data = new ApiData();
                                data.description = description;
                                data.title=title;
                                data.url=url;
                                data.urlToImage=urlToImage;
                                data.url=url;
                                apiDataArrayList.add(data);
                            }
                            apiDataAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {

                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onError: "+anError.getErrorDetail() );

                    }
                });
    }
    /** SENDING DATA THROUGH PUT EXTRA METHOD GET DATA INSIDE HOME ACTIVITY  SET DATA IN IF ELSE METHOD*/

    @Override
    public void itemClick(ApiData apiData, View view, String tag) {  //* WHICH ACTIVITY YOU WANT TO SHOW
        Intent newsIntent=new Intent(MainActivity.this,HomeActivity.class);
        newsIntent.putExtra("NEWS_DESCRIPTION",apiData.description);
        newsIntent.putExtra("NEWS_TITLE",apiData.title);
        newsIntent.putExtra("NEWS_IMAGE",apiData.urlToImage);//* ALWAYS TAKE UNDERSCORE DONT TAKE SPACE //
        newsIntent.putExtra("NEWS_URL",apiData.url);
        ActivityOptionsCompat optionsCompat= ActivityOptionsCompat.makeSceneTransitionAnimation(this,view,tag);
        startActivity(newsIntent,optionsCompat.toBundle());

    }
}