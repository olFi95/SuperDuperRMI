package model;

public class Contact {
    private String contactEmail;
    private int chatType;

    public Contact(String contactEmail, int chatType) {
        this.contactEmail = contactEmail;
        this.chatType = chatType;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getChatType() {
        return chatType;
    }

    public void setChatType(int chatType) {
        this.chatType = chatType;
    }
}
