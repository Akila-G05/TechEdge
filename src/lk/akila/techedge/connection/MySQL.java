/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.akila.techedge.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
    
    private static Connection connection;
    private static final String user = "root";
    private static final String password = "akila@2005";
    private static final String DB_name = "techedge" ;
    
    public static Connection getConnection() throws SQLException{
        
        try {
            if(connection == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB_name, user, password);
            }
            return connection;
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("MySQL Connection Faild....!");
        }
        
    } 
    
    public static void iud(String query){
        try {
            getConnection().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ResultSet search(String query) throws SQLException{
        return getConnection().createStatement().executeQuery(query);
    }
    
}
