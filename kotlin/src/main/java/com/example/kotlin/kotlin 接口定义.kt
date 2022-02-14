package com.example.kotlin

import android.hardware.usb.UsbManager

/*
TODO kotlin 接口
     1.接口中所有的成员变量和成员本身都是public open的 所以不需要手动open
     2.接口不能有主构造 反正就是没有构造
     3。实现接口不仅要实现函数还要重写接口的成员  
 */
interface IUSB {
    var usbinformation: String  //usb信息
    var usbimplents: String      //usb插入设备信息

    fun insertUsb(): String
}

class Mouse(override var usbinformation: String = "USB 3.0", override var usbimplents: String = "鼠标接入了USB 3.0") : IUSB {
    override fun insertUsb(): String = "Mouse$usbinformation  ,${usbimplents}"
}

class KeyBoard() : IUSB {
    override var usbinformation: String = "USB 3.1"
        get() = field
        set(value) {
            field = value
        }

    override var usbimplents: String = "键盘接入了USB 3.0"
        get() = field
        set(value) {
            field = value
        }

    override fun insertUsb(): String = "Keyboard$usbinformation  ,${usbimplents}"
}

fun main() {
    val mouse = Mouse()
    println(mouse.insertUsb())
    val keyBoard = KeyBoard()
    println(keyBoard    .insertUsb())

}