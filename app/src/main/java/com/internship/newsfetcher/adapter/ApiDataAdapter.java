package com.internship.newsfetcher.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.internship.newsfetcher.R;
import com.internship.newsfetcher.model.ApiData;

import java.util.ArrayList;

public class ApiDataAdapter extends RecyclerView.Adapter<ApiDataAdapter.ApiDataViewHolder> {
    private Context mContext;
    private ArrayList<ApiData> apiDataArrayList;

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<ApiData> getApiDataArrayList() {
        return apiDataArrayList;
    }

    public void setApiDataArrayList(ArrayList<ApiData> apiDataArrayList) {
        this.apiDataArrayList = apiDataArrayList;
    }

    @NonNull
    @Override
    public ApiDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cell_news, parent, false);
        return new ApiDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ApiDataViewHolder holder, int position) {


        final ApiData data = apiDataArrayList.get(position);
        holder.mTVTitle.setText(data.title);
        holder.mTvDescription.setText(data.description);
        Glide.with(mContext).load(data.urlToImage).placeholder(R.drawable.ic_launcher_background).error(R.drawable.news_logo).into(holder.mTvImage);
        /**
         *when image not loading or apk don,t get image
         *.placeholder(R.drawable.ic_launcher_background).error(R.drawable.news_logo).
         * ic_launcher_background for  place holder default image
         * news_logo for apk dont get image means image not upload in apk by server
         * */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //*USE OVERWRITE METHOD
                itemClickListener.itemClick(data,holder.itemView,"news");
            }
        });
    }

    @Override
    public int getItemCount() {
        return apiDataArrayList.size();
    }

    public class ApiDataViewHolder extends RecyclerView.ViewHolder {
        TextView mTVTitle;
        TextView mTvDescription;
        ImageView mTvImage;

        public ApiDataViewHolder(@NonNull View itemView) {
            super(itemView);
            mTVTitle = itemView.findViewById(R.id.tv_news_title);
            mTvDescription=itemView.findViewById(R.id.tv_news_description);
            mTvImage=itemView.findViewById(R.id.iv_image_news);
        }
    }
    OnItemClickListener itemClickListener; //*USE ON CLICK INSIDE INSIDE ADAPTER   OVERRIDE METHOD INSIDE onBindViewHolder AND WHICH ACTIVITY YOU WANT SHOW DATA EX-HEAR Mainactivity
    public void setItemClickListener(OnItemClickListener itemClickListener) { //*USE SETTER METHOD
        this.itemClickListener = itemClickListener; //* PASS THIS    this.itemClickListener = itemClickListener SEE INTERFACE TUTORIAL
    }

    public interface OnItemClickListener{
        void itemClick(ApiData apiData,  View view,String tag );
    }

}
