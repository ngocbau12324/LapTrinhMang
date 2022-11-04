import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("N= ");
        n=sc.nextInt();
        if(n%2==0) System.out.println(n+" la So Chan.");
        else System.out.println(n+" la So Le.");
    }
}
