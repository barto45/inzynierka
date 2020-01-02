package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;



public class Cases {
	public static void AddCasesById(int idSprawy, String DanPoszk,String DanSprawcy,LocalDate DatRozp,LocalDate DatZak,String RodzSzkody
			,String StatSpraw,  String Uwagi)  throws ClassNotFoundException, SQLException{
		
		
	     
		 Connection conn;
	     Statement stmt = null;
			 try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
		    	 System.out.print("\n COnnecting to database ");
		    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
		    			 System.out.println(" SUCCESS!\n");
		    			stmt= conn.createStatement(); 
		    			 stmt.executeUpdate("INSERT INTO `sprawy`(`idSprawy`, `DanPoszk`, `DanSprawcy`, `DatRozp`, `DatZak`, `StatSpraw`, `RodzSzkody`, `Uwagi`) VALUES ('"+idSprawy+"','"+DanPoszk+"',"
		    			 				+ "'"+DanSprawcy+"','"+DatRozp+"','"+DatZak+"','"+StatSpraw+"',"
		    			 						+ "'"+RodzSzkody+"','"+Uwagi+"')");
		    			   		 System.out.println(" SUCCESS!\n");
		    			   		conn.close(); 
		    			         if(stmt!= null){
		    			        	 JOptionPane.showMessageDialog(null, "Edytowano sprawê");
		    			          } 
		         conn.close();
		     } catch (ClassNotFoundException | SQLException e){
		          e.printStackTrace();
		          throw e;
		          }
		
	}


	public static void deleteCasesById(int idSprawy) throws ClassNotFoundException, SQLException{
		
		
	     
		 Connection conn;
	     Statement stmt = null;
			 try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
		    	 System.out.print("\n COnnecting to database ");
		    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
		    			 System.out.println(" SUCCESS!\n");
		    			stmt= conn.createStatement(); 
		    			 stmt.executeUpdate( "DELETE FROM `sprawy` WHERE `idSprawy`='"+idSprawy+"' ");
		    			 System.out.println(" SUCCESS!\n");
		    			 if(stmt!= null){
    			        	 JOptionPane.showMessageDialog(null, "Usuniêto sprawê");
    			          } 
		         conn.close();
		     } catch (ClassNotFoundException | SQLException e){
		          e.printStackTrace();
		          throw e;
		          }
		
	}

	public static void EditCasesById(int idSprawy,String DanPoszk,String DanSprawcy, String RodzSzkody,String StatSpraw,LocalDate DatRozp,LocalDate DatZak,String Uwagi) throws ClassNotFoundException, SQLException{
		
		     
			 Connection conn;
		     Statement stmt = null;
				 try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
			    	 System.out.print("\n COnnecting to database ");
			    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
			    			 System.out.println(" SUCCESS!\n");
			    			stmt= conn.createStatement(); 
			    			 stmt.executeUpdate( "UPDATE `sprawy` SET `idSprawy`='"+idSprawy+"',`DanPoszk`='"+DanPoszk+"',`DanSprawcy`='"+DanSprawcy+"',`DatRozp`='"+DatRozp+"',`DatZak`='"+DatZak+"',`StatSpraw`='"+StatSpraw+"',`RodzSzkody`='"+RodzSzkody+"',`Uwagi`='"+Uwagi+"' WHERE `idSprawy`='"+idSprawy+"' ");
			 		         System.out.println(" SUCCESS!\n");
			         
			         conn.close();
			     } catch (ClassNotFoundException | SQLException e){
			          e.printStackTrace();
			          throw e;
			          }
	
	}
}
