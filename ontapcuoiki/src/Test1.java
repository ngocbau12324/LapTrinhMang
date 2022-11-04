public class Test1 {
    public static void main(String[] args) {

        Square r=new Square();
        System.out.println(r.area(5,4));
        Derived b=new Derived();
        System.out.println(b.getValue());
    }
}
