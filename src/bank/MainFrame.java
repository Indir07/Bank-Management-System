package Bank;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.sql.*;
import javax.swing.ImageIcon;

class MainFrame extends JFrame implements ActionListener {

    JButton transfer_button, deposit, utility_bills, logout, my_info, currentbalancebutton,
            send, pay, depositButton;

    JTextField currentbalancefield, amount, billAmount, depositAmount, bankName, depositAccountNumber, billType, billID, firstnameField, lastnameField, usernameField, emailField;

    JFrame infoFrame, utilityBillsFrame, depositFrame, transferFrame;

    JLabel firstnameLabel, lastnameLabel, usernameLabel, emailLabel;

    String userName;

    MainFrame(String Username) {
        this.userName = Username;

        // Current Balance Buttons
        currentbalancebutton = new JButton("Current Balance");
        currentbalancebutton.setFont(new Font("Bold", Font.PLAIN, 20));
        currentbalancebutton.setForeground(Color.white);
        currentbalancebutton.setBackground(Color.gray);
        currentbalancebutton.setBorder(new LineBorder(Color.black, 12));
        currentbalancebutton.setBounds(15, 90, 180, 50);

        // Balance TextField
        currentbalancefield = new JTextField("");
        currentbalancefield.setBounds(210, 90, 150, 50);
        currentbalancefield.setEditable(false);
        currentbalancefield.setFont(new Font("Arial", Font.BOLD, 22));
        currentbalancefield.setForeground(Color.WHITE);
        currentbalancefield.setBackground(Color.gray);
        viewBalance();

        transfer_button = new JButton("Send Money");
        transfer_button.setBounds(20, 210, 150, 50);
        transfer_button.setFont(new Font("Bold", Font.PLAIN, 18));
        transfer_button.setForeground(Color.BLACK);
        transfer_button.setBackground(Color.gray);
        currentbalancebutton.setBorder(new LineBorder(Color.white, 8));
        transfer_button.addActionListener(this);

        // Buttons Inside transfer frame
        // Send Money Button
        send = new JButton("Send");
        send.setBounds(150, 200, 80, 60);
        send.addActionListener(this);

        deposit = new JButton("Deposit");
        deposit.setBounds(400, 210, 165, 50);
        deposit.setFont(new Font("Bold", Font.PLAIN, 18));
        deposit.setForeground(Color.BLACK);
        deposit.setBackground(Color.gray);
        deposit.addActionListener(this);

        // Utility Bills Button
        utility_bills = new JButton("Utility Bills");
        utility_bills.setBounds(20, 350, 150, 50);
        utility_bills.setFont(new Font("Bold", Font.PLAIN, 18));
        utility_bills.setForeground(Color.BLACK);
        utility_bills.setBackground(Color.gray);
        utility_bills.addActionListener(this);

        // MY INFO Button
        my_info = new JButton("My Info");
        my_info.setBounds(400, 350, 165, 50);
        my_info.setFont(new Font("Bold", Font.PLAIN, 18));
        my_info.setForeground(Color.BLACK);
        my_info.setBackground(Color.gray);
        my_info.addActionListener(this);

        // Logout Button
        logout = new JButton("Logout");
        logout.setBounds(210, 270, 160, 50);
        logout.setFont(new Font("Bold", Font.PLAIN, 18));
        logout.setForeground(Color.BLACK);
        logout.setBackground(Color.gray);
        logout.addActionListener(this);

        

        // Add buttons to frame
        getContentPane().add(transfer_button);
        getContentPane().add(deposit);
        getContentPane().add(utility_bills);
        getContentPane().add(my_info);
        getContentPane().add(logout);
        getContentPane().add(currentbalancebutton);
        getContentPane().add(currentbalancefield);

        ImageIcon icon = new ImageIcon("C:\\Users\\COSMOS\\Documents\\NetBeansProjects\\Bank\\src\\icons\\logo.jpg");
        setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icon.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 600);
        add(image);
        
        // Set frame properties
        setTitle("Bank Management System");
        setSize(600, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null); // Set layout to null to use absolute positioning
        getContentPane().setBackground(Color.black);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == transfer_button) {
            transferFrame = new JFrame();
            ImageIcon icon = new ImageIcon("C:\\Users\\COSMOS\\Documents\\NetBeansProjects\\Bank\\src\\icons\\logo.jpg");
            transferFrame.setIconImage(icon.getImage());

            transferFrame.setLayout(new FlowLayout());
            transferFrame.setLayout(null);
            JTextField u = new JTextField("Username");
            u.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (u.getText().equals("Username")) {
                        u.setText("Username");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (u.getText().isEmpty()) {
                        u.setText("Username");
                    }
                }
            });

            u.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (u.getText().equals("Username")) {
                        u.setText("");
                    }
                }
            });
            u.setBounds(120, 50, 150, 50);
            u.setForeground(Color.gray);
            amount = new JTextField("Amount");
            amount.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (amount.getText().equals("Amount")) {
                        amount.setText("Amount");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (amount.getText().isEmpty()) {
                        amount.setText("Amount");
                    }
                }
            });

            amount.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (amount.getText().equals("Amount")) {
                        amount.setText("");
                    }
                }
            });
            amount.setBounds(120, 120, 150, 50);
            amount.setForeground(Color.gray);
            transferFrame.add(u);
            transferFrame.add(amount);
            transferFrame.add(send);
            transferFrame.setSize(400, 400);
            transferFrame.getContentPane().setBackground(Color.BLACK);

            transferFrame.setVisible(true);
            transferFrame.getContentPane().setBackground(Color.blue);
            transferFrame.setLocationRelativeTo(null);
            transferFrame.setResizable(false);
            transferFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            
            
        } else if (e.getSource() == logout) {
            setVisible(false);
            new Welcome().setVisible(true);
        } else if (e.getSource() == send) {

            
            
            // Get the transfer amount from the text field
            double transferamount = Double.parseDouble(amount.getText());

            // Get the current balance from the text field
            double currentBalance = Double.parseDouble(currentbalancefield.getText());
            // Checking if transfer amount is greater than current balance
            if (transferamount > currentBalance) {
                JOptionPane.showMessageDialog(
                        this,
                        "Insufficient balance to transfer amounts.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                transferFrame.setVisible(false);
                new MainFrame(userName).setVisible(true);
                
            } else {
                // Deduct the transfer amount from the current balance
                double newBalance = currentBalance - transferamount;

                // Update the current balance field
                currentbalancefield.setText(String.valueOf(newBalance));
                String newbalance = String.valueOf(newBalance);

                try {
                    Conn c = new Conn();
                    String q = "UPDATE Balance SET balance = balance + ? WHERE Username = ?";
                    PreparedStatement p = c.con.prepareStatement(q);
                    p.setString(1, newbalance);
                    p.setString(2, userName);
                    p.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Amount Transfered successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    transferFrame.setVisible(false);
                    //new MainFrame(userName).setVisible(true);

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        } else if (e.getSource() == deposit) {
            depositFrame = new JFrame();
            ImageIcon icon = new ImageIcon("C:\\Users\\COSMOS\\Documents\\NetBeansProjects\\Bank\\src\\icons\\logo.jpg");
            depositFrame.setIconImage(icon.getImage());
            depositFrame.setSize(400, 400);
            depositFrame.setLayout(new FlowLayout());
            depositFrame.setLayout(null);
            depositAmount = new JTextField("Enter Amount");
            depositAmount.setForeground(Color.LIGHT_GRAY);
            depositAmount.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (depositAmount.getText().equals(" Enter Amount")) {
                        depositAmount.setText(" Enter Amount");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (depositAmount.getText().isEmpty()) {
                        depositAmount.setText("");
                    }
                }
            });

            depositAmount.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (depositAmount.getText().equals("Enter Amount")) {
                        depositAmount.setText("");
                    }
                }
            });
            depositAmount.setBounds(120, 80, 150, 50);

            bankName = new JTextField("Enter Bank Name");
            bankName.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (bankName.getText().equals(" Enter Bank Name")) {
                        bankName.setText(" Enter Bank Name");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (bankName.getText().isEmpty()) {
                        bankName.setText("");
                    }
                }
            });

            bankName.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (bankName.getText().equals("Enter Bank Name")) {
                        bankName.setText("");
                    }
                }
            });
            bankName.setBounds(120, 140, 150, 50);
            bankName.setForeground(Color.LIGHT_GRAY);

            depositAccountNumber = new JTextField("Enter Username");

            depositAmount.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (depositAmount.getText().equals(" Enter Amount")) {
                        depositAmount.setText(" Enter Amount");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (depositAmount.getText().isEmpty()) {
                        depositAmount.setText("");
                    }
                }
            });

            depositAmount.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (depositAmount.getText().equals("Enter Amount")) {
                        depositAmount.setText("");
                    }
                }
            });
            depositAmount.setBounds(120, 80, 150, 50);

            depositAccountNumber = new JTextField("Enter Username");
            depositAccountNumber.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (depositAccountNumber.getText().equals(" Enter Username")) {
                        depositAccountNumber.setText(" Enter Username");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (depositAccountNumber.getText().isEmpty()) {
                        depositAccountNumber.setText("");
                    }
                }
            });

            depositAccountNumber.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (depositAccountNumber.getText().equals("Enter Username")) {
                        depositAccountNumber.setText("");
                    }
                }
            });
            depositAccountNumber.setBounds(120, 200, 150, 50);
            depositAccountNumber.setForeground(Color.LIGHT_GRAY);
            depositButton = new JButton("Deposit");
            depositButton.setBounds(150, 280, 100, 50);
            depositButton.addActionListener(this);
            depositFrame.setVisible(true);
            depositFrame.getContentPane().setBackground(Color.BLACK);
            depositFrame.getContentPane().add(depositButton);
            depositFrame.getContentPane().add(depositAmount);
            depositFrame.getContentPane().add(bankName);
            depositFrame.getContentPane().add(depositAccountNumber);
            depositFrame.getContentPane().setBackground(Color.WHITE);
            depositFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            depositFrame.setLocationRelativeTo(null);
        } else if (e.getSource() == utility_bills) {
            utilityBillsFrame = new JFrame();
            billAmount = new JTextField("Amount");

            billAmount.setBounds(110, 50, 180, 30);

            billType = new JTextField("Enter Bill Type");
            billType.setBounds(110, 110, 180, 30);
            billID = new JTextField("Bill ID");
            billID.setBounds(110, 170, 180, 30);

            pay = new JButton("Pay");
            pay.addActionListener(this);
            pay.setBounds(165, 230, 60, 40);
            utilityBillsFrame.getContentPane().add(billAmount);
            utilityBillsFrame.getContentPane().add(billType);
            utilityBillsFrame.getContentPane().add(billID);
            utilityBillsFrame.getContentPane().add(pay);
            utilityBillsFrame.setLayout(new FlowLayout());
            utilityBillsFrame.setLayout(null);

            utilityBillsFrame.setSize(400, 400);
            utilityBillsFrame.getContentPane().setBackground(Color.black);
            utilityBillsFrame.setResizable(false);
            utilityBillsFrame.setVisible(true);
            utilityBillsFrame.getContentPane().setBackground(Color.BLACK);
            utilityBillsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            utilityBillsFrame.setLocationRelativeTo(null);

        } else if (e.getSource() == pay) {
            // Get the bill amount from the text field
            double billPayAmount = Double.parseDouble(billAmount.getText());

            // Get the current balance from the text field
            double currentBalance = Double.parseDouble(currentbalancefield.getText());
            if (billPayAmount > currentBalance) {
                JOptionPane.showMessageDialog(this,
                        "Insufficient balance to pay this bill.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
                utilityBillsFrame.setVisible(false);
            } else {
                // Deduct the bill amount from the current balance
                double newBalance = currentBalance - billPayAmount;
                String newbalance = String.valueOf(newBalance);
                try {
                    Conn c = new Conn();
                    String q = "UPDATE Balance SET balance = balance + ? WHERE Username = ?";
                    PreparedStatement p = c.con.prepareStatement(q);
                    p.setString(1, newbalance);
                    p.setString(2, userName);
                    p.executeUpdate();

                    utilityBillsFrame.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Bill paid successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                    c.con.close();
                    p.close();
                    
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                // Update the current balance field
                currentbalancefield.setText(String.valueOf(newbalance));

            }
        } else if (e.getSource() == depositButton) {
            // Get Balance from Amount field       
            double dpamount = Double.parseDouble(depositAmount.getText());

//Get Current Balance From textfield
            double currentBalance = Double.parseDouble(currentbalancefield.getText());

            double updatedbalance = currentBalance + dpamount;
            String amount1 = String.valueOf(updatedbalance);
            currentbalancefield.setText(amount1);

            try {
                Conn c = new Conn();
                String q = "update Balance set balance = ? where Username = ?";
                PreparedStatement p = c.con.prepareStatement(q);
                p.setString(1, amount1);
                p.setString(2, userName);
                p.executeUpdate();

                depositFrame.setVisible(false);
                new MainFrame(userName).setVisible(true);
                JOptionPane.showMessageDialog(this, "Amount successfully deposited!", "Success", JOptionPane.INFORMATION_MESSAGE);
                c.con.close();
                p.close();
                
            } catch (Exception ex) {
                System.out.println(ex);
            }

        } else if (e.getSource() == my_info) {
            infoFrame = new JFrame("Account Info");
            ImageIcon icon = new ImageIcon("C:\\Users\\COSMOS\\Documents\\NetBeansProjects\\Bank\\src\\icons\\logo.jpg");
            infoFrame.setIconImage(icon.getImage());

            infoFrame.setLayout(null);
            infoFrame.setSize(400, 400);
            infoFrame.setResizable(false);

            firstnameLabel = new JLabel("Firstname");
            firstnameLabel.setBounds(10, 25, 90, 35);
            firstnameLabel.setForeground(Color.white);
            lastnameLabel = new JLabel("Lastname");
            lastnameLabel.setBounds(10, 85, 90, 35);
            lastnameLabel.setForeground(Color.white);
            emailLabel = new JLabel("Email");
            emailLabel.setBounds(10, 135, 100, 35);
            emailLabel.setForeground(Color.white);
            usernameLabel = new JLabel("Username");
            usernameLabel.setBounds(10, 190, 90, 35);
            usernameLabel.setForeground(Color.white);

            firstnameField = new JTextField("");
            firstnameField.setBounds(110, 25, 150, 35);
            lastnameField = new JTextField("");
            lastnameField.setBounds(110, 85, 150, 35);
            emailField = new JTextField("");
            emailField.setBounds(110, 135, 150, 35);
            usernameField = new JTextField("");
            usernameField.setBounds(110, 190, 150, 35);

            infoFrame.setLocationRelativeTo(null);
            infoFrame.setVisible(true);

            infoFrame.getContentPane().setBackground(Color.black);
            infoFrame.getContentPane().add(firstnameLabel);
            infoFrame.getContentPane().add(lastnameLabel);
            infoFrame.getContentPane().add(usernameLabel);
            infoFrame.getContentPane().add(emailLabel);
            infoFrame.getContentPane().add(firstnameField);
            infoFrame.getContentPane().add(lastnameField);
            infoFrame.getContentPane().add(usernameField);
            infoFrame.getContentPane().add(emailField);

            Conn c = new Conn();
            String q = "select * from signup where username='" + userName + "'";
            try {
                ResultSet r = c.s.executeQuery(q);
                if (r.next()) {
                    String name = r.getString("First Name");
                    String lname = r.getString("Last Name");
                    String email = r.getString("Email");
                    String user = r.getString("Username");
                    firstnameField.setText(name);
                    lastnameField.setText(lname);
                    usernameField.setText(email);
                    emailField.setText(user);

                    firstnameField.setEditable(false);
                    lastnameField.setEditable(false);
                    usernameField.setEditable(false);
                    emailField.setEditable(false);

                }
                    c.con.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);

            }

        }
    }

    void viewBalance() {
        String bal;
        Conn c = new Conn();
        try {
            String q = "select * from balance where Username='" + userName + "'";

            ResultSet r = c.s.executeQuery(q);
            if (r.next()) {
                bal = r.getString("Balance");
                currentbalancefield.setText(bal);

            }
            r.close();
            c.con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
