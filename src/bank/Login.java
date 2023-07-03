package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel jLabel, password, jlabel1;
    JTextField jTextField;
    JButton login;
    JPasswordField jPasswordField;

    Login() {

        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        jLabel = new JLabel("Log in to your Account");//label to display text meesage
        jLabel.setBounds(200, 30, 300, 40);
        add(jLabel);//adding labal to Frame
        jLabel.setForeground(Color.white);
        jLabel.setFont(new Font("", Font.PLAIN, 30));

        jlabel1 = new JLabel("Username");//label to display text meesage
        jlabel1.setBounds(200, 120, 200, 30);
        add(jlabel1);
        jlabel1.setFont(new Font("Arial", Font.BOLD, 20));
        jlabel1.setForeground(Color.WHITE);

        jTextField = new JTextField();//insert option
        jTextField.setBounds(340, 120, 200, 30);
        jTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(jTextField);

        password = new JLabel("Password");//label to display text meesage
        password.setBounds(210, 220, 200, 30);
        add(password);
        password.setFont(new Font("Arial", Font.BOLD, 20));
        password.setForeground(Color.WHITE);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(340, 220, 200, 30);
        jPasswordField.setFont(new Font("Arial", Font.BOLD, 14));

        add(jPasswordField);

        login = new JButton("Log in");//obj of button creating button
        login.setBounds(220, 330, 260, 40);//set where to place button in frame and size of button
        login.setFont(new Font("Arial", Font.BOLD, 16));
        login.setBackground(Color.WHITE);
        login.setForeground(Color.black);
        add(login);

        login.addActionListener(this);

        ImageIcon icon = new ImageIcon("C:\\Users\\COSMOS\\Documents\\NetBeansProjects\\Bank\\src\\icons\\logo.jpg");
        setIconImage(icon.getImage());
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1010, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 500);
        add(image);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            Conn c = new Conn();
            try {
                if (e.getSource() == login) {
                    String user = jTextField.getText();
                    String pw = jPasswordField.getText();

                    String q = "select * from login where username='" + user + "' and password='" + pw + "'";

                    ResultSet r = c.s.executeQuery(q);

                    if (r.next()) {
                        setVisible(false);
                        new MainFrame(user).setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                    }

                }
                c.con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);

            }

        }
    }
}
