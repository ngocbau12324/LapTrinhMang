import java.util.Scanner;

public class Bai5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("N= ");
        n=sc.nextInt();
        if(n>0) System.out.println(n+" la So nguyen duong.");
        else if(n==0) System.out.println(n+" la Zero.");
        else System.out.println(n+" la So nguyen am.");
    }
}
