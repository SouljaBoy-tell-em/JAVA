package com.project.project.requests.topic_requests.message_requests;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CreateMessageRequest {
    private long topicId;
    private String userId;
    private String textMessage;

    public CreateMessageRequest(long topicId, String userId, String textMessage) {
        this.topicId = topicId;
        this.userId = userId;
        this.textMessage = textMessage;
    }
}
