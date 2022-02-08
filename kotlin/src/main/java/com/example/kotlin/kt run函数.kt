package com.example.kotlin

//TODO run函数   中有this  代表的是
/**
 * let函数：xxx.let{  it  } it代表xxx peint（it） ,返回类型根据最后一行的变化而变化
 * apply函数：xxx.apply{  this  }  this代表xxx ,     返回的都是xxx本身
 * run函数：xxx.run{  this }  this代表xxx ,   返回根据最后一行的变化而变化
 */
fun main() {

    val name = "We be must success!"
    name.run {
        //TODO  this代表name
        print(this)
    }

    //具名run函数 this
    val run = name.run(::method)
            .run(::method2)
            .run(::method3)
            .run(::method4)
//    print(run)

    //具名let函数  it
    var let=name.let(::method)
            .let(::method2)
            .let(::method3)
            .let(::method4)


}

fun method(str: String) = if (str.length > 5) true else false
fun method2(isok: Boolean) = if (isok) "长度大于5" else "长度小于5"
fun method3(str: String) = str
fun method4(str: String) = print(str)