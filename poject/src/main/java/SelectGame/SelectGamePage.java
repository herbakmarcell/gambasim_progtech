package SelectGame;

import CoinFlip.CoinFlipPage;
import DiceGame.DiceGamePage;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectGamePage {
    private final JFrame frame;
    private JPanel panel1;
    private JButton diceGameBtn;
    private JButton coinFlipBtn;
    private static Logger logger = Logger.getLogger("SelectPage logger");

    public SelectGamePage() {
        frame=CreateFrame();
        ConfigureJFrame(frame);
        RegisterListeners();
    }
    private JFrame CreateFrame() {
        logger.info("Created login frame");
        return new JFrame();
    }
    public void ConfigureJFrame(JFrame frame) {
        frame.setContentPane(this.panel1);
        frame.setVisible(true);
        frame.pack();
        frame.setResizable(false);
        frame.setTitle("Select Game");
        frame.setSize(650,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void RegisterListeners(){
        coinFlipBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CoinFlipPage form = new CoinFlipPage();
                frame.setVisible(false);
                frame.dispose();
            }
        });
        diceGameBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DiceGamePage form = new DiceGamePage();
                frame.setVisible(false);
                frame.dispose();

            }
        });
    }
}
