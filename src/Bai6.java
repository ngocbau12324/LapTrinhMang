import java.util.Scanner;

public class Bai6 {
    //----------------------------Hàm kiểm tra số nguyên tố----------------------------
    public static boolean isPrime(int n){
        if(n<2)return false;
        for(int i=2;i<=Math.sqrt(n);i++)
            if(n%i==0)return false;
         return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        do {
            System.out.print("N=");
            n = sc.nextInt();
            if(n<=0) System.out.println("Nhap lai, N>0");
        }while (n<=0);
        if(isPrime(n)) System.out.println(n+" la So nguyen to.");
        else System.out.println(n+" KHONG PHAI so nguyen to.");
    }
}
