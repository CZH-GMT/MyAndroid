package com.example.kotlin

//TODO kotlin 主构造函数的学习
//TODO 参数不能使用   只是临时的  必须将其赋给修饰后的参数
class KtBase(_name: String, _age: Int, _sex: Char) {
    var name = _name
        get() = field  //TODO field指的是name   value指的是所赋的值  相当于 public void set（String 参数）{ this.name=参数//TODO }
        set(value) {  //TODO
            field = value
        }
    var age = _age
        get() = if (field < 0) -1 else field

}


fun main() {
    val ktBase = KtBase(_name = "陈智华", _age = 18, _sex = '男')
    println(ktBase.name)
    println(ktBase.age)


}