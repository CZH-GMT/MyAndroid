package com.example.mvp.mvp.base;

public interface MainContract {

    /**
     * model Interface
     */
    interface IBaseModel {
        void LoadData(onResponseCallBack onResponseCallBack);

        interface onResponseCallBack {
            void success(String data);

            void showError(String error);
        }
    }

    /**
     * baseView
     */
    interface IBaseView {
    }

    /**
     * viewInterface
     */

    interface IView extends IBaseView {

        void showError(String error);

        void showData(String date);

        void showProcess();

        void hitProcess();
    }
}
