package com.zjn.quickstart.viewmodelrestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.zjn.quickstart.viewmodelrestore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    MyViewModel myViewModel;
    //常量定义方式
    public final static String KEY_NUMBER = "my_number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        myViewModel = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this))
                        .get(MyViewModel.class);
        mainBinding.setData(myViewModel);
        mainBinding.setLifecycleOwner(this);
    }


}
