package com.dam.uf3.java_mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConnectionManager {
    private static final String URI = "";

    public static MongoDatabase getConnection() {

        MongoClient client = MongoClients.create(URI);

        return client.getDatabase("albums");
    }
}
