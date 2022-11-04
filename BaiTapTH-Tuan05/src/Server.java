/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NGOC BAU
 */
public class Server {
    private Socket socket=null;
    private ServerSocket server=null;
    private final int port;
    BufferedWriter out=null;
    BufferedReader in = null;

    public Server(int port) {
        this.port = port;
    }
    public void startServer(){
        try{
            server=new ServerSocket(port);
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public void run(){
        System.out.println("Server started. Waiting for Client....");
        try {
            // Gọi accept() để nhận kết nối tiếp theo
            socket=server.accept();
            System.out.println("Client "+socket.getInetAddress()+" connected at port "+socket.getPort());
            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String lineString="";
            while(!lineString.equals("Over")){
                lineString=in.readLine();
                System.out.println("Server received: "+lineString);
                //Respone
                String str = reverseString(lineString);
                System.out.println("Server retruned: "+str);
                out.write(str);
                out.newLine();
                out.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void stopServer(){
        System.out.println("Closing connection");
        try{
            in.close();
            out.close();
            socket.close();
            server.close();
        }catch(IOException e){
            System.err.println(e);
        }
            
    }
    public static String reverseString(String str ){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
//    public Server(int port){
//        try{
//            server = new ServerSocket(port) ;
//            System.out.println("Server started. Waiting for Client....");
//            socket=server.accept();
//            System.out.println("Client "+socket.getInetAddress()+" connected at port "+socket.getPort());
//            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String lineString="";
//            while(!lineString.equals("Over")){
//                lineString=in.readLine();
//                System.out.println("Server received: "+lineString);
//            }
//            System.out.println("Closing connection");
//            in.close();
//            out.close();
//            socket.close();
//            server.close();
//        }catch(IOException e){
//            System.err.println(e);
//        }
//            
//    }
    public static void main(String[] args) {
        Server server=new Server(6000);
        server.startServer();
        server.run();
        server.stopServer();
    }
}
