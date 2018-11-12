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
<h3> 1.2 Scala中的对象 </h3>

一、类的定义和使用

    1. 一个类中的属性使用var修饰可以使用占位符赋值，并且可以在new之后对其进行重新赋值操作，另外使用占位符赋值需要指定变量的类型
    2. 一个类中的属性使用val修饰，只能赋一次值，不能重复赋值
    3. private [this] 修饰的变量只能在类中使用，出了类的作用范围则无论如何也不能使用
    4. 类中的函数可以直接使用类中的成员，例如 private [this] 修饰的成员
    
        object SimpleObjectApp {
        
          def main(args: Array[String]): Unit = {
            val people = new People()
            people.name = "zhangsan"
        //    people.age = 20 // age属性由于使用val修饰，不可以改变
            println("my name is " + people.name + ", age is " + people.age)
            people.toSleep("22:00 pm")
        
            people.printInfo()
        
        //    people.gender   // 使用private [this] 修饰的，在类的外部无论如何都访问不到
          }
        
        }
        
        class People {
          var name: String = _    // 使用占位符修饰，需要指定类型
          val age = 10  // 这里需要指明值，而且不可变
        
          private [this] val gender = "male"
        
          def printInfo(): Unit = {
            println("gender: " + gender)
          }
        
          def eat(): String = {
            name + " eat..."
          }
        
          def toSleep(time: String) = {
            println(name + "is sleep at " + time)
          }
        }

二、主构造器和附属构造器

    1. 跟在class后面直接构造的就是主构造器。一个class如果没有显式的定义主构造器则自动拥有一个无参的主构造器。
    2. 在class类中使用def this() 定义的构造器，可以与主构造器参数列表不同，并且在其内的第一行代码必须是调用主构造器或者其它附属构造器，
       这样的构造器称为附属构造器。
       
        object ConstructorApp {
        
          def main(args: Array[String]): Unit = {
            val person = new Person("zhangsan", 25)
            println(person.name + " " + person.age)
        
            val person2 = new Person("lisi", 20, "M")
            println(person2.name + " " + person2.age + " " + person2.gender)
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
       
三、继承

    1. 同Java一样，继承时当调用子类构造器之前，需要先嗲用父类的构造器
    2. 子类构造器中新的属性和方法在定义时，需要使用var/val定义，父类存在的属性或方法不需要再使用var/val定义
    
        // 子类构造器
        class Student(name: String, age: Int, var major: String) extends Person(name: String, age: Int) {
          println("enter student contructor ...")
        
          println("leave student contructor ...")
        }
        
四、重写

    当出现继承关系时，子类就可以重写父类的方法或属性，需要使用override关键字修饰
    
        // 子类构造器
        class Student(name: String, age: Int, var major: String) extends Person(name: String, age: Int) {
          println("enter student contructor ...")
        
          // 子类重写父类的方法和属性
          override val school: String = "tonghua"
          override def toString: String = "override person to student, override school: " + school
        
          println("leave student contructor ...")
        }
     
五、抽象类

    抽象类的一个或多个方法只有定义，没有实现；不能直接实例化抽象类；需要实例化必须实现所有的抽象属性及方法
    
        object AbstractApp {
          def main(args: Array[String]): Unit = {
        //    val person = new Person2()  // 此处不允许直接实例化抽象类
        
            val student = new Student2();
            println(student.name + " " + student.age)
            student.speek
          }
        }
        
        // 抽象类
        abstract class Person2 {
          def speek
          def name: String
          def age: Int
        }
        
        class Student2 extends Person2 {
          override def speek: Unit = {
            println(name + " at speek")
          }
        
          override def name: String = "zhangsan"
          override def age: Int = 35
        }
        
六、伴生类和伴生对象

    伴生类和半生对象出现的情况时名称相同，一个相同名称的class是一个object的伴生类；一个相同名称的object是一个class的伴生对象
    
        // 伴生对象
        object ApplyTest {
        
        }
        
        // 伴生类
        class ApplyTest {
        
        }
        
七、apply方法

    