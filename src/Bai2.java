import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int w,l;
        System.out.print("Chieu dai=");
        l=sc.nextInt();
        System.out.print("Chieu rong=");
        w=sc.nextInt();
        System.out.println("Chu vi hinh chu nhat = "+2*(w+l));
        System.out.println("Dien tich hinh chu nhat="+(w*l));
    }
}
