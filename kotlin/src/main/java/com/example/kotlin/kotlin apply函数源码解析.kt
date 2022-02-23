package com.example.kotlin

//TODO kotlin apply函数解析

//apply函数
//private私有化
//inline 内联函数 因为我们的函数中有lambda表达式 加上inline可以提高性能
//fun<A> 在函数中申明泛型 A指的是所有类型
//A.mapplyt对A进行函数扩展意味着  所有类型 万能类型都可以使用 xxx.mapply
//A.lambda: (T) -> Q)   A.lambda让我们的匿名函数里持有this ，在lambda中不需要返回值，因为永远返回A本身
//Q 会根据用户的返回类型变化而变化
//this ==A函数本身
private inline fun <A> A.mapply(lambda: A.() -> Unit): A {
    lambda()
    return this
}


fun main() {
    val mapply = "sds".mapply {

    }

}