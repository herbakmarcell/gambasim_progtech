package Database;

import org.apache.log4j.Logger;

import javax.swing.*;
public class InsertActionLogCommand implements Command{
    private static Logger logger = Logger.getLogger("InsertActionLog logger");
    private static JFrame frame = new JFrame();
    private DatabaseConnection databaseConnection;
    private String user;
    private String action;
    private String event;
    private String result;
    public InsertActionLogCommand(DatabaseConnection databaseConnection, String user, String action, String event, String result) {
        this.databaseConnection = databaseConnection;
        this.user = user;
        this.action = action;
        this.event = event;
        this.result = result;
    }

    @Override
    public void execute() {

        try {
            this.databaseConnection.getDbConnection().createStatement().executeUpdate("INSERT INTO logs (user, action, event, result) VALUES ('" + this.user + "', '"+ this.action + "', '" + this.event + "', '" + this.result + "')");
            logger.info(action + " has put a(n) " + event + " event into logs with the result: " + result);
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Insert Log Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
