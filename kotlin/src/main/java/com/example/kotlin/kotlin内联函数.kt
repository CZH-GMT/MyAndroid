package com.example.kotlin

//TODO  kotlin  内联函数   当函数中有lambda表达式应该使用内联函数（inline  只有public可使用（不确定））
fun main() {
    //TODO   写法一
    loginAPI3("chenZhiHua", "123456", responseResult = { msg, code ->
        print("登陆情况：$msg 返回值：$code")
    })

    loginAPI3("wertyui234", "23453", { msg, code ->
        print("\n登陆情况：$msg 返回值：$code")
    })
    loginAPI3(",3452345", "234567") { msg, code ->
        print("\n登陆情况：$msg 返回值：$code")
    }

}

//模拟数据库 SQL
const val USER_NAME3 = "chenZhiHua"
const val USER_PASSWORD3 = "123456"

//登录API
//TODO  此函数不使用内联  编译后会生成多个对象完成lambda的调用  损耗性能
//TODO  使用内联会把会把代码替换到调用出，没有任何函数开辟  对象开辟  性能损耗
//TODO  如果函数中有lambda 尽量使用inline内敛函数  避免任何函数开辟  对象开辟  性能损耗
inline fun loginAPI3(name: String, password: String, responseResult: (String, Int) -> Unit) {
    if (name == null || password == null) {
        TODO("用户名或密码为null")
    }
    if (name.length > 3 && password.length > 3) {
        if (webServiceLoginApi3(name, password)) {
            responseResult("success", 200)
        } else {
            responseResult("failed", 404)
        }

    } else {
        TODO("用户名或密码不合格")
    }

}

fun webServiceLoginApi3(name: String, password: String): Boolean {
    return if (name == USER_NAME3 && password == USER_PASSWORD3) true else false


}