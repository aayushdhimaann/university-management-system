package university.management.system;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author AAYUSH DHIMAN
 */

public class SliderFrame extends JFrame implements Runnable{
    Thread t1;
    SliderFrame(){
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2=img.getImage().getScaledInstance(1300, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledimg=new ImageIcon(i2);
        JLabel image=new JLabel(scaledimg);
        add(image);
        
        t1=new Thread(this);
        t1.start();
        
        setVisible(true);
        
        for(int i=0;i<=500;i++){
            setLocation(i-370,i-460);
            setSize(i*2+300,i+200);
            
            try{
                Thread.sleep(1);
            }
            catch(Exception e){}
        }
        
    }
    public void run(){
        try{
            Thread.sleep(5000);
            setVisible(false);
            
            new Login();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
           new SliderFrame();
    }
}
