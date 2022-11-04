import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuiBai3 extends JFrame{
    JFrame frame;
    JPanel p1,p2,p3,p4;
    JLabel lbR,lbC,lbS;
    JTextField txR;
    JButton btTinh,btTieptuc,btThoat;
    double c=0,s=0;
    public GuiBai3(){
        frame=new JFrame();
        frame.setTitle("Bài số 3");
        frame.setSize(500,200);
        frame.setLayout(new GridLayout(4,1));

        p1=new JPanel();
        lbR=new JLabel("Nhập Bán kính hình tròn");
        txR=new JTextField(10);
        txR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    TinhChuVi(txR.getText());
                TinhDienTich(txR.getText());
                lbC.setText("Chu vi hình tròn = "+c);
                lbS.setText("Diện tích hình tròn = "+s);
            }
        });
        p1.add(lbR);
        p1.add(txR);
        frame.add(p1);

        p2=new JPanel();
        lbC=new JLabel("Chu vi hình tròn = "+0);
        p2.add(lbC);
        frame.add(p2);

        p3=new JPanel();
        lbS=new JLabel("Diện tích hình tròn = "+0);
        p3.add(lbS);
        frame.add(p3);

        p4=new JPanel();
        btTinh=new JButton("Tính");
        p4.add(btTinh);
        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TinhChuVi(txR.getText());
                TinhDienTich(txR.getText());
                lbC.setText("Chu vi hình tròn = "+c);
                lbS.setText("Diện tích hình tròn = "+s);
            }
        });
        btTieptuc=new JButton("Tiếp tục");
        p4.add(btTieptuc);
        btTieptuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txR.setText(null);
                lbC.setText("Chu vi hình tròn = "+0);
                lbS.setText("Diện tích hình tròn = "+0);
                txR.requestFocus();
            }
        });
        btThoat=new JButton("Thoát");
        p4.add(btThoat);
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(p4);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public void TinhDienTich(String r){
        int bk=Integer.parseInt(r);
        s=Math.PI*bk*bk;
    }
    public void TinhChuVi(String r){
        c=2*Math.PI*(Integer.parseInt(r));
    }
    public static void main(String[] args) {
        new GuiBai3();

    }

}

