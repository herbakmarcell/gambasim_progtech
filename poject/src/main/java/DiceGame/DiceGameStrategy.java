package DiceGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DiceGameStrategy {
    private DiceGamePage dp;
    public DiceGameStrategy(DiceGamePage diceGamePage) {
        this.dp = diceGamePage;
    }

    public void ThrowDice(){
        Random rnd = new Random();
        int throwNumber=rnd.nextInt(6);
        if(dp.getGuessField().getText().equals("")){
            dp.setResultLabelText("You need to guess a number");
        }
        else {
            switch (throwNumber+1) {
                case 1:
                    try {
                        dp.setDiceFaceLabelText("");
                        BufferedImage Img = ImageIO.read(this.getClass().getResource("1.png"));
                        dp.setDiceFaceLabelIcon(new ImageIcon(Img));
                    } catch (Exception e) {
                        DiceGamePage.logger.info("Image not found! Error: " + e.getMessage());
                    }
                    if (dp.getGuessField().getText().equals("1")) {
                        dp.setResultLabelText("You win!");
                    } else {
                        dp.setResultLabelText("You lose!");
                    }
                    break;
                case 2:
                    try {
                        dp.setDiceFaceLabelText("");
                        BufferedImage Img = ImageIO.read(this.getClass().getResource("2.png"));
                        dp.setDiceFaceLabelIcon(new ImageIcon(Img));
                    } catch (Exception e) {
                        DiceGamePage.logger.info("Image not found! Error: " + e.getMessage());
                    }
                    if (dp.getGuessField().getText().equals("2")) {
                        dp.setResultLabelText("You win!");
                    } else {
                        dp.setResultLabelText("You lose!");
                    }
                    break;
                case 3:
                    try {
                        dp.setDiceFaceLabelText("");
                        BufferedImage Img = ImageIO.read(this.getClass().getResource("3.png"));
                        dp.setDiceFaceLabelIcon(new ImageIcon(Img));
                    } catch (Exception e) {
                        DiceGamePage.logger.info("Image not found! Error: " + e.getMessage());
                    }
                    if (dp.getGuessField().getText().equals("3")) {
                        dp.setResultLabelText("You win!");
                    } else {
                        dp.setResultLabelText("You lose!");
                    }
                    break;
                case 4:
                    try {
                        dp.setDiceFaceLabelText("");
                        BufferedImage Img = ImageIO.read(this.getClass().getResource("4.png"));
                        dp.setDiceFaceLabelIcon(new ImageIcon(Img));
                    } catch (Exception e) {
                        DiceGamePage.logger.info("Image not found! Error: " + e.getMessage());
                    }
                    if (dp.getGuessField().getText().equals("4")) {
                        dp.setResultLabelText("You win!");
                    } else {
                        dp.setResultLabelText("You lose!");
                    }
                    break;
                case 5:
                    try {
                        dp.setDiceFaceLabelText("");
                        BufferedImage Img = ImageIO.read(this.getClass().getResource("5.png"));
                        dp.setDiceFaceLabelIcon(new ImageIcon(Img));
                    } catch (Exception e) {
                        DiceGamePage.logger.info("Image not found! Error: " + e.getMessage());
                    }
                    if (dp.getGuessField().getText().equals("5")) {
                        dp.setResultLabelText("You win!");
                    } else {
                        dp.setResultLabelText("You lose!");
                    }
                    break;
                case 6:
                    try {
                        dp.setDiceFaceLabelText("");
                        BufferedImage Img = ImageIO.read(this.getClass().getResource("6.png"));
                        dp.setDiceFaceLabelIcon(new ImageIcon(Img));
                    } catch (Exception e) {
                        DiceGamePage.logger.info("Image not found! Error: " + e.getMessage());
                    }
                    if (dp.getGuessField().getText().equals("6")) {
                        dp.setResultLabelText("You win!");
                    } else {
                        dp.setResultLabelText("You lose!");
                    }
                    break;
            }
        }
    }
}
