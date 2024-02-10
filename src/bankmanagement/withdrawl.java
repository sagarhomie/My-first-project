package bankmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.time.*;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton back,withdraw;
    String pinnumber;
    Date date = new Date();
    withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    JLabel text = new JLabel("Enter the amount you want to withdraw");
    text.setBounds(170,250,400,20);
    text.setFont(new Font("System",Font.BOLD,16));
    text.setForeground(Color.WHITE);
    image.add(text);
     amount = new JTextField();
    amount.setBounds(170,280,250,30);
    amount.setFont(new Font("Raleway",Font.BOLD,16));
    image.add(amount);
     withdraw = new JButton("withdraw");
     withdraw.setBounds(350,420,120,25);
     withdraw.setFont(new Font("Raleway",Font.BOLD,16));
     withdraw.addActionListener(this);
    image.add(withdraw);
     back = new JButton("Back");
     back.setBounds(350,450,120,25);
     back.setFont(new Font("Raleway",Font.BOLD,16));
     back.addActionListener(this);
    image.add(back);


    setSize(850,800);
    setLocation(300,0);
    setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");

            }else{
                try{
                Conn conn = new Conn();
                String query ="insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+number+" withdraw Successfully");
                setVisible(false);  
                new Transaction(pinnumber).setVisible(true);;  
            }catch(Exception e){
                    System.out.println(e);
                }
            }


        }else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }

    }
    public static void main(String[] args) {
        new withdrawl("");
        
    }
    
}
