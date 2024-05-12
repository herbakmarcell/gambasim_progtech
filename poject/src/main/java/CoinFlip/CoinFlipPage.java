package CoinFlip;

import Database.DatabaseConnection;
import Database.GetAllUserCoinFlips;
import Database.InsertActionLogCommand;
import App.UserData;
import Strategies.MoneyStrategy;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class CoinFlipPage {
    public static final String GAME_NAME = "CoinFlip";
    private DatabaseConnection db = new DatabaseConnection(
            "jdbc:mysql://localhost:3306/gambasim",
            "root",
            "");
    private static Logger logger = Logger.getLogger(GAME_NAME + " logger");
    private MoneyStrategy ms = new MoneyStrategy();
    private int betValue;
    private JButton flipButton;
    private JPanel mainPanel;
    private JLabel resultLabel;
    private JLabel coinImgLabel;
    private JLabel betLabel;
    private JTextField betField;
    private JLabel currentPred;
    private JLabel predLabel;
    private JButton switchButton;
    private JLabel latestFlipsLabel;
    private JLabel flipDataLabel;
    private JLabel balanceTextLabel;
    private JLabel balanceLabel;
    private JLabel statusLabel;
    private final String HEAD = "coinFace.png";
    private final String TAIL = "coinNum.png";
    private boolean betCoinState = false; // Head

    public CoinFlipPage(){
        JFrame frame = CreateFrame();
        ConfigureJFrame(frame);
        RegisterListeners();
        refreshBalance();
    }
    private JFrame CreateFrame() {
        logger.info("Created CoinFlip frame");
        return new JFrame();
    }
    private void ConfigureJFrame(JFrame frame){
        frame.setContentPane(this.mainPanel);
        frame.pack();
        frame.setSize(500,500);
        frame.setTitle("Pénzfeldobó Szimulátor 3000");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        setupCoinImgLabel(HEAD);
        recentFlips();
        logger.info("CoinFlip frame configured");
    }
    private void setupCoinImgLabel(String img){
        currentPred.setText("Fej");
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
                hasWon(FlipDaCoin());
                recentFlips();
            }
        });

        switchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                FlipDaLabel();
                logger.info("Prediction changed to " + (betCoinState ? "Tail" : "Head"));
            }
        });

    }
    private void hasWon(String result){
        JFrame frame = new JFrame();
        try{
            betValue = Integer.parseInt(betField.getText().toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Nem megfelelő formátum!", "Hiba", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String prediction = (betCoinState ? "T" : "H");
        if (result.equals(prediction)){
            JOptionPane.showMessageDialog(frame, "Nyereményed: " + betValue, "Nyertél!", JOptionPane.PLAIN_MESSAGE);
            ms.addMoney(2 * betValue);
        } else {
            JOptionPane.showMessageDialog(frame, "Majd legközelebb!", "Vesztettél!", JOptionPane.ERROR_MESSAGE);
            ms.removeMoney(betValue);
        }
        refreshBalance();
    }
    private void FlipDaLabel(){
        betCoinState = !betCoinState;
        if (betCoinState){
            currentPred.setText("Írás");
        } else {
            currentPred.setText("Fej");
        }
    }
    public String FlipDaCoin(){

        Random rnd = new Random();
        String result;

        int headsOrTails = rnd.nextInt(2);
        if (headsOrTails == 0){
            setupCoinImgLabel(HEAD);
            statusLabel.setText("Fej");
            result = "H";
        } else {
            setupCoinImgLabel(TAIL);
            statusLabel.setText("Írás");
            result = "T";
        }

        InsertActionLogCommand logCommand = new InsertActionLogCommand(this.db,
                UserData.username,
                GAME_NAME,
                "Flip",
                result
        );
        logCommand.execute();
        return result;
    }
    private void refreshBalance(){
        balanceLabel.setText(String.valueOf(UserData.balance));
    }
    private void recentFlips(){
        GetAllUserCoinFlips flipsCommand = new GetAllUserCoinFlips(this.db,UserData.username);
        flipsCommand.execute();

        ArrayList<String> flips = flipsCommand.getListOfFlips();
        if (flips.isEmpty()) return;

        StringBuilder sb = new StringBuilder();
        for (int i = flips.size() - 1; i >= 0; i--) {
            if ((flips.size() - 1) - i > 9){ break; }
            sb.append(flips.get(i) + " ");
        }
        flipDataLabel.setText(sb.toString());
    }
}
