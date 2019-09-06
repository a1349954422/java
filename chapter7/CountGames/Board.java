package chapter7.CountGames;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel {
    private Playerp playerp;

    private String diff;
    private String num;
    private  boolean initPaint = true;
    private boolean hasInput = false;
    private int n1;
    private int n2;
    private int index;
    private int answer;
    private String countString;
    private int playAnswer;
    private int diffNumScore;
    int i;


    public Board() {
        this.setPreferredSize(new Dimension(Consts.CV_WIDTH,Consts.BOARD_H));
    }

    public void initGame() {
        num = playerp.getNum();
        diff = playerp.getDiff();
        i = 1;
        repaint();
    }

    public void paintComponent(Graphics g) {
        if(hasInput) {
            paintCount(g);
            hasInput = false;
        }else if(initPaint){
            paintEmpty(g);
        }
    }

    public void paintCount(Graphics g) {
        Random r = new Random();
        r.nextInt();
            if(diff.equals("easy")){
                n1 = r.nextInt(11);
                n2 = r.nextInt(11);
                index = r.nextInt(5);
                answer = makeCount(n1, n2, index);
                diffNumScore = 10;
            }else if(diff.equals("middle")){
                n1 = r.nextInt(11) * 10;
                n2 = r.nextInt(11) * 10;
                index = r.nextInt(5);
                answer = makeCount(n1, n2, index);
                diffNumScore = 20;
            }else if(diff.equals("hard")){
                n1 = r.nextInt(11) * 100;
                n2 = r.nextInt(11) * 100;
                index = r.nextInt(5);
                answer = makeCount(n1, n2, index);
                diffNumScore = 50;
            }

    }



    private void paintEmpty(Graphics g) {
        playerp.setCount("");
        playerp.setScore("");
    }



    public int makeCount(int n1, int n2, int index) {
        if(index == 0){
            answer = n1 + n2;
            countString = "" + n1 + "+" +  n2;
        }else  if(index == 1){
            answer = n1 - n2;
            countString = "" + n1  + "-" +  n2;
        }else if(index == 2){
            answer = n1 * n2;
            countString = "" + n1 + "*" +  n2;
        }else if(index == 3){
            answer = n1 / n2;
            countString = "" + n1  + "/" +  n2;
        }else if(index == 4){
            answer = n1 % n2;
            countString = "" + n1  +" % "+  n2;
        }
        playerp.setCount(countString);
        return answer;
    }

    public void receiveAnswer(String anAnswer) {
        try{
            this.playAnswer = Integer.parseInt(anAnswer);
            if(playAnswer == answer){
                playerp.setScore("you are right,your score:" + diffNumScore );
            }else {
                playerp.setScore("error answer");
            }
            int n = Integer.parseInt(num);
            if(i < n){
                hasInput = true;
                repaint();
                i++;
            }

        }catch (StringIndexOutOfBoundsException sex){
            playerp.setScore("" + 0);
            System.exit(0);
        }catch (NullPointerException e){
            System.exit(0);
        }

    }

    public void setPlayerp(Playerp playerp){
        this.playerp = playerp;
    }


    public void setInit(boolean b) {
        initPaint = true;
    }

    public void setPlay(boolean b) {
        hasInput = b;
    }

    public void initNum() {
        num = playerp.getNum();
    }
}
