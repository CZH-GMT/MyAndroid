package com.example.kotlin

import android.text.InputType

//TODO kotlin泛型类约束
open class MyAnyClass(name: String)//祖宗类
open class PersonClass(name: String) : MyAnyClass(name)//父类

class StudentClass(name: String) : PersonClass(name)//子类
class TeacherClass(name: String) : PersonClass(name)//子类
class QiTaClass(name: String) //其他类

//TODO 给泛型T添加限定  T:PersonClass  添加限定之后就只有限定类和他的子类可以使用
class KtBase27<T : PersonClass>(private var inputType: T, var isok: Boolean = true) {
    fun getobj() = inputType.takeIf { isok }
}

fun main() {
    val myAnyClass = MyAnyClass("MyAnyClass")//祖宗类
    val personClass = PersonClass("PersonClass")//父类
    val studentClass = StudentClass("StudentClass")//子类
    val teacherClass = TeacherClass("TeacherClass")//子类
    val qiTaClass = QiTaClass("QiTaClass") //其他类

//    val myAnyClass1 = KtBase27(myAnyClass).getobj()
    val personClass1 = KtBase27(personClass).getobj()
    val studentClass1 = KtBase27(studentClass).getobj()
    val teacherClass1 = KtBase27(teacherClass).getobj()
//    val qiTaClass1 = KtBase27(qiTaClass).getobj()

//    println(myAnyClass1)
    println(personClass1)
    println(studentClass1)
    println(teacherClass1)
//    println(qiTaClass1)


}