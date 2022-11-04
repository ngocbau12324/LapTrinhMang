package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import Account.Account;
import GUI.employeeInterfaceGUI;
import Users.Customer;

// chưa tối ưu hóa code ở đây
public class accountDAL {
	databaseConnect dc = new databaseConnect();
	public accountDAL() {
		
	}
//	List<bac_si> bac_siList = new ArrayList<bac_si>();
	// lấy tất cả oke 
	public List<Account> findAll() {
		List<Account> accountList = new ArrayList<Account>();
		
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "select * from account";
	            Statement statement = dc.connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	Account std = new Account(resultSet.getInt("ID"), 
	                        resultSet.getString("USERNAME"), resultSet.getString("PASSWORD"), 
	                        resultSet.getString("PERMISSION"));
	            	accountList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return accountList;
	}
	
	public boolean insert(Account p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "insert into account(ID, USERNAME, PASSWORD, PERMISSION) values (?, ?, ?, ?)";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setInt(1, p.getId());
	            statement.setString(2, p.getAccountName());
	            statement.setString(3, p.getPassword());
	            statement.setString(4, p.getPermission());
	            
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
	public boolean update(Account p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "update account set USERNAME=?, PASSWORD=?, PERMISSION=? where ID=?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setString(1, p.getAccountName());
	            statement.setString(2, p.getPassword());
	            statement.setString(3, p.getPermission());
	            statement.setInt(4, p.getId());
	            
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
	public boolean delete(int id) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "delete from account where ID = ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setInt(1, id);
	            
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
	public List<Account> findByCode(int acccountCode) {
		List<Account> accountList = new ArrayList<Account>();
		
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "select * from account where ID = ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            statement.setInt(1, acccountCode);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {                
	            	Account std = new Account(resultSet.getInt("ID"), 
	                        resultSet.getString("USERNAME"), resultSet.getString("PASSWORD"), 
	                        resultSet.getString("PERMISSION"));
	            	if(employeeInterfaceGUI.employeeCode!=-1) {
	            		String permission = resultSet.getString("PERMISSION");
		            	if(!permission.equals("admin") && !permission.equals("Nhân viên")) {
		            		accountList.add(std);
		            	}
	            	}
	            	else {
	            		accountList.add(std);
	            	}
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return accountList;
	}
	 // check trùng mã sản phẩm
	 public boolean hasAccountCode(int code) {
		 boolean result = false;
		 
		 if(dc.openConnection()) {
				try {
		            //query
		            String sql = "select * from account where ID=" + code;
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
	 
	 public int code(String accountName) {
		 int code = -1;
		 if(dc.openConnection()) {
				try {
		            //query
		            String sql = "select ID from account where USERNAME = '"+accountName+"' ";
		            Statement statement = dc.connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	code = resultSet.getInt("ID");
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					dc.closeConnection();
				}
			}
		 return code;
	 }
	 
	 public String getPermission(int code) {
		 String permission = "";
		 if(dc.openConnection()) {
				try {
		            //query
		            String sql = "select PERMISSION from account where ID =" + code;
		            Statement statement = dc.connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	permission = resultSet.getString("PERMISSION");
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					dc.closeConnection();
				}
			}
		 return permission;
	 }
	 
	 public int getCode(String table, String dataToGet, String name, String col) {
			int data = -1;
			if(dc.openConnection()) {
				try {
		            //query
		            String sql = "select " + dataToGet + " from " + table + " where " + col + " =  "+name+" " ;
		            Statement statement = dc.connection.createStatement();
		            
		            ResultSet resultSet = statement.executeQuery(sql);
		           
		            while (resultSet.next()) {                
		            	data = resultSet.getInt(dataToGet);
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					dc.closeConnection();
				}
			}
			
			return data;
		}
	 // hàm sửa tài khoản của người dùng
	 
	 public boolean updateUser(Account p, Customer c, int userCode, int accountCode) {
			boolean result = false;
			if(dc.openConnection()) {
				try {
		            //query account 
					String sql = "update account set PASSWORD=? where ID=?";
		            PreparedStatement statement = dc.connection.prepareCall(sql);
		            
		            statement.setString(1, p.getPassword());
		            statement.setInt(2, accountCode);
		            
		            //query Customer
		            String sql1 = "update user set USER_NAME=?, USER_NUMBERPHONE=?, USER_ADDRESS=? where USER_CODE=?";
		            PreparedStatement statement1 = dc.connection.prepareCall(sql1);
		            
		            statement1.setString(1, c.getCustomerName());
		            statement1.setString(2, c.getNumberPhone());
		            statement1.setString(3, c.getAddress());
		            statement1.setInt(4, userCode);
		            
		            if(statement.executeUpdate()>=1 && statement1.executeUpdate()>=1) {
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
	 public int getAccountId() {
			int accountId = -1;
			
			if(dc.openConnection()) {
				try {
		            //query
		            String sql = "select MAX(ID) from account";
		            PreparedStatement statement = dc.connection.prepareCall(sql);
		            
		            ResultSet resultSet = statement.executeQuery();
		            
		            while (resultSet.next()) {                
		            	accountId = resultSet.getInt("MAX(ID)") + 1; 
		            }
		        } catch(SQLException e) {
		        	System.out.println(e);
		        }
				finally {
					dc.closeConnection();
				}
			}
			return accountId;
		}
}
