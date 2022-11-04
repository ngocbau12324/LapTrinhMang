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
import java.sql.PreparedStatement;
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
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

import BLL.userBLL;
import Users.*;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class userGUI extends JFrame {

	List<Customer> UserList = new ArrayList<Customer>();
	userBLL usrBLL = new userBLL();
	
	private JPanel contentPane;
	private JTextField tfUserCode;
	private JTextField tfUserName;
	private JTextField tfUserNumberPhone;
	private JTextField tfUserAddress;
	private JTextField tfFind;
	private JCheckBox checkbox;
	DefaultTableModel model = new DefaultTableModel() {
		   public Class<?> getColumnClass(int column) {
		    switch (column) {
		    case 0:
		     return Integer.class;
		    case 1:
		     return String.class;
		    case 2:
		     return String.class;
		    case 3:
		     return String.class;
		    case 4:
		     return String.class;
		    case 5:
		    	 return Boolean.class;
		    default:
		     return String.class;
		    }
		   }
	 };
	private JTable table;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userGUI frame = new userGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
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
		panel.setBackground(new Color(51, 153, 102));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 108, 399, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lCode = new JLabel("Mã người dùng:");
		lCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lCode.setForeground(Color.WHITE);
		lCode.setBounds(25, 42, 90, 28);
		panel.add(lCode);
		
		tfUserCode = new JTextField();
		tfUserCode.setBounds(125, 45, 209, 28);
		panel.add(tfUserCode);
		tfUserCode.setColumns(10);
		
		JLabel lName = new JLabel("Tên người dùng:");
		lName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lName.setForeground(Color.WHITE);
		lName.setBounds(24, 87, 101, 28);
		panel.add(lName);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(125, 90, 209, 28);
		panel.add(tfUserName);
		tfUserName.setColumns(10);
		
		JLabel lbGiaNhap = new JLabel("Địa chỉ:");
		lbGiaNhap.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbGiaNhap.setForeground(Color.WHITE);
		lbGiaNhap.setBounds(25, 135, 55, 28);
		panel.add(lbGiaNhap);
		
		tfUserAddress = new JTextField();
		tfUserAddress.setBounds(125, 135, 209, 28);
		panel.add(tfUserAddress);
		tfUserAddress.setColumns(10);
		
		JLabel lNumberPhone = new JLabel("Số điện thoại:");
		lNumberPhone.setForeground(Color.WHITE);
		lNumberPhone.setFont(new Font("SansSerif", Font.BOLD, 12));
		lNumberPhone.setBounds(25, 182, 90, 28);
		panel.add(lNumberPhone);
		
		tfUserNumberPhone = new JTextField();
		tfUserNumberPhone.setBounds(125, 180, 209, 28);
		panel.add(tfUserNumberPhone);
		tfUserNumberPhone.setColumns(10);
		
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
		
		JButton btnNewButton = new JButton("test");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectCheckbox();
			}
		});
		btnNewButton.setBounds(25, 328, 89, 23);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 108, 961, 603);
		contentPane.add(scrollPane);
		
		
		checkbox= new JCheckBox();
		table = new JTable();
		table.setModel(model);

		model.addColumn("STT");
		model.addColumn("Mã người dùng");
		model.addColumn("Tên người dùng");
		model.addColumn("Địa chỉ");
		model.addColumn("Số điện thoại");
		model.addColumn("Chọn");
		table.getColumn("Chọn").setCellEditor(new DefaultCellEditor(checkbox));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
	    
		 displayList();
	
		Panel panel1 = new Panel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBounds(0, 63, 1364, 48);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lbTitle = new JLabel("Danh Sách Người dùng");
		lbTitle.setForeground(Color.WHITE);
		lbTitle.setFont(new Font("SansSerif", Font.BOLD, 26));
		lbTitle.setBounds(315, 6, 372, 36);
		panel1.add(lbTitle);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setBounds(1252, 12, 90, 28);
		panel1.add(btnSearch);
		
		tfFind = new JTextField();
		tfFind.setBounds(1010, 12, 243, 28);
		panel1.add(tfFind);
		tfFind.setColumns(10);
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
	}
	
	private void btnResetActionPerformed(ActionEvent e) {
		tfUserCode.setText("");
		tfUserName.setText("");
		tfUserNumberPhone.setText("");
		tfUserAddress.setText("");
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfUserCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfUserName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfUserNumberPhone.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		tfUserAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfUserCode.getText().trim().equals("") && !tfUserName.getText().trim().equals("") && !tfUserNumberPhone.getText().trim().equals("") && !tfUserAddress.getText().trim().equals("")) {
			try {
				String code = tfUserCode.getText();
				String name = tfUserName.getText();
				String phone = tfUserNumberPhone.getText();
				String address = tfUserAddress.getText();
				
				Customer p = new Customer(code, name, phone,address);
				
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
	    					model.getRowCount()+1, p.getCustomerCode(), p.getName(), p.getNumberPhone(), p.getAddress()
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
			if(index>=0 && !tfUserCode.getText().equals("") && !tfUserName.getText().equals("") && !tfUserNumberPhone.getText().equals("") && !tfUserAddress.getText().equals("")) {
				Customer p = new Customer();
				
				p.setCustomerCode(tfUserCode.getText());
				p.setName(tfUserName.getText());
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
//            User p = UserList.get(selectedIndex);
            
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
			model.addRow(new Object [6] );
			model.setValueAt(model.getRowCount(), i, 0); 
			model.setValueAt(p.getName(), i, 1);
			model.setValueAt(p.getNumberPhone(), i, 2);
			model.setValueAt(p.getCustomerCode(), i, 3);
			model.setValueAt(p.getAddress(), i, 4);
			model.setValueAt(false, i, 5);
			i++;
		}
		
	}
	public void SelectCheckbox() {
		model.setRowCount(0);
		UserList = usrBLL.getAllUser();
    	int i = 0;
		while(i < UserList.size()) {
			Boolean checked=Boolean.valueOf(table.getValueAt(i, 5).toString());
	          String col=table.getValueAt(i, 1).toString();
	          System.out.println(checked);
	          //DISPLAY
	          if(checked)
	          {
	            JOptionPane.showMessageDialog(null, col);
	          }
			i++;
		}
	}
}