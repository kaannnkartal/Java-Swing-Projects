package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Clinic;
import Helper.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateClinicGUI extends JFrame {

	private JPanel contentPane;
	private JTextField fld_clinicName;
	private static Clinic clinic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateClinicGUI frame = new UpdateClinicGUI(clinic);
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
	public UpdateClinicGUI( Clinic clinic) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Poliklinik adı");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 10, 105, 30);
		contentPane.add(lblNewLabel_1_1);
		
		fld_clinicName = new JTextField();
		fld_clinicName.setColumns(10);
		fld_clinicName.setBounds(10, 43, 141, 19);
		fld_clinicName.setText(clinic.getName());
		contentPane.add(fld_clinicName);
		
		JButton btn_updateClinic = new JButton("Düzenle");
		btn_updateClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Helper.confirm("sure")) {
					try {
						if(clinic.updateClinic(clinic.getId(), fld_clinicName.getText())) {
							Helper.showMsg("success");
							dispose();
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_updateClinic.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_updateClinic.setBounds(10, 89, 141, 35);
		contentPane.add(btn_updateClinic);
	}

}
