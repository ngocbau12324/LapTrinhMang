
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
public class Bai02 {
    private static Scanner scanner=new Scanner(System.in);
    int n;

    public Bai02(int n) {
        this.n = n;
    }
    
    @Override
    public String toString(){
        if(n>=3)
            return "Cau 2: Tong cac uoc so cua "+n+" la: "+TongUocSoCuaN(n);
        else return "Cau 2: Vui long nhap so nguyen >=3";
    }
    public static void main(String[] args) {
        System.out.print("Nhap so nguyen duong n: ");
        int n=scanner.nextInt();
        Bai02 bai02=new Bai02(n);
        System.out.println(bai02);
    }
    public static long TongUocSoCuaN(int n) {
        if (n<3){
            return 0;
        }
        long tong=0;
        for(int i=1;i<=n;i++){
            if(n%i==0) tong +=i;
        }
        return tong;
    }
    
}
