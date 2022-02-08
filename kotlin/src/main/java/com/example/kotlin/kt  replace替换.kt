package com.example.kotlin

fun main() {
    val psw = "ABCDEFG"
    print("原始密码$psw")
    val r1 = psw.replace(Regex("[BDF]")) {
        //原始值   it.value
        when (it.value) {
            "B" -> "3"
            "D" -> "4"
            "F" -> "5"
            else -> it.value
        }



    }
    print("  加密后:$r1")

    val r2 = r1.replace(Regex("[345]")) {
        when (it.value) {
            "3" -> "B"
            "4" -> "D"
            "5" -> "F"
            else -> it.value
        }
    }
    print("   恢复之后的密码为$r2")
}