package com.zjn.helloworld.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    //入口方法
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d("MyButton","---dispatchTouchEvent---");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("MyButton","---onTouchEvent---");
                break;
        }
        return super.onTouchEvent(event);
    }
}
