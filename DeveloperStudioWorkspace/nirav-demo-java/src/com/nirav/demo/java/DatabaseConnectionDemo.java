package com.nirav.demo.java;

import java.sql.*;

public class DatabaseConnectionDemo { 
	
	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lr7","root","root"); 
			Statement stmt=con.createStatement();  
			
			long id  = 0;
	//ResultSet rs=stmt.executeQuery("SELECT * FROM lr7.cf_project_master WHERE CREATION_DATE BETWEEN  '2019-03-08' = '2019-03-14' ");  
			//ResultSet rs=stmt.executeQuery("SELECT * FROM lr7.cf_project_master where STATUS=2 AND DATE(CREATION_DATE) = DATE('2019-03-14') ");
			/*ResultSet rs=stmt.executeQuery("SELECT * FROM lr7.cf_project_master"
					+ " A LEFT JOIN LR7.cf_project_benificiary_details"
					+ " B ON A.BENIFICIARY_ID = B.BENIFICIARY_ID "
					+ " WHERE A.STATUS=2 OR B.BENIFICIARY_CATEGORY='Myself' ");*/
			//ResultSet rs=stmt.executeQuery("SELECT * FROM lr7.cf_project_master LEFT JOIN LR7.cf_project_benificiary_details ON lr7.cf_project_master.BENIFICIARY_ID = LR7.cf_project_benificiary_details.BENIFICIARY_ID WHERE lr7.cf_project_master.STATUS=2 AND LR7.cf_project_benificiary_details.BENIFICIARY_CATEGORY='Myself' ");
			//ResultSet rs=stmt.executeQuery("SELECT * FROM lr7.cf_project_master where BENIFICIARY_ID = 901 AND STATUS = 2 AND DATE(CREATION_DATE) = DATE('2019-03-08') ");  
			ResultSet rs= stmt.executeQuery("SELECT * FROM lr7.cf_project_master where (STATUS=2) AND (DATE(CREATION_DATE) = DATE('2019-03-01'))  AND ( CREATION_DATE BETWEEN  DATE('2019-03-08') AND DATE('2019-03-14')) "); 
//			ResultSet rs=stmt.executeQuery("SELECT * FROM lr7.cf_user_otp_details");  
			while(rs.next())  {
				id = rs.getLong("PROJECT_ID");
			System.out.println("Nirav :::: " +id);  
			}
			
			con.close();  
						
		}catch(Exception e)
		{ 
			e.printStackTrace();
		}  
	}  
}  