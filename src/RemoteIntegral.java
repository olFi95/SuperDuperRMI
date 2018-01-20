import java.rmi.*;
import java.util.HashMap;
import java.util.Vector;

/** Interface for remote numeric integration object. */

public interface RemoteIntegral extends Remote {
    public HashMap<String, Vector<Message>> reloadchatVerlauf(HashMap<String, Vector<Message>> map) throws RemoteException;
    public DataWrapper reloadDataWrapper(DataWrapper dataWrapper) throws RemoteException;
}