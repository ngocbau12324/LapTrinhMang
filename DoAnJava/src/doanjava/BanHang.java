/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGOC BAU
 */
public class BanHang extends javax.swing.JFrame {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    DefaultTableModel model;
    DefaultTableModel model1;
    int stt = 0, tong_tien = 0, con_lai = 0, giam_gia = 0;
    ArrayList<giohangDTO> giohang = new ArrayList<giohangDTO>();

    /**
     * Creates new form BanHang
     */
    public BanHang() throws ClassNotFoundException, SQLException, ParseException {
        initComponents();
        model = (DefaultTableModel) tbsanpham.getModel();
        model1 = (DefaultTableModel) tbcthoadon.getModel();
        hienThiSanPham();
        taoIdHd();
        toDay();
        showCombDataCbkh();
        showCombDataCbkm();
        showCombDataCbnv();
        showCombDataCbtl();
        txtgiamgia.setText("0 đ");
        txtconlai.setText("0 đ");
        txttong_tien.setText(formatter.format(tong_tien) + " đ");
        txttongtien.setText(formatter.format(tong_tien) + " đ");
    }

    void hienThiSanPham() throws ClassNotFoundException, SQLException, ParseException {
        SanPhamBUS sanPhamBUS = new SanPhamBUS();
        //if (KhachHangBUS.danhSachKhachHang == null) {
        sanPhamBUS.docDanhSachSanPham();

        for (SanPhamDTO sanPhamDTO : SanPhamBUS.danhSachSanPham) {
            Vector row = new Vector();
            row.add(sanPhamDTO.getMaSanPham());
            row.add(sanPhamDTO.getTenSanPham());
            row.add(sanPhamDTO.getMaTheLoai());
            String t = formatter.format(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getDonGia());
            row.add(sanPhamDTO.getSoLuong());
            row.add(sanPhamDTO.getBaoHanh());

            row.add(sanPhamDTO.getMaNhaCungCap());

            model.addRow(row);
        }
    }

    void hienThiCTHD() {
        for (giohangDTO cDTO : giohang) {
            Vector row = new Vector();
            row.add(++stt);
            row.add(cDTO.getMa_san_pham());
            row.add(cDTO.getTen_san_pham());
            row.add(cDTO.getSo_luong());
            row.add(cDTO.getDon_gia());
            int a = cDTO.getDon_gia();
            int b = cDTO.getSo_luong();
            row.add(a * b);
            tong_tien += a * b;
            model1.addRow(row);
        }

    }

    void taoIdHd() throws ClassNotFoundException, SQLException, ParseException {
        ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
        HoaDonBUS hoaDonBUS = new HoaDonBUS();
        hoaDonBUS.docDanhSachHoaDon();
        list = HoaDonBUS.danhSachHoaDon;
        if (list.isEmpty()) {
            txtmahoahon.setText("1");
        } else {
            String idString = list.get(list.size() - 1).getIdString();
            int id = Integer.parseInt(idString);
            id++;
            idString = Integer.toString(id);
            txtmahoahon.setText(idString);
        }
    }

    private void showCombDataCbkh() throws ClassNotFoundException, SQLException, ParseException {
        KhachHangBUS khachHangBUS = new KhachHangBUS();
        khachHangBUS.docDanhSachKhachHang();
        ArrayList<KhachHangDTO> listKH = new ArrayList<KhachHangDTO>();
        listKH = KhachHangBUS.danhSachKhachHang;
        for (KhachHangDTO kh : listKH) {
            cbkh.addItem(kh.getHo() + " " + kh.getTen() + "(" + kh.getMaKhachHang() + ")");
        }
    }

    private void showCombDataCbkm() throws ClassNotFoundException, SQLException, ParseException {
        KhuyenMaiBUS khuyenMaiBUS = new KhuyenMaiBUS();
        khuyenMaiBUS.docDanhSachKhuyenMai();
        ArrayList<KhuyenMaiDTO> listKM = new ArrayList<KhuyenMaiDTO>();
        listKM = KhuyenMaiBUS.danhSachKhuyenMai;
        for (KhuyenMaiDTO kh : listKM) {
            cbkm.addItem(kh.getTen() + " (" + kh.getId() + ")");
        }

    }

    private void showCombDataCbnv() throws ClassNotFoundException, SQLException, ParseException {
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        nhanVienBUS.docDanhSachNhanVien();
        ArrayList<NhanVienDTO> listNV = new ArrayList<NhanVienDTO>();
        listNV = NhanVienBUS.danhSachNhanVien;
        for (NhanVienDTO nhanVienDTO : listNV) {
            cbnv.addItem(nhanVienDTO.getHo() + " " + nhanVienDTO.getTen() + " (" + nhanVienDTO.getMaNhanVien() + ")");
        }
    }
    private void showCombDataCbtl() throws ClassNotFoundException, SQLException, ParseException{
        TheLoaiBUS theLoaiBUS=new TheLoaiBUS();
        theLoaiBUS.docDanhSachTheLoai();
        ArrayList<TheLoaiDTO> listTL=new ArrayList<TheLoaiDTO>();
        listTL=TheLoaiBUS.danhSachTheLoai;
        cbtl.addItem("-------Thể loại-------");
        for(TheLoaiDTO tl: listTL){
            cbtl.addItem(tl.getTenTheLoaiString()+" ("+tl.getMaTheLoaiString()+")");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbsanpham = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtmahoahon = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtngaylap = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txttongtien = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtgiolap = new javax.swing.JTextField();
        cbkh = new javax.swing.JComboBox<>();
        cbkm = new javax.swing.JComboBox<>();
        txtten = new javax.swing.JTextField();
        btcb = new javax.swing.JButton();
        cbnv = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbcthoadon = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTheLoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSo_luong = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txttong_tien = new javax.swing.JTextField();
        txtconlai = new javax.swing.JTextField();
        txtgiamgia = new javax.swing.JTextField();
        bthuy = new javax.swing.JButton();
        btthanhtoan = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtgiabd = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtgiakt = new javax.swing.JTextField();
        cbtl = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BÁN HÀNG");

        tbsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên sản phẩm", "Mã thể loại", "Đơn giá", "Số lượng"
            }
        ));
        tbsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbsanphamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbsanpham);
        if (tbsanpham.getColumnModel().getColumnCount() > 0) {
            tbsanpham.getColumnModel().getColumn(0).setPreferredWidth(25);
            tbsanpham.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Mã Hóa Đơn:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Tên khách hàng:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tên nhân viên:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Ngày lập:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Khuyến mãi:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Tổng tiền:");

        txttongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongtienActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Giờ lập:");

        cbkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkhActionPerformed(evt);
            }
        });

        cbkm.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbkmItemStateChanged(evt);
            }
        });

        btcb.setText("...");
        btcb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btcb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)
                                .addGap(105, 105, 105))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(txtngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtgiolap)
                                        .addGap(105, 105, 105)))))
                        .addComponent(cbkh, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtmahoahon, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14)
                    .addComponent(txttongtien)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(cbkm, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbnv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmahoahon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btcb))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbnv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtgiolap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbcthoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Mã", "Tên", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(tbcthoadon);
        if (tbcthoadon.getColumnModel().getColumnCount() > 0) {
            tbcthoadon.getColumnModel().getColumn(0).setPreferredWidth(10);
            tbcthoadon.getColumnModel().getColumn(1).setPreferredWidth(20);
            tbcthoadon.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbcthoadon.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên sản phẩm:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Search.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Mã sản phẩm:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tên sản phẩm:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Thể loại:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Đơn giá:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Số lượng:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(150, 150, 150)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSo_luong, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSo_luong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Create.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Giảm giá:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Còn lại:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tổng tiền:");

        txttong_tien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttong_tienActionPerformed(evt);
            }
        });

        txtconlai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconlaiActionPerformed(evt);
            }
        });

        txtgiamgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiamgiaActionPerformed(evt);
            }
        });

        bthuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Delete.png"))); // NOI18N
        bthuy.setText("Hủy");
        bthuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthuyActionPerformed(evt);
            }
        });

        btthanhtoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Price list.png"))); // NOI18N
        btthanhtoan.setText("Thanh toán");
        btthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthanhtoanActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Edit.png"))); // NOI18N
        jButton2.setText("Sửa sản phẩm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Trash.png"))); // NOI18N
        jButton3.setText("Xóa sản phẩm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtgiabd.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtgiabdCaretUpdate(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Giá sản phẩm:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("đến");

        txtgiakt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtgiaktCaretUpdate(evt);
            }
        });

        cbtl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbtlItemStateChanged(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinhanh/Home.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtgiabd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtgiakt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbtl, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(37, 37, 37))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bthuy)
                                .addGap(38, 38, 38))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(36, 36, 36)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btthanhtoan)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttong_tien, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(txtgiamgia)
                                    .addComponent(txtconlai)))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jButton4))
                                .addGap(13, 13, 13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtgiabd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(txtgiakt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbtl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bthuy)
                                .addComponent(btthanhtoan))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txttong_tien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtgiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtconlai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        // TODO add your handling code here:
        SanPhamBUS sanPhamBUS = new SanPhamBUS();
        model.setRowCount(0);
        String tenString = jTextField1.getText();
        try {
            for (SanPhamDTO sanPhamDTO : sanPhamBUS.timkiemTen(tenString)) {
                Vector row = new Vector();
                row.add(sanPhamDTO.getMaSanPham());
                row.add(sanPhamDTO.getTenSanPham());
                row.add(sanPhamDTO.getMaTheLoai());
                row.add(sanPhamDTO.getDonGia());
                row.add(sanPhamDTO.getSoLuong());
                row.add(sanPhamDTO.getBaoHanh());

                row.add(sanPhamDTO.getMaNhaCungCap());

                model.addRow(row);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void tbsanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbsanphamMouseClicked
        // TODO add your handling code here:
        int stt_hang = tbsanpham.getSelectedRow();
        if (stt_hang != -1) {
            txtGia.setText(tbsanpham.getModel().getValueAt(stt_hang, 3).toString());
            txtMa.setText(tbsanpham.getModel().getValueAt(stt_hang, 0).toString());
            txtTen.setText(tbsanpham.getModel().getValueAt(stt_hang, 1).toString());
            txtSo_luong.setText("1");
            TheLoaiBUS theLoaiBUS = new TheLoaiBUS();
            TheLoaiDTO theLoaiDTO = new TheLoaiDTO();
            try {
                theLoaiDTO = theLoaiBUS.timkiem(tbsanpham.getModel().getValueAt(stt_hang, 2).toString());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtTheLoai.setText(theLoaiDTO.getTenTheLoaiString());

        }
    }//GEN-LAST:event_tbsanphamMouseClicked

    void toDay() {
        Date date = new Date();
        txtngaylap.setText(new SimpleDateFormat("dd/MM/yyyy").format(date));
        txtgiolap.setText(new SimpleDateFormat("hh:mm:ss").format(date));
    }

    private void txttongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongtienActionPerformed

    private void txttong_tienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttong_tienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttong_tienActionPerformed

    private void txtconlaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconlaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtconlaiActionPerformed

    private void txtgiamgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiamgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiamgiaActionPerformed

    private void btthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthanhtoanActionPerformed
        // TODO add your handling code here:
        //System.out.println("ACEKGNEKGNKGNEKNGKNEGOENGJENGJKENGGEGEGEGe"+giohang.size());
        KhachHangBUS khachHangBUS = new KhachHangBUS();
        KhuyenMaiBUS khuyenMaiBUS = new KhuyenMaiBUS();
        ChiTietHDBUS chiTietHDBUS = new ChiTietHDBUS();
        try {
            chiTietHDBUS.docDanhSachChiTietHD();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            khuyenMaiBUS.docDanhSachKhuyenMai();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            khachHangBUS.docDanhSachKhachHang();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        int tong_giam_gia = (int) (tong_tien * (giam_gia * 1.0 / 100));
        tong_tien = tong_tien - tong_giam_gia;
        HoaDonDTO hoaDonDTO = new HoaDonDTO();
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        khachHangDTO = KhachHangBUS.danhSachKhachHang.get(cbkh.getSelectedIndex());
        KhuyenMaiDTO khuyenMaiDTO = new KhuyenMaiDTO();
        khuyenMaiDTO = KhuyenMaiBUS.danhSachKhuyenMai.get(cbkm.getSelectedIndex());
        NhanVienDTO nhanVienDTO = new NhanVienDTO();
        nhanVienDTO = NhanVienBUS.danhSachNhanVien.get(cbnv.getSelectedIndex());
        hoaDonDTO.setIdString(txtmahoahon.getText());
        hoaDonDTO.setId_nhan_vienString(nhanVienDTO.getMaNhanVien());
        hoaDonDTO.setId_khuyen_mai(khuyenMaiDTO.getId());
        hoaDonDTO.setNgay_xuat(new Date());
        hoaDonDTO.setId_khach_hang(khachHangDTO.getMaKhachHang());
        hoaDonDTO.setTong_giam_gia(tong_giam_gia);
        hoaDonDTO.setTong_tien_con_lai(tong_tien);

        System.out.println(hoaDonDTO);
        HoaDonBUS hoaDonBUS = new HoaDonBUS();
        try {
            if (txtten.getText() == "") {
                hoaDonBUS.them1(hoaDonDTO);
            } else {
                hoaDonBUS.them(hoaDonDTO);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        String idHD = txtmahoahon.getText();

        for (giohangDTO c : giohang) {
            System.out.println(c);
            ChiTietHDDTO chiTietHDDTO = new ChiTietHDDTO();
            chiTietHDDTO.setId_hoa_donString(idHD);
            chiTietHDDTO.setId_san_pham(c.getMa_san_pham());
            chiTietHDDTO.setSo_luong(c.getSo_luong());
            chiTietHDDTO.setDon_gia(c.getDon_gia());
            chiTietHDDTO.setThanh_tien(c.getDon_gia() * c.getSo_luong());
            
            try {
                //ChiTietHDBUS chiTietHDBUS=new ChiTietHDBUS();
                chiTietHDBUS.them(chiTietHDDTO);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        giohang.clear();
        model1.setRowCount(0);
        tong_tien = 0;
        con_lai = 0;
        try {
            taoIdHd();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtconlai.setText("0 đ");
        txtgiamgia.setText("0 đ");
        txttong_tien.setText("0 đ");
        txttongtien.setText("0 đ");
    }//GEN-LAST:event_btthanhtoanActionPerformed

    private void bthuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthuyActionPerformed
        // TODO add your handling code here:
        int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc HỦY tất cả sản phẩm?", "", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            giohang.clear();
            model1.setRowCount(0);
            txttong_tien.setText("");
            txttongtien.setText("");
            txtgiamgia.setText("");
            txtconlai.setText("");
        }
    }//GEN-LAST:event_bthuyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tong_tien = 0;
        con_lai = 0;
        KhuyenMaiDTO khuyenMaiDTO = new KhuyenMaiDTO();

        toDay();
        giohangDTO c = new giohangDTO();
        c.setMa_san_pham(txtMa.getText());
        c.setSo_luong(Integer.parseInt(txtSo_luong.getText()));
        c.setTen_san_pham(txtTen.getText());
        c.setDon_gia(Integer.parseInt(txtGia.getText()));
        int flag = 0;
        for (int i = 0; i < giohang.size(); i++) {
            if (giohang.get(i).getMa_san_pham().equals(c.getMa_san_pham())) {
                int sl = c.getSo_luong() + giohang.get(i).getSo_luong();
                c.setSo_luong(sl);
                giohang.set(i, c);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            giohang.add(c);
        }
        stt = 0;
        model1.setRowCount(0);
        hienThiCTHD();
        giam_gia = KhuyenMaiBUS.danhSachKhuyenMai.get(cbkm.getSelectedIndex()).getPhan_tram();
        int a = (int) (tong_tien * (giam_gia * 1.0 / 100));
        con_lai = tong_tien - a;
        txtgiamgia.setText("-" + formatter.format(a) + " đ");
        txtconlai.setText(formatter.format(con_lai) + " đ");

        txttong_tien.setText(formatter.format(tong_tien) + " đ");
        txttongtien.setText(formatter.format(tong_tien) + " đ");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int stt_hang = tbcthoadon.getSelectedRow();
        if (stt_hang == -1) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sản phẩm bạn muốn thây đổi số lượng");
        } else {
            String sl = JOptionPane.showInputDialog("Nhập số lượng bạn muốn thay đổi?");
            if (!sl.isEmpty()) {
                int so_luong = Integer.parseInt(sl);
                giohang.get(stt_hang).setSo_luong(so_luong);
                stt = 0;
                model1.setRowCount(0);
                tong_tien = 0;
                con_lai = 0;
                hienThiCTHD();
                giam_gia = KhuyenMaiBUS.danhSachKhuyenMai.get(cbkm.getSelectedIndex()).getPhan_tram();
                int a = (int) (tong_tien * (giam_gia * 1.0 / 100));
                con_lai = tong_tien - a;
                txtgiamgia.setText("-" + formatter.format(a) + " đ");
                txtconlai.setText(formatter.format(con_lai) + " đ");
                txttong_tien.setText(formatter.format(tong_tien) + " đ");
                txttongtien.setText(formatter.format(tong_tien) + " đ");
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int stt_hang = tbcthoadon.getSelectedRow();
        if (stt_hang == -1) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn sản phẩm bạn muốn xóa");
        } else {
            int reply = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sản phẩm này xóa không?", "", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                giohang.remove(stt_hang);
                stt = 0;
                model1.setRowCount(0);
                tong_tien = 0;
                con_lai = 0;
                hienThiCTHD();
                giam_gia = KhuyenMaiBUS.danhSachKhuyenMai.get(cbkm.getSelectedIndex()).getPhan_tram();
                int a = (int) (tong_tien * (giam_gia * 1.0 / 100));
                con_lai = tong_tien - a;

            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbkhActionPerformed

    private void btcbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcbActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, cbkh);
        int i = cbkh.getSelectedIndex();

        //String tenString=KhachHangBUS.danhSachKhachHang.get(i).getTen();
        txtten.setText(cbkh.getItemAt(i));
    }//GEN-LAST:event_btcbActionPerformed

    private void cbkmItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbkmItemStateChanged
        // TODO add your handling code here:
        giam_gia = KhuyenMaiBUS.danhSachKhuyenMai.get(cbkm.getSelectedIndex()).getPhan_tram();
        int a = (int) (tong_tien * (giam_gia * 1.0 / 100));
        con_lai = tong_tien - a;
        txtgiamgia.setText("-" + formatter.format(a) + " đ");
        txtconlai.setText(formatter.format(con_lai) + " đ");
        txttong_tien.setText(formatter.format(tong_tien) + " đ");
        txttongtien.setText(formatter.format(tong_tien) + " đ");
    }//GEN-LAST:event_cbkmItemStateChanged

    private void txtgiabdCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtgiabdCaretUpdate
        // TODO add your handling code here:
        String gia1 = txtgiabd.getText();
        String gia2 = txtgiakt.getText();
        if ((gia2.equals("")) && (!gia1.equals(""))) {
            model.setRowCount(0);
            SanPhamBUS sanPhamBUS = new SanPhamBUS();
            try {
                for (SanPhamDTO sanPhamDTO : sanPhamBUS.gia1(gia1)) {
                    Vector row = new Vector();
                    row.add(sanPhamDTO.getMaSanPham());
                    row.add(sanPhamDTO.getTenSanPham());
                    row.add(sanPhamDTO.getMaTheLoai());
                    row.add(sanPhamDTO.getDonGia());
                    row.add(sanPhamDTO.getSoLuong());
                    row.add(sanPhamDTO.getBaoHanh());

                    row.add(sanPhamDTO.getMaNhaCungCap());

                    model.addRow(row);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ((!gia2.equals("")) && (!gia1.equals("")) && cbtl.getSelectedIndex()==0) {
            model.setRowCount(0);
            SanPhamBUS sanPhamBUS = new SanPhamBUS();
            try {
                for (SanPhamDTO sanPhamDTO : sanPhamBUS.gia1_2(gia1,gia2)) {
                    Vector row = new Vector();
                    row.add(sanPhamDTO.getMaSanPham());
                    row.add(sanPhamDTO.getTenSanPham());
                    row.add(sanPhamDTO.getMaTheLoai());
                    row.add(sanPhamDTO.getDonGia());
                    row.add(sanPhamDTO.getSoLuong());
                    row.add(sanPhamDTO.getBaoHanh());

                    row.add(sanPhamDTO.getMaNhaCungCap());

                    model.addRow(row);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ((!gia2.equals("")) && (!gia1.equals("")) &&(cbtl.getSelectedIndex()!=0)){
            int i=cbtl.getSelectedIndex();
        String gia11=txtgiabd.getText();
        String gia22=txtgiakt.getText();
        if(i !=0){
            SanPhamBUS sanPhamBUS=new SanPhamBUS();                        
            ArrayList<TheLoaiDTO> listTL= new ArrayList<TheLoaiDTO>();
            listTL=TheLoaiBUS.danhSachTheLoai;
            String idtl=listTL.get(i-1).getMaTheLoaiString();
            if((!gia1.equals(""))&&(!gia2.equals(""))){                                                              
                
                model.setRowCount(0);
                try {
                    for (SanPhamDTO sanPhamDTO : sanPhamBUS.timkiemtl_gia(idtl, Integer.parseInt(gia11), Integer.parseInt(gia22))) {
                        Vector row = new Vector();
                        row.add(sanPhamDTO.getMaSanPham());
                        row.add(sanPhamDTO.getTenSanPham());
                        row.add(sanPhamDTO.getMaTheLoai());
                        row.add(sanPhamDTO.getDonGia());
                        row.add(sanPhamDTO.getSoLuong());
                        row.add(sanPhamDTO.getBaoHanh());
                        
                        row.add(sanPhamDTO.getMaNhaCungCap());
                        
                        model.addRow(row);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }
    }//GEN-LAST:event_txtgiabdCaretUpdate

    private void txtgiaktCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtgiaktCaretUpdate
        // TODO add your handling code here:
        String gia1 = txtgiabd.getText();
        String gia2 = txtgiakt.getText();
        if ((!gia2.equals("")) && (gia1.equals(""))) {
            model.setRowCount(0);
            SanPhamBUS sanPhamBUS = new SanPhamBUS();
            try {
                for (SanPhamDTO sanPhamDTO : sanPhamBUS.gia2(gia2)) {
                    Vector row = new Vector();
                    row.add(sanPhamDTO.getMaSanPham());
                    row.add(sanPhamDTO.getTenSanPham());
                    row.add(sanPhamDTO.getMaTheLoai());
                    row.add(sanPhamDTO.getDonGia());
                    row.add(sanPhamDTO.getSoLuong());
                    row.add(sanPhamDTO.getBaoHanh());

                    row.add(sanPhamDTO.getMaNhaCungCap());

                    model.addRow(row);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ((!gia2.equals("")) && (!gia1.equals("")) &&(cbtl.getSelectedIndex()==0)) {
            model.setRowCount(0);
            SanPhamBUS sanPhamBUS = new SanPhamBUS();
            try {
                for (SanPhamDTO sanPhamDTO : sanPhamBUS.gia1_2(gia1,gia2)) {
                    Vector row = new Vector();
                    row.add(sanPhamDTO.getMaSanPham());
                    row.add(sanPhamDTO.getTenSanPham());
                    row.add(sanPhamDTO.getMaTheLoai());
                    row.add(sanPhamDTO.getDonGia());
                    row.add(sanPhamDTO.getSoLuong());
                    row.add(sanPhamDTO.getBaoHanh());

                    row.add(sanPhamDTO.getMaNhaCungCap());

                    model.addRow(row);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ((!gia2.equals("")) && (!gia1.equals("")) &&(cbtl.getSelectedIndex()!=0)){
            int i=cbtl.getSelectedIndex();
        String gia11=txtgiabd.getText();
        String gia22=txtgiakt.getText();
        if(i !=0){
            SanPhamBUS sanPhamBUS=new SanPhamBUS();                        
            ArrayList<TheLoaiDTO> listTL= new ArrayList<TheLoaiDTO>();
            listTL=TheLoaiBUS.danhSachTheLoai;
            String idtl=listTL.get(i-1).getMaTheLoaiString();
            if((!gia1.equals(""))&&(!gia2.equals(""))){                                                              
                
                model.setRowCount(0);
                try {
                    for (SanPhamDTO sanPhamDTO : sanPhamBUS.timkiemtl_gia(idtl, Integer.parseInt(gia11), Integer.parseInt(gia22))) {
                        Vector row = new Vector();
                        row.add(sanPhamDTO.getMaSanPham());
                        row.add(sanPhamDTO.getTenSanPham());
                        row.add(sanPhamDTO.getMaTheLoai());
                        row.add(sanPhamDTO.getDonGia());
                        row.add(sanPhamDTO.getSoLuong());
                        row.add(sanPhamDTO.getBaoHanh());
                        
                        row.add(sanPhamDTO.getMaNhaCungCap());
                        
                        model.addRow(row);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        }
    }//GEN-LAST:event_txtgiaktCaretUpdate

    private void cbtlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbtlItemStateChanged
        // TODO add your handling code here:
        int i=cbtl.getSelectedIndex();
        String gia1=txtgiabd.getText();
        String gia2=txtgiakt.getText();
        if(i != 0){
            SanPhamBUS sanPhamBUS=new SanPhamBUS();                        
            ArrayList<TheLoaiDTO> listTL= new ArrayList<TheLoaiDTO>();
            listTL=TheLoaiBUS.danhSachTheLoai;
            String idtl=listTL.get(i-1).getMaTheLoaiString();
            if((!gia1.equals(""))&&(!gia2.equals(""))){                                                              
                
                model.setRowCount(0);
                try {
                    for (SanPhamDTO sanPhamDTO : sanPhamBUS.timkiemtl_gia(idtl, Integer.parseInt(gia1), Integer.parseInt(gia2))) {
                        Vector row = new Vector();
                        row.add(sanPhamDTO.getMaSanPham());
                        row.add(sanPhamDTO.getTenSanPham());
                        row.add(sanPhamDTO.getMaTheLoai());
                        row.add(sanPhamDTO.getDonGia());
                        row.add(sanPhamDTO.getSoLuong());
                        row.add(sanPhamDTO.getBaoHanh());
                        
                        row.add(sanPhamDTO.getMaNhaCungCap());
                        
                        model.addRow(row);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                model.setRowCount(0);
            
            
                try {
                    for (SanPhamDTO sanPhamDTO : sanPhamBUS.timkiemtl(idtl)) {
                        Vector row = new Vector();
                        row.add(sanPhamDTO.getMaSanPham());
                        row.add(sanPhamDTO.getTenSanPham());
                        row.add(sanPhamDTO.getMaTheLoai());
                        row.add(sanPhamDTO.getDonGia());
                        row.add(sanPhamDTO.getSoLuong());
                        row.add(sanPhamDTO.getBaoHanh());
                        
                        row.add(sanPhamDTO.getMaNhaCungCap());
                        
                        model.addRow(row);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_cbtlItemStateChanged
 public void close(){
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        new HOME().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BanHang().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(BanHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcb;
    private javax.swing.JButton bthuy;
    private javax.swing.JButton btthanhtoan;
    private javax.swing.JComboBox<String> cbkh;
    private javax.swing.JComboBox<String> cbkm;
    private javax.swing.JComboBox<String> cbnv;
    private javax.swing.JComboBox<String> cbtl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbcthoadon;
    private javax.swing.JTable tbsanpham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSo_luong;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTheLoai;
    private javax.swing.JTextField txtconlai;
    private javax.swing.JTextField txtgiabd;
    private javax.swing.JTextField txtgiakt;
    private javax.swing.JTextField txtgiamgia;
    private javax.swing.JTextField txtgiolap;
    private javax.swing.JTextField txtmahoahon;
    private javax.swing.JTextField txtngaylap;
    private javax.swing.JTextField txtten;
    private javax.swing.JTextField txttong_tien;
    private javax.swing.JTextField txttongtien;
    // End of variables declaration//GEN-END:variables
}
