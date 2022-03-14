package com.example.kotlin.zhujie

//TODO kotlin @jvmname注解  添加之后会更改类名在别的地方调用需要修改
//TODO kotlin注解@Jvmfield  使用滞后调用就不是getlist1  变成了直接这里写什么java调用什么  针对于变量
//TODO kotlin 注解：jvmoverloads  原理编译器中专门重载一个函数，专门给java使用  若只要函数中参数有默认值 kotlin就可以不用传入   在java中，就需要全部传入，@jvmoverloads可以达到和kotlin一样的效果
//TODO kotlin @jvmstatic 注解  添加之后java可直接调用函数不需要kotlin.companion.xxx   直接kotlin.xxx   针对于函数