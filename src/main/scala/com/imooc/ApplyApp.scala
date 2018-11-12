package com.imooc

object ApplyApp {
  def main(args: Array[String]): Unit = {
//    for (i <- 1 to 10) {
//      ApplyTest.incr
//    }
//    println(ApplyTest.count)  // 10 说明Object本身就是一个单例对象

    val b = ApplyTest()   // 这里直接调用的是object.apply方法

    val c = new ApplyTest()
    println(c)
    c()   // 这里使用类的实例加()调用的是 Class.apply() 方法
  }
}

// 伴生对象
object ApplyTest {
  println("Object ApplyTest enter ...")

  var count = 0

  def incr = {
    count = count + 1
  }

  // 最佳实践：在Object的apply方法中去new Class
  def apply() = {
    println("Object ApplyTest apply ...")

    // 在object中的apply中new class，这里隐式的调用了new ApplyTest
//    new ApplyTest()
  }

  println("Object ApplyTest leave ...")
}

// 伴生类
class ApplyTest {
  def apply() = {
    println("Class ApplyTest apply ...")
  }
}
