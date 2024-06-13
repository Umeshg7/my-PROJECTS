package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import validation.Validation;
import courses.Courses;
import exception.InvalidFormat;
import exception.NullException;
import users.Instructor;
import users.Student;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateAcc {

    private JFrame frame;
    private JPanel panel;
    private JPanel panel_1;
    private JLabel lblNewLabel;
    private JTextField username;
    private JTextField email;
    private JPasswordField password;
    private JTextField phone;
    private JComboBox<String> rolesSelect;
    private JComboBox<String> course;
    private JButton btnCreate;
    private JButton btnNewButton;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;

    /**
     * Create the application.
     */
    public CreateAcc() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 825, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        frame.getContentPane().add(panel, BorderLayout.NORTH);

        lblNewLabel = new JLabel("Create Account");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
        panel.add(lblNewLabel);

        
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(0, 0, 0));
        frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
        
        // Initialize image label
        lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setAlignmentX(0.5f);
        lblNewLabel_2.setBounds(-50, 90, 553, 380);
        Image logo = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
        lblNewLabel_2.setIcon(new ImageIcon(logo));
        panel_1.add(lblNewLabel_2);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 12));
        username.setForeground(new Color(0, 0, 0));
        username.setBackground(new Color(128, 128, 128));
        username.setToolTipText("");
        username.setColumns(10);
        username.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 12));
        email.setBackground(new Color(128, 128, 128));
        email.setToolTipText("");
        email.setColumns(10);
        email.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

        password = new JPasswordField();
        password.setFont(new Font("Tahoma", Font.PLAIN, 12));
        password.setBackground(new Color(128, 128, 128));
        password.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

        phone = new JTextField();
        phone.setFont(new Font("Tahoma", Font.PLAIN, 12));
        phone.setBackground(new Color(128, 128, 128));
        phone.setToolTipText("");
        phone.setColumns(10);
        phone.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

        rolesSelect = new JComboBox<>(new String[] { "Student", "Instructor" });

        rolesSelect.setForeground(Color.BLACK);
        rolesSelect.setFont(new Font("Poppins", Font.PLAIN, 14));
        rolesSelect.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        rolesSelect.setBackground(new Color(128, 128, 128));

        ArrayList<Courses> cor = new ArrayList<Courses>();
        Courses c = new Courses();
        cor = c.getCourse();
        // cor.toArray();

        course = new JComboBox<String>();
        for (int i = 0; i < cor.size(); i++) {
            course.addItem(cor.get(i).course_name);
        }
        course.setForeground(Color.BLACK);
        course.setFont(new Font("Poppins", Font.PLAIN, 14));
        course.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        course.setBackground(new Color(128, 128, 128));

        Student s = new Student();
        btnCreate = new JButton("Create");
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Instructor i = new Instructor();
                String uname = username.getText();
                String p = new String(password.getPassword());
                String em = email.getText();
                String ph = phone.getText();
                Validation v = new Validation();
                int courseId = c.getCourseId(course.getSelectedItem().toString());
                try {
                    if (v.emailCheck(em) && v.phoneCheck(ph) && v.passCheck(p)){
                        if(rolesSelect.getSelectedItem().equals("Student")) {
                            s.studentRegister(uname,courseId, em, p, ph, 1);
                        }else {
                            i.addInstructor(uname, em, ph, p);
                        }
                        frame.dispose();
                        new Login();
                    }
                    
                } catch (NullException ex) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } catch (InvalidFormat ex1) {
                    JOptionPane.showMessageDialog(null, "Invalid Email or Phone Number or Password Format");
                }

            }
        });
        btnCreate.setForeground(new Color(248, 248, 248));
        btnCreate.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        btnCreate.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        btnCreate.setBackground(new Color(128, 128, 128));

        btnNewButton = new JButton("Log In");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });
        btnNewButton.setForeground(new Color(248, 248, 248));
        btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        btnNewButton.setBackground(new Color(128, 128, 128));

        
        JLabel lblNewLabel_1 = new JLabel("Enter Username :");
        lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));

        JLabel lblNewLabel_1_1 = new JLabel("Enter Email:");
        lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));

        JLabel lblNewLabel_1_2 = new JLabel("Enter Password:\r\n");
        lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));

        JLabel lblNewLabel_1_3 = new JLabel("Enter Phone Number:");
        lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));

        lblNewLabel_2 = new JLabel("Select Role:");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));

        lblNewLabel_3 = new JLabel("Select Course:");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addGap(520)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                            .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(Alignment.TRAILING, gl_panel_1.createParallelGroup(Alignment.LEADING)
                            .addGroup(gl_panel_1.createSequentialGroup()
                                .addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(145, Short.MAX_VALUE))
                            .addGroup(gl_panel_1.createSequentialGroup()
                                .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(gl_panel_1.createSequentialGroup()
                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(gl_panel_1.createSequentialGroup()
                                .addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(gl_panel_1.createSequentialGroup()
                                .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
                                .addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(phone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                    .addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
                                        .addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                                        .addGap(35)
                                        .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                                    .addComponent(course, Alignment.LEADING, 0, 228, Short.MAX_VALUE)
                                    .addComponent(rolesSelect, Alignment.LEADING, 0, 228, Short.MAX_VALUE)
                                    .addComponent(password, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                    .addComponent(username, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                    .addComponent(email, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                                .addGap(63)))))
        );
        gl_panel_1.setVerticalGroup(
            gl_panel_1.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panel_1.createSequentialGroup()
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_panel_1.createSequentialGroup()
                            .addGap(108)
                            .addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_panel_1.createSequentialGroup()
                            .addGap(22)
                            .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(username, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                    .addGap(2)
                    .addComponent(phone, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(password, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(email, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addGap(23)
                    .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(rolesSelect, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                    .addGap(5)
                    .addComponent(course, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addGap(42)
                    .addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(56, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        frame.setVisible(true);

    }
}
