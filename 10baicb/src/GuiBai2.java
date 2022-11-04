import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuiBai2 extends JFrame{
    JFrame frame;
    JPanel p1,p2,p3,p4;
    JLabel lbDai,lbRong,lbC,lbS;
    JTextField txDai,txRong;
    JButton btTinh,btTieptuc,btThoat;
    double c=0,s=0;
    public GuiBai2(){
        frame=new JFrame();
        frame.setTitle("Bài số 2");
        frame.setSize(500,200);
        frame.setLayout(new GridLayout(4,1));

        p1=new JPanel();
        lbDai=new JLabel("Nhập chiều dài");
        txDai=new JTextField(10);
        p1.add(lbDai);
        p1.add(txDai);
        txDai.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    txRong.requestFocus();
            }
        });
        lbRong=new JLabel("Nhập chiều rộng");
        txRong=new JTextField(10);
        txRong.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    TinhChuVi(txDai.getText(),txRong.getText());
                    TinhDienTich(txDai.getText(),txRong.getText());
                    lbC.setText("Chu vi hình chử nhật = "+c);
                    lbS.setText("Diện tích hình chử nhật = "+s);
            }
        });
        p1.add(lbRong);
        p1.add(txRong);
        frame.add(p1);

        p2=new JPanel();
        lbC=new JLabel("Chu vi hình chử nhật = "+0);
        p2.add(lbC);
        frame.add(p2);

        p3=new JPanel();
        lbS=new JLabel("Diện tích hình chử nhật = "+0);
        p3.add(lbS);
        frame.add(p3);

        p4=new JPanel();
        btTinh=new JButton("Tính");
        p4.add(btTinh);
        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TinhChuVi(txDai.getText(),txRong.getText());
                TinhDienTich(txDai.getText(),txRong.getText());
                lbC.setText("Chu vi hình chử nhật = "+c);
                lbS.setText("Diện tích hình chử nhật = "+s);
            }
        });
        btTieptuc=new JButton("Tiếp tục");
        p4.add(btTieptuc);
        btTieptuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txDai.setText(null);
                txRong.setText(null);
                lbC.setText("Chu vi hình chử nhật = "+0);
                lbS.setText("Diện tích hình chử nhật = "+0);
                txDai.requestFocus();
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
    public void TinhDienTich(String d,String r){
        s=Integer.parseInt(d)*(Integer.parseInt(r));
    }
    public void TinhChuVi(String d,String r){
        c=1.0*(Integer.parseInt(d)+(Integer.parseInt(r)))/2;
    }
    public static void main(String[] args) {
        new GuiBai2();

    }

}
