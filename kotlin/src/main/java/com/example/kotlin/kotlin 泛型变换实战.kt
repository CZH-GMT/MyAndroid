package com.example.kotlin

//TODO kotlin 泛型变换实战
/*
   1.类 isMap map takeIf map是什么类型
   2.map int - > str 最终接收的是什么类型
   3.map per - > stu 最终接收的是什么类型
   4.验证是否是此类型 与 null
 */
//1.类 isMap map takeIf map是什么类型
class KtBase26<T>(val isMap: Boolean = false, val inputtype: T) {
    //模仿RXjava  T是传入的类型  R是变换后转换后的类型
    fun <R> map(mapaction: (T) -> R): R? = mapaction(inputtype).takeIf { isMap }


}

//改变之后
inline fun <I, O> map1(inputtypes: I, isMap: Boolean = true, mapactionlanbda: (I) -> O) =
        if (isMap) mapactionlanbda(inputtypes) else null

fun main() {
    // 2.map int - > str 最终接收的是什么类型
    val p1 = KtBase26(false, 3333)
    var r: String? = p1.map {
        it
        it.toString()
    }
    // 4.验证是否是此类型 与 null
    println(r is String)
    println(r is String?)
    println(r)
    println(r ?: "空的草泥马")

    val maps = KtBase26(true, student(22, "华哥")).map {
        it.age
        student(it.age, it.name)
    }
    println(maps)

    //改变之后
    var map1s: String? = map1(123) {
        it.toString()
        "map1包裹【$it】"
    }
    println(map1s)

}

data class student(var age: Int, var name: String)