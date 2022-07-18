package com.example.demoredispubsub.conttroller;

import com.example.demoredispubsub.publisher.MessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PublisherController {

    private final MessagePublisher messagePublisher;

    public PublisherController(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @PostMapping("/api/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        messagePublisher.publish(message);
        return ResponseEntity.ok("Message sent: " + message);
    }
}
