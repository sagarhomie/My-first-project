package bankmanagement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class balanceInquire extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    balanceInquire(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        Conn c = new Conn();
        int balance = 0;
        try{
            ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");
            

            while(rs.next()){
            if (rs.getString("type").equals("Deposit")){
                balance+=Integer.parseInt(rs.getString("amount"));
            }  else{
                balance-=Integer.parseInt(rs.getString("amount"));
            } 
            }
        }catch(Exception e){
        System.out.println(e);        
        }
        JLabel l1 = new JLabel("Your current account balance is Rs"+balance);
        l1.setFont(new Font("System",Font.BOLD,14));
        l1.setForeground(Color.WHITE);
        l1.setBounds(160,300,300,20);
        image.add(l1);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new balanceInquire("");
    }
}
