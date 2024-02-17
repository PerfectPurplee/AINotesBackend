package com.ainotes.backendainotes.controller;

import com.ainotes.backendainotes.dto.gptCommunication.CompletionGptRequest;
import com.ainotes.backendainotes.dto.gptCommunication.CompletionGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class GptController {


    private final RestTemplate restTemplate;

    @Autowired
    public GptController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }


    @GetMapping(path = "/api/hit")
    public String getGetFromGPT() {


        return "PROMPT";
    }

    @PostMapping("/api/hitGpt")
    public ResponseEntity<?> getResponseFromGPT(@RequestBody String prompt) {

        CompletionGptRequest completionGptRequest =
                new CompletionGptRequest("gpt-3.5-turbo", prompt, 30);
        CompletionGptResponse completionGptResponse = restTemplate
                .postForObject("https://api.openai.com/v1/chat/completions", completionGptRequest, CompletionGptResponse.class);
        if (completionGptResponse == null) {
            return ResponseEntity.status(404).body("something went wrong");
        } else
            return ResponseEntity.status(200).body(completionGptResponse);
    }

    @PostMapping("/api/hitGptString")
    public String getResponseFromGPTString(@RequestBody String prompt) {

        CompletionGptRequest completionGptRequest =
                new CompletionGptRequest("gpt-3.5-turbo", prompt, 30);
        CompletionGptResponse completionGptResponse = restTemplate
                .postForObject("https://api.openai.com/v1/chat/completions", completionGptRequest, CompletionGptResponse.class);

        if (completionGptResponse == null) {
            return "something went wrong";
        } else
            return completionGptResponse.getChoices().get(0).getMessage().getContent();
    }


}
