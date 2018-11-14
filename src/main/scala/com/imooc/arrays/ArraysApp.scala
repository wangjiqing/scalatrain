package com.imooc.arrays

object ArraysApp extends App{
  // 创建一个长度为5的数组
//  val a = new Array[String](5)
//  // 数组a的长度
//  println(a.length)     // 5
//  // 向数组a下标为0位赋值"hello"
//  a(0) = "hello"
//  // 取出数组a下表为0的元素
//  println(a(0))         // hello
//
//  // 可以直接调用Array(底层调用的是Array的apply方法)
//  val b = Array("hadoop", "spark", "storm")
//  println(b(0))         // hadoop
//  b(1) = "flink"
//  println(b(1))         // flink
//
//
//  // Scala为我们封装了数组的一些方法，在Java中没有的方法
//  val c = Array(1, 2, 3, 4, 5, 6, 7, 8)
//  println(c.sum)        // 36
//  println(c.max)        // 8
//  println(c.min)        // 1
//
//  // 数组转化String的三种方法
//  println(c.mkString)   //  12345678
//  println(c.mkString(","))  //  1,2,3,4,5,6,7,8
//  println(c.mkString("<", ",", ">"))  //  <1,2,3,4,5,6,7,8>

  // 声明一个变长的数组(ArrayBuffer)，又称为数组缓冲区
  val d = scala.collection.mutable.ArrayBuffer[Int]()
  // 向数组缓冲区中追加一个元素
  println(d += 1)  // ArrayBuffer(1)
  println(d += 2)  // ArrayBuffer(1, 2)
  // 向数组缓冲区中追加多个元素
  println(d += (3, 4, 5))   // ArrayBuffer(1, 2, 3, 4, 5)
  // 向数组缓冲区中追加一个数组
  println(d ++= Array(6, 7, 8))   // ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8)
  // 指定数组缓冲区的下标位置添加一个元素（下标为0的位置添加一个0）
  d.insert(0, 0)
  println(d)            // ArrayBuffer(0, 1, 2, 3, 4, 5, 6, 7, 8)
  // 指定数组缓冲区下标位置移除一个元素
  d.remove(1)
  println(d)            // ArrayBuffer(0, 2, 3, 4, 5, 6, 7, 8)
  // 指定数组缓冲区下标范围移除多个元素
  d.remove(0, 3)
  println(d)            // ArrayBuffer(4, 5, 6, 7, 8)
  // 从数组缓冲区的尾部移除多个元素
  d.trimEnd(2)
  println(d)            //  ArrayBuffer(4, 5, 6)
  // 可变数组转化为不可变数组
  println(d.toArray.mkString(","))    //  4,5,6

  // 遍历数组缓冲区的方法
  for (i <- 0 until d.length) {
    print(d(i) + " ")
  }                                 // 4 5 6

  println()

  for (ele <- d) {
    print(ele + " ")
  }                                 // 4 5 6

  println()
  // 反转遍历数组缓冲区的方法
  for (j <- (0 until d.length).reverse) {
    print(d(j) + " ")
  }                                  // 6 5 4
}
