package Server;

import Client.RemoteClientInterface;
import model.Message;
import model.ProfileWrapper;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Vector;

public class RemoteServerImpl extends UnicastRemoteObject implements RemoteServerInterface {
    private HashMap<String, RemoteClientInterface> remoteClients;


    public RemoteServerImpl() throws RemoteException {
        remoteClients = new HashMap<>();
    }

    @Override
    public ProfileWrapper reloadProfileWrapper(ProfileWrapper profileWrapper) throws RemoteException {
//        HashMap<String, Vector<Message>> chatVerlauf = new HashMap<>();
//        Vector<Message> vec = new Vector<>();
//        for(int i=0; i< 10; i++) {
//            vec.add(new Message("zeides", "alex", Integer.toString(i)));
//        }
//
//        profileWrapper.getChatVerlauf().put("alex", vec);

        return profileWrapper;
    }

    @Override
    public void addRemoteClient(String name) throws RemoteException {
        try {
            remoteClients.put(name, (RemoteClientInterface) Naming.lookup("rmi://" + "localhost/" + name));
            System.out.println(remoteClients);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    //server distributes messages
    @Override
    public void sendMessage(Message message) throws RemoteException {
        //empfänger
        String to = message.getTo();

        //checken ob endpunkt zu contact existiert
        if(remoteClients.containsKey(to)) {
            //beim empfänger nachricht hinzufügen
            remoteClients.get(to).addMessage(message);
        } else {
            System.out.println("Contact Callback nicht vohanden");
        }
    }
}