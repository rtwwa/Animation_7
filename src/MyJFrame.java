import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame extends JFrame {

    private MyJPanel njp = new MyJPanel();
    private Timer timer;
    private Timer timer2;
    private int deltaX = 5;
    private int deltaY = 5;

    public MyJFrame() {
        super("Практическая работа");
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

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                njp.moveSquare(deltaX, 0);
            }
        });

        timer2 = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                njp.moveSquare(-deltaX, 0);
            }
        });

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
                if (e.getKeyCode() == KeyEvent.VK_2) {
                    if (!timer2.isRunning()) {
                        timer2.start();
                    } else {
                        timer2.stop();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    public void moveSquare(int deltaX, int deltaY) {
        njp.moveSquare(deltaX, deltaY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyJFrame::new);
    }
}