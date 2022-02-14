package com.example.kotlin

//TODO kotlin 抽象类
abstract class BaseActivcity {
    fun onCreate() {
        setContentView(getLayoutId())
        initData()
        initView()
    }

    private fun setContentView(layout: Int) = println("加载到$layout 的布局")
    abstract fun getLayoutId(): Int
    abstract fun initData()
    abstract fun initView()
}

class MainActivitys : BaseActivcity() {
    override fun getLayoutId(): Int {
        return 8848
    }

    override fun initData() = println("设置数据")

    override fun initView() = println("设置控件")

    fun show(){
        super.onCreate()
    }
}

fun main() {
    println(MainActivitys().show())

}