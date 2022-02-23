package com.example.kotlin

//TODO kotlin 懒汉式
class kotlinLazy {
    //派生类
    companion object {
        private var instance: kotlinLazy? = null
            get() {
                if (field == null) {
                    field = kotlinLazy()
                }
                return field
            }
        //同步锁
        @Synchronized  //
        fun getInstances() = instance!!
    }

    fun show() = println("show")
}

fun main() {
    kotlinLazy.getInstances().show()
}