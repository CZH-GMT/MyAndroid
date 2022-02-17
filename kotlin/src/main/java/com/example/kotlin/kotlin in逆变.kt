package com.example.kotlin

//TODO kotlin in 逆变
/*
   TODO out协变是  泛型大类型 可以接收小类型
        in 逆变是  泛型小类型 可以接受大类型
 */


class CustomClass1 : Custom<Animal> {

    override fun setCustom(item: Animal) {
        println("消费者 Animal")
    }

}

class CustomClass2 : Custom<People> {
    override fun setCustom(item: People) {
        println("消费者 People")
    }


}

class CustomClass3 : Custom<Man> {

    override fun setCustom(item: Man) {
        println("消费者 Man")
    }

}

class CustomClass4 : Custom<Woman> {
    override fun setCustom(item: Woman) {
        println("消费者 Woman")
    }

}

fun main() {
    val customClass1: Custom<Man> = CustomClass1()
    val customClass2: Custom<Woman> = CustomClass2()   //TODO 泛型类型是people  用woman子类来接受
    //TODO  正常情况下  泛型父类不可以赋值给泛型子类  因为有in 的存在  ==> List<? super String> list=new ArrList<CharSequence>  小类型接收大类型

    //in 逆变 ：子类泛型声明处 可以接受 父类的 泛型具体处   子类=父类
    //out协变 ：父类的泛型声明出可以接受 子类的 泛型具体处   父类=子类
}
