package com.shower.consultant.aiservice;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;
import dev.langchain4j.service.spring.AiServiceWiringMode;
import reactor.core.publisher.Flux;

/**
 * @author shower
 * @date 2025/09/14 16:19
 **/
@AiService(
        wiringMode = AiServiceWiringMode.EXPLICIT,
        chatModel = "openAiChatModel",
        streamingChatModel = "openAiStreamingChatModel"
)
public interface ConsultantService {
    //public String chat(String message);
    @SystemMessage(fromResource = "system.txt")
    public Flux<String> chat(String message);
}
