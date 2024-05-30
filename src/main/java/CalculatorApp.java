import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorApp implements ActionListener, KeyListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equalsButton, delButton, clrButton;
    JPanel panel;
    Font myFond = new Font("Arial", Font.BOLD,20);
    double num1=0, num2=0, result=0;
    char operator;

    public CalculatorApp(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFond);
        textField.addKeyListener(this);
        //textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equalsButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = delButton;
        functionButtons[1] = clrButton;
        functionButtons[2] = addButton;
        functionButtons[3] = subButton;
        functionButtons[4] = mulButton;
        functionButtons[5] = divButton;
        functionButtons[6] = decButton;
        functionButtons[7] = equalsButton;

        for (JButton functionButton : functionButtons) {
            functionButton.addActionListener(this);
            functionButton.setFocusable(false);
        }

        for(int i=0;i<numberButtons.length;i++){
            numberButtons[i]= new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);

            numberButtons[i].setFocusable(false);
        }


        for(int i=0; i<2; i++){
            functionButtons[i].setFont(myFond);
            functionButtons[i].setBounds(50+(i*145 + i*10),410,145,50);
            frame.add(functionButtons[i]);
        }

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[numberButtons.length-3]);
        panel.add(numberButtons[numberButtons.length-2]);
        panel.add(numberButtons[numberButtons.length-1]);
        panel.add(addButton);
        panel.add(numberButtons[numberButtons.length-6]);
        panel.add(numberButtons[numberButtons.length-5]);
        panel.add(numberButtons[numberButtons.length-4]);
        panel.add(mulButton);
        panel.add(numberButtons[numberButtons.length-9]);
        panel.add(numberButtons[numberButtons.length-8]);
        panel.add(numberButtons[numberButtons.length-7]);
        panel.add(subButton);
        panel.add(equalsButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args){
        CalculatorApp calculator = new CalculatorApp();
    }

    @java.lang.Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++){
            if(e.getSource().equals(numberButtons[i])){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            String number = textField.getText();
            if(!number.contains(".")){
                textField.setText(textField.getText().concat("."));
            }
        }

        if(e.getSource()==delButton){
            String number = textField.getText();
            if (!number.isEmpty()) {
                number = number.substring(0, number.length() - 1);
            }
            textField.setText(number);
        }

        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            textField.setText(textField.getText().concat("+"));
            operator = '+';
            textField.setText("");
        }
        if(e.getSource()==subButton){
            String number = textField.getText();
            if (number.isEmpty()) {
                textField.setText("-");
            }else {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
        }
        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            textField.setText(textField.getText().concat("*"));
            operator = '*';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            textField.setText(textField.getText().concat("/"));
            operator = '/';
            textField.setText("");
        }
        if(e.getSource()==clrButton){
            textField.setText("");
        }
        if(e.getSource()==equalsButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator){
                case '+':
                    result = num1 + num2 ;
                    textField.setText(String.valueOf(result));
                    break;
                case '-':
                    result = num1-num2;
                    textField.setText(String.valueOf(result));
                    break;
                case '/':
                    result = num1 / num2;
                    textField.setText(String.valueOf(result));
                    break;
                case '*':
                    result = num1*num2;
                    textField.setText(String.valueOf(result));
                    break;
            }

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
        // Allow only digits
        if (!Character.isDigit(keyChar)) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();

        if (keyChar == KeyEvent.VK_BACK_SPACE) {
            delButton.doClick();
            e.consume();
        }
        if (keyChar == KeyEvent.VK_ENTER){
            equalsButton.doClick();
            e.consume();
        }
        if (keyChar == '+'){
            addButton.doClick();
            e.consume();
        }
        if (keyChar == '-') {
            subButton.doClick();
            e.consume();
        }
        if (keyChar == '*'){
            mulButton.doClick();
            e.consume();
        }
        if (keyChar == '/'){
            divButton.doClick();
            e.consume();
        }
        if (keyChar == '.'){
            decButton.doClick();
            e.consume();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
