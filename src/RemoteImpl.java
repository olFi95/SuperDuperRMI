import model.Contact;
import model.Message;
import model.ProfileWrapper;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Vector;

public class RemoteImpl extends UnicastRemoteObject
        implements Remote {

    public RemoteImpl() throws RemoteException {}

    @Override
    public ProfileWrapper reloadProfileWrapper(ProfileWrapper profileWrapper) throws RemoteException {
        HashMap<Contact, Vector<Message>> chatVerlauf = new HashMap<>();
        Vector<Message> vec = new Vector<>();
        for(int i=0; i< 10; i++) {
            vec.add(new Message("zeides", "alex", Integer.toString(i)));
        }
        Contact contact = new Contact("alex", 0);

        profileWrapper.getChatVerlauf().put(contact, vec);

        return profileWrapper;
    }
}