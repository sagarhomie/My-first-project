package bankmanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class sign2 extends JFrame implements ActionListener{
    JComboBox religionBox,categoryBox,incomeBox,eduQuaBox,occupationBox;
    JTextField panTextField,ninNoTextField;
    JRadioButton yes,no,eyes,eno;
    JButton next;
    String formno;

    sign2(String formno){
        this.formno = formno;
        setTitle("NEW APPLICATION FORM - PAGE 2");
        setLayout(null);
        JLabel text = new JLabel("Page 2: Additional Details");
        text.setFont(new Font("Raleway",Font.BOLD,20));
        text.setBounds(300,80,400,30);
        add(text);
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        String valReligion[]={"Hindu","Muslim","Chistrain","Buddhist","Kirat","Others"};
        religionBox= new JComboBox(valReligion);
        religionBox.setBounds(300,140,400,30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);
        
        
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,200,100,30);
        add(category);
        String valCategory[] = {"General","OBC","SC","ST","Others"};
        categoryBox = new JComboBox(valCategory);
        categoryBox.setBounds(300,200,400,30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,260,100,30);
        add(income);
        String valIncome[] = {"Null","<1,50,00","<2,50,000","<5,00,000","Upto 10,00,000"};
        incomeBox= new JComboBox(valIncome);
        incomeBox.setBounds(300,260,400,30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        JLabel educational = new JLabel("Educational ");
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        educational.setBounds(100,320,200,30);
        add(educational);
        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,340,200,30);
        add(qualification);
        String valEdu[] = {"Non Graduate","Graduate","Post-Graduation","Doctorate","Others"};
        eduQuaBox= new JComboBox(valEdu);
        eduQuaBox.setBounds(300,330,400,30);
        eduQuaBox.setBackground(Color.WHITE);
        add(eduQuaBox);
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,380,200,30);
        add(occupation);
        String valOcc[] = {"Salaried","self employed","Business","Student","Others"};
        occupationBox= new JComboBox(valOcc);
        occupationBox.setBounds(300,380,400,30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        JLabel panNumber = new JLabel("PAN Number:");
        panNumber.setFont(new Font("Raleway",Font.BOLD,20));
        panNumber.setBounds(100,440,200,30);
        add(panNumber);
        panTextField = new JTextField();
        panTextField.setBounds(300,440,400,30);
        panTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(panTextField);
        JLabel ninNo = new JLabel("NIN No:");
        ninNo.setFont(new Font("Raleway",Font.BOLD,20));
        ninNo.setBounds(100,500,100,30);
        add(ninNo);
        ninNoTextField = new JTextField();
        ninNoTextField.setBounds(300,500,400,30);
        ninNoTextField.setFont(new Font("Raleway",Font.BOLD,20));
        add(ninNoTextField);
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
        seniorCitizen.setBounds(100,560,200,30);
        add(seniorCitizen);
        yes = new JRadioButton("Yes");
        yes.setBounds(300,560,200,30);
        yes.setFont(new Font("Raleway",Font.BOLD,20));
        add(yes);
        no = new JRadioButton("No");
        no.setBounds(500,560,200,30);
        no.setFont(new Font("Raleway",Font.BOLD,20));
        add(no);
        ButtonGroup senior = new ButtonGroup();
        senior.add(yes);
        senior.add(no);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setBounds(100,620,200,30);
        existingAccount.setFont(new Font("Raleway",Font.BOLD,20));
        add(existingAccount);
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,620,200,30);
        eyes.setFont(new Font("Raleway",Font.BOLD,20));
        add(eyes);
        eno = new JRadioButton("No");
        eno.setBounds(500,620,200,30);
        eno.setFont(new Font("Raleway",Font.BOLD,20));
        add(eno);
        ButtonGroup existing = new ButtonGroup();
        existing.add(eyes);
        existing.add(eno);
        next = new JButton("NEXT");
        next.setBounds(480,700,200,30);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        add(next);
        next.addActionListener(this);
        setSize(850,800);
        setVisible(true);
        setLocation(250,20);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
        String religion = (String)religionBox.getSelectedItem();
        String category = (String) categoryBox.getSelectedItem();
        String income = (String)incomeBox.getSelectedItem();
        String occupation =(String)occupationBox.getSelectedItem();
        String education =(String)eduQuaBox.getSelectedItem();
        String seniorCitizen = null;
        if(yes.isSelected()){
            seniorCitizen = "Yes";
        }else if(no.isSelected()){
            seniorCitizen="No";
        }
        String existingAccount= null;
        if(eyes.isSelected()){
            existingAccount = "Yes";
        }else if(eno.isSelected()){
            existingAccount="No";
        }
        String pan = panTextField.getText();
        String ninNo = ninNoTextField.getText();
        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+ninNo+"','"+existingAccount+"','"+seniorCitizen+"') ";
            c.s.executeUpdate(query);
            setVisible(false);
            new signupthree(formno).setVisible(true);
            

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new sign2("");
    }
}
