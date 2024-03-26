package cput.za.ac;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGui extends JFrame{
    //declare containers and buttons
    private JFrame mainContainer;
    private JPanel outerContainer, buttonContainer;
    private CalcButton oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, zeroButton;
    private CalcButton addButton, subtractButton, multiplyButton, divideButton, clearButton, equalsButton;
    private JTextField display;
    private JLabel watermark;
    private int value1, value2;
    private char operation;

    //assign values to variables and set the gui layout
    public CalculatorGui(){
        mainContainer = new JFrame();
        outerContainer = new JPanel();
        buttonContainer = new JPanel();
        display = new JTextField();
        setButtons();
        watermark = new JLabel("Created by Saidi Mwamchera");
        //Layout for button container
        GridLayout buttonLayout = new GridLayout(4,4 );
        buttonLayout.setHgap(5);
        buttonLayout.setVgap(5);
        //layout for outer container
        BoxLayout outerLayout = new BoxLayout(outerContainer,BoxLayout.Y_AXIS);

        outerContainer.setLayout(outerLayout);
        outerContainer.add(display);
        outerContainer.add(buttonContainer);
        
        buttonContainer.setLayout(buttonLayout);
        buttonContainer.setPreferredSize(new Dimension(400,500));

        buttonContainer.add(nineButton);
        buttonContainer.add(eightButton);
        buttonContainer.add(sevenButton);
        buttonContainer.add(multiplyButton);

        buttonContainer.add(sixButton);
        buttonContainer.add(fiveButton);
        buttonContainer.add(fourButton);
        buttonContainer.add(divideButton);
        buttonContainer.add(threeButton);
        buttonContainer.add(twoButton);
        buttonContainer.add(oneButton);
        buttonContainer.add(subtractButton);
        buttonContainer.add(clearButton);

        buttonContainer.add(zeroButton);
        buttonContainer.add(addButton);
        buttonContainer.add(equalsButton);

        display.setPreferredSize(new Dimension(400, 100));

        mainContainer.add(outerContainer, BorderLayout.CENTER);
        mainContainer.add(watermark, BorderLayout.SOUTH);
        mainContainer.setTitle("myCalculator");
        mainContainer.setSize(400, 600);
        mainContainer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainContainer.setLocationRelativeTo(null);
        mainContainer.setVisible(true);
    }
    public static int calculate(int x, int y, char operation){
        switch(operation){
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            default:
                return 0;
        }
    }
    //assign button text and add action listeners
    public void setButtons(){
        oneButton = new CalcButton("1");
        twoButton = new CalcButton("2");
        threeButton = new CalcButton("3");
        fourButton = new CalcButton("4");
        fiveButton = new CalcButton("5");
        sixButton = new CalcButton("6");
        sevenButton = new CalcButton("7");
        eightButton = new CalcButton("8");
        nineButton = new CalcButton("9");
        zeroButton = new CalcButton("0");
        addButton = new CalcButton("+");
        addButton.setBackground(Color.PINK);
        subtractButton = new CalcButton("-");
        subtractButton.setBackground(Color.PINK);
        multiplyButton = new CalcButton("x");
        multiplyButton.setBackground(Color.PINK);
        divideButton = new CalcButton("/");
        divideButton.setBackground(Color.PINK);
        clearButton = new CalcButton("C");
        clearButton.setBackground(Color.CYAN);
        equalsButton = new CalcButton("=");
        equalsButton.setBackground(Color.PINK);
        //add action listeners
        oneButton.addActionListener(new numActionListener("1"));
        twoButton.addActionListener(new numActionListener("2"));
        threeButton.addActionListener(new numActionListener("3"));
        fourButton.addActionListener(new numActionListener("4"));
        fiveButton.addActionListener(new numActionListener("5"));
        sixButton.addActionListener(new numActionListener("6"));
        sevenButton.addActionListener(new numActionListener("7"));
        eightButton.addActionListener(new numActionListener("8"));
        nineButton.addActionListener(new numActionListener("9"));
        zeroButton.addActionListener(new numActionListener("0"));

        //now add actionlisteners for the operator buttons
        addButton.addActionListener(new operationActionListener('+'));
        subtractButton.addActionListener(new operationActionListener('-'));
        multiplyButton.addActionListener(new operationActionListener('*'));
        divideButton.addActionListener(new operationActionListener('/'));
        //add actionListener to clear button to reset all variables
        clearButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                value1 = 0;
                value2 = 0;
                display.setText("");
            }
        });
        /*
        Finally, add an action listener to the equals button, which will call the calculate method
        */
        equalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value2 = Integer.parseInt(display.getText());
                String result = Integer.toString(calculate(value1, value2, operation));
                display.setText(result);
            }
        });


    }
    //declare action listener for number buttons
    public class numActionListener implements ActionListener {
        String value;
        numActionListener(String setVal){
            value = setVal;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            display.setText(display.getText() + value);
        }
    }
    //action listener for operator buttons
    public class operationActionListener implements ActionListener{
        char setOperation;
        public operationActionListener(char x){
            setOperation = x;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            value1 = Integer.parseInt(display.getText());
            display.setText("");
            operation = setOperation;
        }
    }
    //set button visuals
    public class CalcButton extends JButton{
        public CalcButton(String type){
            super();
            this.setText(type);
            this.setFocusable(false);
            this.setBackground(Color.LIGHT_GRAY);
        }
    }
}

