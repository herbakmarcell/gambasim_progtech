package DiceGame;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
    private JTextField moneyField;
    private DiceGameStrategy ds = new DiceGameStrategy(this);
    public static Logger logger = Logger.getLogger("DiceGame logger");

    public void setResultLabelText(String text) {
        resultLabel.setText(text);
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public void setDiceFaceLabelIcon(ImageIcon img) {
        this.diceFaceLabel.setIcon(img);
    }
    public void setDiceFaceLabelText(String text) {
        this.diceFaceLabel.setText(text);
    }

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
                ds.ThrowDice();
            }
        });
    }
    private void setupDiceImgLabel(){
        try {
            diceFaceLabel.setText("<html><pre>This is our Dice Game\nHave Fun!</pre></html>");
            diceFaceLabel.setSize(150,150);
        } catch (Exception e){
            logger.info("Image not found! Error: " + e.getMessage());
        }
    }


}
