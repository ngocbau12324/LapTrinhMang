/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.AccountDAO;
import DTO.Account;
import java.util.ArrayList;

/**
 *
 * @author xenov
 */
public class AccountBUS {
    public static ArrayList<Account> ds;
    public void docDuLieu() throws Exception{
        AccountDAO data = new AccountDAO();
        if(ds==null){
            ds=data.docDuLieu();
        }
    }
    public int Login(Account acc){
        
        for(Account a:ds){
            if(a.getUsername().equals(acc.getUsername()) && a.getPw().equals(acc.getPw()))
                return 1;
        }
        return 0;
    }
}
