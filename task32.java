import java.sql.*;

public class task32 {
    public static void main(String[] args) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db");
            Statement stmt = conn.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY, name TEXT NOT NULL)";
            stmt.execute(createTableSQL);

            // Insert only if not exists
            String insertTableSQL = "INSERT OR IGNORE INTO students(name,id) VALUES ('Alicce',1)";
            stmt.execute(insertTableSQL);

            ResultSet rs = stmt.executeQuery("SELECT * FROM students;");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
            }
            rs.close();

            // Update
            String updateSQL = "UPDATE students SET name='sai' WHERE id=1";
            stmt.execute(updateSQL);

            // Show data after update
            ResultSet rsr = stmt.executeQuery("SELECT * FROM students;");
            System.out.println("After update:");
            while (rsr.next()) {
                System.out.println(rsr.getInt("id") + ": " + rsr.getString("name"));
            }
            rsr.close();

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
