package connector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class ForgetPassword {
	JFrame jf;
	JLabel emaillb, confirmlb, llb, reconfimlb;
	JTextField emailtf;
	JPasswordField confirmpf, reconfirmpf;
	JButton savebtn;

	public ForgetPassword() {

		jf = new JFrame("Forget Password");
		jf.setLayout(null);

		llb = new JLabel("Change your password");
		llb.setBounds(200, 10, 150, 30);
		jf.add(llb);

		emaillb = new JLabel("Email-Id");
		emaillb.setBounds(80, 50, 100, 30);
		jf.add(emaillb);

		emailtf = new JTextField();
		emailtf.setBounds(210, 50, 210, 30);
		jf.add(emailtf);

		confirmlb = new JLabel("Confirm Password");
		confirmlb.setBounds(80, 90, 150, 30);
		jf.add(confirmlb);

		confirmpf = new JPasswordField();
		confirmpf.setBounds(210, 90, 210, 30);
		jf.add(confirmpf);

		reconfimlb = new JLabel("Re-enter Password");
		reconfimlb.setBounds(80, 130, 150, 30);
		jf.add(reconfimlb);

		reconfirmpf = new JPasswordField();
		reconfirmpf.setBounds(210, 130, 210, 30);
		jf.add(reconfirmpf);

		savebtn = new JButton("Save");
		savebtn.setBounds(320, 190, 100, 30);
		jf.add(savebtn);
		savebtn.addActionListener(new save());

		jf.setVisible(true);
		jf.setSize(600, 700);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class save implements ActionListener {

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent E) {

			try {

				if (emailtf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Email can't be empty");
					return;

				} else if (confirmpf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Confirm password can't be empty");
					return;

				} else if (reconfirmpf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Re-confirm password can't be empty");
					return;
				}

				if (confirmpf.getText().equals(reconfirmpf.getText())) {

				} else {
					JOptionPane.showMessageDialog(null, "Password didn't match");
					emailtf.setText(null);
					confirmpf.setText(null);
					reconfirmpf.setText(null);
					return;
				}

				String inputEmail = emailtf.getText();

				String isMailIDTrue = "SELECT email FROM student WHERE email = \"" + inputEmail + "\"";

				Connection con = DataBaseConnection.JAVAConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(isMailIDTrue);

				if (rs.next() == true) {
					String registeredEmail = rs.getString(1);

					if (registeredEmail.equals(inputEmail)) {
						System.out.println("Valid email-id");

						String changePassword = "UPDATE student SET password='" + confirmpf.getText()
								+ "' WHERE email='" + registeredEmail + "'";

						st.executeUpdate(changePassword);

						JOptionPane.showMessageDialog(null, "Password changed successfully");
						new Login();

					} else {
						JOptionPane.showMessageDialog(null, "Invalid");
						emailtf.setText(null);
						confirmpf.setText(null);
						reconfirmpf.setText(null);
						new SignUp();
						System.out.println("Login Failed! Register your account now");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Email-ID");
					emailtf.setText(null);
					confirmpf.setText(null);
					reconfirmpf.setText(null);
				}

				st.close();
				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}
		}
	}

}
