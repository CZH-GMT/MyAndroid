package com.example.kotlin.zhujie

//TODO kotlin @jvmstatic 注解  添加之后java可直接调用函数不需要kotlin.companion.xxx   直接kotlin.xxx

class ktbase44 {

    companion object {
        @JvmField  //针对成员变量使用
        val GOING = "黄石公园"

        @JvmStatic  //针对函数使用
        fun showAction(name: String) = println("$name 要去 $GOING 玩")
    }

}

fun main() {
    ktbase44.GOING
    ktbase44.showAction("李小龙")
}