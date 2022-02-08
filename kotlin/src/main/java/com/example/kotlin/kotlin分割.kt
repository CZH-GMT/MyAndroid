package com.example.kotlin

//TODO  kt split分割
fun main() {

    val name2: String = "喜羊羊.美羊羊.懒洋洋.沸羊羊"

    val list = name2.split(".")

    print(list[2])
    //不解构
    print(list)

    //解构
    val (v1, v2, v3, v4) = list
    print("$v1 $v2 $v3 $v4")

//    for (s in list) {
//        print(s)
//    }
}
