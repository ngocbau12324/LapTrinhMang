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
import BLL.employeeBLL;
import DAL.accountDAL;
import Dungchung.Tester;
import Employee.*;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class employeeGUI extends JFrame {
	List<Employee> employeeList = new ArrayList<Employee>();
	employeeBLL emBLL = new employeeBLL();
	accountBLL aBLL = new accountBLL();
	
	private JPanel contentPane;
	private JTextField tfEmployeeCode;
	private JTextField tfEmployeeName;
	private JTextField tfEmployeeNumberPhone;
	private JTextField tfEmployeeAddress;
	private JTextField tfFind, tfAccountId;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField tfEmployeebBrithday;
	public JFrame f = new JFrame();
	
	public employeeGUI() {
		initComponent();
		displayList();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Quản lí sản phẩm");
		setSize(1366, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		f.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 108, 344, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lEmployeeCode = new JLabel("Mã nhân viên");
		lEmployeeCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lEmployeeCode.setForeground(new Color(0, 0, 0));
		lEmployeeCode.setBounds(10, 42, 90, 28);
		panel.add(lEmployeeCode);
		
		tfEmployeeCode = new JTextField();
		tfEmployeeCode.setBounds(110, 43, 209, 28);
		panel.add(tfEmployeeCode);
		tfEmployeeCode.setColumns(10);
		
		JLabel lEmployeeName = new JLabel("Tên nhân viên");
		lEmployeeName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lEmployeeName.setForeground(new Color(0, 0, 0));
		lEmployeeName.setBounds(10, 87, 87, 28);
		panel.add(lEmployeeName);
		
		JLabel lEmployeeAddress = new JLabel("Địa chỉ");
		lEmployeeAddress.setForeground(new Color(0, 0, 0));
		lEmployeeAddress.setFont(new Font("SansSerif", Font.BOLD, 12));
		lEmployeeAddress.setBounds(10, 131, 55, 28);
		panel.add(lEmployeeAddress);
		
		tfEmployeeName = new JTextField();
		tfEmployeeName.setBounds(110, 88, 209, 28);
		panel.add(tfEmployeeName);
		tfEmployeeName.setColumns(10);
		
		JLabel lEmployeeNumberPhone = new JLabel("Số điện thoại");
		lEmployeeNumberPhone.setFont(new Font("SansSerif", Font.BOLD, 12));
		lEmployeeNumberPhone.setForeground(new Color(0, 0, 0));
		lEmployeeNumberPhone.setBounds(10, 175, 102, 28);
		panel.add(lEmployeeNumberPhone);
		
		tfEmployeeNumberPhone = new JTextField();
		tfEmployeeNumberPhone.setBounds(110, 177, 209, 28);
		panel.add(tfEmployeeNumberPhone);
		tfEmployeeNumberPhone.setColumns(10);
		
		tfEmployeeAddress = new JTextField();
		tfEmployeeAddress.setBounds(110, 133, 209, 28);
		panel.add(tfEmployeeAddress);
		tfEmployeeAddress.setColumns(10);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(167, 333, 69, 28);
		panel.add(btnEdit);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBounds(246, 333, 69, 28);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Xóa");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRemoveActionPerformed(e);
			}
		});
		btnRemove.setBounds(10, 333, 69, 28);
		panel.add(btnRemove);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(85, 333, 75, 28);
		panel.add(btnReset);
		
		tfEmployeebBrithday = new JTextField();
		tfEmployeebBrithday.setColumns(10);
		tfEmployeebBrithday.setBounds(110, 215, 209, 28);
		panel.add(tfEmployeebBrithday);
		
		JLabel lEmployeeBirthday = new JLabel("Ngày sinh");
		lEmployeeBirthday.setForeground(new Color(0, 0, 0));
		lEmployeeBirthday.setFont(new Font("SansSerif", Font.BOLD, 12));
		lEmployeeBirthday.setBounds(10, 213, 62, 28);
		panel.add(lEmployeeBirthday);
		
		tfAccountId = new JTextField();
		tfAccountId.setColumns(10);
		tfAccountId.setBounds(110, 250, 209, 28);
		panel.add(tfAccountId);
		tfAccountId.setText(String.valueOf(aBLL.getAccountCode()));
		
		JLabel lAccountId = new JLabel("Mã tài khoản");
		lAccountId.setForeground(new Color(0, 0, 0));
		lAccountId.setFont(new Font("SansSerif", Font.BOLD, 12));
		lAccountId.setBounds(10, 250, 90, 28);
		panel.add(lAccountId);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(342, 108, 1018, 603);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã tài khoản");
		model.addColumn("Mã nhân viên");
		model.addColumn("Tên nhân viên");
		model.addColumn("Địa chỉ");
		model.addColumn("Số điện thoại");
		model.addColumn("Ngày sinh");
		
		
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
		
		JLabel lDSNCC = new JLabel("Danh Sách Nhân Viên");
		lDSNCC.setForeground(Color.WHITE);
		lDSNCC.setFont(new Font("SansSerif", Font.BOLD, 30));
		lDSNCC.setBounds(342, 4, 350, 36);
		panel1.add(lDSNCC);
		
		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setBounds(1252, 12, 90, 36);
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
				adminGUI p = new adminGUI();
				p.f.setVisible(true);
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
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnResetActionPerformed(e);
			}
		});
		f.add(contentPane);
		f.setSize(1366, 740);
		f.setVisible(true);
		tfAccountId.setEditable(false);
		JLabel lblNewLabel = new JLabel("(Tìm kiếm theo tên nhân viên)");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(1013, 60, 309, 29);
		panel1.add(lblNewLabel);
	}
	
	private void btnResetActionPerformed(ActionEvent e) {
		tfEmployeeCode.setText("");
		tfEmployeeName.setText("");
		tfEmployeeAddress.setText("");
		tfEmployeeNumberPhone.setText("");
		tfEmployeebBrithday.setText("");
		tfAccountId.setText(String.valueOf(aBLL.getAccountCode()));
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {
        	tfAccountId.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
            tfEmployeeCode.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		tfEmployeeName.setText(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		tfEmployeeAddress.setText(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		tfEmployeeNumberPhone.setText(String.valueOf(model.getValueAt(selectedIndex, 5)));
    		tfEmployeebBrithday.setText(String.valueOf(model.getValueAt(selectedIndex, 6)));
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfEmployeeCode.getText().trim().equals("") && !tfEmployeeName.getText().trim().equals("") && !tfEmployeeNumberPhone.getText().trim().equals("") && !tfEmployeeAddress.getText().trim().equals("") && !tfEmployeebBrithday.getText().trim().equals("")) {
			try {
				int accountId = Integer.parseInt(tfAccountId.getText());
				String code = tfEmployeeCode.getText();
				String name = tfEmployeeName.getText();
				String address =tfEmployeeAddress.getText();
				String phone = tfEmployeeNumberPhone.getText();
				String birth = tfEmployeebBrithday.getText();
				Tester t = new Tester();
				if(!t.day(birth)) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
					return ;
				}
				if(!t.numberPhone(phone)) {
					JOptionPane.showMessageDialog(null, "Số điện thoại phải có 10 hoặc 11 chữ số. Vui lòng nhập đúng định dạng của số điện thoại");
					return ;
				}
				Employee s = new Employee(accountId, code,name,address,phone,birth);				
				JOptionPane.showMessageDialog(null,emBLL.addEmployee(s));
				displayList();
				btnResetActionPerformed(e);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai dữ liệu. Vui lòng thử lại");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của nhân viên");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		String employeeName = tfFind.getText();
        if(employeeName != null && employeeName.length() > 0) {
            employeeList = emBLL.searchEmployeeByName(employeeName);
            
            if(employeeList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có nhân viên bạn cần tìm");
            	displayList();
            }
            
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < employeeList.size()) {
	    			Employee p = employeeList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getAccountId(), p.getEmployeeCode(), p.getEmployeeName(), p.getAddress(), p.getNumberPhone(),p.getBirthday()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhân viên cấp để tìm kiếm");
        }
	}
	
	private void btnEditActionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfEmployeeCode.getText().equals("") && !tfEmployeeName.getText().equals("") && !tfEmployeebBrithday.getText().equals("") && !tfEmployeeNumberPhone.getText().equals("") && !tfEmployeeAddress.getText().equals("") ) {
				Employee p = new Employee();
				p.setBirthday(tfEmployeebBrithday.getText());
				p.setEmployeeCode(tfEmployeeCode.getText());
				p.setEmployeeName(tfEmployeeName.getText());
				p.setAddress(tfEmployeeAddress.getText());
				p.setNumberPhone(tfEmployeeNumberPhone.getText());
				if(!Tester.day(p.getBirthday())) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không hợp lệ");
					return ;
				}
				if(!Tester.numberPhone(p.getNumberPhone())) {
					JOptionPane.showMessageDialog(null, "Số điện thoại phải có 10 hoặc 11 chữ số. Vui lòng nhập đúng định dạng của số điện thoại");
					return ;
				}
				JOptionPane.showMessageDialog(null, emBLL.editEmployee(p));
				displayList();
				btnResetActionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của nhân viên");
		}
	}
	
	private void btnRemoveActionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfEmployeeCode.getText().equals("")) {
        	String code = tfEmployeeCode.getText();
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa nhân viên này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
	                emBLL.deleteEmployee(code);
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên để xóa");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		employeeList = emBLL.getAllEmployee();
    	int i = 0;
		while(i < employeeList.size()) {
			Employee p = employeeList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getAccountId(), p.getEmployeeCode(), p.getEmployeeName(), p.getAddress(), p.getNumberPhone(),p.getBirthday()
			});
			i++;
		}
		
	}
}