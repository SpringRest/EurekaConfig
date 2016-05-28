package dev.roanixs.eurekaclient.hello.domain;

/**
 * Created by coumaj on 28/05/2016.
 */
public class Message {

    private String content;

    public Message(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
