package com.example.kotlin

import java.util.*

//TODO kotlin 【】操作符
/*
  //五种返回类型变化解释
  //给泛型传入null后直接操作
 */
class KtBase30<T>(vararg var input: T, var isok: Boolean = true) {
    //开启泛型T的只读模式
    var objectArray: Array<out T> = input

    //五种返回类型变化解释
    fun getR1(): Array<out T>? = objectArray.takeIf { isok }

    fun getR2(): Any = objectArray.takeIf { isok } ?: "是空的"

    fun getR3(): Any? = objectArray.takeIf { isok } ?: "是空的" ?: null

    fun getR4(index: Int): T? = objectArray[index].takeIf { isok } ?: null

    fun getR5(index: Int): Any? = objectArray[index].takeIf { isok } ?: "空的" ?: null

    //TODO 运算符重载
    operator fun get(index: Int): T? = objectArray[index].takeIf { isok }

}


fun <B> showinput(item: B) {

//    println(item.toString().length)

//string?可以接受string 还可以接受null
    println((item as String?)?.toString() ?: "穿的是null")
}

fun main() {
    showinput("wertyop")
    showinput("hh")
    showinput(null)



    //TODO 运算符重载测试
    val ktBase30 = KtBase30("dd", "ertyuiop[","4567", null)
    //TODO 因为传入了null所以接收类型要添加？     **********
    val s:String? = ktBase30[3] //null
    //TODO 传入的参数中只要有一个null  那么所有的接受类型都得 添加？
    val s1:String? = ktBase30[0]//dd

    println(ktBase30[0])
    println(ktBase30[1])
    println(ktBase30[2])
    println(s)


}