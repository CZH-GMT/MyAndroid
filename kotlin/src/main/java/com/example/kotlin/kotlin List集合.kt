package com.example.kotlin

import android.os.Build
import androidx.annotation.RequiresApi

//TODO  kotlin list 集合
@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    println("--------------------------  防止下标越界  getOrElse(){}  getOrNull")
    //普通集合    通过索引取值
    val list = listOf(1, 2, 3, 4, 5)
    println(list[0])
    println(list[1])
    println(list[2])
    println(list[3])

    //防止下标越界  getOrElse(){}  getOrNull
    println(list.getOrElse(6) { "越界" })
    println(list.getOrNull(7) ?: "越界了")

    //TODO  kotlin 可变List ---------------------> mutableListOf 可变集合
    println("--------------------------  mutableListOf 可变集合")

    val lists = mutableListOf("喜羊羊", "美羊羊", "懒洋洋", "沸羊羊", "猪八戒")
    lists.add("慢羊羊")
    lists.remove("猪八戒")
    println(lists)

    /**
     * 集合转变  list普通集合转换为可变集合
     */
    //TODO  集合转变  list普通集合转换为可变集合
    println("-------------------------- list普通集合转换为可变集合")
    val listmutable = list.toMutableList()
    listmutable.add(888)
    listmutable.remove(1)
    println(listmutable)


    //可变集合
    val kebianlist: MutableList<String> = mutableListOf("老大", "老二", "老三", "老四")
    println(kebianlist)

    val nolist: List<String> = kebianlist.toList()
//    nolist.add()     不可以
//    nolist.remove()   不可以


    //TODO mutableList 特性   mutablelis+="huage"   mutablelis-="qqq"
    println("--------------------------mutableList 特性   mutablelis+=\"huage\"   mutablelis-=\"qqq\"")
    val mutablelis: MutableList<String> = mutableListOf("aqqq", "awww", "aeee", "rrr", "ttt")

    mutablelis += "huage"
    mutablelis -= "qqq"

    println(mutablelis)

    mutablelis.removeIf { it.contains("a") }
    println("删除之后$mutablelis")


    /**
     * list集合循环输出遍历
     */
    //TODO  list集合循环输出遍历
    println("--------------------------list集合循环输出遍历")
    /**
     * 第一种方式  for(i in list){}
     */
    for (mutableli in mutablelis) {
        println("元素为$mutableli")
    }
    /**
     * 第二种方式  foreach{  it }  表达式       mutablelis.forEach {
    println("foreach $it")
    }
     */
    mutablelis.forEach {// s->
        println("foreach $it")
//        println("foreach $s")
    }


    /**
     * 第三种方式  for(i in list){}
     */
    mutablelis.forEachIndexed { index, s ->
        println("下标为$index  内容为$s")

    }

    /**
     * list集合结构语法和过滤元素
     */
    //TODO list集合结构语法和过滤元素
    println("--------------------------list集合结构语法和过滤元素")
    val list1 = listOf("熊大", "熊二", "熊三", "熊四")

    //解构    可读不可写
    println("--------------------------可读不可写")
    val (v1, v2, v3, v4) = list1
    println("v1:$v1 v2:$v2 v3:$v3 v4:$v4")
    //不想要哪个元素可以用  _  来代替
    //可写
    println("--------------------------可写 s1=光头强")
    var (s1, s2, s3, s4) = list1
    s1 = "光头强"
    println("s1:$s1 s2:$s2 s3:$s3 s4:$s4")

    //TODO 过滤元素  ( _ )
    println("--------------------------过滤元素  ( _ ) 省略b1")
    val (_, b2, b3, b4) = list1
    println("b2:$b2 b3:$b3 b4:$b4")

    /**
     * set创建与元素获取   尽量使用  空合并
     */
    //TODO  set创建与元素获取   尽量使用  空合并
    println("--------------------------set创建与元素获取  元素不能重复")
    var set = setOf<Char>('我', '爱', '中', '国', '爱')
    println(set)
    //set获取元素  set没有[0] 这样的功能 只有list有
    println(set.elementAt(0))
    println(set.elementAt(1))
    println(set.elementAt(2))
    println(set.elementAt(3))

    //防止下标越界   elementAtOrElse(10000000){"越界了"}  elementOrNul(10000000)  若越界则返回null
    println("--------------------------防止下标越界   elementAtOrElse(10000000){\"越界了\"}  ")
    println(set.elementAtOrElse(0) { "没越界" })
    println(set.elementAtOrElse(1000) { "越界了" })

    println("-------------------------- elementOrNul(10000000)  若越界则返回null")
    // elementOrNul(10000000)  若越界则返回null
    println(set.elementAtOrNull(10000))

    // elementOrNul(10000000)  配合空合并操作符  ?:
    println(set.elementAtOrNull(2000000) ?: "配合空合并操作符越界了")


    //TODO  可变set集合
    println("-------------------------- 可变set集合")
    val mutableset = mutableSetOf<Int>(1000, 2000, 3000, 4000)
    println(mutableset)
    mutableset += 888
    mutableset -= 3000
    mutableset.add(777)
    mutableset.remove(4000)
    println(mutableset)


    /**
     * kotlin语言 set 和 list 之间的转换去重
     */
    println("-------------------------- set 和 list 之间的转换去重")
    //1.定义可变list集合
    //2.list转set去重
    //3.list 转 set 在转 list 也可以去重
    //4.快捷去重 distinct
    val mutlist: MutableList<String> = mutableListOf("哈哈", "哈哈", "嘻嘻", "呼呼", "呵呵")  //list可以重复元素
    println("list集合$mutlist")

    val toSet = mutlist.toSet()
    println("去重转换之后的集合$toSet")

    val toList = mutlist.toSet().toList()

    println("list.toset.tolist去重$toList")

    println("使用distinct来去重${mutlist.distinct()}")


}