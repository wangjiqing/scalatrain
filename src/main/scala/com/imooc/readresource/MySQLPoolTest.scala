package com.imooc.readresource

import com.imooc.readresource.DBConnectionPool.getConn

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
