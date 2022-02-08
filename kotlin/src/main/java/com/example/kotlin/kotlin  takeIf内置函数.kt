package com.example.kotlin

//TODO kotlin takeIf内置函数  taleIf+空合并操作符（?:  ""）  xxx.takeIf(boolean)
fun main() {
    print(qianduan("huages", "123"))

}

fun qianduan(name: String, psw: String): String? {

    return name.takeIf { checkPermission(name, psw) } ?: "输入错误"
    //TODO take if 判断true  false
}


private fun checkPermission(name: String, psw: String): Boolean {
    return if (name == "huage" && psw == "123") true else false
}