/**
* @author Fabian Schilling (fabsch@kth.se) and Hugo Sandelius (hugosa@kth.se)
*/

public class Rational {

    private static final Rational ZERO = new Rational(0, 1);

    private long num;
    private long den;

    public Rational(long num, long den) {
        this.num = num;
        this.den = den;
        this.normalize();
        this.reduce();
    }

    private void reduce() {
        long g = gcd(this.num, this.den);
        this.num /= g;
        this.den /= g;
    }

    private void normalize() {
        if (this.den < 0) {
            this.num *= -1;
            this.den *= -1;
        }
    }

    public int compareTo(Rational r) {
        long lhs = this.num * r.den;
        long rhs = this.den * r.num;
        if (lhs < rhs) return -1;
        if (lhs > rhs) return +1;
        return 0;
    }

    public Rational add(Rational r) {
        long num = this.num * r.den + this.den * r.num;
        long den = this.den * r.den;
        return new Rational(num, den);
    }

    public Rational subtract(Rational r) {
        long num = this.num * r.den - this.den * r.num;
        long den = this.den * r.den;
        return new Rational(num, den);
    }

    public Rational multiply(Rational r) {
        long num = this.num * r.num;
        long den = this.den * r.den;
        return new Rational(num, den);
    }

    public Rational divide(Rational r) {
        long num = this.num * r.den;
        long den = this.den * r.num;
        return new Rational(num, den);
    }

    public String toString() {
        return this.num + " / " + this.den;
    }

    public boolean isPositive() {
        return (this.num > 0 && this.den > 0) || (this.num < 0 && this.den < 0);
    }

    public static long gcd(long m, long n) {
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        if (n == 0) return m;
        else return gcd(n, m % n);
    }

}
