package code.java;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import com.mysql.jdbc.PreparedStatement;



public class LogImage {
	
	JFrame f;
	JLabel lbimage;
	JButton submit;
	static String s=Login.usermethod();
	int mouseX,mouseY;
	int dmouseX,dmouseY;
	String xc,yc;
	LogImage(){
		
		f=new JFrame("Login page");
		f.setBackground(Color.CYAN);
		f.setLayout(null);
		
		lbimage=new JLabel();
		
		  submit=new JButton("Submit");
		  submit.setBounds(450, 670, 140, 30);
		  f.add(submit);
		try {
			
			
			Connection con=DB.JAVAConnection();
		     java.sql.PreparedStatement pst=con.prepareStatement("select * from janta where userid='"+s+"'");
			 //String ss="select *from janta where id='"+2+"'";
			 ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
			 String str=rs.getString("image");
		      xc=rs.getString("xc");
		      yc=rs.getString("yc");
			 ImageIcon img= new ImageIcon(((new ImageIcon(str)).getImage()).getScaledInstance(1000, 620, java.awt.Image.SCALE_SMOOTH));
		     lbimage.setIcon(img);
		     lbimage.setBounds(0, 0, 1000, 620);	
		     f.add(lbimage);
		     
		     lbimage.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent me) {
					// TODO Auto-generated method stub
					mouseX=me.getX();
					mouseY=me.getY();
					dmouseX=Integer.valueOf(xc);
					dmouseY=Integer.valueOf(yc);
					if(mouseX<=dmouseX+5 && mouseX>dmouseX-5 && mouseY<=dmouseY+5 && mouseY>dmouseY-5) {
						new Welcome();
						f.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "wrong position...!!!");
					}
					
				}
			});
			
		    
		  
		     
		     
			}else {
				JOptionPane.showMessageDialog(null, "wrong userid..!");
			}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error..!");
			}
		
		  
		  
		  
			
		  f.setSize(1000,630);
	      f.setBackground(Color.CYAN); 	
		  f.setResizable(false);
		  f.setVisible(true);
		  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end of cons

} // end of class
