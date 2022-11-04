package exercise;

import java.util.Scanner;

public class ex18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		System.out.print("Nhập a b:");
		int a = input.nextInt();
		int b = input.nextInt();
		tinhpt(a,b);
	}
	public static void tinhpt(int a, int b) {
		if(a==0)
		System.out.println("Phương trình vô nghiệm");
		else {
			float x=(float)-b/a;
			System.out.println("Phương trình có nghiệm duy nhất là:"+x);
		}
	}

}
