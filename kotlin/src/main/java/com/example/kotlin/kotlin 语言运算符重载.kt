package com.example.kotlin

//TODO kotlin 语言运算符重载  类与类的相加   重载符写时会自动提示  例如plus为 +    前面必须添加operator（操作符）
class AddClass(var number: Int, var number2: Int)

//数据类
data class AddClass2(var number: Int, var number2: Int) {
    operator fun plus(num: AddClass2): Int {
        return (number + num.number) + (number2 + num.number2)

    }
    // operator fun add. 会提示操作符+ — * 等等
}

fun main() {
    val i = AddClass2(1, 2) + AddClass2(1, 2)
    println(i)


}