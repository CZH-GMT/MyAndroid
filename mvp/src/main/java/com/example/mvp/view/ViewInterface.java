package com.example.mvp.view;

public interface ViewInterface<T> {
    void success(T t);

    void failed(String code);
}
