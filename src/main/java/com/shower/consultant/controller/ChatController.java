package com.shower.consultant.controller;

import com.shower.consultant.aiservice.ConsultantService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author shower
 * @date 2025/09/14 16:05
 **/
@RestController
public class ChatController {
/*    @Autowired
    private OpenAiChatModel model;
    @RequestMapping("/chat")
    public String chat(String message) {
        return model.chat(message);
    }*/
    @Autowired
    private ConsultantService consultantService;
/*    @RequestMapping("/chat")
    public String chat(String message) {
        return consultantService.chat(message);
    }*/
    @RequestMapping(value = "/chat" ,produces = "text/html;charset=utf-8")
    public Flux<String> chat(String memoryId, String message) {
        return consultantService.chat(memoryId, message);
    }
}
