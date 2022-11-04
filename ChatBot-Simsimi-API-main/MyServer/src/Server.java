
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class Server extends javax.swing.JFrame {

    /**
     * Creates new form Server
     */
    ServerSocket ss;
    HashMap<Integer, Object> clientList = new HashMap();
    public Server() {
        try{
        //tạo cặp khóa RSA
        RSA.createRSA();
        initComponents();
        ss = new ServerSocket(6666);
        this.sStatus.setText("Server Started.");
        new ClientAccept().start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    class ClientAccept extends Thread {

        public void run() {
            while (true) {
                try {
                    msgBox.append("Server started on port 6666. Waiting for Client....\n");
                    Socket s = ss.accept();
                    msgBox.append("Client "+s.getInetAddress()+" connected at port "+s.getPort()+"\n");
                    String i = new BufferedReader(new InputStreamReader(s.getInputStream())).readLine();                    
                        
                        msgBox.append(i + " Da tham gia !\n");
                        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                     
                        //gửi key RSA public cho client
                        //System.out.println("Server gửi RSA public key:"+RSA.GetKeyPublicBase64());
                        System.out.println("Server tạo cặp key RSA:");
                        System.out.println("Publickey: "+RSA.GetKeyPublicBase64());
                        System.out.println("Privatekey: "+RSA.GetKeyPrivateBase64());
                        
                        out.write(RSA.GetKeyPublicBase64());
                        out.newLine();
                        out.flush();
                        //chờ nhận client gửi lại key AES
                        String messageRecieveFromClient = new BufferedReader(new InputStreamReader(s.getInputStream())).readLine();    
                        System.out.println("Server nhận SecretKey đã mã hóa từ client: "+ messageRecieveFromClient);
                        messageRecieveFromClient=RSA.GiaiMaDuLieu(messageRecieveFromClient);
                       
                        System.out.println("Giải mã ra được Secret Key: "+messageRecieveFromClient);
                        clientList.put(s.getPort(), new ThongTinClient(i,s,messageRecieveFromClient));
                        
                        
                        
                        new ReadMsg(s,i).start();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class  ReadMsg extends Thread{
        Socket s;
        String id;

        public ReadMsg(Socket s, String id) {
            this.s = s;
            this.id = id;
        }
        public void run(){
            while (!clientList.isEmpty() && clientList != null){
                try {
                    //get key AES in hashmap
                    ThongTinClient cl=(ThongTinClient) clientList.get(s.getPort());
                    String messageRecieveFromClient = new BufferedReader(new InputStreamReader(s.getInputStream())).readLine();                       
                    messageRecieveFromClient=AES.GiaiMaAES(messageRecieveFromClient,cl.getkeyEAS());
                    if(messageRecieveFromClient.equals("exit")) {                        
                        clientList.remove(s.getPort());
                        msgBox.append(id+" Đã thoát!!!");
                        break;
                    }
                    //System.out.println("server received :"+messageRecieveFromClient);
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                                    out.write(AES.MaHoaAES(ResponeResult(messageRecieveFromClient), cl.getkeyEAS()));
                                    out.newLine();
                                    out.flush();                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    private String ResponeResult(String s){
        if( s.contains("#")&&s.contains(";")){
            //String req = StringUtils.substringBetween(s,"#",";");
            StringTokenizer st = new StringTokenizer(s,";");
            String req = st.nextToken().trim().toLowerCase();
            switch(req){
                case "#tracuu":
                    if( st.countTokens()==1){
                        String ip = st.nextToken().trim();
                        return ipLookUp(ip);
                    }else return "Để tra cứu: #tracuu;ip";
                    //break;
                case "#quetport":
                    if(st.countTokens() == 3){
                        String hostname = st.nextToken().trim();
                        String beginport = st.nextToken().trim();
                        String endport = st.nextToken().trim();
                        try {
                            int beginPort = Integer.parseInt(beginport);
                            int endPort = Integer.parseInt(endport);
                            if(beginPort >= endPort) return "Port bắt đầu phải nhỏ hơn Port kết thúc!!";                            
                            return scanPort(hostname, beginPort, endPort);
                        } catch (Exception e) {
                            return "Port không hợp lệ!!";
                        }
                    }else return "Để quét port: #quetport;hostname;beginPort;endPort";
                    //break;
                case "#doitien":
                    if(st.countTokens() == 3){
                        String soTienString = st.nextToken().trim();
                        String base = st.nextToken().trim().toUpperCase();
                        String des = st.nextToken().trim().toUpperCase();
                        try {
                            double soTien = Double.parseDouble(soTienString);
                            return DoiTien(soTien, base, des);
                        } catch (Exception e) {
                            return "Tiền chuyển đổi phải là chữ số!!";
                        }
                    }
                    return "Để đổi ngoại tệ: #doitien;số tiền;đơn vị nguồn;đơn vị đích";
                    //break;
                case "#whois":
                    if(st.countTokens() == 1){
                        String domain = st.nextToken().trim();
                        return whoisDomain(domain);
                    }
                    return "Để tra cứu Domain: #whois;domain";
                    //break;
                case "#thoitiet":
                    if(st.countTokens() == 1){
                        String city = st.nextToken().trim();
                        return traCuuThoiTiet(city);
                    }
                    return "Tra cứu thời tiết: #thoitiet;city";
                    //break;
                default:
                    return "Mình có các dịch vụ: #tracuu; #quetport; #doitien; #whois; #thoitiet;";                    
            }
        }
        return chatSimsimi(s);
    }
/*------------------------------------------------API SIMSIMI-------------------------------------------------------------*/    
    private String chatSimsimi(String text){
        String ulr = "https://api-sv2.simsimi.net/v2/?text="+text+"?&lc=vn";
        String ans = "";
        try {
            Connection.Response response=Jsoup.connect(ulr)
//                    .data("text", text)
//                    .data("lc","vn")
//                    .timeout(10000)
                    .method(Connection.Method.GET)
                    .ignoreContentType(true)
                    .execute();
            String simsimi = response.body();
            JsonObject jsonObject= new Gson().fromJson(simsimi,JsonObject.class); 
            ans = (jsonObject.get("success").getAsString());
        } catch (IOException ex) {
            ans = "hừmmmmm";
            //ex.printStackTrace();
        }
        return ans;
    }
/*------------------------------------------------API IP-LOOKUP-------------------------------------------------------------*/      
    private String ipLookUp(String ip){
    String result="";
    String url = "http://ip-api.com/json/" + ip + "?fields=status,message,continent,country,city,lat,lon";
        try {
            Connection.Response respone = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .method(Connection.Method.GET)
                    .execute();
            String doc = respone.body();
            JsonObject json= new Gson().fromJson(doc,JsonObject.class); 
            String status = json.get("status").toString();
        if(status.equals("\"fail\"")){            
            String message =json.get("message").toString();
            if(message.equals("\"private range\"")) return "Private IP. Không thể tìm!";
            if(message.equals("\"reserved range\"")) return "Reserved IP addresses. Không thể tìm!";
            return "IP không hợp lệ.";
        }                                
        result ="IP: "+ip+"\n";
        result +="Vĩ độ: "+json.get("lat").toString()+"\n";
        result +="Kinh Độ: "+json.get("lon").toString()+"\n";
        result +="Thành phố: "+json.get("city").toString()+"\n";
        result +="Quốc gia: "+json.get("country").toString()+"\n";
        result +="Châu lục: "+json.get("continent").toString();        
        } catch (Exception e) {
            //e.printStackTrace();
            return "Rất tiếc đã xãy ra lỗi. Gà con xin lỗi vì sự bất tiện này.";
        }
        return result;
}
/*------------------------------------------------SCAN PORT-------------------------------------------------------------*/      
   private String scanPort(String hostname,int beginPort,int endPort){
        int timeout=200;
        String rs = rs = "#PORT [";
        char flag =0;
        for(int port=beginPort;port<=endPort;port++){
            try{                
                Socket s = new Socket();
                s.connect(new InetSocketAddress(hostname,port), timeout);
                flag =1;
                rs +=port+" ";
                s.close();
            }catch(IOException e){               
                //
            }                        
        }
        if(flag == 0) rs="Hổng có Port nào mở trong khoảng "+beginPort+"-"+endPort;
        else rs += "] IS OPEN.";
        return rs;
    }
/*------------------------------------------------API TỈ GIÁ NGOẠI TỆ-------------------------------------------------------------*/  
   private String DoiTien(double money, String baseCurren, String desCurren) {
        String apikey = "hmFV9hN33BTWUQZyCsypg3wcv8MBzbNRaH1JdzQC";
        String url = "https://api.currencyapi.com/v3/latest?apikey=" + apikey + "&base_currency=" + baseCurren+"&currencies="+desCurren;
        String ketQua;
        try {
            Connection.Response respone = Jsoup.connect(url)
                    .followRedirects(false)
                    .ignoreContentType(true)
                    .method(Connection.Method.GET)
                    .execute();

            int statusCode = respone.statusCode();
            if (statusCode == 200) {
                String doc = respone.body();                
                JsonObject json = new Gson().fromJson(doc, JsonObject.class);
                System.out.println();
                //Lấy giá trị tỷ giá giữa 2 nguồn tiền
                float value = json.get("data").getAsJsonObject().get(desCurren).getAsJsonObject().get("value").getAsFloat();
                double rs = (double) (value * money);
                String rss = String.format(Locale.FRANCE,"%,.0f", rs);
                ketQua = String.format(Locale.FRANCE,"%,.0f", money)+" "+baseCurren+" = "+rss+" "+desCurren;                
            }else ketQua = "Không đổi được ạ";

        } catch (Exception e) {
            //e.printStackTrace();
            ketQua = "Không đổi được ạ";
        }
        return ketQua;
    }
/*------------------------------------------------WHOIS-------------------------------------------------------------*/         
   private String whoisDomain(String domain){
        String myKey = "at_ApkQ41WIlrYmaM5mkWiUk6Y2faHmU";
        String url = "https://www.whoisxmlapi.com/whoisserver/WhoisService?outputFormat=Json&apiKey="+myKey+"&domainName="+domain;
        String kq = "";
        try {
            Connection.Response respone = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .method(Connection.Method.GET)
                    .timeout(2000)
                    .execute();
            String doc = respone.body();
            JsonObject json= new Gson().fromJson(doc,JsonObject.class);
            String createDate;
            String expiresDate;
            String nameServers;
            String registrarName;
            String registrarIANAID;
            String whoisServer;
            String RegistrantContactInfo;
            try {
                 createDate = json.getAsJsonObject("WhoisRecord").get("createdDate").getAsString();
            } catch (Exception e) {
                createDate="no";
            }
            try {
                 expiresDate = json.getAsJsonObject("WhoisRecord").get("expiresDate").getAsString();
            } catch (Exception e) {
                expiresDate="no";
            }
            try {
                 nameServers = (json.getAsJsonObject("WhoisRecord").getAsJsonObject("nameServers").get("rawText").getAsString());
            } catch (Exception e) {
                nameServers="no";
            }
            try {
                 registrarName = json.getAsJsonObject("WhoisRecord").get("registrarName").getAsString();
            } catch (Exception e) {
                registrarName="no";
            }
            try {
                 registrarIANAID = json.getAsJsonObject("WhoisRecord").get("registrarIANAID").getAsString();
            } catch (Exception e) {
                registrarIANAID="no";
            }
            try {
                 whoisServer = json.getAsJsonObject("WhoisRecord").getAsJsonObject("registryData").get("whoisServer").getAsString();
            } catch (Exception e) {
                whoisServer="no";
            }
            try {
                 RegistrantContactInfo = (json.getAsJsonObject("WhoisRecord").getAsJsonObject("registrant").get("rawText").getAsString());
            } catch (Exception e) {
                RegistrantContactInfo="no";
            }
            kq = "REGISTRAR INFO\n";
            kq += "Registrar Name: "+registrarName+"\n";
            kq += "Registrar IANA ID: "+registrarIANAID+"\n";
            kq += "Whois Server: "+whoisServer+"\n";
            kq += "NAME SERVERS\n";
            kq += nameServers+"";
            kq += "Ngày đăng ký:"+createDate+"\n";
            kq += "Ngày hết hạn:"+expiresDate+"\n";
            kq += "THÔNG TIN NGƯỜI ĐĂNG KÝ\n";
            kq += RegistrantContactInfo;
            //System.out.println(kq);
        } catch (Exception e) {
            //e.printStackTrace();
            kq="Simsimi hổng tìm được thông tin về tên miền. Xin lỗi bạn nha!";
            //System.out.println(kq);
        }
        return kq;
    }
/*------------------------------------------------TRA CỨU THỜI TIẾT-------------------------------------------------------------*/            
   private String traCuuThoiTiet(String city){
        URL url;
        HttpURLConnection con=null;
        String kq="";
        try {
            url=new URL("https://api.openweathermap.org/data/2.5/forecast?q="+city+"&units=metric&lang=vi&appid=d98e5e56ad30dfa428b2c9fda6bb3227");
            con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            
            int status = con.getResponseCode();
       
        Reader streamReader =null;
        if(status>299){
            streamReader =new InputStreamReader(con.getErrorStream());
            
        }else{
            streamReader =new InputStreamReader(con.getInputStream());
        }
        System.out.println("C:Response status is :"+status);
       // System.out.println(streamReader);
        
        BufferedReader in =new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content =new StringBuffer();
        while((inputLine=in.readLine())!=null){
            content.append(inputLine);                         
        }
        JsonObject jsonObject = new Gson().fromJson(content.toString(),JsonObject.class);
        String name =jsonObject.getAsJsonObject("city").get("name").getAsString();
        kq = "Thời tiết "+name+" hôm nay và 5 ngày tới\n";
        JsonArray arrayThoiTiet = jsonObject.get("list").getAsJsonArray();
        int lt=arrayThoiTiet.size();
        for (int i = 0; i < lt; ++i) {
            JsonObject rec = (JsonObject) arrayThoiTiet.get(i);
            kq += rec.get("dt_txt").getAsString()+"\n";  
            kq += " -"+rec.getAsJsonObject("main").get("temp").getAsString()+"'C, ";
            kq +="Tốc độ gió "+rec.getAsJsonObject("wind").get("speed").getAsString()+ "m/s\n";
            kq +=" -Độ ẩm "+rec.getAsJsonObject("main").get("humidity").getAsString()+"%, ";
            JsonArray A = rec.get("weather").getAsJsonArray();            
            JsonObject recdes=(JsonObject)A.get(0);
            kq += "Trời có "+recdes.get("description").getAsString()+"\n";
            //System.out.println(rec.get("dt_txt")+"->"+recdes.get("description"));            
        }        
        in.close();
        } catch (Exception e) {
            //e.printStackTrace();
            kq = "Không tìm thấy địa danh bạn đang tra cứu.";
        } finally{
            con.disconnect();
        }
        return kq;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgBox = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        sStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyServer");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        msgBox.setEditable(false);
        msgBox.setColumns(20);
        msgBox.setRows(5);
        jScrollPane1.setViewportView(msgBox);

        jLabel1.setText("Server status:");

        sStatus.setText("..........................................");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 238, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sStatus))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Iterator itrIterator = clientList.keySet().iterator();
        while (itrIterator.hasNext()){
            ThongTinClient client = (ThongTinClient) clientList.get(itrIterator.next());
            try {
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getsocket().getOutputStream()));
                        out.write(AES.MaHoaAES("serverclosed", client.getkeyEAS()));
                        out.newLine();
                        out.flush();
                        out.close();
                        ss.close();
                 this.dispose();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea msgBox;
    private javax.swing.JLabel sStatus;
    // End of variables declaration//GEN-END:variables
}
