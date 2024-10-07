/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinhgiang.model;
import java.sql.*;

/**
 *
 * @author dinhgiang1
 */
public class ConnectDB {
    public Connection gConnection(){   
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/Mango_Classroom";
        String user = "root";
        String password = "";

        try {
            conn = DriverManager.getConnection(url,user,password);
            if (conn != null) {
                System.out.println("Ket noi thanh cong!");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return conn;
    }
}
