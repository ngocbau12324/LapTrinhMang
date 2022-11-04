/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thoitiet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 *
 * @author phanh
 */
public class ThoiTiet {
    URL url;
     HttpURLConnection con;
      static String json ;
    //từ trang : https://www.baeldung.com/java-http-request
    public ThoiTiet(){
        
    }
    public void connect(String str) throws MalformedURLException, IOException{
        url=new URL(str);
        con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
       
    }
    public void reponse() throws IOException{
        int status = con.getResponseCode();
       
        Reader streamReader =null;
        if(status>299){
            streamReader =new InputStreamReader(con.getErrorStream());
            
        }else{
            streamReader =new InputStreamReader(con.getInputStream());
        }
        System.out.println("C:Response status is :"+status);
       // System.out.println(streamReader);
        
        BufferedReader in =new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content =new StringBuffer();
        while((inputLine=in.readLine())!=null){
            content.append(inputLine);
            
             
        }
        JsonObject jsonObject = new Gson().fromJson(content.toString(),JsonObject.class);
        JsonArray arrayThoiTiet = jsonObject.get("list").getAsJsonArray();
        int lt=arrayThoiTiet.size();
        for (int i = 0; i < lt; ++i) {
            JsonObject rec = (JsonObject) arrayThoiTiet.get(i);
            
            JsonArray A = rec.get("weather").getAsJsonArray();
            JsonObject recdes=(JsonObject)A.get(0);
            System.out.println(rec.get("dt_txt")+"->"+recdes.get("description"));
            
        }
        System.out.println();
        in.close();
        
    }
    
    public void disconnect(){
        con.disconnect();
    }
    public String traCuuThoiTiet(String city){
        String kq="";
        try {
            url=new URL("https://api.openweathermap.org/data/2.5/forecast?q="+city+"&units=metric&lang=vi&appid=d98e5e56ad30dfa428b2c9fda6bb3227");
            con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            
            int status = con.getResponseCode();
       
        Reader streamReader =null;
        if(status>299){
            streamReader =new InputStreamReader(con.getErrorStream());
            
        }else{
            streamReader =new InputStreamReader(con.getInputStream());
        }
        System.out.println("C:Response status is :"+status);
       // System.out.println(streamReader);
        
        BufferedReader in =new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content =new StringBuffer();
        while((inputLine=in.readLine())!=null){
            content.append(inputLine);                         
        }
        JsonObject jsonObject = new Gson().fromJson(content.toString(),JsonObject.class);
        String name =jsonObject.getAsJsonObject("city").get("name").getAsString();
        kq = "Thời tiết "+name+" hôm nay và 5 ngày tới\n";
        JsonArray arrayThoiTiet = jsonObject.get("list").getAsJsonArray();
        int lt=arrayThoiTiet.size();
        for (int i = 0; i < lt; ++i) {
            JsonObject rec = (JsonObject) arrayThoiTiet.get(i);
            kq += rec.get("dt_txt").getAsString()+"\n";  
            kq += "  "+rec.getAsJsonObject("main").get("temp").getAsString()+"'C, ";
            kq +="Tốc độ gió "+rec.getAsJsonObject("wind").get("speed").getAsString()+ "m/s\n";
            kq +="  Độ ẩm "+rec.getAsJsonObject("main").get("humidity").getAsString()+"%, ";
            JsonArray A = rec.get("weather").getAsJsonArray();            
            JsonObject recdes=(JsonObject)A.get(0);
            kq += "Trời có "+recdes.get("description").getAsString()+"\n";
            //System.out.println(rec.get("dt_txt")+"->"+recdes.get("description"));
            
        }        
        in.close();
        } catch (Exception e) {
            //e.printStackTrace();
            kq = "Không tìm thấy địa danh";
        } finally{
            con.disconnect();
        }
        return kq;
    }
    public static void main(String[] args) throws Exception{
        ThoiTiet weather =new ThoiTiet();
        System.out.println(weather.traCuuThoiTiet("Nha Trang"));
//        weather.connect("https://api.openweathermap.org/data/2.5/forecast?q=dgdg&units=metric&lang=vi&appid=d98e5e56ad30dfa428b2c9fda6bb3227");
//        weather.reponse();

    }
}