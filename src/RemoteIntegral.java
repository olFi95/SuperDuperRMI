import java.rmi.*;
import java.util.HashMap;
import java.util.Vector;

/** Interface for remote numeric integration object. */

public interface RemoteIntegral extends Remote {

    public double sum(double start, double stop, double stepSize,
                      Evaluatable evalObj)
            throws RemoteException;

    public double integrate(double start, double stop,
                            int numSteps, Evaluatable evalObj)
            throws RemoteException;

    public Message recieveMessage(String from, String to, String content) throws RemoteException;

    public HashMap<String, Vector<Message>> checkForUpdate(HashMap<String, Vector<Message>> map) throws RemoteException;
}