public class CHO extends DONGVAT implements DiChuyen{
    String maulong;
    String giong;
    public CHO(){};
    public CHO(String ten, int cannang,String maulong,String giong){
        super(ten,cannang);
        this.maulong=maulong;
        this.giong=giong;
    }

    @Override
    public void keu() {
        System.out.println("GAU GAUU!!");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("mau long va giong: "+maulong+" "+giong );

    }

    @Override
    public void dichuyen() {
        System.out.println("Đi, Chạy");
    }
}
