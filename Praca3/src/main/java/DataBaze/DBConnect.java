package DataBaze;

import Controller.LoginController;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnect {

    public Connection connection;

    public Boolean getConect() {
        return conect;
    }

    private Boolean conect = false;

    public  Connection getConnection(String login , String haslo) {
                try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/dbinzy", "root", "");
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE Login =? AND Haslo =?");
                ps.setString(1, login);
                ps.setString(2, haslo);
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
