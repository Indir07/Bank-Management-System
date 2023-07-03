package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome extends JFrame implements ActionListener {

    JLabel intro;

    JButton login, register;

    public Welcome() {

        setTitle("Bank Management System");
        setLayout(null);
        setSize(700, 500);
        setLocationRelativeTo(null);

        intro = new JLabel("Welcome to Bank Portal");//label to display text meesage
        intro.setBounds(100, 60, 500, 80);
        add(intro);//adding labal to Frame
        intro.setForeground(Color.BLUE);

        intro.setFont(new Font(intro.getFont().getName(), Font.ITALIC, 40));

        login = new JButton("Log  in");
        login.setBounds(260, 200, 200, 40);
        add(login);
        login.setFont(new Font(intro.getFont().getName(), Font.PLAIN, 20));
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);

        register = new JButton("Register your Account");//obj of button creating button
        register.setBounds(240, 285, 250, 40);//set where to place button in frame and size of button
        add(register);
        register.setFont(new Font(intro.getFont().getName(), Font.PLAIN, 20));
        register.setBackground(Color.black);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);

        ImageIcon icon = new ImageIcon("C:\\Users\\COSMOS\\Documents\\NetBeansProjects\\Bank\\src\\icons\\logo.jpg");
        setIconImage(icon.getImage());
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 500);
        add(image);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            setVisible(false);
            new Login().setVisible(true);

        } else if (e.getSource() == register) {
            new SingUp().setVisible(true);

        }

    }
    
    public static void main(String[] args) {
        new Welcome().setVisible(true);

    }
    
}
