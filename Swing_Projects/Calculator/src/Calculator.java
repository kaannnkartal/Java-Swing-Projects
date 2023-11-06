import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private double result, number;
	int operation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addInput(String str) {
		
		if(input.getText().equals("İşleme Hazır!")) {
			input.setText("");		
		}
		else if (input.getText().equals("Infinity")) {
			input.setText("");	
		}
		input.setText(input.getText() + str);
	}
	
	public void setOperation() {
		
		switch (operation) {
		case '+':
			result = number + Double.parseDouble((input.getText()));   
			break;
		case '-':
			result = number - Double.parseDouble((input.getText()));  
			break;
		case '*':
			result = number * Double.parseDouble((input.getText()));  
			break;			
		case '/':
			result = number / Double.parseDouble((input.getText()));  
			break;
			
		}
		
		input.setText(Double.toString(result));
	
	}
	/**
	 * Create the frame.
	 */
	public Calculator() {
		setType(Type.UTILITY);
		setTitle("Hesap Makinesi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel screen = new JPanel();
		screen.setBounds(10, 10, 420, 60);
		contentPane.add(screen);
		screen.setLayout(null);
		
		input = new JTextField();
		input.setEditable(false);
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setText("İşleme Hazır!");
		input.setFont(new Font("Tahoma", Font.BOLD, 23));
		input.setBounds(10, 22, 400, 28);
		screen.add(input);
		input.setColumns(10);
		
		JLabel behindOperation = new JLabel("");
		behindOperation.setFont(new Font("Tahoma", Font.BOLD, 11));
		behindOperation.setHorizontalAlignment(SwingConstants.RIGHT);
		behindOperation.setBounds(139, -1, 271, 13);
		screen.add(behindOperation);
		
		JPanel control = new JPanel();
		control.setBounds(10, 90, 416, 363);
		contentPane.add(control);
		control.setLayout(new GridLayout(4, 4, 20, 20));
		
		JButton btnNewButton_4 = new JButton("4");
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		
		JButton btnNewButton_7 = new JButton("7");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 24));
		control.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("8");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 24));
		control.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("9");
		btnNewButton_9.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		control.add(btnNewButton_9);
		
		JButton btnNewButton_101 = new JButton("*");
		btnNewButton_101.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				input.setText("");
				operation = '*';
				behindOperation.setText(number + e.getActionCommand());
			}
		});
		control.add(btnNewButton_101);
		control.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("5");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 24));
		control.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		control.add(btnNewButton_6);
		
		JButton btnNewButton_102 = new JButton("/");
		btnNewButton_102.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				number = Double.parseDouble(input.getText());
				input.setText("");
				operation = '/';
				behindOperation.setText(number + e.getActionCommand());
			}
		});
		control.add(btnNewButton_102);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		control.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("2");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		control.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("3");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		control.add(btnNewButton_3);
		
		JButton btnNewButton_103 = new JButton("+");
		btnNewButton_103.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_103.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				input.setText("");
				operation = '+';
				behindOperation.setText(number + e.getActionCommand());
				
			}
		});
		control.add(btnNewButton_103);
		
		JButton btnNewButton_11 = new JButton("=");
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setOperation();
				behindOperation.setText("");
			}
			
		});
		control.add(btnNewButton_11);
		
		JButton btnNewButton_0 = new JButton("0");
		btnNewButton_0.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(e.getActionCommand());
			}
		});
		control.add(btnNewButton_0);
		
		JButton btnClr = new JButton("CLR");
		btnClr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText("");
			}
		});
		btnClr.setFont(new Font("Tahoma", Font.BOLD, 24));
		control.add(btnClr);
		
		JButton btnNewButton_104 = new JButton("-");
		btnNewButton_104.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				input.setText("");
				operation = '-';
				behindOperation.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_104.setFont(new Font("Tahoma", Font.BOLD, 24));
		control.add(btnNewButton_104);
	}
}
