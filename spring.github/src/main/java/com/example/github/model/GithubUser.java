package com.example.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class GithubUser {
    private String login;
    private String url;
}
