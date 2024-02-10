package bankmanagement;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Onward",Font.BOLD,30));
        text.setBounds(200,40,400,40);
        add(text);
        JLabel cardNo = new JLabel("Card No:");
        cardNo.setFont(new Font("Railway",Font.BOLD,30));
        cardNo.setBounds(120,150,150,40);
        add(cardNo);
         cardTextField= new JTextField();
        cardTextField.setBounds(300,150,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,30));
        add(cardTextField);
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Railway",Font.BOLD,30));
        pin.setBounds(200,220,250,40);
        add(pin);
        pinTextField= new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,30));
        add(pinTextField);
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        clear = new JButton("CLEAR");
        clear.setBounds(450,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== clear) {
            cardTextField.setText("");
            pinTextField.setText("");
            
        }else if(ae.getSource()== login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect cardno or pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            setVisible(false);

        }else if(ae.getSource()== signup){
            setVisible(false);
            new signUpOne().setVisible(true);

        }

    }
    public static void main(String[] args) {
        new Login();
        
    }
    
}
