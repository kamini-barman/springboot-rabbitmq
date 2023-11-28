package upskill.ms.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upskill.ms.springboot.publisher.RabbitMQProducer;

@Controller
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer producer;


    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    //localhost:8080/api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ...");
    }
}
