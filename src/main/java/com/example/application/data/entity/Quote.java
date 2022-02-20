package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Quote extends AbstractEntity {
    @NotNull
    private String quote;

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getText() {
        return quote;
    }
}
