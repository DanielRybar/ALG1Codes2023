package semestralProject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ChristmasSnowmanRybar {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===================================");
        System.out.println("Vitejte u vanocniho programu pro vykresleni snehulaka");
        System.out.println("Pokud chcete pouzit defaultni parametry, zadejte D, jinak cokoli jineho pro zadani vlastnich parametru.");

        char choice = Character.toUpperCase(sc.next().charAt(0));

        SnowmanFrame frame;
        int height;
        int width;
        boolean isSnowing;
        boolean isSun;

        if (choice != 'D') {
            System.out.println("Zadejte vysku snehulaka (10 <= x <= 220):");
            height = validateNumber();
            if (height < 10 || height > 220) {
                System.out.println("Dostali jste varováni. Snehulak nebude pekny.");
            }
            System.out.println("Zadejte sirku snehulaka (10 <= x <= 350):");
            width = validateNumber();
            if (width < 10 || width > 350) {
                System.out.println("Dostali jste varováni. Snehulak nebude pekny.");
            }
            System.out.println("Pokud si prejete, aby snezilo, zadejte A:");
            isSnowing = Character.toUpperCase(sc.next().charAt(0)) == 'A';
            System.out.println("Pokud si prejete, aby svitilo slunce, zadejte A:");
            isSun = Character.toUpperCase(sc.next().charAt(0)) == 'A';
        } else {
            height = 150;
            width = 150;
            isSnowing = true;
            isSun = true;
        }

        frame = new SnowmanFrame(height, width, isSnowing, isSun);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // stred obrazovky
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private static int validateNumber() {
        int num = 0;
        boolean isValid = false;
        do {
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Neplatna hodnota (" + sc.next() + "). Opakuj zadavani."); // zde by se dala predat errormessage jako parametr
            }
        } while (!isValid);

        return num;
    }
}

class SnowmanFrame extends JFrame {

    static final int DEFAULT_WIDTH = 800;
    static final int DEFAULT_HEIGHT = 800;

    final static String TITLE = "Snehulak";

    public SnowmanFrame(int height, int width, boolean isSnowing, boolean isSun) {
        super.setTitle(TITLE);
        super.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        SnowmanPanel panel = new SnowmanPanel(height, width, isSnowing, isSun);
        addToThisPanel(panel);
    }

    private void addToThisPanel(Component comp) {
        getContentPane().add(comp);
    }
}

class SnowmanPanel extends JPanel {

    int MID = 0;
    int TOP = 0;

    int height;
    int width;
    boolean isSnowing;
    boolean isSunShining;

    final static String PATH = "./src/semestralProject/img/snowing.jpg";

    // barvy
    final static Color BACKGROUND = Color.decode("#0073cf");
    final static Color GROUND = Color.decode("#00008b");
    final static Color SUN = Color.decode("#FEE12B");
    final static Color SNOWMAN = Color.white;
    final static Color ACCESSORIES = Color.black;
    final static Color HANDS = Color.decode("#964B00");

    public SnowmanPanel(int height, int width, boolean isSnowing, boolean isSunShining) {
        this.height = height;
        this.width = width;
        this.isSnowing = isSnowing;
        this.isSunShining = isSunShining;
    }

    @Override
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        Graphics2D g2d = (Graphics2D) page;

        // nacteni pozadi (pokud snezi)
        if (isSnowing) {
            BufferedImage img;
            try {
                img = ImageIO.read(new File(PATH));
                g2d.drawImage(img, 0, -400, null);
            } catch (IOException ex) {
                System.out.println("Doslo k chybe pri nacitani pozadi. Bude to bohuzel bez snehu :(");
                setBackground(BACKGROUND);
            }
        } else {
            setBackground(BACKGROUND);
        }

        if (isSunShining) {
            g2d.setColor(SUN);
            // slunce
            g2d.fillOval(-30, -30, 80, 80);
        }

        // souradnice pro vykresleni snehulaka
        MID = (int) (getWidth() / 2 - width / 2);
        TOP = (int) (getHeight() - 3 * height - 10);

        g2d.setColor(GROUND);
        // zeme
        g2d.fillRect(0, getHeight() - 13, getWidth(), height);

        g2d.setColor(SNOWMAN);
        drawSnowman(g2d, height, width);

        g2d.setColor(ACCESSORIES);
        // leve oko
        g2d.fillOval(width / 5 + MID, TOP + height / 3, width / 8, height / 8);
        // prave oko
        g2d.fillOval(MID + width / 2 + width / 5, TOP + height / 3, width / 8, height / 8);

        g2d.setStroke(new BasicStroke(3));
        // pusa
        g2d.drawArc(MID + width / 3, TOP + height / 2, width / 3, height / 4, 190, 160);

        g2d.setStroke(new BasicStroke(4));
        g2d.setColor(HANDS);
        // leva ruka
        g2d.drawLine(MID + 5, TOP + (int) (height * 1.5), MID - width + (width / 5), TOP + height);
        // prava ruka
        g2d.drawLine(MID + width - 5, TOP + (int) (height * 1.5), MID + width * 2 - (width / 5), TOP + height);

        g2d.setColor(ACCESSORIES);
        // klobouk - spodni cara
        g2d.drawLine(MID + width / 5, TOP, MID + width / 4 + width / 2, TOP);
        // klobouk - vrsek
        g2d.fillRect(MID + width / 4, TOP - height / 3, width / 2 - 3, height / 3);

        printPf(g2d);
    }

    private void drawSnowman(Graphics g, int height, int width) {
        int x = MID;
        int y = TOP;

        g.fillOval(x, y, width, height); // hlava
        g.fillOval(x, y + height, width, height); // prostredek
        g.fillOval(x, y + height * 2, width, height); // spodek
    }

    private void printPf(Graphics g) {
        String text = "PF 2024";
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        g.drawString(text, getWidth() - 150, 50);
    }
}