package GUI;

import java.awt.BorderLayout;
import DAL.*;
import BLL.*;

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

import Dungchung.Tester;
import Product.Product;
import Users.Customer;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import java.awt.ScrollPane;
import javax.swing.JToolBar;
import java.awt.Panel;

public class statisticGUI extends JFrame {
	List<Product> productList = new ArrayList<Product>();
	productBLL proBBL = new productBLL();
	List<Customer> UserList = new ArrayList<Customer>();
	userBLL usrBLL = new userBLL();
	private JPanel contentPane;
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model1 = new DefaultTableModel();
	private JTable table,table1 ;
	private JTextField tfketqua;
	public JFrame f = new JFrame();
	JLabel countKhongkhoi;
	JLabel countKhoibenh;
	JComboBox cbStatistic;
	String tk[] = {"Thống kê","Sản phẩm","Khách hàng","Doanh thu"};
	public static void main(String[] args) {
		new statisticGUI();
	}
	public statisticGUI() {
		initComponent();
	}
	/**
	 * Create the frame.
	 * @return 
	 */
	public void initComponent() {
		setTitle("Thống kê kinh doanh");
		setSize(1366, 740);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 109, 1352, 594);
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
		
		table1 = new JTable();
		table1.setModel(model1);
		model1.addColumn("STT");
		model1.addColumn("Mã người dùng");
		model1.addColumn("Tên người dùng");
		model1.addColumn("Số điện thoại");
		model1.addColumn("Địa chỉ");	

		Panel panel1 = new Panel();
		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBounds(0, 63, 1364, 47);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JLabel title = new JLabel("Thống Kê Kinh Doanh");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("SansSerif", Font.BOLD, 26));
		title.setBounds(533, 4, 350, 36);
		panel1.add(title);

		
		cbStatistic = new JComboBox(tk);
		cbStatistic.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbStatistic.setBounds(22, 10, 230, 27);
		panel1.add(cbStatistic);
		JLabel lPhantramkhoibenh = new JLabel(" ");
		lPhantramkhoibenh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lPhantramkhoibenh.setForeground(new Color(255, 255, 255));
		lPhantramkhoibenh.setBounds(256, 634, 544, 59);
		contentPane.add(lPhantramkhoibenh);
		JLabel lPhantramtuvong = new JLabel(" ");
		lPhantramtuvong.setForeground(Color.WHITE);
		lPhantramtuvong.setFont(new Font("Tahoma", Font.BOLD, 13));
		lPhantramtuvong.setBounds(832, 634, 510, 59);
		contentPane.add(lPhantramtuvong);
		countKhoibenh = new JLabel();
		countKhoibenh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		countKhoibenh.setForeground(new Color(255, 255, 255));
		countKhoibenh.setBounds(236, 634, 45, 59);
		contentPane.add(countKhoibenh);
		countKhongkhoi = new JLabel();
		countKhongkhoi.setForeground(Color.WHITE);
		countKhongkhoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		countKhongkhoi.setBounds(716, 634, 45, 59);
		contentPane.add(countKhongkhoi);
		cbStatistic.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cbStatistic.getSelectedItem()=="Sản phẩm") {
					scrollPane.setViewportView(table);
					displayListProduct();
				}
				else if(cbStatistic.getSelectedItem()=="Khách hàng") {
					scrollPane.setViewportView(table1);
					displayListUser();
				}
			}
		});
		
		JButton btnTrLi = new JButton("");
		btnTrLi.setBackground(Color.WHITE);
		btnTrLi.setIcon(new ImageIcon("Image\\return-23-48.png"));
		btnTrLi.setBounds(10, 10, 48, 48);
		contentPane.add(btnTrLi);
		
		btnTrLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				adminGUI p = new adminGUI();
				p.f.setVisible(true);
			}
		});
		f.add(contentPane);
		f.setSize(1366, 740);
		f.setVisible(true);
	}
	private void displayListProduct() {
		model.setRowCount(0);
		productList = proBBL.getAllProduct();
    	int i = 0;
		while(i < productList.size()) {
			Product p = productList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getProductCode(), p.getProductName(), p.getProducerName(), p.getSupplierName(), p.getAmount(), p.getImportPrice(), p.getPrice()
			});
			i++;
		}
		
	}
	private void displayListUser() {
		model.setRowCount(0);
		UserList = usrBLL.getAllUser();
    	int i = 0;
		while(i < UserList.size()) {
			Customer p = UserList.get(i);
			model.addRow(new Object [] {
					model.getRowCount()+1, p.getCustomerCode(), p.getName(), p.getNumberPhone(), p.getAddress()
			});
			i++;
		}
		
	}
}