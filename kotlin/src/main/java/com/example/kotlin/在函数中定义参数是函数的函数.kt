package com.example.kotlin

//TODO  kotlin  在函数中定义参数是函数的函数
fun main() {
    //TODO   写法一
    loginAPI("chenZhiHua", "123456", responseResult = { msg, code ->
        print("登陆情况：$msg 返回值：$code")
    })

    loginAPI("wertyui234", "23453", { msg, code ->
        print("\n登陆情况：$msg 返回值：$code")
    })
    loginAPI(",3452345", "234567") { msg, code ->
        print("\n登陆情况：$msg 返回值：$code")
    }

}

//模拟数据库 SQL
const val USER_NAME = "chenZhiHua"
const val USER_PASSWORD = "123456"

//登录API

fun loginAPI(name: String, password: String, responseResult: (String, Int) -> Unit) {
    if (name == null || password == null) {
        TODO("用户名或密码为null")
    }
    if (name.length > 3 && password.length > 3) {
        if (webServiceLoginApi(name, password)) {
            responseResult("success", 200)
        } else {
            responseResult("failed", 404)
        }

    } else {
        TODO("用户名或密码不合格")
    }

}

private fun webServiceLoginApi(name: String, password: String): Boolean {
    return if (name == USER_NAME && password == USER_PASSWORD) true else false


}