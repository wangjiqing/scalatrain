package com.imooc.readresource

import scala.io.Source
import scala.util.parsing.json._

/**
  * Scala读取JSON
  */
object ReadJsonApp extends App {

  def readJson1(json: Option[Any]) = json match {
    case Some(map: Map[String, Any]) => map
  }

  val str = Source.fromFile("G:\\BaiduNetdiskDownload\\test.json").mkString
  val json = JSON.parseFull(str)

  println(readJson1(json))
}
