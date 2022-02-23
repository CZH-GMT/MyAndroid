package com.example.kotlin

import android.content.Context

//TODO kotlin 语言的DLS学习
//TODO DSL 其实指的是  DSL编程式规范 定义输入输出等规则

val ooo = "我是ooo"


//要让实现持有this  那么就得用context来点     如: Context.(xxx) -> Unit     xxx是什么实现中it就指什么
//输入的必须是context这个类才有资格调用这个dsl函数 函数中持有it  this
//输出我们定义的是context本身 所以可以链式调用
//然后main函数就可以根据DSL编程方式标准规则，来写具体的实现  这就是DSL编成
public inline fun Context.apply5(lambdas: Context.(String) -> Unit): Context {
    lambdas(ooo)
    return this

}

fun main() {
//    val apply5 = Context().apply5 {
//        println("success")
//        println(it)
//        println("this:$this  it:$it")
//
//
//    }
}