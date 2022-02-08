package com.example.kotlin

//TODO  kotlin field 关键字

class KtBase70 {
    var name = "huage"

    /*
    public String  name="huage;

    public String getname(){
        return this.name;
    }

   public void setName(String name){
        this.name=name
   }

     */
    var value = "value"   //TODO  默认都有get    set

        ///隐式代码 默认含有
        get() = field
        set(value) {
            field = value
        }


    var info = "猪猪侠"
        get() = field.capitalize() //首字母转换成大写
        set(value) {
            field = "【$value】"
        }
    /*背后一定会做的情:
          public String info = "猪猪侠"

          public void set info(String info){
                this.info="【"+info+"】"
          }

          public String getInfo(){
                return StringKt.capitalize(this.info)
          }

     */

}

fun main() {


    //背后隐式代码  new ktBase70().setName("chenzhihua")
    KtBase70().name = "chenzhihua"
    //背后隐式代码 println( new ktBase70().getName())
    println(KtBase70().name)

    println(">>>>>>>>>>>>>>>>>>>>>>>>>")
    //背后隐式代码 println( new ktBase70().getInfo())
    println(KtBase70().info)
    //背后隐式代码  new ktBase70().setInfo("siling)
    KtBase70().info = "siling"


}

