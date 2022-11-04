import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập chuỗi S= ");
        String s=sc.nextLine();
        int n=s.length();
        //----------------------------Cau a----------------------------
        System.out.println("Câu a: Độ dài của chuỗi S");
        System.out.println(n);
        //----------------------------Cau b----------------------------
        System.out.println("Câu b: Xóa khoảng trắng thừa của chuỗi");
        String[]s1=s.split(" ");
        s="";
        for(String s2:s1) {
            if(s2.length()!=0) s = s.concat(s2 + " ");
        }
        s=s.trim();
        System.out.println(s);
        //----------------------------Cau c----------------------------
        System.out.println("Câu c: Đếm số từ của s");
        /*String al="qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
        int[] temp=new int[52];
        for(int i=0;i<52;i++) temp[i]=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<52;j++)
                if(s.charAt(i)==al.charAt(j)) temp[j]++;
        for(int i=0;i<al.length();i++)
            if(temp[i]>0) System.out.println(al.charAt(i)+": số lượng "+temp[i]);*/
        n=s.length();
        int soTu=1;
        for(int i=0;i<n;i++)
            if(s.charAt(i) == ' ') soTu++;
        System.out.println("Chuỗi s có "+soTu+" từ: " );
        for(int i=0;i<n;i++){
            if(s.charAt(i)==' ') System.out.println();
            else System.out.print(s.charAt(i));

        }
        //----------------------------Cau d----------------------------
        int k=6;
        System.out.println("\nCâu d: In "+k+" kí tự bên trái của s, và "+k+" kí tự bên phải của s");
        /*System.out.print("Nhập số k=");
        int k=sc.nextInt();*/
        System.out.print(k+" kí tự bên trái.");
        for(int i=0;i<k;i++)
            System.out.print(s.charAt(i));
        System.out.print("\n"+k+" kí tự bên phải.");
        for(int i=n-k;i<n;i++)
            System.out.print(s.charAt(i));
        //----------------------------Cau e----------------------------
        k=4;int m=4;
        System.out.println("\nCâu e: In ra "+m+" kí tự từ vị trí thứ"+ k);
        /*System.out.print("Nhấp số k=");
        k=sc.nextInt();
        System.out.print("Nhập số m=");
        int m=sc.nextInt();*/
        int count=0;
        System.out.print(m+" kí tự bắt đầu từ vị trí "+k+" là:");
        while(count<m && count< n ){
            System.out.print(s.charAt(k));
            k++;
            count++;
        }
    }
}
