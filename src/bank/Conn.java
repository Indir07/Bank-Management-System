package Bank;

import java.sql.*;   

public class Conn{
//    String Driver = "com.mysql.cj.jdbc.Driver";
    Connection con;
    Statement s;
   
    public Conn() {  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");    
            con =DriverManager.getConnection("jdbc:mysql://localhost/bankmanagementsystem","root","Mathematics99@");    
            s = con.createStatement();
           
         
        }catch(Exception e){ 
            System.out.println(e);
        }
  
    }
}
