/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.Account;
import DTO.ChiTietPhieuNhapDTO;
import MYSQL.MyDataAccess;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author xenov
 */
public class AccountDAO {
    public AccountDAO(){}
    public ArrayList<Account> docDuLieu() throws Exception{
        ArrayList<Account> ds = new ArrayList<Account>();
        MyDataAccess my = new MyDataAccess("localhost","root","","qlda");
        try {
			String qry = "select * from account";
			ResultSet rs = my.executeQuery(qry);
			while(rs.next()) {
				Account acc = new Account();
				acc.setUsername(rs.getString(1));
				acc.setPw(rs.getString(2));
				ds.add(acc);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage()+"09");
			JOptionPane.showMessageDialog(null,"Lỗi đọc Database");
		}
                finally{
                    my.close();
                }
		return ds;
    }
}
