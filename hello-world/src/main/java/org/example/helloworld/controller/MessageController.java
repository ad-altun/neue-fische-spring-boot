package org.example.helloworld.controller;

import org.example.helloworld.model.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    Message message1 = new Message("1", "name-1", "message-1");
    Message message2 = new Message("2", "name-2", "message-2");
    Message message3 = new Message("3", "name-3", "message-3");

    List<Message> messages = new ArrayList<>(List.of(message1, message2, message3));

    @GetMapping
    public List<Message> getMessages() {

        return messages;
    }

    @PostMapping
    public Message addMessage(@RequestBody Message message) {
        messages.add(message);

        return message;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMessage(@PathVariable String id) {

        messages.removeIf(message -> message.getId().equals(id));

        return "Message with ID " + '\'' + id + '\'' + " is deleted from database.";
    }

}
