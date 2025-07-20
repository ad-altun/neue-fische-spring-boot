package org.example.messageexercise.controller;

import org.example.messageexercise.model.Message;
import org.example.messageexercise.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    MessageService messageService;

    @GetMapping
    public List<Message> getMessages() {
        List<Message> messages = List.of();
        
        try {
            messages = messageService.getAllMessages();
            return messages;
        } catch (NullPointerException nlp) {
            System.out.println("The repository is empty");
        }
        return messages;
    }



}
