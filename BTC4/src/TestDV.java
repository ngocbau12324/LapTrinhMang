public class TestDV {
    public static void main(String[] args) {
        DONGVAT[] dv=new DONGVAT[3];
        dv[0]=new CHO("GHI",16,"Dom","Co");
        dv[1]=new CHO("LULU",15,"vang","Phu Quoc");
        dv[2]=new MEO("DOREAMON",3,"xanh");
        for(int i=0;i<3;i++){
            dv[i].xuat();
            dv[i].keu();
            dv[i].dichuyen();
        }
    }
}
