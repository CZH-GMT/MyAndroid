package com.example.kotlin

//TODO kotlin 语言的合并函数 zip  使用: var list:List<pair<K,V>> = list1.zip(list2)  最后合并成一个集合

fun main() {
    val list1 = listOf("张三", "李四", "王五")
    val list2 = listOf(1, 2, 3)

    //Rxjava 有 zip操作符
    //kotlin 自带 zip操作符

    //zip原理:原理就是把第一个集合和第二个集合 合并起来 创建新的集合，并返回。
    //zip 创建的新集合（元素，元素，元素） 元素pair<K,V> K代替第一个元素  V代替第二个元素
    val zip: List<Pair<String, Int>> = list1.zip(list2)
    println(zip)

    println()
    //tomap
    println(zip.toMap())

    println()
    //toset
    println(zip.toMutableSet())

    println()
    //tolist
    println(zip.toMutableList())

    //遍历
    zip.forEach {
        println("姓名是${it.first},年龄是${it.second}")
    }

    println()

    zip.forEach { (K, V) ->
        println("姓名是${K},年龄是${V}")
    }

}