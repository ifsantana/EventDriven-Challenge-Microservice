package com.eventdriven.challenge.services;

import com.eventdriven.challenge.domain.entities.Event;
import com.eventdriven.challenge.repositories.queries.EventCacheRepository;
import com.eventdriven.challenge.services.queries.ClickConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClickEventService {
    private static final String TOPIC = "save_click_topic";
    private EventCacheRepository repository;
    private KafkaTemplate<String, Object> kafkaTemplate;
    private ClickConsumer consumer;

    @Autowired
    public ClickEventService(EventCacheRepository repository, KafkaTemplate<String, Object> kafkaTemplate, ClickConsumer consumer) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
        this.consumer = consumer;
    }

    public Iterable<Event> getAll() {
        Iterable<Event> teste = this.repository.findAll();
        return teste;
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
