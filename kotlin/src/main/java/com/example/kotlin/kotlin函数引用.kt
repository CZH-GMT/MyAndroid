package com.example.kotlin

//TODO  函数引用    用（::）把函数的实现  变成函数的对象
fun main() {
    //TODO  函数引用    用（::）
    login("chenZhiHua", "123456", ::result)
}
val obj=::result

fun result(msg: String, code: Int) {
    print("登录结果为 $msg -- $code ")

}

const val USER_NAME1 = "chenZhiHua"
const val USER_PASSWORD1 = "123456"

fun login(name: String, psw: String, responseresult: (String, Int) -> Unit) {
    if (name == USER_NAME1 && psw == USER_PASSWORD1) {
        responseresult("登陆成功", 200)
    } else {
        responseresult("登陆失败", 404)
    }


}
