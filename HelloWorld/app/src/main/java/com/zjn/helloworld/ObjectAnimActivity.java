package com.zjn.helloworld;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ObjectAnimActivity extends AppCompatActivity {

    private TextView tvTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_anim);
        tvTest = findViewById(R.id.tv);
        //沿y轴方向发生平移
//        tvTest.animate().translationXBy(500).setDuration(20000).start();
        //2秒之内透明度变为0
//        tvTest.animate().alpha(0).setDuration(2000).start();
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100);
//        valueAnimator.setDuration(2000);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                //valueAnimator实际的值
//                Log.d("aaaa",valueAnimator.getAnimatedValue()+"");
//                //动画的进度0-1
//                Log.d("aaaa",valueAnimator.getAnimatedFraction()+"");
//            }
//        });
//        valueAnimator.start();

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvTest,"translationY",0,500,200);
        objectAnimator.setDuration(2000);
//        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//
//            }
//        });
        objectAnimator.start();
    }
}
