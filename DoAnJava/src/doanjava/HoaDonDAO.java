/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author NGOC BAU
 */
public class HoaDonDAO {
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/java";
    Connection connection = null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet = null;

    public HoaDonDAO() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ket noi that bai!!!");
            }
        }
    }

    ArrayList docDanhSachHoaDon() throws ParseException {
        ArrayList danhSachHoaDon = new ArrayList<HoaDonDTO>();
        try {
            String sql = "select * from hoadon";
            preparedStatement = connection.prepareCall(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HoaDonDTO hoaDonDTO = new HoaDonDTO();
                hoaDonDTO.setIdString(resultSet.getString(1));
                hoaDonDTO.setId_nhan_vienString(resultSet.getString(2));
                hoaDonDTO.setId_khuyen_mai(resultSet.getString(3));
                hoaDonDTO.setNgay_xuat(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(4)));
                hoaDonDTO.setId_khach_hang(resultSet.getString(5));
                hoaDonDTO.setTong_giam_gia(Integer.parseInt(resultSet.getString(7)));
                hoaDonDTO.setTong_tien_con_lai(Integer.parseInt(resultSet.getString(6)));
                danhSachHoaDon.add(hoaDonDTO);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi doc thong tin hóa đơn");
        }
        return danhSachHoaDon;
    }
    @SuppressWarnings("StringEquality")
    void them(HoaDonDTO hoaDonDTO) throws SQLException{
        try{
        String sql="insert into hoadon(id, id_nhan_vien, id_khuyen_mai, ngay_xuat, id_khach_hang, tong_giam_gia, tong_tien_con_lai) value(?, ?, ?, ?, ?, ?, ?)";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,hoaDonDTO.getIdString());
        preparedStatement.setString(2,hoaDonDTO.getId_nhan_vienString());
        preparedStatement.setString(3,hoaDonDTO.getId_khuyen_mai());
        preparedStatement.setString(4,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(hoaDonDTO.getNgay_xuat()));
        preparedStatement.setString(5,hoaDonDTO.getId_khach_hang());
        preparedStatement.setString(6,Integer.toString(hoaDonDTO.getTong_giam_gia()));
        preparedStatement.setString(7,Integer.toString(hoaDonDTO.getTong_tien_con_lai()));
            System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        JOptionPane.showMessageDialog(null,"Thêm thành công!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi ghi!!!!!!!!1");
            return;
        }  
    }
    void them1(HoaDonDTO hoaDonDTO) throws SQLException{
        try{
        String sql="insert into hoadon(id, id_nhan_vien, id_khuyen_mai, ngay_xuat, tong_giam_gia, tong_tien_con_lai) value(?, ?, ?, ?, ?, ?)";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,hoaDonDTO.getIdString());
        preparedStatement.setString(2,hoaDonDTO.getId_nhan_vienString());
        preparedStatement.setString(3,hoaDonDTO.getId_khuyen_mai());
        preparedStatement.setString(4,new SimpleDateFormat("yyyy-MM-dd").format(hoaDonDTO.getNgay_xuat()));
        
        preparedStatement.setString(5,Integer.toString(hoaDonDTO.getTong_giam_gia()));
        preparedStatement.setString(6,Integer.toString(hoaDonDTO.getTong_tien_con_lai()));
            System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        JOptionPane.showMessageDialog(null,"Thêm thành công!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi ghi!!!!!!!!1");
            return;
        }  
    }
    void xoa(String maString){
        try{
            String sql="Delete from hoadon where id=?";
            preparedStatement=connection.prepareCall(sql);
            preparedStatement.setString(1,maString);
            preparedStatement.executeUpdate();  
            System.out.println(preparedStatement);
            JOptionPane.showMessageDialog(null,"Xóa thành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi xóa hoa don ");
            
        }
    }
    
    
    
}
