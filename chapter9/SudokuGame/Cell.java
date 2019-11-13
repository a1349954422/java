package chapter9.SudokuGame;

import java.awt.*;

public class Cell {
    private int x, y;
    private int width;
    private int height;
    private Color color;
    private int dight;
    private int guessed;
    private boolean guessCorrect;
    private boolean visable;

    public Cell(){
        width = Consts.CELL_W;
        height = Consts.CELL_H;
        color = Color.BLUE;
        dight = 0;
        visable = true;
        guessCorrect = false;
    }

    public void paintCell(Graphics2D g2d){
        g2d.setColor(color);
        g2d.drawRect(x, y, width, height);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, 22));
        if(visable){
            g2d.drawString("" + dight, x + Consts.CELL_LEFT, y + Consts.CELL_TOP);
        }else {
            g2d.setColor(Color.YELLOW);
            g2d.fillRect(x + 2, y + 2, width - 2, height - 2);
            if(guessed != 0){
                if(!guessCorrect){
                    g2d.setColor(Color.RED);
                }else {
                    g2d.setColor(Color.GREEN);
                }
                g2d.drawString("" + guessed, x + Consts.CELL_LEFT, y + Consts.CELL_TOP);
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDight() {
        return dight;
    }

    public void setDight(int dight) {
        this.dight = dight;
    }

    public boolean isVisable() {
        return visable;
    }

    public void setVisable(boolean visable) {
        this.visable = visable;
    }

    public int getGuessed() {
        return guessed;
    }

    public void setGuessed(int guessed) {
        this.guessed = guessed;
    }

    public void setGuessCorrect(boolean guessCorrect) {
        this.guessCorrect = guessCorrect;
    }
}
