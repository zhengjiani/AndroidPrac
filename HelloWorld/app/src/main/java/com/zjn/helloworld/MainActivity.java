package com.zjn.helloworld;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.zjn.helloworld.broadcast.BroadActivity;
import com.zjn.helloworld.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI,mBtnEvent,mBtnData,mBtnBroad,mBtnAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnEvent = findViewById(R.id.btn_event);
        mBtnData = findViewById(R.id.btn_data);
        mBtnBroad = findViewById(R.id.btn_broad);
        mBtnAnim = findViewById(R.id.btn_anim);
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnEvent.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mBtnBroad.setOnClickListener(onClick);
        mBtnAnim.setOnClickListener(onClick);


    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this,UIActivity.class);
                    break;
                case R.id.btn_event:
                    intent = new Intent(MainActivity.this,EventActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(MainActivity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_broad:
                    intent = new Intent(MainActivity.this, BroadActivity.class);
                    break;
                case R.id.btn_anim:
                    intent = new Intent(MainActivity.this, ObjectAnimActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
