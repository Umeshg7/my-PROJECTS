package gui;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import courses.AssignedModule;
import courses.Courses;
import courses.Modules;
import users.Admin;
import users.Instructor;
import users.Student;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;

public class Dashboard {

	private JFrame frame;
	private Desktop desktop;
	private CardLayout card = new CardLayout(0, 0);


	/**
	 * Create the application.
	 */
	private String user;
	private String emailInfo;
	private JTable table;
	private JTable table_1;
	private JTable instructorTable;
	private JPasswordField pwdOldPassword;
	private JTable table_2;
	private JPasswordField pwdNewPass;
	private JTable table_3;

	public Dashboard(String user, String emailInfo) {
		this.user = user;
		this.emailInfo=emailInfo;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1080, 720);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		JLabel lblNewLabel_1 = new JLabel("Course Management System");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(card);

		JPanel dashboard = new JPanel();
		dashboard.setBackground(new Color(0, 0, 0));
		panel_2.add(dashboard, "dashboard");

		Courses c = new Courses();
		c.getCourse(); 

		JLabel lblNewLabel_2 = new JLabel("No of Courses :\r\n");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(133, 158, 197, 46);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 28));

		JLabel lblNewLabel_2_1 = new JLabel("No of Tutors :");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setBounds(701, 158, 177, 46);
		lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 28));

		JLabel lblNewLabel_2_2_5 = new JLabel("Dashboard");
		lblNewLabel_2_2_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2_5.setBounds(10, 92, 175, 46);
		lblNewLabel_2_2_5.setFont(new Font("Bahnschrift", Font.BOLD, 30));

		JLabel lblNewLabel = new JLabel("" + c.getCourse().size());
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(212, 214, 97, 69);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 63));

		Instructor i = new Instructor();
		JLabel lblNewLabel_3 = new JLabel("" + i.getInstructor().size());
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(767, 202, 97, 69);
		lblNewLabel_3.setFont(new Font("Poppins", Font.BOLD, 63));

		JLabel lblNewLabel_2_3 = new JLabel("No of Modules :\r\n");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setBounds(133, 293, 197, 46);
		lblNewLabel_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 28));

		Modules m = new Modules();
		JLabel lblNewLabel_4 = new JLabel("" + m.getModules().size());
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(194, 334, 197, 69);
		lblNewLabel_4.setFont(new Font("Poppins", Font.BOLD, 63));

		JLabel lblNewLabel_2_3_1 = new JLabel("No of Students :\r\n");
		lblNewLabel_2_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3_1.setBounds(701, 293, 214, 46);
		lblNewLabel_2_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 28));

		Student s = new Student();
		JLabel lblNewLabel_6 = new JLabel("" + s.getStudents().size());
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(784, 334, 107, 69);
		lblNewLabel_6.setFont(new Font("Poppins", Font.BOLD, 63));
		
		JLabel lblNewLabel_8 = new JLabel("Enrolled Modules :");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(377, 434, 227, 20);
		lblNewLabel_8.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		
		
		DefaultTableModel enroll = new DefaultTableModel();
		enroll.setColumnIdentifiers(new String[] {"Sn","Module Name"});
		for(int j = 0; j<s.moduleEnrollment(emailInfo).size(); j++) {
			enroll.addRow(new Object[] {j+1,s.moduleEnrollment(emailInfo).get(j).toString()});
		}
		dashboard.setLayout(null);
		dashboard.add(lblNewLabel_8);
		dashboard.add(lblNewLabel);
		dashboard.add(lblNewLabel_2);
		dashboard.add(lblNewLabel_2_3);
		dashboard.add(lblNewLabel_4);
		dashboard.add(lblNewLabel_6);
		dashboard.add(lblNewLabel_2_3_1);
		dashboard.add(lblNewLabel_2_1);
		dashboard.add(lblNewLabel_3);
		dashboard.add(lblNewLabel_2_2_5);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(377, 457, 311, 110);
		dashboard.add(scrollPane_4);
		
		table_3 = new JTable(enroll);
		scrollPane_4.setViewportView(table_3);
		
		JButton btnNewButton_1 = new JButton("Enrollment");
		btnNewButton_1.setBounds(479, 577, 129, 30);
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You're already enrolled.");
			}
		});
		if ("admin".equals(user) || "instructors".equals(user)) {
		    btnNewButton_1.setVisible(false);
		} else {
		    btnNewButton_1.setVisible(true);
		}
		
		
		dashboard.add(btnNewButton_1);
		
				Panel panel_1 = new Panel();
				panel_1.setBounds(0, 0, 1066, 86);
				dashboard.add(panel_1);
				panel_1.setBackground(new Color(0, 0, 0));
				
				ImageIcon dashboardIcon = new ImageIcon(getClass().getResource("/dashboard.png"));
				JButton btnNewButton = new JButton("Dashboard", dashboardIcon);
				btnNewButton.setBorderPainted(false);
				btnNewButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        card.show(panel_2, "dashboard");
				        frame.revalidate();
				        frame.repaint();
				    }
				});
				btnNewButton.setBackground(new Color(255, 255, 255));
				btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

				// Courses button
				ImageIcon coursesIcon = new ImageIcon(getClass().getResource("/course.png"));
				JButton btnCourses = new JButton("Courses", coursesIcon);
				btnCourses.setBorderPainted(false);
				btnCourses.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        card.show(panel_2, "course");
				        frame.revalidate();
				    }
				});
				btnCourses.setBackground(new Color(255, 255, 255));
				btnCourses.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

				// Tutors button
				ImageIcon tutorsIcon = new ImageIcon(getClass().getResource("/tutors.png"));
				JButton btnTutors = new JButton("Tutors", tutorsIcon);
				btnTutors.setBorderPainted(false);
				btnTutors.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        card.show(panel_2, "tutors");
				        frame.revalidate();
				    }
				});
				btnTutors.setBackground(new Color(255, 255, 255));
				btnTutors.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

				// Mail button
				ImageIcon mailIcon = new ImageIcon(getClass().getResource("/gmail.png"));
				JButton btnMail = new JButton("Mail", mailIcon);
				btnMail.setBorderPainted(false);
				btnMail.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        desktop = Desktop.getDesktop();

				        // Pushing to browser
				        try {
				            desktop.browse(new URI("https://gmail.com/"));
				        } catch (IOException | URISyntaxException e1) {
				            e1.printStackTrace();
				        }
				    }
				});
				btnMail.setBackground(new Color(255, 255, 255));
				btnMail.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

				// Settings button
				ImageIcon settingsIcon = new ImageIcon(getClass().getResource("/setting.png"));
				JButton btnSettings = new JButton("Setting", settingsIcon);
				btnSettings.setBorderPainted(false);
				btnSettings.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        card.show(panel_2, "setting");
				        frame.revalidate();
				    }
				});
				btnSettings.setBackground(new Color(255, 255, 255));
				btnSettings.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

				// Logout button
				ImageIcon logoutIcon = new ImageIcon(getClass().getResource("/logout.png"));
				JButton btnLogOut = new JButton("Logout", logoutIcon);
				btnLogOut.setBorderPainted(false);
				btnLogOut.setBackground(new Color(255, 255, 255));
				btnLogOut.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
				btnLogOut.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        new Login();
				        frame.setVisible(false);
				        frame.dispose();
				    }
				});

				// Add buttons to the panel_1
				panel_1.add(btnNewButton);
				panel_1.add(btnCourses);
				panel_1.add(btnTutors);
				panel_1.add(btnMail);
				panel_1.add(btnSettings);
				panel_1.add(btnLogOut);
																		JLabel lblNewLabel_5 = new JLabel("" + user);
																		lblNewLabel_5.setForeground(new Color(255, 255, 255));
																		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
																				
																				JLabel lblNewLabel_9 = new JLabel("User mode is :");
																				lblNewLabel_9.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
																				lblNewLabel_9.setForeground(new Color(255, 255, 255));
																				GroupLayout gl_panel_1 = new GroupLayout(panel_1);
																				gl_panel_1.setHorizontalGroup(
																					gl_panel_1.createParallelGroup(Alignment.LEADING)
																						.addGroup(gl_panel_1.createSequentialGroup()
																							.addContainerGap()
																							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
																								.addGroup(gl_panel_1.createSequentialGroup()
																									.addComponent(btnNewButton)
																									.addGap(43)
																									.addComponent(btnCourses, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
																									.addGap(32)
																									.addComponent(btnTutors, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
																									.addGap(39)
																									.addComponent(btnMail, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
																									.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
																									.addComponent(btnSettings)
																									.addGap(44)
																									.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
																								.addGroup(gl_panel_1.createSequentialGroup()
																									.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
																									.addPreferredGap(ComponentPlacement.RELATED)
																									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
																							.addContainerGap())
																				);
																				gl_panel_1.setVerticalGroup(
																					gl_panel_1.createParallelGroup(Alignment.LEADING)
																						.addGroup(gl_panel_1.createSequentialGroup()
																							.addGap(21)
																							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
																								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
																									.addComponent(btnTutors, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
																									.addComponent(btnCourses, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
																								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																									.addComponent(btnMail, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
																									.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
																									.addComponent(btnSettings, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
																							.addPreferredGap(ComponentPlacement.RELATED)
																							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
																								.addComponent(lblNewLabel_5)
																								.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
																							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																				);
																				panel_1.setLayout(gl_panel_1);
		if(user=="students") {
			scrollPane_4.setVisible(true);
			lblNewLabel_8.setVisible(true);
		}else {
			scrollPane_4.setVisible(false);
			lblNewLabel_8.setVisible(false);
		}
		JPanel courses = new JPanel();
		courses.setBackground(new Color(0, 0, 0));
		panel_2.add(courses, "course");

		JLabel lblNewLabel_2_2 = new JLabel("Total No of Courses:");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setBounds(138, 144, 277, 46);
		lblNewLabel_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 28));

		JLabel lblNewLabel_2_2_4 = new JLabel("Courses");
		lblNewLabel_2_2_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2_4.setBounds(10, 92, 124, 46);
		lblNewLabel_2_2_4.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		courses.setLayout(null);
		courses.add(lblNewLabel_2_2);
		courses.add(lblNewLabel_2_2_4);

		JLabel lblNewLabel_7 = new JLabel("" + c.getCourse().size());
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(231, 188, 87, 69);
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.BOLD, 63));
		courses.add(lblNewLabel_7);

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] { "ID", "Course Name" });

		for (int j = 0; j < c.getCourse().size(); j++) {
			model.addRow(new Object[] { c.getCourse().get(j).course_id, c.getCourse().get(j).course_name });
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFocusTraversalKeysEnabled(false);
		scrollPane.setFocusable(false);
		scrollPane.setOpaque(false);
		scrollPane.setRequestFocusEnabled(false);
		scrollPane.setBounds(60, 318, 421, 248);
		courses.add(scrollPane);
		table = new JTable(model);
		table.setEnabled(false);
		table.setFont(new Font("Poppins", Font.PLAIN, 10));
		table.setRequestFocusEnabled(false);
		table.setOpaque(false);
		table.setShowVerticalLines(false);
		table.setRowSelectionAllowed(false);
		table.setShowHorizontalLines(false);
		table.setShowGrid(false);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_2_2_6 = new JLabel("Total No of Modules:");
		lblNewLabel_2_2_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2_6.setFont(new Font("Bahnschrift", Font.PLAIN, 28));
		lblNewLabel_2_2_6.setBounds(659, 144, 277, 46);
		courses.add(lblNewLabel_2_2_6);

		JLabel lblNewLabel_7_2 = new JLabel("" + m.getModules().size());
		lblNewLabel_7_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_7_2.setFont(new Font("Poppins", Font.BOLD, 63));
		lblNewLabel_7_2.setBounds(748, 176, 109, 69);
		courses.add(lblNewLabel_7_2);

		DefaultTableModel model1 = new DefaultTableModel();
		model1.setColumnIdentifiers(new String[] { "ID", "Module Name", "Course", "Type" });

		for (int j = 0; j < m.getModules().size(); j++) {
			model1.addRow(new Object[] { m.getModules().get(j).module_id, m.getModules().get(j).module_name,
					m.getModules().get(j).course_id, m.getModules().get(j).module_type });
		}
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(577, 318, 421, 248);
		courses.add(scrollPane_1);

		table_1 = new JTable(model1);
		table_1.setRowSelectionAllowed(false);
		table_1.setFont(new Font("Poppins", Font.PLAIN, 10));
		table_1.setShowVerticalLines(false);
		table_1.setShowHorizontalLines(false);
		table_1.setShowGrid(false);
		table_1.setEnabled(false);
		scrollPane_1.setViewportView(table_1);

		JButton editCourse = new JButton("Update");
		editCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateCourse();
			}
		});
		if(user=="admin") {
			editCourse.setVisible(true);
		}else {
			editCourse.setVisible(false);

		}
		editCourse.setBorderPainted(false);
		editCourse.setBackground(new Color(255, 255, 255));
		editCourse.setForeground(new Color(0, 0, 0));
		editCourse.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		editCourse.setBounds(220, 283, 98, 25);
		courses.add(editCourse);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteCourse();
			}
		});
		if(user=="admin") {
			btnDelete.setVisible(true);
		}else {
			btnDelete.setVisible(false);

		}
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setBounds(394, 283, 87, 25);
		courses.add(btnDelete);


		JButton addCourse = new JButton("Add");
		addCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddCourse();
			}
		});
		
	addCourse.setVisible(false);
		addCourse.setForeground(new Color(0, 0, 0));
		addCourse.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		addCourse.setBorderPainted(false);
		addCourse.setBackground(new Color(255, 255, 255));
		addCourse.setBounds(60, 283, 70, 25);
		addCourse.setVisible(false);
		courses.add(addCourse);
		if(user=="admin") {
			addCourse.setVisible(true);
		}
		JButton addModule = new JButton(" Add Module");
		addModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddModule();
			}
		});
		addModule.setVisible(false);
		addModule.setForeground(new Color(0, 0, 0));
		addModule.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		addModule.setBorderPainted(false);
		addModule.setBackground(new Color(255, 255, 255));
		addModule.setBounds(577, 283, 124, 25);
		courses.add(addModule);
if(user=="admin") {
	addModule.setVisible(true);
		}else {
			addModule.setVisible(false);
		}
		
		JButton deleteModule = new JButton("Delete Module");
		deleteModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteModule();
			}
		});
		
		deleteModule.setForeground(new Color(0, 0, 0));
		deleteModule.setVisible(false);
		deleteModule.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		deleteModule.setBorderPainted(false);
		deleteModule.setBackground(new Color(255, 255, 255));
		deleteModule.setBounds(854, 283, 144, 25);
		courses.add(deleteModule);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setBackground(Color.BLACK);
		panel_1_1.setBounds(0, 0, 1066, 86);
		courses.add(panel_1_1);
	
		JButton btnNewButton_2 = new JButton("Dashboard", dashboardIcon);
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	  card.show(panel_2, "dashboard");
			        frame.revalidate();
			        frame.repaint();
		    }
		});
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(Color.WHITE);

		// Courses button
		JButton btnCourses_1 = new JButton("Courses", coursesIcon);
		btnCourses_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnCourses_1.setBorderPainted(false);
		btnCourses_1.setBackground(Color.WHITE);

		// Tutors button
		JButton btnTutors_1 = new JButton("Tutors", tutorsIcon);
		btnTutors_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  card.show(panel_2, "tutors");
			        frame.revalidate();
			}
		});
		btnTutors_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnTutors_1.setBorderPainted(false);
		btnTutors_1.setBackground(Color.WHITE);

		// Mail button
		JButton btnMail_1 = new JButton("Mail", mailIcon);
		btnMail_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop = Desktop.getDesktop();

		        // Pushing to browser
		        try {
		            desktop.browse(new URI("https://gmail.com/"));
		        } catch (IOException | URISyntaxException e1) {
		            e1.printStackTrace();
		        }
			}
		});
		btnMail_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnMail_1.setBorderPainted(false);
		btnMail_1.setBackground(Color.WHITE);

		// Settings button
		JButton btnSettings_1 = new JButton("Setting", settingsIcon);
		btnSettings_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  card.show(panel_2, "setting");
			        frame.revalidate();
			}
		});
		btnSettings_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnSettings_1.setBorderPainted(false);
		btnSettings_1.setBackground(Color.WHITE);

		// Logout button
		JButton btnLogOut_1 = new JButton("Logout", logoutIcon);
		btnLogOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new Login();
			        frame.setVisible(false);
			        frame.dispose();
			}
		});
		btnLogOut_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnLogOut_1.setBorderPainted(false);
		btnLogOut_1.setBackground(Color.WHITE);

		// JLabels
		JLabel lblNewLabel_9_1 = new JLabel("User mode is :");
		lblNewLabel_9_1.setForeground(Color.WHITE);
		lblNewLabel_9_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));

		JLabel lblNewLabel_5_1 = new JLabel(""+ user);
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));

		// GroupLayout
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addComponent(btnNewButton_2)
							.addGap(43)
							.addComponent(btnCourses_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnTutors_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(btnMail_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addComponent(btnSettings_1)
							.addGap(44)
							.addComponent(btnLogOut_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addComponent(lblNewLabel_9_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnTutors_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCourses_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnMail_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLogOut_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSettings_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5_1)
						.addComponent(lblNewLabel_9_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		panel_1_1.setLayout(gl_panel_1_1);
		panel_1_1.setLayout(gl_panel_1_1);
		if(user=="admin") {
			deleteModule.setVisible(true);
				}else {
					deleteModule.setVisible(false);
				}

		JPanel tutors = new JPanel();
		tutors.setBackground(new Color(0, 0, 0));
		panel_2.add(tutors, "tutors");

		JLabel lblNewLabel_2_2_1 = new JLabel("Total No of Teachers :");
		lblNewLabel_2_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2_1.setBounds(251, 128, 289, 46);
		lblNewLabel_2_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 28));

		JLabel lblNewLabel_2_2_3 = new JLabel("Tutors");
		lblNewLabel_2_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2_3.setBounds(10, 92, 92, 46);
		lblNewLabel_2_2_3.setFont(new Font("Bahnschrift", Font.BOLD, 30));

		JLabel lblNewLabel_7_1 = new JLabel("" + i.getInstructor().size());
		lblNewLabel_7_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_7_1.setBounds(538, 112, 108, 69);
		lblNewLabel_7_1.setFont(new Font("Poppins", Font.BOLD, 63));
		tutors.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setEnabled(false);
		scrollPane_2.setBounds(80, 240, 397, 356);
		tutors.add(scrollPane_2);

		DefaultTableModel instructTable = new DefaultTableModel();
		instructTable.setColumnIdentifiers(new String[] { "ID", "Name", "Email", "Phone" });
		for (int j = 0; j < i.getInstructor().size(); j++) {
			instructTable.addRow(new Object[] { i.getInstructor().get(j).id, i.getInstructor().get(j).name,
					i.getInstructor().get(j).email, i.getInstructor().get(j).phone });
		}
		instructorTable = new JTable(instructTable);
		instructorTable.setBackground(new Color(255, 255, 255));
		instructorTable.setFont(new Font("Poppins", Font.PLAIN, 10));
		instructorTable.setRowSelectionAllowed(false);
		instructorTable.setShowVerticalLines(false);
		instructorTable.setShowHorizontalLines(false);
		instructorTable.setShowGrid(false);
		instructorTable.setEnabled(false);
		scrollPane_2.setViewportView(instructorTable);
		tutors.add(lblNewLabel_2_2_3);
		tutors.add(lblNewLabel_7_1);
		tutors.add(lblNewLabel_2_2_1);

		JButton editTutor = new JButton("Add Tutor");
		editTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddInstructor();
			}
		});
		editTutor.setForeground(new Color(0, 0, 0));
		editTutor.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		editTutor.setBorderPainted(false);
		editTutor.setBackground(new Color(255, 255, 255));
		editTutor.setBounds(205, 205, 108, 25);
		tutors.add(editTutor);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(557, 240, 432, 356);
		tutors.add(scrollPane_3);

		DefaultTableModel assignTable = new DefaultTableModel();
		ArrayList<AssignedModule> assigned = new ArrayList<>();
		assigned = i.assignedModuleView();
		assignTable.setColumnIdentifiers(new String[] { "Instructor ID", "Module Name" });
		for (int k = 0; k < i.assignedModuleView().size(); k++) {
			assignTable.addRow(new Object[] { assigned.get(k).instructorId, assigned.get(k).moduleName });
		}

		table_2 = new JTable(assignTable);
		scrollPane_3.setViewportView(table_2);
		
		JButton deleteTutor = new JButton("Delete Tutor");
		deleteTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteInstructor();
				
			}
		});
		if(user=="admin"){
			deleteTutor.setVisible(true);
			
		}else {
			deleteTutor.setVisible(false);
		}
		deleteTutor.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		deleteTutor.setForeground(new Color(0, 0, 0));
		deleteTutor.setBackground(new Color(255, 255, 255));
		deleteTutor.setBorderPainted(false);
		deleteTutor.setBounds(340, 205, 131, 25);
		tutors.add(deleteTutor);
		
		JButton assignModule = new JButton("Assign Module");
		assignModule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AssignModule();
			}
		});
		if(user=="admin") {
			assignModule.setVisible(true);
		}else {
			assignModule.setVisible(false);
		}
		assignModule.setForeground(new Color(0, 0, 0));
		assignModule.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		assignModule.setBorderPainted(false);
		assignModule.setBackground(new Color(255, 255, 255));
		assignModule.setBounds(699, 205, 145, 25);
		tutors.add(assignModule);
		
		Panel panel_1_1_1 = new Panel();
		panel_1_1_1.setBackground(Color.BLACK);
		panel_1_1_1.setBounds(0, 0, 1066, 86);
		tutors.add(panel_1_1_1);
		
		// Dashboard button
		JButton btnNewButton_2_2 = new JButton("Dashboard", dashboardIcon);
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_2, "dashboard");
		        frame.revalidate();
		        frame.repaint();
			}
		});
		btnNewButton_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton_2_2.setBorderPainted(false);
		btnNewButton_2_2.setBackground(Color.WHITE);

		// Courses button
		JButton btnCourses_1_1 = new JButton("Courses", coursesIcon);
		btnCourses_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_2, "course");
		        frame.revalidate();
			}
		});
		btnCourses_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnCourses_1_1.setBorderPainted(false);
		btnCourses_1_1.setBackground(Color.WHITE);

		// Tutors button
		JButton btnTutors_1_1 = new JButton("Tutors", tutorsIcon);
		btnTutors_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnTutors_1_1.setBorderPainted(false);
		btnTutors_1_1.setBackground(Color.WHITE);

		// Mail button
		JButton btnMail_1_1 = new JButton("Mail", mailIcon);
		btnMail_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 desktop = Desktop.getDesktop();

			        // Pushing to browser
			        try {
			            desktop.browse(new URI("https://gmail.com/"));
			        } catch (IOException | URISyntaxException e1) {
			            e1.printStackTrace();
			        }
			}
		});
		btnMail_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnMail_1_1.setBorderPainted(false);
		btnMail_1_1.setBackground(Color.WHITE);

		// Settings button
		JButton btnSettings_1_1 = new JButton("Setting", settingsIcon);
		btnSettings_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 card.show(panel_2, "setting");
			        frame.revalidate();
			}
		});
		btnSettings_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnSettings_1_1.setBorderPainted(false);
		btnSettings_1_1.setBackground(Color.WHITE);

		// Logout button
		JButton btnLogOut_1_1 = new JButton("Logout", logoutIcon);
		btnLogOut_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new Login();
			        frame.setVisible(false);
			        frame.dispose();
			}
		});
		btnLogOut_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnLogOut_1_1.setBorderPainted(false);
		btnLogOut_1_1.setBackground(Color.WHITE);

		
		JLabel lblNewLabel_9_1_1 = new JLabel("User mode is :");
		lblNewLabel_9_1_1.setForeground(Color.WHITE);
		lblNewLabel_9_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		
		JLabel lblNewLabel_5_1_1 = new JLabel("" + user );
		lblNewLabel_5_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		GroupLayout gl_panel_1_1_1 = new GroupLayout(panel_1_1_1);
		gl_panel_1_1_1.setHorizontalGroup(
			gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1_1_1.createSequentialGroup()
							.addComponent(btnNewButton_2_2)
							.addGap(43)
							.addComponent(btnCourses_1_1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(btnTutors_1_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(btnMail_1_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addComponent(btnSettings_1_1)
							.addGap(44)
							.addComponent(btnLogOut_1_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_1_1.createSequentialGroup()
							.addComponent(lblNewLabel_9_1_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5_1_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1_1_1.setVerticalGroup(
			gl_panel_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_2_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnTutors_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCourses_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnMail_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLogOut_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSettings_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5_1_1)
						.addComponent(lblNewLabel_9_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1_1_1.setLayout(gl_panel_1_1_1);
		editTutor.setVisible(false);
		if (user==("admin")) {
			editTutor.setVisible(true);
		}else {
			editTutor.setVisible(false);
		}

		JPanel setting = new JPanel();
		setting.setBackground(new Color(0, 0, 0));
		panel_2.add(setting, "setting");

		JLabel lblNewLabel_2_2_2 = new JLabel("Setting");
		lblNewLabel_2_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2_2.setBounds(10, 92, 126, 39);
		lblNewLabel_2_2_2.setFont(new Font("Bahnschrift", Font.BOLD, 30));

		JLabel lblNewLabel_9_2 = new JLabel("Email:");
		lblNewLabel_9_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_9_2.setBounds(252, 178, 67, 25);
		lblNewLabel_9_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));

		JLabel lblNewLabel_9_3 = new JLabel("Old Password :");
		lblNewLabel_9_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_9_3.setBounds(309, 231, 113, 20);
		lblNewLabel_9_3.setFont(new Font("Bahnschrift", Font.PLAIN, 15));

		pwdOldPassword = new JPasswordField();
		pwdOldPassword.setForeground(new Color(255, 255, 255));
		pwdOldPassword.setBackground(new Color(255, 255, 255));
		pwdOldPassword.setBounds(427, 230, 179, 22);
		pwdOldPassword.setEchoChar('*');

		JLabel lblNewLabel_9_3_1 = new JLabel("New Password :");
		lblNewLabel_9_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_9_3_1.setBounds(309, 274, 113, 20);
		lblNewLabel_9_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));

		JButton btnNewButton_1_1 = new JButton("Change");
		btnNewButton_1_1.setBounds(465, 315, 89, 30);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPass = new String(pwdNewPass.getPassword());
				String oldPass = new String(pwdOldPassword.getPassword()) ;
				Admin a = new Admin();
				if(user=="students") {
					s.changePassword(emailInfo, oldPass, newPass);
				 } else if(user=="instructors"){
					 i.changePassword(emailInfo, oldPass, newPass);
				 }else if(user=="admin") {
					 a.changePassword(emailInfo, oldPass, newPass);
				 }
			}
		});
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		
		JLabel lblNewLabel_9_2_1 = new JLabel(emailInfo);
		lblNewLabel_9_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_9_2_1.setBounds(309, 182, 192, 16);
		lblNewLabel_9_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		setting.setLayout(null);
		
		pwdNewPass = new JPasswordField();
		pwdNewPass.setBounds(427, 273, 179, 22);
		pwdNewPass.setEchoChar('*');
		setting.add(pwdNewPass);
		setting.add(lblNewLabel_9_3);
		setting.add(pwdOldPassword);
		setting.add(lblNewLabel_9_2);
		setting.add(lblNewLabel_9_2_1);
		setting.add(lblNewLabel_9_3_1);
		setting.add(lblNewLabel_2_2_2);
		setting.add(btnNewButton_1_1);
		
		JButton generateReport = new JButton("Generate Report ");
		generateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GenerateReport();
			}
		});
		if(user!="students") {
			generateReport.setVisible(true);
		}else {
			generateReport.setVisible(false);
		}
		
		generateReport.setForeground(new Color(0, 0, 0));
		generateReport.setBackground(new Color(255, 255, 255));
		generateReport.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		generateReport.setBorderPainted(false);
		generateReport.setBounds(262, 498, 160, 25);
		setting.add(generateReport);
		
		JButton btnNewButton_2_1 = new JButton("View Report");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewReport();
			}
		});
		btnNewButton_2_1.setForeground(new Color(0, 0, 0));
		btnNewButton_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnNewButton_2_1.setBorderPainted(false);
		btnNewButton_2_1.setBackground(new Color(255, 255, 255));
		btnNewButton_2_1.setBounds(658, 498, 119, 25);
		setting.add(btnNewButton_2_1);
		
		Panel panel_1_1_1_1 = new Panel();
		panel_1_1_1_1.setBackground(Color.BLACK);
		panel_1_1_1_1.setBounds(0, 0, 1066, 86);
		setting.add(panel_1_1_1_1);
		
		// Dashboard button
		JButton btnNewButton_2_2_1 = new JButton("Dashboard", dashboardIcon);
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 card.show(panel_2, "dashboard");
			        frame.revalidate();
			        frame.repaint();
			}
		});
		btnNewButton_2_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnNewButton_2_2_1.setBorderPainted(false);
		btnNewButton_2_2_1.setBackground(Color.WHITE);

		// Courses button

		JButton btnCourses_1_1_1 = new JButton("Courses", coursesIcon);
		btnCourses_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 card.show(panel_2, "course");
			        frame.revalidate();
			}
		});
		btnCourses_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnCourses_1_1_1.setBorderPainted(false);
		btnCourses_1_1_1.setBackground(Color.WHITE);

		// Tutors button
		JButton btnTutors_1_1_1 = new JButton("Tutors", tutorsIcon);
		btnTutors_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_2, "tutors");
		        frame.revalidate();
			}
		});
		btnTutors_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnTutors_1_1_1.setBorderPainted(false);
		btnTutors_1_1_1.setBackground(Color.WHITE);

		// Mail button
		JButton btnMail_1_1_1 = new JButton("Mail", mailIcon);
		btnMail_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop = Desktop.getDesktop();

		        // Pushing to browser
		        try {
		            desktop.browse(new URI("https://gmail.com/"));
		        } catch (IOException | URISyntaxException e1) {
		            e1.printStackTrace();
		        }
			}
		});
		btnMail_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnMail_1_1_1.setBorderPainted(false);
		btnMail_1_1_1.setBackground(Color.WHITE);

		// Settings button
		JButton btnSettings_1_1_1 = new JButton("Setting", settingsIcon);
		btnSettings_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_2, "setting");
		        frame.revalidate();
				
			}
		});
		btnSettings_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnSettings_1_1_1.setBorderPainted(false);
		btnSettings_1_1_1.setBackground(Color.WHITE);

		// Logout button
		JButton btnLogOut_1_1_1 = new JButton("Logout", logoutIcon);
		btnLogOut_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
		        frame.setVisible(false);
		        frame.dispose();
		
			}
		});
		btnLogOut_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		btnLogOut_1_1_1.setBorderPainted(false);
		btnLogOut_1_1_1.setBackground(Color.WHITE);

		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("User mode is :");
		lblNewLabel_9_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_9_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("" + user);
		lblNewLabel_5_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_5_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		GroupLayout gl_panel_1_1_1_1 = new GroupLayout(panel_1_1_1_1);
		gl_panel_1_1_1_1.setHorizontalGroup(
			gl_panel_1_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1_1_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1_1_1_1.createSequentialGroup()
							.addComponent(btnNewButton_2_2_1)
							.addGap(43)
							.addComponent(btnCourses_1_1_1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(btnTutors_1_1_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(btnMail_1_1_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addComponent(btnSettings_1_1_1)
							.addGap(44)
							.addComponent(btnLogOut_1_1_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_1_1_1.createSequentialGroup()
							.addComponent(lblNewLabel_9_1_1_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5_1_1_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1_1_1_1.setVerticalGroup(
			gl_panel_1_1_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1_1_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1_1_1_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1_1_1_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton_2_2_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnTutors_1_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCourses_1_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1_1_1_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnMail_1_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLogOut_1_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSettings_1_1_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1_1_1_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5_1_1_1)
						.addComponent(lblNewLabel_9_1_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1_1_1_1.setLayout(gl_panel_1_1_1_1);

	}
}

