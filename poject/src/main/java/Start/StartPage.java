package Start;

import App.UserData;
import Database.DatabaseConnection;
import Database.LoginCommand;
import Database.RegisterCommand;
import DiceGame.DiceGamePage;
import SelectGame.SelectGamePage;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartPage {
    private static Logger logger = Logger.getLogger("StartPage logger");
    private DatabaseConnection db = new DatabaseConnection(
            "jdbc:mysql://localhost:3306/gambasim",
            "root",
            "");
    private final JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel mainPanel;
    private JLabel pageLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel registerLabel;

    public StartPage(){
        frame = CreateFrame();
        ConfigureJFrame(frame);
        RegisterListeners();
    }
    private JFrame CreateFrame() {
        logger.info("Created login frame");
        return new JFrame();
    }

    private void ConfigureJFrame(JFrame frame){
        frame.setContentPane(this.mainPanel);
        frame.pack();
        frame.setSize(300,300);
        frame.setTitle("Gamba Szimulátor");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        logger.info("Login frame configured");
    }

    private void RegisterListeners() {
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (TryLogin()){
                    SelectGamePage selectPage = new SelectGamePage();
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TryRegister();
            }
        });
    }
    private void TryRegister(){
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        RegisterCommand register = new RegisterCommand(db,username,password);
        register.execute();
    }
    private boolean TryLogin(){
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());
        LoginCommand login = new LoginCommand(db, username, password);
        login.execute();
        if (UserData.username == null) { return false; }
        else { return true; }
    }
}
