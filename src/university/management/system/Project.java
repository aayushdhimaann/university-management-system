/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author AAYUSH DHIMAN
 */
public class Project extends JFrame implements ActionListener{
    
    Project(){
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1500  , 650 , Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        
        JMenuBar menu=new JMenuBar();
      
//        adding new Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.red);
        menu.add(newInformation);
        
        JMenuItem fInfo=new JMenuItem("New Faculty Information");
        fInfo.setBackground(Color.white);
        fInfo.addActionListener(this);
        newInformation.add(fInfo);
        
        JMenuItem sInfo=new JMenuItem("New Student Information");
        sInfo.setBackground(Color.white);
        sInfo.addActionListener(this);
        newInformation.add(sInfo);
        
//        showing details of new information
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.red);
        menu.add(details);
        
        JMenuItem fDetails=new JMenuItem("View Faculty Details");
        fDetails.setBackground(Color.white);
        fDetails.addActionListener(this);
        details.add(fDetails);
        
        JMenuItem sDetails=new JMenuItem("View Student Details");
        sDetails.addActionListener(this);
        sDetails.setBackground(Color.white);
        details.add(sDetails);
        
//        applying for leave
        JMenu leave = new JMenu("Apply for Leave");
        leave.setForeground(Color.red);
        menu.add(leave);
        
        JMenuItem fleave=new JMenuItem("New Faculty leave");
        fleave.addActionListener(this);
        fleave.setBackground(Color.white);
        leave.add(fleave);
        
        JMenuItem sleave=new JMenuItem("New Student leave");
        sleave.addActionListener(this);
        sleave.setBackground(Color.white);
        leave.add(sleave);
        
//        checking for applied leave
        JMenu checkleave = new JMenu("Leave Details");
        checkleave.setForeground(Color.red);
        menu.add(checkleave);
        
        JMenuItem fapleave=new JMenuItem("Faculty leave details");
        fapleave.setBackground(Color.white);
        fapleave.addActionListener(this);
        checkleave.add(fapleave);
        
        JMenuItem sapleave=new JMenuItem("Student leave details");
        sapleave.setBackground(Color.white);
        sapleave.addActionListener(this);
        checkleave.add(sapleave);
        
//        exam
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.red);
        menu.add(exam);
        
        JMenuItem examresult=new JMenuItem("Examination Result");
        examresult.setBackground(Color.white);
        examresult.addActionListener(this);
        exam.add(examresult);
        
        JMenuItem entermarks=new JMenuItem("Enter new Exam Marks");
        entermarks.setBackground(Color.white);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        
//        updating information
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.red);
        menu.add(updateInfo);
        
        JMenuItem upfdetails=new JMenuItem("Update Faculty Details");
        upfdetails.setBackground(Color.white);
        upfdetails.addActionListener(this);
        updateInfo.add(upfdetails);
        
        JMenuItem upsdetails=new JMenuItem("Update Student Details");
        upsdetails.setBackground(Color.white);
        upsdetails.addActionListener(this);
        updateInfo.add(upsdetails);
        
//        fees
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.red);
        menu.add(fee);
        
        JMenuItem feestructure=new JMenuItem("View Fee Structure");
        feestructure.setBackground(Color.white);
        feestructure.addActionListener(this);
        fee.add(feestructure);
        
        JMenuItem feeform=new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.white);
        feeform.addActionListener(this);
        fee.add(feeform);
        
//        utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.red);
        menu.add(utility);
        
        JMenuItem notepad=new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem cal=new JMenuItem("Calculator");
        cal.setBackground(Color.white);
        cal.addActionListener(this);
        utility.add(cal);
        
//        exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
        menu.add(exit);
        
        JMenuItem e=new JMenuItem("Exit");
        e.setBackground(Color.white);
        e.addActionListener(this);
        exit.add(e);
        
        setJMenuBar(menu);
        
        
        setSize(1500,750);
        setLocation(20,20);
//        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        String msg=e.getActionCommand();
        if(msg.equals("Exit")){
            System.exit(0);
        }
        else if(msg.equals("View Student Details")){
            new StudentDetails().setVisible(true);
        }
        else if(msg.equals("View Faculty Details")){
            new TeacherDetails().setVisible(true);
        }
        else if(msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception ee){}
        }
        else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception ee){}
        }
        else if(msg.equals("New Student Information")){
            try{
                new AddStudent1().setVisible(true);
                //System.exit(0);
                
            }catch(Exception ee){
                System.out.println(ee);
            }
        }
        else if(msg.equals("New Faculty Information")){
            new AddFaculty().setVisible(true);
        }
        else if(msg.equals("New Faculty leave")){
            new TeacherLeave().setVisible(true);
        }
        else if(msg.equals("New Student leave")){
            new StudentLeave().setVisible(true);
        }
        else if(msg.equals("Student leave details")){
            new StudentLeaveDetails().setVisible(true);
        }
        else if(msg.equals("Faculty leave details")){
            new TeacherLeaveDetails().setVisible(true);
        }
        else if(msg.equals("Update Faculty Details")){
            new UpdateFaculty().setVisible(true);
        }
        else if(msg.equals("Update Student Details")){
            new UpdateStudent().setVisible(true);
        }
        else if(msg.equals("Enter new Exam Marks")){
            new EnterMarks().setVisible(true);
        }
        else if(msg.equals("Examination Result")){
            new ExaminationResult().setVisible(true);
        }
        else if(msg.equals("View Fee Structure")){
            new Fee().setVisible(true);
        }
        else if(msg.equals("Student Fee Form")){
            new StudentForm().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Project();
    }
}
