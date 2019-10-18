package connector;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeToOasis {
	JFrame jf;
	JLabel Oasislb;
	JPanel jp;

	JLabel imagelb;
	JButton loginbtn, signupbtn;

	public WelcomeToOasis() {

		jf = new JFrame("Welcome to OASIS");
		jf.setLayout(null);

		imagelb = new JLabel();
		imagelb.setBounds(0, 0, 1370, 730);
		ImageIcon img = new ImageIcon(
				((new ImageIcon("Oasis.jpg")).getImage()).getScaledInstance(1370, 730, java.awt.Image.SCALE_SMOOTH));
		imagelb.setIcon(img);
		jf.add(imagelb);

		JPanel jp = new JPanel();
		jp.setBounds(450, 100, 600, 600);
		jp.setBackground(Color.BLACK);
		jf.add(jp);

		jf.setResizable(false);
		jf.setVisible(true);
		jf.setSize(1360, 720);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
