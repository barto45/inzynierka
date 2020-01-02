package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Polisa {
	public static void EditPolisaById(LocalDate DataOd,LocalDate DataDo,String TowUbez,
			String NazPolisy, String Uwagi,String DanUbez
			,String IleRat,String  Koszt,String  NrRej , String Klient_idKlient,int NrPolisy) throws ClassNotFoundException, SQLException{
		
	     
		 Connection conn;
	     Statement stmt = null;
			 try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
		    	 System.out.print("\n COnnecting to database ");
		    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
		    			 System.out.println(" SUCCESS!\n");
		    			stmt= conn.createStatement(); 
		    			 stmt.executeUpdate( "UPDATE `polisy` SET `DataOd`='"+DataOd+"',`DataDo`='"+DataDo+"',`TowUbez`='"+TowUbez+"',`NazPolisy`='"+NazPolisy+"',`Uwagi`='"+Uwagi+"',`DanUbez`='"+DanUbez+"',`IleRat`='"+IleRat+"',`Koszt`='"+Koszt+"',`Klient_idKlient`='"+Klient_idKlient+"',`NrRej`='"+NrRej+"',`NrPolisy`='"+NrPolisy+"' WHERE `NrPolisy`='"+NrPolisy+"'");
		    			     System.out.println(" SUCCESS!\n");
		    			     conn.close(); 
		    		         if(stmt!= null){
		    		        	 JOptionPane.showMessageDialog(null, "Edytowano polisê");
		    		          } 
		    					
		         conn.close();
		     } catch (ClassNotFoundException | SQLException e){
		          e.printStackTrace();
		          throw e;
		          }}
public static void deletePolisaById(int idPolisy) throws ClassNotFoundException, SQLException{
		
	     
		 Connection conn;
	     Statement stmt = null;
			 try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
		    	 System.out.print("\n COnnecting to database ");
		    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
		    			 System.out.println(" SUCCESS!\n");
		    			stmt= conn.createStatement(); 
		    			stmt.executeUpdate( "delete from polisy where NrPolisy = '"+idPolisy+"' ");
		    			 System.out.println(" SUCCESS!\n");
		    			 conn.close(); 
		    	         if(stmt!= null){
		    	        	 JOptionPane.showMessageDialog(null, "Usuniêto polisê");
		    	          } 
		         conn.close();
		     } catch (ClassNotFoundException | SQLException e){
		          e.printStackTrace();
		          throw e;
		          }
		
	}
}
