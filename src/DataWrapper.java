import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

public class DataWrapper implements Serializable{
    private HashMap<String, Vector<Message>> chatVerlauf;
    private String username;

    public DataWrapper(String username, HashMap<String, Vector<Message>> chatVerlauf) {
        this.username = username;
        this.chatVerlauf = chatVerlauf;
    }

    public HashMap<String, Vector<Message>> getChatVerlauf() {
        return chatVerlauf;
    }

    public String getUsername() {
        return username;
    }

    public void setChatVerlauf(HashMap<String, Vector<Message>> chatVerlauf) {
        this.chatVerlauf = chatVerlauf;
    }
}
