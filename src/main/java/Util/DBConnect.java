package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DBConnect {

 
    
	public Connection connection;

    public Boolean getConect() {
        return conect;
    }

    private Boolean conect = false;

    public  Connection getConnection(String Login , String Has�o) {
                try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM pracownik WHERE Login =? AND Has�o =?");
                ps.setString(1, Login);
                ps.setString(2, Has�o);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                   conect = true;
                }
                else {
                        JOptionPane.showMessageDialog(null, "Z�e Has�o albo Login");

                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Brak po��czenia z baz�  danych");

            }
        return null;
    }
    
}
