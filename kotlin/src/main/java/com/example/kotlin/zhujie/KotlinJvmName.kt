@file:JvmName("kotlinjvmnames")  //在编译器环节修改我们的名字  必须写在包的外面

package com.example.kotlin.zhujie

import kotlin.jvm.JvmName

//TODO kotlin @jvmname注解  添加之后会更改类名在别的地方调用需要修改
fun getStudentNameValue(str: String) = println(str)

fun main() {

}