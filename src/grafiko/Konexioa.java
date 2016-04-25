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
 //       try {
            PreparedStatement posted = conn.prepareStatement(pAgindu);
           
            posted.executeUpdate();
           
//        }catch(Exception e){System.out.println(e);}
    }
   
    public ResultSet select(String pAgindua){
        try{
            PreparedStatement statement = conn.prepareStatement(pAgindua);
           
            ResultSet result = statement.executeQuery();
            return result;
           
//           	ArrayList<String> array = new ArrayList<String>();
//            while(result.next()){
//                System.out.print(result.getString("first"));
//                System.out.print(("    "));
//                System.out.println(result.getString("last"));
//               
//               
//                array.add(result.getString("last"));
//               
//            }
//            System.out.println("All records have been selected");
//            return array;
        }catch (Exception e){System.out.println(e);}
        return null;
   
       
    }
   
}