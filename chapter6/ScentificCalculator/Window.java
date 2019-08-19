package ScentificCalculator;

import calculator.Calculator;

import javax.swing.*;

public class Window extends JFrame {
    private CalculatorFace calculator;

    public Window() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(360,420);
        setTitle("scentific calculator");
        calculator = new CalculatorFace();
        add(calculator);
        setVisible(true);

    }
}

