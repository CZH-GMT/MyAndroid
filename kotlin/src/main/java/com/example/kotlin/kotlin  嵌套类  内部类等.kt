package com.example.kotlin

//TODO  kotlin 嵌套类  内部类     必须添加inner 成为内部类才能访问


//TODO 内部类
class Body(var hhhh: String) { //身体
    //心脏
    //TODO 这样是访问不到外部类的信息属于（嵌套类）   必须添加inner 成为内部类才能访问
    inner class Heart {
        fun heart() = println("心脏访问身体的信息：$hhhh")

    }

    //器官
    inner class Qiguan {
        fun qiguan() = println("器官访问身体的信息：$hhhh")
    }

    inner class Hand {  //手
        inner class RightHand {  //右手
            fun rightshou() = println("右手访问身体的信息：$hhhh")
        }

        inner class LeftHand {  //左手
            fun leftshou() = println("左手访问身体的信息：$hhhh")
        }
    }


}

//TODO  嵌套类、
//TODO 嵌套类的特点  ：  外部的类可以访问 内部的嵌套类
//TODO                 内部的嵌套类不能访问外部的属性
class Other {
    val nima = "  hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
    fun show() {
        others().hh()

    }

    class others {
        fun hh() = println("嵌套类的信息：")
    }
}


fun main() {
    //内部类调用
    val body = Body("永远牛逼")
    body.Heart().heart()
    body.Qiguan().qiguan()
    body.Hand().LeftHand().leftshou()
    body.Hand().RightHand().rightshou()

    //嵌套类调用
    Other.others().hh()
}