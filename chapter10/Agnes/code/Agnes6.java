package chapter10.Agnes.code;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Agnes6 extends JFrame {

    public Agnes6() {
        setTitle("Game Agnes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Consts.CV_WIDTH, Consts.CV_HEIGHT);
        setLayout(new BorderLayout());

        GameCanvas gameCv = new GameCanvas();
        add(gameCv, BorderLayout.CENTER);

        PlayerPanel playerPanel = new PlayerPanel();
        playerPanel.setGameCanvas(gameCv);
        add(playerPanel, BorderLayout.SOUTH);

        gameCv.setPlayerPanel(playerPanel);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Agnes6();
    }
}