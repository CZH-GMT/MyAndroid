package com.example.kotlin
//TODO kotlin 函数data数据类 copy函数学习      原先默认生成的tostring equals hashcode copy等等copy的时候只生成主构造 ，不管次构造

data class KtBase21(var bbb: String, var nainling: Int) {
    var zhongyao = ""

    init {//可以监听主构造函数是否执行
        println("主构造函数执行了")
    }

    //次构造函数
    constructor(bbb: String) : this(bbb, 99) {
        println("次构造被调用")
        zhongyao = "非常重要的核心信息"  //想要输出zhongyao必须重写

    }

    override fun toString(): String {
        return "toString name:$bbb,age:$nainling,zhongyao:$zhongyao"
    }

}

/*   TODO 生成的toString 为什么只有两个参数？
     TODO 答：  原先默认生成的tostring equals hashcode copy等等copy的时候只生成主构造 ，不管次构造
//    @NotNull
      public String toString() {
      return "KtBase21(bbb=" + this.bbb + ", nainling=" + this.nainling + ")";
   }
 */
fun main() {
    var p1 = KtBase21("华哥")//调用次构造函数
    println(p1)


    //TODO copy
    val copy = p1.copy("haha", 77)
    println(copy)

}