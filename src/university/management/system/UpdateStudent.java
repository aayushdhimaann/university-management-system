/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
/**
 *
 * @author AAYUSH DHIMAN
 */
public class UpdateStudent extends JFrame implements ActionListener{
    JLabel heading,name,tn,fname,search,tf,roll,tr,dob,td,address,phone,email,ten,tt,twelfth,tw,aadhar,tad,qual,depart;
    JTextField ta,tph,te;
    Choice c1,course,department;
    JButton submit,exit,reset;
    public UpdateStudent(){
        setLayout(null);
        
        heading=new JLabel("Update Student Details");
        heading.setBounds(400, 30, 300, 30);
        heading.setFont(new Font("algerian",Font.BOLD,20));
        add(heading);
        
        search=new JLabel("Search By Roll Number");
        search.setBounds(50, 70, 300, 30);
        search.setFont(new Font("algerian",Font.BOLD,20));
        add(search);
        
        c1=new Choice();
        c1.setBounds(400, 70, 200, 30);
        c1.setFont(new Font("algerian",Font.BOLD,20));
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
        
        name=new JLabel("Name");
        name.setBounds(100, 130, 100, 30);
        name.setFont(new Font("algerian",Font.BOLD,20));
        add(name);
        
        tn=new JLabel("");
        tn.setBounds(290, 130, 300, 30);
        tn.setFont(new Font("arial",Font.BOLD,20));
        add(tn);
        
        fname=new JLabel("Father's Name");
        fname.setBounds(600, 130, 200, 30);
        fname.setFont(new Font("algerian",Font.BOLD,20));
        add(fname);
        
        tf=new JLabel("");
        tf.setBounds(800 , 130, 250, 30);
        tf.setFont(new Font("arial",Font.BOLD,20));
        add(tf);
        
        roll=new JLabel("Roll Number");
        roll.setBounds(100, 170, 150, 30);
        roll.setFont(new Font("algerian",Font.BOLD,20));
        add(roll);
        
        tr=new JLabel("");
        tr.setBounds(290, 170, 150, 30);
        tr.setFont(new Font("arial",Font.BOLD,20));
        add(tr);
        
        dob=new JLabel("Date Of Birth");
        dob.setBounds(600, 170, 150, 30);
        dob.setFont(new Font("algerian",Font.BOLD,20));
        add(dob);
        
        td=new JLabel("");
        td.setBounds(800, 170, 250, 30);
        td.setFont(new Font("arial",Font.BOLD,20));
        add(td);
        
        address=new JLabel("Address");
        address.setBounds(100, 210, 150, 30);
        address.setFont(new Font("algerian",Font.BOLD,20));
        add(address);
        
        ta=new JTextField("");
        ta.setBounds(290, 210, 150, 30);
        ta.setFont(new Font("arial",Font.BOLD,20));
        add(ta);
        
        phone=new JLabel("Phone");
        phone.setBounds(600, 210, 150, 30);
        phone.setFont(new Font("algerian",Font.BOLD,20));
        add(phone);
        
        tph=new JTextField("");
        tph.setBounds(800, 210, 150, 30);
        tph.setFont(new Font("arial",Font.BOLD,20));
        add(tph);
        
        email=new JLabel("Email Id");
        email.setBounds(100, 250, 150, 30);
        email.setFont(new Font("algerian",Font.BOLD,20));
        add(email);
        
        te=new JTextField("");
        te.setBounds(290, 250, 150, 30);
        te.setFont(new Font("arial",Font.BOLD,20));
        add(te);
        
        ten=new JLabel("Class X (%)");
        ten.setBounds(600, 250, 150, 30);
        ten.setFont(new Font("algerian",Font.BOLD,20));
        add(ten);
        
        tt=new JLabel("");
        tt.setBounds(800, 250, 150, 30);
        tt.setFont(new Font("algerian",Font.BOLD,20));
        add(tt);
        
        twelfth=new JLabel("Class XII (%)");
        twelfth.setBounds(100, 290, 150, 30);
        twelfth.setFont(new Font("algerian",Font.BOLD,20));
        add(twelfth);
        
        tw=new JLabel("");
        tw.setBounds(290, 290, 150, 30);
        tw.setFont(new Font("algerian",Font.BOLD,20));
        add(tw);
        
        aadhar=new JLabel("Aadhar No.");
        aadhar.setBounds(600, 290, 150, 30);
        aadhar.setFont(new Font("algerian",Font.BOLD,20));
        add(aadhar);
        
        tad=new JLabel("");
        tad.setBounds(800, 290, 200, 30);
        tad.setFont(new Font("algerian",Font.BOLD,20));
        add(tad);
        
        qual=new JLabel("Qualification");
        qual.setBounds(100, 340, 170, 30);
        qual.setFont(new Font("algerian",Font.BOLD,20));
        add(qual);
        
        course=new Choice();
        course.setBounds(290,340,120,30);
        course.setFont(new Font("arial",Font.BOLD,20));
        course.add("B.Tech");
        course.add("BCA");
        course.add("BBA");
        course.add("MCA");
        course.add("MBA");
        add(course);
        
        depart=new JLabel("Department");
        depart.setBounds(600, 340, 170, 30);
        depart.setFont(new Font("algerian",Font.BOLD,20));
        add(depart);
        
        department=new Choice();
        department.setBounds(800,340,120,30);
        department.setFont(new Font("arial",Font.BOLD,20));
        department.add("CS");
        department.add("Electronics");
        department.add("Mechanical");
        department.add("Civil");
        department.add("IT");
        add(department);
        
        submit=new JButton("SUBMIT");
        submit.setBounds(200, 400, 200, 40);
        submit.setFont(new Font("algerian",Font.BOLD,20));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        reset=new JButton("RESET");
        reset.setBounds(700, 400, 200, 40);
        reset.setFont(new Font("algerian",Font.BOLD,20));
        reset.setBackground(Color.black);
        reset.setForeground(Color.white);
        reset.addActionListener(this);
        add(reset);
        
        exit=new JButton("EXIT");
        exit.setBounds(460, 500, 200, 40);
        exit.setFont(new Font("algerian",Font.BOLD,20));
        exit.setBackground(Color.red);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        add(exit);
        
        
        
//        System.out.println(rollno);
        try{
            Conn c12=new Conn();
            String rollno=c1.getSelectedItem();
            String qry1="select * from student_info where roll=?";
            PreparedStatement pss=c12.con.prepareStatement(qry1);
            pss.setString(1, rollno);
            ResultSet rss=pss.executeQuery();
            while(rss.next()){
                tn.setText(rss.getString("name"));
                tf.setText(rss.getString("fname"));
                tr.setText(rss.getString("roll"));
                td.setText(rss.getString("date"));
                ta.setText(rss.getString("address"));
                tph.setText(rss.getString("phone"));
                te.setText(rss.getString("email"));
                tt.setText(rss.getString("tenth"));
                tw.setText(rss.getString("twelfth"));
                tad.setText(rss.getString("aadhar"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        c1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try{
                    Conn c12=new Conn();
                    String rollno=c1.getSelectedItem();
                    String qry1="select * from student_info where roll=?";
                    PreparedStatement pss=c12.con.prepareStatement(qry1);
                    pss.setString(1, rollno);
                    ResultSet rss=pss.executeQuery();
                    while(rss.next()){
                        tn.setText(rss.getString("name"));
                        tf.setText(rss.getString("fname"));
                        tr.setText(rss.getString("roll"));
                        td.setText(rss.getString("date"));
                        ta.setText(rss.getString("address"));
                        tph.setText(rss.getString("phone"));
                        te.setText(rss.getString("email"));
                        tt.setText(rss.getString("tenth"));
                        tw.setText(rss.getString("twelfth"));
                        tad.setText(rss.getString("aadhar"));
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        });
        
        getContentPane().setBackground(Color.white);
        setSize(1200,700);
        setLocation(150,50);
//        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
        }
        else if(ae.getSource()==reset){
            ta.setText("");
            tph.setText("");
            te.setText("");
        }
        else{
            String rollno=c1.getSelectedItem();
            String address=ta.getText();
            String phone=tph.getText();
            String email=te.getText();
            String c=course.getSelectedItem();
            String dept=department.getSelectedItem();
            String qry="update student_info set address=? , phone=? , email=? , course=? , branch=? where roll=?";
            try{
                Conn c1=new Conn();
                PreparedStatement ps=c1.con.prepareStatement(qry);
                ps.setString(1, address);
                ps.setString(2, phone);
                ps.setString(3, email);
                ps.setString(4, c);
                ps.setString(5, dept);
                ps.setString(6, rollno);
                int a=ps.executeUpdate();
                if(a==1){
                    JOptionPane.showMessageDialog(null, "Student Record Updated");
                    setVisible(false);
                }
                else
                    JOptionPane.showMessageDialog(null, "student record not updated");
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new UpdateStudent();
    }
}
