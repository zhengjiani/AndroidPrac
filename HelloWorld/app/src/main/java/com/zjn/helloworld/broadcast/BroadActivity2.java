package com.zjn.helloworld.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zjn.helloworld.R;

public class BroadActivity2 extends AppCompatActivity {

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad2);
        mBtn = findViewById(R.id.btn_click);
        //点击按钮发送广播
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.zjn.update");
                LocalBroadcastManager.getInstance(BroadActivity2.this).sendBroadcast(intent);
            }
        });
    }


}
