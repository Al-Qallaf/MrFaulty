package uk.ac.dundee.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class FaultService {
	public boolean insert(Fault newFault)
	{
		int updateQuery = 0;
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "INSERT INTO mrfaulty.faults (`iduser`, `project`, `release`, `summary`, `details`, `state`) VALUES (?, ?, ?, ?, ?, ?)";
            pstatement = MyConnection.prepareStatement(queryString);
            pstatement.setInt(1, newFault.getUserid());
            pstatement.setString(2, newFault.getProject());
            pstatement.setString(3, newFault.getRelease());
            pstatement.setString(4, newFault.getSummary());
            pstatement.setString(5, newFault.getDetails());
            pstatement.setString(6, newFault.getState());
            updateQuery = pstatement.executeUpdate();
            if (updateQuery != 0)
            
            
			MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);			
		}
		
		
		return true;
	}

	public static ArrayList<Fault> queryByUserId(int UserId)
	{
		 ArrayList<Fault> listoffaults = new ArrayList<Fault>();
		
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "SELECT * FROM mrfaulty.faults where `iduser` = ? ";
            pstatement = MyConnection.prepareStatement(queryString);
            pstatement.setInt(1, UserId);
            ResultSet rs;

            rs = pstatement.executeQuery();
        
            Fault fault;
            while (rs.next())
            {
            	fault= new Fault();
        
            	fault.setFaultid(rs.getInt("idfault"));
            	fault.setUserid(rs.getInt("iduser"));
            	fault.setProject(rs.getString("project"));
            	fault.setRelease(rs.getString("release"));
            	fault.setSummary(rs.getString("summary"));
            	fault.setDetails(rs.getString("details"));
            	fault.setAction(rs.getString("action"));
            	fault.setState(rs.getString("state"));
            	fault.setInvestigated_by(rs.getString("investigated_by"));
            	
            	listoffaults.add(fault);
            }
        
            
            rs.close();
            MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);			
		}
				
		return listoffaults;  
	}

	
	public boolean delete(int FaultId)
	{
		boolean isdeleted=false;
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "delete FROM mrfaulty.faults where `idfault` = ? ";
            pstatement = MyConnection.prepareStatement(queryString);
            pstatement.setInt(1, FaultId);
            isdeleted = pstatement.execute();
        
            
            MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);			
		}
		
		return isdeleted;
	}

	public static Fault queryByFaultId(int FaultId)
	{
		Fault fault = null;
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "SELECT * FROM mrfaulty.faults where `idfault` = ? ";
            pstatement = MyConnection.prepareStatement(queryString);
            pstatement.setInt(1, FaultId);
            ResultSet rs;
            rs = pstatement.executeQuery();
        
            while (rs.next())
            {
            	fault= new Fault();
            	fault.setFaultid(rs.getInt("idfault"));
            	fault.setUserid(rs.getInt("iduser"));
            	fault.setProject(rs.getString("project"));
            	fault.setRelease(rs.getString("release"));
            	fault.setSummary(rs.getString("summary"));
            	fault.setDetails(rs.getString("details"));
            	fault.setAction(rs.getString("action"));
            	fault.setState(rs.getString("state"));
            	fault.setInvestigated_by(rs.getString("investigated_by"));
            }
            
            rs.close();
            MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);			
		}
		
		
		return fault;  
	}

	
	public static ArrayList<Fault> queryAll()
	{
		 ArrayList<Fault> listoffaults = new ArrayList<Fault>();
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "SELECT * FROM mrfaulty.faults";
            pstatement = MyConnection.prepareStatement(queryString);
            ResultSet rs;
            rs = pstatement.executeQuery();
 
            Fault fault;
            while (rs.next())
            {
            	fault= new Fault();
            	fault.setFaultid(rs.getInt("idfault"));
            	fault.setUserid(rs.getInt("iduser"));
            	fault.setProject(rs.getString("project"));
            	fault.setRelease(rs.getString("release"));
            	fault.setSummary(rs.getString("summary"));
            	fault.setDetails(rs.getString("details"));
            	fault.setAction(rs.getString("action"));
            	fault.setState(rs.getString("state"));
            	fault.setInvestigated_by(rs.getString("investigated_by"));
            	
            	listoffaults.add(fault);
            }
        
            
            rs.close();
            MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);			
		}
			
		return listoffaults;  
	}
	
	public static boolean update(Fault newFault)
	{
		int updateQuery = 0;
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
		
			String queryString = "update mrfaulty.faults SET `project` = ?, `release` = ?, `summary` = ?, `details` = ?, `action` = ?, `state` = ?, `investigated_by` = ? WHERE `idfault` = ?";
            pstatement = MyConnection.prepareStatement(queryString);
          
            pstatement.setString(1, newFault.getProject());
            pstatement.setString(2, newFault.getRelease());
            pstatement.setString(3, newFault.getSummary());
            pstatement.setString(4, newFault.getDetails());
            pstatement.setString(5, newFault.getAction());
            pstatement.setString(6, newFault.getState());
            pstatement.setString(7, newFault.getInvestigated_by());
            pstatement.setInt(8, newFault.getFaultid());
            
            updateQuery = pstatement.executeUpdate();
            if (updateQuery != 0)
        
            
			MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);			
		}
		
		System.out.println("Success is  "+ updateQuery);
		return true;
	}

	public static ArrayList<Fault> queryByInvistigatedBy(String Investigatedby)
	{
		 ArrayList<Fault> listoffaults = new ArrayList<Fault>();
		try
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "SELECT * FROM mrfaulty.faults where `Investigated_by` = ?  ";
            pstatement = MyConnection.prepareStatement(queryString);
            pstatement.setString(1, Investigatedby);
            ResultSet rs;
            rs = pstatement.executeQuery();
 
            Fault fault;
            while (rs.next())
            {
            	fault= new Fault();
            	fault.setFaultid(rs.getInt("idfault"));
            	fault.setUserid(rs.getInt("iduser"));
            	fault.setProject(rs.getString("project"));
            	fault.setRelease(rs.getString("release"));
            	fault.setSummary(rs.getString("summary"));
            	fault.setDetails(rs.getString("details"));
            	fault.setAction(rs.getString("action"));
            	fault.setState(rs.getString("state"));
            	fault.setInvestigated_by(rs.getString("investigated_by"));
            	
            	listoffaults.add(fault);
            }
            rs.close();
            MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error " + e);			
		}
			
		return listoffaults;  
	}


	public static ArrayList<Fault> queryNewFaults()
	{
		 ArrayList<Fault> listoffaults = new ArrayList<Fault>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection MyConnection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mrfaulty", "root", "mesureme");
			PreparedStatement pstatement = null;
			
			String queryString = "SELECT * FROM mrfaulty.faults where `state` = ? ";
            pstatement = MyConnection.prepareStatement(queryString);
            pstatement.setString(1, "New");
            ResultSet rs;

            rs = pstatement.executeQuery();
            Fault fault;
            while (rs.next())
            {
            	fault= new Fault();
            	fault.setFaultid(rs.getInt("idfault"));
            	fault.setUserid(rs.getInt("iduser"));
            	fault.setProject(rs.getString("project"));
            	fault.setRelease(rs.getString("release"));
            	fault.setSummary(rs.getString("summary"));
            	fault.setDetails(rs.getString("details"));
            	fault.setAction(rs.getString("action"));
            	fault.setState(rs.getString("state"));
            	fault.setInvestigated_by(rs.getString("investigated_by"));
            	
            	listoffaults.add(fault);
            }
            System.out.println("The Data quired");
            
            rs.close();
            MyConnection.close();
		}
		catch (Exception e)
		{
				System.out.println("Error yaa yoba" + e);			
		}
		
		return listoffaults;  
	}
	
}
