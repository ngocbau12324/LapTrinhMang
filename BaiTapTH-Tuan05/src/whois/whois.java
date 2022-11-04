/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whois;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

/**
 *
 * @author NGOC BAU
 */
public class whois {
    public void whoisIp(String domain){
        String myKey = "at_NruRE31e25pdcqWcXbXDJEWRwQIpH";
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
            System.out.println(kq);
        } catch (Exception e) {
            //e.printStackTrace();
            kq="Hổng có thông tin về tên miền. Xin lỗi bạn nha!";
            System.out.println(kq);
        }
    }
    public static void main(String[] args) {
        whois w = new whois();
        w.whoisIp("shopee.vn");
//try {
//            Connection.Response respone = Jsoup.connect("https://who.is/whois/tiki.com")
//                    .ignoreContentType(true)
//                    .method(Connection.Method.GET)
//                    .execute();
//            org.jsoup.nodes.Document doc =respone.parse();
//            System.out.println(doc.getElementsByClass("queryResponseBodyRow").get(1).child(0));
//            int n = doc.getElementsByClass("queryResponseBodyRow").size();
//            for(Element e:doc.getElementsByClass("queryResponseBodyRow")){
//                if(e.childrenSize()==2)
//                System.out.println(e.child(0).text()+":"+e.child(1).text());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    
}
