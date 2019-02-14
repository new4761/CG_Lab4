import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

class Lab4_60050143 extends JPanel {

    public static void main(String[] args) {
        Lab4_60050143 m = new Lab4_60050143();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("Lab4");
        // f.setBackground(Color.WHITE);s
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 600, 600);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 600, 600);
        g2.setColor(Color.BLACK);
        midpointCircle(g, g2, new Point(300, 300), 20, Color.BLACK);

    }

    // draw dot Graphics
    public void plot(Graphics g, Color c, int x, int y) {

        g.setColor(c);
        g.fillRect(x, y, 1, 1);

    }

    // draw dot with size
    public void plot(Graphics g, Color c, Point pT, int sizeX, int sizeY) {
        g.setColor(c);
        g.fillRect(pT.x, pT.y, sizeX, sizeY);

    }

    // setCurrent Color
    public Color getCurrent_Color(BufferedImage g, Point pT) {
        int rgba = g.getRGB(pT.x, pT.y);
        Color col = new Color(rgba, true);
        return col;

    }

    public void midpointCircle(Graphics g, Graphics2D g2, Point M, int r, Color color) {
        int x = 0;
        int y = r;
        int Dx = 2 * x, Dy = 2 * y, D = 1 - r;

        while (x <= y) {
            //
            plot(g, color, M.x + x, M.y + y);
            plot(g, color, M.x + x, M.y - y);
            plot(g, color, M.x - x, M.y + y);
            plot(g, color, M.x - x, M.y - y);

            plot(g, color, M.y + y, M.x + x);
            plot(g, color, M.y + y, M.x - x);
            plot(g, color, M.y - y, M.x + x);
            plot(g, color, M.y - y, M.x - x);

            g2.setColor(color);
            g2.setStroke(new BasicStroke(10));
            g2.drawLine(M.x, M.y, M.x + x, M.y + y);
            g2.drawLine(M.x, M.y, M.x - x, M.y + y);
            g2.drawLine(M.x, M.y, M.x + x, M.y - y);
            g2.drawLine(M.x, M.y, M.x - x, M.y - y);

            g2.drawLine(M.x, M.y, M.y + y, M.x + x);
            g2.drawLine(M.x, M.y, M.y + y, M.x - x);
            g2.drawLine(M.x, M.y, M.y - y, M.x + x);
            g2.drawLine(M.x, M.y, M.y - y, M.x - x);

            x++;
            Dx += 2;
            D += Dx + 1;

            if (D >= 0) {
                y--;
                Dy -= 2;
                D -= Dy;
            }
        }
    }
}
