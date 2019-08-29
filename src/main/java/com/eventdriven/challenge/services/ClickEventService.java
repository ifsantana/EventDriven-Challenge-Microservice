package com.eventdriven.challenge.services;

import com.eventdriven.challenge.repositories.cache.EventRepository;
import com.eventdriven.challenge.services.consumers.ClickConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClickEventService {
    private static final String TOPIC = "save_click_topic";
    private EventRepository repository;
    private KafkaTemplate<String, Object> kafkaTemplate;
    private ClickConsumer consumer;

    @Autowired
    public ClickEventService(EventRepository repository, KafkaTemplate<String, Object> kafkaTemplate, ClickConsumer consumer) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
        this.consumer = consumer;
    }

    public void verifyClickLimit() {
//        KafkaStreamer<String, String> kafkaStreamer = new KafkaStreamer<>();
//
//        try (IgniteDataStreamer<String, String> stmr = ignite.dataStreamer(null)) {
//            // allow overwriting cache data
//            stmr.allowOverwrite(true);
//
//            kafkaStreamer.setIgnite(ignite);
//            kafkaStreamer.setStreamer(stmr);
//
//             set the topic
//            kafkaStreamer.setTopic();
//
//             set the number of threads to process Kafka streams
//            kafkaStreamer.setThreads(4);
//
//             set Kafka consumer configurations
//            kafkaStreamer.setStreamer();
//
//             set decoders
//            kafkaStreamer.setKeyDecoder(strDecoder);
//            kafkaStreamer.setValueDecoder(strDecoder);
//
//            kafkaStreamer.start();
//        }
//        finally {
//            kafkaStreamer.stop();
//        }
    }
}
