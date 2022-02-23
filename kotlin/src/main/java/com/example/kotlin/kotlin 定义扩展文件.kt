package com.example.kotlin

import com.example.kotlin.kuozhnawenjian.showkuozhnawenjian

//TODO kotlin 定义扩展文件
/*
  TODO 1.先定义一个扩展文件  在外面创建一个包 扩展文件一般都是public 为了外边使用 一般使用public  外部使用  使用Iterable<E> 为了让他的子类都能用
 */

fun main() {

    val list = listOf("list1", "list2", "list3")

    val set = setOf("set1", "se2", "set3")

    //普通
    println(list.shuffled().first())
    println(set.shuffled().first())

    println()
    //使用扩展文件
    list.showkuozhnawenjian()
    set.showkuozhnawenjian()

}
