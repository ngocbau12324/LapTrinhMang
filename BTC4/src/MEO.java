public class MEO extends DONGVAT implements DiChuyen {
    String maulong;
    public MEO(){};
    public MEO(String ten,int cannang, String maulong){
        super(ten,cannang);
        this.maulong=maulong;
    }

    @Override
    public void keu() {
        System.out.println("MEO MEO!!!");
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("mau long: "+maulong);
    }

    @Override
    public void dichuyen() {
        System.out.println("ĐI, Chạy, Leo trèo, Nhảy");
    }
}
