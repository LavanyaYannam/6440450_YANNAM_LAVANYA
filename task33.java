import java.sql.*;

public class task33 {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db");
            Statement stmt = conn.createStatement();

            // Create table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS accounts (id INTEGER PRIMARY KEY, balance INTEGER)";
            stmt.execute(createTableSQL);

            // Insert accounts if not already present
            stmt.execute("INSERT OR IGNORE INTO accounts (id, balance) VALUES (1, 1000)");
            stmt.execute("INSERT OR IGNORE INTO accounts (id, balance) VALUES (2, 500)");

            // Display balances before transaction
            ResultSet before = stmt.executeQuery("SELECT * FROM accounts");
            System.out.println("Before Transaction:");
            while (before.next()) {
                System.out.println("Account " + before.getInt("id") + ": ₹" + before.getInt("balance"));
            }
            before.close();

            // Begin transaction
            conn.setAutoCommit(false);
            try {
                stmt.executeUpdate("UPDATE accounts SET balance = balance - 100 WHERE id = 1");
                stmt.executeUpdate("UPDATE accounts SET balance = balance + 100 WHERE id = 2");
                conn.commit();
                System.out.println("Transaction successful.");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Transaction failed. Rollback performed.");
                e.printStackTrace();
            }

            // Display balances after transaction
            ResultSet after = stmt.executeQuery("SELECT * FROM accounts");
            System.out.println("After Transaction:");
            while (after.next()) {
                System.out.println("Account " + after.getInt("id") + ": ₹" + after.getInt("balance"));
            }
            after.close();

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
