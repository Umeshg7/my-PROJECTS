package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import exception.NullException;
import users.Admin;
import users.Instructor;
import users.Student;


public class Login {

	public JFrame frame;
	private JTextField email;
	private JPasswordField password;


	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 500, 850, 620);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Course Management System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setAlignmentX(0.5f);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 25));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		email = new JTextField();
		email.setBackground(new Color(128, 128, 128));
		email.setBounds(584, 224, 207, 34);
		email.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		email.setToolTipText("");
		email.setColumns(10);
		JLabel invalid1 = new JLabel("Invalid");
		invalid1.setBounds(745, 261, 46, 26);
		invalid1.setVisible(false);
		JLabel invalid2 = new JLabel("Invalid");
		invalid2.setBounds(745, 327, 54, 32);
		invalid2.setVisible(false);
		password = new JPasswordField();
		password.setToolTipText("");
		password.setBackground(new Color(128, 128, 128));
		password.setBounds(584, 297, 207, 34);
		password.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.add(email);
		panel_1.add(password);
		String roles[] = { "students", "instructors", "admin" };
		JComboBox<String> comboBox = new JComboBox<>(roles);
		comboBox.setBackground(new Color(128, 128, 128));
		comboBox.setBounds(584, 369, 207, 34);
		comboBox.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		panel_1.add(comboBox);


		JButton login = new JButton("Log In");
		login.setBounds(706, 425, 85, 34);
		login.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String emailField = email.getText();
				String passField = new String(password.getPassword());

				Student s = new Student();
				Instructor i = new Instructor();
				Admin a = new Admin();
				try {
					if (comboBox.getSelectedItem().equals("students")) {
						if (s.login(emailField, passField)) {
							new Dashboard(comboBox.getSelectedItem().toString(),emailField);
							frame.dispose();
						}
					} else if (comboBox.getSelectedItem().equals("instructors")) {
						if (i.login(emailField, passField)) {
							new Dashboard(comboBox.getSelectedItem().toString(),emailField);
							frame.dispose();
						}
					} else if (comboBox.getSelectedItem().equals("admin")) {
						if (a.login(emailField, passField)) {
							new Dashboard(comboBox.getSelectedItem().toString(),emailField);
							frame.dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Email or Password!!", "Invalid Information!!",
								JOptionPane.ERROR_MESSAGE);

					}
				} catch (NullException e1) {
					JOptionPane.showMessageDialog(null, "Please fill up the empty boxes!!", "Error!!",
							JOptionPane.ERROR_MESSAGE);
					invalid1.setVisible(true);
					invalid2.setVisible(true);
				}

			}
		});
		login.setBackground(new Color(128, 128, 128));
		login.setForeground(new Color(248, 248, 248));
		login.setFont(new Font("Poppins", Font.PLAIN, 16));
		panel_1.add(login);

		JLabel cacc = new JLabel("Enter Email:");
		cacc.setForeground(new Color(255, 255, 255));
		cacc.setBounds(584, 199, 96, 22);
		cacc.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		panel_1.add(cacc);

		JLabel lblNewLabel_1_1 = new JLabel("Enter Password:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setBounds(584, 275, 110, 22);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Select User Mode :");
		lblNewLabel_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1_1.setBounds(581, 348, 123, 22);
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_1_1_1);

		invalid2.setForeground(new Color(255, 0, 0));
		invalid2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		panel_1.add(invalid2);

		invalid1.setForeground(new Color(255, 0, 0));
		invalid1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		panel_1.add(invalid1);

		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(584, 425, 91, 34);
		btnCreate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateAcc();
				System.out.println("Clicked");
				frame.setVisible(false);

			}
		});
		btnCreate.setForeground(new Color(248, 248, 248));
		btnCreate.setFont(new Font("Poppins", Font.PLAIN, 16));
		btnCreate.setBackground(new Color(128, 128, 128));
		panel_1.add(btnCreate);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setAlignmentX(0.5f);
		lblNewLabel_2.setBounds(-46, 51, 553, 380);
		Image logo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(logo));
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(554, 224, 32, 34);
		Image mail = new ImageIcon(this.getClass().getResource("/mail.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(mail));
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(554, 297, 32, 34);
		Image pass = new ImageIcon(this.getClass().getResource("/password.png")).getImage();
		lblNewLabel_3_1.setIcon(new ImageIcon(pass));
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBounds(554, 369, 32, 34);
		Image user = new ImageIcon(this.getClass().getResource("/account.png")).getImage();
		lblNewLabel_3_1_1.setIcon(new ImageIcon(user));
		panel_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(638, 10, 130, 100);
		Image newImage = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(newImage));
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Please Login your account");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(554, 120, 259, 65);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Welcome back !");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(613, 109, 178, 32);
		panel_1.add(lblNewLabel_6);

	}
}
