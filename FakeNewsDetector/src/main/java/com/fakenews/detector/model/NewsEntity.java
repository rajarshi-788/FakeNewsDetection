package com.fakenews.detector.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "NEWS_RESULTS")
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_seq_gen")
    @SequenceGenerator(name = "news_seq_gen", sequenceName = "NEWS_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NEWS_TEXT", length = 2000)
    private String newsText;

    @Column(name = "PREDICTION")
    private String prediction;

    @Column(name = "CREATED_AT")
    private String createdAt;

    public NewsEntity() {}

    public NewsEntity(String newsText, String prediction, String createdAt) {
        this.newsText = newsText;
        this.prediction = prediction;
        this.createdAt = createdAt;
    }

    // Getters & Setters
}
