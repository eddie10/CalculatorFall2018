package assignment2aalemayehu1;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*
Calculator
Author: Ahadu Alemayehu
Last Revision: 9/5/18

*/
public class Calculator {

    public static int global;
    public static double resultd;
    public static int beforeOpDot;
    public static int afterOpDot;
    public static int dotcount;
    public static int debo;
    public static boolean ifdotispressedbeforeop;
    public static boolean ifdotispressedafterop;
    public static double fOp;
    public static double NOp;
    public static double d1;
    public static double d2;
    public static int dott;
    public static double percent;
    public static int firstOperand;
    public static int nextOperand;
    public static int result;
    public static char operator;
    public static JFrame frame1;
    public static JPanel panel1;
    public static JTextField text1;
    public static JButton Num0;
    public static JButton Num1;
    public static JButton Num2;
    public static JButton Num3;
    public static JButton Num4;
    public static JButton Num5;
    public static JButton Num6;
    public static JButton Num7;
    public static JButton Num8;
    public static JButton Num9;
    public static JPanel panel2;
    public static JPanel panel3;
    public static JButton mult;
    public static JButton sub;
    public static JButton add;
    public static JButton sqrt;
    public static JButton sq;
    public static JButton dot;
    public static JButton perc;
    public static JButton div;
    public static JButton clr;
    public static JButton eq;
    public static JButton plusmin;
    public static int Number;
    public static Stack stack1;
    public static int crax;
    public static int count;
    public static int debos;
    static int[] arr = new int[3];
    public static boolean minus;
    public static boolean plus;
    public static int g, gg;

    public static void main(String[] args) {

        frame1 = new JFrame("Calculator");
        panel1 = new JPanel();
        text1 = new JTextField(20);
        frame1.setSize(400, 400);
        count = 1;
        Center();
        frame1.setLayout(new BorderLayout());
        panel1.add(text1);
        frame1.add(panel1, BorderLayout.NORTH);
        //stack1 = new Stack();
        firstOperand = 0;
        nextOperand = 0;
        result = 0;
        operator = ' ';
        dott = 0;
        g = 1;
        gg = 1;
        beforeOpDot = 0;
        afterOpDot = 0;
        debo = 1;
        debos = 0;
        minus = true;
        plus = false;
        CalcButs();
        logic();
        frame1.show(true);
        frame1.isVisible();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void Center() {

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screen.getWidth() - frame1.getWidth()) / 2);
        int y = (int) ((screen.getHeight() - frame1.getHeight()) / 2);
        frame1.setLocation(x, y);

    }

    public static void CalcButs() {
        Num0 = new JButton("0");
        Num1 = new JButton("1");
        Num2 = new JButton("2");
        Num3 = new JButton("3");
        Num4 = new JButton("4");
        Num5 = new JButton("5");
        Num6 = new JButton("6");
        Num7 = new JButton("7");
        Num8 = new JButton("8");
        Num9 = new JButton("9");
        panel2 = new JPanel();
        //panel2.add(Num0,Num1,Num2,Num3,Num4,Num5,Num6,Num7,Num8,Num9);
        //frame1.getContentPane().setLayout(new GridLayout(3, 3));
        //frame1.add(Num0)
        panel2.setLayout(new GridLayout(5, 2));
        panel2.add(Num0);
        panel2.add(Num1);
        panel2.add(Num2);
        panel2.add(Num3);
        panel2.add(Num4);
        panel2.add(Num5);
        panel2.add(Num6);
        panel2.add(Num7);
        panel2.add(Num8);
        panel2.add(Num9);
        frame1.add(panel2, BorderLayout.CENTER);

        panel3 = new JPanel();
        mult = new JButton("*");
        sub = new JButton("-");
        add = new JButton("+");
        sqrt = new JButton("√");
        sq = new JButton("X²");
        dot = new JButton(".");
        perc = new JButton("%");
        div = new JButton("/");
        clr = new JButton("CLEAR");
        eq = new JButton("=");
        plusmin = new JButton("+/-");

        panel3.setLayout(new GridLayout(5, 2));
        panel3.add(mult);
        panel3.add(div);
        panel3.add(add);
        panel3.add(sub);
        panel3.add(sqrt);
        panel3.add(sq);
        panel3.add(perc);
        panel3.add(clr);
        panel3.add(dot);
        panel3.add(eq);
        panel3.add(plusmin);

        frame1.add(panel3, BorderLayout.EAST);
    }

    public static void logic() {
        Num0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    beforeOpdot();

                    if (ifdotispressedbeforeop == true) {

                        String s = text1.getText();
                        text1.setText(s + "0");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d1 = d;
                        ops();
                    } else if (ifdotispressedbeforeop == false) {
                        String s = text1.getText();
                        text1.setText(s + "0");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        firstOperand = f;
                        ops();
                    }

                } else if (operator != ' ') {
                    afterOpdot();
// 
                    if (ifdotispressedafterop == true) {

                        String s = text1.getText();
                        text1.setText(s + "0");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d2 = d;
                    } else if (ifdotispressedafterop == false) {

                        String s = text1.getText();
                        text1.setText(s + "0");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        nextOperand = f;

                    }

                }

                switch (operator) {
                    case '+':
                        addup();
                        break;
                    case '-':
                        subtract();
                        break;
                    case '*':
                        multiply();
                        break;
                    case '/':
                        divide();
                        break;
                    case '^':
                        square();
                        break;
                    case '!':
                        sqroot();
                        break;
                    case '%':
                        percent();
                        break;
                }

            }

        });
        Num1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    beforeOpdot();

                    if (ifdotispressedbeforeop == true) {

                        String s = text1.getText();
                        text1.setText(s + "1");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d1 = d;
                        ops();
                    } else if (ifdotispressedbeforeop == false) {
                        String s = text1.getText();
                        text1.setText(s + "1");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        firstOperand = f;
                        ops();
                    }

                } else if (operator != ' ') {
                    afterOpdot();
// 
                    if (ifdotispressedafterop == true) {

                        String s = text1.getText();
                        text1.setText(s + "1");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d2 = d;
                    } else if (ifdotispressedafterop == false) {

                        String s = text1.getText();
                        text1.setText(s + "1");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        nextOperand = f;

                    }

                }

                switch (operator) {
                    case '+':
                        addup();
                        break;
                    case '-':
                        subtract();
                        break;
                    case '*':
                        multiply();
                        break;
                    case '/':
                        divide();
                        break;
                    case '^':
                        square();
                        break;
                    case '!':
                        sqroot();
                        break;
                    case '%':
                        percent();
                        break;
                }

            }

        });
        Num2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    beforeOpdot();

                    if (ifdotispressedbeforeop == true) {

                        String s = text1.getText();
                        text1.setText(s + "2");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d1 = d;
                        ops();
                    } else if (ifdotispressedbeforeop == false) {
                        String s = text1.getText();
                        text1.setText(s + "2");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        firstOperand = f;
                        ops();
                    }

                } else if (operator != ' ') {
                    afterOpdot();
// 
                    if (ifdotispressedafterop == true) {

                        String s = text1.getText();
                        text1.setText(s + "2");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d2 = d;
                    } else if (ifdotispressedafterop == false) {

                        String s = text1.getText();
                        text1.setText(s + "2");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        nextOperand = f;

                    }

                }

                switch (operator) {
                    case '+':
                        addup();
                        break;
                    case '-':
                        subtract();
                        break;
                    case '*':
                        multiply();
                        break;
                    case '/':
                        divide();
                        break;
                    case '^':
                        square();
                        break;
                    case '!':
                        sqroot();
                        break;
                    case '%':
                        percent();
                        break;
                }

            }

        });
        Num3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    beforeOpdot();

                    if (ifdotispressedbeforeop == true) {

                        String s = text1.getText();
                        text1.setText(s + "3");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d1 = d;
                        ops();
                    } else if (ifdotispressedbeforeop == false) {
                        String s = text1.getText();
                        text1.setText(s + "3");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        firstOperand = f;
                        ops();
                    }

                } else if (operator != ' ') {
                    afterOpdot();
// 
                    if (ifdotispressedafterop == true) {

                        String s = text1.getText();
                        text1.setText(s + "3");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d2 = d;
                    } else if (ifdotispressedafterop == false) {

                        String s = text1.getText();
                        text1.setText(s + "3");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        nextOperand = f;

                    }

                }

                switch (operator) {
                    case '+':
                        addup();
                        break;
                    case '-':
                        subtract();
                        break;
                    case '*':
                        multiply();
                        break;
                    case '/':
                        divide();
                        break;
                    case '^':
                        square();
                        break;
                    case '!':
                        sqroot();
                        break;
                    case '%':
                        percent();
                        break;
                }

            }

        });
        Num4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    beforeOpdot();

                    if (ifdotispressedbeforeop == true) {

                        String s = text1.getText();
                        text1.setText(s + "4");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d1 = d;
                        ops();
                    } else if (ifdotispressedbeforeop == false) {
                        String s = text1.getText();
                        text1.setText(s + "4");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        firstOperand = f;
                        ops();
                    }

                } else if (operator != ' ') {
                    afterOpdot();
// 
                    if (ifdotispressedafterop == true) {

                        String s = text1.getText();
                        text1.setText(s + "4");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d2 = d;
                    } else if (ifdotispressedafterop == false) {

                        String s = text1.getText();
                        text1.setText(s + "4");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        nextOperand = f;

                    }

                }

                switch (operator) {
                    case '+':
                        addup();
                        break;
                    case '-':
                        subtract();
                        break;
                    case '*':
                        multiply();
                        break;
                    case '/':
                        divide();
                        break;
                    case '^':
                        square();
                        break;
                    case '!':
                        sqroot();
                        break;
                    case '%':
                        percent();
                        break;
                }

            }

        });
        Num5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    beforeOpdot();

                    if (ifdotispressedbeforeop == true) {

                        String s = text1.getText();
                        text1.setText(s + "5");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d1 = d;
                        ops();
                    } else if (ifdotispressedbeforeop == false) {
                        String s = text1.getText();
                        text1.setText(s + "5");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        firstOperand = f;
                        ops();
                    }

                } else if (operator != ' ') {
                    afterOpdot();
// 
                    if (ifdotispressedafterop == true) {

                        String s = text1.getText();
                        text1.setText(s + "5");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d2 = d;
                    } else if (ifdotispressedafterop == false) {

                        String s = text1.getText();
                        text1.setText(s + "5");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        nextOperand = f;

                    }

                }

                switch (operator) {
                    case '+':
                        addup();
                        break;
                    case '-':
                        subtract();
                        break;
                    case '*':
                        multiply();
                        break;
                    case '/':
                        divide();
                        break;
                    case '^':
                        square();
                        break;
                    case '!':
                        sqroot();
                        break;
                    case '%':
                        percent();
                        break;
                }

            }

        });
        Num6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    beforeOpdot();

                    if (ifdotispressedbeforeop == true) {

                        String s = text1.getText();
                        text1.setText(s + "6");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d1 = d;
                        ops();
                    } else if (ifdotispressedbeforeop == false) {
                        String s = text1.getText();
                        text1.setText(s + "6");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        firstOperand = f;
                        ops();
                    }

                } else if (operator != ' ') {
                    afterOpdot();
// 
                    if (ifdotispressedafterop == true) {

                        String s = text1.getText();
                        text1.setText(s + "6");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d2 = d;
                    } else if (ifdotispressedafterop == false) {

                        String s = text1.getText();
                        text1.setText(s + "6");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        nextOperand = f;

                    }

                }

                switch (operator) {
                    case '+':
                        addup();
                        break;
                    case '-':
                        subtract();
                        break;
                    case '*':
                        multiply();
                        break;
                    case '/':
                        divide();
                        break;
                    case '^':
                        square();
                        break;
                    case '!':
                        sqroot();
                        break;
                    case '%':
                        percent();
                        break;
                }

            }

        });
        Num7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    beforeOpdot();

                    if (ifdotispressedbeforeop == true) {

                        String s = text1.getText();
                        text1.setText(s + "7");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d1 = d;
                        ops();
                    } else if (ifdotispressedbeforeop == false) {
                        String s = text1.getText();
                        text1.setText(s + "7");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        firstOperand = f;
                        ops();
                    }

                } else if (operator != ' ') {
                    afterOpdot();
// 
                    if (ifdotispressedafterop == true) {

                        String s = text1.getText();
                        text1.setText(s + "7");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d2 = d;
                    } else if (ifdotispressedafterop == false) {

                        String s = text1.getText();
                        text1.setText(s + "7");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        nextOperand = f;

                    }

                }

                switch (operator) {
                    case '+':
                        addup();
                        break;
                    case '-':
                        subtract();
                        break;
                    case '*':
                        multiply();
                        break;
                    case '/':
                        divide();
                        break;
                    case '^':
                        square();
                        break;
                    case '!':
                        sqroot();
                        break;
                    case '%':
                        percent();
                        break;
                }

            }

        });
        Num8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    beforeOpdot();

                    if (ifdotispressedbeforeop == true) {

                        String s = text1.getText();
                        text1.setText(s + "8");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d1 = d;
                        ops();
                    } else if (ifdotispressedbeforeop == false) {
                        String s = text1.getText();
                        text1.setText(s + "8");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        firstOperand = f;
                        ops();
                    }

                } else if (operator != ' ') {
                    afterOpdot();
// 
                    if (ifdotispressedafterop == true) {

                        String s = text1.getText();
                        text1.setText(s + "8");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d2 = d;
                    } else if (ifdotispressedafterop == false) {

                        String s = text1.getText();
                        text1.setText(s + "8");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        nextOperand = f;

                    }

                }

                switch (operator) {
                    case '+':
                        addup();
                        break;
                    case '-':
                        subtract();
                        break;
                    case '*':
                        multiply();
                        break;
                    case '/':
                        divide();
                        break;
                    case '^':
                        square();
                        break;
                    case '!':
                        sqroot();
                        break;
                    case '%':
                        percent();
                        break;
                }

            }

        });

        Num9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    beforeOpdot();

                    if (ifdotispressedbeforeop == true) {

                        String s = text1.getText();
                        text1.setText(s + "9");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d1 = d;
                        ops();
                    } else if (ifdotispressedbeforeop == false) {
                        String s = text1.getText();
                        text1.setText(s + "9");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        firstOperand = f;
                        ops();
                    }

                } else if (operator != ' ') {
                    afterOpdot();
// 
                    if (ifdotispressedafterop == true) {

                        String s = text1.getText();
                        text1.setText(s + "9");
                        String ss = text1.getText();
                        Double d = Double.parseDouble(ss);
                        System.out.println(ss);
                        d2 = d;
                    } else if (ifdotispressedafterop == false) {

                        String s = text1.getText();
                        text1.setText(s + "9");
                        String ss = text1.getText();
                        int f = Integer.parseInt(ss);
                        System.out.println(ss);
                        nextOperand = f;

                    }

                }

                switch (operator) {
                    case '+':
                        addup();
                        break;
                    case '-':
                        subtract();
                        break;
                    case '*':
                        multiply();
                        break;
                    case '/':
                        divide();
                        break;
                    case '^':
                        square();
                        break;
                    case '!':
                        sqroot();
                        break;
                    case '%':
                        percent();
                        break;
                }

            }

        });

        plusmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                plusmin();

            }
        });

    }

    public static void ops() {

        perc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = '%';
                System.out.println("%");
                // text1.setText("");

                if (global == 0) {
                    percent();
                }
                global++;
            }
        });
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = '+';
                System.out.println("+");
                text1.setText("");

            }
        });
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = '-';
                text1.setText("");
            }
        });
        mult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = '*';
                text1.setText("");
            }
        });
        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = '/';
                text1.setText("");
            }
        });
        sqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = '!';

                sqroot();
            }
        });
        sq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operator = '^';
                square();

            }
        });
        clr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        dot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (operator == ' ') {
                    beforeOpdot();
                } else if (operator != ' ') {
                    afterOpdot();

                }

            }
        });

    }

    public static void result() {
        eq.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ifdotispressedbeforeop == false && ifdotispressedafterop == false) {
                    String s = Integer.toString(result);
                    text1.setText(s);
                    firstOperand = result;
                    nextOperand = 0;
                    global = 0;

                } else if (ifdotispressedbeforeop == true || ifdotispressedafterop == true) {
                    String s = Double.toString(resultd);
                    text1.setText(s);
                    d1 = resultd;
                    d2 = 0;
                    //ifdotispressedbeforeop=false;
                    // ifdotispressedafterop=false;
                    debos = 0;
                    debo = 1;
                    global = 0;

                }
            }
        });

    }

    public static void addup() {

        if (ifdotispressedbeforeop == true || ifdotispressedafterop == true) {
            resultd = d1 + d2;
            result();
        } else if (ifdotispressedbeforeop == false && ifdotispressedafterop == false) {
            result = firstOperand + nextOperand;
            result();
        }
    }

    public static void subtract() {
        String p = text1.getText();

        if (ifdotispressedbeforeop == true || ifdotispressedafterop == true) {
            resultd = d1 - d2;
            result();
        } else if (ifdotispressedbeforeop == false && ifdotispressedafterop == false) {
            result = firstOperand - nextOperand;
            System.out.println(result);
            result();
        }

    }

    public static void multiply() {
        if (ifdotispressedbeforeop == true || ifdotispressedafterop == true) {
            resultd = d1 * d2;
            result();
        } else if (ifdotispressedbeforeop == false && ifdotispressedafterop == false) {
            result = firstOperand * nextOperand;
            result();
        }
    }

    public static void divide() {
        if (ifdotispressedbeforeop == true || ifdotispressedafterop == true) {
            resultd = d1 / d2;
            result();
        } else if (ifdotispressedbeforeop == false && ifdotispressedafterop == false) {
            result = firstOperand / nextOperand;
            result();
        }

    }

    public static void square() {

        String s = text1.getText();
        if (text1.getText().contains(".") == true) {
            double d = Double.parseDouble(s);

            double dp = d * d;
            String sw = Double.toString(dp);
            text1.setText(sw);
            resultd = dp;
            d1 = dp;
        } else if (text1.getText().contains(".") == false) {
            int f = Integer.parseInt(s);
            int sq = f * f;
            String sq1 = Integer.toString(sq);
            text1.setText(sq1);
            result = sq;
            firstOperand = sq;
        }

    }

    public static void sqroot() {
        if (Double.parseDouble(text1.getText()) > 0) {
            String s = text1.getText();

            double f = Double.parseDouble(s);

            double ff = Math.sqrt(f);
            String fff = Double.toString(ff);

            text1.setText(fff);

        } else {
            text1.setText("Number must be larger than 0");
        }
    }

    public static void clear() {

        result = 0;
        firstOperand = 0;
        nextOperand = 0;
        d1 = 0.0;
        d2 = 0.0;
        resultd = 0.0;
        text1.setText("");
        beforeOpDot = 0;
        afterOpDot = 0;
        operator = ' ';
        debo = 1;
        debos = 0;
        global = 0;
        //ifdotispressedbeforeop=false;
        //beforeOpdot();
        //afterOpdot();
    }

    public static void percent() {

        if (operator == ' ') {

            String m = text1.getText();
            double d = Double.parseDouble(m);
            percent = d / 100;
            String mm = Double.toString(percent);
            text1.setText(mm);
            d1 = percent;
            result();
        } else if (operator != ' ') {
            String m = text1.getText();
            double d = Double.parseDouble(m);
            percent = d / 100;
            String mm = Double.toString(percent);
            text1.setText(mm);
            d2 = percent;
            result();

        }

    }

    public static void beforeOpdot() {
        //ifOpPressedbeforedot=false;
        //ifOpPressedafterdot=false;
        dot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (operator == ' ') {
                    ifdotispressedbeforeop = true;
                    if (debo == 1) {
                        text1.setText(text1.getText() + ".");
                        System.out.println(text1.getText());
                        debo++;
                    }
                } else if (operator != ' ') {
                    ifdotispressedbeforeop = false;
                }

            }
        });
    }

    public static void afterOpdot() {

        dot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                /*if(operator==' '&& beforeOpDot==0){
                String p = text1.getText();
                System.out.println(p);
                String ps = p+".0";
                Double d = Double.parseDouble(ps);
                d1=d;
                System.out.println(ps);
                beforeOpDot=1;
                ifOpPressedbeforedot=true;
                // have one dot in the first double
                }
                
                 */ if (operator != ' ') {
                    ifdotispressedafterop = true;
                    if (debos == 0) {
                        text1.setText(text1.getText() + ".");
                        System.out.println(text1.getText());
                        debos++;
                    }
                } else if (operator == ' ') {
                    ifdotispressedafterop = false;
                }
            }

        });
    }

    public static void plusmin() {
        int q;
        if (text1.getText().contains(".") == false) {

            if (operator == ' ') {
                String s1 = text1.getText();
                int d3 = Integer.parseInt(s1);
                d3 = d3 * -1;
                firstOperand = d3;
                String d5 = Integer.toString(d3);
                text1.setText(d5);

            } else if (operator != ' ') {

                String s1 = text1.getText();
                int d3 = Integer.parseInt(s1);
                d3 = d3 * -1;
                nextOperand = d3;
                String d5 = Integer.toString(d3);
                text1.setText(d5);
            }

        } else if (text1.getText().contains(".") == true) {
            if (operator == ' ') {
                String s1 = text1.getText();
                double d3 = Double.parseDouble(s1);
                d3 = d3 * -1.0;
                d1 = d3;
                String d5 = Double.toString(d3);
                text1.setText(d5);

            } else if (operator != ' ') {

                String s1 = text1.getText();
                double d3 = Double.parseDouble(s1);
                d3 = d3 * -1.0;
                d2 = d3;
                String d5 = Double.toString(d3);
                text1.setText(d5);

            }
        }

    }

}
