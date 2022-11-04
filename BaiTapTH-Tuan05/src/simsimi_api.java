
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class simsimi_api {
        public static void main(String[] args) throws IOException {        
        String url = "https://wsapi.simsimi.com/190410/talk";
        String key = "qaTcoLMb._h98ADK-5II40jlpy~cyWz8DvPIlQlM";        
        


        Connection.Response execute;
            execute = Jsoup.connect(url)
                    .header("Content-Type", "application/json")                    
                    .header("x-api-key", key)
                    .followRedirects(true)
                    .ignoreHttpErrors(true)
                    .ignoreContentType(true)                    
                    .method(Connection.Method.POST)                    
                    .data("utext", "hello")
                    .data("lang","en")                    
                    .execute();
             int statusCode = execute.statusCode();
        System.out.println("statusCode: " + statusCode); //  200

        String responseJson = execute.body();
            System.out.println(responseJson);
        }
                
}
