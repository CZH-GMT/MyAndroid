package com.example.kotlin
//TODO 想要继承必须用open来打开
//TODO kotlin语言继承重载 open关键字
//TODO 所有的”类“和”函数“ 都是final修饰的 不能继承  和java相反  默认public final修饰
//open可以移除final
open class Prent(var names: String) {
    fun showname() = "父类的名字为$names"

   open fun myPrintln() = println(showname())

}


class Student(var studentName: String) : Prent(studentName) {
    fun studentname() = "子类的名字为${studentName}"
    override fun myPrintln() = println(studentname())
}


fun main() {
    val p:Prent=Student("学生")
    p.myPrintln()

}