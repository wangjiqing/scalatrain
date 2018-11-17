package com.imooc.readresource

import java.sql.{Connection, DriverManager}
import java.util.{LinkedList, ResourceBundle}

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
