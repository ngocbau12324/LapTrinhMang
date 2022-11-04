import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBai7 extends JFrame {
    JFrame frame=new JFrame();
    JPanel p1,p2,p3,p4,p5;
    JLabel lbNum,lbChon,lbTB,lbKQ;
    JTextField txNum;
    JButton btTieptuc,btThoat,btKQ;
    JComboBox cb;
    String data;
    public GuiBai7(){
        setSize(800,200);
        setLayout(new GridLayout(5,1));
        p1=new JPanel();
        add(p1);
        lbNum=new JLabel("Nhập số nguyên N");
        p1.add(lbNum);
        txNum=new JTextField(10);
        p1.add(txNum);

        p2=new JPanel();
        add(p2);
        lbChon=new JLabel("Chọn yêu cầu");
        p2.add(lbChon);
        String cn[]={"a. Các số tự nhiên <=N và tổng của chúng.",
                "b. Các số tự nhiên chẵn <=N và tổng của chúng",
                "c. Các số tự nhiên lẻ <=N và tổng của chúng",
                "d. Các số tự nhiên là số nguyên tố <=N và tổng của chúng",
                "e. N số nguyên tố đầu tiên"};
        cb=new JComboBox(cn);
        cb.setSelectedIndex(0);
        p2.add(cb);
        btKQ=new JButton("Kết quả");
        p2.add(btKQ);
        btKQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yeuCau="";
                if(cb.getSelectedIndex()!=-1){
                    yeuCau= (String) cb.getItemAt(cb.getSelectedIndex())+" là: ";
                    int index=cb.getSelectedIndex();
                    if(index==0) CauA(txNum.getText());
                    else if(index==1) CauB(txNum.getText());
                    else if(index==2) CauC(txNum.getText());
                    else if(index==3) CauD(txNum.getText());
                    else CauE(txNum.getText());
                }
                lbTB.setText(yeuCau);
                lbKQ.setText(data);
            }
        });

        p3=new JPanel();
        add(p3);
        lbTB=new JLabel("Yêu cầu",JLabel.CENTER);
        p3.add(lbTB);

        p4=new JPanel();
        add(p4);
        lbKQ=new JLabel("Kết quả",JLabel.CENTER);
        p4.add(lbKQ);

        p5=new JPanel();
        add(p5);

        btTieptuc=new JButton("Tiếp tục");
        p5.add(btTieptuc);
        btTieptuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txNum.setText(null);
                lbTB.setText("Yêu cầu");
                lbKQ.setText("Kết quả");
                cb.setSelectedIndex(0);
            }
        });
        btThoat=new JButton("Thoát");
        p5.add(btThoat);
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public boolean checkPrime(int a){
        if(a<2)return false;
        for(int i=2;i<=Math.sqrt(a);i++)
            if(a%i==0)return false;
        return true;
    }
    public void CauA(String s){
        int n=Integer.parseInt(s);
        int sum=0;
         data="";
        for(int i=0;i<=n;i++){
            data+=i+" ";
            sum+=i;
        }
        data+=",Tổng = "+sum;
    }
    public void CauB(String s){
        int n=Integer.parseInt(s);
        int sum=0;
         data="";
        for(int i=0;i<=n;i++){
            if(i%2==0){data+=i+" ";
                sum+=i;}
        }
        data+=",\n Tổng = "+sum;
    }
    public void CauC(String s){
        int n=Integer.parseInt(s);
        int sum=0;
         data="";
        for(int i=0;i<=n;i++){
            if(i%2!=0){data+=i+" ";
                sum+=i;}
        }
        data+=", Tổng = "+sum;
    }
    public void CauD(String s){
        int n=Integer.parseInt(s);
        int sum=0;
         data="";
        for(int i=0;i<=n;i++){
            if(checkPrime(i)){data+=i+" ";
                sum+=i;}
        }
        data+=", Tổng = "+sum;
    }
    public void CauE(String s){
        int n=Integer.parseInt(s);
         data="";
        int count=0,i=2;
        while(count!=n){
            if(checkPrime(i)){
                count++;
                data+=i+" ";
            }
            i++;
        }
    }
    public static void main(String[] args) {
        new GuiBai7();
    }
}
