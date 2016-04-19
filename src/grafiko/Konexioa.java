package grafiko;

import java.sql.*;
import java.util.ArrayList;
 
public class Konexioa {
 
    public static void main(String[] args) throws Exception{
        getConnection();
        post();
        select();
    }
   
    public static Connection getConnection() throws Exception{
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/database";
            String username = "hey";
            String password = "mypass";
            Class.forName(driver);
           
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        }catch(Exception e){System.out.println(e);}
        return null;
    }
   
    public static void post() throws Exception{
        final String var1 = "john";
        final String var2 = "miller";
        try {
            Connection conn = getConnection();
            PreparedStatement posted = conn.prepareStatement("INSERT INTO table (first, last) VALUES ('"+var1+"', '"+var2+"')");
           
            posted.executeUpdate();
           
        }catch(Exception e){System.out.println(e);}
        finally{
            System.out.println("Insert Completed");
        }
    }
   
    public static ArrayList<String> select() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT first, last FROM table");
           
            ResultSet result = statement.executeQuery();
           
            ArrayList<String> array = new ArrayList<String>();
            while(result.next()){
                System.out.print(result.getString("first"));
                System.out.print(("    "));
                System.out.println(result.getString("last"));
               
               
                array.add(result.getString("last"));
               
            }
            System.out.println("All records have been selected");
            return array;
        }catch (Exception e){System.out.println(e);}
        return null;
   
       
    }
   
}