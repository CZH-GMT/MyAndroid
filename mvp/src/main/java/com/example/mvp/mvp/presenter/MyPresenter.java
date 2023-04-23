package com.example.mvp.mvp.presenter;


import com.example.mvp.mvp.base.BasePresenter;
import com.example.mvp.mvp.base.MainContract;
import com.example.mvp.mvp.model.MyModel;

public class MyPresenter extends BasePresenter<MainContract.IView, MyModel> {

    public MyPresenter() {
    }

    @Override
    protected MyModel createModel() {
        return new MyModel();
    }

    public void loadData() {
        model.LoadData(new MainContract.IBaseModel.onResponseCallBack() {
            @Override
            public void success(String data) {
                view.showData(data);
            }

            @Override
            public void showError(String error) {
                view.showError(error);
            }
        });

    }


}
