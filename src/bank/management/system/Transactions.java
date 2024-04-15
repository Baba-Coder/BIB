package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
       JButton deposit, withdraw, miniStatement, changePin, fastCash, balanceEnquiry, exit;
       String pinnumber;
       
       Transactions(String pinnumber){
           this.pinnumber = pinnumber;
           setLayout(null);
           setTitle("Welcome to Baba International Bank(BIB) ATM");
           
           ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           Image i2 = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
           image.setBounds(0, 0, 900, 900);
           add(image);
           
           JLabel textTrans = new JLabel("Please select your Transaction");
           textTrans.setBounds(210, 300, 700, 35);
           textTrans.setForeground(Color.WHITE);
           textTrans.setFont(new Font("System", Font.BOLD, 16));
           image.add(textTrans);
           
           deposit = new JButton("Deposit");
           deposit.setBounds(170, 415, 150 , 30);
           deposit.setForeground(Color.WHITE);
           deposit.setBackground((new Color(65, 125, 128)));
           deposit.addActionListener(this);
           image.add(deposit);
           
           withdraw = new JButton("Cash Withdraw");
           withdraw.setBounds(355, 415, 150 , 30);
           withdraw.setForeground(Color.WHITE);
           withdraw.setBackground((new Color(65, 125, 128)));
           withdraw.addActionListener(this);
           image.add(withdraw);
           
           fastCash = new JButton("Fast Cash");
           fastCash.setBounds(170, 450, 150 , 30);
           fastCash.setForeground(Color.WHITE);
           fastCash.setBackground((new Color(65, 125, 128)));
           fastCash.addActionListener(this);
           image.add(fastCash);
           
           miniStatement = new JButton("Mini Statement");
           miniStatement.setBounds(355, 450, 150 , 30);
           miniStatement.setForeground(Color.WHITE);
           miniStatement.setBackground((new Color(65, 125, 128)));
           miniStatement.addActionListener(this);
           image.add(miniStatement);
           
           changePin = new JButton("Pin change");
           changePin.setBounds(170, 485, 150 , 30);
           changePin.setForeground(Color.WHITE);
           changePin.setBackground((new Color(65, 125, 128)));
           changePin.addActionListener(this);
           image.add(changePin);
        
           balanceEnquiry = new JButton("Balance Enquiry");
           balanceEnquiry.setBounds(355, 485, 150 , 30);
           balanceEnquiry.setForeground(Color.WHITE);
           balanceEnquiry.setBackground((new Color(65, 125, 128)));
           balanceEnquiry.addActionListener(this);
           image.add(balanceEnquiry);
           
           exit = new JButton("Exit");
           exit.setBounds(355, 520, 150 , 30);
           exit.setForeground(Color.WHITE);
           exit.setBackground((new Color(65, 125, 128)));
           exit.addActionListener(this);
           image.add(exit);
           
           // setting for the JFrame layout
           setSize(900, 900);
           setLocation(300, 0);
           setVisible(true);
         //  setUndecorated(true);
        
    }
      
     public void actionPerformed(ActionEvent ae) {
         if (ae.getSource()== exit){
             System.exit(0);
             
       } else if(ae.getSource() == deposit) {
           setVisible(false);
           new Deposit(pinnumber).setVisible(true);
       } else if(ae.getSource() == withdraw) {
           setVisible(false);
           new Withdraw(pinnumber).setVisible(true);
       } else if(ae.getSource() == fastCash) {
           setVisible(false);
           new FastCash(pinnumber).setVisible(true);
       } else if(ae.getSource() == changePin){
           setVisible(false);
           new PinChange(pinnumber).setVisible(true);
       } else if(ae.getSource() == balanceEnquiry) {
           setVisible(false);
           new BalanceEnquiry(pinnumber).setVisible(true);
       } else if (ae.getSource() == miniStatement) {
     
           new MiniStatement(pinnumber).setVisible(true);
       }
     }
    public static void main(String args[]) {
        
        new Transactions("");
    }
    
}
