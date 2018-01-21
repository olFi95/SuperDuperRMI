package Client;

import Server.RemoteServerInterface;
import model.Message;
import model.ProfileWrapper;

import java.rmi.*;
import java.net.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class RemoteClient {

    public static void main(String[] args) {
        try {
            String host = (args.length > 0) ? args[0] : "localhost";

            ProfileWrapper profileWrapper;

            //generating stuff
            HashMap<String, Vector<Message>> chatVerlauf = new HashMap<>();
            Vector<Message> vec = new Vector<>();
            for(int i=0; i< 10; i++) {
                vec.add(new Message("zeides", "kindler", Integer.toString(i)));
            }
            chatVerlauf.put("kindler", vec);

            Scanner scanner = new Scanner(System.in);

            System.out.println("email: ");
            String email = scanner.next();



            String password = "password";

            profileWrapper = new ProfileWrapper(email, password, chatVerlauf);

            //server remote holen
            RemoteServerInterface remote = (RemoteServerInterface)Naming.lookup("rmi://" + host + "/Server.RemoteServerInterface");

            //client in die registry registrieren
            RemoteClientImpl remoteClientImpl = new RemoteClientImpl(profileWrapper);

            Naming.bind("rmi://" + host + "/" + profileWrapper.getEmail(), remoteClientImpl);

            //Bei server anmelden
            remote.addRemoteClient(profileWrapper.getEmail());


            System.out.println(profileWrapper);

            System.out.println();
            System.out.println();

            if(email.equals("zeides")) {
                remote.sendMessage(new Message("hallo kindler","zeides", "kindler"));
            }

            if(email.equals("kindler")){
                profileWrapper.getChatVerlauf().put("zeides", new Vector<>());
            }

            scanner.next();
            System.out.println(remote.reloadProfileWrapper(profileWrapper));

        } catch(RemoteException re) {
            System.out.println("RemoteException: " + re);
        } catch(NotBoundException nbe) {
            System.out.println("NotBoundException: " + nbe);
        } catch(MalformedURLException mfe) {
            System.out.println("MalformedURLException: " + mfe);
        } catch (AlreadyBoundException abe) {
            System.out.println("AlreadyBoundException" + abe);
        }
    }
}