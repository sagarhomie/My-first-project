package bankmanagement;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","talaiknachayo");
            s= c.createStatement();
            
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
