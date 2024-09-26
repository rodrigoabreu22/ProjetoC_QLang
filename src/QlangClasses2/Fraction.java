package QlangClasses2;


public class Fraction implements Comparable<Fraction>{
    private Integer numerator;
    private Integer denominator;

    private boolean fractionOfFractions;

    private Fraction numeratorFraction;
    private Fraction denominatorFraction;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.fractionOfFractions = false;
    }

    public Fraction(Fraction numeratorFraction, Fraction denominatorFraction) {
        this.numeratorFraction = numeratorFraction;
        this.denominatorFraction = denominatorFraction;
        this.fractionOfFractions = true;
    }

    public Integer getNumerator() {
        return numerator;
    }

    public void setNumerator(Integer numerator) {
        this.numerator = numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public void setDenominator(Integer denominator) {
        this.denominator = denominator;
    }

    public Fraction getNumeratorFraction() {
        return numeratorFraction;
    }

    public void setNumeratorFraction(Fraction numeratorFraction) {
        this.numeratorFraction = numeratorFraction;
    }

    public Fraction getDenominatorFraction() {
        return denominatorFraction;
    }

    public boolean greaterThan(Fraction other) {
        return this.numerator * other.getDenominator() > other.getNumerator() * this.denominator;
    }

    public void setDenominatorFraction(Fraction denominatorFraction) {
        this.denominatorFraction = denominatorFraction;
    }

    public static Fraction addFractions(Fraction fraction1, Fraction fraction2) {
        int newNumerator = fraction1.numerator * fraction2.denominator
                + fraction2.numerator * fraction1.denominator;
        int newDenominator = fraction1.denominator * fraction2.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction subtractFractions(Fraction fraction1, Fraction fraction2) {
        int newNumerator = fraction1.numerator * fraction2.denominator
                - fraction2.numerator * fraction1.denominator;
        int newDenominator = fraction1.denominator * fraction2.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction multiplyFractions(Fraction fraction1, Fraction fraction2) {
        int newNumerator = fraction1.numerator * fraction2.numerator;
        int newDenominator = fraction1.denominator * fraction2.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction divideFractions(Fraction fraction1, Fraction fraction2) {
        int newNumerator = fraction1.numerator * fraction2.denominator;
        int newDenominator = fraction1.denominator * fraction2.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction simplifyFraction(Fraction fraction) {
        int gcd = 1;
        int smaller = Math.min(Math.abs(fraction.numerator), Math.abs(fraction.denominator));

        for (int i = 2; i <= smaller; i++) {
            if (fraction.numerator % i == 0 && fraction.denominator % i == 0) {
                gcd = i;
            }
        }
        return new Fraction(fraction.numerator / gcd, fraction.denominator / gcd);
    }

    public static Fraction parseFraction(String text) {
        String[] farc_parts = text.split("\\/");
        int numerador = Integer.parseInt(farc_parts[0]);
        int denominador = 1;
        if (farc_parts.length > 1) {
            denominador = Integer.parseInt(farc_parts[1]);
        }
        return new Fraction(numerador, denominador);
    }

    @Override
    public String toString() {
        if (!this.fractionOfFractions) {
            if (this.denominator == 0) {
                return "null";
            }
            return ((double) this.numerator / this.denominator) * 100 + "%";
        } else {
            Fraction toprint = Fraction.divideFractions(numeratorFraction, denominatorFraction);
            if (toprint.getDenominator() == 0) {
                return "null";
            }
            return ((double) toprint.getNumerator() / toprint.getDenominator()) * 100 + "%";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Fraction) {
            Fraction other = (Fraction) obj;
            return this.compareTo(other) == 0;
        }
        return false;
    }

    @Override
    public int compareTo(Fraction other) {
        Fraction thisSimplified = Fraction.simplifyFraction(this);
        Fraction otherSimplified = Fraction.simplifyFraction(other);
        return thisSimplified.numerator * otherSimplified.denominator
                - otherSimplified.numerator * thisSimplified.denominator;
    }
}
