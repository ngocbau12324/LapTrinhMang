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
public class vd2 {
    /*Chương trình WHOIS domain name*/
    public static void main(String[] args) {
        String hostname ="whois.internic.net";
        int port=43;
        try {
            Socket s = new Socket(hostname,port);
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            out.write("baomoi.com");
            out.newLine();
            out.flush();
            //Respone
            String line;
            while((line=in.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(vd2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
