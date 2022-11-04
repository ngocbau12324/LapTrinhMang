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
import java.util.Vector;

/**
 *
 * @author admin
 */
public class chitietphieunhapdao {
    
     public List xem() throws SQLException
    {
        List lpn=new ArrayList();
       String sql="select * from chitietphieunhap";  
    ResultSet rs= new connect().taoketnoi().executeQuery(sql);
    
    while(rs.next())
    {
        chitietphieunhapdto pn=new chitietphieunhapdto();
        pn.maphieu=rs.getInt(1);
        pn.masp=rs.getInt(2);
        pn.dongia=rs.getInt(3);
        pn.soluong=rs.getInt(4);
        pn.thanhtien=rs.getInt(5);
    lpn.add(pn);
    
   
    }
    return lpn;
    }
    
    public void them(chitietphieunhapdto ct)
    { String sql="INSERT INTO `chitietphieunhap`(`id_phieu_nhap`, `id_san_pham`, `so_luong`, `don_gia`, `thanh_tien`) VALUES ("
            +ct.maphieu+","+ct.masp+","+ct.dongia+","+ct.soluong+","+ct.thanhtien+")";
    
        try{
     new connect().taoketnoi().execute(sql);
        }
        catch(Exception e)
        {
        System.err.print(e);
        }
        
    }
    }
    
    
