package com.zjn.helloworld;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mCb5,mCb6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mCb5 = findViewById(R.id.cb_5);
        mCb6 = findViewById(R.id.cb_6);

        mCb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this,mCb5.isChecked()?"5选中":"5未选中",Toast.LENGTH_SHORT).show();
            }
        });

        mCb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(CheckBoxActivity.this,mCb6.isChecked()?"6选中":"6未选中",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
