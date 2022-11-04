/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipLookup;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author NGOC BAU
 */
public class ip {
    
public String ipLookUp(String ip){
    String result="";
    String url = "http://ip-api.com/json/" + ip + "?fields=status,message,continent,country,city,lat,lon";
        try {
            Connection.Response respone = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .method(Connection.Method.GET)
                    .execute();
            String doc = respone.body();
            JsonObject json= new Gson().fromJson(doc,JsonObject.class); 
            String status = json.get("status").toString();
        if(status.equals("\"fail\"")){            
            String message =json.get("message").toString();
            if(message.equals("\"private range\"")) return "Private IP. Không thể tìm!";
            if(message.equals("\"reserved range\"")) return "Reserved IP addresses. Không thể tìm!";
            return "IP không hợp lệ.";
        }                                
        result ="IP: "+ip+"\n";
        result +="Vĩ độ: "+json.get("lat").toString()+"\n";
        result +="Kinh Độ: "+json.get("lon").toString()+"\n";
        result +="Thành phố: "+json.get("city").toString()+"\n";
        result +="Quốc gia: "+json.get("country").toString()+"\n";
        result +="Châu lục: "+json.get("continent").toString();        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
}
    public static void main(String[] args) {
        String ip = "nguyen nognc bau";
        ip ipp = new ip();
        System.out.println(ipp.ipLookUp(ip));

    }
}
