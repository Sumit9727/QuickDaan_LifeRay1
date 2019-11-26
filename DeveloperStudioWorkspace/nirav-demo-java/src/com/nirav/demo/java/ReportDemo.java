package com.nirav.demo.java;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportDemo {

	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lr7","root","root"); 
			Statement stmt=con.createStatement();  
			
			long id  = 0;
			ResultSet rs = null;
			String selectCause = "Food";
			String selectBeneficieryCategory = "Family";
			
		
			
			if(selectCause.isEmpty() == false && selectBeneficieryCategory.isEmpty() == false) {
			rs=stmt.executeQuery
					("SELECT * FROM lr7.cf_project_benificiary_details where BENIFICIARY_CATEGORY = 'Family' AND CAUSE_DETAILS = 'Medical' ");  
			}
			/*if(selectCause.isEmpty() == false) {
				rs=stmt.executeQuery
						("SELECT * FROM lr7.cf_project_benificiary_details where CAUSE_DETAILS = 'Medical' ");
			}
			if(selectBeneficieryCategory.isEmpty() == false) {
				rs=stmt.executeQuery
						("SELECT * FROM lr7.cf_project_benificiary_details where BENIFICIARY_CATEGORY = 'Family' ");
			}*/
			
			String selectStatus = "2";
			String campaignStartDate = "2019-03-14";
			
			long projectIdArray[] = {1101,1303};
			int counter = 0; 
			
			while(rs.next())  {
				id = rs.getLong("BENIFICIARY_ID");
			System.out.println("Nirav ID  :::: " +id);  
			}
			
			for(int i = 0; i<=projectIdArray.length ; i++) {
				System.out.println("Nirav :::: " + projectIdArray[i]);
			}
				
			
			con.close();  
						
		}catch(Exception e)
		{ 
			e.printStackTrace();
		}  
	}  

}
