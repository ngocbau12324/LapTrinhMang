package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import Users.*;

// chưa tối ưu hóa code ở đây
public class userDAL {
	
	databaseConnect dc = new databaseConnect(); 
	public userDAL() {
		
	}
//	List<user> userList = new ArrayList<user>();
	// lấy tất cả oke 
	public List<Customer> findAll() {
		List<Customer> userList = new ArrayList<Customer>();
		
		if(dc.openConnection()) {
			try {
	            
	            //query
	            String sql = "select * from user";
	            Statement statement = dc.connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	Customer std = new Customer(resultSet.getInt("ACCOUNT_ID"), resultSet.getInt("USER_CODE"), 
	                        resultSet.getString("USER_NAME"), resultSet.getString("USER_NUMBERPHONE"), 
	                        resultSet.getString("USER_ADDRESS"));
	            	userList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return userList;
	}
	
	public boolean insert(Customer p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "insert into user(ACCOUNT_ID, USER_CODE, USER_NAME, USER_NUMBERPHONE, USER_ADDRESS) values (?, ?, ?, ?, ?)";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getAccountId());
	            statement.setInt(2, p.getCustomerCode());
	            statement.setString(3, p.getCustomerName());
	            statement.setString(4, p.getNumberPhone());
	            statement.setString(5, p.getAddress());
	            
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
	public boolean update(Customer p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "update user set USER_NAME=?, USER_NUMBERPHONE=?, USER_ADDRESS=? where USER_CODE = ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setString(1, p.getCustomerName());
	            statement.setString(2, p.getNumberPhone());
	            statement.setString(3, p.getAddress());
	            statement.setInt(4, p.getCustomerCode());
	            
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
				String sql = "delete from user where USER_CODE = ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
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
	public List<Customer> findByFullName(String userName) {
		List<Customer> userList = new ArrayList<Customer>();
		
		if(dc.openConnection()) {
			try {
	            
	            //query
	            String sql = "select * from user where USER_NAME like ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            statement.setString(1, "%"+userName+"%");
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {                
	            	Customer std = new Customer(resultSet.getInt("ACCOUNT_ID"), resultSet.getInt("USER_CODE"), 
	                        resultSet.getString("USER_NAME"), resultSet.getString("USER_NUMBERPHONE"), 
	                        resultSet.getString("USER_ADDRESS"));
	            	userList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return userList;
	}
	public List<String> getUserList() {
		List<String> userList = new ArrayList<String>();
		
		if(dc.openConnection()) {
			try {
	            
	            //query
	            String sql = "select * from user";
	            Statement statement = dc.connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	String std = resultSet.getString("USER_NAME");
	            	userList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return userList;
	}
	 public boolean hasUserCode(int userCode) {
		 boolean result = false;
		 
		 if(dc.openConnection()) {
				try {
		            //query
		            String sql = "select * from user where USER_CODE=" + userCode;
		            Statement statement = dc.connection.createStatement();
		            
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
}
