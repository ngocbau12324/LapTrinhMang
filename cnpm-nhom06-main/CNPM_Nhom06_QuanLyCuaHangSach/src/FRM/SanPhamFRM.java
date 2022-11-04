/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRM;
import BUS.SanPhamBUS;
import DTO.SanPhamDTO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tiens
 */
public class SanPhamFRM extends javax.swing.JFrame 
{
    /**
     * Creates new form SanPhamFRM
     */
    private DefaultTableModel model;
    public SanPhamFRM() {
        initComponents();
        jt.getColumnModel().getColumn(5).setPreferredWidth(200);
        setTitle("QUẢN LÝ SẢN PHẨM");
        docSanPham();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtLoai = new javax.swing.JTextField();
        txtDongia = new javax.swing.JTextField();
        txtSoluong = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtGhichu = new javax.swing.JTextField();
        p1 = new javax.swing.JPanel();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        btTimkiem = new javax.swing.JButton();
        btThongke = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();
        btDatlai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        jLabel2.setText("MÃ SẢN PHẨM");

        jLabel3.setText("LOẠI SẢN PHẨM");

        jLabel4.setText("TÊN SẢN PHẨM");

        jLabel5.setText("ĐƠN GIÁ");

        jLabel6.setText("SỐ LƯỢNG");

        jLabel7.setText("GHI CHÚ");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        txtLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoaiActionPerformed(evt);
            }
        });

        txtDongia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDongiaActionPerformed(evt);
            }
        });

        txtSoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoluongActionPerformed(evt);
            }
        });

        txtGhichu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGhichuActionPerformed(evt);
            }
        });

        btThem.setText("THÊM");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btSua.setText("Cập nhật");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setText("XÓA");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btThoat.setText("Quay lại");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        btTimkiem.setText("TÌM KIẾM");
        btTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimkiemActionPerformed(evt);
            }
        });

        btThongke.setText("THỐNG KÊ");
        btThongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThongkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btTimkiem)
                .addGap(52, 52, 52)
                .addComponent(btThongke, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btThoat)
                .addComponent(btTimkiem)
                .addComponent(btThongke))
        );

        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ SẢN PHẨM", "LOẠI SẢN PHẨM", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "SỐ LƯỢNG", "GHI CHÚ"
            }
        ));
        jt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jt);

        btDatlai.setText("ĐẶT LẠI");
        btDatlai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDatlaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btDatlai)
                        .addGap(30, 30, 30)
                        .addComponent(p1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                                    .addComponent(txtLoai)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTen)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDongia, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 128, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGhichu)))))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGhichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDatlai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void txtGhichuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGhichuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGhichuActionPerformed

    private void txtLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoaiActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        // TODO add your handling code here:
    int i = jt.getSelectedRow();
    if(i>=0)
    {
        if(!isValidToAdd())
            return;
        int result = JOptionPane.showConfirmDialog(null, "Xác nhận sửa ?","Xác nhận",JOptionPane.YES_NO_OPTION);
        if(result == JOptionPane.YES_OPTION)
        {
            SanPhamDTO sp = getFromTextField();
            SanPhamBUS bus = new SanPhamBUS();
            int check = bus.sua(sp,i);
            if(check == 1)
            {
                setModelValue(sp,i);
                JOptionPane.showMessageDialog(null, "Sửa thành công");
            }
        }
    }    
    }//GEN-LAST:event_btSuaActionPerformed

    private void txtSoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoluongActionPerformed

    private void txtDongiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDongiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDongiaActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
    if(!isValidToAdd())  
        return;
    SanPhamDTO sp = getFromTextField();
    Vector head = setVector(sp);
    SanPhamBUS bus = new SanPhamBUS();
    int check = bus.them(sp);
    if(check == 1)
    {
        model.addRow(head);
        jt.setModel(model);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
    }
    else
    {
        JOptionPane.showMessageDialog(null, "Mã đã tồn tại. Thêm thất bại");
    } 
    }//GEN-LAST:event_btThemActionPerformed

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
            java.util.logging.Logger.getLogger(SanPhamFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamFRM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamFRM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDatlai;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btThoat;
    private javax.swing.JButton btThongke;
    private javax.swing.JButton btTimkiem;
    private javax.swing.JButton btXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt;
    private javax.swing.JPanel p1;
    private javax.swing.JTextField txtDongia;
    private javax.swing.JTextField txtGhichu;
    private javax.swing.JTextField txtLoai;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoluong;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
    public boolean isNumberic(String str)
    {
        return str.matches("^\\d+$");
    }
    public boolean isValidToAdd(){
        boolean ok = true;
        if(txtMa.getText().trim().equals("")) ok = false;
        if(txtLoai.getText().trim().equals("")) ok = false;
        if(txtTen.getText().trim().equals("")) ok = false;
        if(ok == false)
        {
            JOptionPane.showMessageDialog(null, "Bạn phải điền đầy đủ thông tin !");
            return ok;
        }
        if(!isNumberic(txtDongia.getText()))
        {
            ok = false;
            JOptionPane.showMessageDialog(null, "Đơn giá không hợp lệ !");
        }
        if(!isNumberic(txtSoluong.getText()))
        {
            ok = false;
            JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ !");
        }
        return ok;
    }
    public SanPhamDTO getFromTextField()
    {
            SanPhamDTO sp = new SanPhamDTO();
            sp.setMa(txtMa.getText().trim());
            sp.setLoai(txtLoai.getText().trim());
            sp.setTen(txtTen.getText().trim());
            sp.setDongia(Integer.parseInt(txtDongia.getText()));
            sp.setSoluong(Integer.parseInt(txtSoluong.getText()));
            sp.setGhichu(txtGhichu.getText());
            return sp;
    }
    public Vector setVector(SanPhamDTO sp)
    {
            Vector head = new Vector();
            head.add(sp.getMa());
            head.add(sp.getLoai());
            head.add(sp.getTen());
            head.add(sp.getDongia());
            head.add(sp.getSoluong());
            head.add(sp.getGhichu());
            return head;
    }
    public void setModelValue(SanPhamDTO sp, int i)
    {
        model.setValueAt(sp.getMa(),i,0);
        model.setValueAt(sp.getLoai(),i,1);
        model.setValueAt(sp.getTen(),i,2);
        model.setValueAt(sp.getDongia(),i,3);
        model.setValueAt(sp.getSoluong(),i,4);
        model.setValueAt(sp.getGhichu(),i,5);
        jt.setModel(model);            
    }

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        // TODO add your handling code here:
        int i = jt.getSelectedRow();
        if(i>=0){
            int result = JOptionPane.showConfirmDialog(null, "Xác nhận xóa ?", "Xác nhận",JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){
                SanPhamBUS bus = new SanPhamBUS();
                int check = bus.xoa(i);  
                if(check == 1){
                    model.removeRow(i);
                    jt.setModel(model);
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                } 
            }
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void jtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtMouseClicked
       // TODO add your handling code here:
       int i = jt.getSelectedRow();
        if(i>=0)
        {
            setTextFieldValue(jt.getValueAt(i,0)+"",jt.getValueAt(i,1)+"",jt.getValueAt(i,2)+"",Integer.parseInt(jt.getValueAt(i,3)+""),Integer.parseInt(jt.getValueAt(i,4)+""),jt.getValueAt(i,5)+"");
        }
    }//GEN-LAST:event_jtMouseClicked

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        // TODO add your handling code here:
//        int exit = JOptionPane.showConfirmDialog(null,"Xác nhận thoát ?","Thoát",JOptionPane.OK_CANCEL_OPTION);
//        if(exit == JOptionPane.OK_OPTION)
//            System.exit(0);
        MenuFRM menu = new MenuFRM();
        this.setVisible(false);
        menu.setVisible(true);
    }//GEN-LAST:event_btThoatActionPerformed

    private void btDatlaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDatlaiActionPerformed
        // TODO add your handling code here:
        setTextFieldValue("","","",0,0,"");
    }//GEN-LAST:event_btDatlaiActionPerformed

    private void btTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimkiemActionPerformed
        // TODO add your handling code here:
        String result = JOptionPane.showInputDialog(null, "Nhập tìm kiếm", "Tìm kiếm",JOptionPane.INFORMATION_MESSAGE);
        if(result == null) return;
        SanPhamBUS bus = new SanPhamBUS();
        showOnTable(bus.timKiem(result));
    }//GEN-LAST:event_btTimkiemActionPerformed

    private void btThongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThongkeActionPerformed
       // TODO add your handling code here:
       
    }//GEN-LAST:event_btThongkeActionPerformed

    public void docSanPham(){
       SanPhamBUS bus = new SanPhamBUS();
       try
       {
           bus.docSanPham();
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, "Lỗi kết nối đến Database.");
           return;
       }
       Vector header = new Vector();
       header.add("Mã");
       header.add("Loại");
       header.add("Tên");
       header.add("Đơn giá");
       header.add("Số lượng");
       header.add("Ghi chú");
       model = new DefaultTableModel(header,0)
       {
            public boolean isCellEditable(int row, int column)
                {
                  return false;//This causes all cells to be not editable
                }
       };
       jt.setAutoCreateRowSorter(true);	
       showOnTable(bus.ds);
    }
    public void showOnTable(ArrayList<SanPhamDTO> ds)
    {
        model.setRowCount(0);
        for(SanPhamDTO sp:ds){
           Vector data = setVector(sp);
           model.addRow(data);
       }
       jt.setModel(model);
    }
    public void setTextFieldValue(String ma, String loai, String ten, int dongia, int soluong, String ghichu)
    {
            txtMa.setText(ma);
            txtLoai.setText(loai);
            txtTen.setText(ten);
            txtDongia.setText(dongia+"");
            txtSoluong.setText(soluong+"");
            txtGhichu.setText(ghichu);
    }
}
