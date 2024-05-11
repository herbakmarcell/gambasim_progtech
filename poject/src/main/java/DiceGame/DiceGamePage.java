package DiceGame;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DiceGamePage{
    private JFrame frame;
    private JButton ThrowBtn;
    private JPanel mainPanel;
    private JTextField guessField;
    private JLabel diceFaceLabel;
    private JLabel resultLabel;
    private static Logger logger = Logger.getLogger("DiceGame logger");

    public DiceGamePage(){
        JFrame frame = CreateFrame();
        ConfigureJFrame(frame);
        RegisterListeners();
    }
    private JFrame CreateFrame() {
        logger.info("Created Dice Game frame");
        return new JFrame();
    }
    private void ConfigureJFrame(JFrame frame){
        frame.setContentPane(this.mainPanel);
        frame.pack();
        frame.setSize(650,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        setupDiceImgLabel();
        logger.info("Dice Game frame configured");
    }
    private void RegisterListeners() {
        ThrowBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logger.info("Dice throw button clicked");
                ThrowDice();
            }
        });
    }
    private void setupDiceImgLabel(){
        try {
            BufferedImage Img = ImageIO.read(this.getClass().getResource("Greetings.png"));
            diceFaceLabel.setText("");
            diceFaceLabel.setIcon(new ImageIcon(Img));
            diceFaceLabel.setSize(100,100);
        } catch (Exception e){
            logger.info("Image not found! Error: " + e.getMessage());
        }
    }

    private void ThrowDice(){
        Random rnd = new Random();
        int throwNumber=rnd.nextInt(6);
        if(guessField.getText().equals("")){
            resultLabel.setText("You need to guess a number");
        }
        else {
        switch (throwNumber+1) {
            case 1:
                try {
                    BufferedImage Img = ImageIO.read(this.getClass().getResource("1.png"));
                    diceFaceLabel.setText("");
                    diceFaceLabel.setIcon(new ImageIcon(Img));
                    diceFaceLabel.setSize(150, 150);
                } catch (Exception e) {
                    logger.info("Image not found! Error: " + e.getMessage());
                }
                if (guessField.getText().equals("1")) {
                    resultLabel.setText("You win!");
                } else {
                    resultLabel.setText("You lose!");
                }
                break;
            case 2:
                try {
                    BufferedImage Img = ImageIO.read(this.getClass().getResource("2.png"));
                    diceFaceLabel.setText("");
                    diceFaceLabel.setIcon(new ImageIcon(Img));
                    diceFaceLabel.setSize(150, 150);
                } catch (Exception e) {
                    logger.info("Image not found! Error: " + e.getMessage());
                }
                if (guessField.getText().equals("2")) {
                    resultLabel.setText("You win!");
                } else {
                    resultLabel.setText("You lose!");
                }
                break;
            case 3:
                try {
                    BufferedImage Img = ImageIO.read(this.getClass().getResource("3.png"));
                    diceFaceLabel.setText("");
                    diceFaceLabel.setIcon(new ImageIcon(Img));
                    diceFaceLabel.setSize(150, 150);
                } catch (Exception e) {
                    logger.info("Image not found! Error: " + e.getMessage());
                }
                if (guessField.getText().equals("3")) {
                    resultLabel.setText("You win!");
                } else {
                    resultLabel.setText("You lose!");
                }
                break;
            case 4:
                try {
                    BufferedImage Img = ImageIO.read(this.getClass().getResource("4.png"));
                    diceFaceLabel.setText("");
                    diceFaceLabel.setIcon(new ImageIcon(Img));
                    diceFaceLabel.setSize(150, 150);
                } catch (Exception e) {
                    logger.info("Image not found! Error: " + e.getMessage());
                }
                if (guessField.getText().equals("4")) {
                    resultLabel.setText("You win!");
                } else {
                    resultLabel.setText("You lose!");
                }
                break;
            case 5:
                try {
                    BufferedImage Img = ImageIO.read(this.getClass().getResource("5.png"));
                    diceFaceLabel.setText("");
                    diceFaceLabel.setIcon(new ImageIcon(Img));
                    diceFaceLabel.setSize(150, 150);
                } catch (Exception e) {
                    logger.info("Image not found! Error: " + e.getMessage());
                }
                if (guessField.getText().equals("5")) {
                    resultLabel.setText("You win!");
                } else {
                    resultLabel.setText("You lose!");
                }
                break;
            case 6:
                try {
                    BufferedImage Img = ImageIO.read(this.getClass().getResource("6.png"));
                    diceFaceLabel.setText("");
                    diceFaceLabel.setIcon(new ImageIcon(Img));
                    diceFaceLabel.setSize(150, 150);
                } catch (Exception e) {
                    logger.info("Image not found! Error: " + e.getMessage());
                }
                if (guessField.getText().equals("6")) {
                    resultLabel.setText("You win!");
                } else {
                    resultLabel.setText("You lose!");
                }
                break;
            }
        }
    }
}
