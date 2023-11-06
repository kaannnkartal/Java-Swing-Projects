package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


import Helper.*;
import Model.Bashekim;
public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField fld_hastaTC;
	private JPasswordField passfld_hastaPass;
	private JTextField fld_doctorTC;
	private JPasswordField passfld_doctorPass;

	private DBConnection conn = new DBConnection();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setTitle("Hastane Otomasyon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lbl_Logo = new JLabel(new ImageIcon(getClass().getResource("logo.png")));
		lbl_Logo.setBounds(192, 10, 93, 111);

		w_pane.add(lbl_Logo);
		
		JLabel lblNewLabel = new JLabel("Hastane Yönetim Sistemine Hoşgeldiniz");
		lblNewLabel.setBounds(91, 131, 332, 33);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		w_pane.add(lblNewLabel);
		
		JTabbedPane w_tabPane = new JTabbedPane(JTabbedPane.TOP);
		w_tabPane.setBounds(10, 174, 466, 179);
		w_tabPane.setBackground(Color.WHITE);
		w_pane.add(w_tabPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		w_tabPane.addTab("Hasta Girişi", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblTcNumaranz = new JLabel("T.C Numaranız : ");
		lblTcNumaranz.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTcNumaranz.setBounds(10, 21, 139, 26);
		panel.add(lblTcNumaranz);
		
		JLabel lblifre = new JLabel("Şifre :");
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblifre.setBounds(10, 62, 63, 29);
		panel.add(lblifre);
		
		fld_hastaTC = new JTextField();
		fld_hastaTC.setFont(new Font("Tahoma", Font.BOLD, 16));
		fld_hastaTC.setBounds(166, 21, 205, 26);
		panel.add(fld_hastaTC);
		fld_hastaTC.setColumns(10);
		
		passfld_hastaPass = new JPasswordField();
		passfld_hastaPass.setBounds(166, 63, 205, 28);
		panel.add(passfld_hastaPass);
		
		JButton btnRegister = new JButton("Kayıt Ol");
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegister.setBounds(10, 121, 139, 21);
		panel.add(btnRegister);
		
		JButton btn_hastaLogin = new JButton("Giriş Yap");
		btn_hastaLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_hastaLogin.setBounds(293, 121, 139, 21);
		panel.add(btn_hastaLogin);
		
		JPanel w_doctorLogin = new JPanel();
		w_doctorLogin.setBackground(Color.WHITE);
		w_tabPane.addTab("Doktor Girişi", null, w_doctorLogin, null);
		w_doctorLogin.setLayout(null);
		
		JLabel lblTcNumaranz_1 = new JLabel("T.C Numaranız : ");
		lblTcNumaranz_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTcNumaranz_1.setBounds(10, 10, 139, 26);
		w_doctorLogin.add(lblTcNumaranz_1);
		
		fld_doctorTC = new JTextField();
		fld_doctorTC.setFont(new Font("Tahoma", Font.BOLD, 16));
		fld_doctorTC.setColumns(10);
		fld_doctorTC.setBounds(166, 10, 205, 26);
		w_doctorLogin.add(fld_doctorTC);
		
		JLabel lblifre_1 = new JLabel("Şifre :");
		lblifre_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblifre_1.setBounds(10, 51, 63, 29);
		w_doctorLogin.add(lblifre_1);
		
		passfld_doctorPass = new JPasswordField();
		passfld_doctorPass.setBounds(166, 52, 205, 28);
		w_doctorLogin.add(passfld_doctorPass);
		
		JButton btn_DoctorLogin = new JButton("Giriş Yap");
		btn_DoctorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_doctorTC.getText().length() == 0 || passfld_doctorPass.getText().length() == 0) {
					Helper.showMsg("fill");
				}else {
					try {
						Connection con = conn.conDB();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						
						while(rs.next()) {
							if(fld_doctorTC.getText().equals(rs.getString("tcno")) && passfld_doctorPass.getText().equals(rs.getString("password"))) {
								Bashekim bhekim = new Bashekim();
								bhekim.setId(rs.getInt("id"));
								bhekim.setPassword("password");
								bhekim.setTcno(rs.getString("tcno"));
								bhekim.setName(rs.getString("name"));
								bhekim.setType(rs.getString("type"));
								
								BashekimGUI bGUI = new BashekimGUI(bhekim);
								bGUI.setVisible(true);
								dispose();
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_DoctorLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_DoctorLogin.setBounds(32, 110, 400, 21);
		w_doctorLogin.add(btn_DoctorLogin);
	}
}
