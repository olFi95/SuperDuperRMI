import java.rmi.*;
import java.net.*;
import java.util.HashMap;
import java.util.Vector;

/** This class calculates a variety of numerical integration 
 * values, printing the results of successively more accurate
 * approximations. The actual computation is performed on a
 * remote machine whose hostname is specified as a command-
 * line argument.
 */

public class RemoteClient {


    public static void main(String[] args) {
        try {
            String host = (args.length > 0) ? args[0] : "localhost";
            Remote remoteIntegral =
                    (Remote)Naming.lookup("rmi://" + host +
                            "/Remote");


            DataWrapper dataWrapper;

            //generating stuff
            HashMap<String, Vector<Message>> chatVerlauf = new HashMap<>();
            Vector<Message> vec = new Vector<>();
            for(int i=0; i< 10; i++) {
                vec.add(new Message("zeides", "kindler", Integer.toString(i)));
            }
            chatVerlauf.put("zeides", vec);

            dataWrapper = new DataWrapper("zeides", chatVerlauf);

            System.out.println("Derzeitiger Verlauf: ");
            System.out.println(dataWrapper.getChatVerlauf());
            System.out.println();
            System.out.println();

            dataWrapper = remoteIntegral.reloadDataWrapper(dataWrapper);
            System.out.print(dataWrapper.getChatVerlauf());

        } catch(RemoteException re) {
            System.out.println("RemoteException: " + re);
        } catch(NotBoundException nbe) {
            System.out.println("NotBoundException: " + nbe);
        } catch(MalformedURLException mfe) {
            System.out.println("MalformedURLException: " + mfe);
        }
    }
}