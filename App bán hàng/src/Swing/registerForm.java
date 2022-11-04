package Swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.CallableStatement;

public class registerForm {
	JFrame f;
	JButton b, r;
	JLabel user , pass, lRePass;
	JTextField usern, passwd, txtRePass;
	public registerForm() {
		f = new JFrame("REGISTER FORM");
		f.setSize(500, 250);
		
		usern = new JTextField();
		passwd = new JPasswordField();
		txtRePass = new JPasswordField();
		
		user = new JLabel("TÀI KHOẢN : ");
		usern.setPreferredSize(new Dimension(350, 30));
		
		pass = new JLabel("MẬT KHẨU : ");
		passwd.setPreferredSize(new Dimension(350, 30));
		
		lRePass = new JLabel("NHẬP LẠI MẬT KHẨU: ");
		txtRePass.setPreferredSize(new Dimension(350, 30));
		
		f.add(user);
		f.add(usern);
		f.add(pass);
		f.add(passwd);
		f.add(lRePass);
		f.add(txtRePass);
		
		r = new JButton("Reset");
		f.add(r);
		b = new JButton("ĐĂNG KÍ");
		f.add(b);
		
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		b.addActionListener(new ActionListener() {
			
			@Override
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
	
	private void btnRegisterActionPerformed(ActionEvent e) {
		if(usern.getText().equals("") || passwd.getText().equals("") || txtRePass.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin đăng kí");
		}
		
		else if(checkSpace(usern.getText())) {
			JOptionPane.showMessageDialog(null, "Tài khoản không được chứa khoảng trắng");
		}
		
		else if(!passwd.getText().equals(txtRePass.getText())) {
			JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại phải trùng với nhau");
		}
		
		else if(passwd.getText().length()<6) {
			JOptionPane.showMessageDialog(null, "Mật khẩu phải ít nhất 6 kí tự");
		}
		
		else {
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_project?useSSL=false", "root", "");
				java.sql.CallableStatement callSt = connection.prepareCall("{insertAccount(?, ?)}");
				callSt.setString(1, usern.getText());
				callSt.setString(2, passwd.getText());
				callSt.execute();
				JOptionPane.showMessageDialog(null, "Đăng kí thành công");
				f.setVisible(false);
				loginForm lf = new loginForm();
				lf.f.setVisible(true);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}	
	}
	
	private boolean checkSpace(String user) {
		char check;
		for(int i=0; i<user.length(); i++) {
			check = user.charAt(i);
			if(Character.isSpaceChar(check)) {
				return true;
			}
		}
		return false;
	}
}
