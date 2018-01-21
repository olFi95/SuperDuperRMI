package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;

public class ProfileWrapper implements Serializable{
    //email but id for mongodb (primary key)
    private String _id;
    private String password;

    //Key = Kontake
    //Value = Liste mit Nachrichten
    private HashMap<Contact, Vector<Message>> chatVerlauf;

    public ProfileWrapper(String _id, String password, HashMap<Contact, Vector<Message>> chatVerlauf) {
        this._id = _id;
        this.password = password;
        this.chatVerlauf = chatVerlauf;
    }

    public String getEmail() {
        return _id;
    }

    public void setEmail(String _id) {
        this._id = _id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashMap<Contact, Vector<Message>> getChatVerlauf() {
        return chatVerlauf;
    }

    public void setChatVerlauf(HashMap<Contact, Vector<Message>> chatVerlauf) {
        this.chatVerlauf = chatVerlauf;
    }

    @Override
    public String toString() {
        return "email = " + _id+
                "\npassword = "+ password +
                "\n"+chatVerlauf;
    }
}
