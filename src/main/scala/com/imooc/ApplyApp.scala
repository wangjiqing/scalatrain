package com.imooc

object ApplyApp {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10) {
      ApplyTest.incr
    }
    println(ApplyTest.count)
  }
}

// 伴生对象
object ApplyTest {
  println("Object ApplyTest enter ...")

  var count = 0

  def incr = {
    count = count + 1
  }

  println("Object ApplyTest leave ...")
}

// 伴生类
class ApplyTest {

}
