/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library_management;

/**
 *
 * @author jyoti
 */
import java.sql.*;

public class Conn {
	Connection c;
	Statement s;

	public Conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //
			c = DriverManager.getConnection("jdbc:mysql://localhost/library_management_system","root","root");
			s = c.createStatement();
			
		} catch(Exception e) {
			System.out.println(e.getMessage()); 
		}
	}
	
}

