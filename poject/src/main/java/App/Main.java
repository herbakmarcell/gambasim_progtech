package App;

import DiceGame.DiceGamePage;
import Start.StartPage;
import org.apache.log4j.Logger;

public class Main {
    private static Logger logger = Logger.getLogger("App.Main logger");
    public static void main(String[] args) {
        DiceGamePage form = new DiceGamePage();
        logger.info("Start page was shown");
    }
}