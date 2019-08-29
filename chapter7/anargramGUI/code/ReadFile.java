package chapter7.anargramGUI.code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ReadFile {
    private URL url;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String filePath;
    private String fileName;
    private int numLines;

    public ReadFile() {
    }

    public void selectFile(String selection){
        filePath = "../file/" + selection;
        try{
            url = getClass().getResource(filePath);
            fileName = url.getPath();
            fileReader = new FileReader(fileName);
            numLines = countLines();
        }
        catch (NullPointerException ex){
            System.out.println("game is aborted by user");
            System.exit(0);
        }catch (FileNotFoundException e) {
            System.out.println("THE FILE IS NOT FOUND");
            System.exit(0);
        }
    }

    public int countLines() {
        bufferedReader = new BufferedReader(fileReader);
        int num = 0;
        try{
            while((bufferedReader.readLine()) != null){
                    num++;
            }
            bufferedReader.close();;
            fileReader.close();
        } catch (IOException e) {
        }
        return num;
    }

    public String readContent(){
        String word = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
        }

        int lineNum;
        int count;

        lineNum = (int)(Math.random() * numLines);
        try {
            count = 0;
            while ((word = bufferedReader.readLine()) != null){
                if(count == lineNum){
                    break;
                }
                count++;
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
        }
        return word;
    }
}
