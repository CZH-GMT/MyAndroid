package com.example.kotlin

//TODO  kotlin 伴生对象 -----》关键字 companion  相当于java的static
//总结
//TODO   无论  KtBaseb()对象构建多少次我们的伴生对象只加载一次
//TODO   无论  KtBaseb()。showsss()调用多少次我们的伴生对象只加载一次
//TODO   伴生对象只会初始化一次
class KtBaseb {
    //伴生对象
    companion object {
        var sss: String = "华哥最最帅"
        fun showsss() = println("showsss:$sss")
    }
}

//TODO   无论  KtBaseb()对象构建多少次我们的伴生对象只加载一次
//TODO   无论  KtBaseb()。showsss()调用多少次我们的伴生对象只加载一次
//TODO   伴生对象只会初始化一次
fun main() {
    //后面其实做了 KtBaseb.companion.sss
    println(KtBaseb.sss)
    //后面其实做了 KtBaseb.companion.showsss( )
    KtBaseb.showsss()

    //   无论  KtBaseb()对象构建多少次我们的伴生对象只加载一次
    KtBaseb()
    KtBaseb()
    KtBaseb()
    KtBaseb()
    KtBaseb()
//
}