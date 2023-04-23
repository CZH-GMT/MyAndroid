package com.example.mvp.mvp.base;

public abstract class BasePresenter<V extends MainContract.IBaseView, M extends MainContract.IBaseModel> {

    protected V view;
    protected M model;

    /**
     * 和view绑定
     * @param view
     */
    public void attachView(V view) {
        this.view = view;
        model = createModel();
    }

    /**
     * 解绑
     */
    public void detachView() {
        view = null;
        model = null;
    }

    /**
     * 创建model
     * @return
     */
    protected abstract M createModel();

    /**
     * 是否绑定
     * @return
     */
    protected boolean isAttach() {
        return view != null;
    }
}
