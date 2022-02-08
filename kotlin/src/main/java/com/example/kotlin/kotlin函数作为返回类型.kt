package com.example.kotlin

//TODO  函数作为返回类型
fun main() {

    val methodddd = methodddd("", 22)
    print(methodddd("wwwwwwwwwwwwwwwwwww", 22))
}


fun methodddd(name: String, age: Int): (String, Int) -> String {

    return { name, age -> "姓名是$name  --年龄是$age" }
}