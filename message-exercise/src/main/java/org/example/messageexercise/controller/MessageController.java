package org.example.messageexercise.controller;

import org.example.messageexercise.model.Message;
import org.example.messageexercise.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// todo-2: implement updating message
// todo-3: deleting a message
// todo-4: implement patch http method as well

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService= messageService;
    }

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

    @PostMapping
    public Message createNewMessage(@RequestBody Message newMessage) {
        return messageService.createMessage(newMessage);
    }

    @DeleteMapping("/delete/{id}")
    public void removeMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }


}
