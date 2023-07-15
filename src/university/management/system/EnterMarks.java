/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

import java.sql.*;
/**
 *
 * @author AAYUSH DHIMAN
 */
public class EnterMarks extends JFrame implements ActionListener{
    JLabel marks,rl,sem,sub,mrk;
    Choice c1,c2;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    JButton submit,exit;
    public EnterMarks(){
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450, 60, 400, 300);
        add(image);
        
        marks=new JLabel("Enter Marks Of Student");
        marks.setBounds(10,20,300,40);
        marks.setFont(new Font("californain fb",Font.BOLD,20));
        add(marks);
        
        rl=new JLabel("Select Roll No");
        rl.setBounds(10,70,200,40);
        rl.setFont(new Font("californain fb",Font.BOLD,20));
        add(rl);
        
        c1=new Choice();
        c1.setBounds(230,70,200,40);
        c1.setFont(new Font("californain fb",Font.BOLD,20));
        
        String qry="select * from student_info";
        try{
            Conn c11=new Conn();
            PreparedStatement ps=c11.con.prepareStatement(qry);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                c1.add(rs.getString(3));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        add(c1);
        
        sem=new JLabel("Select Semester");
        sem.setBounds(10,130,200,40);
        sem.setFont(new Font("californain fb",Font.BOLD,20));
        add(sem);
        
        c2=new Choice();
        c2.setBounds(230,130,200,40);
        c2.setFont(new Font("californain fb",Font.BOLD,20));
        c2.add("1st sem");
        c2.add("2nd sem");
        c2.add("3rd sem");
        c2.add("4th sem");
        c2.add("5th sem");
        c2.add("6th sem");
        add(c2);
        
        sub=new JLabel("Enter Subject");
        sub.setBounds(70,180,150,40);
        sub.setFont(new Font("californain fb",Font.BOLD,20));
        add(sub);
        
        mrk=new JLabel("Enter Marks");
        mrk.setBounds(250,180,150,40);
        mrk.setFont(new Font("californain fb",Font.BOLD,20));
        add(mrk);
        
        t1=new JTextField();
        t1.setBounds(30, 230, 170, 20);
        add(t1);
        
        t2=new JTextField();
        t2.setBounds(200, 230, 170, 20);
        add(t2);
        
        t3=new JTextField();
        t3.setBounds(30, 250, 170, 20);
        add(t3);
        
        t4=new JTextField();
        t4.setBounds(200, 250, 170, 20);
        add(t4);
        
        t5=new JTextField();
        t5.setBounds(30, 270, 170, 20);
        add(t5);
        
        t6=new JTextField();
        t6.setBounds(200, 270, 170, 20);
        add(t6);
        
        t7=new JTextField();
        t7.setBounds(30, 290, 170, 20);
        add(t7);
        
        t8=new JTextField();
        t8.setBounds(200, 290, 170, 20);
        add(t8);
        
        t9=new JTextField();
        t9.setBounds(30, 310, 170, 20);
        add(t9);
        
        t10=new JTextField();
        t10.setBounds(200, 310, 170, 20);
        add(t10);
        
        submit=new JButton("SUBMIT");
        submit.setBounds(120, 350, 200, 40);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        exit=new JButton("EXIT");
        exit.setBounds(120, 400, 200, 40);
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);
        
        setSize(900,500);
        setLocation(300,100);
        getContentPane().setBackground(Color.white);
//        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit)
            setVisible(false);
        else{
            String roll=c1.getSelectedItem();
            String sem=c2.getSelectedItem();
            String sub1=t1.getText();
            String m1=t2.getText();
            String sub2=t3.getText();
            String m2=t4.getText();
            String sub3=t5.getText();
            String m3=t6.getText();
            String sub4=t7.getText();
            String m4=t8.getText();
            String sub5=t9.getText();
            String m5=t10.getText();
            String query="insert into subject values (?,?,?,?,?,?,?)";
            String query2="insert into marks values (?,?,?,?,?,?,?)";
            try{
                Conn c1=new Conn();
                PreparedStatement ps=c1.con.prepareStatement(query);
                ps.setString(1, roll);
                ps.setString(2, sem);
                ps.setString(3, sub1);
                ps.setString(4, sub2);
                ps.setString(5, sub3);
                ps.setString(6, sub4);
                ps.setString(7, sub5);
                ps.executeUpdate();
                PreparedStatement pss=c1.con.prepareStatement(query2);
                pss.setString(1, roll);
                pss.setString(2, sem);
                pss.setString(3, m1);
                pss.setString(4, m2);
                pss.setString(5, m3);
                pss.setString(6, m4);
                pss.setString(7, m5);
                int a=pss.executeUpdate();
                if(a==1){
                    JOptionPane.showMessageDialog(null, "Record Added");
                    setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Record Not Added");
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new EnterMarks();
    }
}
