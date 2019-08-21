package imageBrowse.code;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("browse image");
        setSize(500,400);
        SliderPanel sp = new SliderPanel();
        add(sp);
        setVisible(true);
    }
}
