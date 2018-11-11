package com.imooc

/**
  * Scala 函数
  */
object FunctionApp {
  def main(args: Array[String]): Unit = {
    println(sum(3, 5))  // 8
    println(three)    // 3
    sayHello                  // hello
    sayName()                 // Hello zhangsan
    sayName("lisi")   // Hello lisi
    println(speed(100, 10))    // 10.0
    println(speed(time = 20, distance = 100))   // 5.0
    println(sum2(1, 2, 3))    // 6
    println(sum2(1, 2, 3, 4)) // 10
    println(isTrue(15)) // true
    println(isTrue(5))  // false
    RangeTest(1, 10)    //  Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                        //  Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                        //  Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
                        //  Range(1, 3, 5, 7, 9)
                        //  Range(10, 8, 6, 4, 2)
                        //  Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
    iteratorTest1()     // 0 2 4 6 8 10
    println()
    iteratotTest2()     // 张三 李四 王五 赵六
    println()
    iteratorTest3()     // 张三 李四 王五 赵六
    println()
    sum3()              // 5050
  }

  def sum(x: Int, y: Int): Int = {
    x + y
  }

  def three() = 1 + 2

  def sayHello: Unit = {
    println("hello")
  }

  def sayName(name: String = "zhangsan"): Unit = {
    println("Hello " + name)
  }

  def speed(distance: Float, time: Float): Float = {
    distance / time
  }

  def sum2(numbers: Int*): Int = {
    var result = 0
    for (number <- numbers) {
      result = result + number
    }
    result
  }

  def isTrue(number: Int): Boolean = {
    var b = false;
    if (number > 10) {
      b = true
    } else {
      b = false
    }
    b
  }

  def RangeTest(start: Int, end: Int): Unit = {
    println(start.to(end))
    println(start to end)

    println(Range(start, end))
    println(Range(start, end, 2))
    println(Range(end, start, -2))

    println(start until end)
  }

  def iteratorTest1() = {
    for (i <- 0 to 10 if i % 2 == 0) {
      print(i + " ")
    }
  }

  def iteratotTest2() = {
    val names = Array("张三", "李四", "王五", "赵六")
    for (name <- names) {
      print(name + " ")
    }
  }

  def iteratorTest3() = {
    val names = Array("张三", "李四", "王五", "赵六")
    names.foreach(name => print(name + " "))
  }

  def sum3() = {
    var (num, sum) = (100, 0)
    while (num > 0) {
      sum = sum + num
      num = num - 1
    }
    println(sum)
  }
}
