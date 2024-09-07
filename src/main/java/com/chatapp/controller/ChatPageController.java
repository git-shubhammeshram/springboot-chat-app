package com.chatapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatPageController {

    @GetMapping("/chat")
    public String showChatPage() {
        return "chat";  // This returns the 'chat.html' Thymeleaf template
    }
}
