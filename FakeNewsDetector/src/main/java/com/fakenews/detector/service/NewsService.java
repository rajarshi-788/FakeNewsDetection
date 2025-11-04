package com.fakenews.detector.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fakenews.detector.model.NewsEntity;
import com.fakenews.detector.repo.NewsRepository;
import com.fakenews.detector.serviceObjects.NewsRequest;
import com.fakenews.detector.serviceObjects.PredictionResponse;

@Service
public class NewsService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NewsRepository newsRepository;

    public String predictNews(String text) {
        String pythonApiUrl = "http://localhost:5000/check-news";  // Flask endpoint

        try {
            // Build request body
            NewsRequest request = new NewsRequest(text);

            // Call Flask API
            PredictionResponse response = restTemplate.postForObject(
                    pythonApiUrl, request, PredictionResponse.class
            );

            String prediction = (response != null && response.getPrediction() != null)
                    ? response.getPrediction()
                    : "UNKNOWN";

            // Save to Oracle DB
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            NewsEntity entity = new NewsEntity(text, prediction, timestamp);
            newsRepository.save(entity);

            return prediction;

        } catch (Exception ex) {
            throw new RuntimeException("Error calling Flask API: " + ex.getMessage(), ex);
        }
    }
}