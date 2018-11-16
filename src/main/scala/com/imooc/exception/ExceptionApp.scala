package com.imooc.exception

object ExceptionApp extends App {
  // 异常处理
  try {
    val i = 10 / 0
    println(i)
  } catch {
    case ea: ArithmeticException => println("除数为0的异常: " + ea.getMessage)
    case e: Exception => println(e.getMessage)
  } finally {
    // 最终执行的代码，用于释放资源等
  }
}
