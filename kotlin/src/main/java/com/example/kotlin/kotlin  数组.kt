package com.example.kotlin

import java.io.File

//TODO  kotlin数组
/*
    IntArray        IntArrayOf
    DoubleArray     DoubleArrayOf
    LongArray       LongArrayOf
    ShortArray      ShortArrayOf
    byteArray       byteArrayOf
    FloatArray      FloatArrayOf
    BooleanArray    BooleanArrayOf
    Array           ArrayOf

 */
/**
 * 1.intArrayOf 常规操作的越界崩溃
 * 2.elementAtOrElse  elementAtNull    防止越界
 * 3.list集合转数组
 * 4.arrayOf Array<File>
 */
fun main() {

    val array: IntArray = intArrayOf(1, 2, 3, 4, 5, 6)
    println(array[0])
    println(array[1])
    println(array[2])
    println(array[3])
    println(array[4])


    //防止越界
    println(array.elementAtOrElse(10000) { -1 })

    println(array.elementAtOrNull(10000))
    //结合空合并操作符
    println(array.elementAtOrNull(10000) ?: "没有这个值")


    //TODO 集合转数组

    val tochar = listOf('q', 'w', 'e', 'r').toCharArray()
    println(tochar)


    //Array  对象

    val obj= arrayOf(File("qq"), File("eee"))
    println(obj)

}