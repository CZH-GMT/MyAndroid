package com.example.kotlin

//TODO kotlin infix 中缀表达式
/*
TODO 1.中缀表达式 +扩展函数使用     "男".to("22")     "男" to ("33")
     2.对第一个参数进行扩展 C1.xxx
     3.需要在括号中(C2:C2)传递一个参数
 */

//TODO 自定义一个中缀表达式
private infix fun <C1, C2> C1.gogogo(c2: C2) {
    println("K=${this} V=$c2")

}

private infix fun <A1, A2> A1.haha(a: A2) {}

fun main() {
    //第一种
    println(mapOf("男".to("18")))
    //使用中缀表达式写法
    println(mapOf("女" to "22"))

//自己写的中缀表达式
    "花姑娘".gogogo("1")
    "熊二" gogogo "翠花"

}