/**
* @author Fabian Schilling (fabsch@kth.se) and Hugo Sandelius (hugosa@kth.se)
*/

public class Modular {

    public long num;
    public long mod;

    public Modular(long num, long mod) {
        this.num = (num < 0) ? (num % mod) + mod: (num % mod);
        this.mod = mod;
    }

    public Modular add(Modular m) {
        return new Modular(this.num + m.num, this.mod);
    }

    public Modular subtract(Modular m) {
        return new Modular(this.num - m.num, this.mod);
    }

    public Modular multiply(Modular m) {
        return new Modular(this.num * m.num, this.mod);
    }

    public Modular divide(Modular m) {
        Modular inverse = m.inverse();
        return (inverse == null) ? null: this.multiply(inverse);
    }

    private Modular inverse() {
        long t = 0;
        long newt = 1;
        long r = this.mod;
        long newr = this.num;
        while (newr != 0) {
            long quotient = r / newr;
            long swap = t - (quotient * newt);
            t = newt;
            newt = swap;
            swap = r - (quotient * newr);
            r = newr;
            newr = swap;
        }
        if (r > 1) return null; // does not have an inverse
        return new Modular(t, this.mod);
    }

    public String toString() {
        return this.num + "";
    }
}
