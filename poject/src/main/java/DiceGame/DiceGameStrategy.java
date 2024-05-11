package DiceGame;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DiceGameStrategy {
    private static final Logger log = Logger.getLogger(DiceGameStrategy.class);
    private DiceGamePage dp;
    private GAME_MODE gameMode=GAME_MODE.NUMBER;
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
            dp.setResultLabelText("Nyertél!");
            return true;
        } else {
            dp.setResultLabelText("Vesztettél!");
            return false;
        }
    }

    public boolean HasWon(int guess, int result){
        switch (gameMode) {
            case GAME_MODE.NUMBER:
                return guess==result;
            case GAME_MODE.EVEN:
                return result%2==0;
            case GAME_MODE.LOWER_EQUAL_THREE:
                return result<=3;
            case GAME_MODE.UPPER_THAN_THREE:
                return result>3;
            default:
                log.error("No Win");
                return false;
        }
    }
}

