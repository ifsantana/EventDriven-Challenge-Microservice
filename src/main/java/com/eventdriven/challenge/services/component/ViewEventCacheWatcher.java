package com.eventdriven.challenge.services.component;

import com.eventdriven.challenge.domain.ViewEvent;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.query.ContinuousQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.cache.event.CacheEntryEvent;
import javax.cache.event.CacheEntryListenerException;
import javax.cache.event.CacheEntryUpdatedListener;

@Component
public class ViewEventCacheWatcher {

    private static final String TOPIC = "save_view_topic";

    @Autowired
    private Ignite ignite;
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    @PostConstruct
    public void registerViewEventContinuosQuery() {

        ContinuousQuery query = new ContinuousQuery();

        query.setLocalListener(
                new CacheEntryUpdatedListener<Integer, ViewEvent>() {
                    @Override
                    public void onUpdated(Iterable<CacheEntryEvent<? extends Integer, ? extends ViewEvent>> cacheEntryEvents) throws CacheEntryListenerException {
                        cacheEntryEvents.forEach(cacheEntryEvent -> {
                            kafkaTemplate.send(TOPIC, cacheEntryEvent.toString());
                        });
                    }
                });

        IgniteCache<String, ViewEvent> igniteCache = ignite.getOrCreateCache("ViewEventCache");
        igniteCache.query(query);

    }
}
