package Model;
public class Monomial{
    private double coef;
    private int exponent;

    Monomial(double coef, int exponent){
        this.coef = coef;
        this.exponent = exponent;
    }
    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

}
