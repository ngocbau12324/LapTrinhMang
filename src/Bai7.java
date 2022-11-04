import java.util.Scanner;

public class Bai7 {
    //----------------------------Hàm kiểm tra số nguyên tố----------------------------
    public static boolean isPrime(int n){
        if(n<2)return false;
        for(int i=2;i<=Math.sqrt(n);i++)
            if(n%i==0)return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        do {
            System.out.print("N=");
            n = sc.nextInt();
            if(n<=0) System.out.println("Nhap lai, N>0");
        }while (n<=0);
        int sum;
        //--------------------------Cau a--------------------------
        System.out.println("Cau a: Cac so tu nhien <= "+n);
        sum=0;
        for(int i=0;i<=n;i++){
            sum+=i;
            System.out.print(i+" ");
        }
        System.out.println(", sum= "+sum);
        //--------------------------Cau b--------------------------
        System.out.println("Cau b: Cac so tu nhien chan <= "+n);
        sum=0;
        for(int i=0;i<=n;i++)
            if(i%2==0){
            sum+=i;
            System.out.print(i+" ");
        }
        System.out.println(", sum= "+sum);
        //--------------------------Cau c--------------------------
        System.out.println("Cau c: Cac so tu nhien le <= "+n);
        sum=0;
        for(int i=0;i<=n;i++)
            if(i%2!=0){
            sum+=i;
            System.out.print(i+" ");
        }
        System.out.println(", sum= "+sum);
        //--------------------------Cau d--------------------------
        System.out.println("Cau d: Cac so nguyen to <= "+n);
        sum=0;
        for(int i=0;i<=n;i++)
            if(isPrime(i)){
                sum+=i;
                System.out.print(i+" ");
            }
        System.out.println(", sum= "+sum);
        //--------------------------Cau e--------------------------
        System.out.println("Cau e: "+n+" so nguyen to dau tien");
        int count=0,i=1;
        while(count!=n){
            if(isPrime(++i)){
                count++;
                System.out.print(i+" ");
            }
        }
    }

}
