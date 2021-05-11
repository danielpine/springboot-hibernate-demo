package io.danielpine.github.math;

public class Fraction extends Number implements Arithmetic<Fraction> {

    private static final long serialVersionUID = 1L;

    private int numerator;

    /** * !=0 */
    private int denominator;

    private Fraction() {
    }

    public static Fraction of(int numerator, int denominator) {
	Fraction fraction = new Fraction();
	fraction.numerator = numerator;
	fraction.denominator = denominator;
	return fraction;
    }

    @Override
    public int intValue() {
	return 0;
    }

    @Override
    public long longValue() {
	return 0;
    }

    @Override
    public float floatValue() {
	return 0;
    }

    @Override
    public double doubleValue() {
	return 0;
    }

    @Override
    public Fraction add(Fraction input) {
	if (input.denominator == this.denominator) {
	    return of(input.numerator + this.numerator, this.denominator);
	} else {
	    return this.multiply(input.denominator)
		    .add(input.multiply(this.denominator));
	}
    }

    @Override
    public Fraction subtract(Fraction input) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Fraction multiply(Fraction input) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Fraction divide(Fraction input) {
	// TODO Auto-generated method stub
	return null;
    };

    public Fraction multiply(int input) {
	return of(this.numerator * input, this.denominator * input);
    }

    @Override
    public String toString() {
	return numerator + "/" + denominator;
    }

    public static Fraction of(int i) {
	return of(i, 1);
    };

}
