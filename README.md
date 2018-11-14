<h1>Scala 学习demo</h1>

<h2> 环境 Scala、Maven </h2>

<h2> 笔记课程来自慕课网：https://coding.imooc.com/class/215.html </h2>

<h3> 1.1 Scala 函数 </h3>

一、函数的定义和使用 (demo)
    
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
            
二、默认参数 (demo)
    
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
        
三、命名参数 (demo)
    
    命名参数的意思就是说依照名称对应参数（不建议，很少，但是有）
    
        def main(args: Array[String]): Unit = {
            println(speed(100, 10))
            // 命名参数是按照名字来对应参数
            println(speed(time = 10, distance = 100))
        }
        
        def speed(distance: Float, time: Float): Float = {
            distance / time
        }
    
四、可变参数 (demo)
    
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
     
五、条件表达式 (demo)

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
        
六、循环表达式 (demo)

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

一、类的定义和使用 (clazz)

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

二、主构造器和附属构造器 (constructor)

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
       
三、继承 (constructor)

    1. 同Java一样，继承时当调用子类构造器之前，需要先嗲用父类的构造器
    2. 子类构造器中新的属性和方法在定义时，需要使用var/val定义，父类存在的属性或方法不需要再使用var/val定义
    
        // 子类构造器
        class Student(name: String, age: Int, var major: String) extends Person(name: String, age: Int) {
          println("enter student contructor ...")
        
          println("leave student contructor ...")
        }
        
四、重写 (constructor)

    当出现继承关系时，子类就可以重写父类的方法或属性，需要使用override关键字修饰
    
        // 子类构造器
        class Student(name: String, age: Int, var major: String) extends Person(name: String, age: Int) {
          println("enter student contructor ...")
        
          // 子类重写父类的方法和属性
          override val school: String = "tonghua"
          override def toString: String = "override person to student, override school: " + school
        
          println("leave student contructor ...")
        }
     
五、抽象类 (clazz)

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
        
六、伴生类和伴生对象 (apply)

    伴生类和半生对象出现的情况时名称相同，一个相同名称的class是一个object的伴生类；一个相同名称的object是一个class的伴生对象
    
        // 伴生对象
        object ApplyTest {
        
        }
        
        // 伴生类
        class ApplyTest {
        
        }
        
七、apply方法 (apply)

    1. 对于伴生对象指的是一个类的单例对象
    2. 使用伴生类或者伴生对象的名字后面加()指的是调用了伴生对象中的apply()方法，apply方法必须写
    3. 使用new关键字创建的对象，后面加()然后调用，指的是调用了Class.apply()方法，也就是说使用类的实例加()调用的是Class.apply()方法
    4. 最佳实践：在object的apply方法中去new Class（经测试在object中的apply中隐式的调用了new Class）
    
        object ApplyApp {
          def main(args: Array[String]): Unit = {
        //    for (i <- 1 to 10) {
        //      ApplyTest.incr
        //    }
        //    println(ApplyTest.count)  // 10 说明Object本身就是一个单例对象
        
            val b = ApplyTest()   // 这里直接调用的是object.apply方法
        
            val c = new ApplyTest()
            println(c)
            c()   // 这里使用类的实例加()调用的是 Class.apply() 方法
          }
        }
        
        // 伴生对象
        object ApplyTest {
          println("Object ApplyTest enter ...")
        
          var count = 0
        
          def incr = {
            count = count + 1
          }
        
          // 最佳实践：在Object的apply方法中去new Class
          def apply() = {
            println("Object ApplyTest apply ...")
        
            // 在object中的apply中new class，这里隐式的调用了new ApplyTest
        //    new ApplyTest()
          }
        
          println("Object ApplyTest leave ...")
        }
        
        // 伴生类
        class ApplyTest {
          def apply() = {
            println("Class ApplyTest apply ...")
          }
        }

八、case class (clazz)

    case class使用不需要new关键字，通常用在模式匹配中。当一个类被声明为case class的时候，Scala会帮助我们做以下几件事情：
    
    1） 构造器中的参数如果不被声明为var的话，默认是val类型的，但一般不推荐将构造器中的参数声明为var
    2） 自动创建伴生对象，同时在里面帮我们实现apply方法，使得我们在使用的时候可以不直接显式的new对象
    3）伴生对象中同样会帮我们实现unapply方法，从而可以将case class应用于模式匹配（关于unapply方法后面说）
    4）实现自己的toString、hashCode、copy、equals方法
    
    除此之外与普通的Scala类没有区别
    
        object CaseClassApp {
          def main(args: Array[String]): Unit = {
            // case class使用不需要new关键字，通常用在模式匹配中
            println(Dog("wangcai").name)
          }
        }
        
        case class Dog(name: String)
        
九、trait (clazz)

    1. 中文翻译为“特征”。用于在类之间共享接口和字段。它们类似于Java8中的接口。类和对象可以扩展trait。但是trait不能被实例化，因此没有参数
    2. 定义一个trait（最小trait只有关键字trait和标识符）
    
        trait MyTraitApp
    
    3. trait作为泛型类型和抽象方法特别有用
    
        trait Iterator[A] {
          def hasNext: Boolean
          def next: A
        }
    
        扩展trait Iterator[A]需要一个类型A和方法实现hasNext和next。
    
    4. 使用trait：可以使用extends关键字来扩展trait（多个trait使用with关键字连接），然后使用override关键字实现trait的任何抽象成员。
    
        object TestTrait {
          def main(args: Array[String]): Unit = {
            val iterator = new IntIterator(10)
            println(iterator.hasNext) // return true
            println(iterator.next())  // return 0
            println(iterator.next)    // return 1
          }
        }
        
        trait Iterator[A] {
          def hasNext: Boolean
          def next: A
        }
        
        class IntIterator(to: Int) extends Iterator[Int] {
          private var current = 0
        
          override def hasNext: Boolean = current < to
          override def next(): Int = {
            if (hasNext) {
              val t = current
              current += 1
              t
            } else 0
          }
        }
        
        此类IntIterator将参数to作为上限。这extends Iterator[Int]意味着该next方法必须返回一个Int。
  
<h3> 1.3 Scala中的数组 </h3>

一、定长数组 (arrays)

    1. 创建一个长度为5的数组
    
        val a = new Array[String](5)
    
    2. 得到数组的长度
    
        println(a.length)     // 5
        
    3. 向数组指定下标赋值
    
        a(0) = "hello"
        
    4. 取出数组指定下标的元素
    
        println(a(0))
        
    5. 可以调用Array伴生对象的apply方法创建数组
    
        val b = Array("hadoop", "spark", "storm")
        
    6. Scala封装了数组的一些方法（Java中没有）
    
        val c = Array(1, 2, 3, 4, 5, 6, 7, 8)
        println(c.sum)        // 36
        println(c.max)        // 8
        println(c.min)        // 1
        
    7. Scala数组转化String
    
        println(c.mkString)   //  12345678
        println(c.mkString(","))  //  1,2,3,4,5,6,7,8
        println(c.mkString("<", ",", ">"))  //  <1,2,3,4,5,6,7,8>
        
二、变长数组（数组缓冲区） (arrays)

    1. 声明一个变长的数组(ArrayBuffer)，又称为数组缓冲区
    
        val d = scala.collection.mutable.ArrayBuffer[Int]()
        
    2. 向数组缓冲区中追加一个元素
    
        d += 1
        d += 2
        
    3. 向数组缓冲区中追加多个元素
    
        d += (3, 4, 5)
        
    4. 向数组缓冲区追加一个数组
    
        d ++= Array(6, 7, 8)
        
    5. 指定数组缓冲区的下标位置添加一个元素
        
        d.insert(0, 0)
        
    6. 指定数组缓冲区的下标位置移除一个元素
    
        d.remove(1)
        
    7. 指定数组缓冲区的下标范围移除多个元素（从0到3）
    
        d.remove(0, 3)
        
    8. 从数组缓冲区的尾部移除多个元素
    
        d.trimEnd(2)
        
    9. 数组缓冲区转化为数组
    
        d.toArray (d.toArray.mkString(","))
        
    10. 遍历数组缓冲区的方法
    
        for (i <- 0 until d.length) {
            print(d(i) + " ")
        }
        
        for (ele <- d) {
            print(ele)
        }
        
        for (j <- (0 until d.length).reverse) {
            print(d(j))
        }
        
    ...
    
三、List

    1. Nil一个不可变的List
    
        ·println(Nil)
        
    2. 可以使用下面的方式创建一个数组
    
        val l = List(1, 2, 3, 4, 5)
        
    3. 一个List由头和尾两部分组成
    
        println(l.head) // 1
        println(l.tail) // List(2, 3, 4, 5)
        
    4. 以下是Scala创建List的另外一种方式
    
        val l2 = 1 :: Nil
        val l3 = 1 :: 2 :: 3 :: Nil
        
    5. 使用ListBuffer作为变长的List，可以使用其类似数组的方法
    
        al l4 = scala.collection.mutable.ListBuffer[Int]()
        l4 += 1;
        l4 += (2, 3)
        l4 ++= List(4, 5, 6)
        println(l4)     // ListBuffer(1, 2, 3, 4, 5, 6)
        l4 -= 1
        l4 -= (0, 4)
        l4 --= List(5, 6)
        println(l4)     // ListBuffer(2, 3)
        
    6. ListBuffer的转化
    
        println(l4.toList)  // List(2, 3)
        println(l4.toArray) // [I@57829d67
        
    7. 利用head及tail做一个递归计算
    
        // 递归计算首尾相加
        def sum(nums: Int*): Int = {
          if (nums.length == 0) {
            0
          } else {
            nums.head + sum(nums.tail:_*)
          }
        }