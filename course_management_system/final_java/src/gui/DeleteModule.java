package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import courses.Modules;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteModule {

	private JFrame frame;
	private JTextField midText;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public DeleteModule() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Delete Module");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		midText = new JTextField();
		midText.setFont(new Font("Poppins", Font.PLAIN, 10));
		midText.setBounds(160, 51, 105, 19);
		panel_1.add(midText);
		midText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Module ID");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(160, 29, 88, 19);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Delete Module");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modules m = new Modules();
				m.deleteModule(Integer.parseInt(midText.getText()));
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnNewButton.setBounds(154, 111, 127, 27);
		panel_1.add(btnNewButton);
	}

}
