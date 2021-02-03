package com.wujian.android.common.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class DataBindAdapter {
    @BindingAdapter({"imgRecourse"})
    public static void setImageRecourse(ImageView imageView, int res) {
        imageView.setImageResource(res);
    }

    @BindingAdapter({"imgUrl"})
    public static void getTransImageView(ImageView imageView, String url) {
    }
}
