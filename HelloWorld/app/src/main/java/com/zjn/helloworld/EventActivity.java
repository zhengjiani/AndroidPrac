package com.zjn.helloworld;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.zjn.helloworld.util.ToastUtil;
import com.zjn.helloworld.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnEven,mBtnHandler;
    private MyButton btnMy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        mBtnEven = findViewById(R.id.btn_even);
        mBtnHandler = findViewById(R.id.btn_handler);
        btnMy = findViewById(R.id.btn_my);
        //设置触摸监听
        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("Listener","---onTouch---");
                        break;
                }
                return false;
            }
        });
        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Listener","---onClick---");
            }
        });
        //通过内部类实现
//        mBtnEven.setOnClickListener(new OnClick());
        //匿名内部类
//        mBtnEven.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ToastUtil.showMsg(EventActivity.this,"click...");
//            }
//        });
        //通过事件源所在类实现监听
//        mBtnEven.setOnClickListener(EventActivity.this);
        //通过外部类
        mBtnEven.setOnClickListener(new MyClickListener(EventActivity.this));
        mBtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_even:
                ToastUtil.showMsg(EventActivity.this,"click...");
                break;
        }
    }


    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_even:
                    ToastUtil.showMsg(EventActivity.this,"click...");
                    break;
            }
        }
    }

    public void show(View v){
        switch (v.getId()){
            case R.id.btn_event:
                Log.d("布局","click");
                ToastUtil.showMsg(EventActivity.this,"click...");
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton","---onTouchEvent---");
                break;
        }
        return false;
    }
}
