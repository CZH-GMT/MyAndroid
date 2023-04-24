package com.example.myandroid.proxymvp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BaseProxyPresenter<V> {

    private Object o;

    public BaseProxyPresenter(V v) {
        initProxy(v);
    }

//    protected void attachView(V view) {
//        initProxy(view);
//    }

    protected void initProxy(V view) {
        o = Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(view, args);
            }
        });
    }

    protected V getView() {
        return (V) o;
    }
}
