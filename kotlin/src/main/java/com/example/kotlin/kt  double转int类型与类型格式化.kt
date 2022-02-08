package com.example.kotlin

import kotlin.math.roundToInt

//TODO  kotlin double转int与类型格式化
fun main() {
    print(23.33333.toInt())//非四舍五入 小数点后面的全部取消
    print(23.33333.roundToInt())//四舍五入
    print(23.43333.roundToInt())//四舍五入

    //r的类型为String类型  %.3f  保留三个小数点
    val r = "%.3f".format(23.43333)
    print("            r:$r")
}