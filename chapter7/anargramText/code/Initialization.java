package chapter7.anargramText.code;

import java.util.Random;

public class Initialization {
    private ReadFile readFile;

    public Initialization() {
    }

    public String readWord(){
        String giveWord;
        readFile = new ReadFile();
        readFile.selectFile();
        giveWord = readFile.readWord();
        return  giveWord;
    }

    public char[] scrembleWord(char[] charArray){
        Random random = new Random();
        int num = charArray.length;
        random.nextInt();
        for (int i = 0; i < num; i++) {
            int index = i + random.nextInt(num - i);
            swap(charArray,i,index);
        }
        return charArray;
    }

    private void swap(char[] charArray, int i, int index) {
        char temp = charArray[i];
        charArray[i] = charArray[index];
        charArray[index] = temp;
    }

    public  void printArray(char[] charArray){
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }
        System.out.println();
    }
}
