package com.shower.consultant.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

/**
 * @author shower
 * @date 2025/09/14 16:19
 **/
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT, // 手动装配
        chatModel = "openAiChatModel", // 指定模型
        streamingChatModel = "openAiStreamingChatModel", //指定流式调用模型
//        chatMemory = "chatMemory", // 配置会话记忆对象
        chatMemoryProvider = "chatMemoryProvider" // 配置会话记忆提供者对象
)
public interface ConsultantService {
    //public String chat(String message);
    @SystemMessage(fromResource = "system.txt")
    public Flux<String> chat(@MemoryId String memoryId, @UserMessage String message);
}
