package com.ainotes.backendainotes.dto.gptCommunication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String role;
    private String content;
}
