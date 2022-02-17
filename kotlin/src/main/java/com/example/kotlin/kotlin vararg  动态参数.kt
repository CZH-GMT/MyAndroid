package com.example.kotlin

//TODO kotlin 动态参数 关键字（vararg）
/*
   1.objArray:Array<T>
   2.showObj(index)
   3.mapObj(index,变换lambda)
   4.p.showObj  p.mapObj(int -> str)
   5.P的类型  it的类型
 */
class KtBase29<T>(vararg var objects: T, var ismap: Boolean) {
    //添加out 讲的是只读不取  不添加报错
    // 1.objArray:Array<T>
    var objectArrays: Array<out T> = objects

    fun showObj(): Array<out T>? = objectArrays.takeIf { ismap }

    //2.showObj(index)
    fun showObjIndex(index: Int): Any? = objectArrays[index].takeIf { ismap } ?: "空的操你妈"

    //3.mapObj(index,变换lambda)
    fun <O> mapObj(index: Int, mapAction: (T?) -> O?) = mapAction(objectArrays[index].takeIf { ismap })
}

fun main() {
    val p: KtBase29<Any?> = KtBase29(111, "huage", 3832.67, '男', null, ismap = true)
//    println(p.showObj())
    println(p.showObjIndex(0))
    println(p.showObjIndex(1))
    println(p.showObjIndex(2))
    println(p.showObjIndex(3))
    println(p.showObjIndex(4))

    println()

    val mapObj = p.mapObj(2) {
        it.toString()
    }
    println(mapObj)
}