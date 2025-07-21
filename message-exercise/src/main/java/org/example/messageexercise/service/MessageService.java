package org.example.messageexercise.service;

import org.example.messageexercise.model.Message;
import org.example.messageexercise.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

// todo-1:

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public Optional<Message> getMessageById(Long id) {
        try {
            return messageRepository.findById(id);
        } catch (Exception e) {
            System.out.println("The inquired message couldn't be find.");
        }
        return Optional.empty();
    }

    public void deleteMessage(Long id) {
         messageRepository.deleteById(id);
    }

}
