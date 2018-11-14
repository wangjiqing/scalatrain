package com.imooc.arrays

object ArraysApp extends App{
  // 创建一个长度为5的数组
  val a = new Array[String](5)
  // 数组a的长度
  println(a.length)     // 5
  // 向数组a下标为0位赋值"hello"
  a(0) = "hello"
  // 取出数组a下表为0的元素
  println(a(0))         // hello

  // 可以直接调用Array(底层调用的是Array的apply方法)
  val b = Array("hadoop", "spark", "storm")
  println(b(0))         // hadoop
  b(1) = "flink"
  println(b(1))         // flink


  // Scala为我们封装了数组的一些方法，在Java中没有的方法
  val c = Array(1, 2, 3, 4, 5, 6, 7, 8)
  println(c.sum)        // 36
  println(c.max)        // 8
  println(c.min)        // 1

  // 数组转化String的三种方法
  println(c.mkString)   //  12345678
  println(c.mkString(","))  //  1,2,3,4,5,6,7,8
  println(c.mkString("<", ",", ">"))  //  <1,2,3,4,5,6,7,8>
}
