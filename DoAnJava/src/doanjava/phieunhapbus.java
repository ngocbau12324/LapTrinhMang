/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doanjava;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class phieunhapbus {
    static List<phieunhapdto> dspn=null;
    public List xem() throws SQLException
    {
    if(dspn==null){
       dspn= new phieunhapdao().xem();
        return dspn;
    }
    else
        
    {
        return dspn;
    }
    
    
    }
    public int them(phieunhapdto pn) throws SQLException
            
    {
        if(dspn==null){dspn=new ArrayList(); dspn.add(pn);
          new phieunhapdao().them(pn);
        
        return 1;  }
    else
            
        {
        
        for(int i=0;i<dspn.size();i++)
        {
        
        if(dspn.get(i).maphieu==pn.maphieu){return 0;}
        }
        dspn.add(pn);
        new phieunhapdao().them(pn);
        return 1;
        }
    }
    public phieunhapdto timkiem(int ma)
    { 
         if(dspn==null){return null;}   
        for(int i=0;i<dspn.size();i++)
        {
        
        if(dspn.get(i).maphieu==ma){return dspn.get(i);}
        
        }
        return null;
    }
}
