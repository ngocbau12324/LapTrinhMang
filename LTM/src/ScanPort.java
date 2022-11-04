
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class ScanPort {
    public ScanPort(){}
    public  void scanPort(String hostname,int beginPort,int endPort){
        int timeout=200;
        String rs = rs = "#PORT [";
        char flag =0;
        for(int port=beginPort;port<=endPort;port++){
            try{                
                Socket s = new Socket();
                s.connect(new InetSocketAddress(hostname,port), timeout);
                flag =1;
                rs +=port+"";
//                System.out.println(port);
//                System.out.println("#PORT "+port+" IS OPENED.");
                s.close();
            }catch(IOException e){               
                //System.out.println("Port "+port+" is closed.");
            }
            
            
        }
        if(flag == 0) rs="Hổng có Port nào mở trong khoảng "+beginPort+"-"+endPort;
        else rs += "] IS OPEN.";
        System.out.println(rs);
    }
    public static void main(String[] args) {
        ScanPort scanPort = new ScanPort();
        scanPort.scanPort("8.8.8.8", 400, 500);
    }
}
