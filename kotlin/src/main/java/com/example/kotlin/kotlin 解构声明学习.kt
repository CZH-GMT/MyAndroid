package com.example.kotlin

//TODO kotlin 解构声明学习   必须得写 fun component1=.....才能达成解构
class KtBase22(var name: String, var age: Int, var sex: String) {
    operator fun component1() = name
    operator fun component2() = age
    operator fun component3() = sex

}

data class KtBase22data(var name: String, var age: Int, var sex: String)


fun main() {
    //TODO 普通类
    val (name, age, sex) = KtBase22("hah", 33, "nan")
    println("普通类 name:$name,age:$age,sex:$sex")
    val (name1, age1, sex1) = KtBase22data("hah", 33, "nan")
    println("数据类 name:$name1,age:$age1,sex:$sex1")
    val (_, age2, sex2) = KtBase22data("hah", 33, "nan")
    println("拒收 name:,age:$age2,sex:$sex2")

}