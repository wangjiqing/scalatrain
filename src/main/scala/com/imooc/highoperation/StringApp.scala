package com.imooc.highoperation

object StringApp extends App {
  // 字符串插值操作
  val name = "WJQ"
  println(s"Hello:$name")                     // Hello:WJQ

  val team = "AC"
  println(s"Hello:$name, Welcome to $team")   // Hello:WJQ, Welcome to AC

  // 字符串多行操作(键盘操作：shift + 双引号按三次，回车即可)
  val b =
    """
      |这是一个多行字符串
      |hello
      |world
    """.stripMargin

  println(b)
}
