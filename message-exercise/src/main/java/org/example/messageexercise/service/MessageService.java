package org.example.messageexercise.service;

import org.example.messageexercise.model.Message;
import org.example.messageexercise.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
       return messageRepository.findAll();
    }
}
