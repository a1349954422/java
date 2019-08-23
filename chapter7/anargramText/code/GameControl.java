package chapter7.anargramText.code;

import javax.swing.*;

public class GameControl {
    private Player player;
    private Initialization initialization;
    private String initWord;
    private String guessWord;
    private char[] chars;
    private char[] scrembleChar;

    public GameControl() {
        initGame();
    }

    private void initGame() {
        initBoard();
        initPlayer();
        compareWord(initWord,guessWord);
        moreGuess();
    }

    private void moreGuess() {
        Object[] choiceValues = {"yes","no"};
        Object choice = JOptionPane.showInputDialog(null,"Do you want continue games?","choice",JOptionPane.QUESTION_MESSAGE,null,choiceValues,choiceValues[0]);
        try{
            if(choice.equals("yes")){
                initGame();
            }else {
                System.out.println("game over!");
            }
        }catch (NullPointerException e){
            System.out.println("you click cancel");
            System.out.println("game terminal！");
            System.exit(0);
        }
    }

    private void initBoard() {
        initialization = new Initialization();
        initWord = initialization.readWord();
        chars = initWord.toCharArray();
        scrembleChar = initialization.scrembleWord(chars);
        initialization.printArray(scrembleChar);
    }

    private void initPlayer() {
        player = new Player();
        guessWord = player.getGuessWord();
    }

    private void compareWord(String initWord, String guessWord) {
        if(initWord.equals(guessWord)){
            System.out.println("congratulation！your guess is current！ths answer is" + initWord);
        }else{
            System.out.println("sorry,your guess is error! the answer is " + initWord);
        }
    }
}
