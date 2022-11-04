
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
public class Cau1 {
    public boolean checkPrime(int a){        
        if(a<2) return false;//Không có số nguyên tố nào nhỏ hơn 2
        for(int i=2; i<=Math.sqrt(a);i++)
            if(a%i==0)return false;//Số nguyên tố chỉ chia hết cho 1 và chính nó.
        return true;
    }
    public static void main(String[] args) {
        Cau1 cau1 = new Cau1();
        System.out.print("Nhap so nguyen X: ");
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        if(cau1.checkPrime(x)) System.out.println(x+" là số nguyên tố");
        else System.out.println(x+" không phải số nguyên tố.");
    }
}
