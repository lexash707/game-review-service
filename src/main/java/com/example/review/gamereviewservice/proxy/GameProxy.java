package com.example.review.gamereviewservice.proxy;

import com.example.review.gamereviewservice.dto.Game;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "localhost:8080", name = "game-service")
public interface GameProxy {
    @GetMapping("/allGames")
    List<Game> allGames();
}
