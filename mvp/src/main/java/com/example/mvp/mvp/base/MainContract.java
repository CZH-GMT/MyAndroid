package com.example.mvp.mvp.base;

public class MainContract {

    /**
     * model Interface
     */
    public interface IBaseModel {
        void LoadData(onResponseCallBack onResponseCallBack);

        interface onResponseCallBack {
            void success(String data);

            void showError(String error);
        }
    }

    /**
     * baseView
     */
    public interface IBaseView {
    }

    /**
     * viewInterface
     */

    public interface IView extends IBaseView {

        void showError(String error);

        void showData(String date);

        void showProcess();

        void hitProcess();
    }
}
