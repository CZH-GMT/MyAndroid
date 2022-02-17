package com.example.kotlin

//TODO kotlin out协变
/*
   1.product Custom 不变
   2.productClass4
   3.main测试
 */
//TODO  out 协变
//生产者 out T 协变    只能读不能修改
interface Product<out T> {
    //只能读不能修改  修改
//    fun setProduct(item: T) {/*报错因为次函数是对T的修改*/
//    }

    fun getProduct(): T   //可以读取

}

//TODO  in 协变
//消费者 in T协变   只能修改不能读取
interface Custom<in T> {
    //只能修改不能读取      此函数为修改
    fun setCustom(item: T)

    //读取
//    fun getCustom(): T   //报错因为in协变只能修改不能读取

}

//TODO 普通
//生产者&消费者 T  默认情况不变
interface ProductCustom<T> {
    //读取
    fun getProductCustom(): T

    //修改
    fun setProductCustom(item: T)

}

open class Animal //动物
open class People : Animal() //人类
open class Man : People()//男人
open class Woman : People() //女人


class ProductClass1 : Product<Animal> {
    override fun getProduct(): Animal {
        println("生产者 Animal")
        return Animal()
    }

}

class ProductClass2 : Product<People> {
    override fun getProduct(): People {
        println("生产者 People")
        return People()
    }

}

class ProductClass3 : Product<Man> {
    override fun getProduct(): Man {
        println("生产者 Man")
        return Man()
    }

}

class ProductClass4 : Product<Woman> {
    override fun getProduct(): Woman {
        println("生产者 Woman")
        return Woman()
    }

}


//
fun main() {
    val productClass1: Product<Animal> = ProductClass1()  //这个可以接受是因为类型都是Animal

    val productClass2: Product<Animal> = ProductClass2()  //这个也可以接收是因为Product<out T>中含有 out out的作用所以可以用父类来接受子类
    val productClass3: Product<Animal> = ProductClass3()  //这个也可以接收是因为Product<out T>中含有 out out的作用所以可以用父类来接受子类
    val productClass4: Product<Animal> = ProductClass4()  //这个也可以接收是因为Product<out T>中含有 out out的作用所以可以用父类来接受子类

    //TODO 默认情况下泛型的子类对象不可以赋值给泛型的父类对象 ==> List<CharSequence> list=new ArrList<CharSequence>   接收什么类型就必须什么类型
    //TODO out: 泛型的子类 可以赋值给 泛型的父类对象    ==>  List<? extends CharSequence> list=new ArrList<String>  可以接受   大类型接收小类型
}

