package com.dam.uf3.java_mongo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

public class Model {
    private MongoCollection<Document> collection;
    public Model() {
        MongoDatabase db = ConnectionManager.getConnection();
        collection = db.getCollection("albums");
    }

    public void inserirAlbum(Album album) {

        collection.insertOne(album.toDocument());
    }

    public List<Album> getAllAlbums() {

        List<Album> albums = new ArrayList<>();

        for (Document doc : collection.find()) {

            Album album = new Album();

            album.setArtist(doc.getString("artist"));
            album.setTitle(doc.getString("title"));
            album.setDate(doc.getString("date"));

            albums.add(album);
        }

        return albums;
    }

    public void updateAlbum(String oldTitle, Album albumNou) {

        collection.updateOne(
                eq("title", oldTitle),
                combine(
                        set("artist", albumNou.getArtist()),
                        set("title", albumNou.getTitle()),
                        set("date", albumNou.getDate().toString())
                )
        );
    }

    public void deleteAlbum(String title) {

        collection.deleteOne(eq("title", title));
    }

    public List<Album> getAlbumByDate(LocalDate inici,
                                      LocalDate fi) {

        List<Album> albums = new ArrayList<>();

        for (Document doc : collection.find(
                and(
                        gte("date", inici.toString()),
                        lte("date", fi.toString())
                )
        )) {

            albums.add(
                    new Album(
                            doc.getString("artist"),
                            doc.getString("title"),
                            doc.getString("date")
                    )
            );
        }

        return albums;
    }

    public List<Album> getFilteredAlbum(String text) {

        List<Album> albums = new ArrayList<>();

        for (Document doc :
                collection.find(regex("title", text, "i"))) {

            albums.add(
                    new Album(
                            doc.getString("artist"),
                            doc.getString("title"),
                            doc.getString("date")
                    )
            );
        }

        return albums;
    }
}
