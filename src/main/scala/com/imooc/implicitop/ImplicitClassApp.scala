package com.imooc.implicitop

/**
  * 隐式类
  */
object ImplicitClassApp extends App {

  implicit class Calculator(x: Int) {
    def add(a: Int) = a + x
  }

  println(1.add(2))

  // implicit 修饰的类参数是Int，不能使用字符串.add()方法
//  "1".add(2)
}


