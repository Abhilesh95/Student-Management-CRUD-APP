package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	public static boolean insertStudentToDB(Student st) {
		
		boolean flag=false;
		try {
			//jdbc code
			Connection con=CP.createC();
			String q="insert into students(sname,sphone,scity) values(?,?,?)";
			//prepred statement
			
			PreparedStatement pstmt=con.prepareStatement(q);
			//set the values of the parameter
			pstmt.setString(1,st.getStudentName());
			pstmt.setString(2,st.getStudentPhone());
			pstmt.setString(3,st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			
			flag=true;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public static boolean deleteStudent(int userid) {

		boolean flag=false;
		try {
			//jdbc code
			Connection con=CP.createC();
			String q="delete from students where sid=?";
			//prepred statement
			
			PreparedStatement pstmt=con.prepareStatement(q);
			//set the values of the parameter
			pstmt.setInt(1,userid);
			
			//execute
			pstmt.executeUpdate();
			
			flag=true;
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	public static void showAllStudents() {
	
		try {
			//jdbc code
			Connection con=CP.createC();
			String q="select * from students";
			// static statement
			
			Statement stmt=con.createStatement();
			ResultSet set=stmt.executeQuery(q);
			
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				String city=set.getString(4);
				
				System.out.println("id:"+id+" " +"name:"+name+" "+"phone:"+phone+" "+"city:"+city);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean updateStudent(Student st,int sid) {
		//update student with the help of provided id
		boolean flag=false;
		try {
			Connection con=CP.createC();
			String query = "update students set sname=?, sphone=?,scity=? where sid=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			//set the values of parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			pstmt.setInt(4, sid);
			
			//execute
			pstmt.executeUpdate();
			flag=true;
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag;
		}
	}



















