package imageBrowse.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class SliderPanel extends JPanel implements ActionListener {
    private ImageStore imageStore;
    private ShowBoard showBoard;
    private JButton leftBtn;
    private JButton rightBtn;

    public SliderPanel() {
        initComponent();
    }

    private void initComponent() {
        setLayout(new BorderLayout());
        initImage();
        initBoard();
        initButton();
    }
    private void initImage() {
        imageStore = new ImageStore();
    }

    private void initBoard() {
        showBoard = new ShowBoard();
        showBoard.setImageStore(imageStore);
        showBoard.initImage();
        showBoard.findImage();
        add(showBoard,BorderLayout.CENTER);
    }

    private void initButton() {
        leftBtn = new JButton();
        leftBtn.setPreferredSize(new Dimension(50,(int)(50 * 1.5)));
        BufferedImage leftArrow = zoomImage(imageStore.getLeftArrow());
        leftBtn.setIcon(new ImageIcon(leftArrow));
        leftBtn.setBorder(null);
        add(leftBtn,BorderLayout.WEST);
        leftBtn.addActionListener(this);

        rightBtn = new JButton();
        rightBtn.setPreferredSize(new Dimension(50,(int)(50 * 1.5)));
        BufferedImage rightArrow = zoomImage(imageStore.getRightArrow());
        rightBtn.setIcon(new ImageIcon(rightArrow));
        rightBtn.setBorder(null);
        add(rightBtn,BorderLayout.EAST);
        rightBtn.addActionListener(this);
    }

    private BufferedImage zoomImage(Image arrow) {
        BufferedImage bufferedArrow = (BufferedImage) arrow;
        BufferedImage newArrow;

        double ratio = (50 * 1.0) / bufferedArrow.getWidth();
        int newW = (int)(bufferedArrow.getWidth() * ratio);
        int newH = (int)(bufferedArrow.getHeight() * ratio);
        newArrow = new BufferedImage(newW,newH,BufferedImage.TYPE_INT_ARGB);
        Graphics g = newArrow.createGraphics();
        g.drawImage(arrow,0,0,newW,newH,null);
        g.dispose();
        return newArrow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int listSize = imageStore.getScenyListImageList().size();
        if(e.getSource() == rightBtn){
            int newIndex = showBoard.getIndex() - 1;
            if(newIndex == -1){
                newIndex = listSize - 1;
            }
            showBoard.setIndex(newIndex % listSize);
            showBoard.findImage();
            showBoard.repaint();
        }else if(e.getSource() == leftBtn){
            showBoard.setIndex((showBoard.getIndex() + 1) % listSize);
            showBoard.findImage();
            showBoard.repaint();
        }

    }
}
