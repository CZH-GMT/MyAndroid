package com.example.kotlin.kuozhnawenjian

//TODO kotlin 扩展我文件本件
//TODO 一般使用public  外部使用  使用Iterable  为了让他的子类都能用

//需求随机取一个元素返回
fun <S> Iterable<S>.showkuozhnawenjian() = println("扩展文件随机取出的元素是：${this.shuffled().first()}")