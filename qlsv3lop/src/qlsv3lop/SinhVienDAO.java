/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv3lop;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


/**
 *  
 * @author NGOC BAU
 */
public class SinhVienDAO {
    String user="root";
    String password="";
    String url="jdbc:mysql://localhost:3306/dlsv";
    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;

    public SinhVienDAO() throws SQLException {
        if(conn==null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection(url,user,password);
            }catch(ClassNotFoundException e){
                JOptionPane.showMessageDialog(null,"Ket noi that bai!!!");
            }
        }
    }
    ArrayList docDSSV() throws SQLException, ParseException{
        ArrayList dssv=new ArrayList<SinhVienDTO>();
        try{
            String qry="select * from sinhvien";
            st=conn.createStatement();
            rs=st.executeQuery(qry);
            while(rs.next()){
                SinhVienDTO sv=new SinhVienDTO();
                sv.mssv=rs.getString(1);
                sv.ho=rs.getString(2);
                sv.ten=rs.getString(3);
                sv.gioiTinh=rs.getString(5);
                sv.diaChi=rs.getString(6);
                sv.sdt=rs.getString(8);
                sv.diemTB=Float.parseFloat(rs.getString(9));
                
                sv.ngaySinh=rs.getString(4);
                sv.email=rs.getString(7);
                dssv.add(sv);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi doc thong tin sinh vien");
        }
        return dssv;
    }
    void them(SinhVienDTO sv){
        try{
            String qry="insert into sinhvien Values (";
            qry=qry+"'"+sv.mssv+"'";
            qry=qry+","+"'"+sv.ho+"'";
            qry=qry+","+"'"+sv.ten+"'";
            qry=qry+","+"'"+sv.ngaySinh+"'";
            qry=qry+","+"'"+sv.gioiTinh+"'";
            qry=qry+","+"'"+sv.diaChi+"'";
            qry=qry+","+"'"+sv.email+"'";
            qry=qry+","+"'"+sv.sdt+"'";
            qry=qry+","+""+sv.diemTB+"";
            qry=qry+")";
            System.out.println(qry);
            st=conn.createStatement();
            st.executeUpdate(qry);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi ghi thong tin sinh vien ");
        }
    }
    void xoa(String mssv){
        try{
            String qry="delete from sinhvien where mssv='"+mssv+"'";
            st=conn.createStatement();
            st.executeUpdate(qry);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi xoa thong tin sinh vien");
        }
    }
    void sua(SinhVienDTO sv){
        try{
            String qry="update sinhvien set ho='"+sv.ho+"', ten='"+sv.ten+"', "
                    + "ngaySinh='"+sv.ngaySinh+"', diaChi='"+sv.diaChi+"', "
                    + "email='"+sv.email+"', sdt='"+sv.sdt+"', diem="+sv.diemTB+" "
                    + "where mssv='"+sv.mssv+"'";
            st=conn.createStatement();
            st.executeUpdate(qry);
          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Loi sua thong tin sinh vien");
        }
    }
    
}
