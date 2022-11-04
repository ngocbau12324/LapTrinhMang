package Swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class loginForm {
	JFrame f;
	JLabel user,pass;
	JTextField usern,passwd;
	JButton r, b, register;
	welcome w = new welcome();
	registerForm re = new registerForm();
	public static void main(String[] args) {
		new loginForm();
	}
	
	public loginForm() {
		// TODO Auto-generated method stub
				f = new JFrame("LOGIN FORM");
				f.setSize(500, 250);
				
				usern = new JTextField();
				passwd = new JPasswordField();
				
				user = new JLabel("TÀI KHOẢN : ");
				usern.setPreferredSize(new Dimension(350, 30));
				
				pass = new JLabel("MẬT KHẨU : ");
				passwd.setPreferredSize(new Dimension(350, 30));
				
				f.add(user);
				f.add(usern);
				f.add(pass);
				f.add(passwd);
				
				r = new JButton("Reset");
				f.add(r);
				b = new JButton("ĐĂNG NHẬP");
				f.add(b);
				register = new JButton("Đăng kí");
				f.add(register);
				
				f.setLayout(new FlowLayout());
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setVisible(true);
				
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						btnLoginActionPerformed(e);
					}
				});
				
				register.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnRegisterActionPerformed(e);
					}
				});
				
				r.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						usern.setText("");
						passwd.setText("");
					}
				});
	}
	private void btnLoginActionPerformed(ActionEvent e) {
		if(usern.getText().equals("") || passwd.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin đăng nhập"); 
		}
		else {
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_project?useSSL=false", "root", "");
				
				String sql = "SELECT * FROM users WHERE USERNAME = ? AND PASSWORD = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setString(1, usern.getText());
				ps.setString(2, passwd.getText());
				
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					f.setVisible(false);
					w.welcome(usern.getText());
				}
				else {
					JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private void btnRegisterActionPerformed(ActionEvent e) {
		f.setVisible(false);
		re.f.setVisible(true);
	}
}