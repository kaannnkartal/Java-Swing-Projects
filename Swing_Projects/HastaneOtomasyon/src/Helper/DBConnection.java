package Helper;
import java.sql.*;
public class DBConnection {

	Connection c = null;
	
	public DBConnection() {
		
	}
	
	public Connection conDB() {
		try {
			this.c = DriverManager.getConnection("jdbc:mariadb://localhost:3325/hospital?user=root&password=12345");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
