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

    1. 同Java一样，继承时当调用子类构造器之前，需要先调用父类的构造器
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
    
三、List (collection)

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
        
四、Map (collection)

    1. 创建一个map
    
        var m = Map("Alice" -> 1, "Bob" -> 3, "Mike" -> 6)
        
    2. 向Map中追加一个kv
    
        m+=("Ann" -> 8)
        
    3. 追加一个Map
    
        m++=Map("Ant" -> 5, "Dob" -> 6)
        
    4. 打印所有的key
    
        println(m.keys)
        println(m.keySet)
        
    5. 移除一个kv
    
        m-=("Ann")
        
    6. 取值
    
        println(m get "Bob")  // Some(3)
        println(m("Bob"))     // 3
     
    7. 遍历
    
        for (kv <- mm) {
          print(kv)         // (one,1)(three,3)(four,4)(two,2)
          print(kv._1 + " " + kv._2 + " | ")    // one 1 | three 3 | four 4 | two 2 |
        }
        
    ...
    
五、 Option&Some&None (option)

    1. 避免null的使用
    
        大多数语言都有一个特殊的关键字或者对象来表示一个对象引用的是“无”，在Java中，它是null。Java语言中，null是一个关键字，不是一个对象，
        所以对它调用任何方法都是非法的。但是这对语言设计者来说是一件令人困惑的选择：为什么要在程序员希望返回一个对象的时候返回一个关键字呢？
        
    2. Option
    
        为了让所有事物都是对象的目标一致，也为了遵循函数式编程的习惯，Scala鼓励在变量或函数返回值可能不会引用任何值的时候使用Option类型。
        
    3. None
    
        在没有值的时候，使用None，这是Option的子类。None被声明为一个对象，而不是一个类，因为我们只需要它的一个实例。这样它多少有点像null关键
        字，但是它却是一个实实在在的，有方法的对象。
        
    4. Some
    
        如果有值的时候就是用Some来包含这个值，Some也是Option的子类
        
    5. 应用举例
    
        Option类型的值通常作为Scala集合类型（List、Map等）操作的返回类型。比如Map的get方法
        
        val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo", "China" -> "Beijing")
        println(capitals get "China")     // Some(Beijing)
        println(capitals.get("North Pole")) // None
        
    6. Option有两个子类别，Some和None。当程序回传Some的时候，代表这个函数式成功的给了你一个String，然后我们可以通过get()函数得到这个
       String。如果程序返回的是None，则代表没有字符串可以返回。
       
    7. 在返回None，也就是没有String给你的时候，如果还调用get()来取String的话，Scala一样会抛出异常（NoSuchElementException）。为了避免
       这个异常，可以选择另外的方法getOrElse。这个方法在Option是Some的实例时返回对应的值，而Option时None的时候返回传入的参数。换句话说，传
       入getOrElse的参数实际上时默认返回值。
       
       // 没有值调用的时候依旧会抛出异常
       println(capitals get "North Pole" get) // Exception
       // Scala推荐使用getOrElse方法，设置一个默认值，没有值返回的时候使用默认值作为返回值
       println(capitals get "North Pole" getOrElse "Oops") // Oops
       println(capitals.get("China").getOrElse("Oops"))    // Beijing
       
    8. Scala程序中使用Option非常频繁，在Java中使用null表示空值，代码中很多地方都要添加null关键字检测，不然很容易出现NullPointException。
       因此 Java 程序需要关心那些变量可能是 null,而这些变量出现 null 的可能性很低，但一但出现，很难查出为什么出现 NullPointerException。 
       Scala 的 Option 类型可以避免这种情况，因此 Scala 应用推荐使用 Option 类型来代表一些可选值。使用 Option 类型，读者一眼就可以看出这
       种类型的值可能为 None。
       实际上，多亏 Scala 的静态类型，你并不能错误地尝试在一个可能为 null 的值上调用方法。虽然在 Java 中这是个很容易犯的错误，它在 Scala 
       却通不过编译，这是因为 Java 中没有检查变量是否为 null 的编程作为变成 Scala 中的类型错误（不能将 Option[String] 当做 String 来使
       用）。所以，Option 的使用极强地鼓励了更加弹性的编程习惯。
       
    9. 详解Option
    
        在Scala中Option[T]实际上是一个容器，就像数组或者List一样，可以把它看作时可能有零个到一个的元素Lis。t当你的 Option 里面有东西的时
        候，这个 List 的长度是 1（也就是 Some），而当你的 Option 里没有东西的时候，它的长度是 0（也就是 None）。
        如果把 Option 当成一般的 List 来用，并且用一个 for 循环来遍历这个 Option 的时候，如果 Option 是 None，那这个 for 循环里的程序
        代码自然不会执行，于是我们就达到了「不用检查 Option 是否为 None 这件事。
        
六、Tuple元组 (tuple)

    1. 与列表一样，Tuple（元组）也是不可变的，但与列表不同的是Tuple可以包含不同类型的元素，Tuple的值是通过将单个的值包含在圆括号中构成的。
       例如：
       
        val t = (1, 3.14, "Fred")
        val tn = new Tuple3(1, 3.14, "Fred")
            
    2. Tuple的实际类型取决于它的元素的类型（由于Scala的类型自动推导）。目前Scala支持的元组类型最大长度为22.对于更大长度可以使用集合，或者扩展
       Tuple。   
       
    3. 访问Tuple元素
    
        val tx = (4, 3, 2, 1)
        val sum = tx._1 + tx._2 + tx._3
        println(sum)    
           
    4. 迭代Tuple
    
        tx.productIterator.foreach{
          i => print("value = " + i + " | ")    // value = 4 | value = 3 | value = 2 | value = 1 | 
        }
    
    5. Tuple转化为字符串
    
        val ts = (1, "hello", Console)
        println(ts.toString())
        
    6. Tuple元素交换
    
        val tm = new Tuple2("www.baidu.com", "www.google.com")
        println(tm.swap) 
        
<h3> 1.4 Scala中的模式匹配 (matchpa/exception)</h3>

一、最基础的模式匹配

    同Java类似的的switch case语句类似，对一个值进行条件判断，返回针对不同的条件进行不同处理的代码逻辑，代码格式如下：
        
        变量 match {
            case value1 => 代码1
            case value2 => 代码2
            ...
            case _ => 代码N 
        }
        
二、 加条件进行匹配

    可以在case语句中使用if条件语句，例如：
    
        def judgeGrade(score: Int) = {
          score match {
            case score if (score <= 100 && score > 90) => println("A")
            case score if (score <= 90 && score > 75) => println("B")
            case score if (score <= 75 && score > 60) => println("C")
            case score if (score <= 60) => println("C")
            case _ => println("分数不正确")
          }
        }
        
三、Array模式匹配

    可以在case语句中使用Array，例如：
    
        def courses(array: Array[String]): Unit = {
          array match {
            case Array("math") => println("今天只有一节课是math")
            case Array("math", _*) => println("今天第一节课是math，总共有" + array.length + "节课")
            case Array(x, y) => println("今天有 " + array.length + "节课," )
            case _ => println("课程走丢了")
          }
        }
        
        courses(Array("math"))
        courses(Array("math", "english"))
        courses(Array("math", "english", "history"))
        courses(Array("hehe"))
        
四、List模式匹配

    可以在case语句中使用List，例如：
    
        def courses(list: List[String]) = {
          list match {
            case "math" :: Nil => println("今天只有一节课是math")
            case x :: y :: Nil => println("今天有" + list.size + "节课")
            case "english" :: tail => println("今天第一节课是English，共" + list.size + "节课")
            case _ => println("课程走丢了")
          }
        }
        
        courses(List("math"))
        courses(List("history", "math"))
        courses(List("english", "history", "math"))
        courses(List("bbb"))
        
五、类型匹配

    Scala还有一个强大的功能，可以使用类型匹配，例如：
    
       def matchType(N: Any): Unit ={
         N match {
           case x: Int => println("Int")
           case s: String => println("String")
           case m: Map[_, _] => m.foreach(print)
           case _ => println("other")
         }
       }
       
       matchType(1)
       matchType("Hello")
       matchType(Map(1 -> "one", 2 -> "two"))
       matchType(1L)
       
六、Scala异常处理

    Scala中用作异常处理的语句如下：
    
        try {
          val i = 10 / 0
          println(i)
        } catch {
          case ea: ArithmeticException => println("除数为0的异常: " + ea.getMessage)
          case e: Exception => println(e.getMessage)
        } finally {
          // 最终执行的代码，用于释放资源等
        }
        
七、case class模式匹配

    case class主要用于模式匹配，例如：
    
        abstract class Person
        case class CTO(name: String) extends Person
        case class Emp(name: String) extends Person
        case class Other(name: String) extends Person
        
        def caseClassMatch(person: Person): Unit = {
          person match {
            case CTO(name) => println("CTO is " + name)
            case Emp(name) => println("Emp have " + name)
            case Other(name) => println("Other have " + name)
          }
        }
        
        caseClassMatch(CTO("WJQ"))
        caseClassMatch(CTO("ZS"))
        caseClassMatch(CTO("AS"))
        
八、Some None模式匹配

    Option[T]是Scala为了摆脱null这个问题，设计出来的，Option[T] 是一个类型为 T 的可选值的容器： 如果值存在， Option[T] 就是一个 
    Some[T] ，如果不存在， Option[T] 就是对象 None 。这里我们遍历一个map，使用模式匹配：
    
        val curse = Map("Java" -> "one", "C++" -> "two", "Ruby" -> "three", "Python" -> null)
        def show(value: Option[String]): Unit = {
          value match {
            case Some(x) => println(x)
            case None => println("This language is null!")
          }
        }
        
        println(curse.get("Python"))  // Some(null)
        
        show(curse.get("Java"))       // one
        show(curse.get("Python"))     // null
        
<h3> 1.5 Scala函数中的高级操作 (highoperation)</h3>

一、字符串高级操作
    
     1. 多行字符串操作，使用键盘上的shift + 双引号，按三次，然后回车
     
        val b =
          """
            |这是一个多行字符串
            |hello
            |world
          """.stripMargin
        
        println(b)
        
     2. Interpolation（字符串插值）：使用s"xxx $xxx" 进行字符串连接，插入等操作
     
        val name = "WJQ"
        println(s"Hello:$name")                     // Hello:WJQ
        
        val team = "AC"
        println(s"Hello:$name, Welcome to $team")   // Hello:WJQ, Welcome to AC
        
二、匿名函数

    匿名函数通常特点如下：
    1）没有名字
    2）使用 “=>”
    实例如下：
    
    val a = (x: Int, y: Int) => x + y
    println(a(2, 3))        // 5
    
    val b = (x: String, y: String) => {
      s"=====> $x =====> $y"   // =====> hello =====> world
    }
    println(b("hello", "world"))
    
三、currying函数

    柯里化（Currying）是把接受多个参数的函数变换成接受一个单一参数(最初函数的第一个参数)的函数，并且返回接受余下的参数且返回结果的新函数的技术。
    
        def sum(a: Int, b: Int) = a + b
        println(sum(2, 3))
        
        def sum2(a: Int)(b: Int) = a + b
        println(sum2(2)(3))
        
四、高阶函数（Scala中的重点内容）

    1. map 将集合中的每个元素作用上一个函数（使用相同的函数操作集合上的每个元素）
    
        val l = List(1, 2, 3, 4, 5, 6, 7, 8)
        val l2 = l.map((x: Int) => x * 2)
        println(l2)   // List(2, 4, 6, 8, 10, 12, 14, 16)
        val l3 = l.map(x => x * 2)
        println(l3)   // List(2, 4, 6, 8, 10, 12, 14, 16)
        val l4 = l.map(_ * 2)
        println(l4)   // List(2, 4, 6, 8, 10, 12, 14, 16)
        
    2. filter 用来过滤集合中的元素
    
        println(l4.filter(_ > 8))   // List(10, 12, 14, 16)
        println(l4.filter(x => x > 8))
        
    3. take 取得集合中的前几个元素
    
        println(l take 4)
        println(l.take(4))
        
    4. reduce 将集合中的元素依次相加
        
        println(l.reduce(_ + _))              // 36
        println(l.reduce((x, y) => x + y))    // 36
        
    5. reduceLeft 集合中的元素从左向右依次执行函数
    
        println(l.reduceLeft((x, y) => x - y))  // -34
        println(l.reduceLeft(_ - _))            // -34
        println(l.reduceLeft(_ min _))  // 集合中元素从左到右比较得到最小值
        println(l.reduceLeft((x, y) => x min y))  // 集合中元素从左到右比较得到最小值
        println(l.reduceLeft(_ max _))  // 集合中元素从左到右比较得到最大值
        println(l.reduceLeft((x, y) => x max y))  // 集合中元素从左到右比较得到最大值
        
    6. reduceRight 集合中的元素按照 (1 - (2 - (3 - (4 - (...)))))的方式执行
    
        println(l.reduceRight(_ - _))   // -4
        println(l.reduceRight((x, y) => x - y)) // -4
        
    7. fold 手动添加1个元素（柯里化函数中的第一个参数）与集合中的每个元素做函数操作
    
        println(l.fold(36)(_ - _))    // 36 - ((((1 - 2) - 3) - 4) - 5) ... = 0
        println(l.foldLeft(-1)(_ min _))  // -1
        println(l.foldRight(10)(_ max _)) // 10
        println(l.foldRight(4)(_ - _))    // 4 + (1 - (2 - (3 - (4 - (5 - (6 -(7 - 8)))))))   // 0
        
    8. flatten 压缩多层集合为一层集合
    
        val f = List(List(1, 2), List(3, 4), List(5, 6))
        println(f.flatten)            // List(1, 2, 3, 4, 5, 6)
        
    9. map 对集合中的每个元素执行函数
    
        println(f.map(_.map(_ * 2)))  // 两层Map使用两层Map计算 List(List(2, 4), List(6, 8), List(10, 12))
        
    10. flatMap 计算并压缩（flatMap = flatten + map的操作）
    
        println(f.flatMap(_ map (_ * 2))) // List(2, 4, 6, 8, 10, 12)
        
五、偏函数 （https://www.cnblogs.com/MOBIN/p/5326994.html）

    1. Scala-Partial Functions：定义一个函数，只能接受和处理其参数定义域范围内的子集，对于这个参数范围外的参数则抛出异常，这样的函数
       就是偏函数（可以这么理解：偏函数只处理传入来的部分参数）。
       
    2. 偏函数的类型为PartialFunction[A, B]，其中接收一个类型为A的参数，返回一个类型为B的结果。其中有个重要的函数就是：
        
        def isDefinedAt(x: A): Boolean // 判断传入来的参数是否在这个偏函数所处理的范围内
    
        定义一个普通的除法函数
        
        val divide = (x: Int) => 100 / x
        divide(0)     // exception
        
        显然，当我们将0作为参数传入时会报错，一般的解决办法就是使用try/catch来捕捉异常或者对参数进行判断看其是否等于0;但是在Scala的偏
        函数中这些都已经封装好了，如下：将divide定义成一个偏函数：
        
        val divide = new PartialFunction[Int, Int] {
          	override def isDefinedAt(x: Int): Boolean = x != 0  // 判断x是否等于0，当x=0时抛出异常
        def apply(x: Int): Int = 100 / x
        }	
        
        println(divide(0))
        
        偏函数与case语句结合起来就能使代码更简洁
        
        val divide1 : PartialFunction[Int, Int] = {
          	case d: Int if d != 0 => 100 / d
        }
        
        println(divide1(0))
        
        下面代码就是对上面那段代码的封装，这里同样调用isDefinedAt方法
        
        scala> divide1.isDefinedAt(0)
        res1: Boolean = false
        
        scala> divide1.isDefinedAt(10)
        res2: Boolean = true
        
    3. 使用OrElse方法可以将多个偏函数组合起来使用，结合起来的效果类似于case语句，每个偏函数里又可以再使用case
    
        scala> val or1: PartialFunction[Int, String] = {case 1 => "One"}
        or1: PartialFunction[Int,String] = <function1>
        
        scala> val or2: PartialFunction[Int, String] = {case 2 => "two"}
        or2: PartialFunction[Int,String] = <function1>
        
        scala> val or3: PartialFunction[Int, String] = {case 3 => "three"}
        or3: PartialFunction[Int,String] = <function1>
        
        scala> val or = or1 orElse or2 orElse or3
        
        scala> or(1)
        res1: String = One
        
        scala> or(2)
        res2: String = two
        
        scala> or(3)
        res3: String = three
        
    4. andThen 对函数的结果进行下一步的处理
    
<h3> 1.6 Scala中的隐式转换 (implicitop)</h3>

一、隐式转换的概述

    为一个已存在的类添加一个新的方法（不改变其内容），如果使用Java的话，可以使用动态代理，在Scala中使用隐式转换来实现
   
二、实例

    实例： 
    
        object ImplicitApp extends App {
        
          // 定义隐式转换函数
          implicit def man2superman(man: Man): SuperMan = new SuperMan(man.name)
          val man = new Man("WJQ")
          man.fly()
        
          // 增强java.io.File类
          implicit def file2RichFile(file: File): RichFile = new RichFile(file)
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
    
三、隐式转换切面的封装

    代码ImplicitAspect：
    
        object ImplicitAspect extends App {
        
          implicit def man2superman(man: Man): SuperMan = new SuperMan(man.name)
          implicit def file2RichFile(file: File): RichFile = new RichFile(file)
        }
        
    代码ImplicitApp：
    
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
        
四、隐式参数

    指的是在函数或者方法中，定义一个用implicit修饰的参数，此时Scala会尝试找到一个指定类型的，用implicit修饰的对象，即隐式值，并注入
    参数
    
       def testParam(implicit name: String): Unit = {
           println(s"$name ~~~~~~~")
         }
         // 主动传入参数，按照传入参数操作
         testParam("zhangsan")
       
         // 这里是隐式参数
         implicit val name = "implicit_name"
         testParam
       
         // 声明了隐式参数，也可以自动重新覆盖
         testParam(name = "WJQ")
       
         // 作用域中出现两个implicit修饰的值时是不允许的
       //  implicit val s1 = "s1"
       //  implicit val s2 = "s2"
       //  testParam
       
五、隐式类

     是对类增加implicit限定的类，其作用主要是对类的加强
     
        object ImplicitClassApp extends App {
        
          implicit class Calculator(x: Int) {
            def add(a: Int) = a + x
          }
        
          println(1.add(2))
        
          // implicit 修饰的类参数是Int，不能使用字符串.add()方法
        //  "1".add(2)
        }
        
<h3> 1.7 Scala读取外部资源 (readresource)</h3>

一、Scala读取文件及网络数据

    1. 读取文本文件内容
    
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
        
    2. 读取网络上的内容
    
        // 读取网络上的内容
        def readNet(): Unit = {
          val file = Source.fromURL("https://www.baidu.com")
          for (elem <- file.getLines()) {
            println(elem)
          }
        }
        
        readNet()
        
二、Scala读取MySQL数据

    1. 普通方式操作MySQL
    
        def main(args: Array[String]): Unit = {
          val url = "jdbc:mysql://192.168.177.129:3306/test"
          val username = "root"
          val password = "chang"
        
          var connection: Connection = null
          var statement: Statement = null
          try {
            // 此处单机时不写是没有问题的，但是在分布式环境下建议还是协商
            classOf[com.mysql.jdbc.Driver]
        
            connection = DriverManager getConnection(url, username, password)
            statement = connection.createStatement()
        
            val resultSet = statement.executeQuery("select * from user")
            while (resultSet.next()) {
              val id = resultSet.getInt("id")
              val name = resultSet.getString("name")
              val sex = resultSet.getString("sex")
        
              println(s"id = $id, name=$name, sex=$sex")
            }
          } catch {
            case exception: Exception => exception.printStackTrace()
          } finally {
            if (connection != null) {
              connection.close()
            }
            if (statement != null) {
              statement.close()
            }
          }
        }
        
    2. 封装数据库连接池操作MySQL
        
        /**
          * 数据库连接池工具类
          */
        object DBConnectionPool {
        
          private val reader = ResourceBundle.getBundle("connection")
          private val max_connection = reader.getString("mysql.max_connection")
          private val connection_num = reader.getString("mysql.connection_num")
          private var current_num = 0   // 当前数据库中已经产生的连接数
          private val pools = new LinkedList[Connection]()  // 连接池
          private val driver = reader.getString("mysql.driver")
          private val url = reader.getString("mysql.url")
          private val username = reader.getString("mysql.username")
          private val password = reader.getString("mysql.password")
        
          /**
            * 加载驱动
            */
          private def before(): Unit = {
            if (current_num > max_connection.toInt && pools.isEmpty) {
              print("busyness")
              Thread.sleep(2000)
              before()
            } else {
              Class.forName(driver)
            }
          }
        
          /**
            * 获得连接
            * @return
            */
          private def initConn(): Connection = {
            val conn = DriverManager.getConnection(url, username, password)
            conn
          }
        
          /**
            * 初始化连接池
            * @return
            */
          private def initConnectionPool(): LinkedList[Connection] = {
            AnyRef.synchronized({
              if (pools.isEmpty()) {
                before()
                for (elem <- 1 to connection_num.toInt) {
                  pools.push(initConn())
                  current_num += 1
                }
              }
              pools
            })
          }
        
          /**
            * 获得连接
            * @return
            */
          def getConn(): Connection = {
            initConnectionPool()
            pools.poll()
          }
        
          /**
            * 释放连接
            * @param conn
            */
          def releaseConn(conn: Connection): Unit = {
            pools.push(conn)
          }
        }
        
        /**
          * 测试数据库连接池的使用
          */
        object MySQLPoolTest extends App {
          val conn = getConn()
          val stat = conn.createStatement()
          val resultSet = stat.executeQuery("select * from user")
          while (resultSet.next()) {
            val id = resultSet.getInt("id")
            val name = resultSet.getString("id")
            val sex = resultSet.getString("sex")
            println(s"id = $id, name=$name, sex=$sex")
          }
          DBConnectionPool.releaseConn(conn)
        }
        
        
三、Scala读取XML文件

    代码举例
    
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
        
          loadXml2()
          
四、Scala读取XML属性内容

    读取xml文件属性
    
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
          
五、Scala读取JSON文件

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

六、Scala提供Rest接口及调用Rest接口

    （待完善）