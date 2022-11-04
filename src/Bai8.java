import java.util.Scanner;

public class Bai8 {
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
        //----------------------------Khởi tạo mang----------------------------
        do {
            System.out.print("Nhap so phan tu cua mang (N>0): ");
            n=sc.nextInt();
        }while (n<=0);
        int[] arr=new int[100];
        for(int i=0;i<n;i++){
            System.out.print("Nhap phan tu thu "+(i+1)+": ");
            arr[i]=sc.nextInt();
        }
        int sum=0;
        //----------------------------Cau a----------------------------
        System.out.println("Cau a: In ra cac phan tu cua mang va tong cua chung");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
            sum+=arr[i];
        }
        System.out.println("\nTong= "+sum);
        //----------------------------Cau b----------------------------
        System.out.println("Cau b: In ra cac phan tu chan cua mang va tong cua chung");
        sum=0;
        for(int i=0;i<n;i++)
            if(arr[i]%2==0){
            System.out.print(arr[i]+" ");
            sum+=arr[i];
        }
        System.out.println("\nTong= "+sum);
        //----------------------------Cau c----------------------------
        System.out.println("Cau c: In ra cac phan tu le cua mang va tong cua chung");
        sum=0;
        for(int i=0;i<n;i++)
            if(arr[i]%2!=0){
                System.out.print(arr[i]+" ");
                sum+=arr[i];
            }
        System.out.println("\nTong= "+sum);
        //----------------------------Cau d----------------------------
        System.out.println("Cau d: In ra cac so nguyen to cua mang va tong cua chung");
        sum=0;
        for(int i=0;i<n;i++)
            if(isPrime(arr[i])){
                System.out.print(arr[i]+" ");
                sum+=arr[i];
            }
        if(sum!=0)System.out.println("\nTong= "+sum);
        else System.out.println("KHONG co so nguyen to trong mang.");
        //----------------------------Cau e----------------------------
        System.out.println("Cau e: Them 1 phan tu moi vao mang");
        System.out.print("Nhập phần tử muốn thêm a=");
        int a=sc.nextInt();
        int k;
        do {
            System.out.print("Nhập vị trí muốn thêm k=");
            k = sc.nextInt();
        }while((k<0)||(k>=n));
        for(int i=n;i>k;i--){
            arr[i]=arr[i-1];
        }
        arr[k]=a;
        n++;
        System.out.println("Cac phan tu cua mang sau khi them: ");
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        //----------------------------Cau f----------------------------
        System.out.println("\nCau f: Xoa phan tu tai vi tri k");
        System.out.print("Nhập vị trí muốn xóa k=");
        k=sc.nextInt();
        for(int i=k;i<n-1;i++)
            arr[i]=arr[i+1];
        n--;
        System.out.println("Cac phan tu cua mang sau khi xoa: ");
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
        //----------------------------Cau g----------------------------
        System.out.print("\nCau g: Nhap so muon tim kiems x= ");
        int x=sc.nextInt();
        int count=0;
        for(int i=0;i<n;i++)
            if(arr[i]==x){
                System.out.println(x+" nằm ở vị trí "+i);
                count++;
            }
        if(count==0) System.out.println("KHÔNG TÌM THẤY "+x);
    }
}
