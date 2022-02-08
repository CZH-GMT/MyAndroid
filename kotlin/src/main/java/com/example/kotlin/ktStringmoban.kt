package com.example.kotlin

import java.util.*

//TODO ------------kotlin String字符串模板--------${}来拼接
fun main() {
    val garden = "黄山公园"
    val time = 6

    print("今天去了${garden}玩了${time}个小时")

    var isBoolean=false
    var hh = 1



//    if (isBoolean)
//        isBoolean = false
//
//    else if (!isBoolean)
//
//        isBoolean = true
//    print(isBoolean)



    print("${if (isBoolean) "登录成功" else "登陆失败"}")

}