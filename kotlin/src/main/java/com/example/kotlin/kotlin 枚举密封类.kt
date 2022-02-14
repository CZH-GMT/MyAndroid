package com.example.kotlin

//TODO kotlin 密封类(sealed)  我们的的成员就必须有类型 并且(继承本类)  若没有参数通常用object来修饰  有参数就用class来形容  用when表达式前面添加is
sealed class KtBase24() {
    //object是单例
    object FENSHU1 : KtBase24()//分数差
    object FENSHU2 : KtBase24()//分数及格
    object FENSHU3 : KtBase24()//分数良好

    //这里不可以写成object 是因为对象不是单例 有对象王五  有对象张三
    class FENSHU4(var studentName: String) : KtBase24()//分数优秀

    //需求 得到孩子姓名
//    var studentname = null
}

class Teacher1(var fenShu1: KtBase24) {
    fun show1() =
            when (fenShu1) {
                is KtBase24.FENSHU1 -> "分数差"   //TODO 使用的时候前面添加 is
                is KtBase24.FENSHU2 -> "分数及格"
                is KtBase24.FENSHU3 -> "分数良好"
                is KtBase24.FENSHU4 -> "分数优秀 学生姓名为：${(this.fenShu1 as KtBase24.FENSHU4).studentName}"
                //这个时候没有else因为是用枚举类进行判断 这个就属于代数数据类型，就不需要写else了
                //因为when表达式已经非常明确了只有四种类型，再不会有其他else类型，所以不用写

            }

}

fun main() {
    //使用

    println(Teacher1(KtBase24.FENSHU1).show1())
    println(Teacher1(KtBase24.FENSHU4("张三")).show1())


}