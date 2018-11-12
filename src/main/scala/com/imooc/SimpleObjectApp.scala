package com.imooc

/**
  * Scala中的对象：类的定义和使用
  */
object SimpleObjectApp {

  def main(args: Array[String]): Unit = {
    val people = new People()
    people.name = "zhangsan"
//    people.age = 20 // age属性由于使用val修饰，不可以改变
    println("my name is " + people.name + ", age is " + people.age)

    people.toSleep("22:00 pm")
    people.printInfo()

//    people.gender   // 使用private [this] 修饰的，在类的外部无论如何都访问不到
  }

}

class People {
  var name: String = _    // 使用占位符修饰，需要指定类型
  val age = 10  // 这里需要指明值，而且不可变

  private [this] val gender = "male"

  def printInfo(): Unit = {
    println("gender: " + gender)
  }

  def eat(): String = {
    name + " eat..."
  }

  def toSleep(time: String) = {
    println(name + "is sleep at " + time)
  }
}