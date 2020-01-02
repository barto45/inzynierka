package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DBConnect2 {

 
    
	public static Connection connection;

    public Boolean getConect() {
        return conect;
    }

    private static Boolean conect = false;

    public static DBConnect2 getInstance() {
                try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ubezpieczenia", "root", "");
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM pracownik ");
             
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                   conect = true;
                }
                else {
                        JOptionPane.showMessageDialog(null, "Z³e Has³o albo Login");

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Brak po³¹czenia z baz¹  danych");

            }
        return null;
    }


    
}
