package ScentificCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFace extends JPanel implements ActionListener {
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
    private JButton bSqrt = new JButton("√");
    private JButton bPow = new JButton("^");
    private JButton bLog = new JButton("log");
    private JButton bMode = new JButton("%");
    private JButton bReset = new JButton("RESET");
    private JTextField disOperated1;
    private JTextField disOperated2;
    private JTextField disLine;
    private JTextField disResult;
    private boolean getOp ;
    private boolean getOpe1;
    private boolean getOpe2;
    private boolean getEqual;
    private boolean getSqrt;
    private String op ;
    private String ope1;
    private String ope2;

    public CalculatorFace() {
        initCalculator();
        addAction();
        initReset();

    }


    private void initCalculator() {
        JPanel ub = new JPanel();
        JPanel pp = new JPanel();
        pp.setLayout(new GridLayout(5, 3, 5, 5));
        bSqrt.setPreferredSize(new Dimension(70,50));
        pp.add(bSqrt);
        bPow.setPreferredSize(new Dimension(70,50));
        pp.add(bPow);
        bLog.setPreferredSize(new Dimension(70,50));
        pp.add(bLog);
        bSeven.setPreferredSize(new Dimension(70, 50));
        pp.add(bSeven);
        bEight.setPreferredSize(new Dimension(70, 50));
        pp.add(bEight);
        bNine.setPreferredSize(new Dimension(70, 50));
        pp.add(bNine);
        bFour.setPreferredSize(new Dimension(70, 50));
        pp.add(bFour);
        bFive.setPreferredSize(new Dimension(70, 50));
        pp.add(bFive);
        bSix.setPreferredSize(new Dimension(70, 50));
        pp.add(bSix);
        bOne.setPreferredSize(new Dimension(70, 50));
        pp.add(bOne);
        bTwo.setPreferredSize(new Dimension(70, 50));
        pp.add(bTwo);
        bThree.setPreferredSize(new Dimension(70, 50));
        pp.add(bThree);
        bZero.setPreferredSize(new Dimension(70, 50));
        pp.add(bZero);
        bDot.setPreferredSize(new Dimension(70, 50));
        pp.add(bDot);
        bEqual.setPreferredSize(new Dimension(70, 50));
        pp.add(bEqual);
        ub.add(pp);

        JPanel cp = new JPanel();
        cp.setLayout(new GridLayout(5, 1, 5, 5));
        bMode.setPreferredSize(new Dimension(70,50));
        cp.add(bMode);
        bAdd.setPreferredSize(new Dimension(70, 50));
        cp.add(bAdd);
        bSub.setPreferredSize(new Dimension(70, 50));
        cp.add(bSub);
        bMul.setPreferredSize(new Dimension(70, 50));
        cp.add(bMul);
        bDiv.setPreferredSize(new Dimension(70, 50));
        cp.add(bDiv);
        ub.add(cp);

        disOperated1 = new JTextField(20);
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



    private void initReset() {
        getOpe1 = true;
        getOp = false;
        getOpe2 = false;
        getEqual = false;
        getSqrt = false;
        ope1 = "";
        ope2 = "";
        op = "";
        disOperated1.setText("");
        disOperated2.setText("");
        disResult.setText("");
    }

    public void addAction() {
        bZero.addActionListener(this);
        bOne.addActionListener(this);
        bTwo.addActionListener(this);
        bThree.addActionListener(this);
        bFour.addActionListener(this);
        bFive.addActionListener(this);
        bSix.addActionListener(this);
        bSeven.addActionListener(this);
        bEight.addActionListener(this);
        bNine.addActionListener(this);
        bDot.addActionListener(this);
        bAdd.addActionListener(this);
        bSub.addActionListener(this);
        bMul.addActionListener(this);
        bDiv.addActionListener(this);
        bMode.addActionListener(this);
        bSqrt.addActionListener(this);
        bLog.addActionListener(this);
        bPow.addActionListener(this);
        bEqual.addActionListener(this);
        bReset.addActionListener(this);
    }


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
        }else if(obj.equals(bSqrt)){
            assignOp("√");
        }else if(obj.equals(bPow)){
            assignOp("^");
        }else if(obj.equals(bLog)){
            assignOp("log");
        }else if(obj.equals(bMode)){
            assignOp("%");
        }

        if (getOpe1 && !getOpe2) {
            if(!getEqual && !getSqrt){
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
            if(!(ope1.equals("")) && op.equals("√")){
                getEqual = true;
                Double oep1Value = Double.parseDouble(ope1);
                doSqrt(oep1Value);
            }
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
                }else if(op.equals("%")){
                    doMode(ope1Value,ope2Value);
                }else if(op.equals("^")){
                    doPow(ope1Value,ope2Value);
                }else if(op.equals("log")){
                    doLog(ope1Value,ope2Value);
                }
            }
        }else if(obj.equals(bReset)){
            initReset();
        }

    }

    private void doLog(Double ope1Value, Double ope2Value) {
        Double sum = Math.log(ope2Value)/ Math.log(ope1Value);
        disResult.setText(String.valueOf(sum));
    }

    private void doPow(Double ope1Value, Double ope2Value) {
        Double sum = Math.pow(ope1Value,ope2Value);
        disResult.setText(String.valueOf(sum));
    }

    private void doMode(Double ope1Value, Double ope2Value) {
        int q = (int)(ope1Value / ope2Value);
        Double sum =  ope1Value - q * ope2Value ;
        disResult.setText(String.valueOf(sum));
    }

    private void doSqrt(Double ope1Value) {
        Double sum = Math.sqrt(ope1Value);
        disResult.setText(String.valueOf(sum));
    }


    private void doDiv(Double ope1Value, Double ope2Value) {
        if(ope2Value == 0){
            disResult.setText("error!");
        }else {
            Double sum = ope1Value / ope1Value;
            disResult.setText(String.valueOf(sum));
        }
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


    private void assignOp(String s) {
        if(!ope1.equals("")) {
            op = s;
            if(op.equals("√")){
                getSqrt = true;
                getOpe2 = false;
                getOpe1 = false;
                getOp = false;
            }
            getOpe1 = false;
            getSqrt = false;
            getOp = true;
            getOpe2 = true;
        }
    }

}

