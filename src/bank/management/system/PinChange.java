package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange  extends JFrame implements ActionListener {
    
    JPasswordField pinTextField, repEnterPinTextField;
    JButton back, change;
    String pinnumber;
    
    PinChange(String pinnumber){
        
        setTitle("BABA INTERNATIONAL BANK (BIB)");
        
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        
        // image to fix all the Jframe.
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        JLabel pinText = new JLabel("New Pin:");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 320, 180, 25);
        image.add(pinText);
        
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
        pinTextField.setBounds(330, 320, 175, 28);
        image.add(pinTextField);
        
        JLabel repEnterPin = new JLabel("Re-Enter New PIN:");
        repEnterPin.setForeground(Color.WHITE);
        repEnterPin.setFont(new Font("System", Font.BOLD, 16));
        repEnterPin.setBounds(165, 365, 180, 28);
        image.add(repEnterPin);
        
        repEnterPinTextField = new JPasswordField();
        repEnterPinTextField.setFont(new Font("Raleway", Font.BOLD, 25));
        repEnterPinTextField.setBounds(330, 365, 175, 27);
        image.add(repEnterPinTextField);
        
        change = new JButton("CHANGE");
        change.setBounds(355, 465, 150, 30);
        change.setBackground((new Color(65, 125, 128)));
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355, 500, 150, 30);
        back.setBackground((new Color(65, 125, 128)));
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == change) {
          try {
            String npin =  pinTextField.getText();
            String rpin =  repEnterPinTextField.getText();
            
            // new pin not equal to repeat pin
            if(!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            
            } 
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                return;
            }
            
            //If all condidition are meant then we want to connect to the database
            Conn conn = new Conn();
            String query1 = "update bank set pin =  '"+rpin+"' where pin='"+pinnumber+"'";
            String query2 = "update login set pin =  '"+rpin+"' where pin='"+pinnumber+"'";
            String query3 = "update signupThree set pin =  '"+rpin+"' where pin='"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);   
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
         }
          catch (Exception e) {
                    System.out.println(e);
             }
        }
          else {
              setVisible(false);
          }
    }
    public static void main(String args[]){
        new PinChange("").setVisible(true);
        }
}
