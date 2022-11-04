package BLL;

import java.util.*;
import DAL.userDAL;
import Users.*;

public class userBLL {
	userDAL usrDAL = new userDAL();
	
	public List<Customer> getAllUser() {
		return usrDAL.findAll();
	}
	
	public String addUser(Customer p) {
		if(usrDAL.hasUserCode(p.getCustomerCode())) {
			return "Mã người dùng này đã tồn tại. Vui lòng thử lại";
		}
		if(usrDAL.insert(p)) {
			return "Thêm người dùng thành công";
		}
		return "Thêm người dùng không thành công";
	}
	
	public String deleteUser(String id) {
		if(usrDAL.delete(id)) {
			return "Xóa người dùng thành công";
		}
		return "Xóa người dùng không thành công";
	}
	
	public String editUser(Customer p) {
		if(usrDAL.update(p)) {
			return "Sửa người dùng thành công";
		}
		return "Sửa người dùng không thành công";
	}
	
	
	public List<Customer> searchUserByName(String userName) {
		return usrDAL.findByFullName(userName);
	}
	
	public List<String> getUserList() {
		return usrDAL.getUserList();
	}

}
