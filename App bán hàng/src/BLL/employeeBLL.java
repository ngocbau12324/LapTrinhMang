package BLL;

import java.util.*;
import DAL.employeeDAL;
import Employee.Employee;

public class employeeBLL {
	employeeDAL emDAL = new employeeDAL();
	
	public List<Employee> getAllEmployee() {
		return emDAL.findAll();
	}
	
	public String addEmployee(Employee p) {
		if(emDAL.hasEmployeeCode(p.getEmployeeCode())) {
			return "Mã nhân viên này đã tồn tại. Vui lòng thử lại";
		}
		if(emDAL.insert(p)) {
			return "Thêm nhân viên thành công";
		}
		return "Thêm nhân viên không thành công";
	}
	
	public String deleteEmployee(String id) {
		if(emDAL.delete(id)) {
			return "Xóa nhân viên thành công";
		}
		return "Xóa nhân viên không thành công";
	}
	
	public String editEmployee(Employee p) {
		if(emDAL.update(p)) {
			return "Sửa thông tin nhân viên thành công";
		}
		return "Sửa thông tin nhân viên không thành công";
	}
	
	
	public List<Employee> searchEmployeeByName(String employeeName) {
		return emDAL.findByFullName(employeeName);
	}
	
	public List<String> geEmployeeList() {
		return emDAL.getEmployeeList();
	}
}
