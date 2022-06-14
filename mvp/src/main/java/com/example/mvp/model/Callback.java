package com.example.mvp.model;

public interface Callback {
    void success(String date);

    void failed(String code);
}
