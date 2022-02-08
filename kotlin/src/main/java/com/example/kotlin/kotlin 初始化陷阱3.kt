package com.example.kotlin

//TODO kotlin 初始化陷阱
class KtBase11(_info: String) {
    //TODO  必须先第1步  若这是第二不会报错因为还没赋值就调用了所以报错
    val info = _info

    //TODO  必须先第2步
    val len: String = getlen()

    //TODO  必须先第3步
    private fun getlen(): String {
        return info

    }


}

fun main() {
    println("内容长度为${KtBase11("huage").len.length}")

}