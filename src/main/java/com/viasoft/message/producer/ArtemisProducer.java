package com.viasoft.message.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;


public class ArtemisProducer {

    private final JmsTemplate jmsTemplate;

    public ArtemisProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend("crm.filas::pessoa", message);
    }

}
