package Database;

import App.UserData;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetAllUserCoinFlips implements Command{
    private static Logger logger = Logger.getLogger("GetAllUserCoinFlips logger");
    private static JFrame frame = new JFrame();
    private DatabaseConnection databaseConnection;
    private String username;
    private ResultSet results;
    private ArrayList<String> userFlips;

    public ArrayList<String> getListOfFlips() {
        return userFlips;
    }

    public GetAllUserCoinFlips(DatabaseConnection databaseConnection, String username) {
        this.databaseConnection = databaseConnection;
        this.username = username;
        this.userFlips = new ArrayList<>();
    }
    @Override
    public void execute() {
        String query = "SELECT * FROM logs WHERE user = " + "'" + this.username + "'" + " AND action = 'CoinFlip'";
        userFlips.clear();
        try {
            this.results = this.databaseConnection.getDbConnection().createStatement().executeQuery(query);
            while(this.results.next()){
                userFlips.add((this.results.getString("result").equals("H")?"F":"Í"));
            }
            logger.info(this.username + " got data of the coin flips.");
        } catch (Exception e){
            logger.error("Error while getting the users flips.");
        }
    }
}
