package Server;

import model.Message;
import model.ProfileWrapper;

import java.rmi.*;

/** Interface for remote numeric integration object. */

public interface RemoteServerInterface extends java.rmi.Remote {
    public ProfileWrapper reloadProfileWrapper(ProfileWrapper profileWrapper) throws RemoteException;
    public void addRemoteClient(String name) throws RemoteException;
    public void sendMessage(Message message) throws RemoteException;
}