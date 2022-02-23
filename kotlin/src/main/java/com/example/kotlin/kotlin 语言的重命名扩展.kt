package com.example.kotlin

import com.example.kotlin.kuozhnawenjian.showkuozhnawenjian as ok

//TODO kotlin  语言重命名扩展  在上面导的包中 后面添加 as xxx 然后下面我们调用的函数就被换成了我们转换的xxx
fun main() {

    val list = listOf("list1", "list2", "list3")

    val set = setOf("set1", "se2", "set3")

    //普通
    println(list.shuffled().first())
    println(set.shuffled().first())

    println()
    //使用扩展文件
    list.ok()
    set.ok()
}