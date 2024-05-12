package DiceGame;

import App.UserData;
import Database.DatabaseConnection;
import Database.InsertActionLogCommand;
import Strategies.MoneyStrategy;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DiceGameStrategy {
    public static final String GAME_NAME = "Dice Game";
    private static final Logger log = Logger.getLogger(DiceGameStrategy.class);
    private DiceGamePage dp;
    private GAME_MODE gameMode=GAME_MODE.NUMBER;
    private MoneyStrategy ms = new MoneyStrategy();
    private double multiplier;
    public DiceGameStrategy(DiceGamePage diceGamePage) {
        this.dp = diceGamePage;
    }


    public void setGameMode(GAME_MODE gameMode) {
        this.gameMode = gameMode;
        log.info(this.gameMode);
    }

    public boolean ThrowDice(){
        if (!CheckBet()) { return false; }
        int guessNumber=0;
        if (gameMode==GAME_MODE.NUMBER)
        {
            if (!CheckNum()) { return false; }
            guessNumber = Integer.parseInt(dp.getGuessField().getText());
        }
        Random rnd = new Random();
        int throwNumber=rnd.nextInt(6)+1;


        String resultPicture=throwNumber+".png";
        try {
            dp.setDiceFaceLabelText("");
            BufferedImage Img = ImageIO.read(this.getClass().getResource(resultPicture));
            dp.setDiceFaceLabelIcon(new ImageIcon(Img));
        } catch (Exception e) {
            log.error("Image not found! Error: " + e.getMessage());
            return false;
        }
        if (HasWon(guessNumber,throwNumber)) {
            ms.addMoney((int) (dp.getMoneyField()*multiplier));
            dp.setResultLabelText("Nyertél!");
            InsertActionLogCommand logCommand=new InsertActionLogCommand(new DatabaseConnection(
                    "jdbc:mysql://localhost:3306/gambasim", "root", ""),
                    UserData.username, GAME_NAME, "Throw", String.valueOf(throwNumber));
            logCommand.execute();
            return true;
        } else {
            ms.removeMoney(dp.getMoneyField());
            dp.setResultLabelText("Vesztettél!");
            InsertActionLogCommand logCommand=new InsertActionLogCommand(new DatabaseConnection(
                    "jdbc:mysql://localhost:3306/gambasim", "root", ""),
                    UserData.username, GAME_NAME, "Throw", String.valueOf(throwNumber));
            logCommand.execute();
            return false;
        }
    }

    private boolean CheckNum(){
        JFrame frame = new JFrame();
        try{
            int value = Integer.parseInt(dp.getGuessField().getText());
            if (value <= 1 || value > 6) {
                JOptionPane.showMessageDialog(frame, "Nem megfelelő tét!", "Hiba", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Nem megfelelő formátum!", "Hiba", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    private boolean CheckBet(){
        JFrame frame = new JFrame();
        try{
            int betValue = dp.getMoneyField();
            if (betValue <= 0) {
                JOptionPane.showMessageDialog(frame, "Nem lehet negatív tét!", "Hiba", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Nem megfelelő formátum!", "Hiba", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public boolean HasWon(int guess, int result){
        switch (gameMode) {
            case NUMBER:
                multiplier=6;
                return guess==result;
            case EVEN:
                multiplier=1.5;
                return result%2==0;
            case LOWER_EQUAL_THREE:
                multiplier=1.5;
                return result<=3;
            case UPPER_THAN_THREE:
                multiplier=1.5;
                return result>3;
            case ODD:
                multiplier=1.5;
                return result%2==1;
            default:
                log.error("No Win");
                return false;
        }
    }
}

