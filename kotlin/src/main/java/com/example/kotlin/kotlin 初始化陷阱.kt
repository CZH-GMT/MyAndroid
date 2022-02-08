package com.example.kotlin

//TODO kotlin 初始化仙境
class KtBase9() {

    var nums = 9
    init {
        nums = nums.times(9)
    }



}

fun main() {
    val nums = KtBase9().nums
    println(nums)

}