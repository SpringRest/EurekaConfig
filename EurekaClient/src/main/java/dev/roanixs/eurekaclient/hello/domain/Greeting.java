package dev.roanixs.eurekaclient.hello.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by coumaj on 28/05/2016.
 */
public class Greeting {
    private Message message;
    private long id;
    private String content;

    public Greeting(long id, String content, String message) {
        this.id = id;
        this.content = content;
        this.message = new Message(message);
    }

    public long getId() {
        return id;
    }

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The name of the user", required = true)
    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
