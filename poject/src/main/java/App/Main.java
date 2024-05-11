package App;

import org.apache.log4j.Logger;
import Start.StartPage;
public class Main {
    private static Logger logger = Logger.getLogger("App.Main logger");
    public static void main(String[] args) {
        StartPage form = new StartPage();
        logger.info("Start page was shown");
    }
}