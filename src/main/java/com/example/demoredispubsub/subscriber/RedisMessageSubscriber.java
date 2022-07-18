package com.example.demoredispubsub.subscriber;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class RedisMessageSubscriber implements MessageListener {

    private static final List<String> messageList = new ArrayList<>();

    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message.toString());
        String p = new String(pattern, StandardCharsets.UTF_8);
        System.out.println("Pattern: " + p);
        System.out.println("Message received: " + message);
    }

    public static List<String> getMessageList() {
        return messageList;
    }
}
