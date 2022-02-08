package com.example.kotlin
//TODO 在kotlin 中所有的类都隐式继承了Any类  不写默认就有

class objs : Any()
class objs1 : Any()
class objs2 : Any()
class objs3 : Any()


fun main() {
    println(objs().toString())

}