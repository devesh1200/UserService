package com.userservice.consumer;


import com.userservice.entities.UserInfoDto;
import com.userservice.service.UserSerivce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class AuthServiceConsumer {

    @Autowired
    private UserSerivce userSerivce;


    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(UserInfoDto eventData) {
        try {

            userSerivce.createAndUpdateUser(eventData);

        } catch (Exception e) {
          log.error("Error in consuming event from Kafka topic: {}. Error: {}", eventData, e.getMessage());
        }

    }

}
