package code.java;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Login {

	JFrame f;
	JLabel user,bimage;
	JTextField iuser;
	JButton log,signup;
	
	static String s1;
	
	Login(){
		
		f=new JFrame("Login page");
		f.setBackground(Color.CYAN);
		f.setLayout(null);
		
		
		
		
		user=new JLabel("Userid");
		user.setBounds(100, 100, 100, 40);
		user.setForeground(Color.WHITE);
		f.add(user);
		
		iuser=new JTextField();
		iuser.setBounds(200, 100, 130, 30);
		f.add(iuser);
		
		
		log=new JButton("Login");
		log.setBounds(200, 250, 130, 40);
		f.add(log);
		
		log.addActionListener(new action());
		
		signup=new JButton("SignUp");
		signup.setBounds(200, 350, 130, 40);
		f.add(signup);
		
		signup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
			      new SignUp();
			      f.dispose();
				
			}
		});
		
		bimage=new JLabel();
		bimage.setBounds(0,0,1000,780);
		ImageIcon img= new ImageIcon(((new ImageIcon("1.jpg")).getImage()).getScaledInstance(1000, 780, java.awt.Image.SCALE_SMOOTH));
		bimage.setIcon(img);
		f.add(bimage);
		
		f.setSize(1000,780);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	class action implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		      s1=iuser.getText();
			try {
			Connection con=DB.JAVAConnection();
			Statement st=con.createStatement();
			 String ss="select *from janta where userid='"+s1+"'";
			 ResultSet rs=st.executeQuery(ss);
			if(rs.next()) {
				   new LogImage();
				   f.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "wrong userid..!");
			}
			}catch(Exception ex) {
				System.out.print("Error  "+ex);
			}
			
		}
	}
	
 public static String usermethod() {
	 return s1;
	 
 }


}