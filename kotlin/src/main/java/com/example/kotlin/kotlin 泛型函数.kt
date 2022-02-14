package com.example.kotlin

import android.app.ProgressDialog.show

//TODO kotlin泛型函数
//1.万能对象返回器 boolean来控制是否返回 运用takeIf
class KtBase25<T>(var boolean: Boolean, var obj: T) {
    fun getobj() = obj.takeIf { boolean }
}

/*
  TODO 1.万能对象返回器 boolean来控制是否返回 运用takeIf
       2.四个对象打印
       3.对象打印+run+？
       4.对象打印+apply+？
       5.show（t:T）+apply+?

 */
fun main() {

    val students = Students("张三", 22, '男')
    val students1 = Students("张丽丽", 18, '女')

    val Teachers = Teachers("张三", 22, '男')
    val Teachers1 = Teachers("张丽丽", 18, '女')
    //2.四个对象打印
    println(KtBase25(true, students).getobj())
    println(KtBase25(true, students1).getobj())
    println(KtBase25(true, Teachers).getobj())
    println(KtBase25(false, Teachers1).getobj() ?: "返回的是null呀？？？？？？")

    println()

    // 3.对象打印+run+？
    var a1 = KtBase25(false, students).getobj()?.run { //返回最后一行
        println("万能对象是$this")

    } ?: println("万能对象返回的是null")


    //对象打印+apply+？
    KtBase25(false, Teachers).getobj().apply {
        if (this == null) {
            println("apply万能对象返回的是null")
        } else {
            println("apply万能对象是$this")
        }
    }
    println()


    // 5.show（t:T）+apply+?\
    shows("ewew")
    shows(1223)
    shows(true)
    shows(null)


}

fun <T> shows(obj: T) {
    val any = obj?.also {
        println("shows万能对象是$it ")
    } ?: println("whows万能对象返回的是null")
}

