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
        Random rnd = new Random();
        int throwNumber=rnd.nextInt(6)+1;
        int guessNumber=0;
        if (gameMode==GAME_MODE.NUMBER)
        {
            guessNumber = Integer.parseInt(dp.getGuessField().getText());
        }
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

    public boolean HasWon(int guess, int result){
        switch (gameMode) {
            case GAME_MODE.NUMBER:
                multiplier=6;
                return guess==result;
            case GAME_MODE.EVEN:
                multiplier=1.5;
                return result%2==0;
            case GAME_MODE.LOWER_EQUAL_THREE:
                multiplier=1.5;
                return result<=3;
            case GAME_MODE.UPPER_THAN_THREE:
                multiplier=1.5;
                return result>3;
            case GAME_MODE.ODD:
                multiplier=1.5;
                return result%2==1;
            default:
                log.error("No Win");
                return false;
        }
    }
}

