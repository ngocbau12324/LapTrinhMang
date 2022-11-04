package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import GUI.loginGUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class registrationGUI extends JFrame {
	public JFrame f=new JFrame();
	private JPanel contentPane;
	private JTextField tfAccountName;
	private JPasswordField tfPass;
	private JPasswordField tfPass_1;
	private JTextField tfNumberPhone;
	private JTextField tfAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new registrationGUI();
	}

	/**
	 * Create the frame.
	 */
	public registrationGUI() {
		setTitle("\u0110\u0103ng k\u00FD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(370, 150, 727, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(371, 21, 97, 25);
		contentPane.add(lblNewLabel);
		
		tfAccountName = new JTextField();
		tfAccountName.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		}); 
		tfAccountName.setBounds(371, 46, 330, 31);
		contentPane.add(tfAccountName);
		tfAccountName.setColumns(10);
		
		
		
		
		
		tfPass = new JPasswordField();
		tfPass.setColumns(10);
		tfPass.setBounds(371, 113, 330, 31);
		contentPane.add(tfPass);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u:");
		lblMtKhu.setForeground(Color.WHITE);
		lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMtKhu.setBounds(371, 88, 67, 25);
		contentPane.add(lblMtKhu);
		
		tfPass_1 = new JPasswordField();
		tfPass_1.setColumns(10);
		tfPass_1.setBounds(371, 188, 330, 31);
		contentPane.add(tfPass_1);
		
		JLabel lblNhpLiMt = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u:");
		lblNhpLiMt.setForeground(Color.WHITE);
		lblNhpLiMt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNhpLiMt.setBounds(371, 163, 119, 25);
		contentPane.add(lblNhpLiMt);
		
		tfNumberPhone = new JTextField();
		tfNumberPhone.setColumns(10);
		tfNumberPhone.setBounds(371, 254, 330, 31);
		contentPane.add(tfNumberPhone);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSinThoi.setForeground(Color.WHITE);
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSinThoi.setBounds(371, 229, 91, 25);
		contentPane.add(lblSinThoi);
		
		JButton btnNewButton = new JButton("\u0110\u0103ng k\u00FD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfAccountName.getText().equals("") || tfPass.getPassword().equals("") ||  tfPass_1.getPassword().equals("")|| tfNumberPhone.getText().equals("")|| tfAddress.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin đăng kí");
				}
				
				else if(checkSpace(tfAccountName.getText())) {
					JOptionPane.showMessageDialog(null, "Tài khoản không được chứa khoảng trắng");
				}
				
				else if(!tfPass.getPassword().equals(tfPass_1.getPassword())) {
					JOptionPane.showMessageDialog(null, "Mật khẩu nhập lại phải trùng với nhau");
				}
				
				else if(tfPass.getPassword().length<6) {
					JOptionPane.showMessageDialog(null, "Mật khẩu phải ít nhất 6 kí tự");
				}
				
				else {
					try {
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_project?useSSL=false", "root", "");
						String sql="insert into custumer(CUSTUMERCODE,ACCOUNTNAME,PASSWORD,NUMBER_PHONE,ADDRESS) values(?,?,?,?,?)";
						PreparedStatement statement = connection.prepareCall(sql);
						
//						statement.setString(1, ); mã người dùng
						statement.setString(2, tfAccountName.getText());
						statement.setString(3, tfPass.getPassword().toString());
						statement.setString(4, tfNumberPhone.getText());
						statement.setString(5, tfAddress.getText());
						JOptionPane.showMessageDialog(null, "Đăng kí thành công");
						f.setVisible(false);
						loginGUI l = new loginGUI();
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
				
			}
		});
		
		
		
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(371, 388, 330, 39);
		contentPane.add(btnNewButton);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(371, 321, 330, 31);
		contentPane.add(tfAddress);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblaCh.setForeground(Color.WHITE);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblaCh.setBounds(371, 296, 46, 25);
		contentPane.add(lblaCh);
		
		
		JButton btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginGUI login=new loginGUI();
				f.setVisible(false);
			}
		});
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDangNhap.setBackground(new Color(30, 144, 255));
		btnDangNhap.setBounds(371, 438, 330, 39);
		contentPane.add(btnDangNhap);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 361, 508);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\HP\\OneDrive\\M\u00E1y t\u00EDnh\\https-hypebeast.com-image-2020-11-apple-iphone-12-pro-max-mini-homepod-preorder-friday-november-6_4.jpg"));
		lblNewLabel_3.setBounds(-335, 0, 696, 508);
		panel.add(lblNewLabel_3);
		f.add(contentPane);
		f.setBounds(370, 150, 727, 547);
		f.setVisible(true);
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
