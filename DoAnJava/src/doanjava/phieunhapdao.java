/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class phieunhapdao {
    
    
    public List xem() throws SQLException
    {
        List lpn=new ArrayList();
       String sql="select * from phieunhap";  
    ResultSet rs= new connect().taoketnoi().executeQuery(sql);
    
    while(rs.next())
    {
        phieunhapdto pn=new phieunhapdto();
        pn.maphieu=rs.getInt(1);
        pn.manv=rs.getInt(2);
        pn.mancc=rs.getInt(3);
        pn.tongtien=rs.getDouble(4);
        pn.ngaynhap=rs.getString(5);
    lpn.add(pn);
   
    }
    return lpn;
    }
    
    public void them(phieunhapdto pn) throws SQLException
    {
    
    String sql="INSERT INTO `phieunhap`(`id`, `id_nhan_vien`, `id_nha_cc`, `tong_tien`, `ngay_nhap`) VALUES ("
            +pn.maphieu+","+pn.manv+","+pn.mancc+","+pn.tongtien+", '"+pn.ngaynhap+"' )";
   System.out.print(sql);
    boolean a= new connect().taoketnoi().execute(sql);
      return;
    }
    
}
