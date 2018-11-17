package com.imooc.implicitop

/**
  * 隐式参数
  */
object ImplicitParamApp extends App {

  def testParam(implicit name: String): Unit = {
    println(s"$name ~~~~~~~")
  }
  // 主动传入参数，按照传入参数操作
  testParam("zhangsan")

  // 这里是隐式参数
  implicit val name = "implicit_name"
  testParam

  // 声明了隐式参数，也可以自动重新覆盖
  testParam(name = "WJQ")

  // 作用域中出现两个implicit修饰的值时是不允许的
//  implicit val s1 = "s1"
//  implicit val s2 = "s2"
//  testParam
}
