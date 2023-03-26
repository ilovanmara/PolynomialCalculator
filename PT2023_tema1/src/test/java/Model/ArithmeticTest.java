package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticTest {

    @Test
    void add() {
        Polynomial p1 =  new Polynomial();
        p1.verifyRegex("x^3-2x^2+6x-5");
        Polynomial p2 = new Polynomial();
        p2.verifyRegex("x^2-1");
        Polynomial res = new Polynomial();
        res.verifyRegex("x^3-x^2+6x-6");
        assertEquals(Arithmetic.add(p1, p2).toString(), res.toString());
    }

    @Test
    void addW() {
        Polynomial p1 =  new Polynomial();
        p1.verifyRegex("x^3-2x^2+6x-5");
        Polynomial p2 = new Polynomial();
        p2.verifyRegex("x^2-1");
        Polynomial res = new Polynomial();
        res.verifyRegex("x^5-x^2+6x-6");
        //assertNotSame(Arithmetic.add(p1, p2), res);
        assertEquals(Arithmetic.add(p1, p2).toString(), res.toString());
    }
    @Test
    void sub() {
        Polynomial p1 =  new Polynomial();
        p1.verifyRegex("x^3-2x^2+6x-5");
        Polynomial p2 = new Polynomial();
        p2.verifyRegex("x^2-1");
        Polynomial res = new Polynomial();
        res.verifyRegex("x^3-3x^2+6x^1-4x^0");
        assertEquals(Arithmetic.sub(p1, p2).toString(), res.toString());
    }
    @Test
    void subW() {
        Polynomial p1 =  new Polynomial();
        p1.verifyRegex("x^3-2x^2+6x-5");
        Polynomial p2 = new Polynomial();
        p2.verifyRegex("x^2-1");
        Polynomial res = new Polynomial();
        res.verifyRegex("-x^2");
        //assertNotSame(Arithmetic.add(p1, p2), res);
        assertEquals(Arithmetic.add(p1, p2).toString(), res.toString());
    }

    @Test
    void multiplication() {
        Polynomial p1 =  new Polynomial();
        p1.verifyRegex("x^3-2x^2");
        Polynomial p2 = new Polynomial();
        p2.verifyRegex("x^2-1");
        Polynomial res = new Polynomial();
        res.verifyRegex("x^5-2x^4-x^3+2x^2");
        assertEquals(Arithmetic.multiplication(p1, p2).toString(), res.toString());
    }

    @Test
    void derivative() {
        Polynomial p1 =  new Polynomial();
        p1.verifyRegex("x^3-2x^2+6x-5");
        Polynomial res = new Polynomial();
        res.verifyRegex("3x^2-4x+6");
        assertEquals(Arithmetic.derivative(p1).toString(), res.toString());
    }

    @Test
    void integrate() {
        Polynomial p1 =  new Polynomial();
        p1.verifyRegex("8x^3-6x^2+6x-5");
        Polynomial res = new Polynomial();
        res.verifyRegex("2x^4-2x^3+3x^2-5x");
        assertEquals(Arithmetic.integrate(p1).toString(), res.toString());
    }
    @Test
    void integrateW() {
        Polynomial p1 =  new Polynomial();
        p1.verifyRegex("8x^3-6x^2+6x-5");
        Polynomial res = new Polynomial();
        res.verifyRegex("2x^4-2x^3+3x^2");
        assertEquals(Arithmetic.integrate(p1).toString(), res.toString());
    }

    @Test
    void divison() {
        Polynomial p1 =  new Polynomial();
        p1.verifyRegex("x^3-2x^2+6x-5");
        Polynomial p2 = new Polynomial();
        p2.verifyRegex("x^2-1");
        Polynomial res[] = new Polynomial[2];
        Polynomial r1 = new Polynomial();
        r1.verifyRegex("x-2");
        Polynomial r2 = new Polynomial();
        r2.verifyRegex("7x-7");
        res[0] = r1;
        res[0] = r2;
        assertEquals(Arithmetic.divison(p1, p2).toString(), res.toString());
    }


}