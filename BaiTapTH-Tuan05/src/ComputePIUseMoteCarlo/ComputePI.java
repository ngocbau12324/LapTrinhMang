/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComputePIUseMoteCarlo;

/**
 *
 * @author NGOC BAU
 */
public class ComputePI {
    int n;
    public double computePIUseMoteCarlo(int a){
        int i;
        double x,y;  
        int nThrows=0;
        int nSuccess=0;
        for(i=0;i<a;i++){
            x=Math.random();//Ném phi tiêu
            y=Math.random();
            
            nThrows++;//Số lần ném
            
            if(x*x+y*y < 1) nSuccess++;// Số lần ném trong vòng tròn
        }
        return 4*(double)nSuccess/(double)nThrows;
    }
    public static void main(String[] args) {
        ComputePI c =new ComputePI();
        System.out.println(c.computePIUseMoteCarlo(100000000));
    }
}
