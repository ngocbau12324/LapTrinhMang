/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSocket;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author NGOC BAU
 */
public class demo {
    public static void main(String[] args) {
        String ulr = "https://api.simsimi.net/v2/";
        try {
            Connection.Response response=Jsoup.connect(ulr)
                    .data("text", "Chào buổi sáng!")
                    .data("lc","vn")
                    .method(Connection.Method.GET)
                    .ignoreContentType(true)
                    .execute();
            String simsimi = response.body();
            JsonObject jsonObject= new Gson().fromJson(simsimi,JsonObject.class); 
            System.out.println(jsonObject.get("success").getAsString());
        } catch (IOException ex) {
            Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
