package Client;

import model.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteClientInterface extends Remote{
    public void addMessage(Message message) throws RemoteException;
}
