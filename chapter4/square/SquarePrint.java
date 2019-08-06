package square;

import javax.swing.*;

public class SquarePrint {//用" - "和" | "打印矩形
    private int length;
    private  int j ;

    public SquarePrint() {
        inputLength();
    }

    public SquarePrint(int length) {
        this.length = length;
    }
    private void inputLength() {
            String input = JOptionPane.showInputDialog("enter square's length");
            input = inputSearch(input);
            length = Integer.parseInt(input);
            printGraph(length);

    }

    private String inputSearch(String input) {
        char[] ch = input.toCharArray();
        for(char i: ch){
            int t = i;
            if(t < 48 || t > 57){
                input = JOptionPane.showInputDialog("error input,please try again");
                inputSearch(input);
                break;
            }
        }
        return input;
    }

    private void printGraph(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
            if(i == length - 1){
                System.out.println();
            }
        }
       for (int i = 0; i < length; i++) {
            System.out.print("|");
            j = 1;
            while(j < length - 1){
                System.out.print(" ");
                j++;
            }
            System.out.println("|");
        }
        for (int i = 0; i < length; i++) {
            System.out.print("-");
            if(i == length - 1){
                System.out.println();
            }
        }
    }


}
