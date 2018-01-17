package com.shujuguan.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

/**
 * Created by limeng on 18-1-17.
 */

@Configuration
@ConditionalOnClass(Mongo.class)
public class MorphiaFactory {

    @Inject
    private Mongo mongo;

    @Inject
    MongoProperties mongoProperties;

    @Bean
    public Datastore get() {
        Morphia morphia = new Morphia();
        return morphia.createDatastore((MongoClient) mongo, mongoProperties.getDatabase());
    }
}
