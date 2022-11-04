package exercise;

import java.util.Scanner;
import exercise.main;

public class employee {
		private String name;
		private String Code;
		private int workDays;
		private String rank;
		private int salary;
		public static void inputEmployee() {
			Scanner inputs = new Scanner(System.in);
			System.out.println("Nhập vào tên nhân viên");
			String name = inputs.nextLine();
			System.out.println("Nhập vào mã số nhân viên");
			String code = inputs.nextLine();
			System.out.println("Nhập vào số giờ lương làm");
			int workdays = inputs.nextInt();
			employee new_employee = new employee(name, code, workdays);
			main.employees.add(new_employee);
		}
		public static void outputEmployee() {
			for(employee e : main.employees) {
				System.out.println("Tên Nhân Viên: " + e.getName() + "Mã Nhân Viên:" + e.getCode() + "Số giờ làm:" + e.getWorkDays());
			}
		}
		public static void toRank() {
			for(employee e : main.employees) {
				if(e.getWorkDays()>26) {
					e.setRank("A");
			    if(e.getWorkDays()>=22)
					e.setRank("B");
				if(e.getWorkDays()<22)
					e.setRank("C");
				}
			}
		}
		public static void salary() {
			for(employee e : main.employees) {
				int salary = e.getWorkDays() * 200000;
				e.setSalary(salary);
				System.out.println("Lương của nhân viên " + e.getName() + "là:" + salary);
			}
		}
		public static void salaryBonus() {
			for(employee e : main.employees) {
				if(e.getRank() == "A") {
					System.out.println("Số tiền sau khi tính bonus:" + e.getSalary()*0.05+e.getSalary());
				}
				if(e.getRank() == "B") {
					System.out.println("Số tiền sau khi tính bonus:" + e.getSalary()*0.02+e.getSalary());
				}
				if(e.getRank() == "C") {
					System.out.println("Số tiền sau khi tính bonus:" + e.getSalary());
				}
			}
		}
		//contrustor
		public employee(String name, String code, int workDays) {
			this.name = name;
			this.Code = code;
			this.workDays = workDays;
		}
		// getter and setter
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCode() {
			return Code;
		}
		public void setCode(String code) {
			this.Code = code;
		}
		public int getWorkDays() {
			return workDays;
		}
		public void setWorkDays(int workDays) {
			this.workDays = workDays;
		}
		public String getRank() {
			return rank;
		}
		public void setRank(String rank) {
			this.rank = rank;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
	}

