package Database;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static Logger logger = Logger.getLogger("Database Connection logger");
    private static JFrame frame = new JFrame();
    private Connection dbConnection;

    public DatabaseConnection(String url, String username, String password) {

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
        }
        catch (Exception e) {
            connection = null;
            logger.error(e.getMessage());

            JOptionPane.showMessageDialog(frame, e.getMessage(), "Adatbázis csatlakozási hiba!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        this.setDbConnection(connection);
    }

    public Connection getDbConnection() {
        return dbConnection;
    }
    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

}