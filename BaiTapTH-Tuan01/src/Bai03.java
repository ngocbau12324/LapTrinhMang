
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
public class Bai03 {
    private static Scanner scanner=new Scanner(System.in);
    int n;
    public Bai03() {}
    public Bai03(int n) {
        this.n = n;
    }
    @Override
    public String toString(){
        if(n>=3)
            return "Cau 3: Tong cac so nguyen so <="+n+" la: "+TongSoNguyenTo(n);
        else return "Cau 3: Vui long nhap so nguyen >=3";
    }
    public static void main(String[] args) {
        System.out.print("Nhap so nguyen duong N: ");
        int n=scanner.nextInt();
        Bai03 bai03=new Bai03(n);
        System.out.println(bai03);
    }
    public static long TongSoNguyenTo(int n){
        if (n<3){           
            return 0;
        }
            long tong=0;
            for(int i=2;i<=n;i++)
                if (soNguyenTo(i)) tong +=i;
            return tong;  
    }
    public static boolean soNguyenTo(int n){
        if (n<2)return false;
        for(int i=2;i<=Math.sqrt(n);i++)
            if(n%i==0)return false;
        return true;
    }
}
