package com.example.leaderboard;

import com.example.leaderboard.service.RankingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;

@SpringBootTest
public class SimpleTest {

    public static final int TEST_SIZE = 1_000_000;

    @Autowired
    private RankingService rankingService;

    @Test
    @DisplayName("Redis 에 테스트 데이터 셋팅")
    void insertScore() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            int score = (int) (Math.random() * TEST_SIZE);
            String userId = "user_" + i;
            rankingService.setUserScore(userId, score);
        }
    }

    @Test
    @DisplayName("1. Redis 미사용 케이스")
    void inMemorySortPerformance() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < TEST_SIZE; i++) {
            int score = (int) (Math.random() * TEST_SIZE);
            list.add(score);
        }

        Instant before = Instant.now();

        Collections.sort(list);

        Duration elapsed = Duration.between(before, Instant.now());
        System.out.println(elapsed.getNano() / 1_000_000 + " ms");
    }

    @Test
    @DisplayName("2. Redis 사용 케이스")
    void redisSortPerformance() {
        Instant before = Instant.now();

        Long userRank = rankingService.getUserRanking("user_100");

        Duration elapsed = Duration.between(before, Instant.now());
        System.out.println(String.format("Rank(%d) - Took %d ms", userRank, elapsed.getNano() / 1_000_000));
    }

}
