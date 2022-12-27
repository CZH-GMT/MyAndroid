package com.example.kotlin

//TODO kotlin 双检锁单例
class KotlinShuangJianShuoDanLi private constructor() { //加上 private constructor 就不能调用这里了只能调用下面
    companion object {
//        val instance: KotlinShuangJianShuoDanLi by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
//            KotlinShuangJianShuoDanLi()
//        }

//        //Todo:懒汉试
//        var instance: KotlinShuangJianShuoDanLi? = null
//
//        get() {
//                if (instance == null) {
//                    instance = KotlinShuangJianShuoDanLi()
//                }
//                return instance
//            }
    }
    fun  show()= println("show")
}

fun main() {
//    KotlinShuangJianShuoDanLi.instance.show()

}