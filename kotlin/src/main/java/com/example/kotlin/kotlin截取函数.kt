package com.example.kotlin
//TODO 截取函数  substring

const val USER_STRING="huluwa"
fun main() {

    val indexOf = USER_STRING.indexOf("l")
    val substring: String = USER_STRING.substring(0, indexOf)
    print(substring)


    print(USER_STRING.substring(0 until 3))  //until从0.。。。到。。。



}