package com.zjn.helloworld.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.zjn.helloworld.R;

public class BroadActivity extends AppCompatActivity {

    private Button mBtn1;
    private TextView mtvTest;
    private MyBroadcast mBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad);
        mBtn1 = findViewById(R.id.btn_1);
        mtvTest = findViewById(R.id.tv_test);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BroadActivity.this,BroadActivity2.class);
                startActivity(intent);
            }
        });
        mBroadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.zjn.update");
        LocalBroadcastManager.getInstance(this).registerReceiver(mBroadcast,intentFilter);

    }
    private class MyBroadcast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()){
                case "com.zjn.update":
                    mtvTest.setText("123");
                    break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mBroadcast);
    }
}
