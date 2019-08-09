package XmasCard.code;
import javax.swing.*;
import java.io.*;
import java.net.URL;
public class ReadTxt {
    private FileReader inputfile;
    private String filePath;
    private String fileName;

    public ReadTxt() {
    }

    public void selectFlie() {
        Object[] selectionsValues = {"XmasCard.txt","XmasCard2.txt"};
        String selectionValues = "";
        Object selection = JOptionPane.showInputDialog(null,"please select a file","'select file", JOptionPane.QUESTION_MESSAGE,null,selectionsValues,selectionsValues[0]);
        filePath = "../TXT/" + selection;
        URL url = getClass().getResource(filePath);
        fileName = url.getPath();
        try {
            inputfile = new FileReader(fileName);
        }catch(FileNotFoundException ex){
        }
    }

    public String readFile(){
        String line = null;
        BufferedReader bufferedReader = new BufferedReader(inputfile);
        try{
            line = bufferedReader.readLine();
            bufferedReader.close();
        }catch(IOException ioex){
        }
        return line;
    }
}
