package git_test;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class unterlage {

    public static void lesh() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Fehler beim Laden des Treibers");
        }
        
        String url = "jdbc:mysql://localhost/world";
        String user = "root";
        String pass = "";
        
        Connection con=null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("Fehler beim Herstellen der Verbindung");
        }
     
        
        try {
            Statement stmt = con.createStatement();
            /*ResultSet result = stmt.executeQuery("SELECT * FROM city");
            while(result.next()) {
                String city = result.getString("Name");
                int population = result.getInt("Population");
                System.out.println(city + " has " + population + " habitants"); */
            int result = stmt.executeUpdate("INSERT INTO city (Name, CountryCode, District, Population) "
                    + "VALUES ('Shkodra', 'ALB', 'Shkodra', 120000)");
            System.out.println(result);
        }
        catch (SQLException ex) {
            System.out.println("Fehler bei der Erstellung der Statement");
        }
        
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println("Fehler beim Zumachen der Verbindung");
        }
    }
    
}
