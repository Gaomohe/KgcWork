package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;
    private static int n = 0;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/information";
            String name = "root";
            String password = "gzx123zyl920";
            connection = DriverManager.getConnection(url,name,password);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //查询
    public static ResultSet query(String sql,Object[] obj){
        try{
            preparedStatement = connection.prepareStatement(sql);
            if (obj != null){
                for (int i = 0; i < obj.length; i++) {
                    preparedStatement.setObject(i+1,obj[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }

    //增、删、改
    public static int alter(String sql,Object[] obj){
        try{
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                preparedStatement.setObject(i+1,obj[i]);
            }
            n = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return n;
    }
}
