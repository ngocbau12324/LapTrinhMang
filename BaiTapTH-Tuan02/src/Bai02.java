
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class Bai02 {
    public static void main(String[] args) {
        LinkedHashMap<String, String> m=new LinkedHashMap<>();
        String word="";
        String res="";
        Scanner input=new Scanner(System.in);
        System.out.print("Input: ");
        String data=input.nextLine();
        StringTokenizer st=new StringTokenizer(data, " ");
        while(st.hasMoreElements())
        {
            word=st.nextToken();
            /*if(!m.containsKey(word.toLowerCase())){
                res+=word+" ";
                m.put(word.toLowerCase(), word);
            }*/
            m.putIfAbsent(word.toLowerCase(), word);
        }
        for(String value: m.values())
            res+=value+ " ";
        System.out.println("Output: "+res);
        //System.out.println(m);
        /*s="";
        Set<String> keySet=m.keySet();
        for(String key : keySet)
            s+=m.get(key)+" ";
        System.out.println(s);*/
    }
    
    
}
