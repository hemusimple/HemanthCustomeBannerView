package com.hemanthkumar.hemanthcustomebannerview.customebanners;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.hemanthkumar.hemanthcustomebannerview.R;
import com.hemanthkumar.hemanthcustomebannerview.network.ConnectionDetector;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by SAFACS on 6/23/2018.
 */

public class CustomeBanner extends FrameLayout {
    Context context;
    View view;

    public CustomeBanner(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }

    public CustomeBanner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public CustomeBanner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, Context context1) {
        super(context, attrs, defStyleAttr);
        this.context = context1;
    }

    public CustomeBanner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes, Context context1) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context1;
    }

    private int count = 1;
    private int imagesSize = -1;
    private int presentImage = -1;
    private ArrayList<String> images = new ArrayList<>();

    public void setAllImages(ArrayList<String> images) {
        this.images = images;
        addPagination();
    }

    private LinearLayout paginationholder;
    private Handler handler;

    private void init() {
        view = LayoutInflater.from(context).inflate(R.layout.customebanner, null);
        paginationholder = (LinearLayout) view.findViewById(R.id.smaplepagelisner);

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeimgholder);
        ViewGroup.LayoutParams params1 = getLayoutParams();
        if (params1 != null) {
            relativeLayout.setLayoutParams(params1);
        } else {
            relativeLayout.setLayoutParams(params);
        }
        handler = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                if (ConnectionDetector.checckNetwork(context)) {
                    if (images != null) {
                        imagesSize = images.size();
                        if (presentImage == -1) {
                            presentImage++;
                            setPaginationVisibility(presentImage);
                            final ImageView image = (ImageView) view.findViewById(R.id.sampleimg);
                            Picasso.with(context).load(images.get(presentImage)).into(image);

                        } else {
                            if (presentImage == imagesSize) {
                                setPaginationVisibility(presentImage - 1);
                                ImageView image = (ImageView) view.findViewById(R.id.sampleimg);
                                Picasso.with(context).load(images.get(presentImage - 1)).into(image);
                                //  image.setImageResource(R.drawable.ic_launcher_foreground);
                                presentImage = -1;
                            } else {
                                setPaginationVisibility(presentImage);
                                ImageView image = (ImageView) view.findViewById(R.id.sampleimg);
                                Picasso.with(context).load(images.get(presentImage)).into(image);
                                //     image.setImageResource(R.drawable.ic_launcher_background);
                                presentImage++;
                            }
                        }
                    }
                }
                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(r, 2000);
        addView(view);
    }

    private void addPagination() {
        if (images != null) {
            for (int i = 0; i < images.size(); i++) {
                View v = LayoutInflater.from(context).inflate(R.layout.pagination, null);
                paginationholder.addView(v);
            }
        }
    }

    private int previousePaginationItem = -1;

    private void setPaginationVisibility(int position) {
        if (paginationholder != null) {
            View v = paginationholder.getChildAt(position);
            RelativeLayout parent = (RelativeLayout) v;
            if(previousePaginationItem!=-1) {
                visibilityoff(previousePaginationItem);
            }
            visiblityon(position);
            TextView textView = (TextView) parent.getChildAt(0);
            textView.setVisibility(VISIBLE);
        }
    }

    private  void visiblityon(int position){
        View v = paginationholder.getChildAt(position);
        RelativeLayout parent = (RelativeLayout) v;
        TextView textView = (TextView) parent.getChildAt(0);
        textView.setVisibility(VISIBLE);
        previousePaginationItem = position;
    }
    private  void visibilityoff(int position){
        View v = paginationholder.getChildAt(position);
        RelativeLayout parent = (RelativeLayout) v;
        TextView textView = (TextView) parent.getChildAt(0);
        textView.setVisibility(INVISIBLE);
    }
}