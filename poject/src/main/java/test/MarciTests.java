package test;

import App.UserData;
import CoinFlip.CoinFlipPage;
import Database.DatabaseConnection;
import Database.GetAllUserCoinFlips;
import Database.LoginCommand;
import Database.RegisterCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MarciTests {
    @Test
    public void DatabaseConnectionTest(){
        DatabaseConnection db = new DatabaseConnection(
                "jdbc:mysql://localhost:3306/gambasim",
                "root",
                "");
        assertNotNull(db);
    }
    @Test
    void DatabaseConnectionInstanceTest() throws SQLException {

        DatabaseConnection db = new DatabaseConnection(
                "jdbc:mysql://localhost:3306/gambasim",
                "root",
                ""
        );

        assertEquals(
                new DatabaseConnection(
                        "jdbc:mysql://localhost:3306/gambasim",
                        "root",
                        ""
                ).getDbConnection().getMetaData().getURL(),
                db.getDbConnection().getMetaData().getURL()
        );

        assertEquals(
                new DatabaseConnection(
                        "jdbc:mysql://localhost:3306/gambasim",
                        "root",
                        ""
                ).getDbConnection().getMetaData().getUserName(),
                db.getDbConnection().getMetaData().getUserName()
        );
    }
    @ParameterizedTest
    @CsvSource("QAGSVA, GoofyAAH")
    public void LoginTest(String username, String password){
        LoginCommand command = new LoginCommand(new DatabaseConnection(
                "jdbc:mysql://localhost:3306/gambasim",
                "root",
                ""),
                username,
                password);
        command.execute();
        assertNotNull(UserData.username);
    }
    @ParameterizedTest
    @CsvSource("QAGSVA, GoofyAAH")
    public void RegisterTest(String username, String password) throws SQLException {
        RegisterCommand registerCommand = new RegisterCommand(new DatabaseConnection(
                "jdbc:mysql://localhost:3306/gambasim",
                "root",
                ""),
                username,
                password);
        registerCommand.execute();
        assertTrue(!registerCommand.result.isBeforeFirst());
    }
    @ParameterizedTest
    @CsvSource("QAGSVA")
    public void GetUserFlipsTest(String username){
        GetAllUserCoinFlips cmd = new GetAllUserCoinFlips(new DatabaseConnection(
                "jdbc:mysql://localhost:3306/gambasim",
                "root",
                ""),
                username);
        cmd.execute();
        assertNotNull(cmd.getListOfFlips());
    }
    @Test
    public void FlipCheckTest(){
        String[] expected = new String[]{"H", "T"};
        CoinFlipPage cfp = new CoinFlipPage();
        boolean result = expected[0].equals(cfp.FlipDaCoin()) || expected[1].equals(cfp.FlipDaCoin());
        assertTrue(result);
    }

}
