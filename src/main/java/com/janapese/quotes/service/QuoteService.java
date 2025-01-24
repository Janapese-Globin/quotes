package com.janapese.quotes.service;

import java.util.List;

import com.janapese.quotes.model.Quote;
import com.janapese.quotes.repository.QuoteRepository;

import org.springframework.stereotype.Service;

@Service
public class QuoteService {
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
