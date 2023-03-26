package View;

import Model.Arithmetic;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolynomialCalculatorView implements ActionListener {
    private JFrame frame = new JFrame("Polynomial Calculator");
    Color c1 = new Color(173, 208, 198);
    Border border = BorderFactory.createLineBorder(Color.white);
    private JPanel panel = new JPanel();
    private JPanel subPanel1 = new JPanel();
    private JPanel subPanel2 = new JPanel();
    private JLabel title;
    private JLabel inputPolynomialLabel1;
    private JTextField inputPolynomialTextField1;
    private JLabel inputPolynomialLabel2;
    private JTextField inputPolynomialTextField2;
    private JLabel resultLabel;
    private JTextField resultTextField;
    private JTextField m_totalTf     = new JTextField(20);
    private JButton multiplyBtn = new JButton("Multiply");
    private JButton addBtn = new JButton("Add");
    private JButton divideBtn = new JButton("Divide");
    private JButton subBtn = new JButton("Sub");
    private JButton integralBtn = new JButton("Integrate");
    private JButton derivativeBtn = new JButton("Derive");
    private JButton clearBtn = new JButton("Clear");

    public PolynomialCalculatorView(){
        frame.setName("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(680, 600);
        frame.setLocationRelativeTo(null);

        title = new JLabel("Polynomial Calculator");
        title.setBounds(160, 30, 400, 50);
        title.setFont(new Font("Georgia",Font.BOLD,30));
        panel.setLayout(null);
        panel.setBackground(c1);
        panel.add(title);
        panel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        insertPanel1();
        addBtns();

        frame.add(panel, BorderLayout.CENTER);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
    private void insertPanel1(){
        inputPolynomialLabel1 = new JLabel("First Polynomial:");
        inputPolynomialLabel1.setBounds(50, 120, 250, 30);
        inputPolynomialLabel1.setFont(new Font("Century",Font.CENTER_BASELINE,20));
        inputPolynomialLabel2 = new JLabel("Second Polynomial:");
        inputPolynomialLabel2.setBounds(50, 170, 250, 30);
        inputPolynomialLabel2.setFont(new Font("Century",Font.CENTER_BASELINE,20));
        resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50,220,250,30);
        resultLabel.setFont(new Font("Century",Font.CENTER_BASELINE,20));

        inputPolynomialTextField1 = new JTextField(10);
        inputPolynomialTextField1.setBounds(250, 120,370,30);
        inputPolynomialTextField1.setBorder(border);
        inputPolynomialTextField2 = new JTextField(10);
        inputPolynomialTextField2.setBounds(250,170,370, 30);
        inputPolynomialTextField2.setBorder(border);
        resultTextField = new JTextField(10);
        resultTextField.setBounds(250, 220, 370, 30);
        resultTextField.setBorder(border);
        resultTextField.setEditable(false);
        createTextField(inputPolynomialTextField1);
        createTextField(inputPolynomialTextField2);

        panel.add(inputPolynomialLabel1);
        panel.add(inputPolynomialTextField1);
        panel.add(inputPolynomialLabel2);
        panel.add(inputPolynomialTextField2);
        panel.add(resultLabel);
        panel.add(resultTextField);
    }
    private void createTextField(JTextField text){
        text.setText("ex: 3x^2-2x^1+9x^0");
        text.setForeground(Color.GRAY);
    }

    private void createButton(JButton button){
        Color buttonColor = new Color(52, 107, 82);
        button.setFont(new Font("Century",Font.CENTER_BASELINE,20));
        button.setForeground(Color.white);
        button.setBackground(buttonColor);
        button.setBorder(border);
        button.setFocusPainted(false);
        button.setBorderPainted(false);

    }
    public JButton getAddBtn() {
        return addBtn;
    }
    void addBtns(){
        panel.add(addBtn);
        createButton(addBtn);
        addBtn.setBounds(110, 300, 120,50);

        panel.add(subBtn);
        createButton(subBtn);
        subBtn.setBounds(265, 300, 120,50);

        panel.add(multiplyBtn);
        createButton(multiplyBtn);
        multiplyBtn.setBounds(420, 300, 120,50);

        panel.add(divideBtn);
        createButton(divideBtn);
        divideBtn.setBounds(110, 380, 120, 50);

        panel.add(derivativeBtn);
        createButton(derivativeBtn);
        derivativeBtn.setBounds(265, 380, 120, 50);

        panel.add(integralBtn);
        createButton(integralBtn);
        integralBtn.setBounds(420, 380, 120, 50);

        panel.add(clearBtn);
        createButton(clearBtn);
        clearBtn.setBounds(265, 460, 120, 50);
    }
    public void addAddListener(ActionListener e){
        addBtn.addActionListener(e);
    }
    public void addMultiplyListener(ActionListener e){
        multiplyBtn.addActionListener(e);
    }
    public void addSubListener(ActionListener e){
        subBtn.addActionListener(e);
    }
    public void addDerivativeListener(ActionListener e){
        derivativeBtn.addActionListener(e);
    }
    public void addIntegralListener(ActionListener e){
        integralBtn.addActionListener(e);
    }
    public void addDivisionListener(ActionListener e){
        divideBtn.addActionListener(e);
    }
    public void addClearListener(ActionListener e){
        clearBtn.addActionListener(e);
    }
    public JTextField getResultTextField() {
        return resultTextField;
    }

    public JTextField getInputPolynomialTextField2() {
        return inputPolynomialTextField2;
    }
    public JTextField getInputPolynomialTextField1() {
        return inputPolynomialTextField1;
    }
    public String getUserInput(JTextField text){
        return text.getText();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
