package test;


import DiceGame.DiceGamePage;
import DiceGame.DiceGameStrategy;
import DiceGame.GAME_MODE;
import org.junit.jupiter.api.Test;




import static org.junit.jupiter.api.Assertions.assertEquals;


public class MateTest {
    @Test
    public void testHasWon_NUMBER_Mode_true() {
        DiceGameStrategy strategy = new DiceGameStrategy(null);
        strategy.setGameMode(GAME_MODE.NUMBER);
        int guess = 3;
        int result = 3;
        boolean resultOfWin = strategy.HasWon(guess, result);
        boolean expect=true;
        assertEquals(expect,resultOfWin);
    }
    @Test
    public void testHasWon_NUMBER_Mode_false() {
        DiceGameStrategy strategy = new DiceGameStrategy(null);
        strategy.setGameMode(GAME_MODE.NUMBER);
        int guess = 2;
        int result = 4;
        boolean resultOfWin = strategy.HasWon(guess, result);
        boolean expect=false;
        assertEquals(expect,resultOfWin);
    }
    @Test
    public void testHasWon_EVEN_Mode_true() {
        DiceGameStrategy strategy = new DiceGameStrategy(null);
        strategy.setGameMode(GAME_MODE.EVEN);
        int guess = 2;
        int result = 4;
        boolean resultOfWin = strategy.HasWon(guess, result);
        boolean expect=true;
        assertEquals(expect,resultOfWin);
    }
    @Test
    public void testHasWon_EVEN_Mode_false() {
        DiceGameStrategy strategy = new DiceGameStrategy(null);
        strategy.setGameMode(GAME_MODE.EVEN);
        int guess = 2;
        int result = 3;
        boolean resultOfWin = strategy.HasWon(guess, result);
        boolean expect=false;
        assertEquals(expect,resultOfWin);
    }

    @Test
    public void testHasWon_UPPER_THAN_THREE_Mode() {
        DiceGameStrategy strategy = new DiceGameStrategy(null);
        strategy.setGameMode(GAME_MODE.UPPER_THAN_THREE);
        int guess = 0;
        int result = 4;
        boolean resultOfWin = strategy.HasWon(guess, result);
        boolean expect=true;
        assertEquals(expect,resultOfWin);
    }
    @Test
    public void testHasWon_LOWER_EQUAL_THREE_Mode() {
        DiceGameStrategy strategy = new DiceGameStrategy(null);
        strategy.setGameMode(GAME_MODE.LOWER_EQUAL_THREE);
        int guess = 0;
        int result = 2;
        boolean resultOfWin = strategy.HasWon(guess, result);
        boolean expect=true;
        assertEquals(expect,resultOfWin);
    }




}
