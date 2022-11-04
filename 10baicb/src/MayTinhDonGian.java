import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MayTinhDonGian implements ActionListener {
    JFrame frame;
    JTextField txNhap,txBieuThuc;
    JButton[] btSo=new JButton[10];
    JButton[] btPhepTinh=new JButton[10];
    JButton btCong,btTru,btNhan,btChia;
    JButton btCham,btBang,btXoa,btLamTiep,btDoi,btThoat;
    JPanel panel;
    Font font=new Font("Courier New",Font.BOLD,30);
    Font font1=new Font("Courier New",Font.BOLD,20);
    double so1=0,so2=0,kq=0;
    char phepTinh,flagBang=0,flagDoi=0;
    MayTinhDonGian(){
        frame=new JFrame("Máy tính đơn giản");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340,540);
        frame.setLayout(null);

        txBieuThuc=new JTextField();
        txBieuThuc.setBounds(5,17,315,30);
        txBieuThuc.setHorizontalAlignment(4);
        txBieuThuc.setEditable(false);
        frame.add(txBieuThuc);

        txNhap=new JTextField();
        txNhap.setText("0");
        txNhap.setBounds(5,50,315,70);
        txNhap.setHorizontalAlignment(4);//Text nằm bên trái
        frame.add(txNhap);
        txNhap.setFont(font);
        txNhap.setEditable(false);

        btCong=new JButton("+");
        btTru=new JButton("-");
        btNhan=new JButton("x");
        btChia=new JButton("/");
        btCham=new JButton(".");
        btBang=new JButton("=");
        btDoi=new JButton("(-)");
        btXoa=new JButton("<=");
        btLamTiep=new JButton("C");
        btThoat=new JButton("OFF");

        btPhepTinh[0]=btCong;
        btPhepTinh[1]=btTru;
        btPhepTinh[2]=btNhan;
        btPhepTinh[3]=btChia;
        btPhepTinh[4]=btCham;
        btPhepTinh[5]=btBang;
        btPhepTinh[6]=btXoa;
        btPhepTinh[7]=btDoi;
        btPhepTinh[8]=btLamTiep;
        btPhepTinh[9]=btThoat;

        for(int i=0;i<10;i++){
            btPhepTinh[i].addActionListener(this);
            btPhepTinh[i].setFont(font1);
            btPhepTinh[i].setBorder(BorderFactory.createEmptyBorder());
            btPhepTinh[i].setBackground(new Color(230,230,230));
            btPhepTinh[i].setFocusable(false);
        }
        btBang.setBackground(new Color(89,168,105));
        btThoat.setBackground(new Color(208,148,143));
        for(int i=0;i<10;i++){
            btSo[i]=new JButton(String.valueOf(i));
            btSo[i].addActionListener(this);
            btSo[i].setFont(font1);
            btSo[i].setBorder(BorderFactory.createEmptyBorder());
            btSo[i].setBackground(Color.white);
            btSo[i].setFocusable(false);
        }
        panel=new JPanel();
        panel.setBounds(5,150,315,300);
        panel.setLayout(new GridLayout(5,4,2,2));
        frame.add(panel);

        panel.add(btThoat);
        panel.add(btLamTiep);
        panel.add(btXoa);
        panel.add(btChia);
        panel.add(btSo[7]);
        panel.add(btSo[8]);
        panel.add(btSo[9]);
        panel.add(btNhan);
        panel.add(btSo[4]);
        panel.add(btSo[5]);
        panel.add(btSo[6]);
        panel.add(btTru);
        panel.add(btSo[1]);
        panel.add(btSo[2]);
        panel.add(btSo[3]);
        panel.add(btCong);
        panel.add(btDoi);
        panel.add(btSo[0]);
        panel.add(btCham);
        panel.add(btBang);

        frame.setVisible(true);

    }
    public static void main(String[] args) {
         new MayTinhDonGian();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource()==btSo[i]){
                txNhap.setText(txNhap.getText().concat(String.valueOf(i)));
                txBieuThuc.setText(txBieuThuc.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==btCham){
            txNhap.setText(txNhap.getText().concat("."));
            txBieuThuc.setText(txBieuThuc.getText().concat("."));
        }
        if(e.getSource()==btCong){
            so1=Double.parseDouble(txNhap.getText());
            phepTinh='+';
            txNhap.setText("");
            if(flagBang==0)txBieuThuc.setText(txBieuThuc.getText().concat("+"));
            else txBieuThuc.setText(String.valueOf(kq)+"+");
            flagDoi=1;
        }
        if(e.getSource()==btTru){
            so1=Double.parseDouble(txNhap.getText());
            phepTinh='-';
            txNhap.setText("");
            if(flagBang==0)txBieuThuc.setText(txBieuThuc.getText().concat("-"));
            else txBieuThuc.setText(String.valueOf(kq)+"-");
            flagDoi=1;
        }
        if(e.getSource()==btNhan){
            so1=Double.parseDouble(txNhap.getText());
            phepTinh='*';
            txNhap.setText("");
            if(flagBang==0)txBieuThuc.setText(txBieuThuc.getText().concat("x"));
            else txBieuThuc.setText(String.valueOf(kq)+"x");
            flagDoi=1;
        }
        if(e.getSource()==btChia){
            so1=Double.parseDouble(txNhap.getText());
            phepTinh='/';
            txNhap.setText("");
            if(flagBang==0)txBieuThuc.setText(txBieuThuc.getText().concat("/"));
            else txBieuThuc.setText(String.valueOf(kq)+"/");
            flagDoi=1;
        }
        if(e.getSource()==btBang){
            flagBang=1;
            flagDoi=0;
            so2=Double.parseDouble(txNhap.getText());
            switch (phepTinh){
                case '+':
                    kq=so1+so2;
                    break;
                case '-':
                    kq=so1-so2;
                    break;
                case '*':
                    kq=so1*so2;
                    break;
                case '/':
                    kq=so1/so2;
                    break;
                default:
                    kq=so2;
                    break;

            }
            txNhap.setText(String.valueOf(kq));
            phepTinh=' ';
            txBieuThuc.setText(txBieuThuc.getText()+"=");

        }
        if(e.getSource()==btLamTiep){
            txBieuThuc.setText("");
            txNhap.setText("0");
            flagBang=0;
            flagDoi=0;
        }
        if(e.getSource()==btDoi){
            String strTam=txNhap.getText();
            Double tam=Double.parseDouble(txNhap.getText());
            tam*=(-1);
            kq=tam;
            txNhap.setText(String.valueOf(tam));
            if(flagDoi==0)txBieuThuc.setText(String.valueOf(tam));
            else {
                String str=txBieuThuc.getText();
                str=str.substring(0,str.length()-strTam.length());
                txBieuThuc.setText(str+"(-"+strTam+")");
            }
        }
        if(e.getSource()==btXoa){
            String tam=txNhap.getText();
            txNhap.setText("");
            for(int i=0;i<tam.length()-1;i++){
                txNhap.setText(txNhap.getText()+tam.charAt(i));
            }
            String tam1=txBieuThuc.getText();
            txBieuThuc.setText("");
            for(int i=0;i<tam1.length()-1;i++)
                txBieuThuc.setText(txBieuThuc.getText()+tam1.charAt(i));
            if(txNhap.getText()=="");
        }
        if(e.getSource()==btThoat)
            System.exit(0);
    }
}
