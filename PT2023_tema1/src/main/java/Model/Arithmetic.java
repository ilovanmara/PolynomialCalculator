package Model;

import java.util.Map;

public class Arithmetic {
    public static Monomial addMono(Monomial m1, Monomial m2) {
        Monomial rez = new Monomial(0, 0);
        rez.setExponent(m1.getExponent());
        rez.setCoef(m1.getCoef() + m2.getCoef());
        return rez;
    }
    public static Polynomial add(Polynomial p1, Polynomial p2){
        Polynomial rez = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : p1.getMonomialMap().entrySet()) {
            if(p2.getMonomialMap().containsKey(entry.getKey())) {
                Monomial rezI = addMono(entry.getValue(), p2.getMonomialMap().get(entry.getKey()));
                rez.addMonom(rezI);
            }
            else
                rez.addMonom(entry.getValue());
        }
        for(Map.Entry<Integer, Monomial> entry2 : p2.getMonomialMap().entrySet()) {
            if(!p1.getMonomialMap().containsKey(entry2.getKey())) {
                rez.addMonom(entry2.getValue());
            }
        }
        return rez;
    }
    public static Monomial subMono(Monomial m1, Monomial m2) {
        Monomial rez = new Monomial(0, 0);
        rez.setExponent(m1.getExponent());
        rez.setCoef(m1.getCoef() - m2.getCoef());
        return rez;
    }
    public static Polynomial sub(Polynomial p1, Polynomial p2){
        Polynomial rez = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : p1.getMonomialMap().entrySet()) {
            if(p2.getMonomialMap().containsKey(entry.getKey())) {
                Monomial rezI = subMono(entry.getValue(), p2.getMonomialMap().get(entry.getKey()));
                if(rezI.getCoef() != 0)
                    rez.addMonom(rezI);
            }
            else
                rez.addMonom(entry.getValue());
        }
        for(Map.Entry<Integer, Monomial> entry2 : p2.getMonomialMap().entrySet()) {
            if(!p1.getMonomialMap().containsKey(entry2.getKey())) {
                Monomial subP2 = entry2.getValue();
                subP2.setCoef(-1 * subP2.getCoef());
                rez.addMonom(subP2);
            }
        }
        return rez;
    }
    public static Monomial multiplicationMono(Monomial m1, Monomial m2) {
        Monomial rez = new Monomial(0, 0);
        rez.setExponent(m1.getExponent());
        rez.setCoef(m1.getCoef() * m2.getCoef());
        rez.setExponent(m1.getExponent() + m2.getExponent());
        return rez;
    }
    public static Polynomial multiplication(Polynomial p1, Polynomial p2){
        Polynomial rez = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : p1.getMonomialMap().entrySet()) {
            for(Map.Entry<Integer, Monomial> entry2 : p2.getMonomialMap().entrySet()) {
                Monomial resM = multiplicationMono(entry.getValue(), entry2.getValue());
                rez.addMonom(resM);
            }
        }
        return rez;
    }

    public static Polynomial derivative(Polynomial p1){
        Polynomial rez = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : p1.getMonomialMap().entrySet()) {
            if(entry.getKey() > 0){
              Monomial newM = new Monomial(entry.getValue().getCoef() * entry.getValue().getExponent(), entry.getValue().getExponent() - 1);
              rez.addMonom(newM);
            }
        }
        return rez;
    }
    public static String verInteger(double number){
        String decimals = null;
        if((number % 1) == 0)
            decimals = String.valueOf(number).split("\\.")[0];
        else
            decimals = String.format("%.2f",number);
        return decimals;
    }

    public static Polynomial integrate(Polynomial p1){
        Polynomial rez = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry : p1.getMonomialMap().entrySet()) {
            Monomial newM = new Monomial(entry.getValue().getCoef() / (entry.getValue().getExponent() + 1),entry.getValue().getExponent() + 1);
            rez.addMonom(newM);
        }
        return rez;
    }
    public static Monomial divideMono(Monomial m1, Monomial m2){
        Monomial res = new Monomial(0, 0);
        res.setCoef(m1.getCoef() / m2.getCoef());
        res.setExponent(m1.getExponent() - m2.getExponent());
        return res;
    }

    public static Polynomial[] divison(Polynomial p1, Polynomial p2) {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = p1;
        Polynomial[] res = new Polynomial[2];
        int key = remainder.getMonomialMap().firstEntry().getKey();
        while (key >= p2.getMonomialMap().firstEntry().getKey()) {
            Monomial resQ = divideMono(remainder.getMonomialMap().firstEntry().getValue(), p2.getMonomialMap().firstEntry().getValue());
            Polynomial intr = new Polynomial();
            quotient.addMonom(resQ);
            for (Map.Entry<Integer, Monomial> entry2 : p2.getMonomialMap().entrySet()) {
                Monomial resI = multiplicationMono(entry2.getValue(), resQ);
                resI.setCoef(resI.getCoef());
                intr.addMonom(resI);
            }
            remainder = sub(p1, intr);
            p1 = remainder;
            key = p1.getMonomialMap().firstEntry().getKey();
        }
            res[0] = quotient;
            res[1] = remainder;
            return res;
        }


}
