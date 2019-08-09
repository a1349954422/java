package XmasCard.code;


import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

public class XmasCard extends JPanel {
        private String recName;
        private String merryXmas;
        private String signature;
        ReadTxt readTxt;
        private int x, y;

        public XmasCard() {
            inputRecName();
            inputMerryXms();
            inputSignature();
            repaint();
        }

        private void inputRecName() {//读取收件人姓名
        recName = JOptionPane.showInputDialog("Enter recipient's name: ");
        }

        private void inputMerryXms() { //读取祝福语
            readTxt  = new ReadTxt();
            readTxt.selectFlie();
            merryXmas = readTxt.readFile();
        }

         private void inputSignature() {//读取发件人姓名
            signature = JOptionPane.showInputDialog("Enter sender's name: ");
         }

         public void paint(Graphics g){//输出
            g.setColor(Color.RED);
            paintRecname(g);
            paintMerryXmas(g);
            paintSignature(g);
            
         }

         private void paintRecname(Graphics g) {//将收件人姓名输出
            g.setFont(new Font("Time",Font.BOLD,24));
            FontMetrics fm = g.getFontMetrics();
            int charHeight = fm.getAscent();
            y = Consts.miny_dis + charHeight;
            g.drawString(recName,Consts.minx_dis,y);
         }

         private void paintMerryXmas(Graphics g) {//将祝福语输出
             g.setFont(new Font("Algerian",Font.BOLD,30));
             int displaySize = Consts.maxx_dis - Consts.minx_dis;
             FontMetrics fm = g.getFontMetrics();
             int charHeight = fm.getAscent();

             StringTokenizer s = new StringTokenizer(merryXmas, " ");
             String subString = "";
             y = y + charHeight;
             while(s.hasMoreTokens()) {
                 String nextT = s.nextToken();
                 int substrN = fm.stringWidth(subString) + fm.stringWidth(nextT);
                 if (substrN <= displaySize) {
                     subString = subString + nextT + " ";
                 } else {
                     y = y + Consts.miny_dis;
                     g.drawString(subString, Consts.minx_dis, y);
                     subString = nextT + " ";
                 }
             }
                 if(!subString.equals(" ")){
                     y = y + Consts.miny_dis;
                     g.drawString(subString, Consts.minx_dis, y);

                 }
         }



         private void paintSignature(Graphics g) {//将发件人姓名输出
            g.setFont(new Font("Time",Font.BOLD,24));
            FontMetrics fm = g.getFontMetrics();
            int charHeight = fm.getAscent();
            int x = Consts.maxx_dis - fm.stringWidth(signature);
            y = y  + charHeight;
            g.drawString(signature, x, y);
          }

}
