package OrangeHrmDB;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class GetDataFromOrangeHRM {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		String dburl,uid,pwd,sqlquery;
		
		dburl = "jdbc:mysql://orangehrm.qedgetech.com:3306//database=orangehrm2019";
		
		uid = "Admin";
		
		pwd = "Qedge123!@#";
		
		sqlquery = "select max(emp_number) from hs_hr_employee";
		
		Connection dbcon;
		
		dbcon = (Connection) DriverManager.getConnection(dburl, uid, pwd);
		
		Statement stmt = (Statement) dbcon.createStatement();
		
		ResultSet rs = (ResultSet) stmt.executeQuery(sqlquery);
		
		rs.next();
		
		int maxempno = rs.getInt(1);
		
		System.out.println(maxempno);
		
		rs.close();
		
		dbcon.close();
		
		
		
		
		
		
		
		
		
	}

}
