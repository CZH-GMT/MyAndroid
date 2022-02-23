package com.example.kotlin

//TODO kotlin 语言的过滤函数
fun main() {
    val listOf = listOf(listOf("哈哈1", "哈哈2", "哈哈3"), listOf("呵呵1", "呵呵2", "呵呵3"), listOf("笑你妈1", "笑你妈2", "笑你妈3"))
    //filter
    val filter = listOf.filter {
        true
    }
    println(filter)
    //map
    listOf.map {
        println(it)
    }

    println()

    //flatMap
    val flatMap = listOf.flatMap {
        listOf(it)

    }
    println(flatMap)


    println()

    //map+filter
    val map = listOf.map {
//        println(it)
        it ->
        it.filter {
            true
        }
    }
    println(map)

    println()

    //flatMap+filter
    val map1 = listOf.flatMap {
//        println(it)
        it ->
        it.filter {
            true
        }
    }
    println(map1)

    println()

//filter+flatMap + 过滤需要的
    val flatMap1 = listOf.flatMap { it ->
        it.filter {
            it.contains("哈哈")
        }

    }
    println(flatMap1)
}
/* //TODO 题目 val listOf = listOf(listOf("哈哈1", "哈哈2", "哈哈3"), listOf("呵呵1", "呵呵2", "呵呵3"), listOf("笑你妈1", "笑你妈2", "笑你妈3"))
map
[哈哈1, 哈哈2, 哈哈3]
[呵呵1, 呵呵2, 呵呵3]
[笑你妈1, 笑你妈2, 笑你妈3]

flatMap
[[哈哈1, 哈哈2, 哈哈3], [呵呵1, 呵呵2, 呵呵3], [笑你妈1, 笑你妈2, 笑你妈3]]

map+filter
[[哈哈1, 哈哈2, 哈哈3], [呵呵1, 呵呵2, 呵呵3], [笑你妈1, 笑你妈2, 笑你妈3]]

flatMap+filter
[哈哈1, 哈哈2, 哈哈3, 呵呵1, 呵呵2, 呵呵3, 笑你妈1, 笑你妈2, 笑你妈3]

flatMap+filter+过滤
[哈哈1, 哈哈2, 哈哈3]

 */