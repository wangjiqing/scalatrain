package com.imooc.collection

object ListApp {
  def main(args: Array[String]): Unit = {
    // Nil 一个不可变的List
    println(Nil)    // List()

    val l = List(1, 2, 3, 4, 5)
    println(l)      // List(1, 2, 3, 4, 5)
    // 一个List是由头和尾组成的
    println(l.head) // 1
    println(l.tail) // List(2, 3, 4, 5)

    // 也可以使用如下的方式声明List
    val l2 = 1 :: Nil
    println(l2)     // List(1)

    val l3 = 1 :: 2 :: 3 :: Nil
    println(l3)     // List(1, 2, 3)

    // 使用ListBuffer作为变长的List
    val l4 = scala.collection.mutable.ListBuffer[Int]()
    l4 += 1;
    l4 += (2, 3)
    l4 ++= List(4, 5, 6)
    println(l4)     // ListBuffer(1, 2, 3, 4, 5, 6)

    l4 -= 1
    l4 -= (0, 4)
    l4 --= List(5, 6)
    println(l4)     // ListBuffer(2, 3)
    // ListBuffer 转化
    println(l4.toList)  // List(2, 3)
    println(l4.toArray) // [I@57829d67

    // 递归计算
    println(sum(1, 2, 3, 4))  // 10
  }

  // 递归计算首尾相加
  def sum(nums: Int*): Int = {
    if (nums.length == 0) {
      0
    } else {
      nums.head + sum(nums.tail:_*)
    }
  }
}
