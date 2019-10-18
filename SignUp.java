package code.java;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.sql.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class SignUp {

	JFrame f;
	JLabel name,age,gender,mob,email,bgimage,userid;
	JButton submit,back,image;
	static JTextField iname,iage,imob,iemail,imagefield,iuserid;
	static JRadioButton male,female,other;
	ButtonGroup bg;
  static String path;
	
	
	SignUp(){
		f=new JFrame("SignUp");
		f.setLayout(null);
		
		
		
		back=new JButton("Back");
		back.setBounds(20, 50, 80, 30);
		f.add(back);
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				f.dispose();
			}
		});
		
		name=new JLabel("Name");
		name.setForeground(Color.WHITE);
		name.setBounds(50, 150, 100, 30);
		f.add(name);
		
		iname=new JTextField();
		iname.setBounds(200, 150, 130, 30);
		f.add(iname);
	
		userid=new JLabel("UserID");
		userid.setForeground(Color.WHITE);
		userid.setBounds(50, 190, 100, 30);
		f.add(userid);
		
		iuserid=new JTextField();
		iuserid.setBounds(200, 190, 130, 30);
		f.add(iuserid);
		
		
		
		age=new JLabel("Age");
		age.setForeground(Color.WHITE);
		age.setBounds(50, 230, 100, 30);
		f.add(age);
		
		iage=new JTextField();
		iage.setBounds(200, 230, 130, 30);
		f.add(iage);
		
		gender=new JLabel("Gender");
		gender.setForeground(Color.WHITE);
		gender.setBounds(50, 270, 100, 30);
		f.add(gender);
		
		male=new JRadioButton("Male");
		//male.setForeground(Color.WHITE);
		male.setBounds(200, 270, 80, 30);
		f.add(male);
		
		female=new JRadioButton("Female");
		//female.setForeground(Color.WHITE);
		female.setBounds(290, 270, 100, 30);
		f.add(female);
		
		other=new JRadioButton("Other");
		//other.setForeground(Color.WHITE);
		other.setBounds(400, 270, 100, 30);
		f.add(other);
		
		bg=new ButtonGroup();
		bg.add(male);
		bg.add(female);
		bg.add(other);
		
		mob=new JLabel("Mobile");
		mob.setForeground(Color.WHITE);
		mob.setBounds(50, 310, 100, 30);
		f.add(mob);
		
		imob=new JTextField();
		imob.setBounds(200, 310, 130, 30);
		f.add(imob);
		
		email=new JLabel("email");
		email.setForeground(Color.WHITE);
		email.setBounds(50, 350, 100, 30);
		f.add(email);
		
		iemail=new JTextField();
		iemail.setBounds(200, 350, 130, 30);
		f.add(iemail);
		
		image=new JButton("Image");
		image.setBounds(200, 450, 100, 30);
		f.add(image);
		
		imagefield=new JTextField();
		imagefield.setBounds(310, 450, 200, 30);
		f.add(imagefield);
		
		image.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				JFileChooser chooser=new JFileChooser();
				chooser.showOpenDialog(null);
				FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Image", "jpg","gif","png");
				chooser.addChoosableFileFilter(filter);
				File f=chooser.getSelectedFile();
				path=f.getAbsolutePath();
				imagefield.setText(path);
				//ImageIcon img= new ImageIcon(((new ImageIcon(path)).getImage()).getScaledInstance(1000, 720, java.awt.Image.SCALE_SMOOTH));
				
			}
		});
		
		
		
		
		submit=new JButton("Next");
		submit.setBounds(200, 580, 120, 30);
		f.add(submit);
		
		submit.addActionListener(new Desk());
		
		
		bgimage=new JLabel();
		bgimage.setBounds(0, 0,1000,780);
		ImageIcon img=new ImageIcon(((new ImageIcon("2.jpg")).getImage()).getScaledInstance(1000, 780, java.awt.Image.SCALE_SMOOTH));
		bgimage.setIcon(img);
		f.add(bgimage);
		
		f.setSize(1000,780);
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end of cons
	
	class Desk implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			 new ImageClass();
			 f.dispose();
		
	     }
    }
	public static String method() {
		return path;
	}
	
	public static String nameMethod() {
		String s=iname.getText();
		return s;
	}
	
	public static String useridMethod() {
		String s=iuserid.getText();
		return s;
	}
	
	public static String ageMethod() {
		String s=iage.getText();
		return s;
	}
	
	public static String genderMethod() {
		String s="";
		 if(male.isSelected())
			 s="male";
		 else if(female.isSelected())
			 s="female";
		 else
			 s="other";
		 
		 return s;
	}
	
	public static String mobileMethod() {
		String s=imob.getText();
		return s;
	}
	
	public static String emailMethod() {
		String s=iemail.getText();
		return s;
	}
	
	

}// end of signup class




// image frame


class ImageClass  {
	JFrame frame;
	JButton submit;
	JLabel imagelabel;
	int mouseX,mouseY;
	File file;
	FileInputStream is;
	
	String sname=SignUp.nameMethod();
	String suserid=SignUp.useridMethod();
	String sage=SignUp.ageMethod();
	String sgender=SignUp.genderMethod();
	String smobile=SignUp.mobileMethod();
	String semail=SignUp.emailMethod();
	String kuch=SignUp.method();
	
	ImageClass(){
	
		frame=new JFrame("Take Image");
		frame.setLayout(null);
         	ImageIcon img= new ImageIcon(((new ImageIcon(kuch)).getImage()).getScaledInstance(1000, 620, java.awt.Image.SCALE_SMOOTH));
	        imagelabel=new JLabel();
	        imagelabel.setBounds(0, 0, 1000, 620);
	        imagelabel.setIcon(img);
	        frame.add(imagelabel);
	        
	        imagelabel.addMouseListener(new MouseListener() {
				
			
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				
				public void mouseClicked(MouseEvent me) {
					// TODO Auto-generated method stub
					
					mouseX=me.getX();
					mouseY=me.getY();
					JOptionPane.showMessageDialog(null, "Captured");
					
				}
			});
	       
        submit=new JButton("submit");
		submit.setBounds(500, 660, 200, 40);
		frame.add(submit);
		
		submit.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					String sx=Integer.toString(mouseX);
					String sy=Integer.toString(mouseY);
					Connection con=DB.JAVAConnection();
					PreparedStatement pst=con.prepareStatement("insert into janta(name,userid,age,gender,mobile,email,image,Xc,Yc)value(?,?,?,?,?,?,?,?,?)");
					pst.setString(1, sname);
					pst.setString(2, suserid);
					pst.setString(3, sage);
					pst.setString(4, sgender);
					pst.setString(5, smobile);
					pst.setString(6, semail);
					pst.setString(7, kuch);
					pst.setString(8, sx);
					pst.setString(9, sy);
					
					 //file=new File(kuch);
					 //is=new FileInputStream(file);
					//String q="insert into janta(name,userid,age,gender,mobile,email,image,Xc,Yc)values('"+sname+"','"+suserid+"','"+sage+"','"+sgender+"','"+smobile+"','"+semail+"','"+kuch+"','"+sx+"','"+sy+"')";
					int i=pst.executeUpdate();
					if(i==1) {
						JOptionPane.showMessageDialog(null, "SignUp Successfully");
						new Login();
						frame.dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "Try Again!");
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "error");
					System.out.println("error "+e1);
				}
				
				
			}
		});
		
		
		frame.setSize(1000,780);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//cons ends
	
	
}//class ends
	
	

