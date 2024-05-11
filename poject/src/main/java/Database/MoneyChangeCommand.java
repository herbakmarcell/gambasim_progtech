package Database;

import App.UserData;
import org.apache.log4j.Logger;

import javax.swing.*;

public class MoneyChangeCommand implements Command{
    private static Logger logger = Logger.getLogger("Money logger");
    private static JFrame frame = new JFrame();
    private DatabaseConnection databaseConnection;
    private String user;
    private int oldBalance;
    private int newBalance;
    public MoneyChangeCommand(DatabaseConnection databaseConnection, String user,int oldBalance, int newBalance) {
        this.databaseConnection = databaseConnection;
        this.user = user;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;

    }
    @Override
    public void execute() {
        String query = "UPDATE users SET balance = " + newBalance + " WHERE username = " + "'" + this.user + "'";
        try {
            this.databaseConnection.getDbConnection().createStatement().executeUpdate(query);
            logger.info("Money successfully changed for user " + UserData.username);
        } catch (Exception e) {
            logger.error(e.getMessage());
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Error while changing money", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            moneyChangedDatabase();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
    private void moneyChangedDatabase(){
        InsertActionLogCommand command = new InsertActionLogCommand(this.databaseConnection,UserData.username,"Balance","Change",String.valueOf(newBalance-oldBalance));
        command.execute();
    }
}
