package Swing;

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


import Product.*;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class productManager extends JFrame {

	List<Product> productList = new ArrayList<Product>();
	productModify pm = new productModify();
	private JPanel contentPane;
	private JTextField tfCode;
	private JTextField tfProductName;
	private JTextField tfImportPrice;
	private JTextField tfPrice;
	private JTextField tfAmount;
	private JTextField tfFind;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	JComboBox cbProducer;
	String producerList[] = {"Xiaomi", "Iphone", "Realme"};
	JComboBox  cbSupplier;
	List<String> supplierList = pm.getSupplierList();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productManager frame = new productManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public productManager() {
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 102));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, null, null));
		panel.setBounds(0, 108, 315, 603);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lCode = new JLabel("Mã SP:");
		lCode.setFont(new Font("SansSerif", Font.BOLD, 12));
		lCode.setForeground(Color.WHITE);
		lCode.setBounds(25, 42, 44, 28);
		panel.add(lCode);
		
		tfCode = new JTextField();
		tfCode.setBounds(85, 42, 209, 28);
		panel.add(tfCode);
		tfCode.setColumns(10);
		
		JLabel lProductName = new JLabel("Tên SP:");
		lProductName.setFont(new Font("SansSerif", Font.BOLD, 12));
		lProductName.setForeground(Color.WHITE);
		lProductName.setBounds(24, 87, 43, 28);
		panel.add(lProductName);
		
		JLabel lProducer = new JLabel("Hãng:");
		lProducer.setForeground(Color.WHITE);
		lProducer.setFont(new Font("SansSerif", Font.BOLD, 12));
		lProducer.setBounds(6, 132, 69, 28);
		panel.add(lProducer);
		
		tfProductName = new JTextField();
		tfProductName.setBounds(85, 87, 209, 28);
		panel.add(tfProductName);
		tfProductName.setColumns(10);
		
		cbProducer = new JComboBox(producerList);
		cbProducer.setBounds(85, 132, 209, 28);
		panel.add(cbProducer);
		
		JLabel lbGiaNhap = new JLabel("Giá nhập:");
		lbGiaNhap.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbGiaNhap.setForeground(Color.WHITE);
		lbGiaNhap.setBounds(12, 177, 55, 28);
		panel.add(lbGiaNhap);
		
		tfImportPrice = new JTextField();
		tfImportPrice.setBounds(85, 177, 209, 28);
		panel.add(tfImportPrice);
		tfImportPrice.setColumns(10);
		
		JLabel lPrice = new JLabel("Giá bán:");
		lPrice.setForeground(Color.WHITE);
		lPrice.setFont(new Font("SansSerif", Font.BOLD, 12));
		lPrice.setBounds(16, 222, 55, 28);
		panel.add(lPrice);
		
		JLabel lSupplier = new JLabel("Nhà cung cấp:");
		lSupplier.setFont(new Font("SansSerif", Font.BOLD, 12));
		lSupplier.setForeground(Color.WHITE);
		lSupplier.setBackground(Color.BLACK);
		lSupplier.setBounds(15, 267, 55, 28);
		panel.add(lSupplier);
		
		JLabel lAmount = new JLabel("Số lượng:");
		lAmount.setFont(new Font("SansSerif", Font.BOLD, 12));
		lAmount.setForeground(Color.WHITE);
		lAmount.setBackground(Color.BLACK);
		lAmount.setBounds(15, 312, 55, 28);
		panel.add(lAmount);
		
		JLabel lbGhiChu = new JLabel("Ghi chú:");
		lbGhiChu.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbGhiChu.setForeground(Color.WHITE);
		lbGhiChu.setBounds(18, 357, 55, 28);
		panel.add(lbGhiChu);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(85, 222, 209, 28);
		panel.add(tfPrice);
		tfPrice.setColumns(10);
		
		cbSupplier = new JComboBox(supplierList.toArray());
		cbSupplier.setBounds(85, 267, 209, 28);
		panel.add(cbSupplier);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(85, 312, 209, 28);
		panel.add(tfAmount);
		tfAmount.setColumns(10);
		
		JButton btnEdit = new JButton("Sửa");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setBounds(169, 544, 69, 28);
		panel.add(btnEdit);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnAddActionPerformed(e);
			}
		});
		btnAdd.setBounds(243, 544, 69, 28);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Xóa");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRemoveActionPerformed(e);
			}
		});
		btnRemove.setBounds(6, 544, 69, 28);
		panel.add(btnRemove);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(85, 544, 75, 28);
		panel.add(btnReset);
		
//		JLabel lbTrangThai = new JLabel("Tr\u1EA1ng th\u00E1i:");
//		lbTrangThai.setFont(new Font("SansSerif", Font.BOLD, 12));
//		lbTrangThai.setForeground(Color.WHITE);
//		lbTrangThai.setBounds(14, 503, 75, 16);
//		panel.add(lbTrangThai);
//		
//		JRadioButton rdHien = new JRadioButton("Hi\u1EC7n");
//		rdHien.setBackground(new Color(51, 153, 102));
//		rdHien.setFont(new Font("SansSerif", Font.BOLD, 12));
//		rdHien.setForeground(Color.WHITE);
//		rdHien.setBounds(114, 502, 60, 18);
//		panel.add(rdHien);
//		
//		JRadioButton rdAn = new JRadioButton("\u1EA8n");
//		rdAn.setBackground(new Color(51, 153, 102));
//		rdAn.setFont(new Font("SansSerif", Font.BOLD, 12));
//		rdAn.setForeground(Color.WHITE);
//		rdAn.setBounds(214, 502, 44, 18);
//		panel.add(rdAn);
		
		TextArea txtGhiChu = new TextArea();
		txtGhiChu.setBounds(85, 357, 209, 126);
		panel.add(txtGhiChu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(313, 108, 1047, 603);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		model.addColumn("STT");
		model.addColumn("Mã sản phẩm");
		model.addColumn("Tên sản phẩm");
		model.addColumn("Hãng");
		model.addColumn("Nhà cung cấp");
		model.addColumn("Số Lượng");
		model.addColumn("Giá nhập");
		model.addColumn("Giá bán");
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jTableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		
		Panel panel1 = new Panel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBounds(0, 63, 1364, 48);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel lbTitle = new JLabel("Danh Sách Sản Phẩm");
		lbTitle.setForeground(Color.WHITE);
		lbTitle.setFont(new Font("SansSerif", Font.BOLD, 26));
		lbTitle.setBounds(315, 6, 280, 36);
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
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnResetActionPerformed(e);
			}
		});
	}
	
	private void btnResetActionPerformed(ActionEvent e) {
		tfCode.setText("");
		tfProductName.setText("");
		cbProducer.setSelectedIndex(0);
		tfImportPrice.setText("");
		tfPrice.setText("");
		tfAmount.setText("");
		cbSupplier.setSelectedIndex(0);
	}
	
	private void jTableMouseClicked(MouseEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0) {            
            tfCode.setText(String.valueOf(model.getValueAt(selectedIndex, 1)));
    		tfProductName.setText(String.valueOf(model.getValueAt(selectedIndex, 2)));
    		cbProducer.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 3)));
    		cbSupplier.setSelectedItem(String.valueOf(model.getValueAt(selectedIndex, 4)));
    		tfAmount.setText(String.valueOf(model.getValueAt(selectedIndex, 5)));
    		tfImportPrice.setText(String.valueOf(model.getValueAt(selectedIndex, 6)));
    		tfPrice.setText(String.valueOf(model.getValueAt(selectedIndex, 7)));
        }
	}
	
	private void btnAddActionPerformed(ActionEvent e) {
		if(!tfCode.getText().equals("") && !tfProductName.getText().equals("") && !tfAmount.getText().equals("") && !tfImportPrice.getText().equals("") && !tfPrice.getText().equals("")) {
			try {
				String code = tfCode.getText();
				String name = tfProductName.getText();
				String producer = cbProducer.getSelectedItem().toString();
				String supplier = cbSupplier.getSelectedItem().toString();
				int amount = Integer.parseInt(tfAmount.getText());
				int importPrice = Integer.parseInt(tfImportPrice.getText());
				int price = Integer.parseInt(tfPrice.getText());
				
				Product p = new Product(code, name, producer, supplier, amount, importPrice, price);
				pm.insert(p);
				displayList();
				btnResetActionPerformed(e);
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Giá bán hoặc giá nhập hoặc số lượng phải là số");
			} 
		}
		else {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của sản phẩm");
		}
	}
	
	private void btnSearchActionPerformed(ActionEvent e) {
		String productName = tfFind.getText();
        if(productName != null && productName.length() > 0) {
            productList = pm.findByFullName(productName);
            
            if(productList.size()==0) {
            	JOptionPane.showMessageDialog(null, "Không có sản phẩm bạn cần tìm");
            	displayList();
            }
            else {
	            model.setRowCount(0);
	            int i = 0;
	    		while(i < productList.size()) {
	    			Product p = productList.get(i);
	    			model.addRow(new Object [] {
	    					model.getRowCount()+1, p.getProductCode(), p.getProductName(), p.getProducerName(), p.getSupplierName(), p.getAmount(), p.getImportPrice(), p.getPrice()
	    			});
	    			i++;
	    		}
            }
            
        } else {
        	JOptionPane.showMessageDialog(null, "Vui lòng nhập tên của sản phẩm để tìm kiếm");
        }
	}
	
	private void btnEditActionPerformed(ActionEvent e) {
		try {
			int index = table.getSelectedRow();
			if(index>=0 && !tfCode.getText().equals("") && !tfProductName.getText().equals("") && !tfImportPrice.getText().equals("") && !tfPrice.getText().equals("") && !tfAmount.getText().equals("")) {
				Product p = new Product();
				
				p.setProductCode(tfCode.getText());
				p.setProductName(tfProductName.getText());
				p.setProducerName(cbProducer.getSelectedItem().toString());
				p.setSupplierName(cbSupplier.getSelectedItem().toString());
				p.setAmount(Integer.parseInt(tfAmount.getText()));
				p.setImportPrice(Integer.parseInt(tfImportPrice.getText()));
				p.setPrice(Integer.parseInt(tfPrice.getText()));
				
				pm.update(p);
				displayList();
				btnResetActionPerformed(e);
			}
			else {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để sửa");
			}
			
		}catch(InputMismatchException ex) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin của sản phẩm");
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Giá bán hoặc giá nhập hoặc số lượng phải là số");
		} 
	}
	
	private void btnRemoveActionPerformed(ActionEvent e) {
		int selectedIndex = table.getSelectedRow();
        if(selectedIndex >= 0 && !tfCode.getText().equals("")) {
        	String code = tfCode.getText();
//            Product p = productList.get(selectedIndex);
            
            int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sản phẩm này không?", "Question", JOptionPane.YES_NO_OPTION);
            
            if(option == JOptionPane.YES_OPTION) {
            	int sure = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa sản phẩm này không?", "Question", JOptionPane.YES_NO_OPTION);
            	if(sure == JOptionPane.YES_OPTION) {
	                pm.delete(code);
	                displayList();
	                btnResetActionPerformed(e);
            	}
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm để xóa");
        }
	}
	
	private void displayList() {
		model.setRowCount(0);
		productList = pm.findAll();
    	int i = 0;
		while(i < productList.size()) {
			Product p = productList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getProductCode(), p.getProductName(), p.getProducerName(), p.getSupplierName(), p.getAmount(), p.getImportPrice(), p.getPrice()
			});
			i++;
		}
		
	}
}