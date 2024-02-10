package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;


public class fastCash extends JFrame implements ActionListener {
    JButton hundred,fivehundred,thousand,fivethousand,back,twothousand,tenthousand;
    String pinnumber;
    fastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel text = new JLabel(i3);
        text.setBounds(0,0,900,900);
        add(text);
         hundred = new JButton("Rs 100");
        hundred.setBounds(170,420,125,25);
        hundred.setFont(new Font("Raleway",Font.BOLD,14));
        text.add(hundred);
        hundred.addActionListener(this);
         fivehundred = new JButton("Rs 500");
        fivehundred.setBounds(390,420,125,25);
        fivehundred.setFont(new Font("Raleway",Font.BOLD,14));
        text.add(fivehundred);
        fivehundred.addActionListener(this);
         thousand = new JButton("Rs 1000");
        thousand.setBounds(170,460,125,25);
        thousand.setFont(new Font("Raleway",Font.BOLD,14));
        text.add(thousand);
        thousand.addActionListener(this);
         twothousand = new JButton("Rs 2000");
        twothousand.setBounds(390,460,125,25);
        twothousand.setFont(new Font("Raleway",Font.BOLD,14));
        text.add(twothousand);
        twothousand.addActionListener(this);
         fivethousand = new JButton("Rs 5000");
        fivethousand.setBounds(170,500,125,25);
        fivethousand.setFont(new Font("Raleway",Font.BOLD,14));
        text.add(fivethousand);
        fivethousand.addActionListener(this);
         tenthousand = new JButton("Rs 10000");
        tenthousand.setBounds(390,500,125,25);
        tenthousand.setFont(new Font("Raleway",Font.BOLD,14));
        text.add(tenthousand);
        tenthousand.addActionListener(this);
         back = new JButton("Back");
        back.setBounds(390, 530,125,20);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        text.add(back);
        back.addActionListener(this);
        
        setSize(850,800);
        setVisible(true);
        setLocation(300,0);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);

        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource()!= back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "insufficient balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+amount+"Debited Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        
        }
        
    }
    public static void main(String[] args) {
        new fastCash("");
    }
}
