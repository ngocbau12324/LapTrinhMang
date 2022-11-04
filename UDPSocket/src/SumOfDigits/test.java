/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SumOfDigits;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author NGOC BAU
 */
public class test {
    static int findSumOfDigits(int number)  
        {     
        //variable that stores the sum      
        int sum = 0;  
        //executes until the condition becomes false  
        while (number != 0)  
        {  
        //finds the last digit from the number and add it to the variable sum      
        sum = sum + number % 10;  
        //removes the last digit  
        number = number/10;  
        }  
        //returns the sum  
        return sum;  
        } 
    public static void main(String[] args) throws IOException {     
        int dem =0;
        String path = ".\\src\\SumOfDigits\\data.txt";          
//        File file = new File(path);
//        FileWriter fw = new FileWriter(file);
//        BufferedWriter bw = new BufferedWriter(fw);
//        Random ran = new Random();
//        int number;
//        for(int i=0;i<100000;i++){
//            number = ran.nextInt(100000);
//            bw.write(Integer.toString(number));
//            bw.newLine();
//        }
//        bw.close();
//        fw.close();  
        
        //doc file data len
        Map<Integer, Integer> sumOfDigitsMap = new HashMap<>();
        FileInputStream fileInputStream = new FileInputStream(path);
        Scanner input = new Scanner(fileInputStream);
        String line;
        int number;
        while(input.hasNextLine()){
            line = input.nextLine();
            number = Integer.parseInt(line);            
            if(!sumOfDigitsMap.containsKey(number)){
                sumOfDigitsMap.put(number, findSumOfDigits(number));                
            }            
        }
//        for(int key : sumOfDigitsMap.keySet()){
//            System.out.println(key+"-"+sumOfDigitsMap.get(key));            
//        }                
    }
}
