package com.example.spring_app.model;

import lombok.Data;

@Data
public class Amount {
    private float amount;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
