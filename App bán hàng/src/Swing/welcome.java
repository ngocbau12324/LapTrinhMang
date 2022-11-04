package Swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class welcome {
//	public static void main(String[] args) {
//		new welcome();
//	}
	JButton logOut;
	JFrame w;
	public void welcome(String username) {
		// TODO Auto-generated method stub
			w = new JFrame("WELCOME");
			logOut = new JButton("Đăng xuất");
			w.setSize(500, 250);
			JLabel l = new JLabel("Hello: " + username);
			w.add(l);
			w.add(logOut);
			
			w.setLayout(new FlowLayout());
			w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			w.setVisible(true);
			
			logOut.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					logOutActionPerformed(e);
				}
			});
	}
	
	private void logOutActionPerformed(ActionEvent e) {
		loginForm l = new loginForm();
		JOptionPane.showMessageDialog(null, "Đăng xuất thành công");
		w.setVisible(false);
		l.f.setVisible(true);
	}

}
