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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author NGOC BAU
 */
public class TheLoaiDAO {
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/java";
    Connection connection = null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet = null;
    public TheLoaiDAO() throws ClassNotFoundException, SQLException{
        if(connection==null){
            try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=(Connection)DriverManager.getConnection(url, user, password);
            }catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ket noi that bai!!!");
            }
        }
    }
    ArrayList docDanhSachTheLoai() throws ParseException {
        ArrayList danhSachTheloai = new ArrayList<TheLoaiDTO>();
        try {
            String sql = "select * from theloai";
            preparedStatement = connection.prepareCall(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TheLoaiDTO theLoaiDTO = new TheLoaiDTO();
                theLoaiDTO.setMaTheLoaiString(resultSet.getString(1));
                theLoaiDTO.setTenTheLoaiString(resultSet.getString(2));            
                danhSachTheloai.add(theLoaiDTO);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi doc thong tin theer loaij san pham");
        }
        return danhSachTheloai;
    }
    void them(TheLoaiDTO theLoaiDTO) throws SQLException{
        String sql="insert into theloai value (?, ?)";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,theLoaiDTO.getMaTheLoaiString());
        preparedStatement.setString(2,theLoaiDTO.getTenTheLoaiString());
        preparedStatement.executeUpdate();
    }
    void xoa(String ma) throws SQLException{
        
        String sqlString="delete from theloai where id="+ma;
        preparedStatement=connection.prepareCall(sqlString);
        preparedStatement.executeUpdate();
        
    }
    void sua(TheLoaiDTO theLoaiDTO) throws SQLException{
        try{
        String sqlString="update theloai set ten_the_loai=? where id=?";
        preparedStatement=connection.prepareCall(sqlString);
        preparedStatement.setString(2,theLoaiDTO.getMaTheLoaiString());
        preparedStatement.setString(1,theLoaiDTO.getTenTheLoaiString());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        JOptionPane.showMessageDialog(null,"Sửa thông tin khách hàng thành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi sửa thông tin khách hàng ");
        } 
                
    }
     ArrayList<TheLoaiDTO> timkiemTen(String ten) throws SQLException{
        ArrayList danhsachArrayList=new ArrayList<TheLoaiDTO>();
        String sqlString="select * from theloai where ten_the_loai like '%"+ten+"%'";
        preparedStatement=connection.prepareCall(sqlString);
        System.out.println(sqlString);
        resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            TheLoaiDTO theLoaiDTO=new TheLoaiDTO();
            theLoaiDTO.setMaTheLoaiString(resultSet.getString(1));
            theLoaiDTO.setTenTheLoaiString(resultSet.getString(2));
            danhsachArrayList.add(theLoaiDTO);
        }
        return danhsachArrayList;
    }
    TheLoaiDTO thongTinTheLoai(String ma) throws SQLException{
        TheLoaiDTO theLoaiDTO=new TheLoaiDTO();
        String sql="select * from theloai where id="+ma;
        preparedStatement=connection.prepareCall(sql);
        System.out.println(sql);
        resultSet=preparedStatement.executeQuery();
        System.out.println(resultSet.toString());
        theLoaiDTO.setMaTheLoaiString(resultSet.getString(1));
        theLoaiDTO.setTenTheLoaiString(resultSet.getString(2));
        System.out.println(theLoaiDTO.toString());
        return theLoaiDTO;
    }
}
