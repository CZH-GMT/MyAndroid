package com.example.kotlin

//TODO kotlin 进阶枚举学习 语言的枚举函数学习
//第一步
enum class Bodys(var information: Information) {
    RIGHT_HAND(Information("右手", 10)),
    LEFT_HAND(Information("左手", 20)),
    RIGHT_FOOT(Information("右脚", 30)),
    LEFT_FOOT(Information("左脚", 40));

    //这时候在定义普通的枚举值就报错了，必须所有的枚举值保持一致
    //主构造参数必须和枚举参数保持一致
    fun shows(): String {
        return "四肢的名字叫：${information.bodyname}长度是：${information.bodylength}"

    }

    fun updata(information: Information) {
        println("更新前的数据为${this.information}")
        this.information.bodylength = information.bodylength
        this.information.bodyname = information.bodyname
        println("更新后的数据为${this.information}")

    }
}

//第二步创建四肢信息class
data class Information(var bodyname: String, var bodylength: Int) {
//    fun show() {
//        println("肢体的名字叫:$bodyname 他的长度为:$bodylength")
//    }
}


fun main() {
    //显示枚举
    // println(Bodys().show())不能这么用
    //正确
    //一般的用法
    println(Bodys.LEFT_FOOT.shows())
    println(Bodys.RIGHT_FOOT.shows())
    println(Bodys.RIGHT_HAND.shows())
    println(Bodys.LEFT_HAND.shows())

    println()

    println(Bodys.LEFT_HAND.updata(Information("没有手",8888)))


}