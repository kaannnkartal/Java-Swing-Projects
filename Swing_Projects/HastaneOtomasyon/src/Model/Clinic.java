package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;

public class Clinic {

	DBConnection conn = new DBConnection();
	

	private int id;
	private String name;

	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	//ArrayList<User> clinicList = null;

	public Clinic(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Clinic() {
	}
	
	public boolean deleteClinic(int clinicID) throws SQLException {
		
		String query = "DELETE FROM clinic WHERE id = ?";
		Connection con = conn.conDB();
		
		try {
			st = con.createStatement();
			//st.executeQuery("INSERT INTO user (tcno, password, name, type) VALUES ('"+Tcno+"', 'password', 'nameSurname', 'Doktor')");
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1,clinicID);	

			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			st.close();
			rs.close();
			con.close();
		}
		
		
		return false;
	}
	
	public boolean updateClinic(int id,String name) throws SQLException {
		//isValueChange(id,name,tcno,password);
		String query = "UPDATE clinic SET name = ? WHERE id = ?";
		Connection con = conn.conDB();
		try {
			st = con.createStatement();
						
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);	
			ps.setInt(2, id);
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			st.close();
			con.close();
		}
		
		
		return false;

	}

	public boolean addClinic(String clinicName) throws SQLException {
		Connection con = conn.conDB();

		st = con.createStatement();

		String query = "INSERT INTO clinic (name) VALUES (?)";

		try {
			ps = con.prepareStatement(query);
			ps.setString(1, clinicName);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			st.close();
			ps.close();
			rs.close();
			con.close();
		}

		return false;
	}
	
	private ArrayList<Integer> getDoctorsIDsClinic(int clinicID) {
		
		ArrayList<Integer> doctorIDClinic = new ArrayList();
		
		Connection con = conn.conDB();
		
		try {
			String query = "SELECT * FROM worker WHERE clinic_id = " + clinicID;
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			
			while(rs.next()) {
				doctorIDClinic.add(rs.getInt("user_id"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return doctorIDClinic;
		
		
	}
	
	public ArrayList<User> getDoctorsInClinic(int clinicID) {

		ArrayList<Integer> doctorID =   getDoctorsIDsClinic(clinicID);
		
		ArrayList<User> doctorsInClinic = new ArrayList();
		
		
		
		Connection con = conn.conDB();
		
		
		try {
			for(int i = 0; i<doctorID.size(); i++) {
				String query = "SELECT * FROM user WHERE id =" +  doctorID.get(i);
				st = con.createStatement();
				rs = st.executeQuery(query);	
				
				while(rs.next()) {
					User obj = new User();
					obj.setId(rs.getInt("id"));
					obj.setName(rs.getString("name"));
					obj.setTcno(rs.getString("tcno"));
					doctorsInClinic.add(obj);
				}
			}

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return doctorsInClinic;
		
		
	}

	public ArrayList<Clinic> getClinicList() throws SQLException {

		ArrayList<Clinic> clinicList = new ArrayList();
		Connection con = conn.conDB();

		Clinic obj;

		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clinic");

			while (rs.next()) {
				obj = new Clinic();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				clinicList.add(obj);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}

		return clinicList;
	}
	
	public Clinic getFetch(int id) {
		Connection con = conn.conDB();
		Clinic c = null;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM clinic WHERE id = " + id);
			
			while(rs.next()) {
				c = new Clinic(rs.getInt("id"), rs.getString("name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
