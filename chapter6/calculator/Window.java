package calculator;

import javax.swing.*;

public class Window extends JFrame {
     private Calculator calculator;

    public Window() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,320);
        setTitle("calculator");
        calculator = new Calculator();
        add(calculator);
        setVisible(true);

    }
}
