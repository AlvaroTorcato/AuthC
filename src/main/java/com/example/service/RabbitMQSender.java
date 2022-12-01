package com.example.service;

import com.example.model.JWT;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public String exchange = "authentications_exchange";
    private static Logger logger = LogManager.getLogger(RabbitMQSender.class.toString());
    public void send(JWT jwt) {
        amqpTemplate.convertAndSend(exchange,"", jwt);
        logger.info("Sending Message to the Queue : " + jwt.toString());
    }
}