package com.example.myandroid.proxymvp;

public class ProxyPresenter extends BaseProxyPresenter<IViewInterface> {

    public ProxyPresenter(IViewInterface iViewInterface) {
        super(iViewInterface);
    }


    public void getData() {
        getView().showData("hhhhhhhhhh");
    }

}
