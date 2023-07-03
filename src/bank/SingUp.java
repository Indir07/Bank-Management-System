package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingUp extends JFrame implements ActionListener {

    JLabel jlabel2, username;

    JTextField fnameField, userText, lnameField, eTextField;
    JButton signup;
    JPasswordField jPasswordField;

    SingUp() {

        setTitle("NEW ACCOUNT REGISTERATION FORM");

        setLayout(null);

        JLabel j = new JLabel();
        j.setBounds(200, 20, 300, 30);
        j.setText("Registration Form");
        j.setFont(new Font("", Font.PLAIN, 25));
        j.setForeground(Color.white);
        add(j);

        jlabel2 = new JLabel();
        jlabel2.setBounds(150, 80, 200, 20);
        jlabel2.setText("First Name");
        add(jlabel2);
        jlabel2.setFont(new Font("Arila", Font.BOLD, 18));
        jlabel2.setForeground(Color.white);

        fnameField = new JTextField();
        fnameField.setBounds(350, 80, 200, 30);
        fnameField.setFont(new Font("Arial", Font.BOLD, 14));

        add(fnameField);
        // jTextField1.setText("Enter your name here");

        jlabel2 = new JLabel();
        jlabel2.setBounds(150, 130, 200, 20);
        jlabel2.setText("Last Name:");
        add(jlabel2);
        jlabel2.setFont(new Font("", Font.BOLD, 18));
        jlabel2.setForeground(Color.white);

        lnameField = new JTextField();
        lnameField.setBounds(350, 130, 200, 30);
        lnameField.setFont(new Font("Arial", Font.BOLD, 14));

        add(lnameField);

        username = new JLabel();
        username.setBounds(150, 180, 200, 20);
        username.setText("User Name:");
        add(username);
        username.setFont(new Font("", Font.BOLD, 18));
        username.setForeground(Color.white);

        userText = new JTextField();
        userText.setBounds(350, 180, 200, 30);
        userText.setFont(new Font("Arial", Font.BOLD, 14));
        add(userText);

        jlabel2 = new JLabel();
        jlabel2.setBounds(150, 230, 200, 20);
        jlabel2.setText("Email");
        add(jlabel2);
        jlabel2.setFont(new Font("Arial", Font.BOLD, 18));
        jlabel2.setForeground(Color.white);

        eTextField = new JTextField();
        eTextField.setBounds(350, 230, 200, 30);
        eTextField.setFont(new Font("Arial", Font.BOLD, 14));

        add(eTextField);

        jlabel2 = new JLabel();
        jlabel2.setBounds(150, 280, 200, 20);
        jlabel2.setText("Password:");
        add(jlabel2);
        jlabel2.setFont(new Font("Arial", Font.BOLD, 18));
        jlabel2.setForeground(Color.white);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(350, 280, 200, 30);
        jPasswordField.setFont(new Font("Arial", Font.BOLD, 14));

        add(jPasswordField);

        signup = new JButton("Sign up");
        signup.setBounds(200, 360, 300, 35);
        signup.setFont(new Font("Arial", Font.PLAIN, 14));
        add(signup);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);

        ImageIcon icon = new ImageIcon("C:\\Users\\COSMOS\\Documents\\NetBeansProjects\\Bank\\src\\icons\\logo.jpg");
        setIconImage(icon.getImage());
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 500);
        add(image);

        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String fname = fnameField.getText();
        String lname = lnameField.getText();
        String email = eTextField.getText();
        String user = userText.getText();
        String pw = jPasswordField.getText();

        if (e.getSource() == signup) {

            if (fnameField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else if (lnameField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else if (eTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else if (userText.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else if (jPasswordField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {

                Conn c = new Conn();
                String bal = "0.0";
                try {
                    String q = "insert into signup values('" + user + "','" + fname + "','" + lname + "','" + email + "')";
                    c.s.executeUpdate(q);

                    String q1 = "insert into login values('" + user + "','" + pw + "')";
                    c.s.executeUpdate(q1);

                    String q3 = "insert into balance values('" + user + "','" + bal + "')";
                    c.s.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null, " ACOUNT REGISTERED SUCCESSFULLY!");
                    setVisible(false);
                    //new Login().setVisible(true);

                    c.con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

        }

    }
}
