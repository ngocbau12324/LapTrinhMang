abstract class DONGVAT implements DiChuyen{
    String ten;
    int cannang;
    public DONGVAT(){};
    public DONGVAT(String ten, int cannang){
        this.ten=ten;
        this.cannang=cannang;
    };
    public abstract void keu();

    public void xuat(){
        System.out.println("\nTen: "+ten+"\nCan nang: "+cannang+"Kg");
    };
    public void dichuyen(){};
}
