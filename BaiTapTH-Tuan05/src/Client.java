/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author NGOC BAU
 */
public class Client {
    private Socket socket=null;
    BufferedWriter out=null;
    BufferedReader in=null;
    BufferedReader stdin = null;
    public Client(String host, int port){
        try{
            socket=new Socket(host,port);
            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            stdin = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            while(!line.equals("Over")){
                line = stdin.readLine();
                System.out.println("Client sent: "+line);
                out.write(line);
                out.newLine();
                out.flush();
                
                System.out.println("Client received: "+in.readLine());
            }
            
            in.close();
            out.close();
            stdin.close();
            socket.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static void main(String[] args) {
        Client client =new Client("localhost",6000);
    }
}
