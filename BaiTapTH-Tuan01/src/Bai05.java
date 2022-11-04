
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
public class Bai05 {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Nhap so nguyen duong N: ");
        int n=scanner.nextInt();
        Bai01 bai01=new Bai01(n);
        Bai02 bai02=new Bai02(n);
        Bai03 bai03=new Bai03(n);
        Bai04 bai04=new Bai04(n);
        System.out.println(bai01);
        System.out.println(bai02);
        System.out.println(bai03);
        System.out.println(bai04);
    }
}
