/** An interface for evaluating functions y = f(x) at a specific
 * value. Both x and y are double-precision floating-point 
 * numbers.
 */

public interface Evaluatable {
    public double evaluate(double value);
}