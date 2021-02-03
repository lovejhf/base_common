package com.wujian.android.developer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wujian.android.common.glide.GlideApp;
public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image);

    }
    public void jump(View view) {
        ARouter.getInstance().build("/app/login").navigation();
    }
}