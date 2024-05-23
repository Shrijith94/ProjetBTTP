import java.sql.*;
import java.util.Scanner;


public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/projetBTTP?useSSL=false";
            Connection connect = DriverManager.getConnection(url,"root","root");

            System.out.println("OK");
            Statement req1 = connect.createStatement ();
            
           Scanner s = new Scanner(System.in);
           s.close();
            
        //     //String aString = "SELECT Numvol FROM vol WHERE VilleDepart =  \"" + ville + "\"";
          String aString = "SELECT * FROM document";

        //    PreparedStatement req2 = connect.prepareStatement (aString) ;
        //   req2.setString(1, ville);
            
         ResultSet res = req1.executeQuery(aString);
        // ResultSet res = req2.executeQuery();
            
            //while(res.next()) {
            	//System.out.println(res.getString("Numvol"));
            //}
            ResultSetMetaData r = res.getMetaData();
            int columnsNumber = r.getColumnCount();
            while (res.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    	String columnValue = res.getString(i);
                    System.out.print(columnValue + " ");
                }
                System.out.println("");
            }          
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    
}
