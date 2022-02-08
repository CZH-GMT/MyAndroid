package com.example.kotlin
//TODO----const修饰成员变量，，不能修饰局部变量
const val name2:String=""
fun main() {
    //TODO var--可变      val--不可变
    //TODO kotlin数据类型   String、Double、Int、Boolean、Float、---------数据类型都是引用类型，实则编译之后会修改成基本数据类型
    var name:String="hh"
    val name1:String="hh"
    print(name+name1)

}
