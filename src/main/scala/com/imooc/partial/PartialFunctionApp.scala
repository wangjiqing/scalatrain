package com.imooc.partial

object PartialFunctionApp extends App {
  // 常规函数
//  val divide = (x: Int) => 100 / x
//  divide(0)     // exception

  // 定义一个偏函数
//  val divide = new PartialFunction[Int, Int] {
//    override def isDefinedAt(x: Int): Boolean = x != 0  // 判断x是否等于0，当x=0时抛出异常
//    def apply(x: Int): Int = 100 / x
//  }

//  println(divide(0))

  // 偏函数与case语句结合
  val divide1 : PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 100 / d
  }

  println(divide1(0))
}
