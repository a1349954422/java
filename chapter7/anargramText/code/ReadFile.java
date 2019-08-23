package chapter7.anargramText.code;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ReadFile {
    FileReader fileReader;
    String fileName;
    String filePath;

    public ReadFile() {
    }

    public void selectFile(){
        Object[] selectionsValue = {"wordaj.txt","wordbz.txt"};
        Object selection = JOptionPane.showInputDialog(null,"select a file to start","select file",JOptionPane.QUESTION_MESSAGE,null,selectionsValue,selectionsValue[0]);
        filePath = "../file/" + selection;

        try {
            URL url = getClass().getResource(filePath);
            fileName = url.getPath();
            fileReader = new FileReader(fileName);
        }catch (NullPointerException noex){
            System.out.println("you click cancel");
            System.out.println("the game is aborted by the user");
            System.exit(0);
        }
        catch (FileNotFoundException e) {
            System.out.println("the file is not found");
            System.exit(0);
        }
    }

    public String readWord(){
        String aWord = null;
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int numLines = 4;
        int count;
        int lineNum;

        lineNum = (int)(Math.random() * numLines);
        try{
            count = 0;
            while((aWord = bufferedReader.readLine()) != null){
                if(count == lineNum){
                    break;
                }
                count++;
            }
            bufferedReader.close();
        } catch (IOException e) {
        }
        return aWord;
    }
}
