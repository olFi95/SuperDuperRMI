import java.io.Serializable;

/** An evaluatable version of x^2. */

class Quadratic implements Evaluatable, Serializable {
    public double evaluate(double val) {
        return(val * val);
    }

    public String toString() {
        return("Quadratic");
    }
}