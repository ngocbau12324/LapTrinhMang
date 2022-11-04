package IQAIR;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.StringTokenizer;
import org.jsoup.Jsoup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class server {
    public static int buffersize = 512;
    public static int port = 1234;
    public static void main(String[] args) {
        DatagramSocket socket;
        DatagramPacket dpSend, dpReceive;
        try{
            socket = new DatagramSocket(port);
            while(true){
                dpReceive = new DatagramPacket(new byte[buffersize],buffersize);
                socket.receive(dpReceive);
                String tmp = new String(dpReceive.getData(),0,dpReceive.getLength());
                System.out.println("Server receive "+tmp+" from client "+dpReceive.getAddress()+
                        " port number "+dpReceive.getPort());
                if(tmp.equals("bye")){
                    System.out.println("Server socket closed.");
                    socket.close();
                    break;
                }
                //send back
                tmp = returnResult(tmp);
                dpSend = new DatagramPacket(tmp.getBytes(),tmp.getBytes().length,dpReceive.getAddress(),dpReceive.getPort());
                socket.send(dpSend);
                System.out.println("Server send  back: "+new String(dpSend.getData(),0,dpSend.getLength()));
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    public static String returnResult(String str ){        
        if(str.equalsIgnoreCase("hello"))
            return showListCountries();
        if(str.contains(";")){
            StringTokenizer stringTokenizer = new StringTokenizer(str,";");
            //coutry;state
            if(stringTokenizer.countTokens()==2){
                String country = stringTokenizer.nextToken();
                String state = stringTokenizer.nextToken();
                return showListCities(state, country);
            }
            //coutry;state;city
            if(stringTokenizer.countTokens()==3){
                String country = stringTokenizer.nextToken();
                String state = stringTokenizer.nextToken();
                String city = stringTokenizer.nextToken();
                return getAQI(city, state, country);
            }
        }
        //Khi client nhập coutry(TÊn quốc gia)
        return showListStates(str);        
    }
    public static String showListCountries(){
        String listCountries="";    
        String apiKey = "0cc59bc3-2b42-4168-bd25-0df351e8b213";
        String url ="http://api.airvisual.com/v2/countries?key="+apiKey;
        try {
             org.jsoup.Connection.Response respone = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .method(org.jsoup.Connection.Method.GET)
                    .execute();
            String doc = respone.body();
            JsonObject json= new Gson().fromJson(doc,JsonObject.class); 
            int numberOfListCountry = json.getAsJsonArray("data").size();
            for(int i=0;i<numberOfListCountry;i++){
                listCountries +=(i+1)+". "+(json.getAsJsonArray("data").get(i).getAsJsonObject().get("country").getAsString())+"\n";
            }
        }catch(Exception e){
            listCountries = "#Lỗi";
            //e.printStackTrace();
    }
        return listCountries;
    }
    public static String showListStates(String country){
        String listStates="";    
        String apiKey = "0cc59bc3-2b42-4168-bd25-0df351e8b213";
        String url ="http://api.airvisual.com/v2/states?country="+country+"&key="+apiKey;
        try {
             org.jsoup.Connection.Response respone = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .method(org.jsoup.Connection.Method.GET)
                    .execute();
            String doc = respone.body();
            JsonObject json= new Gson().fromJson(doc,JsonObject.class); 
            int numberOfListCountry = json.getAsJsonArray("data").size();
            for(int i=0;i<numberOfListCountry;i++){
                listStates +=(i+1)+". "+(json.getAsJsonArray("data").get(i).getAsJsonObject().get("state").getAsString())+"\n";
            }
        }catch(Exception e){
            listStates = "#Không tìm thấy quốc gia này. Gửi Hello để lấy danh sách các quốc gia";
            //e.printStackTrace();
    }
        return listStates;
    }
    public static String showListCities(String state, String country){
        String listCyties="";    
        String apiKey = "0cc59bc3-2b42-4168-bd25-0df351e8b213";
        String url ="http://api.airvisual.com/v2/cities?state="+state+"&country="+country+"&key="+apiKey;
        try {
             org.jsoup.Connection.Response respone = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .method(org.jsoup.Connection.Method.GET)
                    .execute();
            String doc = respone.body();
            JsonObject json= new Gson().fromJson(doc,JsonObject.class); 
            int numberOfListCountry = json.getAsJsonArray("data").size();
            for(int i=0;i<numberOfListCountry;i++){
                listCyties +=(i+1)+". "+(json.getAsJsonArray("data").get(i).getAsJsonObject().get("city").getAsString())+"\n";
            }
        }catch(Exception e){
            listCyties = "#Sai state hoặc country. Gửi country để biết các state. Gửi hello để biết các country";
            //e.printStackTrace();
    }
        return listCyties;
    }
    public static String getAQI(String city,String state, String country){
        float aqius=0;  
        String kq="";
        String apiKey = "0cc59bc3-2b42-4168-bd25-0df351e8b213";
        String url ="http://api.airvisual.com/v2/city?city="+city+"&state="+state+"&country="+country+"&key="+apiKey;
        try {
             org.jsoup.Connection.Response respone = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .method(org.jsoup.Connection.Method.GET)
                    .execute();
            String doc = respone.body();
            JsonObject json= new Gson().fromJson(doc,JsonObject.class); 
            aqius =json.getAsJsonObject("data").getAsJsonObject("current").getAsJsonObject("pollution").get("aqius").getAsFloat();
            if(aqius>0&&aqius<=50)kq="#Chỉ số không khí(Chuẩn US): "+aqius+"(Tốt)";
            else if(aqius<=100)kq="#Chỉ số không khí(Chuẩn US): "+aqius+"(Vừa phải)";
                else if(aqius<=150)kq="#Chỉ số không khí(Chuẩn US): "+aqius+"(Không tốt cho người thuộc nhóm nhạy cảm)";
                    else if(aqius<=200)kq="#Chỉ số không khí(Chuẩn US): "+aqius+"(Ô nhiểm)";
                        else if(aqius<=300)kq="#Chỉ số không khí(Chuẩn US): "+aqius+"(Rất ô nhiểm)";
                            else if(aqius<=500)kq="#Chỉ số không khí(Chuẩn US): "+aqius+"(Nguy hiểm)";
        }catch(Exception e){
            kq = "#Không tìm thấy địa điểm trên";
            //e.printStackTrace();
    }
        return kq;
    }
}
