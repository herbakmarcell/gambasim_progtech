package Strategies;

import App.UserData;
import Database.DatabaseConnection;
import Database.MoneyChangeCommand;

public class MoneyStrategy {
    int oldBalance;
    private DatabaseConnection db = new DatabaseConnection(
            "jdbc:mysql://localhost:3306/gambasim",
            "root",
            "");
    public void removeMoney(int amount) {
        oldBalance = UserData.balance;
        UserData.balance -= amount;
        MoneyChangeCommand mc = new MoneyChangeCommand(this.db,UserData.username,oldBalance,UserData.balance);
        mc.execute();
    }
    public void addMoney(int amount) {
        oldBalance = UserData.balance;
        UserData.balance += amount;
        MoneyChangeCommand mc = new MoneyChangeCommand(this.db,UserData.username,oldBalance,UserData.balance);
        mc.execute();
    }
}
