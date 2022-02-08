package com.example.kotlin

import android.os.Build
import androidx.annotation.RequiresApi

//TODO   Map创建  键值对
@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    //第一种方式  mapOf("map" to (33), "map1" to (44))
    val map = mapOf("map" to (33), "map1" to (44))
    println("第一种$map")

    //第二种方式   mapOf(Pair("qq", 22), Pair("ww", 88))
    val map1 = mapOf(Pair("qq", 22), Pair("ww", 88))
    println("第二种$map1")


    //TODO  Map读取Map的值
    val map3 = mapOf("map" to (33), "map1" to (44))
    println("----------------------- Map读取Map的值")
    println(map3["map"])   //==>等价于  map.get()  没有则返回null
    //第一种没有返回null
    println(map3["xxx"])  //返回null
    //第二种 getOrDefault("xxx",-1)
    println(map3.getOrDefault("xxx", -1))
    //第三种 geOrElse("xxx){}

    println(map3.getOrElse("xxx") { "空" })

    //方法四不建议使用
    // println(map3.getValue("xxx"))    //崩溃


    //TODO Map  遍历
    println("----------------------- Map  遍历")
    val maps = mapOf(Pair("aa", 1), Pair("bb", 2), Pair("cc", 3), Pair("dd", 4), Pair("ee", 5))

    //遍历  for
    for (map: Map.Entry<String, Int> in maps) {  //(map: Map.Entry<String, Int> in maps)  TODO  map后面默认有map.Entry<类型，类型>
        println("for $map")
    }
    //forEach
    maps.forEach {     //s-> 可以覆盖掉it
        it//代表整个元素
        println("forEach  $it")
    }
    // 参数
    maps.forEach { k, v ->  //波浪线代表key 和 value  实在一起的不分开的(k,v)->
        println("key$k value$v")

    }
    //修改波浪线
    maps.forEach { (k, v) ->
        println("修改波浪线 key:$k value:$v")
    }


    //TODO 可变Map   mutMap += Pair("22", 88) 1.getOrPut("xxx "){"xxx"}
    //    mutMap += ("dd" to (33))
    //    mutMap -= "aa"`
    println("----------------------- 可变Map   mutMap += Pair(\"22\", 88) 1.getOrPut(\"xxx \"){\"xxx\"}")

    val mutMap = mutableMapOf(Pair("aa", 1), Pair("bb", 2), Pair("cc", 3), Pair("dd", 4), Pair("ee", 5))
    mutMap += Pair("22", 88)
    mutMap += ("dd" to (33))
    mutMap -= "aa"
    println(mutMap)

    //1.getOrPut("xxx "){"xxx"}   取不到参数 先将参数添加进去在取出来
    mutMap.getOrPut("sss"){6666666}
    println(mutMap["sss"])
    //2.getOrPut("xxx "){"xxx"}   若有参数 直接见参数取出来
    mutMap.getOrPut("bb"){888}
    println(mutMap.getOrPut("bb"){888})


}