package com.example.kotlin

//TODO kotlin 泛型定义
class FanXingBean<T>(var str: T) {
    fun show() = println("万能输出器$str")

}

data class Students(var name: String, var age: Int, var sex: Char)
data class Teachers(var name: String, var age: Int, var sex: Char)

fun main() {
    val students = Students("张三", 22, '男')
    val students1 = Students("张丽丽", 18, '女')

    val Teachers = Teachers("张三", 22, '男')
    val Teachers1 = Teachers("张丽丽", 18, '女')


    FanXingBean(students).show()
    FanXingBean(students1).show()

    FanXingBean(Teachers).show()
    FanXingBean(Teachers1).show()

    FanXingBean(String("123".toByteArray())).show()
    FanXingBean("gggggggggggggh").show()
}