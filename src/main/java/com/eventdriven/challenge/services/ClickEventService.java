package com.eventdriven.challenge.services;

import com.eventdriven.challenge.repositories.cache.ClickEventRepository;
import com.eventdriven.challenge.services.consumers.ClickConsumer;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteDataStreamer;
import org.apache.ignite.stream.kafka.KafkaStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClickEventService {
    private static final String TOPIC = "";
    private ClickEventRepository repository;
//    private KafkaTemplate<String, String> kafkaTemplate;
    private ClickConsumer consumer;

    @Autowired
    public ClickEventService(ClickEventRepository repository, ClickConsumer consumer) {
        this.repository = repository;
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
