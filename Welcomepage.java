package connector;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Welcomepage {

	JFrame jf;
	JLabel imagelb;
	JButton loginbtn, signupbtn;

	public Welcomepage() {

		jf = new JFrame("Welcome Page");
		jf.setLayout(null);

		loginbtn = new JButton("Login");
		loginbtn.setFont(new Font("Login", Font.BOLD, 16));
		loginbtn.setBounds(290, 520, 380, 60);
		loginbtn.addActionListener(new login());
		jf.add(loginbtn);

		signupbtn = new JButton("Sign Up");
		signupbtn.setFont(new Font("Sign Up", Font.BOLD, 16));
		signupbtn.setBounds(690, 520, 380, 60);
		jf.add(signupbtn);

		imagelb = new JLabel();
		imagelb.setBounds(0, 0, 1370, 730);
		ImageIcon img = new ImageIcon(
				((new ImageIcon("Welcome.jpg")).getImage()).getScaledInstance(1370, 730, java.awt.Image.SCALE_SMOOTH));
		imagelb.setIcon(img);
		jf.add(imagelb);

		JPanel jp = new JPanel();
		jp.setBounds(450, 100, 600, 600);
		jp.setBackground(Color.BLACK);
		jf.add(jp);

		jf.setResizable(false);
		jf.setVisible(true);
		jf.setSize(1370, 730);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class login implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			new Login();
		}
	}

	class sign implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			new SignUp();
		}
	}

}
