package com.example.kotlin

//TODO kotlin  by lazy{} 自动初始化
class KtBase8() {
    //普通方式》》》》》》》》》》》》》》》》》》》》》未调用by lazy  直接调用会还没在使用的时候调用
//    val sssss: String = getStrings()

    //调用by lazy方式》》》》》》》》》》》》》》》》》》》》》调用by lazy
    val hhhh by lazy { getStrings() }

    private fun getStrings(): String {
        println("加载中...")
        println("加载中...")
        println("加载中...")
        println("加载中...")
        println("加载中...")
        println("加载中...")
        println("加载中...")
        return "hahahhahahhahhahahhhahahhahahahah"
    }

    fun showh() {

        println(hhhh)
    }

    fun shows() {

//        println(sssss)
    }

}

fun main() {
    //调用by lazy
    val kt8 = KtBase8()
    println("即将开始使用")
    Thread.sleep(2000)
    kt8.showh()


}