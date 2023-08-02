//package com.gap.mongodb.practice.MongoDBPractice.mongo;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import io.micrometer.core.instrument.util.StringUtils;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.MongoDbFactory;
//import org.springframework.data.mongodb.MongoTransactionManager;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//@Configuration
////@EnableMongoRepositories(basePackages = "com.gap.mongodb.practice.MongoDBPractice")
//public class MongoDbConfig /*extends AbstractMongoClientConfiguration*/ {
//
//    // private final Environment environment;
//
//  /*  @Autowired
//    public MongoDbConf(Environment environment) {
//        this.environment = environment;
//    }*/
//
//    /*@Override
//    public MongoClient mongoClient() {
//        String connectionString = "mongodb://localhost:27017/springBootMongoDB?retryWrites=false";
//
//        if (StringUtils.isBlank(connectionString))
//            throw new IllegalArgumentException("No connection string to initialize mongo client");
//
//        return MongoClients.create(
//                MongoClientSettings.builder()
//                        .applyConnectionString(new ConnectionString(connectionString))
//                        .applicationName("MY_APP")
//                        .build());
//    }
//
//    @Override
//    protected String getDatabaseName() {
//        // return environment.getProperty("mongodb.database", "myDB");
//        return "SpringBootMongoDB";
//    }
//
//    @Bean
//    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
//        return new MongoTransactionManager(dbFactory);
//    }*/
//}
