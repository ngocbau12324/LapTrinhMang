package DAL;

import java.sql.*;
import java.util.*;

import EnterCoupon.EnterCouponDetails;
import GUI.billGUI;
import GUI.employeeInterfaceGUI;
import GUI.enterCouponGUI;

public class enterCouponDetailsDAL {
	databaseConnect dc = new databaseConnect();
	enterCouponDAL ecd = new enterCouponDAL();
	public enterCouponDetailsDAL() {
		
	}
//	List<Product> productList = new ArrayList<Product>();
	// lấy tất cả oke 
	public List<EnterCouponDetails> findAll(String date) {
		List<EnterCouponDetails> enterCouponDetailsList = new ArrayList<EnterCouponDetails>();
		
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "select * from enter_coupon_details where enter_coupon_details.COUPON_DATE= '"+date+"' ";
	            Statement statement = dc.connection.createStatement();
	            
	            ResultSet resultSet = statement.executeQuery(sql);
	           
	            while (resultSet.next()) {                
	            	EnterCouponDetails std = new EnterCouponDetails(resultSet.getString("COUPON_DATE"), resultSet.getString("COUPON_CODE_DETAILS"),
	                        resultSet.getString("PRODUCT_CODE"), resultSet.getInt("SUPPLIER_CODE"),  
	                        resultSet.getInt("EMPLOYEE_CODE"), resultSet.getInt("PRICE"), resultSet.getInt("IMPORT_PRICE"),
	                        resultSet.getInt("AMOUNT"), resultSet.getInt("TOTAL"));
	            	enterCouponDetailsList.add(std);
	            }
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return enterCouponDetailsList;
	}
	
	public boolean insert(EnterCouponDetails p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "insert into enter_coupon_details(COUPON_DATE, COUPON_CODE_DETAILS, PRODUCT_CODE, SUPPLIER_CODE, EMPLOYEE_CODE, PRICE, IMPORT_PRICE, AMOUNT, TOTAL) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setString(1, p.getCouponDate());
	            statement.setString(2, p.getEnterCouponCodeDetails());
	            statement.setString(3, p.getProductCode());
	            statement.setInt(4, p.getSupplierCode());
	            statement.setInt(5, p.getEmployeeCode());
	            statement.setInt(6, p.getPrice());
	            statement.setInt(7, p.getImportPrice());
	            statement.setInt(8, p.getAmount());
	            statement.setInt(9, p.getImportPrice() * p.getAmount());
	            
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
	public boolean update(EnterCouponDetails p) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "update enter_coupon_details set PRODUCT_CODE=?, SUPPLIER_CODE=?, EMPLOYEE_CODE=?, PRICE=?, IMPORT_PRICE=?, AMOUNT=?, TOTAL=? where COUPON_CODE_DETAILS=? and COUPON_DATE=?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            
	            statement.setString(1, p.getProductCode());
	            statement.setInt(2, p.getSupplierCode());
	            statement.setInt(3, p.getEmployeeCode());
	            statement.setInt(4, p.getPrice());
	            statement.setInt(5, p.getImportPrice());
	            statement.setInt(6, p.getAmount());
	            statement.setInt(7, p.getImportPrice() * p.getAmount());
	            statement.setString(8, p.getEnterCouponCodeDetails());
	            statement.setString(9, p.getCouponDate());
	            
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
	public boolean delete(String id, String date) {
		boolean result = false;
		if(dc.openConnection()) {
			try {
	            //query
				String sql = "delete from enter_coupon_details where COUPON_CODE_DETAILS = ? and COUPON_DATE = ?";
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
	
	public List<EnterCouponDetails> findByCode(String code) {
		List<EnterCouponDetails> enterCouponDetailsList = new ArrayList<EnterCouponDetails>();
		
		if(dc.openConnection()) {
			try {
	            //query
	            String sql = "select * from enter_coupon_details where PRODUCT_CODE=?";
	            PreparedStatement statement = dc.connection.prepareCall(sql);
	            statement.setString(1, code);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {                
	            	EnterCouponDetails std = new EnterCouponDetails(resultSet.getString("COUPON_DATE"), resultSet.getString("COUPON_CODE_DETAILS"),
	                        resultSet.getString("PRODUCT_CODE"), resultSet.getInt("SUPPLIER_CODE"),  
	                        resultSet.getInt("EMPLOYEE_CODE"), resultSet.getInt("PRICE"), resultSet.getInt("IMPORT_PRICE"), resultSet.getInt("AMOUNT"), resultSet.getInt("TOTAL"));
	            	if(enterCouponGUI.code!=null && enterCouponGUI.code.equals(std.getCouponDate())) {
	            		enterCouponDetailsList.add(std);
	            	}
	            }
	            
	        } catch(SQLException e) {
	        	System.out.println(e);
	        }
			finally {
				dc.closeConnection();
			}
		}
		return enterCouponDetailsList;
	}
	 // check trùng mã hóa đơn chi tiết
	 public boolean hasEnterCouponDetails(String couponDate, String couponCodeDetails) {
		 boolean result = false;
		 
		 if(dc.openConnection()) {
				try {
		            //query
		            String sql = "select * from enter_coupon_details where COUPON_DATE='"+couponDate+"' and COUPON_CODE_DETAILS=" + couponCodeDetails;
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
