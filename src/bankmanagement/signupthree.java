package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class signupthree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    signupthree( String formno){
        this.formno= formno;
        setTitle("SIGNUP PAGE 3");
        setLayout(null);
        JLabel text = new JLabel("Page 3: Account Details");
        text.setBounds(300,30,300,30);
        text.setFont(new Font("Raleway",Font.BOLD,20));
        add(text);
        JLabel accountText = new JLabel("Account Type");
        accountText.setBounds(100,90,200,30);
        accountText.setFont(new Font("Raleway",Font.BOLD,20));
        add(accountText);
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100,120,150,20);
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        add(r1);
        r2 = new JRadioButton("Current Account");
        r2.setBounds(250,120,150,20);
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        add(r2);
        r3 = new JRadioButton("Fixed Deposit");
        r3.setBounds(100,150,150,20);
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        add(r3);
        r4 = new JRadioButton("Recurring Account");
        r4.setBounds(250,150,180,20);
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        add(r4);
        ButtonGroup accountType = new ButtonGroup();
        accountType.add(r1);
        accountType.add(r2);
        accountType.add(r3);
        accountType.add(r4);
        JLabel cardText = new JLabel("Card Number");
        cardText.setBounds(100,190,300,30);
        cardText.setFont(new Font("Raleway",Font.BOLD,20));
        add(cardText);
        JLabel cardNo = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNo.setBounds(350,190,300,30);
        cardNo.setFont(new Font("Raleway",Font.BOLD,20));
        add(cardNo);
        JLabel cardInfo = new JLabel("This is your 16 digit card number");
        cardInfo.setBounds(100,220,400,15);
        cardInfo.setFont(new Font("Raleway",Font.BOLD,12));
        add(cardInfo);
        JLabel pinText = new JLabel("PIN:");
        pinText.setBounds(100,240,300,30);
        pinText.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinText);
        JLabel pinNo = new JLabel("XXXX");
        pinNo.setBounds(350,240,300,30);
        pinNo.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinNo);
        JLabel pinInfo = new JLabel("This is your 4 digit pin number");
        pinInfo.setBounds(100,270,400,15);
        pinInfo.setFont(new Font("Raleway",Font.BOLD,12));
        add(pinInfo);
        JLabel services = new JLabel("Services Required:");
        services.setBounds(100,350,400,30);
        services.setFont(new Font("Raleway",Font.BOLD,20));
        add(services);
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,400,200,30);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(450,400,200,30);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,430,200,30);
        add(c3);
        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(450,430,200,30);
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,460,200,30);
        add(c5);
        c6 = new JCheckBox("E-Statements");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(450,460,200,30);
        add(c6);
        c7 = new JCheckBox("The above enter details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,510,400,30);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        add(c7);
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,580,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        add(submit);
        submit.addActionListener(this);
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(500,580,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        add(cancel);
        cancel.addActionListener(this);

        
        



          
        setSize(850,800);
        setVisible(true);
        setLocation(350,20);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType = null;
            if (r1.isSelected()){
                accountType = "Saving Account";
            }else if(r2.isSelected()){
                accountType = "Current Account";
            }else if(r3.isSelected()){
                accountType = "Fixed Deposit";
            }else if(r4.isSelected()){
                accountType = "Recurring Account";
            }
            Random random = new Random();
            String cardNumber = ""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pinNumber = ""+Math.abs((random.nextLong()%9000L)+1000L);
            String facility = "";
            if(c1.isSelected()){
                facility = facility+" ATM CARD";
            }else if(c2.isSelected()){
                facility = facility+" Internet Banking";
            }else if(c3.isSelected()){
                facility = facility+" Mobile Banking";
            }else if(c4.isSelected()){
                facility = facility+" EMAIL & SMS Alerts";
            }else if(c5.isSelected()){
                facility = facility+" Cheque Book";
            }else if(c6.isSelected()){
                facility = facility+" E-Statement";
            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is required");
                }
                Conn c;
                c = new Conn();
                String query1 = "insert signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                String query2 = "insert login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card Number: "+ cardNumber + "\n Pin:"+ pinNumber );
            }catch(Exception e){
                System.out.println(e);
            }


        }

    }
    public static void main(String[] args) {
        new signupthree("");
        
    }
}
