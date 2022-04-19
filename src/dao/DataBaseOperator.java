package dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import dao.DataBaseOperator;
import domain.Userdata;
import jlujee.servlet.Student;

public class DataBaseOperator {
	Connection conn = null;
	static DataBaseOperator instance = null;
	DataBaseOperator() 
	{
		init();
	}
	void init() 
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/servlet"; 
		    String user="root";
			String password="271828";
			conn=DriverManager.getConnection(url,user,password);
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
	public static DataBaseOperator getInstance()
	{
		if(instance == null)
			instance = new DataBaseOperator();
		return instance;
	}
	public void insert(Userdata ud)
	{
		try {
			String username=ud.Get_Username();
			String password=ud.Get_Password();
			String sql = "insert into userdata(username,password)"
							+ " values('"+username+"','"+password+"');";
			//System.out.println(sql);
	      	Statement stat=null;
			stat=conn.createStatement();
			stat.executeUpdate(sql); 
			if(stat!=null){
		    	   stat.close();
		    }			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Userdata search(String un, String pw) throws SQLException
	{
		Statement stat=null;
	    ResultSet rs=null;
		stat=conn.createStatement();
		String uname=un;
		String pword=pw;
    	if(uname==null) uname ="";
    	if(pword==null) pword ="";
      	rs=stat.executeQuery("select * from userdata where username="+uname+" and password='"+pword+"'"); 
      	Userdata ud = new Userdata();
    	if(rs.next())
        {
        	
        	ud.Set_Password(rs.getString("password"));
        	ud.Set_Username(rs.getString("username"));
    	    if(rs!=null){
  	    	  rs.close();
  	       }
  		if(stat!=null){
  	    	   stat.close();
  	    }
		return ud;
        }
    	else {
    		return null;
    	}


	}
}
