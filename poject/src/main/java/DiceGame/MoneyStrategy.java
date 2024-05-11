package DiceGame;

public class MoneyStrategy {
    private DiceGamePage dp;
    public MoneyStrategy(DiceGamePage diceGamePage) {
        this.dp = diceGamePage;
    }

    public int removeMoney(int currentMoney, int amount) {
        currentMoney -= amount;
        return currentMoney;
    }
    public int addMoney(int currentMoney, int amount) {
        currentMoney += amount;
        return currentMoney;
    }
}
