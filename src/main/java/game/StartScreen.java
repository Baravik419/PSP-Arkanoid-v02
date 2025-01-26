package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel {

    private JFrame parentFrame;

    public StartScreen(JFrame frame) {
        this.parentFrame = frame;
        initStartScreen();
    }

    private void initStartScreen() {
        setLayout(null);
        setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));

        JLabel title = new JLabel("Arkanoid", SwingConstants.CENTER);
        title.setFont(new Font(Constants.FONT, Font.BOLD, 36));
        title.setForeground(Constants.FONT_COLOR_MAIN);
        add(title, BorderLayout.NORTH);

        FontMetrics metrics = title.getFontMetrics(title.getFont());
        int titleWidth = metrics.stringWidth(title.getText()); // Text width
        int titleHeight = metrics.getHeight(); // Text height

        title.setBounds((Constants.WIDTH - titleWidth) / 2, Constants.HEIGHT / 5, titleWidth, titleHeight);

        JButton startButton = new JButton("Start");
        startButton.setFont(new Font(Constants.FONT, Font.PLAIN, 18));
        startButton.setBackground(Constants.BUTTON_COLOR_FILL);
        startButton.setForeground(Constants.FONT_COLOR_ACCENTS);
        startButton.setFocusPainted(false);
        startButton.setBounds((Constants.WIDTH - 100) / 2, (Constants.HEIGHT / 3) + 50, 100, 50);
        startButton.setPreferredSize(new Dimension(150, 50));
        startButton.addActionListener(new StartButtonListener());

        add(startButton);
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Switch to the MainScreen
            parentFrame.getContentPane().removeAll();
            parentFrame.add(new MainScreen());
            parentFrame.revalidate();
            parentFrame.repaint();
        }
    }
}
