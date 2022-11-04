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
public class NhanVienDAO {
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/java";
    Connection connection = null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet = null;

    public NhanVienDAO() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ket noi that bai!!!");
            }
        }
    }
    
    ArrayList docDanhSachNhanVien() throws ParseException {
        ArrayList<NhanVienDTO> danhSachNhanVien = new ArrayList<NhanVienDTO>();
        try {
        
        
            String sql = "select * from nhanvien";
            preparedStatement = connection.prepareCall(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhanVienDTO nhanVienDTO = new NhanVienDTO();
                nhanVienDTO.setMaNhanVien(resultSet.getString(1));
                nhanVienDTO.setHo(resultSet.getString(2));
                nhanVienDTO.setTen(resultSet.getString(3));
                nhanVienDTO.setGioitinh(resultSet.getString(4));
                nhanVienDTO.setNgaysinh(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(5)));
                nhanVienDTO.setSdt(resultSet.getString(6));
                nhanVienDTO.setDiachi(resultSet.getString(7));
                danhSachNhanVien.add(nhanVienDTO);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi doc thong tin nhan vien");
        }
        return danhSachNhanVien;
    }
          @SuppressWarnings("StringEquality")
        void them(NhanVienDTO nhanVienDTO) throws SQLException{
        try{
        String sql="insert into nhanvien(id, ho, ten, gioi_tinh, ngay_sinh, phone, dia_chi) value(?, ?, ?, ?, ?, ?, ?)";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,nhanVienDTO.getMaNhanVien());
        preparedStatement.setString(2,nhanVienDTO.getHo());
        preparedStatement.setString(3,nhanVienDTO.getTen());
        preparedStatement.setString(4,nhanVienDTO.getGioitinh());
        preparedStatement.setString(5,new SimpleDateFormat("yyyy-MM-dd").format(nhanVienDTO.getNgaysinh()));
        preparedStatement.setString(6,nhanVienDTO.getSdt());
        preparedStatement.setString(7,nhanVienDTO.getDiachi());
            System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        JOptionPane.showMessageDialog(null,"Thêm thành công!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi ghi thong tin nhan vien ");
            return;
        }  
    }
    void xoa(String maString){
        try{
            String sql="Delete from nhanvien where id=?";
            preparedStatement=connection.prepareCall(sql);
            preparedStatement.setString(1,maString);
            preparedStatement.executeUpdate();  
            System.out.println(preparedStatement);
            JOptionPane.showMessageDialog(null,"Xóa thành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi xóa thông tin nhanvien ");
            
        }
    }
    void sua(NhanVienDTO nhanVienDTO) throws SQLException{
        try{
        String sql="update nhanvien set ho=?, ten=?,gioi_tinh=?, ngay_sinh=?, dia_chi=?, phone=?  where id=?";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,nhanVienDTO.getHo());
        preparedStatement.setString(2,nhanVienDTO.getTen());
        preparedStatement.setString(3,nhanVienDTO.getGioitinh());
        preparedStatement.setString(4,new SimpleDateFormat("yyyy-MM-dd").format(nhanVienDTO.getNgaysinh()));
        preparedStatement.setString(5,nhanVienDTO.getDiachi());
        preparedStatement.setString(6,nhanVienDTO.getSdt());
        preparedStatement.setString(7,nhanVienDTO.getMaNhanVien());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Sửa thông tin nhân viên thành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi sửa thông tin");
        }  
    }
           
   ArrayList<NhanVienDTO> timkiemTen(String ten) throws SQLException, ParseException{
        ArrayList danhsachArrayList=new ArrayList<NhanVienDTO>();
        String sqlString="select * from nhanvien where ten like '%"+ten+"%'";
        preparedStatement=connection.prepareCall(sqlString);
        System.out.println(sqlString);
        resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            NhanVienDTO nhanVienDTO=new NhanVienDTO();
            nhanVienDTO.setMaNhanVien(resultSet.getString(1));
            nhanVienDTO.setHo(resultSet.getString(2));
            nhanVienDTO.setTen(resultSet.getString(3));
            nhanVienDTO.setGioitinh(resultSet.getString(4));
            nhanVienDTO.setNgaysinh(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(5)));     
            nhanVienDTO.setSdt(resultSet.getString(6));
             nhanVienDTO.setDiachi(resultSet.getString(7));
  
            danhsachArrayList.add(nhanVienDTO);
        }
        return danhsachArrayList;
    }
      ArrayList<NhanVienDTO> timkiemSdt(String sdt) throws SQLException, ParseException{
        ArrayList danhsachArrayList=new ArrayList<NhanVienDTO>();
        String sqlString="select * from nhanvien where phone like '%"+sdt+"%'";
        preparedStatement=connection.prepareCall(sqlString);
        System.out.println(sqlString);
        resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            NhanVienDTO nhanVienDTO=new NhanVienDTO();
            nhanVienDTO.setMaNhanVien(resultSet.getString(1));
            nhanVienDTO.setHo(resultSet.getString(2));
            nhanVienDTO.setTen(resultSet.getString(3));
            nhanVienDTO.setGioitinh(resultSet.getString(4));
            nhanVienDTO.setNgaysinh(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(5)));
            nhanVienDTO.setSdt(resultSet.getString(6));
            nhanVienDTO.setDiachi(resultSet.getString(7));
            danhsachArrayList.add(nhanVienDTO);
        }
        return danhsachArrayList;
    }
}
