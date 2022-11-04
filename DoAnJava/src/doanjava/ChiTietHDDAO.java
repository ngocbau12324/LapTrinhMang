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
public class ChiTietHDDAO {
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/java";
    Connection connection = null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet = null;

    public ChiTietHDDAO() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ket noi that bai!!!");
            }
        }
    }

    ArrayList docDanhSachChiTietHD() throws ParseException {
        ArrayList danhSachChiTietHD = new ArrayList<ChiTietHDDTO>();
        try {
            String sql = "select * from chitiethoadon";
            preparedStatement = connection.prepareCall(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ChiTietHDDTO chiTietHDDTO= new ChiTietHDDTO();
                chiTietHDDTO.setId_hoa_donString(resultSet.getString(1));
                chiTietHDDTO.setId_san_pham(resultSet.getString(2));
                chiTietHDDTO.setSo_luong(Integer.parseInt(resultSet.getString(3)));
                chiTietHDDTO.setDon_gia(Integer.parseInt(resultSet.getString(4)));
                chiTietHDDTO.setThanh_tien(Integer.parseInt(resultSet.getString(5)));
                danhSachChiTietHD.add(chiTietHDDTO);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi doc thong tin");
        }
        return danhSachChiTietHD;
    }
    ArrayList docDanhSachChiTietHDByIdHD(String id) throws ParseException {
        ArrayList danhSachChiTietHD = new ArrayList<ChiTietHDDTO>();
        try {
            String sql = "select * from chitiethoadon where id_hoa_don="+id;
            preparedStatement = connection.prepareCall(sql);
            System.out.println(preparedStatement);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ChiTietHDDTO chiTietHDDTO= new ChiTietHDDTO();
                chiTietHDDTO.setId_hoa_donString(resultSet.getString(1));
                chiTietHDDTO.setId_san_pham(resultSet.getString(2));
                chiTietHDDTO.setSo_luong(Integer.parseInt(resultSet.getString(3)));
                chiTietHDDTO.setDon_gia(Integer.parseInt(resultSet.getString(4)));
                chiTietHDDTO.setThanh_tien(Integer.parseInt(resultSet.getString(5)));
                danhSachChiTietHD.add(chiTietHDDTO);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi doc thong tin");
        }
        return danhSachChiTietHD;
    }
    @SuppressWarnings("StringEquality")
    void them(ChiTietHDDTO chiTietHDDTO) throws SQLException{
        try{
        String sql="insert into chitiethoadon(id_hoa_don, id_san_pham, so_luong, don_gia, thanh_tien) value(?, ?, ?, ?, ?)";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,chiTietHDDTO.getId_hoa_donString());
        preparedStatement.setString(2,chiTietHDDTO.getId_san_pham());
        preparedStatement.setString(3,Integer.toString(chiTietHDDTO.getSo_luong()));
        preparedStatement.setString(4,Integer.toString(chiTietHDDTO.getDon_gia()));
        preparedStatement.setString(5,Integer.toString(chiTietHDDTO.getThanh_tien()));
        
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi ghi");
            
        }  
    }
}
