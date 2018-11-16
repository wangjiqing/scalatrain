package com.imooc.highoperation

object FunctionApp extends App {
  // 通常函数定义如下
  def sayHello(name: String): Unit = {
    println("Hi! " + name)
  }
  sayHello("WJQ")

  // 匿名函数的使用
  val a = (x: Int, y: Int) => x + y
  println(a(2, 3))        // 5

  val b = (x: String, y: String) => {
    s"=====> $x =====> $y"   // =====> hello =====> world
  }
  println(b("hello", "world"))

  // 将参数分开的写法被称为柯里化
  def sum(a: Int, b: Int) = a + b
  println(sum(2, 3))

  def sum2(a: Int)(b: Int) = a + b
  println(sum2(2)(3))

  val l = List(1, 2, 3, 4, 5, 6, 7, 8)
  // map：将集合中的每个元素作用上一个函数（使用相同的函数操作集合上每一个元素）
  val l2 = l.map((x: Int) => x * 2)
  println(l2)   // List(2, 4, 6, 8, 10, 12, 14, 16)
  val l3 = l.map(x => x * 2)
  println(l3)   // List(2, 4, 6, 8, 10, 12, 14, 16)
  val l4 = l.map(_ * 2)
  println(l4)   // List(2, 4, 6, 8, 10, 12, 14, 16)

  // filter：指过滤集合中的元素
  println(l4.filter(_ > 8))   // List(10, 12, 14, 16)
  println(l4.filter(x => x > 8))

  // take：取得集合中前几个元素
  println(l take 4)
  println(l.take(4))

  // reduce：将集合中的元素 依次相加
  println(l.reduce(_ + _))              // 36
  println(l.reduce((x, y) => x + y))    // 36

  // reduceLeft：集合中的元素从左向右依次执行函数
  println(l.reduceLeft((x, y) => x - y))  // -34
  println(l.reduceLeft(_ - _))            // -34
  println(l.reduceLeft(_ min _))  // 集合中元素从左到右比较得到最小值
  println(l.reduceLeft((x, y) => x min y))  // 集合中元素从左到右比较得到最小值
  println(l.reduceLeft(_ max _))  // 集合中元素从左到右比较得到最大值
  println(l.reduceLeft((x, y) => x max y))  // 集合中元素从左到右比较得到最大值

  // 集合中的元素按照如下公式操作 1 - ( 2 - ( 3 - ( 4 - 5 ））））
  println(l.reduceRight(_ - _))   // -4
  println(l.reduceRight((x, y) => x - y)) // -4
  // ... min max

  // fold：手动添加1个元素（柯里化函数中第一个参数）与集合中的每个元素做函数操作
  println(l.fold(36)(_ - _))    // 36 - ((((1 - 2) - 3) - 4) - 5) ... = 0
  println(l.foldLeft(-1)(_ min _))  // -1
  println(l.foldRight(10)(_ max _)) // 10
  println(l.foldRight(4)(_ - _))    // 4 + (1 - (2 - (3 - (4 - (5 - (6 -(7 - 8)))))))   // 0

  // flatten：将集合中的元素压缩成一层
  val f = List(List(1, 2), List(3, 4), List(5, 6))
  println(f.flatten)            // List(1, 2, 3, 4, 5, 6)

  // map: 对集合中的每个元素执行函数
  println(f.map(_.map(_ * 2)))  // 两层Map使用两层Map计算 List(List(2, 4), List(6, 8), List(10, 12))

  // flatMap: 将多层集合压缩成一层集合： flatMap = flatten + map的操作
  println(f.flatMap(_ map (_ * 2))) // List(2, 4, 6, 8, 10, 12)
}
