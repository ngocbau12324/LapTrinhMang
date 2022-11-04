/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package danhsachsinhvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NGOC BAU
 */
public class ThongTinSv extends javax.swing.JFrame {

    /**
     * Creates new form ThongTinSv
     */
    ArrayList<SinhVien> list;
    DefaultTableModel model;
    Connection connection=ketnoidulieu.ketNoi();
    
    public ThongTinSv() {
        initComponents();
        list=new ArrayList<>();
        model=(DefaultTableModel) tbSv.getModel();
        txMssv.requestFocus(true);
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
        lbMssv = new javax.swing.JLabel();
        lbHo = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        lbNgS = new javax.swing.JLabel();
        lbGt = new javax.swing.JLabel();
        llbDiaChi = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbSdt = new javax.swing.JLabel();
        lbDtb = new javax.swing.JLabel();
        txDtb = new javax.swing.JTextField();
        txSdt = new javax.swing.JTextField();
        txEmail = new javax.swing.JTextField();
        txDiaChi = new javax.swing.JTextField();
        txGt = new javax.swing.JTextField();
        txNgS = new javax.swing.JTextField();
        txTen = new javax.swing.JTextField();
        txHo = new javax.swing.JTextField();
        btThem = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        txMssv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSv = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("NHẬP THÔNG TIN SINH VIÊN");

        lbMssv.setText("Mã sinh viên");

        lbHo.setText("Họ đệm");

        lbTen.setText("Tên");

        lbNgS.setText("Ngày sinh");

        lbGt.setText("Giới tính");

        llbDiaChi.setText("Địa chỉ");

        lbEmail.setText("Email");

        lbSdt.setText("Số điện thoại");

        lbDtb.setText("Điểm trung bình");

        txDtb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txDtbKeyPressed(evt);
            }
        });

        txSdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txSdtKeyPressed(evt);
            }
        });

        txEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txEmailKeyPressed(evt);
            }
        });

        txDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txDiaChiActionPerformed(evt);
            }
        });
        txDiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txDiaChiKeyPressed(evt);
            }
        });

        txGt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txGtKeyPressed(evt);
            }
        });

        txNgS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txNgSKeyPressed(evt);
            }
        });

        txTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txTenKeyPressed(evt);
            }
        });

        txHo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txHoActionPerformed(evt);
            }
        });
        txHo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txHoKeyPressed(evt);
            }
        });

        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btReset.setText("Nhập lại");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        txMssv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txMssvKeyPressed(evt);
            }
        });

        tbSv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sinh viên", "Họ đệm", "Tên", "Ngày Sinh", "Giới tính", "Địa chỉ", "Email", "Số Đt", "Điểm TB"
            }
        ));
        jScrollPane1.setViewportView(tbSv);
        if (tbSv.getColumnModel().getColumnCount() > 0) {
            tbSv.getColumnModel().getColumn(0).setMaxWidth(40);
            tbSv.getColumnModel().getColumn(1).setMaxWidth(100);
            tbSv.getColumnModel().getColumn(3).setMaxWidth(50);
            tbSv.getColumnModel().getColumn(5).setMaxWidth(60);
            tbSv.getColumnModel().getColumn(8).setMaxWidth(150);
            tbSv.getColumnModel().getColumn(9).setMaxWidth(60);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("DANH SÁCH SINH VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 991, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btThem)
                        .addGap(28, 28, 28)
                        .addComponent(btReset)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(llbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbSdt))
                            .addComponent(lbDtb)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbGt, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNgS, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbMssv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbHo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txSdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(txEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txGt, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txNgS, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txTen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txHo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txMssv, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txDtb))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMssv)
                            .addComponent(txMssv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbHo)
                            .addComponent(txHo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTen))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbNgS)
                            .addComponent(txNgS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbGt)
                            .addComponent(txGt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(llbDiaChi)
                            .addComponent(txDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbEmail)
                            .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbSdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDtb)
                            .addComponent(txDtb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btThem)
                            .addComponent(btReset)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        // TODO add your handling code here:
        SinhVien s=new SinhVien();
        s.setMssv(txMssv.getText());
        s.setHo(txHo.getText());
        s.setTen(txTen.getText());
        s.setDiaChi(txDiaChi.getText());
        s.setGioiTinh(txGt.getText());
        s.setEmail(txEmail.getText());
        s.setDiemTB(Float.parseFloat(txDtb.getText()));
        s.setSdt(txSdt.getText());
        try{
            s.setNgaySinh(new SimpleDateFormat("yyyy-mm-dd").parse(txNgS.getText()));
        } catch (ParseException ex) {
            Logger.getLogger(ThongTinSv.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.add(s);//Thêm vào danh sách sinh viên
        hienThi();
    }//GEN-LAST:event_btThemActionPerformed
    int stt=1;
    public void hienThi(){
        SinhVien s=list.get(list.size()-1);
        model.addRow(new Object[]{stt++,s.getMssv(),s.getHo(),s.getTen(),s.getNgaySinh(),s.getGioiTinh(),s.getDiaChi()
            ,s.getEmail(),s.getSdt(),s.getDiemTB()});
    }
    public void docDuLieu(){
        try {
            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from sinhvien");
            while(rs.next()){
                SinhVien s=new SinhVien();
                s.setMssv(rs.getString(1));
                s.setHo(rs.getString(2));
                s.setTen(rs.getString(3));
                s.setDiaChi(rs.getString(6));
                s.setGioiTinh(rs.getString(5));
                s.setEmail(rs.getString(7));
                s.setDiemTB(Float.parseFloat(rs.getString(9)));
                s.setSdt(rs.getString(8));
        try{
            s.setNgaySinh(new SimpleDateFormat("yyyy-mm-dd").parse(rs.getString(4)));
        } catch (ParseException ex) {
            Logger.getLogger(ThongTinSv.class.getName()).log(Level.SEVERE, null, ex);
        }
        list.add(s);
        hienThi();
            }
        } catch (Exception e) {
        }
    }
    private void txHoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txHoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txHoActionPerformed

    private void txDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txDiaChiActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        // TODO add your handling code here:
        txMssv.setText("");
        txHo.setText("");
        txTen.setText("");
        txNgS.setText("");
        txDiaChi.setText("");
        txEmail.setText("");
        txSdt.setText("");
        txDtb.setText("");
        txGt.setText("");
        txMssv.requestFocus(true);
    }//GEN-LAST:event_btResetActionPerformed

    private void txMssvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMssvKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            txHo.requestFocus(true);
    }//GEN-LAST:event_txMssvKeyPressed

    private void txHoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txHoKeyPressed
            // TODO add your handling code here:
            if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            txTen.requestFocus(true);
    }//GEN-LAST:event_txHoKeyPressed

    private void txTenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTenKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            txNgS.requestFocus(true);
    }//GEN-LAST:event_txTenKeyPressed

    private void txNgSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txNgSKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            txGt.requestFocus(true);
    }//GEN-LAST:event_txNgSKeyPressed

    private void txGtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txGtKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            txDiaChi.requestFocus(true);
    }//GEN-LAST:event_txGtKeyPressed

    private void txDiaChiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDiaChiKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            txEmail.requestFocus(true);
    }//GEN-LAST:event_txDiaChiKeyPressed

    private void txEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEmailKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            txSdt.requestFocus(true);
    }//GEN-LAST:event_txEmailKeyPressed

    private void txSdtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txSdtKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            txDtb.requestFocus(true);
    }//GEN-LAST:event_txSdtKeyPressed

    private void txDtbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txDtbKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            btThem.doClick();
    }//GEN-LAST:event_txDtbKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(ThongTinSv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongTinSv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongTinSv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongTinSv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThongTinSv thongTinSv=new ThongTinSv();
                //new ThongTinSv().setVisible(true);
                thongTinSv.docDuLieu();
                thongTinSv.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btReset;
    private javax.swing.JButton btThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDtb;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGt;
    private javax.swing.JLabel lbHo;
    private javax.swing.JLabel lbMssv;
    private javax.swing.JLabel lbNgS;
    private javax.swing.JLabel lbSdt;
    private javax.swing.JLabel lbTen;
    private javax.swing.JLabel llbDiaChi;
    private javax.swing.JTable tbSv;
    private javax.swing.JTextField txDiaChi;
    private javax.swing.JTextField txDtb;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txGt;
    private javax.swing.JTextField txHo;
    private javax.swing.JTextField txMssv;
    private javax.swing.JTextField txNgS;
    private javax.swing.JTextField txSdt;
    private javax.swing.JTextField txTen;
    // End of variables declaration//GEN-END:variables
}
