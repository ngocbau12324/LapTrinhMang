/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author xenov
 */
public class Account {
    private String username;
    private String pw;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Account(String username, String pw) {
        this.username = username;
        this.pw = pw;
    }
    public Account(){}
    public Account(Account acc){
        this(acc.username,acc.pw);
    }         
}
