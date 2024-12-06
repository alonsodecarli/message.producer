package com.viasoft.message.producer;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class AppConfig {

    @Value("${spring.artemis.url}")
    private String brokerUrl;

    @Value("${spring.artemis.user}")
    private String username;

    @Value("${spring.artemis.password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        try {
            /*
            factory.setBrokerURL("tcp://localhost:61616");
            factory.setUser("artemis");
            factory.setPassword("iaMuhgNJuViEey9");
             */
            factory.setBrokerURL(brokerUrl);
            factory.setUser(username);
            factory.setPassword(password);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
        return new JmsTemplate(connectionFactory);
    }

    @Bean
    public ArtemisProducer artemisProducer(JmsTemplate jmsTemplate) {
        return new ArtemisProducer(jmsTemplate);
    }

}
