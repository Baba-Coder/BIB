package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*; 


public class SignupOne extends JFrame implements ActionListener {
    
    
    long random;
    JTextField fnameTextField, lnameTextField , emailTextField, addressTextField, cityTextField,  stateTextField ,  pinTextField ;
    JButton next;
    JRadioButton male, female, single, married, other;
    JDateChooser dateChooser;
              
     SignupOne() {
         
         setLayout(null);
    
         Random ran = new Random();
         random = Math.abs((ran.nextLong() % 9000L) + 1000L);
         
         JLabel formno = new JLabel("APPLICATION FORM NO: " + random);
         formno.setFont(new Font("Raleway", Font.BOLD, 38));
         formno.setBounds(140, 20, 600, 40);
         add(formno);
         
         JLabel personDetails = new JLabel("Page 1: Personal Details");
         personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
         personDetails.setBounds(290, 80, 400, 30);
         add(personDetails);
         
          // first name
         JLabel fname = new JLabel("First Name:");
         fname.setFont(new Font("Raleway", Font.BOLD, 20));
         fname.setBounds(100, 140, 120, 30);
         add(fname);
         
         fnameTextField = new JTextField();
         fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         fnameTextField.setBounds(300, 140, 400, 30);
         add(fnameTextField);
         
         // second name
         JLabel lname = new JLabel("Last Name:");
         lname.setFont(new Font("Raleway", Font.BOLD, 20));
         lname.setBounds(100, 190, 200, 30);
         add(lname);
         
         lnameTextField = new JTextField();
         lnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         lnameTextField.setBounds(300, 190, 400, 30);
         add(lnameTextField);
         
         // dob
         JLabel dob = new JLabel("Date of Birth:");
         dob.setFont(new Font("Raleway", Font.BOLD, 20));
         dob.setBounds(100, 240, 200, 30);
         add(dob);
         
         // Calender for dob
         dateChooser = new JDateChooser();
         dateChooser.setBounds(300, 240, 400, 30);
         dateChooser.setForeground(new Color(105, 105, 105));
         add(dateChooser);
         
         JLabel gender = new JLabel("Gender:");
         gender.setFont(new Font("Raleway", Font.BOLD, 20));
         gender.setBounds(100, 290, 200, 30);
         add(gender);
         
        // Gender selection 
         male = new JRadioButton("Male");
         male.setBounds(300, 290, 60, 30);
         male.setBackground(Color.WHITE);
         add(male);
         
         female = new JRadioButton("Female");
         female.setBounds(450, 290, 80, 30);
         female.setBackground(Color.WHITE);
         add(female);
         
         ButtonGroup gendergroup = new ButtonGroup();
         gendergroup.add(male);
         gendergroup.add(female);
         
         // Email
         JLabel email = new JLabel("E-mail:");
         email.setFont(new Font("Raleway", Font.BOLD, 20));
         email.setBounds(100, 340, 200, 30);
         add(email);
         
         emailTextField = new JTextField();
         emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         emailTextField.setBounds(300, 340, 400, 30);
         add(emailTextField);
         
         // Marital
         JLabel marital = new JLabel("Marital Status:");
         marital.setFont(new Font("Raleway", Font.BOLD, 20));
         marital.setBounds(100, 390, 200, 30);
         add(marital);
         
          // Marital  selection 
          // Single
         single = new JRadioButton("Single");
         single.setBounds(300, 390, 100, 30);
         single.setBackground(Color.WHITE);
         add(single);
         
         married = new JRadioButton("Married");
         married.setBounds(450, 390, 100, 30);
         married.setBackground(Color.WHITE);
         add(married);
         
         // Other
         other = new JRadioButton("Other");
         other.setBounds(630, 390, 80, 30);
         other.setBackground(Color.WHITE);
         add(other);
         
         ButtonGroup maritalgroup = new ButtonGroup();
         maritalgroup.add(single);
         maritalgroup.add(married);
         maritalgroup.add(other);
         
         JLabel address = new JLabel("Address:");
         address.setFont(new Font("Raleway", Font.BOLD, 20));
         address.setBounds(100, 440, 200, 30);
         add(address);
         
         addressTextField = new JTextField();
         addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         addressTextField.setBounds(300, 440, 400, 30);
         add(addressTextField);
         
         // City
         JLabel city = new JLabel("City:");
         city.setFont(new Font("Raleway", Font.BOLD, 20));
         city.setBounds(100, 490, 200, 30);
         add(city);
         
         cityTextField = new JTextField();
         cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         cityTextField.setBounds(300, 490, 400, 30);
         add(cityTextField);
         
         // State
         JLabel state = new JLabel("State:");
         state.setFont(new Font("Raleway", Font.BOLD, 20));
         state.setBounds(100, 540, 200, 30);
         add(state);
         
         stateTextField = new JTextField();
         stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         stateTextField.setBounds(300, 540, 400, 30);
         add(stateTextField);
         
         // Pin
         JLabel pincode = new JLabel("Pin Code:");
         pincode.setFont(new Font("Raleway", Font.BOLD, 20));
         pincode.setBounds(100, 590, 200, 30);
         add(pincode);
         
         pinTextField = new JTextField();
         pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         pinTextField.setBounds(300, 590, 400, 30);
         add(pinTextField);
         
         next = new JButton ("Next");
         next.setBackground(Color.BLACK);
         next.setForeground(Color.WHITE);
         next.setFont(new Font("Raleway" , Font.BOLD, 14));
         next.setBounds(620, 660, 80, 30);
         next.addActionListener(this);
         add(next);
                 
         getContentPane().setBackground(Color.yellow); 
         setSize(850, 800);
         setLocation(350, 10);
         setVisible(true);
}
     
     public void actionPerformed(ActionEvent ae) {
         
         String formno = "" + random;  // long
         String fname = fnameTextField.getText(); // setText
         String lname = lnameTextField.getText();
         String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
         String gender = null;
         if ( male.isSelected()) {
             gender= "Male";
         } else if (female.isSelected()) {
             gender = "Female";
         }
         
         String email =  emailTextField.getText();
         String marital = null;
         if (single.isSelected())
            {
             marital = "Single";
            }
         else if (married.isSelected())
            {
             marital = "Married";
            } 
             else if (other.isSelected()) {
             marital = "Other";
         }
         
         String address = addressTextField.getText();
         String city = cityTextField.getText();
         String state = stateTextField.getText();
         String pin = pinTextField.getText(); 
         
         try {
              if(fname.equals(""))
              {    
                  JOptionPane.showMessageDialog(null, "Name is required");
             } else 
              {
                  Conn c = new Conn();
                  String query = "insert into signup values('"+formno+"','"+fname+"','"+lname+"' ,'"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"', '"+city+"','"+state+"','"+pin+"')"; 
                  c.s.executeUpdate(query);
                  
                 setVisible(false);
                  new SignupTwo(formno).setVisible(true);
              }
         } catch (Exception e) {
         System.out.println(e);
         }
     }
    

     public static void main(String args[]) {
         new SignupOne();
     }
}
