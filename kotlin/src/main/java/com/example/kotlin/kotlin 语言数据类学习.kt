package com.example.kotlin

//TODO kotlin 数据类学习
//普通类和数据类背后toString原理
//前面学过== 和 ===
//普通类==背后原理
//数据类==背后原理
//TODO 普通类
class ResponseBean1(var names: String, var ages: Int, var sex: String) : Any()

//普通类默认会生成 get() set() 方法
//TODO 数据类 就是添加了在类的前面添加 data 关键字
data class ResponseBean2(var names: String, var ages: Int, var sex: String)

//数据类会生成get() set() 构造函数 hashcode toString equals copy
fun main() {

//    val(v1,v2,v3)= list 这个list集合之前的 解构操作
    //TODO 普通类
    println(ResponseBean1("哈哈", 2, "男")) //会打印出 com.example.kotlin.ResponseBean1@5cad8086 TODO 因为我们的类在创造的时候会默认继承any（）类
    //TODO any（）类中有tostring的方法 但并不是实现tostring所以打印出此东西


    //TODO 数据类
    println(ResponseBean2("哈哈", 2, "男"))//打印出ResponseBean2(names=哈哈, ages=2, sex=男)//TODO 因为我们的数据类会比普通类额外多生成许多方法
    //TODO 里面就含有tostring  是实现的toString 所以会打印出真实数据


    //TODO 普通类 == 比较
    //TODO == 比较的是值的比较 相当于java中的equals   ===比较的是引用 对象比较
    //TODO 按道理来说里面传递的数据都相同 应该是 true  然而为false并不是这样  why？ 因为any父类equals 比较的是对象的引用  即：ResponseBean1()对象引用 比较 ResponseBean1()对象引用
    println(ResponseBean1("哈哈", 2, "男") == ResponseBean1("哈哈", 2, "男"))


    //TODO 数据类 == 比较
    println(ResponseBean2("哈哈", 2, "男") == ResponseBean2("哈哈", 2, "男"))
    //TODO 结果为 true 虽然类都会继承any类但data类中会重写 equals 方法并进行值的比较 因为值都相同所以为true
}