package Database;

import App.UserData;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.sql.ResultSet;

public class RegisterCommand implements Command{
    private static Logger logger = Logger.getLogger("Register logger");
    private static JFrame frame = new JFrame();
    private DatabaseConnection databaseConnection;
    private ResultSet result;
    private String username;
    private String password;

    public RegisterCommand(DatabaseConnection databaseConnection, String username, String password) {
        this.databaseConnection = databaseConnection;
        this.username = username;
        this.password = password;
    }
    @Override
    public void execute() {
        if (username.isBlank() || password.isBlank()) {
            logger.info("Field left blank");
            JOptionPane.showMessageDialog(frame, "Kérem töltse ki a mezőket!", "Sikertelen regisztáció", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String query = "SELECT * FROM users WHERE username = " + "'" + this.username + "'";
            this.result = this.databaseConnection.getDbConnection().createStatement().executeQuery(query);

            if(result.isBeforeFirst()){
                logger.info(this.username + " is already registered!");
                JOptionPane.showMessageDialog(frame, "Ez a felhasználónév már foglalt!", "Sikertelen regisztáció", JOptionPane.ERROR_MESSAGE);
            } else {
                RegisterUser();
                JOptionPane.showMessageDialog(frame, "Most már bejelentkezhet!", "Sikeres regisztráció", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage());
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Register Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void RegisterUser(){
        try {
            this.databaseConnection.getDbConnection().createStatement().executeUpdate("INSERT INTO users (username, password, balance) VALUES ('" + this.username + "', '"+ this.password + "', " + 1000 + ")");
            logger.info("User named " + this.username+ " has been registered!");

        }
        catch (Exception e) {
            logger.error(e.getMessage());
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Register Error", JOptionPane.ERROR_MESSAGE);
        }
        LogIntoDatabase("Success");
    }
    private void LogIntoDatabase(String result){
        InsertActionLogCommand command = new InsertActionLogCommand(this.databaseConnection,"SYSTEM","Register",this.username,result);
        command.execute();
    }
}
