package Model;

import Model.Monomial;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private Collections colections;
    private TreeMap<Integer, Monomial> monomialMap = new TreeMap<Integer, Monomial>(colections.reverseOrder());

    public TreeMap<Integer, Monomial> getMonomialMap() {
        return monomialMap;
    }

    public void setMonomialMap(Polynomial p) {
        this.monomialMap.putAll(p.getMonomialMap());
    }

    public Polynomial(){
        super();
    }

    public boolean verifyRegex(String polymonial){
        Pattern pattern = Pattern.compile("([+-]?[\\d\\.]*[x]?\\^?\\d*)");
        Matcher matcher = pattern.matcher( polymonial );
        boolean verify = true;
        while (!matcher.hitEnd()) {
            matcher.find();
            Pattern pattern2 = Pattern.compile("([+-]?[\\d\\.]*)([x]?)\\^?(\\d*)");
            Matcher m2 = pattern2.matcher(matcher.group());
            String coef, exp;
            if(m2.find()) {
                int coefInteger = 0, expInteger = 0;
                coef = m2.group(1);
                if (m2.group(1).matches("[+-]*\\d*\\.?\\d+")) {
                    coefInteger = Integer.valueOf(coef);
                } else if(m2.group(1).matches("[+-]?") && m2.group(2).matches("x"))
                    coefInteger = Integer.valueOf(coef + "1");
                else verify = false;
                exp = m2.group(3);
                if (m2.group(3).matches("[+-]*\\d*\\.?\\d+")) {
                    expInteger = Integer.valueOf(exp);
                } else if(m2.group(2).matches("x")){
                    expInteger = 1;
                }else expInteger = 0;
                double c = coefInteger;
                Monomial newMono = new Monomial(c, expInteger);
                this.addMonom(newMono);
            }
        }
        return verify;
    }
    public int verifyMono(Monomial m){
        int validare = 0;
        if(this.getMonomialMap().containsKey(m.getExponent())){
            this.getMonomialMap().get(m.getExponent()).setCoef( this.getMonomialMap().get(m.getExponent()).getCoef() + m.getCoef());
            validare = 1;
        }
        return validare;
    }
    public void addMonom(Monomial m){
        int validare = verifyMono(m);
        if(validare == 0)
            monomialMap.put(m.getExponent(), m);
    }
    public void print(){
        int validare = 0;
        for(Map.Entry<Integer, Monomial> entry : this.monomialMap.entrySet()){
            if(entry.getValue().getCoef() > 0) {
                if(validare == 0){
                    System.out.print(entry.getValue().getCoef() + "x^" + entry.getValue().getExponent());
                } else
                    System.out.print("+" + entry.getValue().getCoef() + "x^" + entry.getValue().getExponent());
                validare = 1;
            }
            else if(entry.getValue().getCoef() < 0) {
                System.out.print(entry.getValue().getCoef() + "x^" + entry.getValue().getExponent());
                validare = 1;
            }
            System.out.println();
        }
        System.out.println();
    }
    public String concat(String poly, String decimals, int exp, double coef){
        String rez;
        if(coef < 0) {
            if( coef == -1){
                rez = poly + "-x^" + exp;
            } else rez = poly + decimals + "x^" + exp;
        }else {
            if (coef == 1) {
                rez = poly + "+x^" + exp;
            } else  rez = poly + "+" + decimals + "x^" + exp;
        }
        return rez;
    }

    public String toString(){
        String poly = null;
        int validare = 0;
        String decimals = null;
        for(Map.Entry<Integer, Monomial> entry : this.monomialMap.entrySet()){
            decimals = Arithmetic.verInteger(entry.getValue().getCoef());
            if(entry.getValue().getCoef() > 0) {
                if (validare == 0) {
                    if( entry.getValue().getCoef() == 1){
                        poly = "x^" + entry.getValue().getExponent();
                    } else poly = decimals + "x^" + entry.getValue().getExponent();
                } else {
                   poly = concat(poly, decimals, entry.getValue().getExponent(), entry.getValue().getCoef());
                }
                validare = 1;
            }
            else if(entry.getValue().getCoef() < 0) {
                if(validare == 1){
                    poly = concat(poly, decimals, entry.getValue().getExponent(), entry.getValue().getCoef());
                } else {
                    if( entry.getValue().getCoef() == -1){
                        poly = "-x^" + entry.getValue().getExponent();
                    } else  poly = decimals + "x^" + entry.getValue().getExponent();
                }
                validare = 1;
            }
        }
        return poly;
    }


}
