package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import java.sql.ResultSet;
//import java.sql.Statement;


public class DbConnector {
	
	String url = "jdbc:mysql://localhost:3306";
    //String login = "root";
    //String passwd = "doliprane";
    Connection cn =null;
    Statement st =null;
	//public static Statement myStmt;
	//public Connection myConn=null;
	
	

	public DbConnector(String log,String pass) {
		try{
			
			cn = DriverManager.getConnection(url,log,pass);
			
			st = cn.createStatement();

			/*if(cn == null) {
				
				System.out.println("Connection not successful");
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Validate Mail");
				alert.setHeaderText(null);
				alert.setContentText("Connection not successful");
				alert.showAndWait();
			
			}
			else{
					System.out.println("Connection successful");
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Validate Mail");
					alert.setHeaderText(null);
					alert.setContentText("Connection successful");
					alert.showAndWait();
					
			}*/
			//setMyStmt(cn.createStatement());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}



	public Connection getCn() {
		return cn;
	}



	public void setCn(Connection cn) {
		this.cn = cn;
	}

}
