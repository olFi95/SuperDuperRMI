import java.rmi.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/** Creates a RemoteIntegralImpl object and registers it under
 * the name 'RemoteIntegral' so that remote clients can connect
 * to it for numeric integration results. The idea is to place
 * this server on a workstation with very fast floating-point
 * capabilities, while slower interfaces can run on smaller
 * computers but still use the integration routines.
 */

public class RemoteIntegralServer {
    public static void main(String[] args) {
        try {
            RemoteIntegralImpl integral = new RemoteIntegralImpl();
            Registry rmiRegistry = LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi:///RemoteIntegral", integral);
        } catch(RemoteException re) {
            System.out.println("RemoteException: " + re);
        } catch(MalformedURLException mfe) {
            System.out.println("MalformedURLException: " + mfe);
        }
    }
}