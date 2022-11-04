/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Locale;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author NGOC BAU
 */
public class doitien {
    
    
    public String DoiTien1(double money, String baseCurren, String desCurren) {
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
                double rs = (double) (json.get("data").getAsJsonObject().get(desCurren).getAsFloat() * money);
                String rss = String.format(Locale.FRANCE,"%,.2f", rs);
                ketQua = String.format(Locale.FRANCE,"%,.2f", money)+" "+baseCurren+" = "+rss+" "+desCurren;                
            }else ketQua = "Không đổi được ạ";

        } catch (Exception e) {
            //e.printStackTrace();
            ketQua = "Không đổi được ạ";
        }
        return ketQua;
    }
    public static void main(String[] args) {        
        System.out.println(doitien.DoiTien1(500000,"VND","USD"));
    }
}
