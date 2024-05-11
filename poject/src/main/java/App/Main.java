package App;

import CoinFlip.CoinFlipPage;
import Database.DatabaseConnection;
import Database.LoginCommand;
import org.apache.log4j.Logger;
import Start.StartPage;

import javax.imageio.IIOException;
import java.io.IOException;

public class Main {
    private static Logger logger = Logger.getLogger("App.Main logger");
    public static void main(String[] args){
        LoginCommand login = new LoginCommand(
                new DatabaseConnection(
                        "jdbc:mysql://localhost:3306/gambasim",
                        "root",
                        ""),
                "QAGSVA",
                "GoofyAAH"
        );
        login.execute();
        CoinFlipPage form = new CoinFlipPage();
        //StartPage form = new StartPage();
        logger.info("Start page was shown");
    }
}