import model.Contact;
import model.Message;
import model.ProfileWrapper;

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
            Remote remote = (Remote)Naming.lookup("rmi://" + host + "/Remote");


            ProfileWrapper profileWrapper;

            //generating stuff
            HashMap<Contact, Vector<Message>> chatVerlauf = new HashMap<>();
            Vector<Message> vec = new Vector<>();
            for(int i=0; i< 10; i++) {
                vec.add(new Message("zeides", "kindler", Integer.toString(i)));
            }
            Contact contact = new Contact("kindler", 0);
            chatVerlauf.put(contact, vec);

            String email = "zeides@mail.hs-ulm.de";
            String password = "password";

            profileWrapper = new ProfileWrapper(email, password, chatVerlauf);

            System.out.println(profileWrapper);

            System.out.println();
            System.out.println();

            System.out.println(remote.reloadProfileWrapper(profileWrapper));

        } catch(RemoteException re) {
            System.out.println("RemoteException: " + re);
        } catch(NotBoundException nbe) {
            System.out.println("NotBoundException: " + nbe);
        } catch(MalformedURLException mfe) {
            System.out.println("MalformedURLException: " + mfe);
        }
    }
}