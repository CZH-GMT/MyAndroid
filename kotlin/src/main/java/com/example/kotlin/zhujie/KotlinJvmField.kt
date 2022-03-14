package com.example.kotlin.zhujie

//TODO kotlin注解@Jvmfield  使用滞后调用就不是getlist1  变成了直接这里写什么java调用什么
class KotlinJvmField {
    @JvmField
    val list1 = listOf("张三", "李四", "王五")

}

fun main() {


}