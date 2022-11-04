import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiBai9 extends JFrame {
    JFrame frame=new JFrame();
    JPanel panel=new JPanel();
    JLabel lbStr,lbYc,lbKq;
    JTextField txStr;
    JComboBox cbYc;
    JButton btKq,btTt,btThoat;
    public GuiBai9(){
        setSize(600,400);
        add(panel);
        panel.setLayout(null);
        lbStr=new JLabel("Nhập chuổi S");
        lbStr.setBounds(20,5,100,30);
        lbStr.setBackground(Color.blue);
        panel.add(lbStr);
        txStr=new JTextField(10);
        txStr.setBounds(100,5,420,30);
        panel.add(txStr);
        lbYc=new JLabel("Yêu cầu");
        lbYc.setBounds(20,50,100,30);
        panel.add(lbYc);

        String yeuCau[]={"a.\tĐộ dài của s","b.\tXoá bỏ khoảng trắng thừa của s","c.\tĐếm số từ của s và xuất mỗi từ ra",
                "d.\tNhập số tự nhiên k, xuất k ký tự bên trái của s, k kí tự bên phải của s",
        "e.\tNhập số tự nhiên k, n, xuất n kí tự của s kể từ vị trí k "};
        cbYc=new JComboBox(yeuCau);
        cbYc.setBounds(100,50,420,30);
        panel.add(cbYc);
        btKq=new JButton("Kết quả");
        btKq.setBounds(250,100,90,30);
        panel.add(btKq);
        lbKq=new JLabel();
        lbKq.setBounds(200,150,600,30);
        lbKq.setFont(new Font("Arial",Font.HANGING_BASELINE,20));
        panel.add(lbKq);
        btKq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cbYc.getSelectedIndex()!=-1){
                    int stt=cbYc.getSelectedIndex();
                    String str=txStr.getText();
                    if(stt==0) cauA(str);
                    else if(stt==1) {
                        cauB(str);
                    }else if(stt==2){
                        cauC(str);
                    }else if(stt==3){
                        cauD(str);
                    }else cauE(str);
                }
            }
        });
        btThoat=new JButton("Thoát");
        btThoat.setBounds(200,200,100,30);
        panel.add(btThoat);
        btTt=new JButton("Tiếp tục");
        btTt.setBounds(300,200,100,30);
        panel.add(btTt);
        btThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btTt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txStr.setText(null);
                cbYc.setSelectedIndex(0);
                lbKq.setText(null);
                txStr.requestFocus();
            }
        });



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public String chuanHoaXau(String s){
        s=s.trim();
        while(s.indexOf("  ")!=-1) s=s.replaceAll("  "," ");
        //s=s.replaceAll("//s+"," ");
        return s;
    }
    public void cauA(String s){
        lbKq.setText("Độ dài chuổi là: "+s.length());
    }
    public void cauB(String s){
        s=chuanHoaXau(s);
        lbKq.setText("Chuỗi chuẩn hóa là: "+s);
        txStr.setText(s);
    }
    public void cauC(String s){
        String word[]=s.split(" ");
        String kq="";
        for(int i=0;i<word.length-1;i++)
            kq+=word[i]+", ";
        kq+=word[word.length-1];
        lbKq.setText("Chuỗi có "+word.length+" từ: "+kq);
    }
    public void cauD(String s){
        String strK=JOptionPane.showInputDialog("Nhập k ");
        int k=Integer.parseInt(strK);
        String strR,strL;
        strR=s.substring(s.length()-k);
        strL=s.substring(0,k);
        lbKq.setText(strL+"]"+s.substring(k,s.length()-k)+"["+strR);
    }
    public void cauE(String s){
        String strK=JOptionPane.showInputDialog("Nhập k ");
        String strN=JOptionPane.showInputDialog("Nhập n ");
        int k=Integer.parseInt(strK);
        int n=Integer.parseInt(strN);
        String strR,strL,strM;
        strL=s.substring(0,k-1);
        strR=s.substring(k+n-1);
        strM=s.substring(k-1,k+n-1);
        lbKq.setText(strL+"["+strM+"]"+strR);
    }
    public static void main(String[] args) {
        new GuiBai9();
    }
}
