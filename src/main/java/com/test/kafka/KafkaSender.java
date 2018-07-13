package com.test.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.model.TestKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send(String id, String name) {
        TestKafka message = new TestKafka();
        message.setId(System.currentTimeMillis());
        System.err.println("生成的Topic是" + System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setName_id(id);
        message.setName(name);
        message.setSendTime(new Date());
        kafkaTemplate.send("addTest", gson.toJson(message));
    }
}
