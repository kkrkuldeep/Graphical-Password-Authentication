package connector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginPopUp {

	JLabel loginlb;
	JButton loginbtn;
	JFrame jf;

	public LoginPopUp() {
		jf = new JFrame("Go to Login");
		jf.setLayout(null);

		loginlb = new JLabel("Click here to login your account");
		loginlb.setBounds(210, 10, 310, 30);
		jf.add(loginlb);

		loginbtn = new JButton("Login");
		loginbtn.setBounds(220, 70, 160, 30);
		jf.add(loginbtn);
		loginbtn.addActionListener(new LoginPop());

		jf.setVisible(true);
		jf.setSize(600, 180);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	class LoginPop implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			new Login();
		}
	}

}
