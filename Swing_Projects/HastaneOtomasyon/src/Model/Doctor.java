package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor extends User {

	Statement st = null;
	ResultSet rs  = null;
	PreparedStatement ps = null;
	Connection con = conn.conDB();
	public Doctor() {
		super();
	}
	public Doctor(int id, String tcno, String name, String password, String type) {
		super(id, tcno, name, password, type);
	}
	
	
	
}
