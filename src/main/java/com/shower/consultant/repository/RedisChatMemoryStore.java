package com.shower.consultant.repository;

import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.List;

/**
 * @author shower
 * @date 2025/09/14 22:21
 **/
@Repository
public class RedisChatMemoryStore implements ChatMemoryStore {
    // 注入 RedisTemplate
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public List<ChatMessage> getMessages(Object memoryId) {
        // 获取会话消息
        String json = redisTemplate.opsForValue().get(memoryId);
        // 把json数据反序列化为List<ChatMessage>
        return ChatMessageDeserializer.messagesFromJson(json);
    }

    @Override
    public void updateMessages(Object memoryId, List<ChatMessage> list) {
        // 更新会话消息
        // 序列化list
        String json = ChatMessageSerializer.messagesToJson(list);
        // 把json数据存储到redis中
        redisTemplate.opsForValue().set(memoryId.toString(), json, Duration.ofDays(1));
    }

    @Override
    public void deleteMessages(Object memoryId) {
        redisTemplate.delete(memoryId.toString());
    }
}
