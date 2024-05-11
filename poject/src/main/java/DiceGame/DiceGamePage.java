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
    private JLabel GreetingsLabel;
    private JLabel currentMoney;
    private DiceGameStrategy ds = new DiceGameStrategy(this);
    private MoneyStrategy ms = new MoneyStrategy(this);
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
//    public JTextField getMoneyField() {
//        return moneyField;
//    }

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
                if(getGuessField().getText().equals("")){
                    setResultLabelText("Írj be egy számot");
                    logger.info("The User does not write number in the field");
                }else{
                    if (ds.ThrowDice()){
                        logger.info("Win!");
                    }
                    else{
                        logger.info("Lose!");
                    }
                }
            }
        });
    }
    private void setupDiceImgLabel(){
        try {
            GreetingsLabel.setText("<html><pre>Dobókocka Játék\nJó szórakozást!</pre></html>");
            diceFaceLabel.setText("");
            BufferedImage Img = ImageIO.read(this.getClass().getResource("6.png"));
            diceFaceLabel.setIcon(new ImageIcon(Img));
            diceFaceLabel.setSize(150,150);
            resultLabel.setText("");
        } catch (Exception e){
            logger.info("Image not found! Error: " + e.getMessage());
        }
    }


}
