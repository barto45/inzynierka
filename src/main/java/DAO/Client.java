package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Client {
	public static void UpdateKlienciById(int idKlient,String Nazwa, String Ulica,String Kod_Poczt, String Nr_tel,String Nip,String Pesel,String Miejscowosc,String NrDomu,String Uwagi) throws ClassNotFoundException, SQLException{
		
	     
		 Connection conn;
	     Statement stmt = null;
			 try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
		    	 System.out.print("\n COnnecting to database ");
		    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
		    			 System.out.println(" SUCCESS!\n");
		    			stmt= conn.createStatement(); 
		    			stmt.executeUpdate ("UPDATE klient SET idKlient='"+idKlient+"',Nazwa='"+Nazwa+"',Ulica='"+Ulica+"',Kod_Poczt='"+Kod_Poczt+"',NrDomu='"+NrDomu+"',Nr_tel='"+Nr_tel+"',Nip='"+Nip+"',Pesel='"+Pesel+"',Miejscowosc='"+Miejscowosc+"', Uwagi='"+Uwagi+"' WHERE idKlient='"+idKlient+"' ");
		    		       System.out.println(" SUCCESS!\n");
		    		       conn.close(); 
		    		         if(stmt!= null){
		    		        	 JOptionPane.showMessageDialog(null, "Edytowano klienta");
		    		          }
		         conn.close();
		     } catch (ClassNotFoundException | SQLException e){
		          e.printStackTrace();
		          throw e;
		          }}
		
	public static void deleteKlienciById(int idKlient) throws ClassNotFoundException, SQLException{
			
		     
			 Connection conn;
		     Statement stmt = null;
				 try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
			    	 System.out.print("\n COnnecting to database ");
			    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
			    			 System.out.println(" SUCCESS!\n");
			    			stmt= conn.createStatement(); 
			    			stmt.executeUpdate( "delete from klient where idKlient = '"+idKlient+"' ");
			    			 System.out.println(" SUCCESS!\n");
			    			 conn.close(); 
			    	         if(stmt!= null){
			    	        	 JOptionPane.showMessageDialog(null, "Usuniêto klienta");
			    	          } 
			         conn.close();
			     } catch (ClassNotFoundException | SQLException e){
			          e.printStackTrace();
			          throw e;
			          }
			
	}}
	


