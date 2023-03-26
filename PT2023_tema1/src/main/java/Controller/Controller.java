package Controller;

import Model.Arithmetic;
import Model.Polynomial;
import View.PolynomialCalculatorView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller  {
    PolynomialCalculatorView GUI= new PolynomialCalculatorView();
    Arithmetic op = new Arithmetic();
    private Polynomial polynomial1;
    private Polynomial polynomial2;
    private Polynomial result;
    public Controller(){
        GUI.addAddListener(new AddListener());
        GUI.addMultiplyListener(new MultiplyListener());
        GUI.addSubListener(new SubListener());
        GUI.addDerivativeListener(new DerivativeListener());
        GUI.addIntegralListener(new IntegralListener());
        GUI.addDivisionListener(new DivisionListener());
        GUI.addClearListener(new ClearListener());
    }
    class AddListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            polynomial1 = new Polynomial();
            polynomial2 = new Polynomial();
            Polynomial result;
            if(polynomial1.verifyRegex(GUI.getUserInput(GUI.getInputPolynomialTextField1())) && polynomial2.verifyRegex(GUI.getUserInput(GUI.getInputPolynomialTextField2()))){
                result = Arithmetic.add(polynomial1, polynomial2);
                GUI.getResultTextField().setText(result.toString());
            } else GUI.getResultTextField().setText("Invalid input. Please try again!");

        }
    }
    class MultiplyListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            polynomial1 = new Polynomial();
            polynomial2 = new Polynomial();
            Polynomial result;
            if(polynomial1.verifyRegex(GUI.getUserInput(GUI.getInputPolynomialTextField1())) && polynomial2.verifyRegex(GUI.getUserInput(GUI.getInputPolynomialTextField2()))){
                result = Arithmetic.multiplication(polynomial1, polynomial2);
                GUI.getResultTextField().setText(result.toString());
            } else GUI.getResultTextField().setText("Invalid input. Please try again!");
        }
    }
    class SubListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            polynomial1 = new Polynomial();
            polynomial2 = new Polynomial();
            Polynomial result;
            if(polynomial1.verifyRegex(GUI.getUserInput(GUI.getInputPolynomialTextField1())) && polynomial2.verifyRegex(GUI.getUserInput(GUI.getInputPolynomialTextField2()))){
                result = Arithmetic.sub(polynomial1, polynomial2);
                GUI.getResultTextField().setText(result.toString());
            } else GUI.getResultTextField().setText("Invalid input. Please try again!");
        }
    }
    class DerivativeListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            polynomial1 = new Polynomial();
            Polynomial result;
            if(polynomial1.verifyRegex(GUI.getUserInput(GUI.getInputPolynomialTextField1()))){
                result = Arithmetic.derivative(polynomial1);
                GUI.getResultTextField().setText(result.toString() + "+C");
            } else GUI.getResultTextField().setText("Invalid input. Please try again!");
        }
    }
    class IntegralListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            polynomial1 = new Polynomial();
            Polynomial result;
            if(polynomial1.verifyRegex(GUI.getUserInput(GUI.getInputPolynomialTextField1()))){
                result = Arithmetic.derivative(polynomial1);
                GUI.getResultTextField().setText(result.toString());
            } else GUI.getResultTextField().setText("Invalid input. Please try again!");
        }
    }
    class DivisionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            polynomial1 = new Polynomial();
            polynomial2 = new Polynomial();
            Polynomial[] result;
            if(polynomial1.verifyRegex(GUI.getUserInput(GUI.getInputPolynomialTextField1())) && polynomial2.verifyRegex(GUI.getUserInput(GUI.getInputPolynomialTextField2()))){
                if(polynomial2.getMonomialMap().firstEntry().getKey() > polynomial1.getMonomialMap().firstEntry().getKey())
                    GUI.getResultTextField().setText("Invalid input. Please try again!");
                else {
                    result = Arithmetic.divison(polynomial1, polynomial2);
                    GUI.getResultTextField().setText(result[0].toString() + "    R: " + result[1].toString());
                }
            } else GUI.getResultTextField().setText("Invalid input. Please try again!");

        }
    }

    class ClearListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            GUI.getInputPolynomialTextField1().setText("");
            GUI.getInputPolynomialTextField2().setText("");
            GUI.getResultTextField().setText("");
        }
    }

}
