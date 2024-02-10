package bankmanagement;
import java.awt.Color;

import javax.swing.*;
import java.sql.*;

public class Ministatement extends JFrame{
    String pinnumber;
    Ministatement(String pinnumber){
        this.pinnumber = pinnumber;
        setTitle("MINI Statement");
        setLayout(null);
        JLabel mini = new JLabel();
        add(mini);
        JLabel bank = new JLabel("NEPAL BANK");
        bank.setBounds(150,20,100,20);
        add(bank);
        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        try{
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXXX"+rs.getString("cardnumber").substring(12));

            }

        } catch(Exception e){
            System.out.println(e);
        }
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
           while(rs.next()){
            mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
           }

        }catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,140,200,200);
        setSize(400,400);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);

    }
    public static void main(String[] args) {
        new Ministatement("");
    }
}
