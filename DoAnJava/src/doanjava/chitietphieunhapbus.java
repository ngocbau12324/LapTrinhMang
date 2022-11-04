/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class chitietphieunhapbus {
 public static  List<chitietphieunhapdto>  dsctpn  =null ;
 
 public List loaddata() throws SQLException
 {  
    
   
    if(dsctpn==null){
       dsctpn= new chitietphieunhapdao().xem();
        return dsctpn;
    }
    else
        
    {
        return dsctpn;
    }
    
    
    }
         
 public int them(chitietphieunhapdto ctpnt)
 {
    
     if(dsctpn!=null){
         
         for(int i=0;i<dsctpn.size();i++)
         {
             if(dsctpn.get(i).maphieu==ctpnt.maphieu)
             {   return 0;
            
             }
             
         }
         dsctpn.add(ctpnt);
         new chitietphieunhapdao().them(ctpnt);
         return 1;
     }
     else{
         dsctpn=new ArrayList<>();
        try{ dsctpn.add(ctpnt);}
        catch(Exception e)
        {
            System.out.print("k add dc");
        }
     new chitietphieunhapdao().them(ctpnt);
     return 1;
     }
    
  }
 public chitietphieunhapdto timkiem(int ma)
 {
 
 if(dsctpn==null){return null;}
 for(int i=0;i<dsctpn.size();i++)
     
 {
 
 if(dsctpn.get(i).maphieu==ma)
 {
     return dsctpn.get(i);
 }
 }
 return null;
 }
 
 
 
 }
    

