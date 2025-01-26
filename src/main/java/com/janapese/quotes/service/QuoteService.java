package com.janapese.quotes.service;

import java.util.List;

import com.janapese.quotes.model.Quote;
import com.janapese.quotes.repository.QuoteRepository;

import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    private Long lastDailyQuote;
    private Quote dailyQuote;

    private final QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<Quote> getAll(){
        return quoteRepository.findAll();
    }

    public Quote getById(long id){
        return quoteRepository.findById(id).orElse(null);
    }

    public Quote getById(int id){
        return quoteRepository.findById((long) id).orElse(null);
    }

    public Quote getDailyQuote() {
        if(this.lastDailyQuote == null || this.lastDailyQuote + 86400 < System.currentTimeMillis()){
            this.dailyQuote = getRandomQuote();
            this.lastDailyQuote = System.currentTimeMillis();
        }

        return this.dailyQuote;
    }

    public Quote getRandomQuote() {
        List<Quote> allQuotes = quoteRepository.findAll();

        if(allQuotes.isEmpty()){
            return null;
        }

        return allQuotes.get((int) (Math.random() * allQuotes.size()));
    }

    public Quote create(Quote quote){
        return quoteRepository.save(quote);
    }

    public void delete(long id){
        quoteRepository.deleteById(id);
    }

    public void saveAll(List<Quote> quotes){
        quoteRepository.saveAll(quotes);
    }
}
