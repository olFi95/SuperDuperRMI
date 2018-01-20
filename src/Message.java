import java.io.Serializable;

public class Message implements Serializable{
    public String from;
    public String to;
    public String content;

    public Message(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    @Override
    public String toString() {
        return from +" >> "+ to + " > " + content ;
    }
}
