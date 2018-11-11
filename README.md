<h1>Scala 学习demo</h1>

<h2> 环境 Scala、Maven </h2>

<h2> 笔记课程来自慕课网：https://coding.imooc.com/class/215.html </h2>

<h3> 1.1 Scala 函数 </h3>

一、函数的定义和使用
    
    1. def 函数名（参数名称：参数类型，...）：返回值类型 = {
            // 函数体
            ...
            // 最后一行执行的结果为当前函数的返回值，不需要return关键字
        }
    2. def 函数名（参数名称：参数类型，...）：返回值类型 = 3 + 5
    3. 函数调用时当函数没有参数列表时，调用时可以不写函数后面的括号
 
        def main(args: Array[String]): Unit = {
            println(three)  // 此处直接调用即可，不用写括号
        }
      
        def three() = 1 + 2
    
    4. 定义函数时，没有参数列表多数情况亦可以不写后面的括号，包括返回类型（Scala会自动推导）
        
        def main(args: Array[String]): Unit = {
            sayHello
        }
        
        def sayHello {
            println("hello world")
        }
            
二、默认参数
    
    允许在函数定义时，指定函数的默认值
    
        def main(args: Array[String]): Unit = {
          sayName()
          sayName("ZH")
          // 以下情况不可以
          sayName
        }
        
        def sayName(name: String = "WJQ") = {
          println(name)
        }
        
三、命名参数
    
    命名参数的意思就是说依照名称对应参数（不建议，很少，但是有）
    
        def main(args: Array[String]): Unit = {
            println(speed(100, 10))
            // 命名参数是按照名字来对应参数
            println(speed(time = 10, distance = 100))
        }
        
        def speed(distance: Float, time: Float): Float = {
            distance / time
        }
    
四、可变参数
    
    所谓可变参数指的是参数的个数可变，如下方法中使用“*”表示可变参数，调用的时候可以传多个相同类型（Int）的参数
    
        def main(args: Array[String]): Unit = {
            println(sum2(1, 2, 3))
            println(sum2(1, 2, 3, 4))
            println(sum2(1, 2, 3, 4, 5))
        }
        
        def sum2(numbers: Int*) = {
            var result = 0
            for (number <- numbers) {
              result += number
            }
            result
        }
     
五、条件表达式

    就是所谓的 if else 判断
    
        def main(args: Array[String]): Unit = {
          println(isTrue(5))
          println(isTrue(15))
        }
        
        def isTrue(number: Int): Boolean = {
          var b = false
          if (number > 10) {
            b = true
          } else {
            b = false
          }
          b
        }
        
六、循环表达式

    1. to：底层实现是Range，实现一个左闭右闭的集合
    
        写法一：
        
            scala> 1 to 10
            res0: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        
        写法二：
        
            scala> 1.to(10)
            res1: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    2. Range：实现一个左闭右开的集合
    
        使用一：
        
            scala> Range(1, 10)
            res2: scala.collection.immutable.Range = Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
        
        使用二： step步长为2
        
            scala> Range(1, 10, 2)
            res3: scala.collection.immutable.Range = Range(1, 3, 5, 7, 9)
            
        使用三： step步长为-2，倒序集合
        
            scala> Range(10, 1, -2)
            res4: scala.collection.immutable.Range = Range(10, 8, 6, 4, 2)
        
    3. until：底层实现是Range，实现一个左闭右开的集合
    
        scala> 1 until 10
        res5: scala.collection.immutable.Range = Range(1, 2, 3, 4, 5, 6, 7, 8, 9)
    
    4. 遍历
    
        方式一：带有条件判断的遍历
        
            def main(args: Array[String]): Unit = {
              for (i <- 0 to 10 if i % 2 == 0) {
                print(i + ",")
              }
            }
        
        方式二：
        
            var names = Array("张三", "李四", "王五", "赵六")
            
            def main(args: Array[String]): Unit = {
              for (name <- names) {
                print(name + " ")
              }
            }
        
        方式三(foreach)：name指的是names里每一个元素；=> 指的是将左边的name作用上一个函数（这里是print），输出另外的结果
        
            var names = Array("张三", "李四", "王五", "赵六")
            
            def main(args: Array[String]): Unit = {
              names.foreach(name => print(name + " "))
            }
        
        方式四：使用while循环累加求取100以内整数相加的和
        
            def main(args: Array[String]): Unit = {
              var (num, sum) = (100, 0)
              while (num > 0) {
                sum = sum + num
                num = num - 1
              }
              println(sum)
            }
          