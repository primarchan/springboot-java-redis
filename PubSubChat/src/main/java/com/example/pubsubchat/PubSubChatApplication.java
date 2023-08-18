package com.example.pubsubchat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class PubSubChatApplication implements CommandLineRunner {

	private final ChatService chatService;

	public static void main(String[] args) {
		SpringApplication.run(PubSubChatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application started...");
		chatService.enterChatRoom("chat1");
	}

}
