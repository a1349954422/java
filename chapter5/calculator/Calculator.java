package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JPanel {
    private JPanel topPortion;
    private JButton bZero = new JButton("0");
    private JButton bOne = new JButton("1");
    private JButton bTwo = new JButton("2");
    private JButton bThree = new JButton("3");
    private JButton bFour = new JButton("4");
    private JButton bFive = new JButton("5");
    private JButton bSix = new JButton("6");
    private JButton bSeven = new JButton("7");
    private JButton bEight = new JButton("8");
    private JButton bNine = new JButton("9");
    private JButton bDot = new JButton(".");
    private JButton bEqual = new JButton("=");
    private JButton bAdd = new JButton("+");
    private JButton bSub = new JButton("-");
    private JButton bMul = new JButton("*");
    private JButton bDiv = new JButton("/");
    private JButton bReset = new JButton("RESET");
    private JTextField disOperated1;
    private JTextField disOperated2;
    private JTextField disLine;
    private JTextField disResult;
    private boolean getOp = false;
    private boolean getOpe1 = true;
    private boolean getOpe2 = false;
    private boolean getEqual = false;
    private String op = "";
    private String ope1 = "";
    private String ope2 = "";

    public Calculator() {
        initCalculator();
    }

    private void initCalculator() {
        JPanel ub = new JPanel();
        JPanel pp = new JPanel();
        pp.setLayout(new GridLayout(4, 3, 5, 5));
        bSeven.setPreferredSize(new Dimension(50, 40));
        pp.add(bSeven);
        bEight.setPreferredSize(new Dimension(50, 40));
        pp.add(bEight);
        bNine.setPreferredSize(new Dimension(50, 40));
        pp.add(bNine);
        bFour.setPreferredSize(new Dimension(50, 40));
        pp.add(bFour);
        bFive.setPreferredSize(new Dimension(50, 40));
        pp.add(bFive);
        bSix.setPreferredSize(new Dimension(50, 40));
        pp.add(bSix);
        bOne.setPreferredSize(new Dimension(50, 40));
        pp.add(bOne);
        bTwo.setPreferredSize(new Dimension(50, 40));
        pp.add(bTwo);
        bThree.setPreferredSize(new Dimension(50, 40));
        pp.add(bThree);
        bZero.setPreferredSize(new Dimension(50, 40));
        pp.add(bZero);
        bDot.setPreferredSize(new Dimension(50, 40));
        pp.add(bDot);
        bEqual.setPreferredSize(new Dimension(50, 40));
        pp.add(bEqual);
        ub.add(pp);

        JPanel cp = new JPanel();
        cp.setLayout(new GridLayout(4, 1, 5, 5));
        bAdd.setPreferredSize(new Dimension(50, 40));
        cp.add(bAdd);
        bSub.setPreferredSize(new Dimension(50, 40));
        cp.add(bSub);
        bMul.setPreferredSize(new Dimension(50, 40));
        cp.add(bMul);
        bDiv.setPreferredSize(new Dimension(50, 40));
        cp.add(bDiv);
        ub.add(cp);

        disOperated1 = new JTextField(40);
        disOperated1.setHorizontalAlignment(JTextField.RIGHT);
        disOperated1.setBorder(null);
        disOperated2 = new JTextField();
        disOperated2.setHorizontalAlignment(JTextField.RIGHT);
        disOperated2.setBorder(null);
        disLine = new JTextField("-------------------------------------------------------------------");
        disLine.setHorizontalAlignment(JTextField.RIGHT);
        disLine.setBorder(null);
        disResult = new JTextField();
        disResult.setHorizontalAlignment(JTextField.RIGHT);
        disResult.setBorder(null);
        topPortion = new JPanel();
        topPortion.setLayout(new GridLayout(4, 1));
        topPortion.add(disOperated1);
        topPortion.add(disOperated2);
        topPortion.add(disLine);
        topPortion.add(disResult);

        this.setLayout(new BorderLayout());
        this.add(topPortion, BorderLayout.NORTH);
        this.add(ub, BorderLayout.CENTER);
        this.add(bReset, BorderLayout.SOUTH);
    }

    private void addEventListerner() {
        bZero.addActionListener(new DigitActionListener());
        bOne.addActionListener(new DigitActionListener());
        bTwo.addActionListener(new DigitActionListener());
        bThree.addActionListener(new DigitActionListener());
        bFour.addActionListener(new DigitActionListener());
        bFive.addActionListener(new DigitActionListener());
        bSix.addActionListener(new DigitActionListener());
        bSeven.addActionListener(new DigitActionListener());
        bEight.addActionListener(new DigitActionListener());
        bNine.addActionListener(new DigitActionListener());
        bDot.addActionListener(new DigitActionListener());
        bAdd.addActionListener(new DigitActionListener());
        bSub.addActionListener(new DigitActionListener());
        bMul.addActionListener(new DigitActionListener());
        bDiv.addActionListener(new DigitActionListener());
        bEqual.addActionListener(new DigitActionListener());
        bReset.addActionListener(new DigitActionListener());
    }

    class DigitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String aLetter = " ";
            Object obj = (Object) e.getSource();
            if (obj.equals(bZero)) {
                aLetter = "0";
                getOp = false;
            } else if (obj.equals(bOne)) {
                aLetter = "1";
                getOp = false;
            } else if (obj.equals(bTwo)) {
                aLetter = "2";
                getOp = false;
            } else if (obj.equals(bThree)) {
                aLetter = "3";
                getOp = false;
            } else if (obj.equals(bFour)) {
                aLetter = "4";
                getOp = false;
            } else if (obj.equals(bFive)) {
                aLetter = "5";
                getOp = false;
            } else if (obj.equals(bSix)) {
                aLetter = "6";
                getOp = false;
            } else if (obj.equals(bSeven)) {
                aLetter = "7";
                getOp = false;
            } else if (obj.equals(bEight)) {
                aLetter = "8";
                getOp = false;
            } else if (obj.equals(bNine)) {
                aLetter = "9";
                getOp = false;
            } else if (obj.equals(bDot)) {
                aLetter = ".";
                getOp = false;
            } else if (obj.equals(bAdd)) {
                assignOp("+");
            } else if (obj.equals(bSub)) {
                assignOp("-");
            } else if (obj.equals(bMul)) {
                assignOp("*");
            } else if (obj.equals(bDiv)) {
                assignOp("/");
            }

            if (getOpe1 && !getOpe2) {
                if(!getEqual){
                    ope1 = ope1 + aLetter;
                }
                disOperated1.setText(ope1);

            }else if(!getOpe1 && getOpe2) {
                if(!getEqual && !getOp){
                    ope2 = ope2 + aLetter;
                }
                disOperated2.setText(op + "   " + ope2);
            }
            if(obj.equals(bEqual)){
                if(!(ope1.equals("")) && !(ope2.equals("")) && !(op).equals("")){
                    getEqual = true;
                    Double ope1Value = Double.parseDouble(ope1);
                    Double ope2Value = Double.parseDouble(ope2);
                    if(op.equals("+")){
                        doAdd(ope1Value,ope2Value);
                    }else if(op.equals("-")){
                        doSub(ope1Value,ope2Value);
                    }
                    else if(op.equals("*")){
                        doMul(ope1Value,ope2Value);
                    }else if(op.equals("/")){
                        doDiv(ope1Value,ope2Value);
                    }
                }
            }else if(obj.equals(bReset)){
                initReset();
            }

        }

        private void initReset() {
            getOpe1 = true;
            getOp = false;
            getOpe2 = false;
            getEqual = false;
        }

        private void doDiv(Double ope1Value, Double ope2Value) {
            if(ope2Value == 0){
                disResult.setText("error!");
            }
            Double sum = ope1Value / ope1Value;
            disResult.setText(String.valueOf(sum));
        }

        private void doMul(Double ope1Value, Double ope2Value) {
            Double sum = ope1Value * ope2Value;
            disResult.setText(String.valueOf(sum));
        }

        private void doSub(Double ope1Value, Double ope2Value) {
            Double sum = ope1Value - ope2Value;
            disResult.setText(String.valueOf(sum));
        }

        private void doAdd(Double ope1Value, Double ope2Value) {
            Double sum = ope1Value + ope2Value;
            disResult.setText(String.valueOf(sum));
        }


        public void assignOp(String s) {
            op = s;
            getOpe1 =
        }
    }
}
