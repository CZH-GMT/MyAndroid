package com.example.mvp.present;

import com.example.mvp.model.Callback;
import com.example.mvp.model.Model;
import com.example.mvp.view.ViewInterface;

public class Present<T> implements PresenterInterface<T> {

    private Model model;
    private ViewInterface viewInterface;

    public Present(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
        model = new Model();

    }

    @Override
    public void getModeData() {
        model.data(new Callback() {
            @Override
            public void success(String date) {
                viewInterface.success(date);

            }

            @Override
            public void failed(String code) {
                viewInterface.failed(code);

            }
        });

    }
}
