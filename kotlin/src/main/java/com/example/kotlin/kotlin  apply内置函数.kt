package com.example.kotlin

import java.io.File

//TODO  kotlin apply内置函数  this代表xxx.apply (this代表xxx本身) 返回xxx本身
fun main() {
    val name = "How are you!"
    //普通方式
    print("字符串长度为: ${name.length} ")
    print("最后一个字符是：${name[name.length - 1]}")
    print("全部转换成小写：${name.toLowerCase()}")

    //TODO apply的使用  其中的含有this代表着  name对象
    name.apply {
        print(this)
        print("\n字符串长度为: ${length} ")
        print("最后一个字符是：${this[length - 1]}")
        print("全部转换成小写：${toLowerCase()}")

    }

//链式调用
    name.apply {
        print("\n字符串的长度为：${length}")
    }.apply {
        print("最后一个字符是：${this[length - 1]}")
    }.apply {
        print("全部转换成小写：${toLowerCase()}")
    }


    //TODO 普通写法
    val file = File("C:\\Users\\chenciling\\Desktop\\mvpmvvmmvc.txt")
    file.setExecutable(true)
    file.setReadable(true)
    print("文件为：\n${file.readLines()}")
    print(file.readBytes())

    //TODO apply  this代表着file本身对象
    file.apply {
        setExecutable(true)
    }.apply {
        setReadable(true)
    }.apply {
        print(readLines())
    }.apply {
        print(readBytes())
    }


}