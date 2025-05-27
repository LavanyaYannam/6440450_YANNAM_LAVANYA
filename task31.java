import java.sql.*;


public class task31 {
    public static void main(String[] args) {
        try {
            // SQLite DB connection
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db");
            Statement stmt = conn.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT NOT NULL)";
            
            stmt.execute(createTableSQL);

            System.out.println("Connection and creation successfull");
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
