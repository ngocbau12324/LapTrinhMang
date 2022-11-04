package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Vector;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BLL.accountBLL;
import BLL.userBLL;
import Users.*;
import database.databaseHelp;
import GUI.*;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class userGUI extends JFrame {

	List<Customer> UserList = new ArrayList<Customer>();
	userBLL usrBLL = new userBLL();
	accountBLL aBLL = new accountBLL();
	databaseHelp dh = new databaseHelp();
	
	private JPanel contentPane;
	public JFrame f = new JFrame();
	private JTextField tfUserCode;
	private JTextField tfUserName;
	private JTextField tfUserNumberPhone;
	private JTextField tfUserAddress;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField tfAccountCode;
	public userGUI() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Quản lí người dùng");
		setSize(1366, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 108, 399, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lCode = new JLabel("Mã người dùng");
		lCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lCode.setForeground(new Color(0, 0, 0));
		lCode.setBounds(25, 123, 90, 28);
		panel.add(lCode);
		f.setResizable(false);
		tfUserCode = new JTextField();
		tfUserCode.setBounds(125, 126, 209, 28);
		panel.add(tfUserCode);
		tfUserCode.setColumns(10);
		
		JLabel lName = new JLabel("Tên người dùng");
		lName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lName.setForeground(new Color(0, 0, 0));
		lName.setBounds(24, 168, 101, 28);
		panel.add(lName);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(125, 171, 209, 28);
		panel.add(tfUserName);
		tfUserName.setColumns(10);
		
		JLabel lbGiaNhap = new JLabel("Địa chỉ");
		lbGiaNhap.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbGiaNhap.setForeground(new Color(0, 0, 0));
		lbGiaNhap.setBounds(25, 216, 55, 28);
		panel.add(lbGiaNhap);
		
		tfUserAddress = new JTextField();
		tfUserAddress.setBounds(125, 216, 209, 28);
		panel.add(tfUserAddress);
		tfUserAddress.setColumns(10);
		
		JLabel lNumberPhone = new JLabel("Số điện thoại");
		lNumberPhone.setForeground(new Color(0, 0, 0));
		lNumberPhone.setFont(new Font("SansSerif", Font.BOLD, 12));
		lNumberPhone.setBounds(25, 263, 90, 28);
		panel.add(lNumberPhone);
		
		tfUserNumberPhone = new JTextField();
		tfUserNumberPhone.setBounds(125, 261, 209, 28);
		panel.add(tfUserNumberPhone);
		tfUserNumberPhone.setColumns(10);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.setBounds(218, 363, 69, 28);
		panel.add(btnEdit);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBounds(320, 363, 69, 28);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Xóa");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRemoveActionPerformed(e);
			}
		});
		btnRemove.setBounds(10, 363, 69, 28);
		panel.add(btnRemove);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(113, 363, 75, 28);
		panel.add(btnReset);
		
		tfAccountCode = new JTextField();
		tfAccountCode.setColumns(10);
		tfAccountCode.setBounds(125, 71, 209, 28);
		panel.add(tfAccountCode);
		tfAccountCode.setText(String.valueOf(aBLL.getAccountCode()));
		tfAccountCode.setEnabled(false);
		
		JLabel lAccountCode = new JLabel("Mã tài khoản");
		lAccountCode.setForeground(Color.BLACK);
		lAccountCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lAccountCode.setBounds(25, 68, 90, 28);
		panel.add(lAccountCode);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 108, 961, 603);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã tài khoản");
		model.addColumn("Mã người dùng");
		model.addColumn("Tên người dùng");
		model.addColumn("Số điện thoại");
		model.addColumn("Địa chỉ");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		Panel panel1 = new Panel();
		panel1.setBackground(new Color(50, 205, 50));
		panel1.setBounds(0, 0, 1364, 111);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lbTitle = new JLabel("Danh Sách Người dùng");
		lbTitle.setForeground(Color.WHITE);
		lbTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lbTitle.setBounds(315, 6, 372, 36);
		panel1.add(lbTitle);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setBounds(1252, 12, 90, 38);
		panel1.add(btnSearch);
		
		tfFind = new JTextField();
		tfFind.setBounds(1010, 12, 243, 38);
		panel1.add(tfFind);
		tfFind.setColumns(10);
		
		JButton btnTrLi = new JButton("");
		btnTrLi.setBounds(0, 0, 50, 50);
		panel1.add(btnTrLi);
		btnTrLi.setBackground(new Color(50, 205, 50));
		btnTrLi.setIcon(new ImageIcon("Image\\return-24-48.png"));
		
		btnTrLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				if(Integer.parseInt(loginGUI.code)!=0) {
					employeeInterfaceGUI p = new employeeInterfaceGUI(loginGUI.code);
					p.f.setVisible(true);
				}
				else {
					adminGUI p = new adminGUI();
					p.f.setVisible(true);
				}
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditActionPerformed(e);
			}
		});
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnResetActionPerformed(e);
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSearchActionPerformed(e);
			}
		});
		
		f.add(contentPane);
		f.setSize(1366, 740);
		if(employeeInterfaceGUI.employeeCode!=-1) {
			btnRemove.setEnabled(false);
		}
		JLabel lblNewLabel = new JLabel("(Tìm kiếm theo tên người dùng)");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(1013, 60, 309, 29);
		panel1.add(lblNewLabel);
	}
	
	private void btnResetActionPerformed(ActionEvent e) {
		tfUserCode.setText("");
		tfUserName.setText("");
		tfUserNumberPhone.setText("");
		tfUserAddress.setText("");
		tfAccountCode.setText(String.valueOf(aBLL.getAccountCode()));
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {      
        	tfAccountCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
            tfUserCode.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfUserName.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		tfUserNumberPhone.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		tfUserAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 5)));
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfAccountCode.getText().trim().equals("") && !tfUserCode.getText().trim().equals("") && !tfUserName.getText().trim().equals("") && !tfUserNumberPhone.getText().trim().equals("") && !tfUserAddress.getText().trim().equals("")) {
			try {
				int accountId = Integer.parseInt(tfAccountCode.getText());
				int code = Integer.parseInt(tfUserCode.getText());
				String name = tfUserName.getText();
				String phone = tfUserNumberPhone.getText();
				String address = tfUserAddress.getText();
				
				Customer p = new Customer(accountId, code, name, phone,address);
				
				JOptionPane.showMessageDialog(null, usrBLL.addUser(p));
				
				displayList();
				btnResetActionPerformed(e);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Số điện thoại là số");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của người dùng");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		String UserName = tfFind.getText();
        if(UserName != null && UserName.length() > 0) {
            UserList = usrBLL.searchUserByName(UserName);
            
            if(UserList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có người dùng bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < UserList.size()) {
	    			Customer p = UserList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getAccountId(), p.getCustomerCode(), p.getCustomerName(), p.getNumberPhone(), p.getAddress()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên của người dùng để tìm kiếm");
        }
	}
	
	private void btnEditActionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfAccountCode.getText().trim().equals("") && !tfUserCode.getText().equals("") && !tfUserName.getText().equals("") && !tfUserNumberPhone.getText().equals("") && !tfUserAddress.getText().equals("")) {
				Customer p = new Customer();
				
				p.setAccountId(Integer.parseInt(tfAccountCode.getText()));
				p.setCustomerCode(Integer.parseInt(tfUserCode.getText()));
				p.setCustomerName(tfUserName.getText());
				p.setNumberPhone(tfUserNumberPhone.getText());
				p.setAddress(tfUserAddress.getText());
				
				JOptionPane.showMessageDialog(null, usrBLL.editUser(p));
				displayList();
				btnResetActionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn người dùng để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của người dùng");
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Số điện thoại phải là số");
		} 
	}
	
	private void btnRemoveActionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfUserCode.getText().equals("")) {
        	String code = tfUserCode.getText();
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa người dùng này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa người dùng này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
	                usrBLL.deleteUser(code);
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn người dùng để xóa");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		UserList = usrBLL.getAllUser();
    	int i = 0;
		while(i < UserList.size()) {
			Customer p = UserList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getAccountId(), p.getCustomerCode(), p.getCustomerName(), p.getNumberPhone(), p.getAddress()
			});
			i++;
		}
	}
}