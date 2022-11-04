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
import Account.*;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class accountGUI extends JFrame {

	List<Account> accountList = new ArrayList<Account>();
	accountBLL accBBL = new accountBLL();
	public JFrame f = new JFrame();
	private JPanel contentPane;
	private JTextField tfAccountName, tfId;
	private JTextField tfPassword;
	JComboBox cbPermission;
	String [] permissionList = {"admin",  "Nhân viên", "Khách hàng"};
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	
	
	public accountGUI() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Quản lí tài khoản");
		setSize(1366, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 108, 399, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lCode = new JLabel("Tên tài khoản:");
		lCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lCode.setForeground(new Color(0, 0, 0));
		lCode.setBounds(25, 42, 90, 28);
		panel.add(lCode);
		
		tfAccountName = new JTextField();
		tfAccountName.setBounds(125, 45, 209, 28);
		panel.add(tfAccountName);
		tfAccountName.setColumns(10);
		
		JLabel lName = new JLabel("Password:");
		lName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lName.setForeground(new Color(0, 0, 0));
		lName.setBounds(25, 97, 101, 28);
		panel.add(lName);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(125, 99, 209, 28);
		panel.add(tfPassword);
		tfPassword.setColumns(10);
		
		JLabel lId = new JLabel("Mã tài khoản:");
		lId.setFont(new Font("SansSerif", Font.BOLD, 12));
		lId.setForeground(new Color(0, 0, 0));
		lId.setBounds(25, 150, 101, 28);
		panel.add(lId);
		
		tfId = new JTextField();
		tfId.setBounds(125, 151, 209, 28);
		panel.add(tfId);
		tfId.setColumns(10);
		tfId.setText(String.valueOf(accBBL.getAccountCode()));
		tfId.setEditable(false);
		
		JLabel lPermission = new JLabel("Phân quyền tài khoản:");
		lPermission.setFont(new Font("SansSerif", Font.BOLD, 12));
		lPermission.setForeground(new Color(0, 0, 0));
		lPermission.setBounds(25, 200, 101, 28);
		panel.add(lPermission);
		
		cbPermission = new JComboBox(permissionList);
		cbPermission.setBounds(125, 201, 209, 28);
		panel.add(cbPermission);
		
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(218, 282, 69, 28);
		panel.add(btnEdit);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBounds(320, 282, 69, 28);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Xóa");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRemoveActionPerformed(e);
			}
		});
		btnRemove.setBounds(10, 282, 69, 28);
		panel.add(btnRemove);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(113, 282, 75, 28);
		panel.add(btnReset);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 108, 961, 603);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã tài khoản");
		model.addColumn("Tên tài khoản");
		model.addColumn("Mật khẩu");
		model.addColumn("Quyền của tài khoản");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				jTableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		Panel panel1 = new Panel();
		panel1.setBackground(new Color(50, 205, 50));
		panel1.setBounds(0, 0, 1364, 111);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lbTitle = new JLabel("Danh Sách Tài Khoản");
		lbTitle.setForeground(Color.WHITE);
		lbTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
		lbTitle.setBounds(315, 6, 372, 57);
		panel1.add(lbTitle);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(1252, 12, 90, 38);
		panel1.add(btnSearch);
		
		tfFind = new JTextField();
		tfFind.setBounds(934, 12, 319, 38);
		panel1.add(tfFind);
		tfFind.setColumns(10);
		JButton btnTrLi = new JButton("");
		btnTrLi.setBounds(10, 0, 50, 50);
		panel1.add(btnTrLi);
		btnTrLi.setBackground(new Color(50, 205, 50));
		btnTrLi.setIcon(new ImageIcon("Image\\return-24-48.png"));
		
		btnTrLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				if(employeeInterfaceGUI.employeeCode!=-1) {
					employeeInterfaceGUI p = new employeeInterfaceGUI(loginGUI.code);
					p.f.setVisible(true);
				}
				else {
					adminGUI p = new adminGUI();
					p.f.setVisible(true);
				}
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditActionPerformed(e);
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTableMouseClicked(e);
			}
		});
		if(employeeInterfaceGUI.employeeCode!=-1) {
			// bỏ tài khoản nhân viên và tài khoản admin ra khỏi mảng hiển thị chỉ hiện tài khoản khách hàng
			btnRemove.setEnabled(false);
			cbPermission.setSelectedItem("Khách hàng");
			cbPermission.setEnabled(false);
		}
		f.add(contentPane);
		f.setSize(1366, 740);
		f.setResizable(false);
		JLabel lblNewLabel = new JLabel("(Tìm kiếm theo mã tài khoản)");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(1013, 60, 309, 29);
		panel1.add(lblNewLabel);
 	}
	
	private void btnResetActionPerformed(ActionEvent e) {
		tfAccountName.setText("");
		tfPassword.setText("");
		tfId.setText(String.valueOf(accBBL.getAccountCode()));
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {    
        	tfId.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfAccountName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfPassword.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfAccountName.getText().trim().equals("") && !tfPassword.getText().trim().equals("")) {
			try {
				// id và phân quyền chưa thêm
				int id = Integer.parseInt(tfId.getText().toString());
				String name = tfAccountName.getText();
				String password = tfPassword.getText();
				String permission = cbPermission.getSelectedItem().toString();
				
				Account p = new Account(id, name,password, permission);
				
				JOptionPane.showMessageDialog(null, accBBL.addAccount(p));
				
				displayList();
				btnResetActionPerformed(e);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Giá bán hoặc giá nhập hoặc số lượng phải là số");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của tài khoản");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		int id = Integer.parseInt(tfFind.getText());
        if(id >= 0) {
            accountList = accBBL.searchAccountByCode(id);
            
            if(accountList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có tài khoản bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	            while(i < accountList.size()) {
	    			Account p = accountList.get(i);
	    			if(employeeInterfaceGUI.employeeCode!=-1) {
	    				if(p.getPermission().equals("Nhân viên") || p.getPermission().equals("admin")) {
	    					i++;
	    					continue;
	    				}
	    			}
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getId(), p.getAccountName(), p.getPassword(), p.getPermission()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập mã của tài khoản để tìm kiếm");
        }
	}
	
	private void btnEditActionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfAccountName.getText().equals("") && !tfPassword.getText().equals("") && !tfId.getText().trim().equals("")) {
				Account p = new Account();
				
				p.setId(Integer.parseInt(tfId.getText()));
				p.setAccountName(tfAccountName.getText());
				p.setPassword(tfPassword.getText());
				p.setPermission(cbPermission.getSelectedItem().toString());
				
				JOptionPane.showMessageDialog(null, accBBL.editAccount(p));
				displayList();
				btnResetActionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của tài khoản");
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Giá bán hoặc giá nhập hoặc số lượng phải là số");
		} 
	}
	
	private void btnRemoveActionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfAccountName.getText().equals("")) {
        	int code = Integer.parseInt(tfId.getText());
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tài khoản này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa tài khoản này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
	                accBBL.deleteAccount(code);
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn tài khoản để xóa");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		accountList = accBBL.getAllAccount();
    	int i = 0;
		while(i < accountList.size()) {
			Account p = accountList.get(i);
			if(employeeInterfaceGUI.employeeCode!=-1) {
				if(p.getPermission().equals("Nhân viên") || p.getPermission().equals("admin")) {
					i++;
					continue;
				}
			}
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getId(), p.getAccountName(), p.getPassword(), p.getPermission()
			});
			i++;
		}
		
	}
}