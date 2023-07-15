/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;
import java.sql.*;
/**
 *
 * @author AAYUSH DHIMAN
 */
public class Conn {
    Connection con=null;
    Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/university?user=root&password=");
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
