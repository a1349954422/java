package chapter7.anargramText.code;

import javax.swing.*;

public class Player {
    private String guessWord = "";
    boolean nextInput = false;
    char inputChar;

    public Player() {
    }

    public String getGuessWord() {
        while (!nextInput) {
            guessWord = JOptionPane.showInputDialog("please input your guess word");
            try {
                inputChar = guessWord.charAt(0);
                nextInput = true;
            } catch (StringIndexOutOfBoundsException sex) {
                System.out.println("your answer is empty");
            } catch (NullPointerException ex) {
                System.out.println("you click cancel,the game is aborted");
                System.exit(0);
            }
        }
        return guessWord;
    }
}
