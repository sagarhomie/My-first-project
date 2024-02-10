package bankmanagement;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class signUpOne extends JFrame implements ActionListener {
    long Random;
    JTextField namTextField,pinTextField,addressTextField,fnamTextField,emailTextField,
    cityTextField,stateTextField;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser dateChooser;
    signUpOne(){
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");
        Random ran = new Random();
        Random = Math.abs(ran.nextLong()%9000L+1000L);
        JLabel formNo = new JLabel("APPLICATION FORM NO"+ Random);
        formNo.setBounds(200,10,450,30);
        formNo.setFont(new Font("Raleway",Font.BOLD,30));
        add(formNo);
        JLabel personalDetail = new JLabel("Page 1: Personal Details");
        personalDetail.setBounds(280,40,300,30);
        personalDetail.setFont(new Font("Raleway",Font.BOLD,20));
        add(personalDetail);
        JLabel name = new JLabel("Name: ");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);
        namTextField = new JTextField();
        namTextField.setBounds(300,140,400,30);
        namTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(namTextField);
        JLabel fname = new JLabel("Father's Name: ");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(fname);
        fnamTextField = new JTextField();
        fnamTextField.setBounds(300,190,400,30);
        fnamTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(fnamTextField);
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);
         dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setBackground(Color.BLACK);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);
         male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(400,290,120,30);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        JLabel email = new JLabel("Email Address:");
        email.setBounds(100,340,200,30);
        email.setFont(new Font("Raleway",Font.BOLD,20));
        add(email);
        emailTextField = new JTextField();
        emailTextField.setBounds(300,340,400,30);
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(emailTextField);
        JLabel maritial = new JLabel("Maritial Status:");
        maritial.setBounds(100,390,200,30);
        maritial.setFont(new Font("Raleway",Font.BOLD,20));
        add(maritial);
         married= new JRadioButton("Married");
        married.setBounds(300,390,120,30);
        married.setBackground(Color.WHITE);
        add(married);
         unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,120,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
         other = new JRadioButton("Other");
        other.setBounds(570,390,120,30);
        other.setBackground(Color.WHITE);
        add(other);
        ButtonGroup maritialGroup = new ButtonGroup();
        maritialGroup.add(married);
        maritialGroup.add(unmarried);
        maritialGroup.add(other);
        JLabel address = new JLabel("Address:");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);
         addressTextField = new JTextField();
        addressTextField.setBounds(300,440,400,30);
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(addressTextField);
        JLabel city = new JLabel("City:");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);
        cityTextField = new JTextField();
        cityTextField.setBounds(300,490,400,30);
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(cityTextField);
        JLabel state = new JLabel("State:");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);
         stateTextField = new JTextField();
        stateTextField.setBounds(300,540,400,30);
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(stateTextField);
        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setBounds(100,590,200,30);
        pinCode.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinCode);
         pinTextField = new JTextField();
        pinTextField.setBounds(300,590,400,30);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(pinTextField);
        
        
         next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(600,640,100,30);
        add(next);
        next.addActionListener(this);
        setSize(850,800);
        getContentPane().setBackground(Color.WHITE);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno = ""+Random;
        String name = namTextField.getText();
        String fname = fnamTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";

        }else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String maritial = null;
        if(married.isSelected()){
            maritial = "Married";
        }else if (unmarried.isSelected()){
            maritial = "Unmarried";
        }else if (other.isSelected()){
            maritial = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father name is mandatory");
            }else {
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new sign2(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        


    }
    public static void main(String[] args) {
        new signUpOne();
    }
}