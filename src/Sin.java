import java.io.Serializable;

/** An evaluatable version of sin(x). */

class Sin implements Evaluatable, Serializable {
    public double evaluate(double val) {
        return(Math.sin(val));
    }

    public String toString() {
        return("Sin");
    }
}