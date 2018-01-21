package model;

import javafx.util.converter.DateTimeStringConverter;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Message implements Serializable {

    private String content;
    private String from;
    private String to;
    private LocalDateTime timestamp;

    public Message(String content, String from, String to) {
        this.content = content;
        this.from = from;
        this.to = to;

        if (ZoneId.systemDefault().equals(ZoneId.of("Europe/Berlin"))) {
            this.timestamp = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        } else {
            this.timestamp = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Berlin"));
        }
    }


    public String getContent() {
        return content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return getFrom() + " >> " + getTo() + ":" + getContent();
    }
}
