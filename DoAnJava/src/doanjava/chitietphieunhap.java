/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class chitietphieunhap extends javax.swing.JFrame {
DefaultTableModel model=new DefaultTableModel();
public chitietphieunhap() throws SQLException
{
initComponents();
this.setVisible(true);
 model.addColumn("ID_Phiếu Nhập");
        model.addColumn("ID_SP");
        model.addColumn("Số Lượng");
        model.addColumn("Đơn giá");
        model.addColumn("Thành Tiền");
       jTable1.setModel(model);
}
    public chitietphieunhap(int ma) throws SQLException {
        this.setVisible(true);
        initComponents();
        jTextField1.setText(String.valueOf(ma));
        model.addColumn("ID_Phiếu Nhập");
        model.addColumn("ID_SP");
        model.addColumn("Số Lượng");
        model.addColumn("Đơn giá");
        model.addColumn("Thành Tiền");
        jTable1.setModel(model);
   
   
        
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã Phiếu");

        jLabel2.setText("Mã SP");

        jLabel3.setText("Đơn Giá");

        jLabel4.setText("Số Lượng");

        jLabel5.setText("Thành Tiền");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Tìm Kiếm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu", "Mã SP", "Đơn Gía", "Số Lượng ", "Thành Tiền"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Xem");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(62, 62, 62)
                        .addComponent(jButton2)
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       if( jTextField1.getText().equals("") ||jTextField2.getText().equals("") ||jTextField3.getText().equals("")
               || jTextField4.getText().equals("") )
       {
           JOptionPane.showMessageDialog(null,"vui lòng nhập đầy đủ"," ", JOptionPane.ERROR_MESSAGE);
       return;
       }
       else
       {
        chitietphieunhapdto ctpnt=new chitietphieunhapdto();
        try{
        ctpnt.maphieu=Integer.parseInt(jTextField1.getText());
        ctpnt.masp=Integer.parseInt(jTextField2.getText());
         ctpnt.dongia=Integer.parseInt(jTextField4.getText());
        ctpnt.soluong=Integer.parseInt(jTextField3.getText());
       
        ctpnt.thanhtien=ctpnt.soluong*ctpnt.dongia;
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(null,"Chỉ Nhập SỐ"," ", JOptionPane.ERROR_MESSAGE);
        return ;
        }
        int a=  new chitietphieunhapbus().them(ctpnt) ;
        if(a==0){
            JOptionPane.showMessageDialog(null,"Thêm Thất Bại"," ", JOptionPane.ERROR_MESSAGE);
        }
        else
        {JOptionPane.showMessageDialog(null,"Thêm Thành Công"," ", JOptionPane.WARNING_MESSAGE);}
       
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    List<chitietphieunhapdto> ctpndto=new ArrayList<>();
        try {
        // TODO add your handling code here:
        
       ctpndto=new chitietphieunhapbus().loaddata();
    } catch (SQLException ex) {
       System.err.print("loi loi ban oi");
    }
        for(int i=0;i<model.getRowCount();i++)
        {model.removeRow(0);}
        
        for(int i=0;i<ctpndto.size();i++)
        {
            Vector vt= new Vector();
           vt.add(ctpndto.get(i).maphieu);
             vt.add(ctpndto.get(i).masp);
        vt.add(ctpndto.get(i).dongia);
        vt.add(ctpndto.get(i).soluong);
        vt.add(ctpndto.get(i).thanhtien);
     model.addRow(vt);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String a="";
    a=  JOptionPane.showInputDialog(null,"nhập Mã ","",JOptionPane.QUESTION_MESSAGE);
        if(a==""){return;}
        
        chitietphieunhapdto ct=new chitietphieunhapdto();
        try{
        ct=new chitietphieunhapbus().timkiem(Integer.parseInt(a));
        }
        catch(Exception e)
        {return;}
        if(ct==null)
        {JOptionPane.showMessageDialog(null,"Không Tìm Thấy"," ", JOptionPane.ABORT);}
        else
        {
            
            jTextField1.setText(String.valueOf(ct.maphieu));
            jTextField2.setText(String.valueOf(ct.masp));
            jTextField3.setText(String.valueOf(ct.dongia));
            jTextField4.setText(String.valueOf(ct.soluong));
            jTextField5.setText(String.valueOf(ct.thanhtien));
             
        }   
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int a=jTable1.getRowCount();
        if(a==0){return;}
        int b=jTable1.getSelectedRow();
        jTextField1.setText(jTable1.getValueAt(b, 0).toString());
        jTextField2.setText(jTable1.getValueAt(b, 1).toString());
        jTextField3.setText(jTable1.getValueAt(b, 2).toString());
        jTextField4.setText(jTable1.getValueAt(b, 3).toString());
        jTextField5.setText(jTable1.getValueAt(b, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
  public static void main(String args[]) throws SQLException
  {
  new chitietphieunhap().setVisible(true);
  
  }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
