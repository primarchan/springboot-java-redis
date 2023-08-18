package com.example.pubsubchat;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService implements MessageListener {

    private final RedisTemplate<String, String> redisTemplate;
    private final RedisMessageListenerContainer container;

    public void enterChatRoom(String chatRoomName) {
        container.addMessageListener(this, new ChannelTopic(chatRoomName));

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.equals("q")) {
                log.info("Quit...");
                break;
            }

            redisTemplate.convertAndSend(chatRoomName, line);
        }

        container.removeMessageListener(this);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info("Message : " + message.toString());
    }

}
