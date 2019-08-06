package Source.code;

import javax.swing.*;
import java.io.*;
import java.net.URL;

public class EchoFile {
    FileReader inputFile;
    String fileName;
    String filePath;

    public EchoFile() {
        Object[] selectionsValues = {"txt1.txt","txt2.txt","txt3.txt"};
        String initValues = "";
        Object selection = JOptionPane.showInputDialog(null,"Select a file you want to open", "SELECT A TXT",JOptionPane.QUESTION_MESSAGE,null,selectionsValues,selectionsValues[0]);
        filePath = "../TXT/" + selection;
        URL url = getClass().getResource(filePath);
        fileName = url.getPath();
        try{
            inputFile = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        readContent();
    }

    private void readContent() {
        BufferedReader bf = new BufferedReader(inputFile);
        String line = null;
        try{
            while(null != (line = bf.readLine())){
                System.out.println(line);
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
