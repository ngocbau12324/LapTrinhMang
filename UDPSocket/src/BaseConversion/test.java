/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseConversion;

/**
 *
 * @author NGOC BAU
 */
public class test {
   public static String baseConversion(String number, int sBase, int dBase1, int dBase2){
       return Integer.toString(Integer.parseInt(number,sBase),dBase1)+"-"+Integer.toString(Integer.parseInt(number,sBase),dBase2);
   } 
    public static void main(String[] args) {
        System.out.println(baseConversion("555", 10, 2,16));
    }
}
