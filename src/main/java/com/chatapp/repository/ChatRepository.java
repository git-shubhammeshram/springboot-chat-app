package com.chatapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatapp.model.Message;


public interface ChatRepository extends JpaRepository<Message, Long> {
}