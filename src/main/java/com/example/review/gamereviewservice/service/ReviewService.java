package com.example.review.gamereviewservice.service;

import com.example.review.gamereviewservice.model.Review;
import com.example.review.gamereviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> allReviewsOfGame(Long gameId) {
        return reviewRepository.findAllByGameId(gameId);
    }

    public ResponseEntity<HttpStatus> addReview(Review review) {

        if (reviewRepository.save(review) != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
