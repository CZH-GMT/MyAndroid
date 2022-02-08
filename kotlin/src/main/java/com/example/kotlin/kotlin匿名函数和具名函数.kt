package com.example.kotlin

//TODO  kotlin 匿名函数和具名函数（具体有名字的函数）
fun main() {
    //匿名
    methods("陈智华", 18) { strs, num ->
        print("匿名函数$strs+$num          ")
    }
    methods("华哥最帅",18, ::results)

}
fun results(string: String,int: Int){
    print("具名函数结果为$string$int")

}

inline fun methods(name: String, age: Int, requestResult: (String, Int) -> Unit) {
    var str = "name:$name  age:$age"
    requestResult(str, 666)
}