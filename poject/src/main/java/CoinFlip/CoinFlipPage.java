package CoinFlip;

import Database.DatabaseConnection;
import Database.InsertGameLogCommand;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CoinFlipPage {
    public static final String GAME_NAME = "CoinFlip";
    private static Logger logger = Logger.getLogger(GAME_NAME + " logger");
    private JButton flipButton;
    private JPanel mainPanel;
    private JLabel resultLabel;
    private JLabel coinImgLabel;
    private JLabel moneyLabel;
    private JTextField textField1;
    private JLabel currentPred;
    private JLabel predLabel;
    private JButton switchButton;
    private final String HEAD = "coinFace.png";
    private final String TAIL = "coinNum.png";

    public CoinFlipPage(){
        JFrame frame = CreateFrame();
        ConfigureJFrame(frame);
        RegisterListeners();
    }
    private JFrame CreateFrame() {
        logger.info("Created CoinFlip frame");
        return new JFrame();
    }
    private void ConfigureJFrame(JFrame frame){
        frame.setContentPane(this.mainPanel);
        frame.pack();
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        setupCoinImgLabel(HEAD);
        logger.info("CoinFlip frame configured");
    }
    private void setupCoinImgLabel(String img){
        try {
            BufferedImage coinImg = ImageIO.read(this.getClass().getResource(img));
            coinImgLabel.setText("");
            coinImgLabel.setIcon(new ImageIcon(coinImg));
            coinImgLabel.setSize(150,150);
        } catch (Exception e){
            logger.info("Image not found! Error: " + e.getMessage());
        }
    }
    private void RegisterListeners() {
        flipButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logger.info("Coin flipped");
                FlipDaCoin();
            }
        });
    }

    private void FlipDaCoin(){
        Random rnd = new Random();
        String result;
        int headsOrTails = rnd.nextInt(2);
        if (headsOrTails == 0){
            setupCoinImgLabel(HEAD);
            result = "H";
        } else {
            setupCoinImgLabel(TAIL);
            result = "T";
        }
        InsertGameLogCommand logCommand = new InsertGameLogCommand(new DatabaseConnection(
                "jdbc:mysql://localhost:3306/gambasim",
                "root",
                ""),
                GAME_NAME,
                "Flip",
                result
        );
        logCommand.execute();
    }
}
