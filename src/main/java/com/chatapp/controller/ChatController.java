package com.chatapp.controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.chatapp.model.Message;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Message sendMessage(Message message) {
        message.setSender("User"); // Here you can specify the sender
        message.setTimestamp(LocalDateTime.now());
        
        // Simple bot logic
        String botResponse = getBotResponse(message.getContent());
        Message botMessage = new Message();
        botMessage.setSender("Bot");
        botMessage.setContent(botResponse);
        botMessage.setTimestamp(LocalDateTime.now());

        // Return bot's response (in real-time)
        return botMessage;
    }

    private String getBotResponse(String userMessage) {
        if (userMessage.toLowerCase().contains("hello")) {
            return "Hello! How can I help you today?";
        } else if (userMessage.toLowerCase().contains("bye")) {
            return "Goodbye! Have a nice day!";
        } else {
            return "I'm not sure how to respond to that.";
        }
    }
}
