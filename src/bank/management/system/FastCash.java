package bank.management.system;

   
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
       JButton deposit, withdraw, miniStatement, changePin, fastCash, balanceEnquiry, back;
       String pinnumber;
       
    FastCash(String pinnumber){
        
           this.pinnumber = pinnumber;   
           setLayout(null);
           
           setTitle("BABA INTERNATIONAL BANK (BIB)");   
           setTitle("Welcome to Baba International Bank(BIB) ATM");
           
           ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
           Image i2 = il.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
           ImageIcon i3 = new ImageIcon(i2);
           JLabel image = new JLabel(i3);
           image.setBounds(0, 0, 900, 900);
           add(image);
           
           JLabel textSelect = new JLabel("SELECT YOUR WITHDRAW AMOUNT");
           textSelect.setBounds(210, 320, 700, 35);
           textSelect.setForeground(Color.WHITE);
           textSelect.setFont(new Font("System", Font.BOLD, 16));
           image.add( textSelect);
           
           deposit = new JButton("$100");
           deposit.setBounds(170, 418, 150 , 30);
           deposit.setForeground(Color.WHITE);
           deposit.setBackground((new Color(65, 125, 128)));
           deposit.addActionListener(this);
           image.add(deposit);
           
           withdraw = new JButton("$500");
           withdraw.setBounds(355, 415, 150 , 30);
           withdraw.setForeground(Color.WHITE);
           withdraw.setBackground((new Color(65, 125, 128)));
           withdraw.addActionListener(this);
           image.add(withdraw);
           
           fastCash = new JButton("$1000");
           fastCash.setBounds(170, 450, 150 , 30);
           fastCash.setForeground(Color.WHITE);
           fastCash.setBackground((new Color(65, 125, 128)));
           fastCash.addActionListener(this);
           image.add(fastCash);
           
           miniStatement = new JButton("$2000");
           miniStatement.setBounds(355, 450, 150 , 30);
           miniStatement.setForeground(Color.WHITE);
           miniStatement.setBackground((new Color(65, 125, 128)));
           miniStatement.addActionListener(this);
           image.add(miniStatement);
           
           changePin = new JButton("$ 5000");
           changePin.setBounds(170, 485, 150 , 30);
           changePin.setForeground(Color.WHITE);
           changePin.setBackground((new Color(65, 125, 128)));
           changePin.addActionListener(this);
           image.add(changePin);
        
           balanceEnquiry = new JButton("$10000");
           balanceEnquiry.setBounds(355, 485, 150 , 30);
           balanceEnquiry.setForeground(Color.WHITE);
           balanceEnquiry.setBackground((new Color(65, 125, 128)));
           balanceEnquiry.addActionListener(this);
           image.add(balanceEnquiry);
           
           back = new JButton("BACK");
           back.setBounds(355, 520, 150 , 30);
           back.setForeground(Color.WHITE);
           back.setBackground((new Color(65, 125, 128)));
           back.addActionListener(this);
           image.add(back);
           
           // setting for the JFrame layout
           setSize(900, 900);
           setLocation(300, 0);
           setVisible(true);
      //   setUndecorated(true);   
    }
    
       @Override
     public void actionPerformed(ActionEvent ae) {    
         if (ae.getSource()== back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);        
       } else{    
             String amount = ((JButton)ae.getSource()).getText().substring(3);
             Conn c = new Conn();
              Date date = new Date();
           try {
                ResultSet resultSet = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(resultSet.next()) {
                   if (resultSet.getString("type").equals("Deposit")){
                       balance += Integer.parseInt(resultSet.getString("amount"));
                   } else {
                       balance -= Integer.parseInt(resultSet.getString("amount"));
                   }
               }
                String num= "17";
               if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
          
               String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "$ "+amount+" fast cash withdraw successfully.");
               
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           } 
           catch (Exception E) {
            System.out.println(E);           
                }      
            }
          }
    public static void main(String args[]) {
        
        new FastCash("");
    }
    
}
  