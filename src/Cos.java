import java.io.Serializable;

/** An evaluatable version of cos(x). */

class Cos implements Evaluatable, Serializable {
    public double evaluate(double val) {
        return(Math.cos(val));
    }

    public String toString() {
        return("Cosine");
    }
}