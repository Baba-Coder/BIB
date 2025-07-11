package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b100,b500,b1000,b2000,b5000,b10000,bback;
    // JButton deposit, witghdraw, fastCash,miniStatement,changePin,balanceEnquiry,back
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null); // very iomportant to set it as null 
        setTitle("BABA INTERNATIONAL BANK");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        // This will change the size of our background.
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,900,900);
        add(l3);

 
        JLabel fastSelect= new JLabel("SELECT YOUR WITHDRAW AMOUNT IN $");
             // XY.setBounds{left, dowm, right ,
        fastSelect.setBounds(180,300,700,30);
        fastSelect.setForeground(Color.WHITE);
        fastSelect.setFont(new Font("System",Font.BOLD,16));
        l3.add(fastSelect);

        b100 = new JButton("$ 100");
        b100.setForeground(Color.WHITE);
        b100.setBackground(new Color(65,125,128));
        b100.setBounds(170,415,150,30);
        b100.addActionListener(this);
        l3.add(b100);

        b500= new JButton("$ 500");
        b500.setForeground(Color.WHITE);
        b500.setBackground(new Color(65,125,128));
        b500.setBounds(355,415,150,30);
        b500.addActionListener(this);
        l3.add(b500);

        b1000 = new JButton("$ 1000");
        b1000.setForeground(Color.WHITE);
        b1000.setBackground(new Color(65,125,128));
        b1000.setBounds(170,450,150,30);
        b1000.addActionListener(this);
        l3.add(b1000);

        b2000 = new JButton("$ 2000");
        b2000.setForeground(Color.WHITE);
        b2000.setBackground(new Color(65,125,128));
        b2000.setBounds(355,450,150,30);
        b2000.addActionListener(this);
        l3.add(b2000);

        b5000 = new JButton("$ 5000");
        b5000.setForeground(Color.WHITE);
        b5000.setBackground(new Color(65,125,128));
        b5000.setBounds(170,485,150,30);
        b5000.addActionListener(this);
        l3.add(b5000);

        b10000 = new JButton("$ 10000");
        b10000.setForeground(Color.WHITE);
        b10000.setBackground(new Color(65,125,128));
        b10000.setBounds(355,485,150,30);
        b10000.addActionListener(this);
        l3.add(b10000);

        bback = new JButton("BACK");
        bback.setForeground(Color.WHITE);
        bback.setBackground(new Color(65,125,128));
        bback.setBounds(355,520,150,30);
        bback.addActionListener(this);
        l3.add(bback);
         
        // seetinmg the JFramE LAYOUT
        
      // setting for the JFrame layout
           setSize(900, 900);
           setLocation(0,0);
           setVisible(true);
           setLayout(null);
      //   setUndecorated(true);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==bback) {
            setVisible(false);
            new  Transactions(pinnumber);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Conn c = new Conn();
            Date date = new Date();
            try{
                ResultSet resultSet = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (e.getSource() != bback && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                
  String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                c.s.executeUpdate("insert into bank values('"+pinnumber+"','"+date+"', 'withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "$ "+amount+" Debited Successfully");
            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new Transactions (pinnumber);
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}