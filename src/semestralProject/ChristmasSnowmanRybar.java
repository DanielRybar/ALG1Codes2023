package semestralProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ChristmasSnowmanRybar {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("Vítejte u vánočního programu pro vykreslení sněhuláka");
        System.out.println("Zadejte rozměr sněhuláka");
        SnowmanFrame frame = new SnowmanFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //frame.setResizable(false);
    }
}

class SnowmanFrame extends JFrame {

    public static final int DEFAULT_WIDTH = 400;
    public static final int DEFAULT_HEIGHT = 400;

    private JLabel label;

    public SnowmanFrame() {

        setTitle("Snehulak");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        SnowmanPanel panel = new SnowmanPanel();
        label = new JLabel("text");

        //setLayout(new GridLayout(0,1));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        addToThisPanel(panel);
        //addToThisPanel(label);

        initComponentListener();
    }

    private void addToThisPanel(Component comp) {
        getContentPane().add(comp);
    }

    private void initComponentListener() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension velikostOkna = getSize();
                int sirka = (int) velikostOkna.getWidth();
                int vyska = (int) velikostOkna.getHeight();

                label.setText("Velikost: " + sirka + "x" + vyska);
            }
        });
    }

    @Override
    public final void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public final void setSize(int s1, int s2) {
        super.setSize(s1, s2);
    }
}

class SnowmanPanel extends JPanel {

    final int MID = 180;
    final int TOP = 100;
    final static boolean IS_SNOWING = true;
    final static boolean IS_SUN_SHINING = true;
    final static int HEIGHT = 200;
    final static int SIZE = 100;

    @Override
    public void paintComponent(Graphics page) {
        super.paintComponent(page);

        Graphics2D g2d = (Graphics2D) page;

        if (IS_SNOWING) {
            BufferedImage img;
            try {
                img = ImageIO.read(new File("./src/semestralProject/img/snowing.jpg"));
                g2d.drawImage(img, 0, -700, null);
            } catch (IOException ex) {
                System.out.println("Bude to bohuzel bez snehu :(");
                //System.out.println(ex.getMessage());
                setBackground(Color.decode("#0073cf"));
            }

        } else {
            setBackground(Color.decode("#0073cf"));
        }

        g2d.setColor(Color.decode("#00008b"));
        g2d.fillRect(0, 350, 400, 50);  // zeme

        if (IS_SUN_SHINING) {
            g2d.setColor(Color.decode("#FEE12B"));
            g2d.fillOval(-40, -40, 80, 80);  // slunicko
        }

        g2d.setColor(Color.white);
        //setSpheres(g2d, size);
        int head = 60 * 2;
        int middle = 70 * 2;
        int last = 80 * 2;
        drawSnowman(g2d, head, middle, last);

        /*
        g2d.setColor(Color.black);
        g2d.fillOval(MID - 10, TOP + 10, 5, 5);   // leve oko
        g2d.fillOval(MID + 5, TOP + 10, 5, 5);    // prave oko
        

        g2d.setStroke(new BasicStroke(3));
        g2d.drawArc(MID - 10, TOP + 20, 20, 10, 190, 160);   // pusa

        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.decode("#964B00"));
        g2d.drawLine(MID - 25, TOP + 60, MID - 59, TOP + 40);  // leva ruka
        g2d.drawLine(MID + 25, TOP + 60, MID + 55, TOP + 60);  // prava ruka

        g2d.setColor(Color.BLACK);
        g2d.drawLine(MID - 20, TOP + 5, MID + 20, TOP + 5);  //spodek kloubouku
        g2d.fillRect(MID - 15, TOP - 20, 30, 25);        // vrsekKlobouku
         */
    }

    private void drawSnowman(Graphics g, int headDiameter, int upperTorsoDiameter, int lowerTorsoDiameter) {
        //int MID = width / 2;
        //int TOP = height / 2;

        g.fillOval(MID - headDiameter / 2, TOP - 30, headDiameter, headDiameter);                   // head
        g.fillOval(MID - upperTorsoDiameter / 2, TOP + headDiameter - 30, upperTorsoDiameter, 50);  // upper torso
        g.fillOval(MID - lowerTorsoDiameter / 2, TOP + headDiameter - 30 + 50, lowerTorsoDiameter, 60);  // lower torso
    }

    /*
    public void setSpheres(Graphics2D g2d) {
        g2d.fillOval(MID - 20, TOP, 40, 40);      // head
        g2d.fillOval(MID - 35, TOP + 35, 70, 50);   // upper torso
        g2d.fillOval(MID - 50, TOP + 80, 100, 60);  // lower torso
    }*/
}