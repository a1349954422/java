<<<<<<< HEAD
package XmasCard.code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ReadImage {
    private BufferedImage img;

    public ReadImage() {
        try{
            img = ImageIO.read(getClass().getResource("../image/test.jpg"));
        }
        catch (IOException ex){
        }
    }
    public BufferedImage getImg(){
        return img;
    }
}
=======
package XmasCard.code;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ReadImage {
    private BufferedImage img;

    public ReadImage() {
        try{
            img = ImageIO.read(getClass().getResource("../image/test.jpg"));
        }
        catch (IOException ex){
        }
    }
    public BufferedImage getImg(){
        return img;
    }
}
>>>>>>> a8e2260ae201f56374a52d89ce889908316dfb5b
