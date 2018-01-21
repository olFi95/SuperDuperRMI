import java.rmi.*;
import java.net.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteServer {
    public static void main(String[] args) {
        try {
            RemoteImpl integral = new RemoteImpl();
            Registry rmiRegistry = LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi:///Remote", integral);
        } catch(RemoteException re) {
            System.out.println("RemoteException: " + re);
        } catch(MalformedURLException mfe) {
            System.out.println("MalformedURLException: " + mfe);
        }
    }
}