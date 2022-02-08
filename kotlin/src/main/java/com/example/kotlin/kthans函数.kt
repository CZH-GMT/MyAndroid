package com.example.kotlin

//TODO  --------------函数头
fun main() {
   method("月华", 18)
}

//TODO -----函数默认都是public     kotlin函数 先有输入 再有输出

private fun method(name: String, age: Int): Int {
    print("你的年龄是${age}你的名字是${name}")
    return 200

}
