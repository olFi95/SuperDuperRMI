package Client;

import model.Message;
import model.ProfileWrapper;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteClientImpl extends UnicastRemoteObject implements RemoteClientInterface{
    private ProfileWrapper profileWrapper;

    public RemoteClientImpl(ProfileWrapper profileWrapper) throws RemoteException {
        this.profileWrapper = profileWrapper;
    }


    //server adds the message on the client
    @Override
    public void addMessage(Message message) throws RemoteException {
        String from = message.getFrom();

        System.out.println(from);
        System.out.println(profileWrapper.getChatVerlauf());
        //prüft ob der sender als contact exisitert
        if(profileWrapper.getChatVerlauf().containsKey(from)) {
            profileWrapper.getChatVerlauf().get(from).add(message);
            System.out.println(profileWrapper.getChatVerlauf());
        } else {
            //theoretisch kontakt  hinzufügen
            System.out.println("RemoteClientImp.addMessage()");
            System.out.println("contact nicht vorhanden");
            System.out.println(profileWrapper.getChatVerlauf());
        }

    }
}
