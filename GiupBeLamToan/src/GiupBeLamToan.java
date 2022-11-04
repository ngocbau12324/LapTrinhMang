import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GiupBeLamToan implements ActionListener {
    JFrame frame;
    JPanel pPhepTinh,pThongBao,pXuLy;
    JLabel lbSo1,lbSo2,lbKq,lbTitle,lbTb,lbPt;
    JTextField txSo1,txSo2,txKq;
    ButtonGroup btG;
    JButton[] btXuLy=new JButton[7];
    JButton btCong,btTru,btNhan,btChia,btTiepTuc,btKiemTra,btThoat;
    Font myFont=new Font("Tahoma",Font.CENTER_BASELINE,20);
    Font myFont1=new Font("Bookman",Font.CENTER_BASELINE,12);
    Font myFont2=new Font("Courier New",Font.CENTER_BASELINE,16);
    int so1=0,so2=0;
    double kq=0;
    char phepTinh,flagPhepTinh=0,flagSo1=0,flagSo2=0,flagKq=0;
    GiupBeLamToan(){
        frame=new JFrame("Giúp bé làm toán");
        frame.setSize(500,310);
        frame.setLayout(null);

        lbTitle=new JLabel("CỘNG TRỪ NHÂN CHIA KHÔNG KHÓ");
        lbTitle.setFont(myFont);
        lbTitle.setForeground(new Color(56,159,214));
        lbTitle.setBounds(55,10,400,30);
        frame.add(lbTitle);

        lbSo1=new JLabel("Mời bé nhập số thứ nhất ");
        lbSo1.setBounds(20,50,150,30);
        lbSo1.setFont(myFont1);
        frame.add(lbSo1);
        txSo1=new JTextField();
        txSo1.setText("");
        txSo1.setBounds(170,50,170,30);
        txSo1.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        txSo1.setFont(myFont2);
        frame.add(txSo1);

        lbPt=new JLabel();
        lbPt.setBounds(173,85,10,10);
        frame.add(lbPt);

        lbSo2=new JLabel("Mời bé nhập số thứ hai");
        lbSo2.setBounds(20,100,150,30);
        lbSo2.setFont(myFont1);
        frame.add(lbSo2);
        txSo2=new JTextField();
        txSo2.setBounds(170,100,170,30);
        txSo2.setText("");
        txSo2.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        txSo2.setFont(myFont2);
        frame.add(txSo2);

        lbKq=new JLabel("Mời bé nhập Đáp số");
        lbKq.setBounds(20,140,150,30);
        lbKq.setFont(myFont1);
        frame.add(lbKq);
        txKq=new JTextField();
        txKq.setText("");
        txKq.setBounds(170,140,170,30);
        txKq.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        txKq.setFont(myFont2);
        frame.add(txKq);

        pPhepTinh=new JPanel();
        pPhepTinh.setBounds(360,50,100,80);
        pPhepTinh.setLayout(new GridLayout(2,2,2,2));
        frame.add(pPhepTinh);

        btCong=new JButton("+");
        btTru=new JButton("-");
        btNhan=new JButton("x");
        btChia=new JButton("/");
        btTiepTuc=new JButton("Làm tiếp");
        btKiemTra=new JButton("Kiểm tra");
        btThoat=new JButton("Thoát");
        btXuLy[0]=btCong;
        btXuLy[1]=btTru;
        btXuLy[2]=btNhan;
        btXuLy[3]=btChia;
        btXuLy[4]=btKiemTra;
        btXuLy[5]=btTiepTuc;
        btXuLy[6]=btThoat;
        btG=new ButtonGroup();
        btG.add(btCong);
        btG.add(btTru);
        btG.add(btNhan);
        btG.add(btChia);

        for(int i=0;i<7;i++){
            btXuLy[i].addActionListener(this);
            btXuLy[i].setFocusable(false);
            btXuLy[i].setFont(myFont1);
            btXuLy[i].setBorder(BorderFactory.createEmptyBorder());
            btXuLy[i].setBackground(new Color(230,230,230));
        }
        btKiemTra.setBackground(new Color(208,148,143));
        btTiepTuc.setBackground(new Color(89,168,105));
        btThoat.setBackground(new Color(89,168,105));
        pPhepTinh.add(btXuLy[0]);
        pPhepTinh.add(btXuLy[1]);
        pPhepTinh.add(btXuLy[2]);
        pPhepTinh.add(btXuLy[3]);
        btXuLy[4].setBounds(360,133,100,40);
        frame.add(btXuLy[4]);

        pThongBao=new JPanel();
        pThongBao.setBackground(new Color(252,250,237));
        pThongBao.setBounds(0,180,500,40);
        lbTb=new JLabel();
        lbTb.setFont(myFont2);
        pThongBao.add(lbTb);
        frame.add(pThongBao);

        pXuLy=new JPanel();
        pXuLy.setBounds(150,225,200,40);
        pXuLy.setLayout(new GridLayout(1,2,2,2));
        pXuLy.add(btTiepTuc);
        pXuLy.add(btThoat);
        frame.add(pXuLy);

        txSo1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER) txSo2.requestFocus();
            }
        });
        txSo2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER) txKq.requestFocus();
            }
        });
        txKq.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_ENTER) btKiemTra.doClick();
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new GiupBeLamToan();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btCong){
            phepTinh='+';
            flagPhepTinh=0;
            btCong.setBackground(new Color(89,168,105));
            btTru.setBackground(new Color(230,230,230));
            btNhan.setBackground(new Color(230,230,230));
            btChia.setBackground(new Color(230,230,230));
        }
        if(e.getSource()==btTru){
            phepTinh='-';
            flagPhepTinh=0;
            btTru.setBackground(new Color(89,168,105));
            btCong.setBackground(new Color(230,230,230));
            btNhan.setBackground(new Color(230,230,230));
            btChia.setBackground(new Color(230,230,230));
        }
        if(e.getSource()==btNhan){
            phepTinh='x';
            flagPhepTinh=0;
            btNhan.setBackground(new Color(89,168,105));
            btTru.setBackground(new Color(230,230,230));
            btCong.setBackground(new Color(230,230,230));
            btChia.setBackground(new Color(230,230,230));
        }
        if(e.getSource()==btChia){
            phepTinh='/';
            flagPhepTinh=0;
            btChia.setBackground(new Color(89,168,105));
            btTru.setBackground(new Color(230,230,230));
            btNhan.setBackground(new Color(230,230,230));
            btCong.setBackground(new Color(230,230,230));
        }
        if(e.getSource()==btKiemTra){
            lbTb.setText("");
            pPhepTinh.setBackground(null);
            txSo1.setBorder(BorderFactory.createLineBorder(Color.CYAN));
            txSo2.setBorder(BorderFactory.createLineBorder(Color.CYAN));
            txKq.setBorder(BorderFactory.createLineBorder(Color.CYAN));
            lbPt.setText(String.valueOf(phepTinh));
            if(txSo1.getText().length()!=0) {
                so1=Integer.parseInt(txSo1.getText());
                flagSo1=0;
            }
            else flagSo1=1;
            if(txSo2.getText().length()!=0) {
                so2=Integer.parseInt(txSo2.getText());
                flagSo2=0;
                if(so2==0 && phepTinh=='/') flagSo2=1;
            }
            else flagSo2=1;
            int tempKq=0;
            if(txKq.getText().length()!=0){
                tempKq=Integer.parseInt(txKq.getText());
                flagKq=0;
            }
            else flagKq=1;
            switch (phepTinh){
                case '+':
                    kq=so1+so2;
                    break;

                case '-':
                    kq=so1-so2;
                    break;
                case 'x':
                    kq=so1*so2;
                    break;
                case '/':
                    kq=1.0*so1/so2;
                    break;
                default:
                    lbTb.setText("Bé quên chọn PHÉP TÍNH rồi!!!!");
                    flagPhepTinh=1;
                    if(flagSo2+flagSo1+flagKq==0)pPhepTinh.setBackground(new Color(219,88,96));
                    break;
            }
            if((flagPhepTinh+flagSo1+flagSo2+flagKq) ==0){
            if(kq==(tempKq)) {
                lbTb.setText("Chúc mừng bé, đáp số đúng rồi!!!");
                lbTb.setForeground(new Color(89,168,105));
            }
            else {
                lbTb.setText("Sai rồi! "+kq+" mới là đáp số đúng!");
                lbTb.setForeground(new Color(219,88,96));
            }
            }else
            if(flagSo1==1){
                lbTb.setForeground(new Color(219,88,96));
                lbTb.setText("Bé hãy nhập số thứ nhất!");
                txSo1.requestFocus();
                txSo1.setBorder(BorderFactory.createLineBorder(new Color(219,88,96)));
            }
            else
            if(flagSo2==1){
                lbTb.setForeground(new Color(219,88,96));
                if(so2==0 && txSo2.getText().length()!=0)lbTb.setText("Số 0 không chia được! Bé hãy nhập lại số thứ hai.");
                if(txSo2.getText().length()==0)lbTb.setText("Bé hãy nhập số thứ hai!");
                txSo2.requestFocus();
                txSo2.setBorder(BorderFactory.createLineBorder(new Color(219,88,96)));
            }else
            if(flagKq==1){
                lbTb.setForeground(new Color(219,88,96));
                lbTb.setText("Bé hãy nhập đáp số, mới kiểm tra được!");
                txKq.requestFocus();
                txKq.setBorder(BorderFactory.createLineBorder(new Color(219,88,96)));
            }
        }
        if(e.getSource()==btTiepTuc){
            txSo1.setText("");
            txSo2.setText("");
            txKq.setText("");
            lbTb.setText("");
            txSo1.requestFocus();
            phepTinh=' ';
            lbPt.setText("");
            flagKq=0;
            flagSo2=0;
            flagSo1=0;
            btTru.setBackground(new Color(230,230,230));
            btNhan.setBackground(new Color(230,230,230));
            btCong.setBackground(new Color(230,230,230));
            btChia.setBackground(new Color(230,230,230));
        }
        if(e.getSource()==btThoat){
            System.exit(0);
        }
    }
}
