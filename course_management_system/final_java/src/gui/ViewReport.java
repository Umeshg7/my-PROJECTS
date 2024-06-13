package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import exception.NullException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewReport {

    private JFrame frame;
    private JTextField textField;

    public ViewReport() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Results");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        frame.getContentPane().add(panel_1, BorderLayout.CENTER);

        textField = new JTextField();
        textField.setBounds(145, 38, 106, 22);
        textField.setFont(new Font("Poppins", Font.PLAIN, 10));
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Student ID");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(160, 10, 77, 16);
        lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));

        JButton btnNewButton = new JButton("View");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textField.getText());
                    new StudentResult(id);
                } catch (NullException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Fill the empty box!!", "Error!",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        btnNewButton.setBounds(283, 37, 77, 25);
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btnNewButton.setBackground(new Color(255, 255, 255));

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[] { "Module Name", "Marks" });
        panel_1.setLayout(null);
        panel_1.add(textField);
        panel_1.add(lblNewLabel_1);
        panel_1.add(btnNewButton);
        frame.setVisible(true);
    }
}
