/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author NGOC BAU
 */
public class demoCal {
    public static void main(String[] args) {           
    String infor = "";        
        String domain = "https://web2.0calc.com/calc";
        try{                
        Connection.Response respone = Jsoup.connect(domain)
                .data("in[]","5/2-2*4+6")
                .data("trig","deg")
                .data("p","0")
                .data("s","0")                               
                .ignoreContentType(true)
                .method(Connection.Method.POST)
                .execute();
        org.jsoup.nodes.Document XemDiemPage = respone.parse();
        String data = XemDiemPage.body().text();
        JsonObject jsonData=new Gson().fromJson(data, JsonObject.class);              
        System.out.println(jsonData.getAsJsonArray("results").get(0).getAsJsonObject().get("out").getAsString());            
        }catch(IOException e){
            System.err.println(e);
        }
    }
}
