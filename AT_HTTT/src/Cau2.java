
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
public class Cau2 {
    // Cách 1 : dùng phép chia lấy dư
    public int GCD_1(int a, int b){
        while (a*b != 0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        return a+b;
    }
    //Dùng giải thuật Euclid
    public int GCD_Euclid(int a, int b){
        //Dùng đệ quy
        if (b == 0) return a;
        return GCD_Euclid(b, a%b);
        
//        Không dùng đệ quy
//        int tmp;
//        while (b!=0){
//            tmp= a%b;
//            a=b;
//            b=tmp;
//        }
//        return a;
    }
    public static void main(String[] args) {
        Cau2 cau2=new Cau2();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số thứ nhất: ");
        int a = sc.nextInt();
        System.out.print("Nhập số thứ hai: ");
        int b = sc.nextInt();
        System.out.println("GCD("+a+", "+b+")="+cau2.GCD_Euclid(a, b));
        System.out.println("GCD("+a+", "+b+")="+cau2.GCD_1(a, b));
        System.out.println(a%b);
    }
}
