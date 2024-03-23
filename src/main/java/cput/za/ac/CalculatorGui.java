package cput.za.ac;
import javax.swing.*;
import java.awt.*;

public class CalculatorGui extends JFrame{
    //declare containers and buttons
    private JFrame mainContainer;
    private JPanel outerContainer, buttonContainer;
    private JButton oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton, zeroButton;
    private JButton addButton, subtractButton, multiplyButton, divideButton, percentButton, equalsButton;
    private JTextField display;
    private JLabel watermark;

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
    //set button text and look
    public void setButtons(){
        oneButton = new JButton("1");
        twoButton = new JButton("2");
        threeButton = new JButton("3");
        fourButton = new JButton("4");
        fiveButton = new JButton("5");
        sixButton = new JButton("6");
        sevenButton = new JButton("7");
        eightButton = new JButton("8");
        nineButton = new JButton("9");
        zeroButton = new JButton("0");
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton("/");
        percentButton = new JButton("%");
        equalsButton = new JButton("=");
    }

}
