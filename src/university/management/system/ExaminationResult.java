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

public class ExaminationResult extends JFrame implements ActionListener{
    JLabel search,heading,name,tname,fname,tfname,rolll,troll,dob,tdob,sub1,m1,sub2,m2,sub3,m3,sub4,m4,sub5,m5,sem,tsem;
    JTextField roll;
    JButton submit,exit;
    public ExaminationResult(){
        setLayout(null);
        
        heading=new JLabel("Examination Result");
        heading.setBounds(400, 20, 300, 30);
        heading.setFont(new Font("californain fb",Font.BOLD,20));
        add(heading);
        
        search=new JLabel("Enter Roll Number");
        search.setBounds(100, 70, 200, 30);
        search.setFont(new Font("californain fb",Font.BOLD,20));
        add(search);
        
        roll=new JTextField();
        roll.setBounds(350, 70, 150, 30);
        roll.setFont(new Font("californain fb",Font.BOLD,20));
        add(roll);
        
        submit=new JButton("SUBMIT");
        submit.setBounds(600, 70, 100, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        exit=new JButton("EXIT");
        exit.setBounds(800, 70, 100, 30);
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);
        
        name=new JLabel("Name");
        name.setBounds(100, 130, 200, 30);
        name.setFont(new Font("californain fb",Font.BOLD,20));
        add(name);
        
        tname=new JLabel();
        tname.setBounds(250, 130, 200, 30);
        tname.setFont(new Font("californain fb",Font.BOLD,20));
        add(tname);
        
        fname=new JLabel("Father's Name");
        fname.setBounds(500, 130, 200, 30);
        fname.setFont(new Font("californain fb",Font.BOLD,20));
        add(fname);
        
        tfname=new JLabel();
        tfname.setBounds(750, 130, 200, 30);
        tfname.setFont(new Font("californain fb",Font.BOLD,20));
        add(tfname);
        
        rolll=new JLabel("Roll Number");
        rolll.setBounds(100, 190, 200, 30);
        rolll.setFont(new Font("californain fb",Font.BOLD,20));
        add(rolll);
        
        troll=new JLabel();
        troll.setBounds(250, 190, 200, 30);
        troll.setFont(new Font("californain fb",Font.BOLD,20));
        add(troll);
        
        dob=new JLabel("Date Of Birth");
        dob.setBounds(500, 190, 200, 30);
        dob.setFont(new Font("californain fb",Font.BOLD,20));
        add(dob);
        
        tdob=new JLabel();
        tdob.setBounds(750, 190, 200, 30);
        tdob.setFont(new Font("californain fb",Font.BOLD,20));
        add(tdob);
        
        sem=new JLabel("Semester");
        sem.setBounds(300, 220, 200, 30);
        sem.setFont(new Font("californain fb",Font.BOLD,20));
        sem.setForeground(Color.red);
        add(sem);
        
        tsem=new JLabel();
        tsem.setBounds(450, 220, 200, 30);
        tsem.setFont(new Font("californain fb",Font.BOLD,20));
        tsem.setForeground(Color.red);
        add(tsem);
        
        sub1=new JLabel();
        sub1.setBounds(100, 270, 200, 30);
        sub1.setFont(new Font("californain fb",Font.BOLD,20));
        add(sub1);
        
        m1=new JLabel();
        m1.setBounds(400, 270, 200, 30);
        m1.setFont(new Font("californain fb",Font.BOLD,20));
        add(m1);
        
        sub2=new JLabel();
        sub2.setBounds(100, 320, 200, 30);
        sub2.setFont(new Font("californain fb",Font.BOLD,20));
        add(sub2);
        
        m2=new JLabel();
        m2.setBounds(400, 320, 200, 30);
        m2.setFont(new Font("californain fb",Font.BOLD,20));
        add(m2);
        
        sub3=new JLabel();
        sub3.setBounds(100, 370, 200, 30);
        sub3.setFont(new Font("californain fb",Font.BOLD,20));
        add(sub3);
        
        m3=new JLabel();
        m3.setBounds(400, 370, 200, 30);
        m3.setFont(new Font("californain fb",Font.BOLD,20));
        add(m3);
        
        sub4=new JLabel();
        sub4.setBounds(100, 420, 200, 30);
        sub4.setFont(new Font("californain fb",Font.BOLD,20));
        add(sub4);
        
        m4=new JLabel();
        m4.setBounds(400, 420, 200, 30);
        m4.setFont(new Font("californain fb",Font.BOLD,20));
        add(m4);
        
        sub5=new JLabel();
        sub5.setBounds(100, 470, 200, 30);
        sub5.setFont(new Font("californain fb",Font.BOLD,20));
        add(sub5);
        
        m5=new JLabel();
        m5.setBounds(400, 470, 200, 30);
        m5.setFont(new Font("californain fb",Font.BOLD,20));
        add(m5);
        
        getContentPane().setBackground(Color.white);
        setSize(1000,600);
        setLocation(250, 100);
//        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String r=roll.getText();
            String qry1="select * from student_info where roll=?";
            String qry2="select * from subject where roll=?";
            String qry3="select * from marks where roll=?";
            try{
                Conn cc=new Conn();
                PreparedStatement ps1=cc.con.prepareStatement(qry1);
                ps1.setString(1,r);
                PreparedStatement ps2=cc.con.prepareStatement(qry2);
                ps2.setString(1, r);
                PreparedStatement ps3=cc.con.prepareStatement(qry3);
                ps3.setString(1, r);
                ResultSet rs1=ps1.executeQuery();
                ResultSet rs2=ps2.executeQuery();
                ResultSet rs3=ps3.executeQuery();
                
                while(rs1.next()&&rs2.next()&&rs3.next()){
                    tname.setText(rs1.getString(1));
                    tfname.setText(rs1.getString(2));
                    troll.setText(rs2.getString(1));
                    tdob.setText(rs1.getString(4));
                    tsem.setText(rs2.getString(2));
                    sub1.setText(rs2.getString(3));
                    sub2.setText(rs2.getString(4));
                    sub3.setText(rs2.getString(5));
                    sub4.setText(rs2.getString(6));
                    sub5.setText(rs2.getString(7));
                    m1.setText(rs3.getString(3));
                    m2.setText(rs3.getString(4));
                    m3.setText(rs3.getString(5));
                    m4.setText(rs3.getString(6));
                    m5.setText(rs3.getString(7));
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new ExaminationResult();
    }
}
