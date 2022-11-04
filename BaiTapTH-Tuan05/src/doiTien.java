
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.text.DecimalFormat;
import java.util.Locale;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author NGOC BAU
 */
public class doiTien {

    public String DoiTien(double money, String baseCurren, String desCurren) {
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

    public static void main(String[] args) {
        doiTien doitien = new doiTien();
        System.out.println(doitien.DoiTien(10000000,"VND","USD"));

    }
}
