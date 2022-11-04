package Swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.*;
import javax.swing.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Account.Account;
import database.databaseHelp;

public class Register_Form extends javax.swing.JFrame {

	private Container c;
	private JLabel title;
	private JLabel name;
	private JTextField tName;
	private JLabel numberPhone;
	private JTextField tNumberPhone;
	private JLabel gender;
	private JRadioButton male;
	private JRadioButton female;
	private ButtonGroup genderButton;
	private JLabel birthday;
	private JComboBox date;
	private JComboBox month;
	private JComboBox year;
	private JLabel password;
	private JPasswordField tPassword;
	private JLabel address, accountName;
	private JTextField tAddress, tAccountName;
	private JCheckBox term;
	private JButton btnSignUp;
	private JButton reset;

	private String ngày[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
			"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
	private String tháng[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	private String năm[] = { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
			"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018",
			"2019", "2020", "2021" };

	// constructor, to initialize the components
	// with default values.
	public Register_Form() {
		setTitle("ĐĂNG KÍ");
		setBounds(300, 90, 900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("ĐĂNG KÍ");
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		title.setSize(300, 30);
		title.setLocation(300, 30);
		c.add(title);

		name = new JLabel("TÊN");
		name.setFont(new Font("Arial", Font.PLAIN, 20));
		name.setSize(100, 20);
		name.setLocation(100, 100);
		c.add(name);

		tName = new JTextField();
		tName.setFont(new Font("Arial", Font.PLAIN, 15));
		tName.setSize(190, 20);
		tName.setLocation(200, 100);
		c.add(tName);

		numberPhone = new JLabel("SĐT");
		numberPhone.setFont(new Font("Arial", Font.PLAIN, 20));
		numberPhone.setSize(100, 20);
		numberPhone.setLocation(100, 150);
		c.add(numberPhone);

		tNumberPhone = new JTextField();
		tNumberPhone.setFont(new Font("Arial", Font.PLAIN, 15));
		tNumberPhone.setSize(150, 20);
		tNumberPhone.setLocation(200, 150);
		c.add(tNumberPhone);

		gender = new JLabel("GIỚI TÍNH");
		gender.setFont(new Font("Arial", Font.PLAIN, 20));
		gender.setSize(100, 20);
		gender.setLocation(100, 200);
		c.add(gender);

		male = new JRadioButton("Nam");
		male.setFont(new Font("Arial", Font.PLAIN, 15));
		male.setSelected(true);
		male.setSize(75, 20);
		male.setLocation(200, 200);
		c.add(male);

		female = new JRadioButton("Nữ");
		female.setFont(new Font("Arial", Font.PLAIN, 15));
		female.setSelected(false);
		female.setSize(80, 20);
		female.setLocation(275, 200);
		c.add(female);

		genderButton = new ButtonGroup();
		genderButton.add(male);
		genderButton.add(female);

		birthday = new JLabel("SN");
		birthday.setFont(new Font("Arial", Font.PLAIN, 20));
		birthday.setSize(100, 20);
		birthday.setLocation(100, 250);
		c.add(birthday);

		date = new JComboBox(ngày);
		date.setFont(new Font("Arial", Font.PLAIN, 15));
		date.setSize(50, 20);
		date.setLocation(200, 250);
		c.add(date);

		month = new JComboBox(tháng);
		month.setFont(new Font("Arial", Font.PLAIN, 15));
		month.setSize(60, 20);
		month.setLocation(250, 250);
		c.add(month);

		year = new JComboBox(năm);
		year.setFont(new Font("Arial", Font.PLAIN, 15));
		year.setSize(60, 20);
		year.setLocation(320, 250);
		c.add(year);

		accountName = new JLabel("Acount Name");
		accountName.setFont(new Font("Arial", Font.PLAIN, 20));
		accountName.setSize(100, 20);
		accountName.setLocation(100, 300);
		c.add(accountName);

		tAccountName = new JTextField();
		tAccountName.setFont(new Font("Arial", Font.PLAIN, 15));
		tAccountName.setSize(150, 20);
		tAccountName.setLocation(200, 300);
		c.add(tAccountName);

		password = new JLabel("PASS");
		password.setFont(new Font("Arial", Font.PLAIN, 20));
		password.setSize(100, 20);
		password.setLocation(100, 350);
		c.add(password);

		tPassword = new JPasswordField();
		tPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		tPassword.setSize(150, 20);
		tPassword.setLocation(200, 350);
		c.add(tPassword);

		address = new JLabel("Address");
		address.setFont(new Font("Arial", Font.PLAIN, 20));
		address.setSize(100, 20);
		address.setLocation(100, 400);
		c.add(address);

		tAddress = new JTextField();
		tAddress.setFont(new Font("Arial", Font.PLAIN, 15));
		tAddress.setSize(150, 20);
		tAddress.setLocation(200, 400);
		c.add(tAddress);

		term = new JCheckBox("Đồng ý với các điều khoản và điều kiện.");
		term.setFont(new Font("Arial", Font.PLAIN, 15));
		term.setSize(250, 20);
		term.setLocation(150, 450);
		c.add(term);

		JButton btnSignUp = new JButton("ĐĂNG KÍ");
		btnSignUp.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSignUp.setSize(100, 20);
		btnSignUp.setLocation(150, 500);
		// event
		btnSignUp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSignUpActionPerformed(evt);
			}
		});
		c.add(btnSignUp);

		reset = new JButton("Reset");
		reset.setFont(new Font("Arial", Font.PLAIN, 15));
		reset.setSize(100, 20);
		reset.setLocation(270, 500);
		// event
		reset.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnResetActionPerformed(evt);
			}
		});
		c.add(reset);

		setVisible(true);
	}

	public void btnSignUpActionPerformed(ActionEvent e) {
		if (term.isSelected()) {

			// lấy dữ liệu từ trong form ra
			String id = "1";
			String fullName = tName.getText().toString();
			String numberPhone = tNumberPhone.getText().toString();
			String gender = null;
			if (male.isSelected()) {
				gender = "nam";
			} else {
				gender = "nữ";
			}

			String birthday = "2000/1/1";

			String accountName = tAccountName.getText().toString();

			String password = tPassword.getPassword().toString();

			String address = tAddress.getText().toString();

			// thêm dữ liệu vào database
			Connection connect = null;
			PreparedStatement statement = null;

			try {
				// kết nối tới database
				connect = (Connection) DriverManager
						.getConnection("jdbc:mysql://localhost:3306/store_project?useSSL=false", "root", "");

				// thực thi câu lệnh sql
				String sql = "insert into user_account(ID, NUMBERPHONE, GENDER, BIRTHDAY, FULLNAME, ADDRESS, ACCOUNT_NAME, PASSWORD)"
						+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
				statement = (PreparedStatement) connect.prepareStatement(sql);

				statement.setString(1, id);
				statement.setString(2, numberPhone);
				statement.setString(3, gender);
				statement.setString(4, birthday);
				statement.setString(5, fullName);
				statement.setString(6, address);
				statement.setString(7, accountName);
				statement.setString(8, password);

				statement.execute();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if (connect != null) {
					try {
						connect.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			// thông báo thêm thành công
			JOptionPane.showMessageDialog(this, "Đăng kí thành công");
		}
		else {
			JOptionPane.showMessageDialog(this, "Bạn chưa đồng ý với điều khoản của chúng tôi");
		}
	}

	public void btnResetActionPerformed(ActionEvent e) {
		String def = "";
		tName.setText(def);
		tNumberPhone.setText(def);
		term.setSelected(false);
		date.setSelectedIndex(0);
		month.setSelectedIndex(0);
		year.setSelectedIndex(0);
		tAccountName.setText(def);
		tPassword.setText(def);
		tAddress.setText(def);
	}

	public void insertIntoDatabase(Account accounts) {
		databaseHelp connect = new databaseHelp();

		try {
			connect.connectDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connect.closeConnect();
		}

	}
}