package DAL;

import java.sql.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.JOptionPane;

import Bill.BillDetails;
import GUI.billGUI;
import GUI.employeeInterfaceGUI;

// chưa tối ưu hóa code ở đây
public class billDetailsDAL {
	
	databaseConnect dc = new databaseConnect();
	public billDetailsDAL() {
		
	}
//	List<Product> productList = new ArrayList<Product>();
	// lấy tất cả oke 
	public List<BillDetails> findAll(String date) {
		List<BillDetails> billDetailsList = new ArrayList<BillDetails>();
		
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "select * from bill_details where BILL_DATE='"+date+"'";
	            
	            Statement statement = dc.connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	            
	            while (resultSet.next()) {  
	            	BillDetails std = new BillDetails(resultSet.getString("BILL_DATE"), resultSet.getInt("BILL_DETAILS_CODE"), resultSet.getInt("CUSTOMER_CODE"), 
	            				resultSet.getString("PRODUCT_CODE"), resultSet.getInt("EMPLOYEE_CODE"), resultSet.getInt("AMOUNT"), 
	            				resultSet.getInt("PRICE"), resultSet.getInt("TOTAL") ); 
	            	billDetailsList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return billDetailsList;
	}
	
	public boolean insert(BillDetails p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "insert into bill_details(BILL_DATE, BILL_DETAILS_CODE, CUSTOMER_CODE, PRODUCT_CODE, EMPLOYEE_CODE , AMOUNT, PRICE, TOTAL) values (?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setString(1, p.getBillDate());
	            statement.setInt(2, p.getBillDetailsCode());
	            statement.setInt(3, p.getCustomerCode());
	            statement.setString(4, p.getProductCode());
	            statement.setInt(5, p.getEmployeeCode());
	            statement.setInt(6, p.getAmount());
	            statement.setInt(7, p.getPrice());
	            statement.setInt(8, p.getTotal());
	            
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
	public boolean update(BillDetails p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            // phiếu chi tiết
				String sqlDetails = "update bill_details set CUSTOMER_CODE=?, PRODUCT_CODE=?, EMPLOYEE_CODE=?, AMOUNT=?, PRICE=? where BILL_DETAILS_CODE = ? AND BILL_DATE=?";
	            PreparedStatement statementDetails = dc.connection.prepareCall(sqlDetails);
	            
	            statementDetails.setInt(1, p.getCustomerCode());
	            statementDetails.setString(2, p.getProductCode());
	            statementDetails.setInt(3, p.getEmployeeCode());
	            statementDetails.setInt(4, p.getAmount());
	            statementDetails.setInt(5, p.getPrice());
	            statementDetails.setInt(6, p.getBillDetailsCode());
	            statementDetails.setString(7, p.getBillDate());
	            
	            if(statementDetails.executeUpdate()>=1) {
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
	public boolean delete(String id, String date) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "delete from bill_details where BILL_DETAILS_CODE = ? and BILL_DATE = ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setString(1, id);
	            statement.setString(2, date);
	            
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
	public List<BillDetails> findByCode(String code, String col) {
		List<BillDetails> billDetailsList = new ArrayList<BillDetails>();
		
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "select * from bill_details where "+col+" = ?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            statement.setString(1, code);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {  
	            	BillDetails std = new BillDetails(resultSet.getString("BILL_DATE"), resultSet.getInt("BILL_DETAILS_CODE"), resultSet.getInt("CUSTOMER_CODE"), 
	            				resultSet.getString("PRODUCT_CODE"), resultSet.getInt("EMPLOYEE_CODE"), resultSet.getInt("AMOUNT"), 
	            				resultSet.getInt("PRICE"), resultSet.getInt("TOTAL") ); 
	            	if(billGUI.date!=null && billGUI.date.equals(std.getBillDate())) {
	            		billDetailsList.add(std);
	            	}
	            	if(employeeInterfaceGUI.employeeCode!=-1) {
	            		billDetailsList.add(std);
	            	}
	            }
	            
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return billDetailsList;
	}
	 // check trùng mã phiếu xuất chung
	 public boolean hasBillDetailsCode(String billDate, int billDetailsCode) {
		 boolean result = false;
		 
		 if(dc.openConnection()) {
				try {
		            //query
					String sql = "select * from bill_details where BILL_DATE= '"+billDate+"' and BILL_DETAILS_CODE=" + billDetailsCode;
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
