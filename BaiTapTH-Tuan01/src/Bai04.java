
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class Bai04 {
    private static Scanner scanner=new Scanner(System.in);
    int n;

    public Bai04(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Cau 4: "+n+" = " +phanTichNguyenTo(n);
    }
    
    public static void main(String[] args) {
        System.out.print("Nhap so nguyen duong N: ");
        int n=scanner.nextInt();
        Bai04 bai04=new Bai04(n);
        System.out.println(bai04);
    }
    public static String phanTichNguyenTo(int n){
        String s="";
        int dem=0;
        Map<Integer, Integer> m=new HashMap<>();
        for(int i=2;i<=n;i++){
            while (n%i==0){
                dem++;
                m.put(i, dem);
                n/=i;
            }
            dem=0;
        }
        Set<Integer> keySet=m.keySet();
        for(Integer key : keySet)
            s+="x"+key+"^"+m.get(key);
        return s.substring(1);
    }
}

