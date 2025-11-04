package com.fakenews.detector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fakenews.detector.service.NewsService;
import com.fakenews.detector.serviceObjects.NewsRequest;

@RestController
@RequestMapping("/api") // base path
public class FakeNewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping("/check-news")
    public ResponseEntity<String> predictNews(@RequestBody NewsRequest request) {
        try {
            String prediction = newsService.predictNews(request.getText());
            return ResponseEntity.ok(prediction);
        } catch (Exception e) {
            System.out.println("Exception in generating a Response");
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error while predicting news: " + e.getMessage());
        }
    }
}
