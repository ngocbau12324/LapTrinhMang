import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuiBai5 {
    JFrame frame;
    JPanel p1,p2,p3;
    JTextField txNum;
    JLabel lbNum,lbTB;
    JButton btKT,btTieptuc,btThoat;
    public GuiBai5(){
        frame=new JFrame();
        frame.setTitle("Bài số 5: Kiểm tra âm/zero/dương");
        frame.setLayout(new GridLayout(3,1));
        frame.setSize(400,150);

        p1=new JPanel();
        frame.add(p1);
        lbNum=new JLabel("Nhập số nguyên N");
        p1.add(lbNum);
        txNum=new JTextField(10);
        p1.add(txNum);
        txNum.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    int a=Integer.parseInt(txNum.getText());
                if(a<0) lbTB.setText(a+" LÀ SỐ ÂM.");
                else if(a==0)lbTB.setText(a+" LÀ ZERO.");
                else lbTB.setText(a+" LÀ SỐ DƯƠNG");}
            }
        });

        p2=new JPanel();
        frame.add(p2);
        lbTB=new JLabel("Nhập rồi nhấn ENTER cho lẹ!");
        p2.add(lbTB);

        p3=new JPanel();
        btKT=new JButton("Kiểm tra");
        p3.add(btKT);
        btKT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a=Integer.parseInt(txNum.getText());
                if(a<0) lbTB.setText(a+" LÀ SỐ ÂM.");
                else if(a==0)lbTB.setText(a+" LÀ ZERO.");
                    else lbTB.setText(a+" LÀ SỐ DƯƠNG");
            }
        });
        btTieptuc=new JButton("Tiếp tục");
        p3.add(btTieptuc);
        btTieptuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txNum.setText(null);
                txNum.requestFocus();
                lbTB.setText("Nhập rồi nhấn ENTER cho lẹ!");
            }
        });
        btThoat=new JButton("Thoát");
        p3.add(btThoat);
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(p3);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new GuiBai5();
    }
}
