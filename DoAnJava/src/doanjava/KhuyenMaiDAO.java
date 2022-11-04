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
public class KhuyenMaiDAO {
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/java";
    Connection connection = null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet = null;

    public KhuyenMaiDAO() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ket noi that bai!!!");
            }
        }
    }

    ArrayList docDanhSachKhuyenMai() throws ParseException {
        ArrayList danhSachKhuyenMai = new ArrayList<KhuyenMaiDTO>();
        try {
            String sql = "select * from chuongtrinhkhuyenmai";
            preparedStatement = connection.prepareCall(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                KhuyenMaiDTO khuyenMaiDTO = new KhuyenMaiDTO();
                khuyenMaiDTO.setId(resultSet.getString(1));
                khuyenMaiDTO.setTen(resultSet.getString(2));
                khuyenMaiDTO.setPhan_tram(Integer.parseInt(resultSet.getString(3)));
                khuyenMaiDTO.setNgay_bat_dau(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(4)));
                khuyenMaiDTO.setNgay_ket_thuc(new SimpleDateFormat("yyyy-MM-dd").parse(resultSet.getString(5)));
                
                danhSachKhuyenMai.add(khuyenMaiDTO);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi doc.");
        }
        return danhSachKhuyenMai;
    }
    @SuppressWarnings("StringEquality")
    void them(KhuyenMaiDTO khuyenMaiDTO) throws SQLException{
        try{
        String sql="insert into chuongtrinhkhuyenmai(id, ten, phan_tram, ngay_bd, ngay_kt) value(?, ?, ?, ?, ?)";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,khuyenMaiDTO.getId());
        preparedStatement.setString(2,khuyenMaiDTO.getTen());
        preparedStatement.setString(3,Integer.toString(khuyenMaiDTO.getPhan_tram()));
        preparedStatement.setString(4,new SimpleDateFormat("yyyy-MM-dd").format(khuyenMaiDTO.getNgay_bat_dau()));
        preparedStatement.setString(5,new SimpleDateFormat("yyyy-MM-dd").format(khuyenMaiDTO.getNgay_ket_thuc()));
        
            System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        JOptionPane.showMessageDialog(null,"Thêm thành công!!");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi ghi thong tin");
            return;
        }  
    }
    void xoa(String maString){
        try{
            String sql="Delete from chuongtrinhkhuyenmai where id=?";
            preparedStatement=connection.prepareCall(sql);
            preparedStatement.setString(1,maString);
            preparedStatement.executeUpdate();  
            System.out.println(preparedStatement);
            JOptionPane.showMessageDialog(null,"Xóa thành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi xóa");
            
        }
    }
    void sua(KhuyenMaiDTO khuyenMaiDTO) throws SQLException{
        try{
        String sql="update chuongtrinhkhuyenmai set ten=?, ngay_bd=?, ngay_kt=?, phan_tram=? where id=?";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,khuyenMaiDTO.getTen());
        preparedStatement.setString(2,new SimpleDateFormat("yyyy-MM-dd").format(khuyenMaiDTO.getNgay_bat_dau()));
        preparedStatement.setString(3,new SimpleDateFormat("yyyy-MM-dd").format(khuyenMaiDTO.getNgay_ket_thuc()));
        preparedStatement.setString(4,Integer.toString(khuyenMaiDTO.getPhan_tram()));
        preparedStatement.setString(5,khuyenMaiDTO.getId());
        
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        
        JOptionPane.showMessageDialog(null,"Sửa thông tinthành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi sửa thông tin");
        }  
    }
    
}
