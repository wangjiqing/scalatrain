package com.imooc.readresource

import java.io.{FileInputStream, InputStreamReader}

import scala.xml.XML

/**
  *
  */
object XMLApp extends App {

  // 将xml内容读取出来
  def loadXml(): Unit = {
    val xml1 = XML.load(this.getClass.getClassLoader.getResource("test.xml"))
    println(xml1)
  }
//  loadXml()

  def loadXml1(): Unit = {
    val xml = XML.load(new FileInputStream("E:\\IdeaProjects-github\\scalatrain\\src\\resource\\test.xml"))
    println(xml)
  }
//  println(loadXml1())

  def loadXml2(): Unit = {
    val xml = XML.load(new InputStreamReader(new FileInputStream("E:\\IdeaProjects-github\\scalatrain\\src\\resource\\test.xml")))
    println(xml)
  }

//  loadXml2()

  // readXml
  def readMXLAttr(): Unit = {
    val xml = XML.load(this.getClass.getClassLoader.getResource("test.xml"))
    // header/field  dom   层级导航标签查找
    val headerField  = xml \ "header" \ "field"
//    println(headerField)

    // all field dom      查找所有的名称为field的标签
    val field = xml \\ "field"
    for (elem <- field) {
//      println(elem)
    }

    //  header/field -> name  取得header标签下的field标签中name的属性
//    val fieldAttributes = (xml \ "header" \ "field").map(_ \ "@name")
    val fieldAttributes = (xml \ "header" \ "field" \\ "@name")
    for (elem <- fieldAttributes) {
//      println(elem)
    }

    // name="Logon"的标签
    val filters = (xml \\ "message").filter(_.attribute("name").exists(_.text.equals("Logon")))
    for (elem <- filters) {
//      println(elem)
    }

    // header/field/name 中标签内的值
    (xml \ "header" \ "field").map(x => (x \ "@name", x.text, x \ "@required")).foreach(println)
  }

  readMXLAttr()
}
