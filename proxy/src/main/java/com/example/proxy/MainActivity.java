package com.example.proxy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proxy.staticproxy.Agent;
import com.example.proxy.staticproxy.MessageInterface;
import com.example.proxy.staticproxy.Real1;
import com.example.proxy.staticproxy.Real2;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        //静态代理
        Real1 real1 = new Real1();//真实对象1
        MessageInterface real2 = new Real2();
        Agent agent1 = new Agent(real1);
        Agent agent2 = new Agent(real2);
        agent1.text();
        agent2.text();


        //动态代理
        //创建真正的对象
        Real1 real11 = new Real1();

        //动态代理
        Object o = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{MessageInterface.class},//jdk只能代理接口
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // proxy(指的就是上面的o )  method 就是方法名   args 是接口中的参数
                        return method.invoke(real11, args);
                    }
                });

        MessageInterface messageInterface = (MessageInterface) o;
        messageInterface.text(); //调用的时候会回调到invoke方法中
    }

    public void s(){


    }
}