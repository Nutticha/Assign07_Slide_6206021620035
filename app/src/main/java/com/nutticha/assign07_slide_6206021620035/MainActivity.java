package com.nutticha.assign07_slide_6206021620035;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    int res_image[] = {R.drawable.a , R.drawable.b, R.drawable.c , R.drawable.d,
                       R.drawable.e , R.drawable.f, R.drawable.g , R.drawable.h};
    Button btnStartSlide , btnStopSlide;
    private Handler mHandler = new Handler( Looper.myLooper());
    int iSlide = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(res_image[iSlide]);
        btnStartSlide = (Button) findViewById(R.id.btnStart);
        btnStartSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iv.setImageResource(res_image[iSlide]);
                mHandler.postDelayed(mUpdateTimeTask , 1000);
                btnStartSlide.setEnabled(true);
            }
        });
        btnStopSlide = (Button) findViewById(R.id.btnStop);
        btnStopSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.removeCallbacks(mUpdateTimeTask);

            }
        });
    }
    private Runnable mUpdateTimeTask = new Runnable () {
        public void run() {
            if (iSlide < 7) {
                iSlide ++;
                iv.setImageResource(res_image[iSlide]);
                mHandler.postDelayed(this, 1000);}
            else {
                iSlide = 0;
                iv.setImageResource(res_image[iSlide]);
            }
        }
    };
}