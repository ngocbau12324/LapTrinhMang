/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MASOTHUE;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;


/**
 *
 * @author NGOC BAU
 */
public class main {
    public static void main(String[] args) {        
        //https://masothue.com/Search/?q=301245124&type=auto&token=hPRep5qONi
        //String url ="https://masothue.com/Search/?q=301245124&type=auto&token=hPRep5qONi";        
        String info = "Tên: ";
        try {
             String url =Jsoup.connect("https://www.thegioididong.com/laptop?g=laptop-gaming")
                     .followRedirects(true)
                     .execute()
                     .url()
                     .toExternalForm();
             org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
             //System.out.println(doc.getElementsByClass("table-taxinfo"));
             org.jsoup.select.Elements elements= doc.getElementsByClass("listproduct");
//             //if(elements.size()==0);
                Element e=doc.getElementsByClass("listproduct").get(0); 
                 int n=(e.childrenSize());//Số lượng nhánh con của "table-taxinfo"'
                 for(int i=0 ;i<n; i++){
                     //System.out.println(e.child(i).attr("data-price")+"-"+e.child(i).child(0).getElementsByTag("h3").text()+"-"+e.child(i).child(0).attr("data-brand"));
                     System.out.println(e.child(i).child(0).child(1).child(0).attr("data-src"));
                 }
//             info += (e.child(0).child(0).child(0).text())+"\n";
//             
//             int childrenSize=e.child(1).childrenSize();//số lượng nhánh con của child(1)
//             for(int i=0;i<childrenSize;i++){
//                 info += (e.child(1).child(i).child(0).text())+": ";
//                 info += (e.child(1).child(i).child(1).text())+"\n";
//                 if((e.child(1).child(i).child(0).text()).equals("Tình trạng")) break;
//             }
             //System.out.println(e);                                          
        } catch (IOException ex) {
            System.out.println("LOI");
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
}
