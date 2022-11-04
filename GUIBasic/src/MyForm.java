import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyForm {
    public static void main(String[] args) {
        JFrame frame=new JFrame("Ví dụ 1");
        frame.setSize(500,300);
        frame.setLayout(new GridLayout(3,1));

        Panel p0=new Panel();
        Panel p1=new Panel();
        p1.setBackground(Color.CYAN);
        Panel p2=new Panel();
        p2.setBackground(Color.BLUE);
        frame.add(p0);
        frame.add(p1);
        frame.add(p2);

        Label lb1=new Label("Bài tập đầu tiên");
        lb1.setAlignment(1);
        lb1.setForeground(Color.red);
        lb1.setFont(new Font("Arial",Font.BOLD,50));
        p0.add(lb1);

        JTextField tx1=new JTextField("Xin chào các bạn",20);
        tx1.setFont(new Font("Arial",Font.ITALIC,20));
        p1.add(tx1);

        Button bt1=new Button("Chào");
        Button bt2=new Button("Đóng");
        p2.add(bt1);
        p2.add(bt2);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tx1.setText("Hello World!");
            }
        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
