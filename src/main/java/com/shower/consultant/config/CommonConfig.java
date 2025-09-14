package com.shower.consultant.config;

import com.shower.consultant.aiservice.ConsultantService;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shower
 * @date 2025/09/14 16:20
 **/
@Configuration
public class CommonConfig  {
    @Autowired
    private OpenAiChatModel openAiChatModel;
/*    @Bean
    public ConsultantService consultantService() {
        return AiServices.builder(ConsultantService.class)
                .chatModel(openAiChatModel)
                .build();
    }*/
}
