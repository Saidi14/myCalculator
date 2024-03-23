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
    private CalcButton addButton, subtractButton, multiplyButton, divideButton, percentButton, equalsButton;
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
        buttonContainer.add(sixButton);
        buttonContainer.add(fiveButton);
        buttonContainer.add(fourButton);
        buttonContainer.add(threeButton);
        buttonContainer.add(twoButton);
        buttonContainer.add(oneButton);
        buttonContainer.add(zeroButton);
        buttonContainer.add(addButton);
        buttonContainer.add(subtractButton);
        buttonContainer.add(multiplyButton);
        buttonContainer.add(divideButton);
        buttonContainer.add(percentButton);
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
            case 'A':
                return x + y;
            case 'S':
                return x - y;
            case 'M':
                return x * y;
            case 'D':
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
        subtractButton = new CalcButton("-");
        multiplyButton = new CalcButton("x");
        divideButton = new CalcButton("/");
        percentButton = new CalcButton("%");
        equalsButton = new CalcButton("=");

        //add action listeners
        oneButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String x = display.getText();
                display.setText(x + "1");
            }
        });
        twoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String x = display.getText();
                display.setText(x + "2");
            }
        });
        threeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String x = display.getText();
                display.setText(x + "3");
            }
        });
        fourButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String x = display.getText();
                display.setText(x + "4");
            }
        });
        fiveButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String x = display.getText();
                display.setText(x + "5");
            }
        });
        sixButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String x = display.getText();
                display.setText(x + "6");
            }
        });
        sevenButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String x = display.getText();
                display.setText(x + "7");
            }
        });
        eightButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String x = display.getText();
                display.setText(x + "8");
            }
        });
        nineButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String x = display.getText();
                display.setText(x + "9");
            }
        });
        zeroButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String x = display.getText();
                display.setText(x + "0");
            }
        });

        //now add actionlisteners for the operator buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value1 = Integer.parseInt(display.getText());
                display.setText("");
                operation = 'A';
            }
        });
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value1 = Integer.parseInt(display.getText());
                display.setText("");
                operation = 'S';
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value1 = Integer.parseInt(display.getText());
                display.setText("");
                operation = 'M';
            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value1 = Integer.parseInt(display.getText());
                display.setText("");
                operation = 'D';
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

