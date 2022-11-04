import javax.swing.*;

public class MainDssv {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createTable();
            }
        });
    }
    private static void createTable(){
        TableDssv tableDs=new TableDssv();
        JPanel root=tableDs.getRootPanel();
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(root);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
