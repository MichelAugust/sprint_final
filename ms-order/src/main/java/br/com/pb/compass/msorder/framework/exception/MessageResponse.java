package br.com.pb.compass.msorder.framework.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse {
    private String status;
    private String message;
    private List<String> messages;

    public MessageResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public MessageResponse(String status, List<String> messages) {
        this.status = status;
        this.messages = messages;
    }
}
