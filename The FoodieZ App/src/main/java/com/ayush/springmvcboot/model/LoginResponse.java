package com.ayush.springmvcboot.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse
{
    @JsonAlias("Message")
    String message;
}
