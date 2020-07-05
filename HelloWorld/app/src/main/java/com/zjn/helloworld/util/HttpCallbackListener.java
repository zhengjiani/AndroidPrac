package com.zjn.helloworld.util;

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
