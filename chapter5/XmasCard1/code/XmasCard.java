package XmasCard.code;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.StringTokenizer;

public class XmasCard extends JPanel {
        private String recName;
        private String merryXmas;
        private String signature;
        private ReadTxt readTxt;
        private ReadImage readImage;
        private int x, y;
        private int left_maxX;

        public XmasCard() {
            left_maxX = Consts.maxx / 2 - Consts.MARGIN;
            inputRecName();
            inputMerryXms();
            inputSignature();
            imputImage();
            repaint();
        }

        private void imputImage() {
            readImage = new ReadImage();
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
            paintImg(g);
            
         }



        private void paintRecname(Graphics g) {//将收件人姓名输出
            g.setFont(new Font("Time",Font.BOLD,12));
            FontMetrics fm = g.getFontMetrics();
            int charHeight = fm.getAscent();
            y = Consts.miny_dis + charHeight;
            g.drawString(recName,Consts.minx_dis,y);
         }

         private void paintMerryXmas(Graphics g) {//将祝福语输出
             g.setFont(new Font("Algerian",Font.BOLD,15));
             int displaySize = left_maxX - Consts.minx_dis;
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
            g.setFont(new Font("Time",Font.BOLD,12));
            FontMetrics fm = g.getFontMetrics();
            int charHeight = fm.getAscent();
            int x = left_maxX - fm.stringWidth(signature);
            y = y  + charHeight + Consts.MARGIN;
            g.drawString(signature, x, y);
          }

          private void paintImg(Graphics g) {
              BufferedImage img = readImage.getImg();
              int ingMinX = Consts.maxx / 2 + Consts.MARGIN;
              int imgMinY = Consts.miny_dis;
              int ingMaxX = Consts.maxx - Consts.MARGIN;
              int imgMaxY = Consts.maxy_dis;
              int imgW = ingMaxX - ingMinX;
              int imgH = imgMaxY - imgMinY;
              g.drawImage(img,ingMinX,imgMinY,imgW,imgH,null);
          }
}
