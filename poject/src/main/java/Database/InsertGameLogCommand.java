package Database;

import org.apache.log4j.Logger;

import javax.swing.*;
public class InsertGameLogCommand implements Command{
    private static Logger logger = Logger.getLogger("InsertGameLog logger");
    private static JFrame frame = new JFrame();
    private DatabaseConnection databaseConnection;
    private String gameName;
    private String event;
    private String result;
    public InsertGameLogCommand(DatabaseConnection databaseConnection, String gameName, String event, String result) {
        this.databaseConnection = databaseConnection;
        this.gameName = gameName;
        this.event = event;
        this.result = result;
    }

    @Override
    public void execute() {

        try {
            this.databaseConnection.getDbConnection().createStatement().executeUpdate("INSERT INTO logs (game, event, result) VALUES ('" + this.gameName + "', '" + this.event + "', '" + this.result + "')");
            logger.info(gameName + " has put a(n) " + event + " event into logs with the result: " + result);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            JOptionPane.showMessageDialog(frame, e.getMessage(), "There was an error while running the command!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
