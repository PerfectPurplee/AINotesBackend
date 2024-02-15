package com.ainotes.backendainotes.controller;

import com.ainotes.backendainotes.dto.gptCommunication.CompletionGptRequest;
import com.ainotes.backendainotes.dto.gptCommunication.CompletionGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class GptController {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/hitGpt")
    public String getResponseFromGPT(@RequestBody String prompt) {

        CompletionGptRequest completionGptRequest =
                new CompletionGptRequest("gpt-3.5-turbo", prompt);
        CompletionGptResponse completionGptResponse = restTemplate
                .postForObject("https://api.openai.com/v1/chat/completions", completionGptRequest, CompletionGptResponse.class);

        assert completionGptResponse != null;
        return completionGptResponse.getChoices().get(0).getMessage().getContent();
    }

}
