package com.example.kotlin

fun main() {


    //TODO 函数参数
    val name: (String, Int) -> String = { name, num ->
        "name :  $name  num : $num "
    }
    print(name("华哥", 100))
    print("\n----------------------------------------------------")


//TODO   函数it  当参数类型和返回值只有一种类型的时候  it指其内容
    val method: (String) -> String = {
        "$it  huage"
    }
    print(method("\nnb"))
    print("\n----------------------------------------------------")


    //TODO  kotlin语言匿名函数的类型推断
    //TODO 方法名  以 “ ：”  必须指定 参数类型 和 返回类型
    //TODO 结构  方法名 = 类型推断返回值
    val method2: () -> String = { "" }
    //TODO 相当于省略中间这部分    : () ->String   变成  val method2 ={ 参数：类型，参数：类型   ->   返回值     }
    //TODO    lambda 表达式
    val method3 = { a: Int, b: Int -> "\n$a  $b" }
    print(method3(2, 3))
    //TODO  无参数类型
    val method4 = {
        "hugenb"
    }
    print(method4())


    print("\n----------------------------------------------------")


}