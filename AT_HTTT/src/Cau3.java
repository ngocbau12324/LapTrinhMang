
import java.lang.reflect.Array;
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
public class Cau3 {
    //Hàm kiểm tra số nguyên tố.
    public boolean checkPrime(int a){
        if(a<2) return false;
        for(int i=2; i<=Math.sqrt(a);i++)
            if(a%i==0)return false;
        return true;
    }
    //Hàm in tất cả các số nguyên tố có trong mảng một chiều.
    public void showAllPrimeNumberInArray(int a[]){
        System.out.print("Các số nguyên tố có trong mảng: ");
        int sizeOfArray = a.length;
        int flag=0;
        for(int i=0;i<sizeOfArray;i++){
            if(checkPrime(a[i])) 
            {
                System.out.print(a[i]+" ");
                flag=1;
            }
        }
        if(flag==0)System.out.print("Không có số nguyên số nào trong mảng.");
    }
    public static void main(String[] args) {
        Cau3 cau3=new Cau3();
        //Nhập độ dài và giá trị của mảng
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập độ dài của mảng: ");
        int n = sc.nextInt();
        int[] a = new int[n]; 
        System.out.println("Nhập các phần tử của mảng: ");
        for(int i=0;i<n;i++){
            System.out.print("Nhập phần tử thứ "+(i+1)+" :");
            a[i] = sc.nextInt();
        }
        //Gọi phương thức của đối tượng
        cau3.showAllPrimeNumberInArray(a);
           
    }
}
