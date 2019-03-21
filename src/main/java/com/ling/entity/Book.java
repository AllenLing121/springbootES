package com.ling.entity;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Lian on 03/01/2019.
 */
@Document(indexName = "library",type = "book")
public class Book {
    private int id;
    private String name;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
