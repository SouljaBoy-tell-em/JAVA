package com.project.project.controllers;


import com.project.project.requests.topic_requests.CreateTopicRequest;
import com.project.project.requests.topic_requests.message_requests.CreateMessageRequest;
import com.project.project.requests.topic_requests.message_requests.DeleteMessageRequest;
import com.project.project.requests.topic_requests.message_requests.GetMessagesByTopicIdRequest;
import com.project.project.requests.topic_requests.message_requests.UpdateMessageRequest;
import com.project.project.topic_config.message_config.Message;
import com.project.project.topic_config.message_config.MessageRepository;
import com.project.project.topic_config.Topic;
import com.project.project.topic_config.TopicRepository;
import com.project.project.user_config.UserServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class TopicController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserServiceManager service;

    @PostMapping("/create_message")
    public String CREATE_MESSAGE(@RequestBody CreateMessageRequest request) {
        if(!topicRepository.findById(request.getTopicId()).isEmpty()) {
            messageRepository.save(new Message(request.getTopicId(),
                    getAuthUsername(),
                    request.getTextMessage(),
                    LocalDate.now())
            );
            return "message created";
        }
        return "topic with id " + request.getTopicId() + " doesn't exist.";
    }

    @PostMapping("/create_topic")
    public String CREATE_TOPIC(@RequestBody CreateTopicRequest request) {
        String topicName = null;
        if((topicName = request.getTopicName()) == null)
            throw new NoSuchElementException();

        Topic currentTopic = new Topic(topicName);
        topicRepository.save(currentTopic);
        messageRepository.save(new Message(currentTopic.getId(),
                getAuthUsername(),
                "topic created",
                LocalDate.now())
        );
        return "topic with name '" + request.getTopicName() + "' created.";
    }

    @DeleteMapping("/delete_message")
    public String DELETE_MESSAGE(@RequestBody DeleteMessageRequest request) {
        try {
            Message message = messageRepository.findById(request.getMessageId()).get();
            if(message.getUserId().equals(getAuthUsername()) &&
               messageRepository.amountRowsByTopicId(message.getTopicId()) > 1) {
                messageRepository.deleteByMessageId(request.getMessageId());
                return "message with id " + request.getMessageId() + " was deleted.";
            }
        } catch (NullPointerException exception) {
            System.out.println(exception.fillInStackTrace());
        } catch (NoSuchElementException exception) {
            System.out.println(exception.fillInStackTrace());
        }
        return "message wasn't delete.";
    }

    @GetMapping("/get_topics")
    public List<String> GET_TOPICS() {
        List<Topic> topics = topicRepository.findAll();
        List<String> topicNames = new ArrayList<>();

        for(Topic topic : topics)
            topicNames.add(topic.getName());
        return topicNames;
    }

    @GetMapping("/get_topic")
    public List<Message> GET_MESSAGES(@RequestBody GetMessagesByTopicIdRequest request) {
        return messageRepository.findByTopicId(request.getTopicId());
    }

    @PatchMapping("/update_message")
    public String UPDATE_MESSAGE(@RequestBody UpdateMessageRequest request) {
        try {
            Message message = messageRepository.findById(request.getMessageId()).get();
            if(message.getUserId().equals(getAuthUsername())) {
                messageRepository.updateByMessageId(request.getTextMessage(), request.getMessageId());
                return "message '" + request.getTextMessage() + "' with id " + request.getMessageId() + " updated.";
            }
        } catch (NullPointerException exception) {
            System.out.println(exception.fillInStackTrace());
        } catch (NoSuchElementException exception) {
            System.out.println(exception.fillInStackTrace());
        }
        return "message wasn't update.";
    }

    public String getAuthUsername() {
        try {
            return SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getName();
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String exampleAdmin() {
        return "Hello, admin!";
    }
}