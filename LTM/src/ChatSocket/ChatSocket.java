/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatSocket;

import GUI.TextItemLeft;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author NGOC BAU
 */
public class ChatSocket {
    private Socket socket;
    private BufferedWriter out;
    private BufferedReader in ;
    private JTextArea txaLog;
    private JPanel boxchat ;

    public ChatSocket(Socket socket, JPanel boxchat) {
        this.socket = socket;
        this.boxchat = boxchat;
        try{
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        receiveFromServer();
    }catch(IOException e){
        //Xu ly loi
    }    
    }
     public ChatSocket(Socket socket, JTextArea txaLog) {
        this.socket = socket;
        this.txaLog = txaLog;
        try{
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        receiveFromClient();
    }catch(IOException e){
        //Xu ly loi
    }    
    }
    private void receiveFromClient(){
        Thread th = new Thread(){
            public void run(){
                while(true){
                    try {                        
                        String line = in.readLine();                        
                        if(line != null){
                            //Xu ly Tin nhắn nhận từ client
                            txaLog.append("Server receive: "+line+"\n");
                            line = chatSimsimi(line);
                            //phan hoi cho client
                            txaLog.append("Server send: "+line+"\n");
                            out.write(line+"\n");
                            out.flush();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ChatSocket.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        th.start();
    }
    private void receiveFromServer(){
        Thread th = new Thread(){
            public void run(){
                while(true){
                    try {                        
                        String line = in.readLine();
                        System.out.println(line);                        
                        if(line != null){
                            //Xu ly gif do                            
                            TextItemLeft item = new TextItemLeft(line);
                            boxchat.add(item,"wrap, w 80%");
                            boxchat.repaint();
                            boxchat.revalidate();
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ChatSocket.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        th.start();
    }
    public void send(String mess){       
        try {
            out.write(mess);
            out.flush();
        } catch (IOException ex) {
            Logger.getLogger(ChatSocket.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public void close(){
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
        }
    }
    private String chatSimsimi(String text){
        String ulr = "https://api.simsimi.net/v2/";
        String ans = "";
        try {
            Connection.Response response=Jsoup.connect(ulr)
                    .data("text", text)
                    .data("lc","vn")
                    .method(Connection.Method.GET)
                    .ignoreContentType(true)
                    .execute();
            String simsimi = response.body();
            JsonObject jsonObject= new Gson().fromJson(simsimi,JsonObject.class); 
            ans = (jsonObject.get("success").getAsString());
        } catch (IOException ex) {
            Logger.getLogger(demo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ans;
    }
}
