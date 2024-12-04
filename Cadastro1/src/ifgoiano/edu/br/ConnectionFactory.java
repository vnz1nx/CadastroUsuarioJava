package ifgoiano.edu.br;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection c;

	public static Connection getConnection() {
		try {
			c = DriverManager.getConnection("jdbc:postgresql://localhost/camara", "postgres", "postgres");
			return c;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static void close() {
		try {
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
