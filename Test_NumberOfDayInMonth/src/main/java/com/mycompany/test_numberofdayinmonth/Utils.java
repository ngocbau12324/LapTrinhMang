/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test_numberofdayinmonth;

/**
 *
 * @author NGOC BAU
 */
public class Utils {
    public static int findNumberOfDaysInMonth(int month, int year){
        int number_Of_DaysInMonth = 0;
        switch (month) {
            case 1:                
                number_Of_DaysInMonth = 31;
                break;
            case 2:                
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    number_Of_DaysInMonth = 29;
                } else {
                    number_Of_DaysInMonth = 28;
                }
                break;
            case 3:               
                number_Of_DaysInMonth = 31;
                break;
            case 4:                
                number_Of_DaysInMonth = 30;
                break;
            case 5:                
                number_Of_DaysInMonth = 31;
                break;
            case 6:                
                number_Of_DaysInMonth = 30;
                break;
            case 7:                
                number_Of_DaysInMonth = 31;
                break;
            case 8:                
                number_Of_DaysInMonth = 31;
                break;
            case 9:                
                number_Of_DaysInMonth = 30;
                break;
            case 10:                
                number_Of_DaysInMonth = 31;
                break;
            case 11:                
                number_Of_DaysInMonth = 30;
                break;
            case 12:                
                number_Of_DaysInMonth = 31;
        }
        return number_Of_DaysInMonth;
    }    
}
