package com.imooc.option

object OptionApp {
  def main(args: Array[String]): Unit = {
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo", "China" -> "Beijing")
    println(capitals get "China")     // Some(Beijing)
    println(capitals.get("North Pole")) // None

    // 没有值调用的时候依旧会抛出异常
    println(capitals get "North Pole" get) // Exception
    // Scala推荐使用getOrElse方法，设置一个默认值，没有值返回的时候使用默认值作为返回值
    println(capitals get "North Pole" getOrElse "Oops") // Oops
    println(capitals.get("China").getOrElse("Oops"))    // Beijing
  }
}
