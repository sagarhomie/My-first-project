package bankmanagement;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastcash,balanceinquire,ministatement,pinchange,exit;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text = new JLabel("Please select you Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        deposit = new JButton("Deposit");
        deposit.setBounds(160,415,125,25);
        deposit.addActionListener(this);
        image.add(deposit);
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(390,415,125,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        fastcash = new JButton("Fastcash");
        fastcash.setBounds(160,455,125,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        balanceinquire = new JButton("Balance Inquire");
        balanceinquire.setBounds(390,455,125,25);
        balanceinquire.addActionListener(this);
        image.add(balanceinquire);
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(160,495,125,25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(390,495,125,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        exit = new JButton("Exit");
        exit.setBounds(390,525,125,25);
        image.add(exit);
        exit.addActionListener(this);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new deposit(pinnumber).setVisible(true);

        }else if (ae.getSource()==withdrawl){
            setVisible(false);
            new withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new fastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new pinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceinquire){
            setVisible(false);
            new balanceInquire(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            setVisible(false);
            new Ministatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
        
    }
    
}
