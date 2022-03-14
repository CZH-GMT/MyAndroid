package com.example.kotlin.zhujie;
//TODO 注解@Jvmfield
public class JvmFiled {
    public static void main(String[] args) {
        KotlinJvmField kotlinJvmField = new KotlinJvmField();
        for (String s : kotlinJvmField.list1) {
            System.out.println(s);
        }
    }
}
