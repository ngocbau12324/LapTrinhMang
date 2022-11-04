/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IQAIR;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.jdi.connect.spi.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author NGOC BAU
 */
public class test {
    public static void main(String[] args) {
        String result="";    
        String apiKey = "0cc59bc3-2b42-4168-bd25-0df351e8b213";
        String url ="http://api.airvisual.com/v2/city?city=Los Angeles&state=California&country=USA&key="+apiKey;
        try {
             org.jsoup.Connection.Response respone = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .method(org.jsoup.Connection.Method.GET)
                    .execute();
            String doc = respone.body();
            JsonObject json= new Gson().fromJson(doc,JsonObject.class); 
            System.out.println(json.getAsJsonObject("data").getAsJsonObject("current").getAsJsonObject("pollution").get("aqius").getAsString());
            System.out.println(result);
        }catch(Exception e){
            e.printStackTrace();
    }
    
}
}
