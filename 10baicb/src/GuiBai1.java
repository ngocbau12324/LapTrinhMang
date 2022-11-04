import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuiBai1 extends JFrame {
    JFrame frame;
    JTextField txSo1,txSo2,txTong,txHieu,txTich,txThuong;
    JButton btTinh,btTieptuc,btThoat;
    JLabel lbSo1,lbSo2,lbTong,lbHieu,lbTich,lbThuong;
    JPanel p1,p2,p3,p4,p5,p6;
    int tong,hieu,tich;
    double thuong;
    public GuiBai1(){
        frame=new JFrame("Bài 1");
        frame.setSize(500,300);
        frame.setLayout(new GridLayout(6,1));

        p1=new JPanel();
        lbSo1=new JLabel("Số nguyên thứ nhất");
        txSo1=new JTextField(10);
        p1.add(lbSo1);
        p1.add(txSo1);
        txSo1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    txSo2.requestFocus();
            }
        });

        lbSo2=new JLabel("Số nguyên thứ hai");
        txSo2=new JTextField(10);
        p1.add(lbSo2);
        p1.add(txSo2);
        frame.add(p1);
        txSo2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                {
                    int a=Integer.parseInt(txSo1.getText());
                    int b=Integer.parseInt(txSo2.getText());
                    tong=a+b;
                    lbTong.setText("Tổng = "+tong);
                    hieu=a-b;
                    lbHieu.setText("Hiệu = "+hieu);
                    tich=a*b;
                    lbTich.setText("Tích = "+tich);
                    thuong=a*1.0/b;
                    lbThuong.setText("Thương = "+thuong);
                }
            }
        });

        p2=new JPanel();
        btTinh=new JButton("Tính");
        p2.add(btTinh);
        btTieptuc=new JButton("Tiếp tục");
        p2.add(btTieptuc);
        btTieptuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txSo1.setText(null);
                txSo1.requestFocus();
                txSo2.setText(null);
                lbTong.setText("Tổng = "+0);
                lbHieu.setText("Hiệu = "+0);
                lbTich.setText("Tích = "+0);
                lbThuong.setText("Thương = "+0.0);
            }
        });
        btThoat=new JButton("Thoát");
        p2.add(btThoat);
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(p2);
        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a=Integer.parseInt(txSo1.getText());
                int b=Integer.parseInt(txSo2.getText());
                tong=a+b;
                lbTong.setText("Tông = "+tong);
                hieu=a-b;
                lbHieu.setText("Hiệu = "+hieu);
                tich=a*b;
                lbTich.setText("Tích = "+tich);
                thuong=a*1.0/b;
                lbThuong.setText("Thương = "+thuong);

            }
        });

        p3=new JPanel();
        lbTong=new JLabel("Tổng = "+tong);
        p3.add(lbTong);
        frame.add(p3);

        p4=new JPanel();
        lbHieu=new JLabel("Hiệu = "+hieu);
        p4.add(lbHieu);
        frame.add(p4);

        p5=new JPanel();
        lbTich=new JLabel("Tích = "+tich);
        p5.add(lbTich);
        frame.add(p5);

        p6=new JPanel();
        lbThuong=new JLabel("Thương = "+thuong);
        p6.add(lbThuong);
        frame.add(p6);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GuiBai1();
    }
}
