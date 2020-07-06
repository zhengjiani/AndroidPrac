package com.zjn.quickstart.livedatatest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLiveData extends ViewModel {
    private MutableLiveData<Integer> LikedNumber;
    //1.写一个构造方法防止为空
//    ViewModelWithLiveData(){
//        LikedNumber = new MutableLiveData<>();
//        LikedNumber.setValue(0);
//    }

    public MutableLiveData<Integer> getLikedNumber() {
        if (LikedNumber == null) {
            LikedNumber = new MutableLiveData<>();
            LikedNumber.setValue(0);
        }
        return LikedNumber;
    }

    public void addLikeNumber(int n) {
        LikedNumber.setValue(LikedNumber.getValue() + n);
    }
}
