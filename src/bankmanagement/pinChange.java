package bankmanagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class pinChange extends JFrame implements ActionListener{
    String pinnumber;
    JButton back, change;
    JTextField pinTextField,repinTextField;
    pinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text = new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);
        JLabel pintext = new JLabel("NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
         pinTextField = new JTextField();
        pinTextField.setBounds(330,320,180,25);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(pinTextField);
        JLabel repintext = new JLabel("Re-Enter new pin");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
         repinTextField = new JTextField();
        repinTextField.setBounds(330,360,180,25);
        repinTextField.setFont(new Font("Raleway",Font.BOLD,18));
        image.add(repinTextField);
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        setSize(900,900);
        
        setLocation(300,0);
        setVisible(true);
        
        

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            try{
                String pin = pinTextField.getText();
                String rpin = repinTextField.getText();
                if(!pin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Enter PIN doesnt match");
                    return;
                }
                if(pin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter PIN Number");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "please Re-Enter new pin ");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "Update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "Update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3 = "Update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);

            }catch(Exception e){
                System.out.println(e);
            }

        }


    }
    public static void main(String[] args) {
        new pinChange("");
    }
}
