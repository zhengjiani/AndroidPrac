package com.zjn.helloworld.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.zjn.helloworld.R;

public class AFragment extends Fragment {

    private TextView mTvTitle;
    private Button mBtnChange,mBtnReset,mBtnMessage;
    private BFragment bFragment;
    private IOnMessageClick listener;
//    private Activity mActivity;
    public static AFragment newInstance(String title){
        //传好参数的fragment
        AFragment fragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        //即便fragment被重构也会重新设置上参数，使用setArguments方法
        fragment.setArguments(bundle);
        return fragment;
    }

    //回调接口方式实现数据传递
    public interface IOnMessageClick{
        void onClick(String text);
    }

    @Override
    public void onAttachFragment(@NonNull Fragment childFragment) {
        super.onAttachFragment(childFragment);
        try{
            listener = (IOnMessageClick) childFragment;
        }catch (ClassCastException e){
            throw new ClassCastException("Activity 必须实现IOnMessageClick接口");
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        Log.d("AFragment","--onCreateView--");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_title);
        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnReset = view.findViewById(R.id.btn_reset);
        mBtnMessage = view.findViewById(R.id.btn_message);
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ((ContainerActivity)getActivity()).setData("你好");
                listener.onClick("你好");
            }
        });
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bFragment == null){
                    bFragment = new BFragment();
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("a");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();

                }

            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mTvTitle.setText("我是新文字");
            }
        });
        //getActivity != null 判断一下
        if(getArguments() != null){
            mTvTitle.setText(getArguments().getString("title"));
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消异步
    }
}
