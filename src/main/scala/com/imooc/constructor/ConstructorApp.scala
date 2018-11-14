package com.imooc.constructor

object ConstructorApp {

  def main(args: Array[String]): Unit = {
    val person = new Person("zhangsan", 25)
    println(person.name + " " + person.age)

    val person2 = new Person("lisi", 20, "M")
    println(person2.name + " " + person2.age + " " + person2.gender)

    val student = new Student("wangwu", 23, "Math")
    println(student.name + " " + student.age + " " + student.major)

    println(student.toString)
  }
}

// 主构造器
class Person(val name: String, val age: Int) {
  println("enter constructor ...")

  val school = "huade"
  var gender: String = _

  // 附属构造器
  def this(name: String, age: Int, gender: String) {
    // 附属构造器的第一行代码必须调用主构造器或者其它附属构造器
    this(name, age)
    this.gender = gender
  }

  println("leave constructor ...")
}

// 子类构造器
class Student(name: String, age: Int, var major: String) extends Person(name: String, age: Int) {
  println("enter student contructor ...")

  // 子类重写父类的方法和属性
  override val school: String = "tonghua"
  override def toString: String = "override person to student, override school: " + school

  println("leave student contructor ...")
}
