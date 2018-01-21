import model.ProfileWrapper;

import java.rmi.*;
import java.util.HashMap;
import java.util.Vector;

/** Interface for remote numeric integration object. */

public interface Remote extends java.rmi.Remote {
    public ProfileWrapper reloadProfileWrapper(ProfileWrapper profileWrapper) throws RemoteException;
}