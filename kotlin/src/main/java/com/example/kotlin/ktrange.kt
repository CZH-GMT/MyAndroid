package com.example.kotlin

//TODO------ range表达式       range（范围  从哪里。。到。。哪里）
fun main() {
    val number=148
    if (number in 10..59){
        print("不及格")
    }else if(number in 60..100){
        print("及格")
    }else if(number in 100..150){
        print("优秀")
    }




}
