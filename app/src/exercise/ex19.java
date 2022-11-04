package exercise;

import java.util.Scanner;

public class ex19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		System.out.println("Nhập ngày:");
		int day = input.nextInt();
		System.out.println("Nhập tháng:");
		int month = input.nextInt();
		System.out.println("Nhập năm:");
		int year = input.nextInt();
		System.out.println("Ngày hôm nay là:"+day+"/"+month+"/"+year);
		tinhthu(day,month,year);
	}
	public static void tinhthu(int day, int month, int year) {
		int record=0;
		if(month<3) {
			month=month+12;
			year=year-1;
		}	
		record = (day+2*month+(3*(month+1))/5+year+(year/4))%7;
		record++;
		System.out.println("Thứ của ngày hôm nay là:"+record);
	}	
}
	
