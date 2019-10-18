package connector;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SignUp {

	private static File f;
	private static String[] imagePath = new String[3];
	private static JTextField usertf;
	private static JPasswordField passpf;
	private static String path;
	public static int i = 1, j = 1, mousex1, mousey1, mousex2, mousey2, mousex3, mousey3;

	JPanel panel, imagepanel1, imagepanel2, imagepanel3;
	JFrame jf;
	JLabel slb, namelb, userlb, passlb, emaillb, genderlb, addlb, phonelb, signupbacklb, panelbacklb, _1panelimagelb,
			_2panelimagelb, _3panelimagelb, _1panellb, _2panellb, _3panellb;
	JTextField nametf, emailtf, addtf, phonetf, imagetf, browertf;
	JButton signupbtn, addbtn, showbtn, browerbtn;
	JComboBox<String> Gender;
	String gender[] = { "Not Selected", "Male", "Female", "Others" };
	JPanel jp;

	public SignUp() {

		jf = new JFrame("Sign up");
		jf.setLayout(null);

		slb = new JLabel("Sign up");
		slb.setFont(new Font("", Font.BOLD, 20));
		slb.setBounds(100, 20, 100, 30);
		jf.add(slb);

		namelb = new JLabel("Name");
		namelb.setFont(new Font("", Font.BOLD, 16));
		namelb.setBounds(100, 80, 100, 30);
		jf.add(namelb);

		nametf = new JTextField();
		nametf.setBounds(210, 80, 210, 30);
		jf.add(nametf);

		userlb = new JLabel("Username");
		userlb.setFont(new Font("", Font.BOLD, 16));
		userlb.setBounds(100, 130, 100, 30);
		jf.add(userlb);

		usertf = new JTextField();
		usertf.setBounds(210, 130, 210, 30);
		jf.add(usertf);

		passlb = new JLabel("Password");
		passlb.setFont(new Font("", Font.BOLD, 16));
		passlb.setBounds(100, 190, 100, 30);
		jf.add(passlb);

		passpf = new JPasswordField();
		passpf.setBounds(210, 190, 210, 30);
		jf.add(passpf);

		emaillb = new JLabel("Email ID : ");
		emaillb.setFont(new Font("", Font.BOLD, 16));
		emaillb.setBounds(100, 250, 100, 30);
		jf.add(emaillb);

		emailtf = new JTextField();
		emailtf.setBounds(210, 250, 210, 30);
		jf.add(emailtf);

		genderlb = new JLabel("Gender");
		genderlb.setFont(new Font("", Font.BOLD, 16));
		genderlb.setBounds(100, 310, 100, 30);
		jf.add(genderlb);

		Gender = new JComboBox<String>(gender);
		Gender.setBounds(210, 310, 210, 30);
		jf.add(Gender);

		addlb = new JLabel("Address");
		addlb.setFont(new Font("", Font.BOLD, 16));
		addlb.setBounds(100, 370, 100, 30);
		jf.add(addlb);

		addtf = new JTextField();
		addtf.setBounds(210, 370, 210, 30);
		jf.add(addtf);

		phonelb = new JLabel("Phone");
		phonelb.setFont(new Font("", Font.BOLD, 16));
		phonelb.setBounds(100, 440, 100, 30);
		jf.add(phonelb);

		phonetf = new JTextField();
		phonetf.setBounds(210, 440, 210, 30);
		jf.add(phonetf);

		signupbtn = new JButton("Sign up");
		signupbtn.setFont(new Font("", Font.BOLD, 14));
		signupbtn.setBounds(320, 500, 100, 30);
		jf.add(signupbtn);
		signupbtn.addActionListener(new sign());

		browerbtn = new JButton("Browser");
		browerbtn.setFont(new Font("", Font.BOLD, 14));
		browerbtn.setBounds(700, 530, 150, 50);
		jf.add(browerbtn);
		browerbtn.addActionListener(new brower());

		browertf = new JTextField();
		browertf.setBounds(880, 530, 420, 50);
		jf.add(browertf);

		addbtn = new JButton("Add Image");
		addbtn.setFont(new Font("", Font.BOLD, 14));
		addbtn.setBounds(980, 600, 150, 50);
		jf.add(addbtn);
		addbtn.addActionListener(new add());

		showbtn = new JButton("Show Image");
		showbtn.setFont(new Font("", Font.BOLD, 14));
		showbtn.setBounds(1150, 600, 150, 50);
		jf.add(showbtn);
		showbtn.addActionListener(new show());

		/* Main Panel */

		panel = new JPanel();
		panel.setBounds(700, 20, 600, 500);
		panel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		panel.setBackground(Color.WHITE);

		// Main panel Image

		panelbacklb = new JLabel();

		ImageIcon panelImage = new ImageIcon(
				(new ImageIcon("Welcome.jpg").getImage()).getScaledInstance(588, 488, java.awt.Image.SCALE_SMOOTH));
		panelbacklb.setIcon(panelImage);
		panel.add(panelbacklb);
		panel.addMouseListener(new mouse());
		jf.add(panel);

		/* Image Box panel 1 */

		imagepanel1 = new JPanel();
		imagepanel1.setBounds(440, 80, 150, 150);
		imagepanel1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		imagepanel1.setBackground(Color.PINK);
		jf.add(imagepanel1);

		_1panellb = new JLabel("Image 1");
		_1panellb.setFont(new Font("", Font.BOLD, 16));
		_1panellb.setBounds(600, 80, 100, 30);
		jf.add(_1panellb);

		/* Image Box panel 2 */

		imagepanel2 = new JPanel();
		imagepanel2.setBounds(440, 270, 150, 150);
		imagepanel2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		imagepanel2.setBackground(Color.CYAN);
		jf.add(imagepanel2);

		_2panellb = new JLabel("Image 2");
		_2panellb.setFont(new Font("", Font.BOLD, 16));
		_2panellb.setBounds(600, 270, 100, 30);
		jf.add(_2panellb);

		/* Image Box panel 3 */

		imagepanel3 = new JPanel();
		imagepanel3.setBounds(440, 470, 150, 150);
		imagepanel3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		imagepanel3.setBackground(Color.BLUE);
		jf.add(imagepanel3);

		_3panellb = new JLabel("Image 3");
		_3panellb.setFont(new Font("", Font.BOLD, 16));
		_3panellb.setBounds(600, 470, 100, 30);
		jf.add(_3panellb);

		/* SignUp Background Image */

		signupbacklb = new JLabel();
		signupbacklb.setBounds(0, 0, 1370, 730);
		ImageIcon signimg = new ImageIcon(
				(new ImageIcon("SignUp.jpg").getImage()).getScaledInstance(1370, 730, java.awt.Image.SCALE_SMOOTH));
		signupbacklb.setIcon(signimg);
		jf.add(signupbacklb);

		jf.setSize(1370, 730);
		jf.setLayout(null);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	} // Contructor Ends

	class mouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent m) {
			if (j == 1) {
				mousex1 = m.getX();
				mousey1 = m.getY();
				JOptionPane.showMessageDialog(null,
						"Location captured at x-axis = " + mousex1 + " y-axis = " + mousey1);
				j++;
				return;
			} else if (j == 2) {
				mousex2 = m.getX();
				mousey2 = m.getY();
				JOptionPane.showMessageDialog(null,
						"Location captured at x-axis = " + mousex2 + " y-axis = " + mousey2);
				j++;
				return;
			} else {
				mousex3 = m.getX();
				mousey3 = m.getY();
				JOptionPane.showMessageDialog(null,
						"Location captured at x-axis = " + mousex3 + " y-axis = " + mousey3);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {

		}

		@Override
		public void mouseExited(MouseEvent arg0) {

		}

		@Override
		public void mousePressed(MouseEvent arg0) {

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}

	}

	class add implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			if (i == 1) {
				imagePath[0] = path;
				
				System.out.println(imagePath[0]);
				
				_1panelimagelb = new JLabel();
				ImageIcon img1 = new ImageIcon(
						(new ImageIcon(path).getImage()).getScaledInstance(140, 138, java.awt.Image.SCALE_SMOOTH));
				_1panelimagelb.setIcon(img1);
				imagepanel1.add(_1panelimagelb);
				jf.add(imagepanel1);
				jf.setVisible(true);

				JOptionPane.showMessageDialog(null, "Image 1 Inserted successfully");

				browertf.setText(null);

				i++;
				return;
			}
			if (i == 2) {
				imagePath[1] = path;
				
				System.out.println(imagePath);
				
				_2panelimagelb = new JLabel();
				ImageIcon img2 = new ImageIcon(
						(new ImageIcon(path).getImage()).getScaledInstance(140, 138, java.awt.Image.SCALE_SMOOTH));
				_2panelimagelb.setIcon(img2);
				imagepanel2.add(_2panelimagelb);
				jf.add(imagepanel2);
				jf.setVisible(true);

				JOptionPane.showMessageDialog(null, "Image 2 Inserted successfully");

				browertf.setText(null);
				i++;
				return;
			}
			if (i == 3) {
				imagePath[2] = path;
				
				System.out.println(imagePath[2]);
				
				_3panelimagelb = new JLabel();
				ImageIcon img3 = new ImageIcon(
						(new ImageIcon(path).getImage()).getScaledInstance(140, 138, java.awt.Image.SCALE_SMOOTH));
				_3panelimagelb.setIcon(img3);
				imagepanel3.add(_3panelimagelb);
				jf.add(imagepanel3);
				jf.setVisible(true);

				JOptionPane.showMessageDialog(null, "Image 3 Inserted successfully");

				browertf.setText(null);

				ImageIcon panelImage = new ImageIcon((new ImageIcon("Welcome.jpg").getImage()).getScaledInstance(588,
						488, java.awt.Image.SCALE_SMOOTH));
				panelbacklb.setIcon(panelImage);
				panel.add(panelbacklb);
				jf.add(panel);
				jf.setVisible(true);

				i = 1;
			}

		}
	}

	class show implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JOptionPane.showMessageDialog(null, "Put your secret marker on the image");
			
			ImageIcon img1 = new ImageIcon(
					(new ImageIcon(path).getImage()).getScaledInstance(588, 488, java.awt.Image.SCALE_SMOOTH));
			panelbacklb.setIcon(img1);
			panel.add(panelbacklb);
			jf.add(panel);
		}

	}

	class brower implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			JFileChooser choose = new JFileChooser();
			choose.showOpenDialog(null);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*Image", ".jpg", ".jpeg", ".png");
			choose.addChoosableFileFilter(filter);
			f = choose.getSelectedFile();
			path = f.getAbsolutePath();
			browertf.setText(path);
			
			JOptionPane.showMessageDialog(null, "To view an image click on SHOW IMAGE button");
		}
	}

	class sign implements ActionListener {
		@Override
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {

			FileInputStream fis;
			String query = "INSERT INTO student(name, username, password, email, gender, address, phone,mousex1,mousey1,mousex2,mousey2,mousex3,mousey3,image1,image2,image3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {

				if (nametf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Name can't be Empty");
					return;

				} else if (usertf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Username can't be empty");
					return;

				} else if (passpf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Password can't be empty");
					return;

				} else if (emailtf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Email can't be empty");
					return;

				} else if (Gender.getSelectedItem() == "Not Selected") {
					JOptionPane.showMessageDialog(null, "Gender can't be empty");
					return;

				} else if (addtf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Address can't be empty");
					return;

				} else if (phonetf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Phone can't be empty");
					return;

				}

				Connection con = DataBaseConnection.JAVAConnection();
				PreparedStatement pst = con.prepareStatement(query);

				/* Check if username or Email was already taken */

				String checkQuery = "SELECT username,email FROM student";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(checkQuery);

				boolean flag = true;

				while (rs.next()) {

					System.out.println(rs.getString(1) + " " + rs.getString(2));

					if (usertf.getText().equals(rs.getString(1)) || emailtf.getText().equals(rs.getString(2))) {
						System.out.println("i'm in " + rs.getString(1) + " " + rs.getString(2));
						usertf.setText(null);
						emailtf.setText(null);
						JOptionPane.showMessageDialog(null, "Username or Password is already Taken");
						flag = false;
					}
				}

				if (flag) {

					con.prepareStatement(query);

					pst.setString(1, nametf.getText());
					pst.setString(2, usertf.getText());
					pst.setString(3, passpf.getText());
					pst.setString(4, emailtf.getText());
					pst.setString(5, Gender.getSelectedItem().toString());
					pst.setString(6, addtf.getText());
					pst.setString(7, phonetf.getText());
					pst.setInt(8, mousex1);
					pst.setInt(9, mousey1);
					pst.setInt(10, mousex2);
					pst.setInt(11, mousey2);
					pst.setInt(12, mousex3);
					pst.setInt(13, mousey3);

					f = new File(imagePath[0]);
					fis = new FileInputStream(f);
					pst.setBinaryStream(14, (InputStream) fis, (int) (f.length()));

					f = new File(imagePath[1]);
					fis = new FileInputStream(f);
					pst.setBinaryStream(15, (InputStream) fis, (int) (f.length()));

					f = new File(imagePath[2]);
					fis = new FileInputStream(f);
					pst.setBinaryStream(16, (InputStream) fis, (int) (f.length()));

					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "SignUp Successfully");
					new LoginPopUp();
					jf.dispose();
					rs.close();
					st.close();
					con.close();
				}

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, e2);
			}
		}

	}
}
