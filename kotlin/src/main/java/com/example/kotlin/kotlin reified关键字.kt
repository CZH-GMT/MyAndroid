package com.example.kotlin

import android.app.backup.BackupAgent

//TODO reified关键字
data class ObjectClass1(var name: String, var age: Int, var study: String)
data class ObjectClass2(var name: String, var age: Int, var study: String)
data class ObjectClass3(var name: String, var age: Int, var study: String)

//需求：随机产生的泛型类型和用户输入的泛型是否相同，不相同则返回用户传入的泛型类型
class KtBase34() {
    //TODO 添加reified  前面得添加inline 添加后就可以就可以   if (first is T)  否则T下面报红
    inline fun <reified T> RandomObject(YongHuShuRu: () -> T): T {
        val listOf = listOf(ObjectClass1("张三", 11, "张三的学校"), ObjectClass2("李四", 22, "李四的学校"), ObjectClass3("王五", 33, "王五的学校"))
        val first = listOf.shuffled().first()
        println("随机生成的泛型对象为$first")
        if (first is T) {
            return first
        } else {
            return YongHuShuRu()
        }
//        return first.takeIf { first is T } as T? ?: YongHuShuRu()
    }

}


fun main() {
    KtBase34().RandomObject<ObjectClass2> {
        println("用户输入的是${ObjectClass2("李四", 22, "李四的学校")}")
        ObjectClass2("李四", 22, "李四的学校")
    }

}