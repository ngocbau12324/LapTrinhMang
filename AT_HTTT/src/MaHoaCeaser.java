
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
public class MaHoaCeaser {
    public String MaHoaCeasar(String s, int k){
        String kq="";
            String tmp = "abcdefghiklmnopqrstuvwxyz";
        int index;
        for(int i=0;i< s.length();i++){
            index = (tmp.indexOf(s.charAt(i))+k )%26;             
            kq+= tmp.charAt(index);
        }
        return kq;
    } 
    public String GiaMaCeasar(String s, int k){
        String kq="";
        String tmp = "abcdefghiklmnopqrstuvwxyz";
        int index;
        for(int i=0;i< s.length();i++){
            index = (tmp.indexOf(s.charAt(i))-k )%26;             
            kq+= tmp.charAt(index);
        }
        return kq;
    } 
    public static void main(String[] args) {
        MaHoaCeaser cau2=new MaHoaCeaser();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuổi: ");
        String s = sc.nextLine();
        System.out.print("Nhập k: ");
        int k = sc.nextInt();
        
        System.out.println(cau2.MaHoaCeasar(s, k));
        System.out.println(cau2.GiaMaCeasar(cau2.MaHoaCeasar(s, k), k));
    }
}
