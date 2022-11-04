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

/**
 *
 * @author NGOC BAU
 */
public class NhaCungCapDAO {
    String user = "root";
    String password = "";
    String url = "jdbc:mysql://localhost:3306/java";
    Connection connection = null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet = null;
    public NhaCungCapDAO() throws ClassNotFoundException, SQLException{
        if(connection==null){
            try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=(Connection)DriverManager.getConnection(url, user, password);
            }catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Ket noi that bai!!!");
            }
        }
    }
    ArrayList docDanhSachNhaCungCap() throws ParseException {
        ArrayList danhsachNhaCungCap = new ArrayList<NhaCUngCapDTO>();
        try {
            String sql = "select * from nhacungcap";
            preparedStatement = connection.prepareCall(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                NhaCUngCapDTO nhaCUngCapDTO = new NhaCUngCapDTO();
                nhaCUngCapDTO.setId(resultSet.getString(1));
                nhaCUngCapDTO.setTen_nha_cc(resultSet.getString(2));            
                danhsachNhaCungCap.add(nhaCUngCapDTO);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi doc thong tin theer loaij san pham");
        }
        return danhsachNhaCungCap;
    }
    void them(NhaCUngCapDTO nhaCUngCapDTO) throws SQLException{
        String sql="insert into nhacungcap value (?, ?)";
        preparedStatement=connection.prepareCall(sql);
        preparedStatement.setString(1,nhaCUngCapDTO.getId());
        preparedStatement.setString(2,nhaCUngCapDTO.getTen_nha_cc());
        preparedStatement.executeUpdate();
    }
    void xoa(String ma) throws SQLException{
        
        String sqlString="delete from nhacungcap where id="+ma;
        preparedStatement=connection.prepareCall(sqlString);
        preparedStatement.executeUpdate();
        
    }
    void sua(NhaCUngCapDTO nhaCUngCapDTO) throws SQLException{
        try{
        String sqlString="update nhacungcap set ten_nha_cc=? where id=?";
        preparedStatement=connection.prepareCall(sqlString);
        preparedStatement.setString(2,nhaCUngCapDTO.getId());
        preparedStatement.setString(1,nhaCUngCapDTO.getTen_nha_cc());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        JOptionPane.showMessageDialog(null,"Sửa thông tin khách hàng thành công");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Lỗi sửa thông tin  ");
        } 
                
    }
}
