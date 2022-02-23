package com.example.kotlin

//TODO kotlin let函数手写与函数扩展   语言扩展属性
fun main() {
    val mlet = "sdsd".mlet { str ->


    }
    val mlet1 = 32323.mlet {
        89898
    }

    val mlet2 = true.mlet {
        32.3
    }
    println(mlet2)

    val also = 434.also {
        434
    }
    val sss = "1111"
    val malso = sss.malso {
        val str = sss + "3232"
        println(str)
    }
    println(malso)

    val also1 = "EWEW".also {
        val s = it + "3423"
    }
    println(also1)
}

//let函数
//private私有化
//inline 内联函数 因为我们的函数中有lambda表达式 加上inline可以提高性能
//fun<T,Q> 在函数中申明两个泛型，T 是输入 Q是输出
//T.mlet对T进行函数扩展意味着  所有类型 万能类型都可以使用 xxx.mlet
//lambda: (T) -> Q)  (T 输入)->Q输出
//Q 会根据用户的返回类型变化而变化
//this ==T函数本身
private inline fun <T, Q> T.mlet(lambda: (T) -> Q): Q {
    val lambda1 = lambda(this)
    return lambda1

}

//also函数  返回本身
fun <B> B.malso(lambda: (B) -> Unit): B {
    val lambda1 = lambda(this)
    return this
}