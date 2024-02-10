
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class practice extends JFrame implements ActionListener {
    practice(){
        setSize(800,600);
        setLayout(null);
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,200,240);
        add(label);
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setBounds(250,100,400,40);
        text.setFont(new Font("Onwards",Font.BOLD,40 ));
        add(text);
        JLabel cardNo = new JLabel("CARDNO:");
        cardNo.setBounds(200,200,200,40);
        cardNo.setFont(new Font("Raleway",Font.BOLD,20));
        add(cardNo);
        JTextField cardTextField = new JTextField();
        cardTextField.setBounds(310,200,350,40);
        add(cardTextField);
        JLabel pinNo = new JLabel("PIN:");
        pinNo.setBounds(250,250,200,40);
        pinNo.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinNo);
        JTextField pinTextField = new JTextField();
        pinTextField.setBounds(310,250,350,40);
        add(pinTextField);
        JButton login = new JButton("SIGN IN");
        login.setBounds(310,360,120,40);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        add(login);
        JButton clear = new JButton("CLEAR");
        clear.setBounds(540,360,120,40);
        clear.setForeground(Color.WHITE);
        clear.setBackground(Color.BLACK);
        add(clear);
        JButton signUp = new JButton("SIGN UP");
        signUp.setBounds(310,420,350,40);
        signUp.setForeground(Color.WHITE);
        signUp.setBackground(Color.BLACK);
        add(signUp);
        //adds(i1);
        getContentPane().setBackground(Color.WHITE);
        //ImageIcon i1 = 
        setVisible(true);
        setLocation(100,200);
    }
    public static void main(String[] args) {
        new practice();
    }
    
}
