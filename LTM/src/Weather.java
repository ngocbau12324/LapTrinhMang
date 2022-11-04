
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class Weather {
    URL url;
     HttpURLConnection con;
      static String json ;
    //từ trang : https://www.baeldung.com/java-http-request
    public Weather(){
        
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
        //System.out.println(streamReader);
        
        BufferedReader in =new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content =new StringBuffer();
        while((inputLine=in.readLine())!=null){
            content.append(inputLine);
            JsonObject jsonObject = new JsonParser().parse(content.toString()).getAsJsonObject();
            System.out.println(jsonObject.get("coord"));
        }
        in.close();
        
    }
    
    public void disconnect(){
        con.disconnect();
    }
    
    public static void main(String[] args) throws IOException{
        Weather weather =new Weather();
        weather.connect("https://api.openweathermap.org/data/2.5/weather?q=th%C3%A0nh%20ph%E1%BB%91%20h%E1%BB%93%20ch%C3%AD%20minh,vi%E1%BB%87t%20nam&appid=d98e5e56ad30dfa428b2c9fda6bb3227");
        weather.reponse();
        
    }
}
