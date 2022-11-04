import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GuiBai8 extends JFrame {
    JFrame frame=new JFrame();
    JPanel p1,p2,p3,p4,p5,p6,p7;
    JButton btNhap,btThem,btXoa,btTimKiem,btThoat,btTiepTuc,btKQ;
    JTextField txNhap;
    JLabel lbTB,lbArr,lbNhap,lbKQ;
    String yeuCau[]={"a. Các phần tử của mảng a và tổng của chúng",
            "b. Các phần tử chẵn của mảng a và tổng của chúng",
            "c.	Các phần tử lẻ của mảng a và tổng của chúng",
            "d.	Các phần tử là số nguyên tố của mảng a và tổng của chúng"};
    JComboBox yc=new JComboBox(yeuCau);
    //Mamg
    int index=1;
    ArrayList<Integer> NumArr=new ArrayList<Integer>();
    String strNum;
    int num;
    public GuiBai8(){
        setSize(600,300);
        setLayout(new GridLayout(7,1));

        p1=new JPanel();
        add(p1);
        lbNhap=new JLabel("Nhập số thứ "+index+" :");
        p1.add(lbNhap);
        txNhap=new JTextField(10);
        p1.add(txNhap);
        txNhap.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    strNum=txNhap.getText();
                    num=Integer.parseInt(strNum);
                    NumArr.add(num);
                    lbArr.setText(NumArr.toString());
                    txNhap.setText(null);
                    index++;
                    lbNhap.setText("Nhập số thứ "+index+" :");

                }
            }
        });
        btNhap=new JButton("Nhập lại");
        p1.add(btNhap);
        btNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(index>1){
                    index--;
                    NumArr.remove(index-1);
                    lbArr.setText(NumArr.toString());
                    lbNhap.setText("Nhập lại số thứ "+ (index)+" :");
                    txNhap.requestFocus();
                }
                else {
                    NumArr.clear();
                    txNhap.requestFocus();
                }

            }
        });

        p2=new JPanel();
        add(p2);
        p2.setBackground(Color.lightGray);
        lbTB=new JLabel("Các phần tử của mảng: ");
        p2.add(lbTB);

        p3=new JPanel();
        p3.setBackground(Color.lightGray);
        add(p3);
        lbArr=new JLabel("Nhập dữ liệu vào ô trên, nhấn ENTER để nhập số tiếp theo CHO LẸ!!!");
        lbArr.setForeground(Color.white);
        lbArr.setFont(new Font("Arial",Font.BOLD,15));
        p3.add(lbArr);

        p4=new JPanel();
        add(p4);
        p4.add(yc);
        btKQ=new JButton("Thực hiện");
        p4.add(btKQ);
        btKQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbArr.setText(NumArr.toString());
                if(yc.getSelectedIndex()!=-1){
                    int stt=yc.getSelectedIndex();
                    if(stt==0){
                        CauA();
                    }else if(stt==1){
                            CauB();
                    }else if(stt==2){
                                CauC();
                    }else {
                            CauD();
                    }
                }
            }
        });

        p5=new JPanel();
        add(p5);
        btThem=new JButton("Thêm");
        btXoa=new JButton("Xóa");
        btTimKiem=new JButton("Tìm kiếm");
        p5.add(btThem);
        p5.add(btXoa);
        p5.add(btTimKiem);
        btXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbArr.setText(NumArr.toString());
                String strVt;
                int vt;
                strVt=JOptionPane.showInputDialog("Nhập vị trí muốn xóa ");
                vt=Integer.parseInt(strVt);
                NumArr.remove(vt-1);
                lbKQ.setText(NumArr.toString());
                lbKQ.setForeground(new Color(51,153,51));

            }
        });
        btTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbArr.setText(NumArr.toString());
                String strNum;
                int num;
                strNum=JOptionPane.showInputDialog("Số bạn cần tìm là: ");
                num=Integer.parseInt(strNum);
                lbKQ.setForeground(new Color(51,51,204));
                if(!NumArr.contains(num)){
                    lbKQ.setText("Tìm hoài không thấy!!!!");
                }else{
                    String strVt="";
                    for( int i=0;i<NumArr.size();i++)
                        if(NumArr.get(i)==num) strVt+=(i+1)+" ";
                        lbKQ.setText("Tìm thấy tại vị trí: "+strVt);
                }

            }
        });
        btThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbArr.setText(NumArr.toString());
                String strDl,strVt;
                int dl,vt;
                strDl=JOptionPane.showInputDialog("Nhập số nguyên: ");
                dl= Integer.parseInt(strDl);
                strVt=JOptionPane.showInputDialog("Vị trí: ");
                vt=Integer.parseInt(strVt);
                NumArr.add(vt-1,dl);
                lbKQ.setText(NumArr.toString());
                lbKQ.setForeground(new Color(204,0,51));
            }
        });
        p6=new JPanel();
        add(p6);
        p6.setBackground(Color.lightGray);
        lbKQ=new JLabel("");
        lbKQ.setForeground(Color.white);
        lbKQ.setFont(new Font("Arial",Font.BOLD,15));
        p6.add(lbKQ);





        p7=new JPanel();
        add(p7);
        btThoat=new JButton("Thoát");
        btTiepTuc=new JButton("Làm tiếp");
        p7.add(btTiepTuc);
        btTiepTuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbNhap.setText("Nhập số thứ 1: ");
                txNhap.setText(null);
                NumArr.clear();
                lbArr.setText(null);
                lbKQ.setText(null);
                txNhap.requestFocus();
                lbArr.setText("Nhập dữ liệu vào ô trên, nhấn ENTER để nhập số tiếp theo CHO LẸ!!!");
                lbArr.setForeground(Color.white);
                lbKQ.setForeground(Color.white);
                lbTB.setText("Các phần tử của mảng: ");
            }
        });
        p7.add(btThoat);
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
    public void CauA(){
        int sum=0;
        for (Integer item: NumArr)
            sum+=item;
        lbKQ.setText(NumArr.toString()+", Tổng = "+sum);
    }
    public void CauB(){
        int sum=0;
        ArrayList<Integer> subArr=new ArrayList<Integer>();
        for(Integer item: NumArr){
            if(item%2==0){
                sum+=item;
                subArr.add(item);}
        }
        lbKQ.setText(subArr.toString()+", Tổng = "+sum);
    }
    public void CauC(){
        int sum=0;
        ArrayList<Integer> subArr=new ArrayList<Integer>();
        for(Integer item: NumArr){
            if(item%2!=0){
                sum+=item;
                subArr.add(item);}
        }
        lbKQ.setText(subArr.toString()+", Tổng = "+sum);
    }
    public void CauD(){
        int sum=0;
        ArrayList<Integer> subArr=new ArrayList<Integer>();
        for(Integer item: NumArr){
            if(checkPrime(item)){
                sum+=item;
                subArr.add(item);}
        }
        lbKQ.setText(subArr.toString()+", Tổng = "+sum);
    }
    public static void main(String[] args) {
        new GuiBai8();
    }
}
