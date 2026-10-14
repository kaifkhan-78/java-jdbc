import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        String url = requireEnv("DB_URL");
        String user = requireEnv("DB_USER");
        String password = requireEnv("DB_PASSWORD");

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection successful");

            try (PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO student VALUES (?, ?, ?)")) {
                ps.setInt(1, 103);
                ps.setString(2, "Rahul");
                ps.setString(3, "CSE");
                int inserted = ps.executeUpdate();
                System.out.println("Rows inserted: " + inserted);
            }

            try (Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT * FROM student")) {
                while (rs.next()) {
                    System.out.printf("%d %s %s%n",
                            rs.getInt(1), rs.getString(2), rs.getString(3));
                }
            }
        } catch (SQLException e) {
            System.err.println("Database operation failed: " + e.getMessage());
        }
    }

    private static String requireEnv(String name) {
        String value = System.getenv(name);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException(
                    "Missing required environment variable: " + name);
        }
        return value;
    }
}
