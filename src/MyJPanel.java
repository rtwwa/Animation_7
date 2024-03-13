import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
class MyJPanel extends JPanel {
    private int x = 0;
    private int y = 0;

    public MyJPanel() {
        setFocusable(true);
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                keyPressedMovement(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    private void keyPressedMovement(KeyEvent event) {
        int i = 20;

        switch (event.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (x + 100 + i > getWidth())
                    break;
                x += i;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (x - i < 0)
                    break;
                x -= i;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (y + 100 + i > getHeight())
                    break;
                y += i;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (y - i < 0)
                    break;
                y -= i;
                break;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(x + 25, y, 35, 85);
        g.setColor(Color.yellow);
        g.fillRect(x, y + 25, 85, 35);
        g.setColor(Color.blue);
        g.fillOval(x + 25, y + 25, 35, 35);
    }

    public void moveSquare(int deltaX, int deltaY) {
        int newX = x + deltaX;
        int newY = y + deltaY;

        if (newX >= 0 && newX + 100 <= getWidth() && newY >= 0 && newY + 100 <= getHeight()) {
            x = x + deltaX;
            y = y + deltaY;
            repaint();
        }
    }
}