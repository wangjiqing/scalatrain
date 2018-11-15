package com.imooc.collection

object MapApp {

  def main(args: Array[String]): Unit = {
    // 创建一个map
    var m = Map("Alice" -> 1, "Bob" -> 3, "Mike" -> 6)
    // 追加一个kv
    m+=("Ann" -> 8)
    println(m)            // Map(Alice -> 1, Bob -> 3, Mike -> 6, Ann -> 8)
    // 追加一个Map
    m++=Map("Ant" -> 5, "Dob" -> 6)
    println(m)            // Map(Ann -> 8, Mike -> 6, Bob -> 3, Dob -> 6, Ant -> 5, Alice -> 1)
    // 打印所有的key
    println(m.keys)       // Set(Ann, Mike, Bob, Dob, Ant, Alice)
    println(m.keySet)     // Set(Ann, Mike, Bob, Dob, Ant, Alice)
    // 打印所有的value
    println(m.values)     // MapLike(8, 6, 3, 6, 5, 1)
    // 移除一个kv
    m-=("Ann")
    println(m)            // Map(Mike -> 6, Bob -> 3, Dob -> 6, Ant -> 5, Alice -> 1)

    // 创建一个可变的map
    val mm = scala.collection.mutable.Map("one" -> 1, "two" -> 2, "three" -> 3)
    mm+=("four" -> 4)
    println(mm)           // Map(one -> 1, three -> 3, four -> 4, two -> 2)

    // 取值
    println(m get "Bob")  // Some(3)
    println(m("Bob"))     // 3
    println(mm("one"))    // 1

    for (kv <- mm) {
      print(kv)         // (one,1)(three,3)(four,4)(two,2)
      print(kv._1 + " " + kv._2 + " | ")    // one 1 | three 3 | four 4 | two 2 |
    }
  }
}
