package code.java;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Welcome {
	JFrame f;
	JLabel label,imagelabel;
	
	Welcome(){
	
		
		  f=new JFrame("Welcome Page");
		  f.setLayout(null);
		
//		  label=new JLabel("Welcome to the page");
//		  label.setForeground(Color.BLUE);
//		  label.setBounds(20, 100, 1000, 200);
//		  f.add(label);
		  
		    imagelabel=new JLabel();
			imagelabel.setBounds(0,0,1000,780);
			ImageIcon img= new ImageIcon(((new ImageIcon("wqelcome.jpg")).getImage()).getScaledInstance(1000, 780, java.awt.Image.SCALE_SMOOTH));
			imagelabel.setIcon(img);
			f.add(imagelabel);
		
		  f.setSize(1000,630);
	      f.setBackground(Color.CYAN); 	
		  f.setResizable(false);
		  f.setVisible(true);
		  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
