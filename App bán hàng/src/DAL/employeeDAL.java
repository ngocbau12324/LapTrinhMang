package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import Employee.Employee;

// chưa tối ưu hóa code ở đây
public class employeeDAL {
	
	private Connection connection; 
	databaseConnect dc = new databaseConnect();
	public employeeDAL() {
		
	}
//	List<Product> productList = new ArrayList<Product>();
	// lấy tất cả oke 
	public List<Employee> findAll() {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		if(dc.openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_project?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from employee";
	            Statement statement = connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	Employee std = new Employee(resultSet.getInt("ACCOUNT_ID"), resultSet.getString("EMPLOYEE_CODE"), 
	                        resultSet.getString("EMPLOYEE_NAME"), resultSet.getString("ADDRESS"), 
	                        resultSet.getString("NUMBER_PHONE"), resultSet.getString("BIRTHDAY"));
	            	employeeList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return employeeList;
	}
	
	public boolean insert(Employee p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "insert into employee(ACCOUNT_ID, EMPLOYEE_CODE, EMPLOYEE_NAME, ADDRESS, NUMBER_PHONE, BIRTHDAY) values (?, ?, ?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setInt(1, p.getAccountId());
	            statement.setString(2, p.getEmployeeCode());
	            statement.setString(3, p.getEmployeeName());
	            statement.setString(4, p.getAddress());
	            statement.setString(5, p.getNumberPhone());
	            statement.setString(6, p.getBirthday());
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return result;
	}
	
	 // sửa oke
	public boolean update(Employee p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "update employee set EMPLOYEE_NAME=?, ADDRESS=?, NUMBER_PHONE=?, BIRTHDAY=? where EMPLOYEE_CODE = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setString(1, p.getEmployeeName());
	            statement.setString(2, p.getAddress());
	            statement.setString(3, p.getNumberPhone());
	            statement.setString(4, p.getBirthday());
	            statement.setString(5, p.getEmployeeCode());
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return result;
	}
	public boolean delete(String id) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "delete from employee where EMPLOYEE_CODE = ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            
	            statement.setString(1, id);
	            
	            if(statement.executeUpdate()>=1) {
	            	result = true;
	            }
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return result;
	}
	public List<Employee> findByFullName(String employeeName) {
		List<Employee> employeeList = new ArrayList<Employee>();
		
		if(dc.openConnection()) {
			try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_project?useSSL=false", "root", "");
	            
	            //query
	            String sql = "select * from employee where EMPLOYEE_NAME like ?";
	            PreparedStatement statement = connection.prepareCall(sql);
	            statement.setString(1, "%"+employeeName+"%");
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {    
	            	Employee std = new Employee(resultSet.getInt("ACCOUNT_ID"), resultSet.getString("EMPLOYEE_CODE"), 
	                        resultSet.getString("EMPLOYEE_NAME"), resultSet.getString("ADDRESS"), 
	                        resultSet.getString("NUMBER_PHONE"), resultSet.getString("BIRTHDAY"));
	            	employeeList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return employeeList;
	}
	 // check trùng mã nhân viên 
	 public boolean hasEmployeeCode(String employeeCode) {
		 boolean result = false;
		 
		 if(dc.openConnection()) {
				try {
		            //query
		            String sql = "select * from employee where 	EMPLOYEE_CODE=" + employeeCode;
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            result = resultSet.next();
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					dc.closeConnection();
				}
			}
		 
		 return result;
	 }
	 
	 public List<String> getEmployeeList() {
			List<String> employeeList = new ArrayList<String>();
			
			if(dc.openConnection()) {
				try {
		            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_project?useSSL=false", "root", "");
		            
		            //query
		            String sql = "select * from employee";
		            Statement statement = connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	String std = resultSet.getString("EMPLOYEE_NAME");
		            	employeeList.add(std);
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					dc.closeConnection();
				}
			}
			return employeeList;
		}
}
