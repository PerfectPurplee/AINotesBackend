package com.ainotes.backendainotes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReqistrationDTO {

    private String username;
    private String login;
    private String password;
}
