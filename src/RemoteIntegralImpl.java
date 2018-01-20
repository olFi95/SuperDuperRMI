import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Vector;

public class RemoteIntegralImpl extends UnicastRemoteObject
        implements RemoteIntegral {

    public RemoteIntegralImpl() throws RemoteException {}

    public HashMap<String, Vector<Message>> reloadchatVerlauf(HashMap<String, Vector<Message>> map) throws RemoteException {
        System.out.println(map);
        Vector<Message> vec = new Vector<>();
        for(int i=0;i < 10; i++) {
            vec.add(new Message("alex", "kindler", Integer.toString(i)));
        }
        map.put("alex", vec);

        return map;
    }

    @Override
    public DataWrapper reloadDataWrapper(DataWrapper dataWrapper) {
        Vector<Message> vec = new Vector<>();
        vec.add(new Message("zeides", "david", "neuer conent"));
        dataWrapper.getChatVerlauf().put("alex", new Vector<Message>(vec));
        return dataWrapper;
    }
}