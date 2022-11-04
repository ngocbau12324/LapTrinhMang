
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
public class Bai01 {
    private static  Scanner scaner=new Scanner(System.in);
    int n;

    public Bai01() {
    }

    public Bai01(int n) {
        this.n = n;
    }
    @Override
    public String toString(){
        if(n>0)
            return "Cau 1: Tong "+n+" so nguyen duong dau tien la: "+ tongNsoNguyenDuongDauTien(n);
        else return "Cau 1: "+n+" khong phai so nguyen duong.";
    }
    public static void main(String[] args) {
        System.out.print("Nhap so nguyen duong n: ");
        int n= scaner.nextInt();
        Bai01 bai01=new Bai01(n);
        System.out.println(bai01);
    }
    public static long tongNsoNguyenDuongDauTien(int n){
        // sum=n*(n+1)/2;
        if(n<=0){
            
            return 0;
        }
        long tong=0;
        for (int i=0;i<=n;i++){
            tong+=i;
        }
        return tong;
        
    }
}
