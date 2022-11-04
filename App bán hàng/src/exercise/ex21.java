package exercise;

import java.util.Scanner;

public class ex21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập N:");
		int n = input.nextInt();
		phantichPrime(n);
		countNumber(n);
	}
	public static int checkPrime(int n) {
		if(n<2)
			return 0;
		for(int i=2;i<Math.sqrt(n);i++) {
			if(n%i==0)
				return 0;
		}
		return 1;
	}
	public static void phantichPrime(int n) {
		for(int i=2; i<=n; i++) {
			while(checkPrime(i)==1 && (n%i==0)) {
				System.out.print(i+" ");
				n=n/i;
			}
		}
		System.out.println("");
	}
	public static void countNumber(int n) {
		int count=0;
		while(n>0) {
			n=n/10;
			count++;
		}
		System.out.println("Count:"+count);
	}

}
