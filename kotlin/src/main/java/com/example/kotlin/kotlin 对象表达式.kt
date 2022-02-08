package com.example.kotlin

//TODO kotlin 对象表达式
//1. add del println
//2. 匿名对象表达方式
//3. 具名实现方式
//4.对java接口的 用对象表达方式、、

interface Callbacks{
    fun run()
}

open class KtBased() {
    open fun add(info: String) = println("ktabse add: $info")
    open fun del(info: String) = println("ktbase del: $info")
}

fun main() {
//TODO 匿名表达式
    val p: KtBased = object : KtBased() {
        override fun add(info: String) {
            // super.add(info)  添加这个走父类的打印
            println("我是匿名对象 add:$info")
        }

        override fun del(info: String) {
            // super.del(info)
            println("我是匿名对象 del:$info")
        }

    }
    p.add("华哥")
    p.del("thank")

    //TODO 具名表达式  第二步
    var j = ktjuming()
    j.add("具名add")
    j.add("具名del")


    //TODO 对java接口的 用对象表达方式、   KT【对象表达式】  方式一
    val value = object : Runnable {
        override fun run() {
            println("Runnable  run --------")
        }
    }
    value.run()

    //TODO 对java的接口 用     java最简洁的方式   方式二
    val runnable: Runnable = Runnable {
        println("Runnable  Run2   -------")
    }
    runnable.run()

    //TODO 对kt手写接口 用对象表达式
    object :Callbacks{
        override fun run() {

            println("kt手写接口对象表达式实现")
        }

    }
    //TODO 对kotlin 接口  简介方式
//    Callbacks{    报错只能使用上述
//
//    }

    //总结Java接口有两种方式    Kotlin 中只能使用（object:对象表达式）
}

//TODO 具名表达式  第一步
class ktjuming : KtBased() {
    override fun add(info: String) {
        // super.add(info)
        println("我是具名对象 add:$info")
    }

    override fun del(info: String) {
        //  super.del(info)
        println("我是具名对象 add:$info")
    }
}