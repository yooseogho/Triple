package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service // @Service 어노테이션을 사용하여 해당 클래스가 Spring의 서비스 컴포넌트임을 명시합니다.
public class ProducerService {


    private static final String TOPIC_NAME = "seokho"; // Kafka 토픽 이름을 상수로 선언합니다.

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

  
    public void sendMessage(String message) {

        kafkaTemplate.send(TOPIC_NAME, message); // KafkaTemplate의 send 메서드를 사용하여 메시지를 특정 토픽에 전송합니다.

     
        System.out.println("Message sent: " + message); // 메시지가 성공적으로 전송되었음을 콘솔에 출력합니다.
    }
}
