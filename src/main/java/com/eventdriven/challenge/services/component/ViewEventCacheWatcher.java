package com.eventdriven.challenge.services.component;

import com.eventdriven.challenge.domain.entities.Event;
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
    public void registerViewEventContinuousQuery() {

        ContinuousQuery query = new ContinuousQuery();

        query.setLocalListener(
                new CacheEntryUpdatedListener<Long, Event>() {
                    @Override
                    public void onUpdated(Iterable<CacheEntryEvent<? extends Long, ? extends Event>> cacheEntryEvents) throws CacheEntryListenerException {
                        cacheEntryEvents.forEach(cacheEntryEvent -> kafkaTemplate.send(TOPIC, cacheEntryEvent.toString()));
                    }
                }
        );

        IgniteCache<Long, Event> igniteCache = ignite.getOrCreateCache("EventCache");
        igniteCache.query(query);
    }
}
