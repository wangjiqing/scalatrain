package com.imooc.readresource

import java.sql.{Connection, DriverManager, Statement}

/**
  * 操作MySQL
  */
object MySqlApp {

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
}
