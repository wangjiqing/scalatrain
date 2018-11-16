package com.imooc.matchpa

import scala.util.Random

object MatchApp extends App {
  val fruits = Array("apple", "orange", "banana")
  // 通过随机数选择一个
  val fruit = fruits(Random.nextInt(fruits.length))
  // 基本模式匹配
  fruit match {
    case "apple" => println("吃苹果")
    case "orange" => println("吃橙子")
    case _ => println("我看还是吃香蕉吧")
  }

  // 也可以再case语句中使用条件判断
  def judgeGrade(score: Int) = {
    score match {
      case score if (score <= 100 && score > 90) => println("A")
      case score if (score <= 90 && score > 75) => println("B")
      case score if (score <= 75 && score > 60) => println("C")
      case score if (score <= 60) => println("C")
      case _ => println("分数不正确")
    }
  }

  judgeGrade(100)

  // Array匹配
  def courses(array: Array[String]): Unit = {
    array match {
      case Array("math") => println("今天只有一节课是math")
      case Array("math", _*) => println("今天第一节课是math，总共有" + array.length + "节课")
      case Array(x, y) => println("今天有 " + array.length + "节课," )
      case _ => println("课程走丢了")
    }
  }

  courses(Array("math"))
  courses(Array("math", "english"))
  courses(Array("math", "english", "history"))
  courses(Array("hehe"))

  println()

  // List匹配
  def courses(list: List[String]) = {
    list match {
      case "math" :: Nil => println("今天只有一节课是math")
      case x :: y :: Nil => println("今天有" + list.size + "节课")
      case "english" :: tail => println("今天第一节课是English，共" + list.size + "节课")
      case _ => println("课程走丢了")
    }
  }

  courses(List("math"))
  courses(List("history", "math"))
  courses(List("english", "history", "math"))
  courses(List("bbb"))

  println()

  // 类型匹配
  def matchType(N: Any): Unit ={
    N match {
      case x: Int => println("Int")
      case s: String => println("String")
      case m: Map[_, _] => m.foreach(println)
      case _ => println("other")
    }
  }

  matchType(1)
  matchType("Hello")
  matchType(Map(1 -> "one"))
  matchType(1L)

  // case class 匹配
  abstract class Person
  case class CTO(name: String) extends Person
  case class Emp(name: String) extends Person
  case class Other(name: String) extends Person

  def caseClassMatch(person: Person): Unit = {
    person match {
      case CTO(name) => println("CTO is " + name)
      case Emp(name) => println("Emp have " + name)
      case Other(name) => println("Other have " + name)
    }
  }

  caseClassMatch(CTO("WJQ"))
  caseClassMatch(CTO("ZS"))
  caseClassMatch(CTO("AS"))

  // Option 匹配
  val curse = Map("Java" -> "one", "C++" -> "two", "Ruby" -> "three", "Python" -> null)
  def show(value: Option[String]): Unit = {
    value match {
      case Some(x) => println(x)
      case None => println("This language is null!")
    }
  }

  println(curse.get("Python"))  // Some(null)

  show(curse.get("Java"))       // one
  show(curse.get("Python"))     // null
}
