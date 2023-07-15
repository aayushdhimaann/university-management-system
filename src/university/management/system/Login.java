/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author AAYUSH DHIMAN
 */

public class Login extends JFrame implements ActionListener{
    JButton login,reset,exit;
    JTextField usertext,passtext;
    JLabel username;
    Login(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        username=new JLabel("Username");
        username.setBounds(40, 20, 150, 20);
        username.setFont(new Font("castellar",Font.BOLD,17));
        add(username);
        
        usertext=new JTextField();
        usertext.setBounds(150,20,150,20);
        usertext.setFont(new Font("californain fb",Font.PLAIN,17));
        add(usertext);
        
        JLabel password=new JLabel("Password");
        password.setBounds(40, 70, 150, 20);
        password.setFont(new Font("castellar",Font.BOLD,17));
        add(password);
        
        passtext=new JPasswordField();
        passtext.setBounds(150,70,150,20);
        passtext.setFont(new Font("californain fb",Font.PLAIN,17));
        add(passtext);
        
        login=new JButton("LOGIN");
        login.setBounds(40, 120, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.setFont(new Font("algerian",Font.ITALIC,16));
        login.addActionListener(this);
        add(login);
        
        reset=new JButton("RESET");
        reset.setBounds(190, 120, 100, 30);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.white);
        reset.setFont(new Font("algerian",Font.ITALIC,16));
        reset.addActionListener(this);
        add(reset);
        
        exit=new JButton("EXIT");
        exit.setBounds(120, 170, 100, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        exit.setFont(new Font("algerian",Font.ITALIC,16));
        add(exit);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            String username=usertext.getText();
            String password=passtext.getText();
            String qry="select * from login where username=? and password = ?";
            try{
                Conn c1=new Conn();
                PreparedStatement ps=c1.con.prepareStatement(qry);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    setVisible(false);
                    new Project().setVisible(true);
//                    System.exit(0);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid Unsername or password");
//                    setVisible(false);
                    System.exit(0);
                }
                c1.con.close();
            }
            catch(Exception ee){
                System.out.println(ee);
            }
            
        }
        else if(ae.getSource()==exit){
            //setVisible(false);
            System.exit(0);
        }
        else if(ae.getSource()==reset){
//            usertext.getAccessibleContext();
                System.out.println("hello");
              usertext.setText("");
              passtext.setText("");
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
