
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
public class ThongTinClient {
    private String nameClient;
    Socket s;
    String keyAES;
    public ThongTinClient(String name,Socket s,String key){
        this.nameClient=name;
        this.s=s;
        this.keyAES=key;
    }
    public String getnameclient(){
        return this.nameClient;
    }
    public Socket getsocket(){
        return this.s;
    }
    public String getkeyEAS(){
        return this.keyAES;
    }
}
