/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author AAYUSH DHIMAN
 */
public class StudentLeave extends JFrame implements ActionListener{
    Choice c1,c2;
    JDateChooser d1;
    JButton submit,cancel;
    StudentLeave(){
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel heading=new JLabel("Student Leave Application");
        heading.setBounds(100, 10, 300, 30);
        heading.setFont(new Font("algerian",Font.BOLD,20));
        add(heading);
        
        JLabel roll=new JLabel("Search By Roll Number");
        roll.setBounds(20, 60, 200, 30);
        roll.setFont(new Font("tahoma",Font.PLAIN,18));
        add(roll);
        
        c1=new Choice();
        c1.setBounds(220, 65, 150, 30);
        add(c1);
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
        
        JLabel date=new JLabel("Date");
        date.setBounds(20, 100, 100, 30);
        date.setFont(new Font("tahoma",Font.PLAIN,18));
        add(date);
        
        d1=new JDateChooser();
        d1.setBounds(220, 100, 150, 30);
        add(d1);
        
        JLabel time=new JLabel("Time Duration");
        time.setBounds(20, 140, 150, 30);
        time.setFont(new Font("tahoma",Font.PLAIN,18));
        add(time);
        
        c2=new Choice();
        c2.setBounds(220, 140, 150, 30);
        c2.add("Full Day");
        c2.add("Half Day");
        add(c2);
        
        submit=new JButton("SUBMIT");
        submit.setBounds(100, 200, 100, 30);
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        submit.setForeground(Color.white);
        add(submit);
        
        cancel=new JButton("CANCEL");
        cancel.setBounds(250, 200, 100, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(500, 400);
        setLocation(500, 150);
//        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            String roll=c1.getSelectedItem();
            String date=((JTextField)d1.getDateEditor().getUiComponent()).getText();
            String time=c2.getSelectedItem();
            String qry="insert into student_leave values(?,?,?)";
            try{
                Conn c1=new Conn();
                PreparedStatement ps=c1.con.prepareStatement(qry);
                ps.setString(1, roll);
                ps.setString(2, date);
                ps.setString(3,time);
                int a=ps.executeUpdate();
                if(a==1){
                    JOptionPane.showMessageDialog(null, "Leave Approved");
                    setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "Leave Not Approved");
            }catch(Exception ep){
                System.out.println(ep);
            }
        }
        else if(e.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentLeave();
    } 
}