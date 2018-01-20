import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Vector;

/** The actual implementation of the RemoteIntegral interface.
 */

public class RemoteIntegralImpl extends UnicastRemoteObject
        implements RemoteIntegral {

    /** Constructor must throw RemoteException. */

    public RemoteIntegralImpl() throws RemoteException {}

    /** Returns the sum of f(x) from x=start to x=stop, where the
     * function f is defined by the evaluate method of the
     * Evaluatable object.
     */

    public double sum(double start, double stop, double stepSize,
                      Evaluatable evalObj) {
        return(Integral.sum(start, stop, stepSize, evalObj));
    }

    /** Returns an approximation of the integral of f(x) from
     * start to stop, using the midpoint rule. The function f is
     * defined by the evaluate method of the Evaluatable object.
     * @see #sum
     */

    public double integrate(double start, double stop, int numSteps,
                            Evaluatable evalObj) {
        return(Integral.integrate(start, stop, numSteps, evalObj));
    }

    public Message recieveMessage(String from, String to, String content) {
        return new Message(from, to, content);
    }

    public HashMap<String, Vector<Message>> checkForUpdate(HashMap<String, Vector<Message>> map) throws RemoteException {
        System.out.println(map);

        return new HashMap(map);
    }
}