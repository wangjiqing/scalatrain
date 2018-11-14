package com.imooc.clazz

object CaseClassApp {
  def main(args: Array[String]): Unit = {
    // case class使用不需要new关键字，通常用在模式匹配中
    println(Dog("wangcai").name)
  }
}

case class Dog(name: String)
