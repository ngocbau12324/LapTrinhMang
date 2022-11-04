
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
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
    HashMap<String, Socket> clientList = new HashMap();
    Set<String> waitingUserList = new HashSet<>();
    
    HashMap<String, String> pairList = new HashMap();
    HashMap<String, Integer> Confirm = new HashMap();
    public Server() {
        try{       
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
                    msgBox.append("Client "+s.getInetAddress()
                          +" connected at port "+s.getPort()+"\n");
                    String i = new BufferedReader(new InputStreamReader(s.getInputStream())).readLine();                                            
                        if(clientList.containsKey(i)){
                            BufferedWriter out = new BufferedWriter(
                                    new OutputStreamWriter(s.getOutputStream()));
                            out.write("Da ton tai");
                            out.newLine();
                            out.flush();
                        }else{
                    
                            msgBox.append(i + " Da tham gia !\n");
                            BufferedWriter out = new BufferedWriter(
                                    new OutputStreamWriter(s.getOutputStream()));
                            out.write("");
                            out.newLine();
                            out.flush();
                           
                            clientList.put(i, s);
                                                        
                            new ReadMsg(s,i).start();
                        }
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
                    String messageRecieveFromClient="";
                    if(s.isConnected()){
                        messageRecieveFromClient = new BufferedReader(
                                new InputStreamReader(s.getInputStream())).readLine();
                    }  
                    System.out.println("server received :"+messageRecieveFromClient);
                    if(messageRecieveFromClient.contains("Pair:")){
                        String req = messageRecieveFromClient.split(":")[1];                        
                         new HandlePairing(id,req).start();                 
                         if(req.equals("exit")) break;
                    }else if(messageRecieveFromClient.equals("exitChat")) {                        
                        BufferedWriter out = new BufferedWriter(
                                new OutputStreamWriter(clientList.get(pairList.get(id)).getOutputStream()));                    
                        out.write("exitChat");
                        out.newLine();
                        out.flush(); 
  
                        clientList.remove(id);
                        pairList.remove(pairList.get(id));
                        pairList.remove(id);
                        break;
                    }
                    else{
                        String[] mess = messageRecieveFromClient.split(":");
                        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientList.get(mess[0]).getOutputStream()));                    
                        out.write(mess[1]);
                        out.newLine();
                        out.flush(); 
                    } 
                    
                    
                    
                    
                    
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
    }    
    class HandlePairing extends Thread {
        String id;
        String req;
        public HandlePairing(String id, String req){
            this.id = id;
            this.req = req;
        }
        public void run(){
            try {                                                
               if(req.equals("Request")){                   
                   if(clientList.size() == 1 || waitingUserList.size()==0){
                   if(!waitingUserList.contains(id))waitingUserList.add(id);
                   BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientList.get(id).getOutputStream()));                    
                                    out.write("Pair:wait");
                                    out.newLine();
                                    out.flush();
               }else{                    
                    Iterator itr = waitingUserList.iterator();
                    String id2 = (String)itr.next();
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientList.get(id2).getOutputStream()));                    
                                        out.write("Pair:"+id);
                                        out.newLine();
                                        out.flush();
                    out = new BufferedWriter(new OutputStreamWriter(clientList.get(id).getOutputStream()));                    
                                        out.write("Pair:"+id2);
                                        out.newLine();
                                        out.flush();
                    if (waitingUserList.contains(id2))waitingUserList.remove(id2);
                    if (waitingUserList.contains(id))waitingUserList.remove(id);
                    pairList.put(id, id2);
                    pairList.put(id2, id);
               }
               }else if(req.equals("no")){
                   BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientList.get(id).getOutputStream()));                    
                                    out.write("Pair:wait");
                                    out.newLine();
                                    out.flush();
                   out = new BufferedWriter(new OutputStreamWriter(clientList.get(pairList.get(id)).getOutputStream()));                    
                                    out.write("Pair:wait");
                                    out.newLine();
                                    out.flush();                 
                   if(!waitingUserList.contains(id)) waitingUserList.add(id);
                   if(!waitingUserList.contains(pairList.get(id))) waitingUserList.add(pairList.get(id));
                   pairList.remove(pairList.get(id));
                   pairList.remove(id);                   
               }else if(req.equals("yes")){
                   Confirm.put(id, 1);
                   if(Confirm.containsKey(pairList.get(id))){
                       BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientList.get(id).getOutputStream()));                    
                                    out.write("Pair:chat;"+pairList.get(id));
                                    out.newLine();
                                    out.flush();
                        out = new BufferedWriter(new OutputStreamWriter(clientList.get(pairList.get(id)).getOutputStream()));                    
                                    out.write("Pair:chat;"+id);
                                    out.newLine();
                                    out.flush(); 
                   } 
               }else if(req.equals("exit")){
                   if(pairList.containsKey(id)){
                       BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientList.get(pairList.get(id)).getOutputStream()));                    
                                    out.write("Pair:wait");
                                    out.newLine();
                                    out.flush();
                    waitingUserList.add(pairList.get(id));
                    pairList.remove(pairList.get(id));
                   }                   
                    pairList.remove(id);
                    clientList.remove(id);
                    waitingUserList.remove(id);
                    msgBox.append(id+" Đã thoát!!!\n");
               }
               
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Danh sách chờ");
            msgBox.append("\nDanh sách chờ:");
            String s="";
            Iterator itr1 = waitingUserList.iterator();
                while (itr1.hasNext()){
                    s=(String)itr1.next();
                    System.out.println(s);
                    msgBox.append("\n"+s);
                }
            System.out.println("Danh ghép cặp");
            msgBox.append("\nDanh sách ghép cặp:");
            Iterator itr2 = pairList.keySet().iterator();
                while (itr2.hasNext()){
                    s=(String)itr2.next();
                    System.out.println(s);
                    msgBox.append("\n"+s);
                }
        }
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
//        Iterator itrIterator = clientList.keySet().iterator();
//        while (itrIterator.hasNext()){
//            ThongTinClient client = (ThongTinClient) clientList.get(itrIterator.next());
//            try {
//                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getsocket().getOutputStream()));
//                        out.write(AES.MaHoaAES("serverclosed", client.getkeyEAS()));
//                        out.newLine();
//                        out.flush();
//                        out.close();
//                        ss.close();
//                 this.dispose();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
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
