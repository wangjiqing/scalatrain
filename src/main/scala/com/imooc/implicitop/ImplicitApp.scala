package com.imooc.implicitop

import java.io.File
import ImplicitAspect._   // 引入

object ImplicitApp extends App {

  // 定义隐式转换函数
//  implicit def man2superman(man: Man): SuperMan = new SuperMan(man.name)
  val man = new Man("WJQ")
  man.fly()

  // 增强java.io.File类
//  implicit def file2RichFile(file: File): RichFile = new RichFile(file)
  val file = new File("G:/BaiduNetdiskDownload/hello.txt")
  val txt = file.read()
  println(txt)

}

class Man(val name: String) {
  def eat(): Unit = {
    println(s"$name eat ...")
  }
}

class SuperMan(val name: String) {
  def fly(): Unit = {
    println(s"$name fly ...")
  }
}

class RichFile(val file: File) {
  def read(): String = {
    scala.io.Source.fromFile(file.getPath).mkString
  }
}


