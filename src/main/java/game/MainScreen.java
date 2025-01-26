package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class MainScreen extends JPanel {

    private Timer timer;
    private String message = "Game over!";
    private Pebble pebble;
    private Bar bar;
    private Block[] blocks;
    private boolean inGame = true;

    private CollisionHandler collisionHandler;

    public MainScreen(){
        initBoard();
        SwingUtilities.invokeLater(this::requestFocusInWindow);
    }

    private void initBoard(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));

        gameInit();
    }

    private void gameInit(){
        blocks = new Block[Constants.NUM_OF_BLOCKS];
        pebble = new Pebble();
        bar = new Bar();

        int k = 0;

        for (int i = 0; i<6; i++){
            for (int j = 0; j<10; j++){

                Random random = new Random();
                int blockType = random.nextInt(2);
                System.out.println(blockType);
                blocks[k] = BlockFactory.createBlock(blockType, j * 50, i * 50);
                k++;
            }
        }

        collisionHandler = new CollisionHandler(pebble, bar, blocks);

        timer = new Timer(Constants.INTERVAL, new GameCycle());
        timer.start();
    }

    private class GameCycle implements ActionListener{
        public void actionPerformed(ActionEvent e){
            doGameCycle();
        }
    }

    private void doGameCycle(){
        pebble.move();

        if(collisionHandler.checkCollision()){
            stopGame();
        }

        bar.move();
        repaint();
    }

    public void stopGame(){
        inGame = false;
        timer.stop();
    }

    public void paint(Graphics g){
        super.paint(g);
        var g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        if(inGame){
            drawObjects(g2d);
        }else{
            gameFinished(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics2D g2d){
        drawPebble(g2d);
        drawBar(g2d);
        drawBlocks(g2d);
    }

    private void drawPebble(Graphics2D g2d){
        g2d.drawImage(pebble.getImage(), pebble.getX(), pebble.getY(), pebble.getImageWidth(), pebble.getImageHeight(), this);
    }

    private void drawBar(Graphics2D g2d){
        g2d.drawImage(bar.getImage(), bar.getX(), bar.getY(), bar.getImageWidth(), bar.getImageHeight(), this);
    }

    private void drawBlocks(Graphics2D g2d){
        for(int i = 0; i < Constants.NUM_OF_BLOCKS; i++){
            if(!blocks[i].isDestroyed()){
                g2d.drawImage(blocks[i].getImage(), blocks[i].getX(), blocks[i].getY(), blocks[i].getImageWidth(), blocks[i].getImageHeight(), this);
            }
        }
    }

    private void gameFinished(Graphics2D g2d){
        var font = new Font(Constants.FONT, Font.BOLD, 36);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.black);
        g2d.setFont(font);
        g2d.drawString(message, (Constants.WIDTH - fontMetrics.stringWidth(message)) / 2, Constants.WIDTH / 2);
    }

    private class TAdapter extends KeyAdapter {
        public void keyReleased(KeyEvent e){
            bar.keyReleased(e);
        }

        public void keyPressed(KeyEvent e){
            bar.keyPressed(e);
        }
    }

}

