package com.example.kotlin

//TODO kotlin 语言变换函数 -flatMap    会把元素平铺   返回的是list<list<String>> 但我们的工程会写成 list<String>

fun main() {
    var lists= listOf("list1","list2","list3")
    val flatMap:List<String> = lists.flatMap {
        val listOf = listOf("哈哈$it")
        listOf
    }
    println(flatMap)

/*
map：遍历每一个元素

flatMap：遍历每一个元素，并铺平元素

var list =listOf(listOf(10,20),listOf(30,40),listOf(50,60))

var mapList = list.map{element->element.toString()}

var flatMapList = list.flatMap{element->element.asIterable()}

flatMap中的函数一定要返回一个Iterable，不然报错

结果：

[[10, 20], [30, 40], [50, 60]]

[10, 20, 30, 40, 50, 60]

 */
}