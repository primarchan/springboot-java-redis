package com.example.demo3.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalApiService {

    public String getUserName(String userId) {
        /**
         * 외부 서비스 or DB 호출
         */
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
           log.error(e.getMessage());
           e.printStackTrace();
        }

        log.info("Getting user name from other service...");

        if (userId.equals("A")) return "Adam";
        if (userId.equals("B")) return "Bob";

        return "";
    }

    @Cacheable(cacheNames = "userAgeCache", key = "#userId")
    public int getUserAge(String userId) {
        /**
         * 외부 서비스 or DB 호출
         */
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        log.info("Getting user age from other service...");

        if (userId.equals("A")) return 28;
        if (userId.equals("B")) return 32;

        return 0;
    }

}
