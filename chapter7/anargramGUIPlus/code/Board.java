package chapter7.anargramGUI.code;

import javax.swing.JPanel;
import javax.swing.JComponent;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel {
    private ReadFile readFile;
    private PlayerPanel playerPanel;

    private int missNum;
    private String diffStr;
    private String givenWord;
    private int wordLen;
    private char[] scranbledWord;
    private String guessWord;
    private char[] guessWordAry;
    private boolean hasGuessed = false;
    private int totalScore = 0;
    private boolean initPaint = true;

    private char[] currAry;
    private int cx;
    private int bx,by;
    private int sx,sy;

    public Board() {
        this.setPreferredSize(new Dimension(Consts.CV_WIDTH,Consts.BOARD_H));
        wordLen = 8;
        repaint();
    }

    public void initDiffcult(){

    }

    public void initGivenWord() {
        hasGuessed = false;
        givenWord = readFile.readContent();
        givenWord = givenWord.toLowerCase();
        wordLen = givenWord.length();
        diffStr = playerPanel.getSelect();
        missNum = getMissNum(diffStr);
        scranbledWord = scranbledWord(currAry);
        repaint();
    }

    private int getMissNum(String diffStr) {
        if(diffStr.equals("easy")){
            missNum = (int)(Math.ceil(currAry.length * 0.1));
        }else if(diffStr.equals("middle")){
            missNum = (int)(Math.ceil(currAry.length * 0.5));
        }else if(diffStr.equals("hard")){
            missNum = (int)(Math.ceil(currAry.length * 0.8));
        }
        return missNum;
    }

    public char[] scranbledWord(char[] ary) {
        Random r = new Random();
        int num = ary.length;
        r.nextInt();
        int count = 0;
            while(count < missNum){
                int index = r.nextInt(num);
                ary[index] = 'X';
                count++;
        }
        return ary;
    }


    public void receiveGuess(String aGuessWoed) {
        try {
            this.guessWord = aGuessWoed;
            guessWord = guessWord.toLowerCase();
            guessWordAry = guessWord.toCharArray();
            hasGuessed = true;
            if (guessWord.equals(givenWord)){
                playerPanel.setMsg("good your guess is right!");
                totalScore += Consts.SCORE + wordLen * 2 + missNum * 2;
                playerPanel.setScoreTxt("" + totalScore);
            } else {
                playerPanel.setMsg("soory your guess is error");
                totalScore -= Consts.SCORE;
                playerPanel.setScoreTxt("" + totalScore);
            }
            repaint();
        }catch (StringIndexOutOfBoundsException se){
            playerPanel.setMsg("you did not enter a word");
            totalScore -= Consts.SCORE;
            playerPanel.setScoreTxt("" + totalScore);
        }catch (NullPointerException e){
            playerPanel.setMsg("your clicked cancel,game is termainate");
            System.exit(0);
        }
    }

    public int getWordLen(){
        return currAry.length;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        bx = (int)(Consts.CV_WIDTH / 2) - (int) ((wordLen * 1.0 / 2) * Consts.CHAR_BLOCK_W);
        g2d.setColor(Color.RED);
        g2d.drawRect(0,0,Consts.CV_WIDTH,Consts.BOARD_H);

        Stroke solid = new BasicStroke(5.0f);
        g2d.setStroke(solid);

        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Times",Font.BOLD,30));

        if(initPaint){
            paintEmpty(g2d);
            initPaint = false;
        }else{
            paintWord(g2d);
            if(hasGuessed){
                paintGuessWord(g2d);
            }
        }
    }



    public void paintEmpty(Graphics2D g2d) {
        by = Consts.BLOCK_Y;
        for (int i = 0; i < wordLen; i++) {
            g2d.drawRect(bx + i * Consts.CHAR_BLOCK_W, by, Consts.CHAR_BLOCK_W, Consts.CHAR_BLOCK_H);
        }

            by = Consts.BLOCK_Y + 2 * Consts.CHAR_BLOCK_H;
        for (int i = 0;i < wordLen; i++) {
            g2d.drawRect(bx + i * Consts.CHAR_BLOCK_W,by,Consts.CHAR_BLOCK_W,Consts.CHAR_BLOCK_H);
        }

    }

    public void paintWord(Graphics2D g2d) {
        paintEmpty(g2d);
        sx = bx + 8;
        sy = Consts.BLOCK_Y;
        for (int k = 0; k < wordLen; k++) {
            if(scranbledWord[k] != ' '){
                g2d.drawString(Character.toString(scranbledWord[k]), sx + k * Consts.CHAR_BLOCK_W, sy + (int) (Consts.CHAR_BLOCK_H * 0.8));
            }
        }
    }

    public void paintGuessWord(Graphics2D g2d) {
        sx = bx + 8;
        sy = Consts.BLOCK_Y + 2 * Consts.CHAR_BLOCK_H;
        try {
            for (int i = 0; i < wordLen; i++) {
                if(guessWordAry[i] != ' '){
                    g2d.drawString(Character.toString(guessWordAry[i]), sx + i * Consts.CHAR_BLOCK_W, sy + (int)(Consts.CHAR_BLOCK_H * 0.8));
                }
            }
        }catch (ArrayIndexOutOfBoundsException ex){

        }
    }

    public void setReadFile(ReadFile readFile){
        this.readFile = readFile;
    }

    public void setPlayerPanel(PlayerPanel playerPanel){
        this.playerPanel = playerPanel;
    }

    public void setInitPaint(boolean b) {
        this.initPaint = b;
    }
}
