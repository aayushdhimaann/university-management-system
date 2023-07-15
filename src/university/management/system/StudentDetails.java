/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author AAYUSH DHIMAN
 */
public class StudentDetails extends JFrame implements ActionListener{
    Choice c1;
    JTable table;
    JButton search,print,update,add,cancel;
    StudentDetails(){
        
//        getContentPane().setBackground(Color.white);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel student=new JLabel("Student Details");
        student.setBounds(380, 20, 200, 30);
        student.setForeground(Color.red);
        student.setFont(new Font("californain fb",Font.BOLD,20));
        add(student);
        
        JLabel heading=new JLabel("Search By Roll Number");
        heading.setBounds(20, 40, 150, 30);
        add(heading);
        
        c1=new Choice();
        c1.setBounds(200, 45, 150, 30);
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
        
        table=new JTable();
        
        try{
            Conn c11=new Conn();
            PreparedStatement ps=c11.con.prepareStatement(qry);
            ResultSet rs=ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        JScrollPane jp=new JScrollPane(table);
        jp.setBounds(0, 100, 1000, 500);
        add(jp);
        
        search=new JButton("SEARCH");
        search.setBounds(20, 80, 100, 20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("PRINT");
        print.setBounds(140, 80, 100, 20);
        print.addActionListener(this);
        add(print);       
        
        update=new JButton("UPDATE");
        update.setBounds(260, 80, 100, 20);
        update.addActionListener(this);
        add(update);

        add=new JButton("ADD");
        add.setBounds(380, 80, 100, 20);
        add.addActionListener(this);
        add(add);
        
        cancel=new JButton("CANCEL");
        cancel.setBounds(500, 80, 100, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(1000,600);
        setLocation(250,100);
//        setVisible(true);
    }
//    public voi
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==search){
            String choice=c1.getSelectedItem();
            String qry="select * from student_info where roll =?";
            try{
                Conn c12=new Conn();
                PreparedStatement pss=c12.con.prepareStatement(qry);
                pss.setString(1, choice);
                ResultSet rss=pss.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rss));
            }catch(Exception eee){
                System.out.println(eee);
            }
        }
        else if(e.getSource()==print){
            try{
                table.print();
            }catch(Exception ee){
                System.out.println(ee);
            }
        }
        else if(e.getSource()==update){
            new UpdateStudent().setVisible(true);
        }
        else if(e.getSource()==add){
            setVisible(false);
            new AddStudent1().setVisible(true);
        }
        else if(e.getSource()==cancel){
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args) {
        new StudentDetails();
    }
}
