package com.example.kotlin

//TODO 手写rxjava
fun main() {
    //create 输入源，没有任何参数给你，你是输出(万能类型)
    create {
        "hhhhhh"
        true
    }.rxmap {
        "你输入的是$this"
    }.observer {
        println(this)
    }


}

//create
inline fun <OUTPUT> create(lambda: () -> OUTPUT): RxjavaCoreClass<OUTPUT> {
    return RxjavaCoreClass(lambda())
}

//中转站
class RxjavaCoreClass<T>(var item: T) {   //此消息就是create最后一行返回值  就是item

}

//map
fun <X, Y> RxjavaCoreClass<X>.rxmap(maplambda: X.() -> Y): RxjavaCoreClass<Y> {
    return RxjavaCoreClass(maplambda(item))

}

fun <O> RxjavaCoreClass<O>.observer(pre: O.() -> Unit) {
    return pre(item)

}