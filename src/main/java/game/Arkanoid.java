package game;

import javax.swing.JFrame;
import java.awt.EventQueue;

public class Arkanoid extends JFrame {
    public Arkanoid() {
        initUI();
    }

    public void initUI(){
        add(new StartScreen(this));
        setTitle("Arkanoid");

        pack();
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var game = new Arkanoid();
            game.setVisible(true);
        });
    }
}
