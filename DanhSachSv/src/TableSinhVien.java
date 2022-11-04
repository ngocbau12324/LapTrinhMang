import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class TableSinhVien extends JFrame {
    JFrame frame;
    JButton bt;
    JTable tb;
    DefaultTableModel model=new DefaultTableModel();
    TableSinhVien(){
        frame=new JFrame("Danh sách sinh viên");
        frame.setSize(1000,600);
        frame.setLayout(null);

        bt=new JButton("Add");
        bt.setBounds(10,10,70,30);
        frame.add(bt);

        tb=new JTable();
        tb.setBounds(20,20,600,200);
        frame.add(tb);
        System.out.println(model.getRowCount());

        bt.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(model.getRowCount());
                super.mouseClicked(e);
                Vector header=new Vector();
                header.add("Ho");
                header.add("Ten");
                if(model.getRowCount()==0){
                    model=new DefaultTableModel(header,0);
                    tb.setModel(model);
                }
                Vector row=new Vector();
                row.add("nguen");
                row.add("Bauso");
                model.addRow(row);
                tb.setModel(model);
            }
        });



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new TableSinhVien();
    }
}
