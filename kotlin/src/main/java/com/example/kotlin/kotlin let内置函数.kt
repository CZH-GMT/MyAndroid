package com.example.kotlin

//TODO   let内置函数  let函数最后一行作为返回值     let的返回根据最后一行的变化而变化
/**
 * 普通方式对集合第一个元素进行相加
 * let对集合第一个元素进行相加
 * 普通对值判null并返回
 * let对值判null并返回
 */
fun main() {
    val list = listOf<Int>(3, 3, 3, 3, 3, 3, 3)
    print("集合第一个元素相加为：${list.first() + list.first()}")

    //it代表集合本身
    list.let {
        print("\n集合第一个元素相加为：${it.first() + it.first()}")
    }

    print(getMethod("哈哈"))

    print(methodLet("华哥"))

    print(getMethod1("哈哈"))

    print(methodLet2("华哥"))

}

//普通版本
fun getMethod(name: String?): String {
    return if (name == null) {
        "什么也没有"
    } else {
        "您输入的是$name"
    }
}

//普通方式简化版
fun getMethod1(name: String?) = if (name == null) "什么也没有" else "您输入的是$name"

//let函数普通版本   let+空合并操作符
fun methodLet(name: String?): String {
    return name?.let {
        "您输入的是$it"
    } ?: "什么也没有"
}

//let函数简化版本
fun methodLet2(name: String?) = name?.let { "您输入的是$it" } ?: "什么也没有"
