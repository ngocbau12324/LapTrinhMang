
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a,b;
        System.out.print("A=");
        a=sc.nextInt();
        System.out.print("B=");
        b=sc.nextInt();
        System.out.println(a+"+"+b+"="+(a+b));
        System.out.println(a+"-"+b+"="+(a-b));
        System.out.println(a+"x"+b+"="+(a*b));
        System.out.println(a+":"+b+"="+(a*1.0/b));
    }
}
