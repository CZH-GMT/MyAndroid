package com.example.kotlin

//TODO   ==（java equals） 与 ===（引用类型的比较）
fun main() {
    val name = "Qqq"
    val name2 = "Qqq"
    val name3 = "www"

    print(name.equals(name2))
    //比较内容是否相同
    print(name == name2) //true


    //比较引用类型
    print(name === name2)  //敞亮池有代理  若有相同的直接会引用
    print(name === name3)//false


    var name4 = "qqq"
    name4 = name4.capitalize()//name4=Qqq  虽然看着相同  但实则引用不一样
    print(name4 === name)

}