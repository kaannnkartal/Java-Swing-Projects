package View;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import Model.*;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

import Helper.*;
import javax.swing.JComboBox;
public class BashekimGUI extends JFrame {
	
	static Bashekim bashekim = new Bashekim();
	Clinic clinic = new Clinic();
	private JPanel w_pane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField fld_doctorID;
	private JPasswordField passwordField;
	private JTable table_doctor;
	private DefaultTableModel doctorModel = null;
	private DefaultTableModel clinicModel = null;
	private DefaultTableModel workerModel = null;
	private Object[] doctorData = null;
	private Object [] clinicData = null;
	private Object [] workerData = null;
	private JTable table_clinic;
	private JTextField textField_2;
	private JPopupMenu clinicMenu;
	private JTable table_worker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BashekimGUI frame = new BashekimGUI(bashekim);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public BashekimGUI(Bashekim bashekim) throws SQLException {
		
		doctorModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				if(column == 0) {
					return false;
				}
				else
					return true;
				
				
			}
		};
		
		// Doktor Model
		Object [] colDoctorName = new Object[4];
		colDoctorName[0] = "ID";
		colDoctorName[1] = "Ad SoyAd";
		colDoctorName[2] = "TC NO";
		colDoctorName[3] = "Şifre";
		doctorModel.setColumnIdentifiers(colDoctorName);
		
		doctorData = new Object[4];
		for(int i = 0; i<bashekim.getDoctorList().size(); i++) {
			doctorData[0] = bashekim.getDoctorList().get(i).getId();
			doctorData[1] = bashekim.getDoctorList().get(i).getName();
			doctorData[2] = bashekim.getDoctorList().get(i).getTcno();
			doctorData[3] = bashekim.getDoctorList().get(i).getPassword();
			
			doctorModel.addRow(doctorData);
			
		}
		
		workerModel = new DefaultTableModel();
		Object [] colWorker = new Object[3];
		colWorker[0] = "ID";
		colWorker[1] = "Name";
		colWorker[2] = "TC No";
		
		workerModel.setColumnIdentifiers(colWorker);
		workerData = new Object[3];
		

		
		
		
		// Clinic Model
		
		clinicModel = new DefaultTableModel();
		Object [] colClinic = new Object[2];
		colClinic[0] = "ID";
		colClinic[1] = "Poliklinik Adı";
		clinicModel.setColumnIdentifiers(colClinic);
		
		clinicData = new Object[2];
		for(int i = 0; i< clinic.getClinicList().size(); i++) {
			clinicData[0] = clinic.getClinicList().get(i).getId();
			clinicData[1] = clinic.getClinicList().get(i).getName();
						
			clinicModel.addRow(clinicData);
			
		}
		
		
		
		
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Hastane Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 538);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoşgeldiniz, Sayın " + bashekim.getName());
		lblNewLabel.setBounds(10, 32, 250, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		w_pane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Çıkış Yap");
		btnNewButton.setBounds(612, 41, 114, 21);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		w_pane.add(btnNewButton);
		
		JTabbedPane w_tab = new JTabbedPane(JTabbedPane.TOP);
		w_tab.setFont(new Font("Tahoma", Font.BOLD, 16));
		w_tab.setBounds(21, 127, 705, 351);
		w_pane.add(w_tab);
		
		JPanel w_doctor = new JPanel();
		w_tab.addTab("Doktor Yönetimi", null, w_doctor, null);
		w_doctor.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(479, 10, 76, 30);
		w_doctor.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(479, 40, 141, 19);
		w_doctor.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("T.C No");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(479, 70, 66, 13);
		w_doctor.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(479, 93, 141, 19);
		w_doctor.add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Şifre");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(479, 122, 45, 13);
		w_doctor.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Ekle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// DB ekleme fonksiyonu yazmamız gerek.
				if(textField.getText().length() == 0 || textField_1.getText().length() == 0 || passwordField.getText().length() == 0 ) {
					//JOptionPane.showMessageDialog(null, "LÜTFEN TÜM DEĞERLERİ GİRİNİZ.");
					Helper.showMsg("fill");
				}
				else {
					try {
						if(bashekim.addDoctor(textField.getText(),textField_1.getText(),passwordField.getText())) {
							Helper.showMsg("success");
							
							textField.setText(null);
							textField_1.setText(null);
							passwordField.setText(null);
							updateDoctorModel();
						}
						else{
							 Helper.showMsg("broke");
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(479, 186, 141, 21);
		w_doctor.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Kullanıcı ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(479, 226, 128, 13);
		w_doctor.add(lblNewLabel_4);
		
		fld_doctorID = new JTextField();
		fld_doctorID.setEditable(false);
		fld_doctorID.setColumns(10);
		fld_doctorID.setBounds(479, 249, 141, 19); 
		w_doctor.add(fld_doctorID);
		
		JButton btnNewButton_2 = new JButton("Sil");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Silme islemi
				if(fld_doctorID.getText().length() == 0) {
					Helper.showMsg("Lütfen Geçerli Bir Doktor Seçiniz");
				}
				else {
					try {
						if(Helper.confirm("sure")) {
							if(bashekim.deleteDoctor(Integer.parseInt(fld_doctorID.getText()))) {
								fld_doctorID.setText(null);
								updateDoctorModel();
							}
						}

					} catch (NumberFormatException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(479, 286, 141, 21);
		w_doctor.add(btnNewButton_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(479, 145, 141, 19);
		w_doctor.add(passwordField);
		
		JScrollPane w_scrollDoctor = new JScrollPane();
		w_scrollDoctor.setBounds(30, 10, 439, 297);
		w_doctor.add(w_scrollDoctor);
		
		table_doctor = new JTable(doctorModel){
			
		};
		w_scrollDoctor.setViewportView(table_doctor);
		

		
		
		
		table_doctor.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				try {
					fld_doctorID.setText(table_doctor.getValueAt(table_doctor.getSelectedRow(), 0).toString()); 
				}
				catch(Exception ex){
					
				}
				
				
			}
			
		});


		table_doctor.getModel().addTableModelListener(new TableModelListener() {

			
			@Override
			public void tableChanged(TableModelEvent e) {

				if(e.getType() == TableModelEvent.UPDATE) {
					boolean flagChange = false;
					
					ArrayList tempList = new ArrayList();
					
					int selectedID = Integer.parseInt(table_doctor.getValueAt(table_doctor.getSelectedRow(), 0).toString());
					String selectedName = (table_doctor.getValueAt(table_doctor.getSelectedRow(), 1).toString());
					String selectedTcno = (table_doctor.getValueAt(table_doctor.getSelectedRow(), 2).toString());
					String selectedPass = (table_doctor.getValueAt(table_doctor.getSelectedRow(), 3).toString());
					
					try {
						tempList = bashekim.getOldValues(selectedID, selectedName, selectedTcno, selectedPass);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					try {
						if(!(tempList.get(0).equals(selectedName) && tempList.get(1).equals(selectedTcno) && tempList.get(2).equals(selectedPass))) {
							if(bashekim.updateDoctor(selectedID, selectedTcno, selectedPass, selectedName)) {
								Helper.showMsg("success");
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		
		
		JPanel w_clinic = new JPanel();
		w_clinic.setBackground(Color.WHITE);
		w_tab.addTab("Polikilinikler", null, w_clinic, null);
		w_clinic.setLayout(null);
		
		JScrollPane w_scrollClinic = new JScrollPane();
		w_scrollClinic.setBounds(10, 10, 260, 297);
		w_clinic.add(w_scrollClinic);
		
		clinicMenu = new JPopupMenu();
		JMenuItem updateMenu = new JMenuItem("Güncelle");
		JMenuItem deleteMenu = new JMenuItem("Sil");
		JMenuItem getDoctorsInPoly = new JMenuItem("Doktorlar");
		clinicMenu.add(updateMenu);
		clinicMenu.add(deleteMenu);
		clinicMenu.add(getDoctorsInPoly);
		
		updateMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selectedID = Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(), 0).toString());
				Clinic selectedClinic = clinic.getFetch(selectedID);
				
				UpdateClinicGUI updateGUI = new UpdateClinicGUI(selectedClinic);
				updateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				updateGUI.setVisible(true);
				updateGUI.addWindowListener(new WindowAdapter() {
					
					public void windowClosed(WindowEvent e) {
						
						
						try {
							updateClinicModel();
							 
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
			
		});
		
		deleteMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int selectedID = Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(), 0).toString());
					clinic.deleteClinic(selectedID);
					updateClinicModel();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
			
		});
		
		getDoctorsInPoly.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Tıklandığında doktorların listesi diğer frame'e getirilecek.
				int selectedID= Integer.parseInt(table_clinic.getValueAt(table_clinic.getSelectedRow(), 0).toString());
				
				if(updateWorkerModel(clinic.getDoctorsInClinic(selectedID))){
					Helper.showMsg("success");
				}
				else {
					Helper.showMsg("Kayıtlı Doktor Bulunamadı");
				}
				
				
				
				
				
				
				
			}
			
		});
		
		table_clinic = new JTable(clinicModel);
		table_clinic.setComponentPopupMenu(clinicMenu);
		table_clinic.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				
				Point point = e.getPoint();
				int selectedRow = table_clinic.rowAtPoint(point);
				table_clinic.setRowSelectionInterval(selectedRow, selectedRow);
				
				
				
			}
		});
		
		
		w_scrollClinic.setViewportView(table_clinic);
		
		JLabel lblNewLabel_1_1 = new JLabel("Poliklinik adı");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(280, 10, 105, 30);
		w_clinic.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(280, 40, 141, 19);
		w_clinic.add(textField_2);
		JButton btn_addClinic = new JButton("Ekle");
		btn_addClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_2.getText().length() == 0) {
					Helper.showMsg("fill");
				}
				else {
					try {
						if(clinic.addClinic(textField_2.getText())) {
							Helper.showMsg("success");
							updateClinicModel();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_addClinic.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_addClinic.setBounds(280, 69, 141, 35);
		w_clinic.add(btn_addClinic);
		
		JScrollPane w_scrollWorker = new JScrollPane();
		w_scrollWorker.setBounds(440, 10, 250, 297);
		w_clinic.add(w_scrollWorker);
		
		table_worker = new JTable(workerModel);
		w_scrollWorker.setViewportView(table_worker);
		
		JComboBox select_Doctor = new JComboBox();
		select_Doctor.setBounds(280, 192, 141, 30);
		
		for(int i=0; i<bashekim.getDoctorList().size();i++) {
			select_Doctor.addItem(new Item(bashekim.getDoctorList().get(i).getId(), bashekim.getDoctorList().get(i).getName()));
		}
		select_Doctor.addActionListener(e ->{
			JComboBox c = (JComboBox) e.getSource();
			 Item item = (Item) c.getSelectedItem();
			
			 
			
		});
		w_clinic.add(select_Doctor);
		
		JButton btn_addWorker = new JButton("Ekle");
		btn_addWorker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_clinic.getSelectedRow();
				if(selectedRow < 0 ) {
					Helper.showMsg("Lütfen poliklinik seçiniz");
				}
				else {
					
					int selectedClinicID =  Integer.parseInt(((table_clinic.getModel().getValueAt(selectedRow, 0).toString())));
					
					Item item = (Item) select_Doctor.getSelectedItem();
					
					try {
						if(bashekim.addWorker(item.getKey(), selectedClinicID)) {
							Helper.showMsg("success");
						}
						else {
							Helper.showMsg("Doktor daha önceden atanmış");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
				}
								
				
				
			}
		});
		btn_addWorker.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_addWorker.setBounds(280, 246, 141, 35);
		w_clinic.add(btn_addWorker);
		
		JPanel panel = new JPanel();
		w_tab.addTab("New tab", null, panel, null);
		
		
		
	}
	
	
	public boolean updateWorkerModel(ArrayList<User> workers) {
		
		try {
			DefaultTableModel clearModel = (DefaultTableModel) table_worker.getModel();
			clearModel.setRowCount(0);
			for(int i = 0; i<workers.size(); i++) {
				workerData[0] = workers.get(i).getId();
				workerData[1] = workers.get(i).getName();
				workerData[2] = workers.get(i).getTcno();
				clearModel.addRow(workerData);
			}
		}catch(Exception e) {
			DefaultTableModel clearModel = new DefaultTableModel();
			
			for(int i = 0; i<workers.size(); i++) {
				workerData[0] = workers.get(i).getId();
				workerData[1] = workers.get(i).getName();
				workerData[2] = workers.get(i).getTcno();
				clearModel.addRow(workerData);
			}
			
		}
		
		
		if(workers.size() != 0) {
			return true;
		}
		
		
		return false;
		
	}
	
	public void updateClinicModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table_clinic.getModel();
		
		clearModel.setRowCount(0);
		
		for(int i = 0; i<clinic.getClinicList().size(); i++) {
			clinicData[0] = clinic.getClinicList().get(i).getId();
			clinicData[1] = clinic.getClinicList().get(i).getName();		
			clinicModel.addRow(clinicData);
		}
	}
	
	public void updateDoctorModel() throws SQLException {
		
		DefaultTableModel clearModel = (DefaultTableModel) table_doctor.getModel();
		
		clearModel.setRowCount(0);
		
		for(int i = 0; i<bashekim.getDoctorList().size(); i++) {
			doctorData[0] = bashekim.getDoctorList().get(i).getId();
			doctorData[1] = bashekim.getDoctorList().get(i).getName();
			doctorData[2] = bashekim.getDoctorList().get(i).getTcno();
			doctorData[3] = bashekim.getDoctorList().get(i).getPassword();
			
			doctorModel.addRow(doctorData);
			
		}
	}
}
