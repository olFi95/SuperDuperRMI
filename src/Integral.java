/** A class to calculate summations and numeric integrals. The
 * integral is calculated according to the midpoint rule.
 */

public class Integral {
    /** Returns the sum of f(x) from x=start to x=stop, where the
     * function f is defined by the evaluate method of the
     * Evaluatable object.
     */

    public static double sum(double start, double stop,
                             double stepSize,
                             Evaluatable evalObj) {
        double sum = 0.0, current = start;
        while (current <= stop) {
            sum += evalObj.evaluate(current);
            current += stepSize;
        }
        return(sum);
    }

    /** Returns an approximation of the integral of f(x) from
     * start to stop, using the midpoint rule. The function f is
     * defined by the evaluate method of the Evaluatable object.
     */

    public static double integrate(double start, double stop,
                                   int numSteps,
                                   Evaluatable evalObj) {
        double stepSize = (stop - start) / (double)numSteps;
        start = start + stepSize / 2.0;
        return(stepSize * sum(start, stop, stepSize, evalObj));
    }
}