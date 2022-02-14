package com.example.kotlin

//TODO kotlin 代数数据类型   使用when(){}这个时候没有else因为是用枚举类进行判断 这个就属于代数数据类型，就不需要写else了
enum class KtBase23() {
    FENSHU1,//分数差
    FENSHU2,//分数及格
    FENSHU3,//分数良好
    FENSHU4;//分数优秀

    //需求 得到孩子姓名
    var studentname = null
}

class Teacher(var fenShu: KtBase23) {
    fun show() =
            when (fenShu) {
                KtBase23.FENSHU1 -> "分数差"
                KtBase23.FENSHU2 -> "分数及格"
                KtBase23.FENSHU3 -> "分数良好"
                KtBase23.FENSHU4 -> "分数优秀"
                //这个时候没有else因为是用枚举类进行判断 这个就属于代数数据类型，就不需要写else了
                //因为when表达式已经非常明确了只有四种类型，再不会有其他else类型，所以不用写

            }

}

fun main() {
    //使用

    println(Teacher(KtBase23.FENSHU1).show())
    println(Teacher(KtBase23.FENSHU4).show())


}