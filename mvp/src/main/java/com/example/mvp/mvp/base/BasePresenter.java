package com.example.mvp.mvp.base;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends MainContract.IBaseView, M extends MainContract.IBaseModel> {

    protected M model;
    protected WeakReference<V> vWeakReference;

    /**
     * 和view绑定
     *
     * @param view
     */
    public void attachView(V view) {
        this.vWeakReference = new WeakReference<>(view);
        this.model = createModel();
    }

    protected V getView() {
        return vWeakReference != null ? vWeakReference.get() : null;
    }


    /**
     * 解绑
     */
    protected void detachView() {
        if (vWeakReference != null) {
            vWeakReference.clear();
            vWeakReference = null;
        }
        model = null;
    }

    /**
     * 创建model
     *
     * @return
     */
    protected abstract M createModel();

    /**
     * 是否绑定
     *
     * @return
     */
    protected boolean isAttach() {
        return getView() != null;
    }
}
