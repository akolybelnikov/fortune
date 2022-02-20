package com.example.application.data.service;

import com.example.application.data.entity.Quote;
import com.example.application.data.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class QuoteService {

    private final QuoteRepository quoteRepo;

    public QuoteService( QuoteRepository quoteRepo) {
        this.quoteRepo = quoteRepo;
    }

    public String findQuote() {
        Long count = quoteRepo.count();
        Random rand = new Random();
        int rid = rand.nextInt(Math.toIntExact(count));
        Optional<Quote> q = quoteRepo.findById((long) rid);
        return q.get().getText();
    }

    public void saveQuote(Quote quote) {
        if (quote == null) {
            System.err.println("Quote is null");
            return;
        }
        quoteRepo.save(quote);
    }
}
