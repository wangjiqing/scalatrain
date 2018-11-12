package com.imooc

object AbstractApp {
  def main(args: Array[String]): Unit = {
//    val person = new Person2()  // 此处不允许直接实例化抽象类

    val student = new Student2();
    println(student.name + " " + student.age)
    student.speek
  }
}

// 抽象类
abstract class Person2 {
  def speek
  def name: String
  def age: Int
}

class Student2 extends Person2 {
  override def speek: Unit = {
    println(name + " at speek")
  }

  override def name: String = "zhangsan"
  override def age: Int = 35
}
