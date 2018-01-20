import java.rmi.*;
import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Vector;

/** This class calculates a variety of numerical integration 
 * values, printing the results of successively more accurate
 * approximations. The actual computation is performed on a
 * remote machine whose hostname is specified as a command-
 * line argument.
 */

public class RemoteIntegralClient {


    public static void main(String[] args) {
        try {
            String host = (args.length > 0) ? args[0] : "localhost";
            RemoteIntegral remoteIntegral =
                    (RemoteIntegral)Naming.lookup("rmi://" + host +
                            "/RemoteIntegral");

            HashMap<String, Vector<Message>> chatVerlauf = new HashMap<>();

            Vector<Message> vec = new Vector<>();
            for(int i=0; i< 10; i++) {
                vec.add(new Message("zeides", "kindler", Integer.toString(i)));
            }
            chatVerlauf.put("zeides", vec);

            System.out.println(chatVerlauf);
            System.out.println();
            System.out.println();

            System.out.print(remoteIntegral.reloadData(chatVerlauf));

        } catch(RemoteException re) {
            System.out.println("RemoteException: " + re);
        } catch(NotBoundException nbe) {
            System.out.println("NotBoundException: " + nbe);
        } catch(MalformedURLException mfe) {
            System.out.println("MalformedURLException: " + mfe);
        }
    }
}