<<<<<<< HEAD
package XmasCard.code;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class TestGuiBasis extends JFrame {//
    private XmasCard xmasCard;

    public TestGuiBasis()  {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("congratulation card");
        setSize(Consts.maxx,Consts.maxy);
        xmasCard = new XmasCard();
        add(xmasCard);

        setVisible(true);
    }
}
=======
package XmasCard.code;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class TestGuiBasis extends JFrame {//
    private XmasCard xmasCard;

    public TestGuiBasis()  {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("congratulation card");
        setSize(Consts.maxx,Consts.maxy);
        xmasCard = new XmasCard();
        add(xmasCard);

        setVisible(true);
    }
}
>>>>>>> a8e2260ae201f56374a52d89ce889908316dfb5b
