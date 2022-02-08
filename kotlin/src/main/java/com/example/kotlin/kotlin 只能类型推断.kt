package com.example.kotlin

import java.security.spec.PSSParameterSpec

//TODO kotlin 语言类型智能类型转换
open class Prent3(val prentname: String) {
    public fun showname() = "父类的名字是$prentname"

    open fun myprintln() {
        println(showname())
    }

    fun methodPerson() = println("我是父类的方法")


}

class Student3(val studentname: String) : Prent3(studentname) {
    private fun studentname() = "子类的名字是$studentname"
    override fun myprintln() {
        println(studentname())
    }

    fun methodStudent() = println("我是子类的方法")
}

fun main() {
    val p3: Prent3 = Student3("哈哈")
    //TODO 若不写  不转换 则调用不了
    (p3 as Student3).methodStudent()
    p3.methodStudent()
    p3.methodStudent()
    p3.methodStudent()

//TODO  智能类型转换 使用as 转换后 会自动变为你转换之后的类型并记录  后面不需要再次转换
}
