package com.example.kotlin

import java.io.File

//TODO  kotlin 类型转换
open class Prent2(val prentname: String) {
    public fun showname() = "父类的名字是$prentname"

    open fun myprintln() {
        println(showname())
    }


}

class Student2(val studentname: String) : Prent2(studentname) {
    private fun studentname() = "子类的名字是$studentname"
    override fun myprintln() {
        println(studentname())
    }
}

fun main() {
    val p2: Prent2 = Student2("学生")
    p2.myprintln()
    //prent2()是否是p2
    println(p2 is Prent2)
    //Student2()是否是p2
    println(p2 is Student2)
    println(p2 is File)

    //TODO is+as  as(转换类型)
    if (p2 is Student2){
        (p2 as Student2).myprintln()
    }
    if (p2 is Prent2){
        (p2 as Prent2).myprintln()  //TODO 子类重写了所以输出的是子类
        println((p2 as Prent2).showname())
    }
}