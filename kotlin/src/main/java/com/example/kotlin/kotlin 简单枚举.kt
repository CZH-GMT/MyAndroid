package com.example.kotlin

//TODO  kotlin 枚举
enum class Week {
    星期一,
    星期二,
    星期三,
    星期四,
    星期五,
    星期六,
    星期日,


}


fun main() {

    println(Week.星期一)
    println(Week.星期五)

    //枚举的值 等于 枚举本身
    println(Week.星期六 is Week)

}