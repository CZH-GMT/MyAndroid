package com.example.kotlin

//TODO kotlin 语言的变换函数 map  {it}
fun main() {
    var list = listOf("张三", "李四", "王五")
    //map原理；把匿名函数 最后一行 的返回值 添加到一个集合里 并返回 泛型为输入类型
    val map: List<String> = list.map {
        "haahhahaha"
        "[$it]"
    }
    println(map)


    val map1 = list.map {
        "姓名是$it"
    }.map {
        "$it 长度是${it.length}"

    }
//    println(map1)
            .map {
               "$it 在学习java $it 在学习kotlin $it 在学习小说"
            }
    println(map1)
}