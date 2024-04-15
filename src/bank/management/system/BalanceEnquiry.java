package bank.management.system;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.*;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JLabel labelBal;
    JButton back;
    String pinnumber;
    
     BalanceEnquiry(String pinnumber) {
        setTitle("BABA INTERNATIONAL BANK (BIB)");
        
        this.pinnumber = pinnumber; 
        setLayout(null);
      
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0, 0, 900, 900);
         add(image);
         
        
         back = new JButton("BACK");
         back.setBounds(355, 520, 150, 30);
         back.setBackground((new Color(65, 125, 128)));
         back.addActionListener(this);
         image.add(back);
         
         Conn c = new Conn();
           int balance = 0;
           try {
               ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
               while(rs.next()) {
                  if (rs.getString("type").equals("Deposit")){
                      balance += Integer.parseInt(rs.getString("amount"));
                  } else {
                      balance -= Integer.parseInt(rs.getString("amount"));
                  }
               }
           }
           catch (Exception e){
               System.out.println(e);            
           }
           
    
          JLabel text = new JLabel("Your Available Account balance is $"  + balance);
          text.setForeground(Color.WHITE);
          text.setBounds(170, 350, 400, 30);
          image.add(text);
                        
         setSize(900, 900);
         setLocation(0, 300);
         setVisible(true);
}
       public void actionPerformed(ActionEvent ae) {
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }

public static void main(String args[]){
         new BalanceEnquiry("") ;
}
}