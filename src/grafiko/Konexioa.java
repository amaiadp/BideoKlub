package grafiko;

import java.sql.*;
import java.util.ArrayList;
 
public class Konexioa {
 
	private Connection conn;
	private static Konexioa nKonexioa;
	
	
	
	private Konexioa(){
		this.getConnection();
	}

	public static Konexioa getKonexioa(){
		if(nKonexioa== null){
			nKonexioa = new Konexioa();
		}
		return nKonexioa;
	}
	
	
	
    private Connection getConnection(){
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/bideoklub";
            String username = "root";
            String password = "";
            Class.forName(driver);
           
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        }catch(Exception e){System.out.println(e);}
        return null;
    }
   
    public void post(String pAgindu)throws Exception{
            PreparedStatement posted = conn.prepareStatement(pAgindu);
           
            posted.executeUpdate();
           
    }
   
    public ResultSet select(String pAgindua){
        try{
            PreparedStatement statement = conn.prepareStatement(pAgindua);
           
            ResultSet result = statement.executeQuery();
            return result;
           
        }catch (Exception e){}
        return null;
   
       
    }
   
}