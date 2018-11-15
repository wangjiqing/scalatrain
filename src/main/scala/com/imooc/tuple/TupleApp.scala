package com.imooc.tuple

object TupleApp extends App {
  // 构建一个Tuple
  val t = (1, 3.14, "Fred")
  println(t)                          // (1,3.14,Fred)

  val tn = new Tuple3(1, 3.14, "Fred")
  println(tn)                         // (1,3.14,Fred)

  // 取处元素
  val tx = (4, 3, 2, 1)
  val sum = tx._1 + tx._2 + tx._3
  println(sum)                        // 9

  tx.productIterator.foreach{
    i => print("value = " + i + " | ")    // value = 4 | value = 3 | value = 2 | value = 1 |
  }

  println()
  // Tuple.toString()
  val ts = (1, "hello", Console)
  println(ts.toString())              // (1,hello,scala.Console$@668bc3d5)
  // 创建一个元素为2的Tuple
  val tm = new Tuple2("www.baidu.com", "www.google.com")
  println(tm.swap)                    // (www.google.com,www.baidu.com)
}
