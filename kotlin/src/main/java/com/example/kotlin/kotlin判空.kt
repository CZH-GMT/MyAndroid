package com.example.kotlin

//TODO  kotlin可空  (?)
fun main() {


    var name: String? = null


    //TODO  kotlin 安全调用操作符（）

    var str: String? = "huage"
//    str = null
    str?.capitalize()  //如果str为空后面不执行
    print(str)


    //TODO  kotlin  let 安全调用   常规操作 参数？.let{   //若为空则执行不进来    }

    var hhhh: String? = "时代法国红酒看来法国红酒看来"
    hhhh = null
    hhhh = ""

    var r = hhhh?.let { //如果hhh为空执行不到这里面
        if (it.isBlank()) {//TODO   isBlank判断内容是否为（" "）
            "jjjjjjj"
        } else {
            print(it)
        }

    }
    print("\n$r")


    //TODO  kotlin  非空断言（确认）----（确认不为空继续操作）操作符 （！！）  capitalize(将第一个字母变为大写）
    var study: String? = null
    study = "czh--------------------------->"

    var s = study!!.capitalize()
    print(s)






    //TODO kotlin空合并操作符
    var jjj:String?="uytrew"
    jjj=null
    print(jjj?:"原来你为null呀")


    print(jjj?.let { "$it" }?:"你又为null")

}