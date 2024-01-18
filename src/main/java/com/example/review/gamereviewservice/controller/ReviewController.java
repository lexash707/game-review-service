package com.example.review.gamereviewservice.controller;

import com.example.review.gamereviewservice.dto.Game;
import com.example.review.gamereviewservice.model.Review;
import com.example.review.gamereviewservice.proxy.GameProxy;
import com.example.review.gamereviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private GameProxy gameProxy;

    @GetMapping("/game/{gameID}/reviews")
    public List<Review> allReviewsOfGame(@PathVariable Long gameID){
       return reviewService.allReviewsOfGame(gameID);
    }

    @PostMapping("/game/reviews")
    public ResponseEntity<HttpStatus> reviewGame(@RequestBody Review review){
        if (gameProxy.allGames().stream().map(Game::getId).toList().contains(review.getGameId()))
            return reviewService.addReview(review);

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
