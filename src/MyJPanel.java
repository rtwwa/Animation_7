import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
class MyJPanel extends JPanel {
    private int myX = 0;
    private int myY = 0;
    private final int step = 20;

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

        switch (event.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if (myX + 100 + step > getWidth())
                    break;
                myX += step;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if (myX - step < 0)
                    break;
                myX -= step;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if (myY + 100 + step > getHeight())
                    break;
                myY += step;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if (myY - step < 0)
                    break;
                myY -= step;
                break;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillOval(myX, myY, 100, 100);
        g.setColor(Color.blue);
        g.fillOval(myX, myY + 25, 100, 50);
        g.setColor(Color.red);
        g.fillRect(myX + 37, myY + 37, 25, 25);
    }

    public void setNewCoordinatesStep(int stepX, int stepY) {
        int newX = myX + stepX;
        int newY = myY + stepY;

        boolean validX = newX >= 0 && newX + 100 <= getWidth();
        boolean validY = newY >= 0 && newY + 100 <= getHeight();

        if (validX && validY) {
            myX = newX;
            myY = newY;
            repaint();
        }
    }

    public void setNewCoordinates(int newX, int newY) {
        boolean validX = newX >= 0 && newX + 100 <= getWidth();
        boolean validY = newY >= 0 && newY + 100 <= getHeight();

        if (validX && validY) {
            myX = newX;
            myY = newY;
            repaint();
        }
    }
}