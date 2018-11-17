package com.imooc.implicitop

import java.io.File

/**
  * 隐式切面封装
  */
object ImplicitAspect extends App {

  implicit def man2superman(man: Man): SuperMan = new SuperMan(man.name)
  implicit def file2RichFile(file: File): RichFile = new RichFile(file)
}
