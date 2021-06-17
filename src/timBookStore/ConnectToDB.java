package timBookStore;

import java.sql.*;
import javax.swing.*;

public class ConnectToDB {
	//Connection con = null;
	public static final String URL ="jdbc:mysql://localhost:3306/timbookstore";
	public static final String USER = "root";
	public static final String PASSWORD = "jy0023";
	public static Connection dbConnerctor() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection(URL,USER,PASSWORD );
			//JOptionPane.showMessageDialog(null, "connect to DataBase Successful!");
			return con;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;	
		}
		
	}
}
