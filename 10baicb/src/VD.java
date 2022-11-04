import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class VD {

    public static void main(String[] args) throws IOException {
        JFrame frame=new JFrame();
        frame.setSize(1000,700);
        //frame.setLayout(new GridLayout(3,1));
        JPanel panel=new JPanel();
        frame.add(panel);

        ImageIcon icon = new ImageIcon("C:\\Users\\NGOC BAU\\Desktop\\A.png");
        JLabel label = new JLabel(icon);
        label .setSize(20,20);
        frame.add(label);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
