package com.zjn.helloworld.datastorage;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.zjn.helloworld.R;

public class DataStorageActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnSharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_storage);
        mBtnSharedPreferences = findViewById(R.id.btn_sharedpreferences);
        mBtnSharedPreferences.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.btn_sharedpreferences:
                intent = new Intent(DataStorageActivity.this,SharedPreferencesActivity.class);
                break;
        }
        startActivity(intent);
    }
}
