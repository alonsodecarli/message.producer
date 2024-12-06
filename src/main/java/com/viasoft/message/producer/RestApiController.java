package com.viasoft.message.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestApiController {

    @Autowired
    ArtemisProducer producer;

    // Método para produzir a mensagem via GET
    @RequestMapping(value = "/produce")
    public String produce(@RequestParam("message") String message) {
        producer.sendMessage(message);
        return "Message sent to the Artemis Queue Successfully";
    }

    // Método para produzir a mensagem via POST
    @PostMapping(value = "/produce")
    public String producePost(@RequestBody String message) {
        producer.sendMessage(message);  // Envia a mensagem usando o produtor
        return "Message sent to the Artemis Queue Successfully (POST)";
    }


}
