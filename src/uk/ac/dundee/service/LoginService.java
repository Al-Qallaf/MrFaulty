package uk.ac.dundee.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginService {
	
	public User authenticate(String username,String password)
	{
		// this method would connect to the database where I have stored all the username and password and
		// other information, it will pull up the password and the username and compare it with 
		// what we have password and username in DB, to make sure that the authentication has done.
		// JDBC connection over Here
		//if (password == null || password.trim()=="")
		//{
		//	return false;
		//}
		//	return true;
		User success = null;
		try
		{
			if ((password == null || password.trim()=="") || ((username == null || username.trim()=="")))
			{
				success=null;
			}
			else
			{
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			Statement st = null;
			ResultSet rs;
			st=MyConnection.createStatement();
			rs = st.executeQuery("SELECT * FROM mrfaulty.users");
			System.out.println("The entered User is "+username+" The entered Pass is "+password);
			
			while(rs.next())
			{
				System.out.println(rs.getString("first_name") +" "+ rs.getString("last_name"));
				if (username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
				{
					success = new User();
					System.out.println("I'm inside if statment");
					success.setUserId(rs.getInt("iduser"));
					success.setUserName(rs.getString("username"));
					success.setFirst_Name(rs.getString("first_name"));
					success.setLast_Name(rs.getString("last_name"));
					success.setPassword(rs.getString("password"));
					success.setEmail(rs.getString("email"));
					success.setPrivilege(rs.getString("privilege"));
				}
			}
			rs.close();
			MyConnection.close();
			}
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);			
		}
		
		System.out.println("Success is  "+success);
		return success;
	}
	
	
	public boolean adduser(User newUser)
	{
		boolean Success= false;
		int updateQuery = 0;
		try
		{
			//May I check the user here, using id from session
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "INSERT INTO mrfaulty.users (`username`, `first_name`, `last_name`, `password`, `email`, `privilege`) VALUES (?, ?, ?, ?, ?, ?)";
            pstatement = MyConnection.prepareStatement(queryString);
            pstatement.setString(1, newUser.getUserName());
            pstatement.setString(2, newUser.getFirst_Name());
            pstatement.setString(3, newUser.getLast_Name());
            pstatement.setString(4, newUser.getPassword());
            pstatement.setString(5, newUser.getEmail());
            pstatement.setString(6, newUser.getPrivilege());
            updateQuery = pstatement.executeUpdate();
            if (updateQuery != 0)
            	System.out.println("User Data inserted successfully in database.");
            
			MyConnection.close();
			Success = true;
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);
				Success = false;
		}
		
		return Success;
	}

	public boolean deleteuser(int UserId)
	{
		boolean isdeleted=false;
		try
		{
			//May I check the user here, using id from session
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "delete FROM mrfaulty.users where `iduser` = ? ";
            pstatement = MyConnection.prepareStatement(queryString);
            pstatement.setInt(1, UserId);
            isdeleted = pstatement.execute();
            System.out.println("The Data Deleted faultid = "+ UserId +" isdeleted is "+ isdeleted);
            
            MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);			
		}
		
		return isdeleted;
	}


	
	public static ArrayList<User> ListUserType(String UserType)
	{
		 ArrayList<User> listoffUserType = new ArrayList<User>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "SELECT * FROM mrfaulty.users where `privilege` = ? ";
            pstatement = MyConnection.prepareStatement(queryString);
            pstatement.setString(1, UserType);
            ResultSet rs;

            rs = pstatement.executeQuery();
            User user;
            
            while (rs.next())
            {
            	user= new User();
				user.setUserId(rs.getInt("iduser"));
				user.setUserName(rs.getString("username"));
				user.setFirst_Name(rs.getString("first_name"));
				user.setLast_Name(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPrivilege(rs.getString("privilege"));
				
				System.out.println("The Data quired"); 
            	listoffUserType.add(user);
            	
            }
            
            rs.close();
            MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);			
		}
		
		return listoffUserType;  
	}
	

	public static User queryByUserId(int UserId)
	{
		User user = null;
		try
		{
			//May I check the user here, using id from session
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "SELECT * FROM mrfaulty.users where `iduser` = ? ";
            pstatement = MyConnection.prepareStatement(queryString);
            pstatement.setInt(1, UserId);
            ResultSet rs;
            rs = pstatement.executeQuery();
       
            while (rs.next())
            {
            	user= new User();
            	user.setUserId(UserId);
            	user.setUserName(rs.getString("username"));
            	user.setFirst_Name(rs.getString("first_name"));
            	user.setLast_Name(rs.getString("last_name"));
            	user.setEmail(rs.getString("email"));
            	user.setPrivilege(rs.getString("privilege"));
            }
            
            rs.close();
            MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error " + e);			
		}
		
		
		return user;  
	}
	
	
	//public static User getUserDetails(String username) // the module is actually the object that we gona pass, and this
	//{											// object(User) in real world scenario comes from the DB.
	//	User user= new User();
	//	user.setUserName(username);
	//	//user.setPassword(password);
	//	return user;
	//}
}
