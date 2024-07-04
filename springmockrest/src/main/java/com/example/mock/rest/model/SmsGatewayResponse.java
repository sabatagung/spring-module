package com.example.mock.rest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SmsGatewayResponse {

    private String transactionId;
    private String responseCode;
    private String responseMessage;
    private List<SmsInfo> smsInformation;
}

