/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

import static java.lang.constant.ConstantDescs.NULL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author NGOC BAU
 */
public class KhachHangDAO {

    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/java";
    Connection connection = null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet = null;

    public KhachHangDAO() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ket noi that bai!!!");
            }
        }
    }

    ArrayList docDanhSachKhachHang() throws ParseException {
        ArrayList danhSachKhachHang = new ArrayList<KhachHangDTO>();
        try {
            String sql = "select * from khachhang";
            preparedStatement = connection.prepareCall(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                KhachHangDTO khachHangDTO = new KhachHangDTO();
                khachHangDTO.setMaKhachHang(resultSet.getString(1));
                khachHangDTO.setHo(resultSet.getString(2));
                khachHangDTO.setTen(resultSet.getString(3));
                khachHangDTO.setNgaySinhDate(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(4)));
                khachHangDTO.setDiaChiString(resultSet.getString(5));
                khachHangDTO.setEmail(resultSet.getString(7));
                khachHangDTO.setSoDienThoai(resultSet.getString(6));
                danhSachKhachHang.add(khachHangDTO);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi doc thong tin sinh vien");
        }
        return danhSachKhachHang;
    }
    @SuppressWarnings("StringEquality")
    void them(KhachHangDTO khachHangDTO) throws SQLException{
        try{
        String sql="insert into khachhang(id, ho, ten, ngay_sinh, dia_chi, phone, email) value(?, ?, ?, ?, ?, ?, ?)";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,khachHangDTO.getMaKhachHang());
        preparedStatement.setString(2,khachHangDTO.getHo());
        preparedStatement.setString(3,khachHangDTO.getTen());
        preparedStatement.setString(4,new SimpleDateFormat("yyyy-MM-dd").format(khachHangDTO.getNgaySinhDate()));
        preparedStatement.setString(5,khachHangDTO.getDiaChiString());
        preparedStatement.setString(6,khachHangDTO.getSoDienThoai());
        preparedStatement.setString(7,khachHangDTO.getEmail());
            System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        JOptionPane.showMessageDialog(null,"Thêm thành công!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi ghi thong tin khach hang ");
            return;
        }  
    }
    void xoa(String maString){
        try{
            String sql="Delete from khachhang where id=?";
            preparedStatement=connection.prepareCall(sql);
            preparedStatement.setString(1,maString);
            preparedStatement.executeUpdate();  
            System.out.println(preparedStatement);
            JOptionPane.showMessageDialog(null,"Xóa thành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi xóa thông tin khách hàng ");
            
        }
    }
    void sua(KhachHangDTO khachHangDTO) throws SQLException{
        try{
        String sql="update khachhang set ho=?, ten=?, ngay_sinh=?, dia_chi=?, phone=?, email=? where id=?";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,khachHangDTO.getHo());
        preparedStatement.setString(2,khachHangDTO.getTen());
        preparedStatement.setString(3,new SimpleDateFormat("yyyy-MM-dd").format(khachHangDTO.getNgaySinhDate()));
        preparedStatement.setString(4,khachHangDTO.getDiaChiString());
        preparedStatement.setString(5,khachHangDTO.getSoDienThoai());
        preparedStatement.setString(6,khachHangDTO.getEmail());
        preparedStatement.setString(7,khachHangDTO.getMaKhachHang());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Sửa thông tin khách hàng thành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi sửa thông tin khách hàng ");
        }  
    }
    ArrayList<KhachHangDTO> timkiemTen(String ten) throws SQLException, ParseException{
        ArrayList danhsachArrayList=new ArrayList<KhachHangDTO>();
        String sqlString="select * from khachhang where ten like '%"+ten+"%'";
        preparedStatement=connection.prepareCall(sqlString);
        System.out.println(sqlString);
        resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            KhachHangDTO khachHangDTO=new KhachHangDTO();
            khachHangDTO.setMaKhachHang(resultSet.getString(1));
            khachHangDTO.setHo(resultSet.getString(2));
            khachHangDTO.setTen(resultSet.getString(3));
            khachHangDTO.setNgaySinhDate(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(4)));
            khachHangDTO.setDiaChiString(resultSet.getString(5));
            khachHangDTO.setSoDienThoai(resultSet.getString(6));
            khachHangDTO.setEmail(resultSet.getString(7));
            danhsachArrayList.add(khachHangDTO);
        }
        return danhsachArrayList;
    }
    ArrayList<KhachHangDTO> timkiemSdt(String sdt) throws SQLException, ParseException{
        ArrayList danhsachArrayList=new ArrayList<KhachHangDTO>();
        String sqlString="select * from khachhang where phone like '%"+sdt+"%'";
        preparedStatement=connection.prepareCall(sqlString);
        System.out.println(sqlString);
        resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            KhachHangDTO khachHangDTO=new KhachHangDTO();
            khachHangDTO.setMaKhachHang(resultSet.getString(1));
            khachHangDTO.setHo(resultSet.getString(2));
            khachHangDTO.setTen(resultSet.getString(3));
            khachHangDTO.setNgaySinhDate(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(4)));
            khachHangDTO.setDiaChiString(resultSet.getString(5));
            khachHangDTO.setSoDienThoai(resultSet.getString(6));
            khachHangDTO.setEmail(resultSet.getString(7));
            danhsachArrayList.add(khachHangDTO);
        }
        return danhsachArrayList;
    }
}
