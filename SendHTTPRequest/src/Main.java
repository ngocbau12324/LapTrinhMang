
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class Main {
    public static HttpURLConnection connection;
    public static void main(String[] args) {
        BufferedReader reader;
        String line;
        String urlString="http://ip-api.com/json/14.174.21.144?fields=status,message,continent,country,city";
        //String url="https://masothue.com/Search/?q=0316281283&type=auto&token=hPRep5qONi";
        StringBuffer responseContent = new StringBuffer();
        try{
            URL url =  new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            //Requesr settup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            //System.out.println(status);
            if(status >299){
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line);
                }
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null){
                    responseContent.append(line+"\n");
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connection.disconnect();
        }
    }
    
}
