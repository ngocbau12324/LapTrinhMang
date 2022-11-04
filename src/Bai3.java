import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r;
        System.out.print("Ban kinh =");
        r=sc.nextInt();
        System.out.println("Chu vi hinh tron = "+2*Math.PI*r);
        System.out.println("Dien tich hinh tron="+Math.PI*r*r);
    }
}
