package com.zjn.helloworld.fragmentBestPrac;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zjn.helloworld.R;

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        if (getActivity().findViewById(R.id.news_content_layout)!=null){
//            //可以找到news_content_layout布局时，为双页模式
//            isTwoPane = true;
//        }else{
//            //找不到news_content_layout布局时，为单页模式
//            isTwoPane = false;
//        }
    }
}
