/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author NGUYEN NGOC BAU - 3119410035
 */
public class Server {
    private Socket socket=null;
    private ServerSocket server=null;
    BufferedWriter out=null;
    BufferedReader in = null;
    Map<String, String> dictionary = new HashMap<>();
    public Server(int port){
        loadDictionary();
        try{
            server = new ServerSocket(port) ;
            System.out.println("Server started. Waiting for Client....");
            socket=server.accept();
            System.out.println("Client "+socket.getInetAddress()+" connected at port "+socket.getPort());
            out=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String lineString="";         
            while(!lineString.equals("bye")){
                lineString=in.readLine();
                System.out.println("Server received: "+lineString);
                //Phản hồi kết quả cho client
                String rs = responseResult(lineString);                
                System.out.println("Server returned: "+ rs);
                out.write(rs);
                out.newLine();
                out.flush();
            }
            System.out.println("Closing connection");
            in.close();
            out.close();
            socket.close();
            server.close();
        }catch(IOException e){
            System.err.println(e);
        }
            
    }
    private void loadDictionary(){   
        //Đọc dữ liệu từ fie gắn vào hashmap
        String path = ".\\src\\Data\\dictionary.txt";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        Scanner input = new Scanner(fileInputStream);
        String line = "";
        while(input.hasNextLine()){
            line = input.nextLine();
            StringTokenizer st = new StringTokenizer(line,";");
            dictionary.put(st.nextToken(), st.nextToken());            
        }        
    } 
    private String responseResult(String s) throws IOException {
        s = s.replaceAll("\\s\\s+", " ").trim();//Bỏ khoảng trắng thừa
        if(s.equals("bye")) return "See you again!";
        StringTokenizer st = new StringTokenizer(s,";");
        //Phân tích yêu cầu client gửi cho server
        String req = st.nextToken().toLowerCase();
        if(req.equals("add")){
            if(st.countTokens()==2){
                String en = st.nextToken().trim();               
                String vi = st.nextToken().trim();
                if(dictionary.containsKey(en))
                    return "Thêm thất bại.Từ đã tồn tại!";
                addWord(en,vi);
                return "Thêm thành công!";
            }
            return "Sai cú pháp!";
        }
        if(req.equals("del")){
            if(st.countTokens() == 1){
                String word = st.nextToken().trim();
                if(!(dictionary.containsKey(word)))
                    return "Xóa thất bại.Không có từ này trong từ điển.";
                deleteWord(word);
                return "Xóa thành công";
            }
            return "Sai cú pháp!";
        }
        return translate(s);
    }
    private String translate(String word){
        if(dictionary.containsKey(word)){
            return dictionary.get(word);
        }else{
            String vi;
            Set set  = dictionary.keySet();            
            for(Object key : set){
                vi=dictionary.get(key);
                if(vi.equals(word)){
                    return key.toString();
                }
            }            
        } 
        return "Không biết.";
    }
    private void addWord(String enWord,String viWord) throws IOException{
        String path = ".\\src\\Data\\dictionary.txt";
        BufferedWriter bw = null;
        try{
        File file =new File(path);                
        //True: cho phép nối thêm nội dung vào file
        FileWriter fw = new FileWriter(file,true);
        bw = new BufferedWriter(fw);
        bw.write(enWord+";"+viWord);//Ghi vào file 
        bw.newLine();
        }catch(Exception e){
            System.out.println("Error:");
            e.printStackTrace();
        }finally{
            dictionary.put(enWord, viWord);
            if(bw != null )bw.close(); 
        }
    }
    private void deleteWord(String word) throws IOException{ 
        //Xóa từ đó ra khỏi hashmap
        dictionary.remove(word);
        //Cập nhật lại file dictionary.txt sau khi xóa.
        String path = ".\\src\\Data\\dictionary.txt";
        BufferedWriter bw = null;
        try{
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for(Object key : dictionary.keySet()){
                bw.write(key+";"+dictionary.get(key));//Ghi vào file
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally{           
            if(bw != null) bw.close();
        }
    }
    public static void main(String[] args) {
        Server server=new Server(6000);
    }
}
