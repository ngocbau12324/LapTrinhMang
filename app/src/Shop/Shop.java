package Shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import Account.Account;
import Account.ArrayAccount;
import Bill.ArrayBill;
import Bill.ArrayBillDetails;
import Employee.ArrayEmployee;
import Employee.Employee;
import EnterCoupon.ArrayDetailEnterCoupon;
import EnterCoupon.ArrayEnterCoupon;
import Producer.ArrayProducer;
import Producer.Producer;
import Users.ArrayCustomer;
import Users.Customer;
import userService.userService;
import Product.Product;
import Supplier.ArraySupplier;
import Supplier.Supplier;
import Product.ArrayProduct;


public class Shop {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ArrayAccount Ac = new ArrayAccount(); // đây là con trỏ tạo đến đối tượng cần sử dụng 
		ArrayProduct ap = new ArrayProduct();
		ArrayCustomer cus = new ArrayCustomer();
		ArraySupplier as = new ArraySupplier();
		ArrayProducer pro = new ArrayProducer();
		ArrayEmployee ae = new ArrayEmployee();
		ArrayEnterCoupon aec= new ArrayEnterCoupon();
		ArrayDetailEnterCoupon adec = new ArrayDetailEnterCoupon();
		ArrayBill ab = new ArrayBill();
		ArrayBillDetails abd = new ArrayBillDetails();
		userService us = new userService();
	    //Thêm 1 phương thức kiểm tra đăng nhập bằng tài khoản cho admin
//		Ac.creatData(); // tạo dữ liệu cho account 
//		Ac.writeFile();
		Scanner sc = new Scanner(System.in);
		login: while (true) {
			System.out.println(" _______________________________");
			System.out.println("|___________ĐĂNG NHẬP___________|");
			System.out.println("|                               |");
			System.out.println("|   1. Admin                    |");
			System.out.println("|   2. User                     |");
			System.out.println("|   3. Sale                     |");
			System.out.println("|   4. Sing-up                  |");
			System.out.println("|   5. Exit                     |");
			System.out.println("|_______________________________|\n");
			loop: while (true) {
				int t = 0;
				System.out.print("Nhập vào sự lựa chọn của bạn:");
				try {
					t = sc.nextInt();
				} catch (InputMismatchException ex) {
					System.out.println("\n>>Lựa chọn phải là số!");
				}
				sc.nextLine();
				switch (t) {
				// ADMIN
				case 1: { // chưa xây dựng nhập tài khoản của admin 
					pwd: while (true) {
						System.out.print("\nMời bạn nhập mật khẩu:");
						String password = sc.nextLine();
					    Ac.readFile();
					    //Đọc file có chứa account của admin và khách hàng rồi in ra màn hình
						// check đăng nhập của admin
						if (Ac.checkPasswordAdmin(password)) {
							System.out.println("\n>>Đăng nhập thành công!");
							menu: while (true) {
								System.out.println(" __________________________________________");
								System.out.println("|___________________MENU___________________|");
								System.out.println("|                                          |");
								System.out.println("|   1- Quản lý tài khoản                   |");
								System.out.println("|   2- Quản lý sản phẩm                    |");
								System.out.println("|   3- Quản lý khách hàng                  |");
								System.out.println("|   4- Quản lý nhà cung cấp                |");
								System.out.println("|   5- Quản lý nhà sản xuất                |");
								System.out.println("|   6- Quản lý nhân viên                   |");
								System.out.println("|   7- Quản lý sản phẩm nhập vào           |");
								System.out.println("|   8- Quản lý sản phẩm đã bán             |");
								System.out.println("|   9- Thống kê kinh doanh                 |");
								System.out.println("|   10- Đăng xuất                          |");
								System.out.println("|   11- Thoát                              |");
								System.out.println("|__________________________________________|\n");
								chon_menu: while (true) {
									int m = 0;
									System.out.print("Nhập vào sự lựa chọn của bạn:");
									try {
										m = sc.nextInt();
									} catch (InputMismatchException ex) {
										System.out.println("\n>>Lựa chọn phải là số!");
									}
									sc.nextLine();
									switch (m) {
									case 1: { // QL Tài Khoản
										 Ac.readFile(); //đọc file có chứa tài khoản account
										 if(Ac.fileNull()){
										 System.out.println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
										 Ac.inputAccount();
										 Ac.writeFile();
										 Ac.readFile();
										 Ac.display(); }
										 else Ac.display();
										tkhoan: while (true) {
											System.out.println(" ___________________________________________");
											System.out.println("|_____________QUẢN LÝ TÀI KHOẢN_____________|");
											System.out.println("|                                           |");
											System.out.println("|   1- Thêm tài khoản                       |");
											System.out.println("|   2- Xóa tài khoản                        |");
											System.out.println("|   3- Sửa tài khoản                        |");
											System.out.println("|   4- Tìm kiếm tài khoản                   |");
											System.out.println("|   5- Quay lại                             |");
											System.out.println("|   6- Thoát                                |");
											System.out.println("|___________________________________________|\n");
											chon_tk: while (true) {
												int a = 0;
												System.out.print("Nhập vào sự lựa chọn của bạn:");
												try {
													a = sc.nextInt();
												} catch (InputMismatchException ex) {
													System.out.println("\n>>Lựa chọn phải là số!");
												}
												sc.nextLine();
												switch (a) {
												case 1: {
															 //thêm tài khoản của khách hàng 
															 Ac.add(); 
															 Ac.writeFile();
															 Ac.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													tk_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tkhoan;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue tk_next;
														}
														}
													}
												}
												case 2: {
															  Ac.remove();
															  Ac.display();
															  Ac.writeFile();
															  System.out.println(
															  "___________________________________________");
															  System.out.println("Bạn có muốn tiếp tục không?");
															  System.out.println("1- Tiếp tục");
															  System.out.println("2- Quay lại menu chính");
															  System.out.println("3 -Thoát"); System.out.println(
															  "___________________________________________");
													tk_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tkhoan;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue tk_next;
														}
														}
													}
												}
												case 3: {
															 // edit tài khoản của khách hàng 
															 Ac.edit(); 
															 Ac.writeFile();
															 Ac.display(); System.out.println(
															 "___________________________________________");
															 System.out.println("Bạn có muốn tiếp tục không?");
															 System.out.println("1- Tiếp tục");
															 System.out.println("2- Quay lại menu chính");
															 System.out.println("3 -Thoát"); System.out.println(
															 "___________________________________________");
													tk_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tkhoan;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue tk_next;
														}
														}
													}
												}
												case 4: {
															  //tìm kiếm tài khoản của khách hàng
															  Ac.search();
															  System.out.println(
															  "___________________________________________");
															  System.out.println("Bạn có muốn tiếp tục không?");
															  System.out.println("1- Tiếp tục");
															  System.out.println("2- Quay lại menu chính");
															  System.out.println("3 -Thoát"); System.out.println(
															  "___________________________________________");
															 
													tk_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tkhoan;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue tk_next;
														}
														}
													}
												}
												case 5: {
													continue menu;
												}
												case 6: {
													System.exit(0);
												}
												default: {
													System.out.println(
															"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 6.\n");
													continue chon_tk;
												}
												}
											}
										}
									}
									// Đây là code quản lí hàng hóa
									case 2: { // QL Hàng Hoá
//										  ap.creatData();
//										  ap.writeFile();
										  ap.readFile();
										  //check file. nếu file đang rỗng thêm dữ liệu cho file. nếu không thì bỏ qua và hiển thị
										  if(ap.fileNull()){
										  System.out.println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
										  ap.inputProduct();
										  ap.writeFile();
										  ap.readFile();
										  ap.display();
										  }
										else 
										   ap.display();// hiển thị hàng hóa lên màn hình
										hhoa: while (true) {
											System.out.println(" ____________________________________________");
											System.out.println("|_____________QUẢN LÝ HÀNG HÓA______________|");
											System.out.println("|                                           |");
											System.out.println("|   1- Thêm hàng hóa                        |");
											System.out.println("|   2- Xóa hàng hóa                         |");
											System.out.println("|   3- Sửa thông tin hàng hóa               |");
											System.out.println("|   4- Tìm kiếm thông tin hàng hóa          |");
											System.out.println("|   5- Quay lại                             |");
											System.out.println("|   6- Thoát                                |");
											System.out.println("|___________________________________________|\n");
											chon_hh: while (true) {
												int a = 0;
												System.out.print("Nhập vào sự lựa chọn của bạn:");
												try {
													a = sc.nextInt();
												} catch (InputMismatchException ex) {
													System.out.println("\n>>Lựa chọn phải là số!");
												}
												sc.nextLine();
												switch (a) {
												case 1: {
															  //thêm hàng hóa 
													ap.add();
													ap.writeFile();
													ap.readFile();
													ap.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													hh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue hhoa;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue hh_next;
														}
														}
													}
												}
												case 2: {
															 //xóa hàng hóa
															 ap.remove(); 
															 ap.writeFile();
															 ap.readFile();
															 ap.display();
															 System.out.println(
															 "___________________________________________");
															 System.out.println("Bạn có muốn tiếp tục không?");
															 System.out.println("1- Tiếp tục");
															 System.out.println("2- Quay lại menu chính");
															 System.out.println("3 -Thoát"); System.out.println(
															 "___________________________________________");
													hh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue hhoa;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue hh_next;
														}
														}
													}
												}
												case 3: {
															 //edit hàng hóa
															 ap.edit(); 
															 ap.writeFile();
															 ap.readFile();
															 ap.display();
															 System.out.println(
															 "___________________________________________");
															 System.out.println("Bạn có muốn tiếp tục không?");
															 System.out.println("1- Tiếp tục");
															 System.out.println("2- Quay lại menu chính");
															 System.out.println("3 -Thoát"); System.out.println(
															 "___________________________________________");
													hh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue hhoa;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue hh_next;
														}
														}
													}
												}
												case 4: {
															 //tìm kiếm hàng hóa
															 ap.search();
															 System.out.println(
															 "___________________________________________");
															 System.out.println("Bạn có muốn tiếp tục không?");
															 System.out.println("1- Tiếp tục");
															 System.out.println("2- Quay lại menu chính");
															 System.out.println("3 -Thoát");
															 System.out.println(
															 "___________________________________________");
													hh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue hhoa;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue hh_next;
														}
														}
													}
												}
												case 5: {
													continue menu;
												}
												case 6: {
													System.exit(0);
												}
												default: {
													System.out.println(
															"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 6.\n");
													continue chon_hh;
												}
												}
											}
										}
									}
									case 3: {
												 //QL Khách Hàng  
												// đọc file khách hàng // nếu không có
												//thì nhập. nếu có bỏ qua và hiển thị ra màn hình 
//												cus.creatData();
//												cus.writeFile();
												cus.readFile();
												if(cus.fileNull()){
													System.out.
													println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
													cus.inputCustomer();
													cus.writeFile();
													cus.readFile(); 
													cus.display(); }
												else
													cus.display();
										khachhang: while (true) {
											System.out.println(" _____________________________________________");
											System.out.println("|_____________QUẢN LÝ KHÁCH HÀNG______________|");
											System.out.println("|                                             |");
											System.out.println("|   1- Thêm khách hàng                        |");
											System.out.println("|   2- Xóa khách hàng                         |");
											System.out.println("|   3- Sửa thông tin khách hàng               |");
											System.out.println("|   4- Tìm kiếm thông tin khách hàng          |");
											System.out.println("|   5- Quay lại                               |");
											System.out.println("|   6- Thoát                                  |");
											System.out.println("|_____________________________________________|\n");
											chon_kh: while (true) {
												int a = 0;
												System.out.print("Nhập vào sự lựa chọn của bạn:");
												try {
													a = sc.nextInt();
												} catch (InputMismatchException ex) {
													System.out.println("\n>>Lựa chọn phải là số!");
												}
												sc.nextLine();
												switch (a) {
												case 1: {
															  // thêm khách hàng 
															 cus.add(); 
															 cus.writeFile();
															 cus.readFile();
															 cus.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													kh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue khachhang;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue kh_next;
														}
														}
													}
												}
												case 2: {
															 // xóa khách hàng
															 cus.remove(); 
															 cus.writeFile();
															 cus.readFile();
															 cus.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													kh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue khachhang;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue kh_next;
														}
														}
													}

												}
												case 3: {
														    // chỉnh sửa danh sách khách hàng 
													 		 cus.edit(); 
													 		 cus.writeFile();
															 cus.readFile();
															 cus.display();
															 
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													kh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue khachhang;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue kh_next;
														}
														}
													}
												}
												case 4: {
													cus.search();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													kh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue khachhang;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue kh_next;
														}
														}
													}
												}
												case 5: {
													continue menu;
												}
												case 6: {
													System.exit(0);
												}
												default: {
													System.out.println(
															"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 6.\n");
													continue chon_kh;
												}
												}
											}
										}
									}
									case 4: { // QL Nhà Cung Cấp
										 /*as.creatData();
										 as.writeFile();*/
										 as.readFile();
								         if(as.fileNull()){
										 System.out.println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
										 as.inputSupplier(); 
										 as.writeFile();
										 as.readFile();
										 as.display(); }
								         else
										 as.display();
										ncc: while (true) {
											System.out.println(" _______________________________________________");
											System.out.println("|_____________QUẢN LÝ NHÀ CUNG CẤP______________|");
											System.out.println("|                                               |");
											System.out.println("|   1- Thêm nhà cung cấp                        |");
											System.out.println("|   2- Xóa nhà cung cấp                         |");
											System.out.println("|   3- Sửa thông tin nhà cung cấp               |");
											System.out.println("|   4- Tìm kiếm thông tin nhà cung cấp          |");
											System.out.println("|   5- Quay lại                                 |");
											System.out.println("|   6- Thoát                                    |");
											System.out.println("|_______________________________________________|\n");
											chon_ncc: while (true) {
												int a = 0;
												System.out.print("Nhập vào sự lựa chọn của bạn:");
												try {
													a = sc.nextInt();
												} catch (InputMismatchException ex) {
													System.out.println("\n>>Lựa chọn phải là số!");
												}
												sc.nextLine();
												switch (a) {
												case 1: {
															 as.add();
															 as.writeFile(); 
															 as.readFile(); 
															 as.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													ncc_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue ncc;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue ncc_next;
														}
														}
													}

												}
												case 2: {
															 as.remove();
															 as.writeFile();
															 as.readFile();
															 as.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													ncc_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue ncc;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue ncc_next;
														}
														}
													}

												}
												case 3: {
															 as.edit();
															 as.writeFile();
															 as.readFile(); 
															 as.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													ncc_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue ncc;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue ncc_next;
														}
														}
													}
												}
												case 4: {
													as.search();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													ncc_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue ncc;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue ncc_next;
														}
														}
													}
												}
												case 5: {
													continue menu;
												}
												case 6: {
													System.exit(0);
												}
												default: {
													System.out.println(
															"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 6.\n");
													continue chon_ncc;
												}
												}
											}
										}
									}
									case 5: { // QL Nhà Sản Xuất
										 //đọc file nhà sản xuất và check dữ liệu
										 /*pro.creatData();
										 pro.writeFile();*/
										 pro.readFile();
										 if(pro.fileNull()){
										 System.out.println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
										 pro.inputProducer();
										 pro.writeFile();
										 pro.readFile();
										 pro.display(); }
										 else
										 pro.display();
										nsx: while (true) {
											System.out.println(" _______________________________________________");
											System.out.println("|_____________QUẢN LÝ NHÀ SẢN XUẤT______________|");
											System.out.println("|                                               |");
											System.out.println("|   1- Thêm nhà sản xuất                        |");
											System.out.println("|   2- Xóa nhà sản xuất                         |");
											System.out.println("|   3- Sửa thông tin nhà sản xuất               |");
											System.out.println("|   4- Tìm kiếm thông tin nhà sản xuất          |");
											System.out.println("|   5- Quay lại                                 |");
											System.out.println("|   6- Thoát                                    |");
											System.out.println("|_______________________________________________|\n");
											chon_nsx: while (true) {
												int a = 0;
												System.out.print("Nhập vào sự lựa chọn của bạn:");
												try {
													a = sc.nextInt();
												} catch (InputMismatchException ex) {
													System.out.println("\n>>Lựa chọn phải là số!");
												}
												sc.nextLine();
												switch (a) {
												case 1: {
															 //Thêm nhà sản xuất 
															pro.add();
															pro.writeFile();
															pro.readFile(); 
															pro.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													nsx_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue nsx;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue nsx_next;
														}
														}
													}
												}
												case 2: {
															 //Xóa nhà sản xuất
															 pro.remove();
															 pro.writeFile();
															 pro.readFile();
															 pro.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													nsx_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue nsx;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue nsx_next;
														}
														}
													}
												}
												case 3: {
															 //edit nhà sản xuất 
															 pro.edit();
															 pro.writeFile();
															 pro.readFile();
															 pro.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													nsx_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue nsx;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue nsx_next;
														}
														}
													}
												}
												case 4: {
													pro.search(); //tìm kiếm nhà sản xuất
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													nsx_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue nsx;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue nsx_next;
														}
														}
													}
												}
												case 5: {
													continue menu;
												}
												case 6: {
													System.exit(0);
												}
												default: {
													System.out.println(
															"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 6.\n");
													continue chon_nsx;
												}
												}
											}
										}
									}
									case 6: { // QL Nhân Viên
										 //Đọc file nhân viên và check dữ liệu 
//										 ae.creatData();
//										 ae.writeFile();
										 ae.readFile();
										 if(ae.fileNull()){
										 System.out.println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
										 ae.inputEmployee();
										 ae.writeFile();
										 ae.readFile();
										 ae.display(); }
										 else ae.display();
										nv: while (true) {
											System.out.println(" ____________________________________________");
											System.out.println("|_____________QUẢN LÝ NHÂN VIÊN______________|");
											System.out.println("|                                            |");
											System.out.println("|   1- Thêm nhân viên                        |");
											System.out.println("|   2- Xóa nhân viên                         |");
											System.out.println("|   3- Sửa thông tin nhân viên               |");
											System.out.println("|   4- Tìm kiếm thông tin nhân viên          |");
											System.out.println("|   5- Quay lại                              |");
											System.out.println("|   6- Thoát                                 |");
											System.out.println("|____________________________________________|\n");
											chon_nv: while (true) {
												int a = 0;
												System.out.print("Nhập vào sự lựa chọn của bạn:");
												try {
													a = sc.nextInt();
												} catch (InputMismatchException ex) {
													System.out.println("\n>>Lựa chọn phải là số!");
												}
												sc.nextLine();
												switch (a) {
												case 1: {
															 //thêm nhân viên
															 ae.add();
															 ae.writeFile();
															 ae.readFile();
															 ae.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													nv_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue nv;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue nv_next;
														}
														}
													}
												}
												case 2: {
															 //Xóa nhân viên
															 ae.remove();
															 ae.writeFile();
															 ae.readFile();
															 ae.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													nv_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue nv;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue nv_next;
														}
														}
													}
												}
												case 3: {
															 //edit nhân viên
															 ae.edit();
															 ae.writeFile();
															 ae.readFile();
															 ae.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													nv_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue nv;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue nv_next;
														}
														}
													}
												}
												case 4: {
															 //tìm kiếm nhân viên
														ae.search();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													nv_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue nv;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue nv_next;
														}
														}
													}
												}
												case 5: {
													continue menu;
												}
												case 6: {
													System.exit(0);
												}
												default: {
													System.out.println(
															"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 6.\n");
													continue chon_nv;
												}
												}
											}
										}
									}
									case 7: { // QL Phiếu Nhập. Đọc file phiếu nhập và chi tiết phiếu nhập để hiển thị
												// ra màn hình
										// tạo dữ liệu
//										 aec.creatData();
//										 adec.creatData();
//										 aec.writeFile();
//										 adec.writeFile();
										 // đọc dữ liệu từ file ra
										 aec.readFile();
										 aec.readFileEnterCouponDetail();
										 adec.readFile();
										 if(aec.fileNull()){
										 System.out.println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
										 aec.inputEnterCoupon();
										 adec.inputDetailEnterCoupon();
										 aec.writeFile();
										 aec.readFile(); 
										 aec.readFileEnterCouponDetail();
										 aec.display();
										 adec.readFile();
										 adec.display(); } 
										 else { aec.display();
										 adec.display(); }
										 tim: while (true) {
											System.out.println(" ____________________________________________");
											System.out.println("|_____________QUẢN LÝ PHIẾU NHẬP_____________|");
											System.out.println("|                                            |");
											System.out.println("|   1- Thêm phiếu nhập                       |");
											System.out.println("|   2- Sửa phiếu nhập                        |");
											System.out.println("|   3- Tìm kiếm phiếu nhập                   |");
											System.out.println("|   4- Tìm kiếm chi tiết phiếu nhập          |");
											System.out.println("|   5- Quay lại                              |");
											System.out.println("|   6- Thoát                                 |");
											System.out.println("|____________________________________________|\n");
//											String remove = aec.removeEnterCoupon();
//											adec.remove(remove);
//											aec.display();
//											adec.display();
											search: while (true) {
												int p = 0;
												System.out.print("Nhập vào sự lựa chọn của bạn:");
												try {
													p = sc.nextInt();
												} catch (InputMismatchException ex) {
													System.out.println("\n>>Lựa chọn phải là số!");
												}
												sc.nextLine();
												switch (p) {
												case 1: {
													adec.readFile();
													adec.readFileEnterCoupon();
													adec.readFileProduct();
													adec.add();
													adec.writeFileEnterCoupon();
													adec.writeFile();
													adec.writeFileProduct();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													pn_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tim;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue pn_next;
														}
														}
													}
												}
												case 2: {
													adec.readFile();
													adec.readFileEnterCoupon();
													adec.readFileProduct();
													adec.edit();
													adec.writeFile();
													adec.writeFileEnterCoupon();
													adec.writeFileProduct();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													pn_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tim;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue pn_next;
														}
														}
													}
												}
												case 3: {
															 //TÌm kiếm phiếu nhập 
															 aec.search();															 
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													pn_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tim;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue pn_next;
														}
														}
													}
												}
												case 4: {
															 // Đọc file chi tiết phiếu nhập và tìm kiếm
															adec.readFile();
															adec.search();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													ctpn_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tim;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue ctpn_next;
														}
														}
													}
												}
												case 5: {
													System.out.println("___________________________________________");
													System.out.println("1- Quay lại");
													System.out.println("2 -Về menu chính");
													System.out.println("___________________________________________");
													tiep: while (true) {
														int o = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															o = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (o) {
														case 1: {
															continue tim;
														}
														case 2: {
															continue menu;
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị 1 hoặc 2.\n");
															continue tiep;
														}
														}
													}
												}
												case 6: {
													System.exit(0);
												}
												default: {
													System.out.println(
															"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
													continue search;
												}
												}

											}
										}

									}
									case 8: { // QL Phiếu Xuất. Đọc file phiếu xuất và chi tiết phiếu xuất
										// tạo dữ liệu 
										ab.creatData();
										abd.creatData();
										ab.writeFile();
										abd.writeFile();
										// đọc file lấy dữ liệu
										 ab.readFile();
										 ab.readFileBillDetails();
										 abd.readFile();
										 if(ab.fileNull()){
										 System.out.println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
										 ab.inputBill();
										 abd.inputBillDetails();
										 ab.writeFile();
										 abd.writeFile();
										 ab.readFile();
										 ab.readFileBillDetails();
										 abd.readFile();
										 ab.display();
										 abd.display();
										 } else
										 { ab.display();
										   abd.display(); 
										 }
										tim: while (true) {
											System.out.println(" ____________________________________________");
											System.out.println("|_____________QUẢN LÝ PHIẾU XUẤT_____________|");
											System.out.println("|                                            |");
											System.out.println("|   1- Thêm phiếu xuất                       |");
											System.out.println("|   2- Sửa phiếu xuất                        |");
											System.out.println("|   3- Tìm kiếm phiếu xuất                   |");
											System.out.println("|   4- Tìm kiếm chi tiết phiếu xuất          |");
											System.out.println("|   5- Quay lại                              |");
											System.out.println("|   6- Thoát                                 |");
											System.out.println("|____________________________________________|\n");
											search: while (true) {
												int p = 0;
												System.out.print("Nhập vào sự lựa chọn của bạn:");
												try {
													p = sc.nextInt();
												} catch (InputMismatchException ex) {
													System.out.println("\n>>Lựa chọn phải là số!");
												}
												sc.nextLine();
												switch (p) {
												case 1: {
													abd.readFileProduct();
													abd.readFileCustomer();
													abd.readFileBill();
													abd.billSale();
													abd.writeFileProduct();
													abd.writeFile();
													abd.writeFileBill();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													px_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tim;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue px_next;
														}
														}
													}
													
												}
												case 2:{
													abd.readFileProduct();
													abd.readFileCustomer();
													abd.readFileBill();
													abd.edit();
													abd.display();
													abd.writeFile();
													abd.writeFileBill();
													abd.writeFileProduct();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													px_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tim;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue px_next;
														}
														}
													}
												}
												case 3: {
															 //tìm kiếm phiếu xuất 
														ab.search();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													px_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tim;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue px_next;
														}
														}
													}
												}
												case 4: {
															 //HIển thị chi tiết phiếu xuất ctpx.docfile();
															 abd.search();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													ctpx_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue tim;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue ctpx_next;
														}
														}
													}
												}
												case 5: {
													System.out.println("___________________________________________");
													System.out.println("1- Về menu chính");
													System.out.println("2 -Thoát");
													System.out.println("___________________________________________");
													tiep: while (true) {
														int o = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															o = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (o) {
														case 1: {
															continue menu;
														}
														case 2: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue tiep;
														}
														}

													}
												}
												default: {
													System.out.println(
															"\n>>Không hợp lệ. Mời bạn nhập lại giá trị 1 hoặc 2.\n");
													continue search;
												}
												}
											}
										}
									}
									case 9:{
										// thống kê kinh doanh
										statisticsh:
										while(true) {
									    ab.readFile();
									    ab.readFileBillDetails();
										ab.economicStatisticsh();
										System.out.println("___________________________________________");
										System.out.println("Bạn có muốn tiếp tục không?");
										System.out.println("1- Tiếp tục");
										System.out.println("2- Quay lại menu chính");
										System.out.println("3 -Thoát");
										System.out.println("___________________________________________");
										pn_next: while (true) {
											int b = 0;
											System.out.print("Nhập vào sự lựa chọn của bạn:");
											try {
												b = sc.nextInt();
											} catch (InputMismatchException ex) {
												System.out.println("\n>>Lựa chọn phải là số!");
											}
											sc.nextLine();
											switch (b) {
											case 1: {
												continue statisticsh;
											}
											case 2: {
												continue menu;
											}
											case 3: {
												System.exit(0);
											}
											default: {
												System.out.println(
														"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
												continue pn_next;
											}
											}
										}
										}
									}
									case 10: {
										System.out.println("\n>>Đăng xuất thành công!");
										System.out.println("___________________________________________");
										System.out.println("Bạn có muốn đăng nhập lại không?");
										System.out.println("1- Đăng nhập");
										System.out.println("2- Thoát");
										System.out.println("___________________________________________");
										logout: while (true) {
											int b = 0;
											System.out.print("Nhập vào sự lựa chọn của bạn:");
											try {
												b = sc.nextInt();
											} catch (InputMismatchException ex) {
												System.out.println("\n>>Lựa chọn phải là số!");
											}
											sc.nextLine();
											switch (b) {
											case 1: {
												continue login;
											}
											case 2: {
												System.exit(0);
											}
											default: {
												System.out.println(
														"\n>>Không hợp lệ. Mời bạn nhập lại giá trị 1 hoặc 2.\n");
												continue logout;
											}
											}
										}
									}
									case 11: {
										System.exit(0);
									}
									default: {
										System.out.println("\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 10.\n");
										continue chon_menu;
									}
									}
								}
							}
						} else {
							System.out.println("\n>>Sai mật khẩu. Vui lòng nhập lại.");
							continue pwd;
						}
					}
				}
				case 2: {
					loginid: while (true) {
						System.out.print("\nMời bạn nhập tên tài khoản:");
						String accountName = sc.nextLine();
						// đọc file và dữ liệu trong file để xử lí
						// đây là tài khoản để test
						Ac.readFile();
						if (Ac.checkAccountNameUser(accountName)) {
							loginpwd: while (true) {
								System.out.print("\nMời bạn nhập mật khẩu:");
								String pwd = sc.nextLine();
								if (Ac.checkPasswordUser(accountName, pwd)) {
									System.out.println("\n>>Đăng nhập thành công!");
									menu: while (true) {
										System.out.println(" __________________________________________");
										System.out.println("|___________________MENU___________________|");
										System.out.println("|                                          |");
										System.out.println("|   1- Mua hàng                            |");
										System.out.println("|   2- Quản lý đơn hàng                    |");
										System.out.println("|   3- Quản lý tài khoản                   |");
										System.out.println("|   4- Chăm sóc khách hàng                 |");
										System.out.println("|   5- Đơn hàng của tôi                    |");
										System.out.println("|   6- Đăng xuất                           |");
										System.out.println("|   7- Thoát                               |");
										System.out.println("|__________________________________________|\n");
										us.readFileAccount();
										String customerCode=us.getCustomerCode(accountName);
										chon_menu: while (true) {
											int m = 0;
											System.out.print("Nhập vào sự lựa chọn của bạn:");
											try {
												m = sc.nextInt();
											} catch (InputMismatchException ex) {
												System.out.println("\n>>Lựa chọn phải là số!");
											}
											sc.nextLine();
											switch (m) {
											case 1: { // Đây là code mua sản phẩm
												muahang:
												while(true) {
												// hiển thị danh sách sản phẩm ở đây
											    us.readFile();// đọc file sản phẩm và in ra màn hình
											    us.productDisplay();
												// tìm kiếm sản phẩm ở đây
											    us.searchRequest();
											    us.writeFile();
											    us.writeFileCart(customerCode);
												// viết code mua hàng ở đây........(bạn có muốn mua hay không: nhập vào số lượng và địa chỉ của bạn)
												// Đây là code sau khi mua sản phẩm. Lựa chọn các tính năng ở dưới
												System.out.println("___________________________________________");
												System.out.println("Bạn có muốn tiếp tục không?");
												System.out.println("1- Tiếp tục");
												System.out.println("2- Quay lại menu chính");
												System.out.println("3 -Thoát");
												System.out.println("___________________________________________");
												sanpham_next: while (true) {
													int b = 0;
													System.out.print("Nhập vào sự lựa chọn của bạn:");
													try {
														b = sc.nextInt();
													} catch (InputMismatchException ex) {
														System.out.println("\n>>Lựa chọn phải là số!");
													}
													sc.nextLine();
													switch (b) {
													case 1: {
														continue muahang;
													}
													case 2: {
														continue menu;
													}
													case 3: {
														System.exit(0);
													}
													default: {
														System.out.println(
																"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
														continue sanpham_next;
													}
													}
												}
												}
											}
											case 2: { // QL Đơn hàng
												// Đọc file đơn hàng và chi tiết đơn hàng của khách hàng để in ra màn hình và xử lí
												pn: while (true) {
													System.out.println(" ________________________________________________");
													System.out.println("|_______________QUẢN LÝ ĐƠN HÀNG_________________|");
													System.out.println("|                                                |");
													System.out.println("|   1- Xóa sản phẩm                              |");
													System.out.println("|   2- Sửa sản phẩm                              |");
													System.out.println("|   3- Thông tin chi tiết đơn hàng               |");
													System.out.println("|   4- Tìm kiếm thông tin sản phẩm đã mua        |");
													System.out.println("|   5- Thanh toán đơn hàng của tôi               |");
													System.out.println("|   6- Quay lại                                  |");
													System.out.println("|   7- Thoát                                     |");
													System.out.println("|________________________________________________|\n");
													chon_pn: while (true) {
														int p = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															p = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (p) {
														case 1: {
															// Đây là code xóa sản phẩm 
															xoasanpham:
															while(true) {
															// viết code xóa sản phẩm ở đây
															us.readFileCart(customerCode);
															us.readFile();
															us.removeCart();
															us.writeFile();
															us.writeFileCart(customerCode);
															System.out.println(
																	"___________________________________________");
															System.out.println("Bạn có muốn tiếp tục không?");
															System.out.println("1- Tiếp tục");
															System.out.println("2- Quay lại");
															System.out.println("3- Quay lại menu chính");
															System.out.println("4 -Thoát");
															System.out.println(
																	"___________________________________________");
															pn_next: while (true) {
																int b = 0;
																System.out.print("Nhập vào sự lựa chọn của bạn:");
																try {
																	b = sc.nextInt();
																} catch (InputMismatchException ex) {
																	System.out.println("\n>>Lựa chọn phải là số!");
																}
																sc.nextLine();
																switch (b) {
																case 1: {
																	continue xoasanpham;
																}
																case 2:{
																	continue pn;
																}
																case 3: {
																	continue menu;
																}
																case 4: {
																	System.exit(0);
																}
																default: {
																	System.out.println(
																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 4.\n");
																	continue pn_next;
																}
																}
															}
															}
														}
														case 2: {// Đây là code quản lí chi tiết đơn hàng gồm 
															// đọc file và show dữ liệu chi tiết đơn hàng cho người dùng
															chitietdonhang:
															while(true) {
														    us.readFileCart(customerCode);
														    us.readFile();
															us.editCart();
															us.writeFile(); // ghi số lượng mới vào file sản phẩm
															us.writeFileCart(customerCode);
															System.out.println(
																	"___________________________________________");
															System.out.println("Bạn có muốn tiếp tục không?");
															System.out.println("1- Tiếp tục");
															System.out.println("2- Quay lại");
															System.out.println("3- Quay lại menu chính");
															System.out.println("4 -Thoát");
															System.out.println(
																	"___________________________________________");
															pn_next: while (true) {
																int b = 0;
																System.out.print("Nhập vào sự lựa chọn của bạn:");
																try {
																	b = sc.nextInt();
																} catch (InputMismatchException ex) {
																	System.out.println("\n>>Lựa chọn phải là số!");
																}
																sc.nextLine();
																switch (b) {
																case 1: {
																	continue chitietdonhang;
																}
																case 2: {
																	continue pn;
																}
																case 3: {
																	continue menu;
																}
																case 4:{
																	System.exit(0);
																}
																default: {
																	System.out.println(
																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 4.\n");
																	continue pn_next;
																}
																}
															}
															}
														}	
														case 3: {// thông tin đơn hàng của tôi															
															diachi:
															while(true) {
																// Đây là code thông tin đơn hàng của tôi
															us.readFileCart(customerCode);	
															us.displayCart();
															System.out.println(
																	"___________________________________________");
															System.out.println("Bạn có muốn tiếp tục không?");
															System.out.println("1- Tiếp tục");
															System.out.println("2- Quay lại");
															System.out.println("3- Quay lại menu chính");
															System.out.println("4 -Thoát");
															System.out.println(
																	"___________________________________________");
															pn_next: while (true) {
																int b = 0;
																System.out.print("Nhập vào sự lựa chọn của bạn:");
																try {
																	b = sc.nextInt();
																} catch (InputMismatchException ex) {
																	System.out.println("\n>>Lựa chọn phải là số!");
																}
																sc.nextLine();
																switch (b) {
																// sửa cái này 
																case 1: {
																	continue diachi;
																}
																case 2: {
																	continue pn;
																}
																case 3: {
																	continue menu;
																}
																case 4:{
																	System.exit(0);
																}
																default: {
																	System.out.println(
																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 4.\n");
																	continue pn_next;
																}
																}
															}
															}
														}
														case 4: {
															timkiem:
															while(true) {
															// Đây là code tìm kiếm thông tin chi tiết sản phẩm
															us.readFileCart(customerCode);
															us.searchCart();
															System.out.println(
																	"___________________________________________");
															System.out.println("Bạn có muốn tiếp tục không?");
															System.out.println("1- Tiếp tục tìm kiếm");
															System.out.println("2- Quay lại");
															System.out.println("2- Quay lại menu chính");
															System.out.println("3 -Thoát");
															System.out.println(
																	"___________________________________________");
															pn_next: while (true) {
																int b = 0;
																System.out.print("Nhập vào sự lựa chọn của bạn:");
																try {
																	b = sc.nextInt();
																} catch (InputMismatchException ex) {
																	System.out.println("\n>>Lựa chọn phải là số!");
																}
																sc.nextLine();
																switch (b) {
																case 1: {
																	continue timkiem;
																}
																case 2: {
																	continue pn;
																}
																case 3: {
																	continue menu;
																}
																case 4: {
																	System.exit(0);
																}
																default: {
																	System.out.println(
																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 4.\n");
																	continue pn_next;
																}
																}
															}
															}
														}
														case 5:{
															// đây là thanh toán đơn hàng
															paymentCart:
															while(true) {
															us.readFileBill();
															us.readFile();
															us.readFileBillDetails();
															us.readFileCart(customerCode);
															us.readFileAccount();
															us.readFileCustomer();
															
//															us.myBillDisplay(accountName);
															us.paymentCart(accountName);
															
															us.writeFileBill(); // ghi file của ngày đó vào hóa đơn chung
															us.writeFileBillDetails();// tự động lưu lại hóa đơn của khách hàng
															us.writeFile();// ghi số lượng còn lại vào file sản phẩm
															us.writeFileCart(customerCode); // xóa đơn hàng khỏi cart
															System.out.println(
																	"___________________________________________");
															System.out.println("Bạn có muốn tiếp tục không?");
															System.out.println("1- Tiếp tục");
															System.out.println("2- Quay lại");
															System.out.println("3- Quay lại menu chính");
															System.out.println("4 -Thoát");
															System.out.println(
																	"___________________________________________");
															pn_next: while (true) {
																int b = 0;
																System.out.print("Nhập vào sự lựa chọn của bạn:");
																try {
																	b = sc.nextInt();
																} catch (InputMismatchException ex) {
																	System.out.println("\n>>Lựa chọn phải là số!");
																}
																sc.nextLine();
																switch (b) {
																case 1: {
																	continue paymentCart;
																}
																case 2: {
																	continue pn;
																}
																case 3: {
																	continue menu;
																}
																case 4: {
																	System.exit(0);
																}
																default: {
																	System.out.println(
																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 4.\n");
																	continue pn_next;
																}
																}
															}
														}
														}
														case 6: {
															continue menu;
														}
														case 7: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 6.\n");
															continue chon_pn;
														}
														}
													}
												}
											}
											case 3: {
												pn: while (true) {								
													System.out.println(" ____________________________________________");
													System.out.println("|_____________QUẢN LÝ TÀI KHOẢN______________|");
													System.out.println("|                                            |");
													System.out.println("|   1- Đổi mật khẩu                          |");
													System.out.println("|   2- Thông tin người dùng                  |");
													System.out.println("|   3- Quay lại                              |");
													System.out.println("|____________________________________________|\n");
													chon_pn: while (true) {
														int p = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															p = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (p) {
														case 1: {
															// Đây là code đổi mật khẩu  
															doimatkhau:
															while(true) {
															Ac.user_change_pwd(accountName);
															Ac.writeFile();
															// viết code đổi mật khẩu ở đây (trong class account)
															System.out.println(
																	"___________________________________________");
															System.out.println("Bạn có muốn tiếp tục không?");
															System.out.println("1- Tiếp tục");
															System.out.println("2- Quay lại");
															System.out.println("3- Quay lại menu chính");
															System.out.println("4 -Thoát");
															System.out.println(
																	"___________________________________________");
															pn_next: while (true) {
																int b = 0;
																System.out.print("Nhập vào sự lựa chọn của bạn:");
																try {
																	b = sc.nextInt();
																} catch (InputMismatchException ex) {
																	System.out.println("\n>>Lựa chọn phải là số!");
																}
																sc.nextLine();
																switch (b) {
																case 1: {
																	continue doimatkhau;
																}
																case 2:{
																	continue pn;
																}
																case 3: {
																	continue menu;
																}
																case 4: {
																	System.exit(0);
																}
																default: {
																	System.out.println(
																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 4.\n");
																	continue pn_next;
																}
																}
															}
															}
														}
														case 2:{
															thongtinnguoidung:
																while(true) {
																	// viết code thông tin người dùng ở đây (trong class account)
																	us.readFileCustomer();
																	us.showInfo(accountName);
																	us.writeFileCustomer();
													    			System.out.println(
																			"___________________________________________");
																	System.out.println("Bạn có muốn tiếp tục không?");
																	System.out.println("1- Tiếp tục");
																	System.out.println("2- Quay lại");
																	System.out.println("3- Quay lại menu chính");
																	System.out.println("4 -Thoát");
																	System.out.println(
																			"___________________________________________");
																	pn_next: while (true) {
																		int b = 0;
																		System.out.print("Nhập vào sự lựa chọn của bạn:");
																		try {
																			b = sc.nextInt();
																		} catch (InputMismatchException ex) {
																			System.out.println("\n>>Lựa chọn phải là số!");
																		}
																		sc.nextLine();
																		switch (b) {
																		case 1: {
																			continue thongtinnguoidung;
																		}
																		case 2:{
																			continue pn;
																		}
																		case 3: {
																			continue menu;
																		}
																		case 4: {
																			System.out.println("Cảm ơn bạn đã sử dụng phần mềm của chúng tôi!");
																			System.exit(0);
																		}
																		default: {
																			System.out.println(
																					"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 4.\n");
																			continue pn_next;
																		}
																		}
																	}
																	}
														}
														case 3:{
															continue menu;
														}
														}
													}
													}
												}
//											case 4: {// Đổi trả sản phẩm
//												change: while (true) {
//													System.out.println("___________________________________________");
//													System.out.println("Lựa chọn của bạn");
//													System.out.println("1- Trả sản phẩm");
//													System.out.println("2- Đổi sản phẩm khác");
//													System.out.println("3- Quay lại");
//													System.out.println("___________________________________________");
//													choice: while (true) {
//														int p = 0;
//														System.out.print("Nhập vào sự lựa chọn của bạn:");
//														try {
//															p = sc.nextInt();
//														} catch (InputMismatchException ex) {
//															System.out.println("\n>>Lựa chọn phải là số!");
//														}
//														sc.nextLine();
//														switch (p) {
//														case 1: {
//															//Trả sản phẩm
//															us.readFileCart(customerCode);
//															us.removeCart();
//															us.writeFileCart(customerCode);
//															System.out.println("___________________________________________");
//															System.out.println("Bạn có muốn tiếp tục không?");
//															System.out.println("1- Tiếp tục");
//															System.out.println("2- Quay lại menu chính");
//															System.out.println("3 -Thoát");
//															System.out.println("___________________________________________");
//															px_next: while (true) {
//																int b = 0;
//																System.out.print("Nhập vào sự lựa chọn của bạn:");
//																try {
//																	b = sc.nextInt();
//																} catch (InputMismatchException ex) {
//																	System.out.println("\n>>Lựa chọn phải là số!");
//																}
//																sc.nextLine();
//																switch (b) {
//																case 1: {
//																	continue change;
//																}
//																case 2: {
//																	continue menu;
//																}
//																case 3: {
//																	System.exit(0);
//																}
//																default: {
//																	System.out.println(
//																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
//																	continue px_next;
//																}
//																}
//															}
//														}
//														case 2:{
//															us.readFile();
//															us.readFileCart(customerCode);
//															us.changeProduct();
//															us.writeFile();
//															us.writeFileCart(customerCode);
//															System.out.println("___________________________________________");
//															System.out.println("Bạn có muốn tiếp tục không?");
//															System.out.println("1- Tiếp tục");
//															System.out.println("2- Quay lại menu chính");
//															System.out.println("3 -Thoát");
//															System.out.println("___________________________________________");
//															px_next: while (true) {
//																int b = 0;
//																System.out.print("Nhập vào sự lựa chọn của bạn:");
//																try {
//																	b = sc.nextInt();
//																} catch (InputMismatchException ex) {
//																	System.out.println("\n>>Lựa chọn phải là số!");
//																}
//																sc.nextLine();
//																switch (b) {
//																case 1: {
//																	continue change;
//																}
//																case 2: {
//																	continue menu;
//																}
//																case 3: {
//																	System.exit(0);
//																}
//																default: {
//																	System.out.println(
//																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
//																	continue px_next;
//																}
//																}
//															}
//														}
//														case 3:{
//															continue menu;
//														}
//														}
//													}
//												}
//											}
											case 4: {
												System.out.println("Vui lòng liên hệ hotline : 0924714551 . Để được tư vấn cảm ơn!!!!");
												System.out.println("___________________________________________");
												System.out.println("Bạn có muốn tiếp tục không?");
												System.out.println("1- Tiếp tục");
												System.out.println("2- Quay lại menu chính");
												System.out.println("3 -Thoát");
												System.out.println("___________________________________________");
												px_next: while (true) {
													int b = 0;
													System.out.print("Nhập vào sự lựa chọn của bạn:");
													try {
														b = sc.nextInt();
													} catch (InputMismatchException ex) {
														System.out.println("\n>>Lựa chọn phải là số!");
													}
													sc.nextLine();
													switch (b) {
													case 1: {
														continue px_next;
													}
													case 2: {
														continue menu;
													}
													case 3: {
														System.exit(0);
													}
													default: {
														System.out.println(
																"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
														continue px_next;
													}
													}
												}
											}
											case 5:{
												us.readFileAccount();
												us.readFileBillDetails();
												us.myBillDisplay(accountName);
												System.out.println("___________________________________________");
												System.out.println("Bạn có muốn tiếp tục không?");
												System.out.println("1- Tiếp tục");
												System.out.println("2- Quay lại menu chính");
												System.out.println("3 -Thoát");
												System.out.println("___________________________________________");
												px_next: while (true) {
													int b = 0;
													System.out.print("Nhập vào sự lựa chọn của bạn:");
													try {
														b = sc.nextInt();
													} catch (InputMismatchException ex) {
														System.out.println("\n>>Lựa chọn phải là số!");
													}
													sc.nextLine();
													switch (b) {
													case 1: {
														continue px_next;
													}
													case 2: {
														continue menu;
													}
													case 3: {
														System.exit(0);
													}
													default: {
														System.out.println(
																"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
														continue px_next;
													}
													}
												}
											}
											case 6: { // Log out
												System.out.println("\n>>Đăng xuất thành công!");
												System.out.println("___________________________________________");
												System.out.println("Bạn có muốn đăng nhập lại không?");
												System.out.println("1- Đăng nhập");
												System.out.println("2 -Thoát");
												System.out.println("___________________________________________");
												logout: while (true) {
													int b = 0;
													System.out.print("Nhập vào sự lựa chọn của bạn:");
													try {
														b = sc.nextInt();
													} catch (InputMismatchException ex) {
														System.out.println("\n>>Lựa chọn phải là số!");
													}
													sc.nextLine();
													switch (b) {
													case 1: {
														continue login;
													}
													case 2: {
														System.exit(0);
													}
													default: {
														System.out.println(
																"\n>>Không hợp lệ. Mời bạn nhập lại giá trị 1 hoặc 2.\n");
														continue logout;
													}
													}
												}
											}
											case 7: { // Thoát
												System.exit(0);
											}
											default: {
												System.out.println(
														"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 7.\n");
												continue chon_menu;
											}

											}
										}
									}
								} else {
									System.out.println("\n>>Sai mật khẩu. Vui lòng nhập lại.");
									continue loginpwd;
								}
							}
						} else {
							System.out.println("\n>>Tên tài khoản này không tồn tại. Vui lòng nhập lại.");
							continue loginid;
						}
					}
				}
				case 3:{
					// Đây là người bán hàng
					loginSalesMan: while (true) {
						System.out.print("\nMời bạn nhập tên tài khoản:");
						String accountName = sc.nextLine();
						// đọc file và dữ liệu trong file để xử lí
						// đây là tài khoản để test
						Ac.readFile();
						if (Ac.checkAccountNameSale(accountName)) {
							loginpwd: while (true) {
								System.out.print("\nMời bạn nhập mật khẩu:");
								String pwd = sc.nextLine();
								if (Ac.checkPasswordSale(accountName, pwd)) {
									System.out.println("\n>>Đăng nhập thành công!");
									menu: while (true) {
										System.out.println(" __________________________________________");
										System.out.println("|___________________MENU___________________|");
										System.out.println("|                                          |");
										System.out.println("|   1- Quản lý tài khoản                   |");
										System.out.println("|   2- Quản lý hóa đơn                     |");
										System.out.println("|   3- Quản lý khách hàng                  |");
										System.out.println("|   4- Thoát                               |");
										System.out.println("|__________________________________________|\n");
										chon_menu: while (true) {
											int m = 0;
											System.out.print("Nhập vào sự lựa chọn của bạn:");
											try {
												m = sc.nextInt();
											} catch (InputMismatchException ex) {
												System.out.println("\n>>Lựa chọn phải là số!");
											}
											sc.nextLine();
											switch (m) {
											case 1: { // QL Tài Khoản
												 Ac.readFile(); //đọc file có chứa tài khoản account
												 if(Ac.fileNull()){
												 System.out.println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
												 Ac.inputAccount();
												 Ac.writeFile();
												 Ac.readFile();
												 Ac.display(); }
												 else Ac.display();
											tkhoan: while (true) {
												System.out.println(" ____________________________________________");
												System.out.println("|_____________QUẢN LÝ TÀI KHOẢN______________|");
												System.out.println("|                                            |");
												System.out.println("|   1- Thêm tài khoản                        |");
												System.out.println("|   2- Xóa tài khoản                         |");
												System.out.println("|   3- Sửa tài khoản                         |");
												System.out.println("|   4- Tìm kiếm tài khoản                    |");
												System.out.println("|   5- Quay lại                              |");
												System.out.println("|   6- Thoát                                 |");
												System.out.println("|____________________________________________|\n");
												chon_tk: while (true) {
													int a = 0;
													System.out.print("Nhập vào sự lựa chọn của bạn:");
													try {
														a = sc.nextInt();
													} catch (InputMismatchException ex) {
														System.out.println("\n>>Lựa chọn phải là số!");
													}
													sc.nextLine();
													switch (a) {
													case 1: {
																 //thêm tài khoản của khách hàng 
																 Ac.add(); 
																 Ac.writeFile();
																 Ac.display();
														System.out.println("___________________________________________");
														System.out.println("Bạn có muốn tiếp tục không?");
														System.out.println("1- Tiếp tục");
														System.out.println("2- Quay lại menu chính");
														System.out.println("3 -Thoát");
														System.out.println("___________________________________________");
														tk_next: while (true) {
															int b = 0;
															System.out.print("Nhập vào sự lựa chọn của bạn:");
															try {
																b = sc.nextInt();
															} catch (InputMismatchException ex) {
																System.out.println("\n>>Lựa chọn phải là số!");
															}
															sc.nextLine();
															switch (b) {
															case 1: {
																continue tkhoan;
															}
															case 2: {
																continue menu;
															}
															case 3: {
																System.exit(0);
															}
															default: {
																System.out.println(
																		"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
																continue tk_next;
															}
															}
														}
													}
													case 2: {
																  Ac.employeeRemove();
																  Ac.employeeDisplay();
																  Ac.writeFile();
																  System.out.println(
																  "___________________________________________");
																  System.out.println("Bạn có muốn tiếp tục không?");
																  System.out.println("1- Tiếp tục");
																  System.out.println("2- Quay lại menu chính");
																  System.out.println("3 -Thoát"); System.out.println(
																  "___________________________________________");
														tk_next: while (true) {
															int b = 0;
															System.out.print("Nhập vào sự lựa chọn của bạn:");
															try {
																b = sc.nextInt();
															} catch (InputMismatchException ex) {
																System.out.println("\n>>Lựa chọn phải là số!");
															}
															sc.nextLine();
															switch (b) {
															case 1: {
																continue tkhoan;
															}
															case 2: {
																continue menu;
															}
															case 3: {
																System.exit(0);
															}
															default: {
																System.out.println(
																		"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
																continue tk_next;
															}
															}
														}
													}
													case 3: {
																 // edit tài khoản của khách hàng 
																 Ac.employeeEdit(); 
																 Ac.writeFile();
																 Ac.employeeDisplay(); System.out.println(
																 "___________________________________________");
																 System.out.println("Bạn có muốn tiếp tục không?");
																 System.out.println("1- Tiếp tục");
																 System.out.println("2- Quay lại menu chính");
																 System.out.println("3 -Thoát"); System.out.println(
																 "___________________________________________");
														tk_next: while (true) {
															int b = 0;
															System.out.print("Nhập vào sự lựa chọn của bạn:");
															try {
																b = sc.nextInt();
															} catch (InputMismatchException ex) {
																System.out.println("\n>>Lựa chọn phải là số!");
															}
															sc.nextLine();
															switch (b) {
															case 1: {
																continue tkhoan;
															}
															case 2: {
																continue menu;
															}
															case 3: {
																System.exit(0);
															}
															default: {
																System.out.println(
																		"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
																continue tk_next;
															}
															}
														}
													}
													case 4: {
																  //tìm kiếm tài khoản của khách hàng
																  Ac.search();
																  System.out.println(
																  "___________________________________________");
																  System.out.println("Bạn có muốn tiếp tục không?");
																  System.out.println("1- Tiếp tục");
																  System.out.println("2- Quay lại menu chính");
																  System.out.println("3 -Thoát"); System.out.println(
																  "___________________________________________");
																 
														tk_next: while (true) {
															int b = 0;
															System.out.print("Nhập vào sự lựa chọn của bạn:");
															try {
																b = sc.nextInt();
															} catch (InputMismatchException ex) {
																System.out.println("\n>>Lựa chọn phải là số!");
															}
															sc.nextLine();
															switch (b) {
															case 1: {
																continue tkhoan;
															}
															case 2: {
																continue menu;
															}
															case 3: {
																System.exit(0);
															}
															default: {
																System.out.println(
																		"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
																continue tk_next;
															}
															}
														}
													}
													case 5: {
														continue menu;
													}
													case 6: {
														System.exit(0);
													}
													default: {
														System.out.println(
																"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 6.\n");
														continue chon_tk;
													}
													}
												}
											  }
										    }
											case 2:{// Đây là code quản lí hóa đơn
												 // đọc file lấy dữ liệu
												 ab.readFile();
												 ab.readFileBillDetails();
												 abd.readFile();
												 abd.readFileBill();
												 if(ab.fileNull()){
												 System.out.println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
												 ab.inputBill();
												 abd.inputBillDetails();
												 ab.writeFile();
												 abd.writeFile();
												 ab.readFile();
												 ab.readFileBillDetails();
												 abd.readFile();
												 ab.display();
												 abd.display();
												 } else
												 { ab.display();
												   abd.display(); 
												 }
												tim: while (true) {
													System.out.println(" ________________________________________________");
													System.out.println("|_________________QUẢN LÝ HÓA ĐƠN________________|");
													System.out.println("|                                                |");
													System.out.println("|   1- Tạo hóa đơn                               |");
													System.out.println("|   2- Tìm kiếm phiếu xuất                       |");
													System.out.println("|   3- Tìm kiếm chi tiết phiếu xuất              |");
													System.out.println("|   4- Quay lại menu chính                       |");
													System.out.println("|   5- Thoát                                     |");
													System.out.println("|________________________________________________|\n");
													search: while (true) {
														int p = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															p = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (p) {
														case 1:{
															abd.readFileProduct();
															abd.readFileCustomer();
															abd.readFileBill();
															abd.billSale();
															abd.writeFileProduct();
															abd.writeFile();
															abd.writeFileBill();
															System.out.println("___________________________________________");
															System.out.println("Bạn có muốn tiếp tục không?");
															System.out.println("1- Tiếp tục");
															System.out.println("2- Quay lại menu chính");
															System.out.println("3 -Thoát");
															System.out.println("___________________________________________");
															px_next: while (true) {
																int b = 0;
																System.out.print("Nhập vào sự lựa chọn của bạn:");
																try {
																	b = sc.nextInt();
																} catch (InputMismatchException ex) {
																	System.out.println("\n>>Lựa chọn phải là số!");
																}
																sc.nextLine();
																switch (b) {
																case 1: {
																	continue tim;
																}
																case 2: {
																	continue menu;
																}
																case 3: {
																	System.exit(0);
																}
																default: {
																	System.out.println(
																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
																	continue px_next;
																}
																}
															}
														}
														case 2: {
																	 //tìm kiếm phiếu xuất 
																ab.search();
															System.out.println("___________________________________________");
															System.out.println("Bạn có muốn tiếp tục không?");
															System.out.println("1- Tiếp tục");
															System.out.println("2- Quay lại menu chính");
															System.out.println("3 -Thoát");
															System.out.println("___________________________________________");
															px_next: while (true) {
																int b = 0;
																System.out.print("Nhập vào sự lựa chọn của bạn:");
																try {
																	b = sc.nextInt();
																} catch (InputMismatchException ex) {
																	System.out.println("\n>>Lựa chọn phải là số!");
																}
																sc.nextLine();
																switch (b) {
																case 1: {
																	continue tim;
																}
																case 2: {
																	continue menu;
																}
																case 3: {
																	System.exit(0);
																}
																default: {
																	System.out.println(
																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
																	continue px_next;
																}
																}
															}
														}
														case 3: {
																	 //HIển thị chi tiết phiếu xuất ctpx.docfile();
																	 abd.search();
															System.out.println("___________________________________________");
															System.out.println("Bạn có muốn tiếp tục không?");
															System.out.println("1- Tiếp tục");
															System.out.println("2- Quay lại menu chính");
															System.out.println("3 -Thoát");
															System.out.println("___________________________________________");
															ctpx_next: while (true) {
																int b = 0;
																System.out.print("Nhập vào sự lựa chọn của bạn:");
																try {
																	b = sc.nextInt();
																} catch (InputMismatchException ex) {
																	System.out.println("\n>>Lựa chọn phải là số!");
																}
																sc.nextLine();
																switch (b) {
																case 1: {
																	continue tim;
																}
																case 2: {
																	continue menu;
																}
																case 3: {
																	System.exit(0);
																}
																default: {
																	System.out.println(
																			"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
																	continue ctpx_next;
																}
																}
															}
														}
														case 4:{
															continue menu;
														}
														case 5: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị 1 hoặc 2.\n");
															continue search;
														}
														}
													}
												}
											}
											case 3:{
												//QL Khách Hàng  
												cus.readFile();
												if(cus.fileNull()){
													System.out.
													println("\n>>File đang rỗng. Vui lòng nhập dữ liệu vào file.");
													cus.inputCustomer();
													cus.writeFile();
													cus.readFile(); 
													cus.display(); }
												else
													cus.display();
										khachhang: while (true) {
											System.out.println(" _____________________________________________");
											System.out.println("|_____________QUẢN LÝ KHÁCH HÀNG______________|");
											System.out.println("|                                             |");
											System.out.println("|   1- Thêm khách hàng                        |");
											System.out.println("|   2- Xóa khách hàng                         |");
											System.out.println("|   3- Sửa thông tin khách hàng               |");
											System.out.println("|   4- Tìm kiếm thông tin khách hàng          |");
											System.out.println("|   5- Quay lại                               |");
											System.out.println("|   6- Thoát                                  |");
											System.out.println("|_____________________________________________|\n");
											chon_kh: while (true) {
												int a = 0;
												System.out.print("Nhập vào sự lựa chọn của bạn:");
												try {
													a = sc.nextInt();
												} catch (InputMismatchException ex) {
													System.out.println("\n>>Lựa chọn phải là số!");
												}
												sc.nextLine();
												switch (a) {
												case 1: {
															  // thêm khách hàng 
															 cus.add(); 
															 cus.writeFile();
															 cus.readFile();
															 cus.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													kh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue khachhang;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue kh_next;
														}
														}
													}
												}
												case 2: {
															 // xóa khách hàng
															 cus.remove(); 
															 cus.writeFile();
															 cus.readFile();
															 cus.display();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													kh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue khachhang;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue kh_next;
														}
														}
													}

												}
												case 3: {
														    // chỉnh sửa danh sách khách hàng 
													 		 cus.edit(); 
													 		 cus.writeFile();
															 cus.readFile();
															 cus.display();
															 
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													kh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue khachhang;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue kh_next;
														}
														}
													}
												}
												case 4: {
													cus.search();
													System.out.println("___________________________________________");
													System.out.println("Bạn có muốn tiếp tục không?");
													System.out.println("1- Tiếp tục");
													System.out.println("2- Quay lại menu chính");
													System.out.println("3 -Thoát");
													System.out.println("___________________________________________");
													kh_next: while (true) {
														int b = 0;
														System.out.print("Nhập vào sự lựa chọn của bạn:");
														try {
															b = sc.nextInt();
														} catch (InputMismatchException ex) {
															System.out.println("\n>>Lựa chọn phải là số!");
														}
														sc.nextLine();
														switch (b) {
														case 1: {
															continue khachhang;
														}
														case 2: {
															continue menu;
														}
														case 3: {
															System.exit(0);
														}
														default: {
															System.out.println(
																	"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 3.\n");
															continue kh_next;
														}
														}
													}
												}
												case 5: {
													continue menu;
												}
												case 6: {
													System.exit(0);
												}
												default: {
													System.out.println(
															"\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 6.\n");
													continue chon_kh;
												}
												}
											}
										}
											}
											case 4:{
												System.exit(0);
											}
									   }
								  }
							  }
						  } else {
								System.out.println("\n>>Sai mật khẩu. Vui lòng nhập lại.");
								continue loginpwd;
							}
					    }
					 }else {
							System.out.println("\n>>Tên tài khoản này không đúng. Vui lòng nhập lại.");
							continue loginSalesMan;
						}
					}
				}
				case 4:{
					Ac.readFile();
					Ac.readFileCustomer();
					Ac.signUp();
					System.out.println("Đăng kí thành công!!!!");
					continue login;
				}
				case 5:
				{
					System.out.println("Cảm ơn bạn đã sử dụng phần mềm của chúng tôi :))))");
					System.exit(0);
					break loop;
				}
				default: {
					System.out.println("\n>>Không hợp lệ. Mời bạn nhập lại giá trị từ 1 đến 5.\n");
					continue loop;
				}
				}
			}
		}
	}
}					