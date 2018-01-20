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

            System.out.print(remoteIntegral.checkForUpdate(chatVerlauf));



//            System.out.println(remoteIntegral.recieveMessage("zeides", "kindler", "das tut nicht wirklich"));



//            for(int steps=10; steps<=10000; steps*=10) {
//                System.out.println
//                        ("Approximated with " + steps + " steps:" +
//                                "\n Integral from 0 to pi of sin(x)=" +
//                                remoteIntegral.integrate(0.0, Math.PI,
//                                        steps, new Sin()) +
//                                "\n Integral from pi/2 to pi of cos(x)=" +
//                                remoteIntegral.integrate(Math.PI/2.0, Math.PI,
//                                        steps, new Cos()) +
//                                "\n Integral from 0 to 5 of x^2=" +
//                                remoteIntegral.integrate(0.0, 5.0, steps,
//                                        new Quadratic()));
//            }
//            System.out.println
//                    ("'Correct' answer using Math library:" +
//                            "\n Integral from 0 to pi of sin(x)=" +
//                            (-Math.cos(Math.PI) - -Math.cos(0.0)) +
//                            "\n Integral from pi/2 to pi of cos(x)=" +
//                            (Math.sin(Math.PI) - Math.sin(Math.PI/2.0)) +
//                            "\n Integral from 0 to 5 of x^2=" +
//                            (Math.pow(5.0, 3.0) / 3.0));
        } catch(RemoteException re) {
            System.out.println("RemoteException: " + re);
        } catch(NotBoundException nbe) {
            System.out.println("NotBoundException: " + nbe);
        } catch(MalformedURLException mfe) {
            System.out.println("MalformedURLException: " + mfe);
        }
    }
}