package DataSource;
import java.sql.*;
public class DBConnection {
	// JDBC driver name and database URL
	private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/bookshop";
	
	// Database credentials
	private static final String DB_USER = "postgres";
	private static final String DB_PASSWORD = "postgres";
	
	static Connection dbConnection = null;
	
	// Execute statements
	public static PreparedStatement prepare(String stm) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			Connection dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(stm);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return preparedStatement;
	}
	
	// Deals with the connection, This effectively abstracted away the need to deal with connection everytime for a statement
	private static Connection getDBConnection() {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			
			dbConnection = DriverManager.getConnection(
					DB_CONNECTION,
					DB_USER,
					DB_PASSWORD);
			
			dbConnection.setAutoCommit(false);
			
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Connection problem");
		return null;
	}
}
