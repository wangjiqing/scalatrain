package com.imooc.readresource

import scala.io.Source

object FileApp {

  def main(args: Array[String]): Unit = {
    val file = Source.fromFile("G:/BaiduNetdiskDownload/hello.txt", "UTF-8")
    // 读取文本文件内容
    def readLine(): Unit = {
      for (line <- file.getLines()) {
        println(line)
      }
    }
//    readLine()

    def readChar(): Unit = {
      for (elem <- file) {
        println(elem)
      }
    }
//    readChar()

    // 读取网络上的内容
    def readNet(): Unit = {
      val file = Source.fromURL("https://www.baidu.com")
      for (elem <- file.getLines()) {
        println(elem)
      }
    }

    readNet()
  }
}
