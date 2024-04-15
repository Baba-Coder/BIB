package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JLabel labelWel, labelCardNo, labelPin;
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() { 
        
        setTitle("BABA INTERNATIONAL BANK (BIB");
        
         setLayout(null);
        
          // Bank logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(70, 10, 100, 100);
        add(image);
       
        
        labelWel = new JLabel("Welcome to BIB");
        labelWel.setForeground(Color.green);
        labelWel.setFont(new Font("AvantGarde", Font.BOLD, 45));
        labelWel.setBounds(220, 40, 400, 40);
        add(labelWel);

        //  Card Number
        labelCardNo = new JLabel("Card No:");
        labelCardNo.setForeground(Color.black);
        labelCardNo.setFont(new Font("AvantGarde", Font.BOLD, 28));
        labelCardNo.setBounds(150, 152, 375, 30);
        add(labelCardNo);

        // Card TextField
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 155, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        cardTextField.setForeground(new Color(152, 153, 153));
        add(cardTextField);

        // Pin
        labelPin = new JLabel("PIN:");
        labelPin.setForeground(Color.black);
        labelPin.setFont(new Font("AvantGarde", Font.BOLD, 28));
        labelPin.setBounds(150, 220, 375, 30);
        add(labelPin);

        // Password TextField
        pinTextField = new JPasswordField(15);
        pinTextField.setBounds(300, 226, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setForeground(new Color(152, 153, 153));
        add(pinTextField);

        // Login Button
        login = new JButton("SIGN IN");
        login.setBounds(300, 285, 100, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        // Clear Button
        clear = new JButton("CLEAR");
        clear.setBounds(430, 285, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        // Sign up Button
        signup = new JButton("SIGN UP");
        signup.setBounds(360, 345, 100, 30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        // Holding card
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/holding-card.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 350, 100, 100);
        image.setForeground(Color.white);
        add(iimage);
       
           // JFrame layout 
         getContentPane().setBackground(Color.white);
         setSize(800, 480);
         setVisible(true);
         setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent ae) {
          if (ae.getSource() == clear)
          {
             cardTextField.setText("");
             pinTextField.setText("");
          } 
          else if (ae.getSource() == login)
          {
            Conn conn = new Conn();
           String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
    
            try {
               ResultSet rs = conn.s.executeQuery(query);
                 
                 if (rs.next()) {
                     
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                } else {
                       JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");                  }
             } catch (Exception e) {       
                 
                System.out.println(e);
             }
        
          }
          else if(ae.getSource() == signup)
          {
              setVisible(false);
              new SignupOne().setVisible(true);
              
          }
}

     public static void main(String args[]){
          new Login();
     }
}
