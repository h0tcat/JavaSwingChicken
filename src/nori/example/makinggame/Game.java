package nori.example.makinggame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {

    private static Tori player;

    public static int width, height, playerX, playerY;
    private GraphicCanvas canvas;
    public Game(String title, int width, int height){
        super(title);

        canvas = new GraphicCanvas();
        this.add(canvas);

        setWidth(width);
        setHeight(height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null); //画面中央に配置する
        setResizable(false);
        addKeyListener(this);
        player = new Tori();

        player.setX(0);
        player.setY(this.getHeight() / 4); //画面の半分の高さに配置する

        playerX = player.getX();
        playerY = player.getY();
    }

    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void start(){
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                playerY -= 10;
                break;
            case KeyEvent.VK_DOWN:
                playerY += 10;
                break;
            case KeyEvent.VK_LEFT:
                playerX -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                playerX += 10;
                break;
        }

        player.setX(playerX);
        player.setY(playerY);
        System.out.printf("x, %d : y, %d\n",player.getX() ,player.getY());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private class GraphicCanvas extends JPanel{

        private Graphics doubleBufferingGraphicVs;
        public void paintComponent(Graphics graphics){
            super.paintComponent(graphics);

            graphics.drawImage(
                    player.getImageFile().
                            getScaledInstance(
                                    player.getImageFile().getWidth(null) / 2,
                                    player.getImageFile().getHeight(null) / 2,
                                    Image.SCALE_AREA_AVERAGING),
                    player.getX(),
                    player.getY(),
                    this);
            repaint();
        }
    }
}
