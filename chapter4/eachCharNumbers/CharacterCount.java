package eachCharNumbers;

import javax.swing.*;

public class CharacterCount {
    int[] count = new int[26];


    public CharacterCount() {
        String input = JOptionPane.showInputDialog("Please input a string:");//输入一个字符串统计各字符的数量
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        charCount(input);
    }

    private void charCount(String input) {
        char[] ch = input.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            count[ch[i] - 97]++;
        }
        printCount(count);
    }

    private void printCount(int[] count) {
        for (int i = 0; i < count.length; i++) {
            System.out.println((char)(i + 97) + " " + count[i]);
        }
    }
}
