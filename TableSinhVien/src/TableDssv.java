import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

public class TableDssv {
    private JPanel rootPanel;
    private JTable tbSv;
    private JTextField txMssv;
    private JTextField txHo;
    private JTextField txTen;
    private JTextField txGt;
    private JTextField txNgSinh;
    private JTextField txDiaChi;
    private JTextField txEmail;
    private JTextField txSdt;
    private JTextField txDtb;
    private JButton btThem;
    private JButton btThoat;
    private JLabel txTitle1;
    private JLabel txTitle2;
    private JLabel lbMssv;
    private JLabel lbHo;
    private JLabel lbTen;
    private JLabel lbGt;
    private JLabel lbNgSinh;
    private JLabel lbDiaChi;
    private JLabel lbEmail;
    private JLabel lbSdt;
    private JLabel lbDtb;
    DefaultTableModel model=new DefaultTableModel();

    public TableDssv(){
        createTable();
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txMssv.setText("");
                txHo.setText("");
                txTen.setText("");
                txGt.setText("");
                txDiaChi.setText("");
                txEmail.setText("");
                txSdt.setText("");
                txDtb.setText("");
                txNgSinh.setText("");
            }
        });
        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //createTable();
                SinhVien sinhVien=new SinhVien();
                sinhVien.setMssv(txMssv.getText());
                sinhVien.setHo(txHo.getText());
                sinhVien.setTen(txTen.getText());
                sinhVien.setGioiTinh(txGt.getText());
                try{
                    sinhVien.setNgaySinh(new SimpleDateFormat("dd/MM/yyyy").parse(txNgSinh.getText()));
                }catch (ParseException ex){
                    ex.printStackTrace();
                }
                sinhVien.setDiaChi(txDiaChi.getText());
                sinhVien.setEmail(txEmail.getText());
                sinhVien.setSdt(txSdt.getText());
                sinhVien.setDiemTB(Float.parseFloat(txDtb.getText()));
                /*Vector row=new Vector();;
                row.add(sinhVien.getMssv());
                row.add(sinhVien.getHo());
                row.add(sinhVien.getTen());
                row.add(sinhVien.getGioiTinh());
                row.add(sinhVien.getNgaySinh());
                row.add(sinhVien.getDiaChi());
                row.add(sinhVien.getEmail());
                row.add(sinhVien.getSdt());
                row.add(sinhVien.getDiemTB());
                model.addRow(row);
                tbSv.setModel(model); {sinhVien.getMssv(),sinhVien.getHo(),sinhVien.getTen(),sinhVien.getGioiTinh(),sinhVien.getNgaySinh(),
                        sinhVien.getDiaChi(),sinhVien.getEmail(),sinhVien.getSdt(),sinhVien.getDiemTB()}*/
                Object [][] sl={{23424,"3119410035","Nguyen","Ngoc Bau","Nam",
                        "30/1/2001","Tp.HoChiMinh","ngocbau2015tqk@gmal.com",
                        "0969295720","8.0"}};
                model.addRow(sl[0]);
            }
        });
    }

    public JPanel getRootPanel(){
        return rootPanel;
    }
    private void createTable(){
        /*Object[][]data={{1,"3119410035","Nguyen","Ngoc Bau","Nam",
                "30/1/2001","Tp.HoChiMinh","ngocbau2015tqk@gmal.com",
                "0969295720","8.0"}
                        ,{"2","3119410035","Nguyen","Ngoc Bau","Nam",
                "30/1/2001","Tp.HoChiMinh","ngocbau2015tqk@gmal.com",
                "0969295720","8.0"}};*/
        Object[][] data={{1,"3119410035","Nguyen","Ngoc Bau","Nam",
                "30/1/2001","Tp.HoChiMinh","ngocbau2015tqk@gmal.com",
                "0969295720","8.0"}};
        String[] cot={"Stt","Mssv","Họ","Tên",
                "Giới tính","Ngày sinh","Địa chỉ",
                "Email","Số điện thoại","Điểm TB"};
        tbSv.setModel(new DefaultTableModel(
                data,
                new String[]{"Stt","Mssv","Họ","Tên",
                        "Giới tính","Ngày sinh","Địa chỉ",
                        "Email","Số điện thoại","Điểm TB"}
        ));
        TableColumnModel columnModel=tbSv.getColumnModel();
        columnModel.getColumn(0).setMaxWidth(30);
        columnModel.getColumn(1).setMinWidth(90);
        columnModel.getColumn(2).setMinWidth(40);
        columnModel.getColumn(3).setMinWidth(100);
        columnModel.getColumn(4).setMaxWidth(50);
        columnModel.getColumn(5).setMinWidth(50);
        columnModel.getColumn(9).setMaxWidth(55);
        columnModel.getColumn(7).setMinWidth(190);
        DefaultTableCellRenderer centerRenderer=new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        columnModel.getColumn(0).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(2).setCellRenderer(centerRenderer);
        columnModel.getColumn(3).setCellRenderer(centerRenderer);
        columnModel.getColumn(4).setCellRenderer(centerRenderer);
        columnModel.getColumn(5).setCellRenderer(centerRenderer);
        columnModel.getColumn(6).setCellRenderer(centerRenderer);
        columnModel.getColumn(7).setCellRenderer(centerRenderer);
        columnModel.getColumn(8).setCellRenderer(centerRenderer);
        columnModel.getColumn(9).setCellRenderer(centerRenderer);

    }
}
