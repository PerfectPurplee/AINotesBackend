package com.ainotes.backendainotes.dto.gptCommunication;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CompletionGptRequest {

    private String model;
    private List<Message> messages;
    private int max_tokens;

    public CompletionGptRequest(String model, String prompt, int max_tokens) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
        this.max_tokens = max_tokens;
    }
}
