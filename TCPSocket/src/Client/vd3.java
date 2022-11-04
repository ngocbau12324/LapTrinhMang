/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGOC BAU
 */
public class vd3 {
    public static void main(String[] args) {
        String hostname = "thongtindaotao.sgu.edu.vn";
        int port=80;
        try {
            Socket s=new Socket(hostname,port);
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            //Send an HTTP GET method to the web server
            String path = "/Default.aspx?page=thoikhoabieu&sta=1&id=10987";
            out.write("GET "+path+" HTTP/1.1\r\n");
            out.write("Host: "+hostname+"\r\n");
            out.write("User-Agent:DemoData\r\n");
            out.write("Acept: text/html\r\n");
            out.write("Acept-Language: en-US\r\n");
            out.write("Connection: Close\r\n");
            out.newLine();
            out.flush();
            //Respone
            String resp;
            while((resp=in.readLine())!=null){
                System.out.println(resp);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
}
