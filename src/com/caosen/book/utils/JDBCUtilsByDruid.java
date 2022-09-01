package com.caosen.book.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author Caosen
 * @Date 2022/7/5 15:19
 * @Version 1.0
 */
public class JDBCUtilsByDruid {
    private static DataSource dataSource;
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("E:\\item\\java_pro\\bookstore\\src\\jdbc.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
