package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 


public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField licenseTextField,  ssnTextField, beneficialTextField, kinTextField;
    JButton next;
    JRadioButton yes ,no;
    JComboBox  selectCountry, yourIncome, education, occupation;
    String formno;
              
     SignupTwo(String formno) {
         this.formno = formno;
         setLayout(null);
         
         setTitle("Bank APPLICATION FORM - PAGE 2 ");
         
        // Bank logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(70, 10, 100, 100);
        add(image);
        
         JLabel additionalDetails = new JLabel("Page 2: Additional Details");
         additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
         additionalDetails.setBounds(290, 80, 400, 30);
         add(additionalDetails);
    
    
          // Country of birth
         JLabel yourCountry = new JLabel("Country:");
         yourCountry.setFont(new Font("Raleway", Font.BOLD, 20));
         yourCountry.setBounds(100, 140, 120, 30);
         add(yourCountry);
         
         String allCountry[] = {"A","Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda","Argentina","Armenia", "Australia","Austria",
                               "Austrian Empire","Azerbaijan","B","Baden","Bahamas" ,"Bahrain","Bangladesh","Barbados","Bavaria","Belarus","Belgium","Belize",
                               "Benin(Dahomey)","Bolivia","Bosnia and Herzegovina","Botswana","Brazil","Brunei","Brunswick and Lüneburg","Bulgaria",
                               "Burkina Faso(Upper Volta)","Burma","Burundi","C","Cabo Verde","Cambodia","Cameroon","Canada","Cayman Islands" ,"Central African Republic",
                               "Central American Federation","Chad","Chile","China","Colombia","Comoros","Congo Free State","Costa Rica","Cote d’Ivoire (Ivory Coast)",
                               "Croatia","Cuba","Cyprus","Czechia","Czechoslovakia","D","Democratic Republic of the Congo","Denmark","Djibouti",
                               "Dominica","Dominican Republic","Duchy of Parma","E","East Germany (German Democratic Republic)","Ecuador","Egypt","El Salvador",
                                "Equatorial Guinea","Eritrea","Estonia","Eswatini","Ethiopia","Federal Government of Germany","F","Fiji","Finland","France","G","Gabon","Gambia",
                                "Georgia","Germany","Ghana","Grand Duchy of Tuscany","Greece","Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","H","Haiti","Hanover",
                                "Hanseatic Republics","Hawaii","Hesse","Holy See","Honduras","Hungary","Iceland","I","India","Indonesia","Iran","Iraq","Ireland",
                                "Israel","Italy","Jamaica","J","Japan","Jordan","K","Kazakhstan","Kenya","Kingdom of Serbia/Yugoslavia","Kiribati","Korea","Kosovo",
                                "Kuwait","Kyrgyzstan","L","Laos","Latvia","Lebanon","Lesotho","Lew Chew","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","M",
                                "Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mecklenburg-Schwerin",
                                "Mecklenburg-Strelitz","Mexico","Micronesia","Moldova","Monaco", "Mongolia","Montenegro","Morocco","Mozambique","N","Namibia",
                                "Nassau","Nauru","Nepal","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","North German Confederation","North German Union",
                                "North Macedonia","Norway","O","Oldenburg","Oman","Orange Free State","P","Pakistan","Palau","Panama","Papal States","Papua New Guinea",
                                "Paraguay","Peru","Philippines","Piedmont-Sardinia","Poland","Portugal","Q","Qatar","R","Republic of Genoa","Republic of Korea (South Korea)",
                                "Republic of the Congo","Romania","Russia","Rwanda","S","Saint Kitts and Nevis","Saint Lucia","Saint Vincent and the Grenadines",
                                "Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Schaumburg-Lippe","Senegal","Serbia","Seychelles","Sierra Leone",
                                "Singapore","Slovakia","Slovenia","Solomon Islands, The Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname",
                                "Sweden","Switzerland","Syria","T","Tajikistan","Tanzania","Thailand","Timor-Leste","Togo","Tonga","Trinidad and Tobago","Tunisia",
                                "Turkey","Turkmenistan","Tuvalu","Two Sicilies*","U","Uganda","Ukraine","Union of Soviet Socialist Republics*","United Arab Emirates", 
                                "United Kingdom", "United States of America","Uruguay","Uzbekistan","V","Vanuatu","Venezuela","Vietnam","W","Württemberg*","Y","Yemen","Zambia","Zimbabwe"
                                  };

          selectCountry = new JComboBox(allCountry);
          selectCountry.setFont(new Font("Raleway", Font.BOLD, 14        ));
          selectCountry.setBounds(300, 140, 400, 30);
          add(selectCountry);

          // License
          JLabel dvl = new JLabel("Driver License:");
          dvl.setFont(new Font("Raleway", Font.BOLD, 20));
          dvl.setBounds(100, 190, 200, 30);
          add(dvl);

          licenseTextField = new JTextField();
          licenseTextField .setFont(new Font("Raleway", Font.BOLD, 14));
          licenseTextField .setBounds(300, 190, 400, 30);
          add(licenseTextField);

          // second name
 //         JLabel lname = new JLabel("Category:");
 //         lname.setFont(new Font("Raleway", Font.BOLD, 20));
 //         lname.setBounds(100, 190, 200, 30);
 //         add(lname);
 //         
 //         lnameTextField = new JTextField();
 //         lnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
 //         lnameTextField.setBounds(300, 190, 400, 30);
 //         add(lnameTextField);

          // Income
          JLabel income = new JLabel("Income:");
          income.setFont(new Font("Raleway", Font.BOLD, 20));
          income.setBounds(100, 240, 200, 30);
          add(income);

          String incomeCat[] = {"Null", " < $10,000", "$10,000 - $50,000", "$50,000-$100,000", " > 100,000"};
          yourIncome = new JComboBox(incomeCat);
          yourIncome.setBounds(300, 240,400, 30);
          yourIncome.setForeground(new  Color(105, 105, 105));
          add(yourIncome);

          //Education
          JLabel edu = new JLabel("Education");
         edu.setFont(new Font("Raleway", Font.BOLD, 20));
         edu.setBounds(100, 290, 200, 30);
         add(edu);
             
         // Email
         JLabel qua = new JLabel("Qualification:");
         qua.setFont(new Font("Raleway", Font.BOLD, 20));
         qua.setBounds(100, 315, 200, 30);
         add(qua);
         
         String educationValues[] = {"High School Diploma", "Associate Degree", "Bachelor Degree", "Master","Graduate School"};
         education = new JComboBox(educationValues);
         education.setBounds(300, 315, 400, 30);
         education.setBackground(Color.WHITE);
         add(education);        
         
         // Marital
         JLabel occ = new JLabel("Occupation:");
         occ.setFont(new Font("Raleway", Font.BOLD, 20));
         occ.setBounds(100, 390, 200, 30);
         add(occ);
         
         String occupationValues[] = {"Student", "Employed", "UnEmployed", "Other" };
         occupation = new JComboBox(occupationValues);
         occupation.setBounds(300, 390, 400, 30);
         occupation.setBackground(Color.white);
         add(occupation); 
         
         
         JLabel ssn = new JLabel("SSN:");
         ssn.setFont(new Font("Raleway", Font.BOLD, 20));
         ssn.setBounds(100, 440, 200, 30);
         add(ssn);
         
         ssnTextField = new JTextField();
          ssnTextField.setFont(new Font("Raleway", Font.BOLD, 14));
          ssnTextField.setBounds(300, 440, 400, 30);
         add(ssnTextField);
         
         // City
         JLabel retired = new JLabel("Are you retired?");
         retired.setFont(new Font("Raleway", Font.BOLD, 20));
         retired.setBounds(100, 490, 200, 30);
         add(retired);
         
         yes = new JRadioButton("Yes");
         yes.setBounds(300, 490, 50, 30);
         yes.setBackground(Color.WHITE);
         add(yes);
         
         no = new JRadioButton("No");
         no.setBounds(450, 490, 50, 30);
         no.setBackground(Color.WHITE);
         add(no);
                  
         ButtonGroup retiredgroup = new ButtonGroup();
         retiredgroup.add(yes);
         retiredgroup.add(no);
            
         // State
         JLabel benef = new JLabel("Name of Beneficiary:");
         benef.setFont(new Font("Raleway", Font.BOLD, 20));
         benef.setBounds(100, 540, 200, 30);
         add(benef);
         
         beneficialTextField = new JTextField();
         beneficialTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         beneficialTextField.setBounds(300, 540, 400, 30);
         add(beneficialTextField);
         
         // Pin
         JLabel pincode = new JLabel("Next of Kin:");
         pincode.setFont(new Font("Raleway", Font.BOLD, 20));
         pincode.setBounds(100, 590, 200, 30);
         add(pincode);
         
         kinTextField = new JTextField();
         kinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
         kinTextField.setBounds(300, 590, 400, 30);
         add(kinTextField);
         
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
       
         String scountry = (String) selectCountry.getSelectedItem(); // setText
         String slicense = licenseTextField.getText();
         String sincome = (String) yourIncome.getSelectedItem();
         String seducation = (String) education.getSelectedItem(); 
         String soccupation = (String) occupation.getSelectedItem();
         String sssn = (String) ssnTextField.getText();
         String retired = null;
         if(yes.isSelected()) {
             retired = "Yes";
         } else if (no.isSelected()) {
             retired = "No";
         }
         
         String sbeneficial =  beneficialTextField.getText();
         String skin =  kinTextField.getText();
     
         try {      
              {
                  Conn c = new Conn();
                  String query = "insert into signupTwo values('"+formno+"','"+scountry+"','"+slicense+"' ,'"+sincome+"','"+seducation+"','"+soccupation+"','"+sssn+"','"+retired+"', '"+sbeneficial+"','"+skin+"')"; 
                  c.s.executeUpdate(query);
                  
                  //Signup Object
                  setVisible(false);
                  new SignupThree(formno).setVisible(true);
              }
         } catch (Exception e) {
         System.out.println(e);
         }
     }
     
     public static void main(String args[]) {
         new SignupTwo("");
     }
}

