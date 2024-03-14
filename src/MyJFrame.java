import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Math.*;

public class MyJFrame extends JFrame {

    private MyJPanel njp = new MyJPanel();
    private Timer timer;
    private int step = 5;
    private int radius = 125;
    private int i = 0;

    public MyJFrame() {
        super("Title");
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));

        njp.setPreferredSize(new Dimension(500, 500));
        add(njp);

        pack();
        setResizable(false);
        setVisible(true);

        njp.requestFocusInWindow();

        njp.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_1) {
                    if (!timer.isRunning()) {
                        timer.start();
                    } else {
                        timer.stop();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i >= 360)
                    i = 0;
                i += 2;
                System.out.println(i);
                int newX = (int) Math.round(200 + radius * Math.cos(i * Math.PI / 180));
                int newY = (int) Math.round(200 + radius * Math.sin(i * Math.PI / 180));
                setNewCoordinates(newX, newY);
                System.out.println(newX + " " + newY);
            }
        });
    }

    public void setNewCoordinatesStep(int stepX, int stepY) {
        njp.setNewCoordinates(stepX, stepY);
    }

    public void setNewCoordinates(int newX, int newY) {
        njp.setNewCoordinates(newX, newY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyJFrame::new);
    }
}