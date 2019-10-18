package connector;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import javax.swing.*;

public class Login {

	JFrame jf;
	JLabel emaillb, emaillb2, passlb, llb, imagelb, orlb, panelbacklb, _1panelimagelb, _2panelimagelb, _3panelimagelb;;
	JTextField emailtf, emailtf2;
	JPasswordField ppf;
	JButton logbtn, forgetbtn, signupbtn, graphicalPassbtn, panelbtn1, panelbtn2, panelbtn3, graphicloginbtn;
	JPanel panel, imagepanel1, imagepanel2, imagepanel3;
	InputStream input;
	FileOutputStream output;
	File f;
	static int i = 1, j = 0, l = 0;
	String[] imagePath = new String[3];
	int[] mousepoint = new int[6];
	ImageIcon img;

	public Login() {

		jf = new JFrame("Login");
		jf.setLayout(null);

		llb = new JLabel("Login account");
		llb.setForeground(Color.white);
		llb.setFont(new Font("", Font.BOLD, 20));
		llb.setBounds(100, 30, 150, 30);
		jf.add(llb);

		emaillb = new JLabel("Email-id");
		emaillb.setForeground(Color.white);
		emaillb.setFont(new Font("", Font.BOLD, 16));
		emaillb.setBounds(100, 90, 100, 30);
		jf.add(emaillb);

		emailtf = new JTextField();
		emailtf.setBounds(210, 90, 210, 30);
		jf.add(emailtf);

		passlb = new JLabel("Password");
		passlb.setForeground(Color.white);
		passlb.setFont(new Font("", Font.BOLD, 16));
		passlb.setBounds(100, 130, 100, 30);
		jf.add(passlb);

		ppf = new JPasswordField();
		ppf.setBounds(210, 130, 210, 30);
		jf.add(ppf);

		logbtn = new JButton("Login");
		logbtn.setFont(new Font("", Font.BOLD, 14));
		logbtn.setBounds(100, 190, 320, 40);
		jf.add(logbtn);
		logbtn.addActionListener(new log());

		forgetbtn = new JButton("Forget Password");
		forgetbtn.setFont(new Font("", Font.BOLD, 14));
		forgetbtn.setBounds(100, 250, 155, 40);
		jf.add(forgetbtn);
		forgetbtn.addActionListener(new forget());

		signupbtn = new JButton("Signup");
		signupbtn.setFont(new Font("", Font.BOLD, 14));
		signupbtn.setBounds(270, 250, 150, 40);
		jf.add(signupbtn);
		signupbtn.addActionListener(new signup());

		orlb = new JLabel("or");
		orlb.setFont(new Font("", Font.BOLD, 16));
		orlb.setForeground(Color.WHITE);
		orlb.setBounds(260, 310, 50, 30);
		jf.add(orlb);

		emaillb2 = new JLabel("Email-id");
		emaillb2.setFont(new Font("", Font.BOLD, 16));
		emaillb2.setForeground(Color.WHITE);
		emaillb2.setBounds(100, 380, 100, 30);
		jf.add(emaillb2);

		emailtf2 = new JTextField();
		emailtf2.setBounds(210, 380, 210, 30);
		jf.add(emailtf2);

		graphicalPassbtn = new JButton("By Grphical password");
		graphicalPassbtn.setFont(new Font("", Font.BOLD, 14));
		graphicalPassbtn.setBounds(100, 450, 320, 40);
		graphicalPassbtn.addActionListener(new graphic());
		jf.add(graphicalPassbtn);

		graphicloginbtn = new JButton("Login");
		graphicloginbtn.setFont(new Font("", Font.BOLD, 14));
		graphicloginbtn.setBounds(270, 530, 150, 40);
		graphicloginbtn.addActionListener(new graphicLogin());
		jf.add(graphicloginbtn);

		/* Main Panel */

		panel = new JPanel();
		panel.setBounds(700, 20, 600, 500);
		panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		panel.setBackground(Color.WHITE);
		panel.addMouseListener(new mainPanelClicked());

		// Main panel Image

		// panelbacklb = new JLabel();
		// ImageIcon panelImage = new ImageIcon(
		// (new ImageIcon("Welcome.jpg").getImage()).getScaledInstance(588, 488,
		// java.awt.Image.SCALE_SMOOTH));
		// panelbacklb.setIcon(panelImage);
		// panel.add(panelbacklb);
		// jf.add(panel);

		/* Image Box panel 1 */

		imagepanel1 = new JPanel();
		imagepanel1.setBounds(440, 80, 150, 150);
		imagepanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		imagepanel1.setBackground(Color.PINK);
		jf.add(imagepanel1);

		panelbtn1 = new JButton("Image 1");
		panelbtn1.setFont(new Font("", Font.BOLD, 12));
		panelbtn1.setBounds(600, 80, 100, 30);
		panelbtn1.addMouseListener(new subPanelClicked());
		jf.add(panelbtn1);

		/* Image Box panel 2 */

		imagepanel2 = new JPanel();
		imagepanel2.setBounds(440, 270, 150, 150);
		imagepanel2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		imagepanel2.setBackground(Color.CYAN);
		jf.add(imagepanel2);

		panelbtn2 = new JButton("Image 2");
		panelbtn2.setFont(new Font("", Font.BOLD, 12));
		panelbtn2.setBounds(600, 270, 100, 30);
		panelbtn2.addMouseListener(new subPanelClicked());
		jf.add(panelbtn2);

		/* Image Box panel 3 */

		imagepanel3 = new JPanel();
		imagepanel3.setBounds(440, 470, 150, 150);
		imagepanel3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		imagepanel3.setBackground(Color.BLUE);
		jf.add(imagepanel3);

		panelbtn3 = new JButton("Image 3");
		panelbtn3.setFont(new Font("", Font.BOLD, 12));
		panelbtn3.setBounds(600, 470, 100, 30);
		panelbtn3.addMouseListener(new subPanelClicked());
		jf.add(panelbtn3);

		/* Login Bckground Image */

		imagelb = new JLabel();
		imagelb.setBounds(0, 0, 1370, 730);
		ImageIcon img = new ImageIcon(
				((new ImageIcon("Login.jpg").getImage()).getScaledInstance(1370, 730, java.awt.Image.SCALE_SMOOTH)));
		imagelb.setIcon(img);
		jf.add(imagelb);

		jf.setVisible(true);
		jf.setSize(1370, 730);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	} // cons close here

	class mainPanelClicked implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent m) {
			if (l == 0) {
				mousepoint[0] = m.getX();
				mousepoint[1] = m.getY();
				l++;
				JOptionPane.showMessageDialog(null, mousepoint[0] + " and " + mousepoint[1]);
				JOptionPane.showMessageDialog(null, "Successfully Saved, Click on next Image button");
				return;
			}
			if (l == 1) {
				mousepoint[2] = m.getX();
				mousepoint[3] = m.getY();
				l++;
				JOptionPane.showMessageDialog(null, mousepoint[2] + " and " + mousepoint[3]);
				JOptionPane.showMessageDialog(null, "Successfully Saved, Click on next Image button");
				return;
			}
			if (l == 2) {
				mousepoint[4] = m.getX();
				mousepoint[5] = m.getY();
				JOptionPane.showMessageDialog(null, mousepoint[4] + " and " + mousepoint[5]);
				JOptionPane.showMessageDialog(null, "Successfully Saved");
				return;
			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

	}

	class subPanelClicked implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {

			if (j == 0) {
				System.out.println("Path saved at index " + j + " " + imagePath[j]);

				panelbacklb = new JLabel();
				ImageIcon img = new ImageIcon(
						(new ImageIcon(imagePath[j]).getImage()).getScaledInstance(588, 488, Image.SCALE_SMOOTH));
				panelbacklb.setIcon(img);
				panel.add(panelbacklb);
				jf.add(panel);
				jf.setVisible(true);

				j++;

				return;
			}
			if (j == 1) {
				resetPanel();

				System.out.println("Path saved at index " + j + imagePath[j]);

				panelbacklb = new JLabel();
				ImageIcon img = new ImageIcon(
						(new ImageIcon(imagePath[j]).getImage()).getScaledInstance(588, 488, Image.SCALE_SMOOTH));
				panelbacklb.setIcon(img);
				panel.add(panelbacklb);
				jf.add(panel);
				jf.setVisible(true);

				j++;
				return;
			}
			if (j == 2) {

				resetPanel();
				System.out.println("Path saved at index " + j + imagePath[j]);

				panelbacklb = new JLabel();
				ImageIcon img = new ImageIcon(
						(new ImageIcon(imagePath[j]).getImage()).getScaledInstance(588, 488, Image.SCALE_SMOOTH));
				panelbacklb.setIcon(img);
				panel.add(panelbacklb);
				jf.add(panel);
				jf.setVisible(true);
				resetPanel();
				return;
			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

	}

	class log implements ActionListener {

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent E) {
			try {

				if (emailtf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Email can't be empty");
					ppf.setText(null);
					return;

				} else if (ppf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Password can't be empty");
					ppf.setText(null);
					return;

				}

				String inputEmail = emailtf.getText();

				String inputPassword = ppf.getText();

				String query = "SELECT email,password FROM student WHERE email='" + inputEmail + "' and password='"
						+ inputPassword + "'";

				Connection con = DataBaseConnection.JAVAConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);

				if (rs.next() == true) {
					String registeredEmail = rs.getString(1);
					String registeredPassword = rs.getString(2);

					if (registeredEmail.equals(inputEmail) && registeredPassword.equals(inputPassword)) {
						JOptionPane.showMessageDialog(null, "Email And Password are correct, choose your way to login");
						System.out.println("Access granted");
					} else {
						JOptionPane.showMessageDialog(null, "Login Failed! Register your account now");
						emailtf.setText(null);
						ppf.setText(null);
						System.out.println("Login Failed! Register your account now");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Login Failed! Register your account now");
					emailtf.setText(null);
					ppf.setText(null);
					System.out.println("Login Failed! Register your account now");
				}

				st.close();
				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);
			}

		}
	}

	class graphicLogin implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String query = "SELECT mousex1,mousey1,mousex2,mousey2,mousex3,mousey3 FROM student WHERE email = '"
					+ emailtf2.getText() + "'";

			Connection con = DataBaseConnection.JAVAConnection();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);

				if (rs.next() == true) {

					int x1 = rs.getInt(1);
					int x2 = rs.getInt(2);
					int x3 = rs.getInt(3);
					int x4 = rs.getInt(4);
					int x5 = rs.getInt(5);
					int x6 = rs.getInt(6);

					System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " "
							+ rs.getInt(5) + " " + rs.getInt(6));

					if (mousepoint[0] - 5 <= x1 && x1 <= mousepoint[0] + 5) {
						System.out.println(mousepoint[0] + " check " + rs.getInt(1));
					} else {
						JOptionPane.showConfirmDialog(null, "Access Denied");
						JOptionPane.showMessageDialog(null, "Invalid Point " + mousepoint[0]);
						return;
					}
					if (mousepoint[1] - 5 <= x2 && x2 <= mousepoint[1] + 5) {
						System.out.println(mousepoint[2] + " check " + rs.getInt(2));
					} else {
						JOptionPane.showConfirmDialog(null, "Access Denied");
						JOptionPane.showMessageDialog(null, "Invalid Point " + mousepoint[1]);
						return;
					}
					if (mousepoint[2] - 5 <= x3 && x3 <= mousepoint[2] + 5) {

					} else {
						JOptionPane.showConfirmDialog(null, "Access Denied");
						JOptionPane.showMessageDialog(null, "Invalid Point " + mousepoint[2]);
						return;
					}
					if (mousepoint[3] - 5 <= x4 && x4 <= mousepoint[3] + 5) {

					} else {
						JOptionPane.showConfirmDialog(null, "Access Denied");
						JOptionPane.showMessageDialog(null, "Invalid Point " + mousepoint[3]);
						return;
					}
					if (mousepoint[4] - 5 <= x5 && x5 <= mousepoint[4] + 5) {

					} else {
						JOptionPane.showConfirmDialog(null, "Access Denied");
						JOptionPane.showMessageDialog(null, "Invalid Point " + mousepoint[4]);
						return;
					}
					if (mousepoint[5] - 5 <= x6 && x6 <= mousepoint[5] + 5) {
						new WelcomeToOasis();
					} else {
						JOptionPane.showConfirmDialog(null, "Access Denied");
						JOptionPane.showMessageDialog(null, "Invalid Point " + mousepoint[5]);
						return;
					}
				}

			} catch (SQLException f) {
				f.printStackTrace();
			}
		}
	}

	class forget implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			new ForgetPassword();

		}
	}

	class signup implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			new SignUp();

		}
	}

	public void resetPanel() {

		panel = new JPanel();
		panel.setBounds(700, 20, 600, 500);
		panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		panel.setBackground(Color.WHITE);

	}

	class graphic implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (emailtf2.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Email-id can't be empty");
				return;
			}
			String getImages = "SELECT image1,image2,image3 FROM student WHERE email='" + emailtf2.getText() + "'";

			String checkEmail = "SELECT email FROM student WHERE email = '" + emailtf2.getText() + "'";
			try {

				Connection con = DataBaseConnection.JAVAConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(checkEmail);

				if (rs.next() == true) {
					if (emailtf2.getText().equals(rs.getString(1))) {
						JOptionPane.showMessageDialog(null, "Email Verified");

						st = con.createStatement();
						rs = st.executeQuery(getImages);

						System.out.println(rs.next());

						System.out.println("hello");
						f = new File("Image" + i + ".jpg");
						output = new FileOutputStream(f);

						input = rs.getBinaryStream("image" + i);

						byte[] buffer = new byte[1024];
						while (input.read(buffer) > 0) {
							output.write(buffer);
						}
						if (i == 1) {
							imagePath[i - 1] = f.getAbsolutePath();
							img = new ImageIcon((new ImageIcon(f.getAbsolutePath()).getImage()).getScaledInstance(140,
									138, Image.SCALE_SMOOTH));
							_1panelimagelb = new JLabel();
							_1panelimagelb.setIcon(img);
							imagepanel1.add(_1panelimagelb);
							jf.add(imagepanel1);
							jf.setVisible(true);

							i++;
						}
						if (i == 2) {

							f = new File("Image" + i + ".jpg");
							output = new FileOutputStream(f);

							input = rs.getBinaryStream("image" + i);

							buffer = new byte[1024];
							while (input.read(buffer) > 0) {
								output.write(buffer);
							}

							imagePath[i - 1] = f.getAbsolutePath();
							img = new ImageIcon((new ImageIcon(f.getAbsolutePath()).getImage()).getScaledInstance(140,
									138, Image.SCALE_SMOOTH));
							_2panelimagelb = new JLabel();
							_2panelimagelb.setIcon(img);
							imagepanel2.add(_2panelimagelb);
							jf.add(imagepanel2);
							jf.setVisible(true);

							i++;
						}
						if (i == 3) {

							f = new File("Image" + i + ".jpg");
							output = new FileOutputStream(f);

							input = rs.getBinaryStream("image" + i);

							buffer = new byte[1024];
							while (input.read(buffer) > 0) {
								output.write(buffer);
							}

							imagePath[i - 1] = f.getAbsolutePath();

							img = new ImageIcon((new ImageIcon(f.getAbsolutePath()).getImage()).getScaledInstance(140,
									138, Image.SCALE_SMOOTH));
							_3panelimagelb = new JLabel();
							_3panelimagelb.setIcon(img);
							imagepanel3.add(_3panelimagelb);
							jf.setVisible(true);

							JOptionPane.showMessageDialog(null, "Done!");
							return;
						}
						con.close();
						st.close();
						rs.close();

					} else {
						JOptionPane.showMessageDialog(null, "Invalid Email-id");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Email-id");
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
		}
	}
} // end of class
