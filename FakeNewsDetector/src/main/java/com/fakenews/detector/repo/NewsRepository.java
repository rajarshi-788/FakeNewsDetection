package com.fakenews.detector.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fakenews.detector.model.NewsEntity;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
}
