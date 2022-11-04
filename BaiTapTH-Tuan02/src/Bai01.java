
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NGOC BAU
 */
/* StringTokenizer
*/
public class Bai01 {
    public static void main(String[] args) {
        /*Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập phép tính: ");
        String pt=scanner.nextLine();
        String[] n= pt.split("[+,-,*,/]");
        int n1=Integer.parseInt(n[0]);
        int n2=Integer.parseInt(n[1]);
        System.out.println(n1+n2);*/
        int num1, num2;
        float result=0;
        String op;
        Scanner input=new Scanner(System.in);
        System.out.print("Input: ");
        String data=input.nextLine();
        StringTokenizer st=new StringTokenizer(data, "+-*/",true);//có true thì in ra cả dấu phép tính
        num1=Integer.parseInt(st.nextToken());
        op=st.nextToken();
        num2=Integer.parseInt(st.nextToken());
        switch (op){
            case "+":
                result=num1+num2;
                break;
            case "-":
                result=num1-num2;
                break;
            case "*":
                result=num1*num2;
                break;
            case "/":
                result=num1/num2;
                break;
            default:
                break;
        }
        System.out.println("Out put: "+result);
    }
    
}
