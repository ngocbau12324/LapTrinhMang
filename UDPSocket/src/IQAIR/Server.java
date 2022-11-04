/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IQAIR;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
/**
 *
 * @author NGOC BAU
 */
public class Server {
    public static int buffsize = 512;
	public static int port = 1234;
	public static void main(String[] args) {
		DatagramSocket socket;
		DatagramPacket dpreceive, dpsend;
		try {
			socket = new DatagramSocket(port);
			dpreceive = new DatagramPacket(new byte[buffsize], buffsize);
			while(true) {
				socket.receive(dpreceive);
				String tmp = new String(dpreceive.getData(), 0 , dpreceive.getLength());
				System.out.println("Server received: " + tmp + " from " +
						dpreceive.getAddress().getHostAddress() + " at port " +
						socket.getLocalPort());
				if(tmp.equals("bye")) {
					System.out.println("Server socket closed");
					socket.close();
					break;
				}
				// Uppercase, sent back to client
				tmp = showListCountries();
				dpsend = new DatagramPacket(tmp.getBytes(), tmp.getBytes().length,
						dpreceive.getAddress(), dpreceive.getPort());
				System.out.println("Server sent back " + new String(dpsend.getData(), 0, dpsend.getLength()) + " to client");
				socket.send(dpsend);
			}
		} catch (IOException e) { System.err.println(e);}
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
                listCountries +=(json.getAsJsonArray("data").get(i).getAsJsonObject().get("country").getAsString())+"\n";
            }
        }catch(Exception e){
            e.printStackTrace();
    }
        return listCountries;
    }
}
