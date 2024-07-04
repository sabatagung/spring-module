package com.example.spring_app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private int statusCode;

    public ErrorResponse(int statusCode, String message)
    {
        super();
    }
}
