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
public class SanPhamDAO {
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/java";
    Connection connection = null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet = null;

    public SanPhamDAO() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ket noi that bai!!!");
            }
        }
    }

    ArrayList docDanhSachSanPham() throws ParseException {
        ArrayList danhSachSanPham = new ArrayList<KhachHangDTO>();
        try {
            String sql = "select * from sanpham";
            preparedStatement = connection.prepareCall(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                SanPhamDTO sanPhamDTO = new SanPhamDTO();
                sanPhamDTO.setMaSanPham(resultSet.getString(1));
                sanPhamDTO.setTenSanPham(resultSet.getString(2));
                sanPhamDTO.setDonGia(Integer.parseInt(resultSet.getString(3)));
                sanPhamDTO.setSoLuong(Integer.parseInt(resultSet.getString(4)));
                sanPhamDTO.setBaoHanh(Integer.parseInt(resultSet.getString(5)));
                sanPhamDTO.setMaTheLoai(resultSet.getString(6));
                sanPhamDTO.setMaNhaCungCap(resultSet.getString(7));
                danhSachSanPham.add(sanPhamDTO);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi doc thong tin san pham");
        }
        return danhSachSanPham;
    }
    @SuppressWarnings("StringEquality")
    void them(SanPhamDTO sanPhamDTO) throws SQLException{
        try{
        String sql="insert into sanpham(id, ten_san_pham, don_gia, so_luong, bao_hanh, id_the_loai, id_nha_cc) value(?, ?, ?, ?, ?, ?, ?)";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,sanPhamDTO.getMaSanPham());
        preparedStatement.setString(2,sanPhamDTO.getTenSanPham());
        preparedStatement.setString(3,Integer.toString(sanPhamDTO.getDonGia()));
        preparedStatement.setString(4,Integer.toString(sanPhamDTO.getSoLuong()));
        preparedStatement.setString(5,Integer.toString(sanPhamDTO.getBaoHanh()));
        preparedStatement.setString(6,sanPhamDTO.getMaTheLoai());
        preparedStatement.setString(7,sanPhamDTO.getMaNhaCungCap());
            System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        JOptionPane.showMessageDialog(null,"Thêm thành công!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi ghi thong tin san pham ");
            return;
        }  
    }
    void xoa(String maString){
        try{
            String sql="Delete from sanpham where id=?";
            preparedStatement=connection.prepareCall(sql);
            preparedStatement.setString(1,maString);
            preparedStatement.executeUpdate();  
            System.out.println(preparedStatement);
            JOptionPane.showMessageDialog(null,"Xóa thành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi xóa san pham ");
            
        }
    }
    void sua(SanPhamDTO sanPhamDTO) throws SQLException{
        try{
        String sql="update sanpham set ten_san_pham=?, don_gia=?, so_luong=?, bao_hanh=?, id_the_loai=? ,id_nha_cc=? where id=?";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,sanPhamDTO.getTenSanPham());
        preparedStatement.setString(2,Integer.toString(sanPhamDTO.getDonGia()));
        preparedStatement.setString(3,Integer.toString(sanPhamDTO.getSoLuong()));
        preparedStatement.setString(4,Integer.toString(sanPhamDTO.getBaoHanh()));
        preparedStatement.setString(5,sanPhamDTO.getMaTheLoai());
        preparedStatement.setString(6,sanPhamDTO.getMaNhaCungCap());
        preparedStatement.setString(7,sanPhamDTO.getMaSanPham());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Sửa thông tin san pham thành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi sửa thông tin san pham ");
        }  
    }
    ArrayList<SanPhamDTO> timkiemTen(String ten) throws SQLException{
        ArrayList danhsachArrayList=new ArrayList<SanPhamDTO>();
        String sqlString="select * from sanpham where ten_san_pham like '%"+ten+"%'";
        preparedStatement=connection.prepareCall(sqlString);
        System.out.println(sqlString);
        resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            SanPhamDTO sanPhamDTO=new SanPhamDTO();
            sanPhamDTO.setMaSanPham(resultSet.getString(1));
            sanPhamDTO.setTenSanPham(resultSet.getString(2));
            sanPhamDTO.setDonGia(Integer.parseInt(resultSet.getString(3)));
            sanPhamDTO.setSoLuong(Integer.parseInt(resultSet.getString(4)));
            sanPhamDTO.setBaoHanh(Integer.parseInt(resultSet.getString(5)));
            sanPhamDTO.setMaTheLoai(resultSet.getString(6));
            sanPhamDTO.setMaNhaCungCap(resultSet.getString(7));
            danhsachArrayList.add(sanPhamDTO);
        }
        return danhsachArrayList;
    }
    SanPhamDTO thongTinSanPham(String ma) throws SQLException{
        SanPhamDTO spdto=new SanPhamDTO();
        String sqlString="selec * from sanpham where id="+ma;
        preparedStatement=connection.prepareCall(sqlString);
        resultSet=preparedStatement.executeQuery();
        spdto.setMaSanPham(resultSet.getString(1));
        spdto.setTenSanPham(resultSet.getString(2));
        spdto.setDonGia(Integer.parseInt(resultSet.getString(3)));
        spdto.setSoLuong(Integer.parseInt(resultSet.getString(4)));
        spdto.setBaoHanh(Integer.parseInt(resultSet.getString(5)));
        spdto.setMaTheLoai(resultSet.getString(6));
        spdto.setMaNhaCungCap(resultSet.getString(7));
        return spdto;
    }
    
    
    
}
