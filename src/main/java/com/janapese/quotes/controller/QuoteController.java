package com.janapese.quotes.controller;

import java.util.List;

import com.janapese.quotes.model.Quote;
import com.janapese.quotes.service.QuoteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping()
    public ResponseEntity<List<Quote>> getQuotes() {
        List<Quote> found = quoteService.getAll();

        if(found.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable int id) {
        Quote found = quoteService.getById(id);

        if(found == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(found, HttpStatus.OK);
    }

    @GetMapping("/random")
    public ResponseEntity<Quote> getRandomQuote() {
        List<Quote> quotes = quoteService.getAll();

        if(quotes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        int randomNumber = (int) (Math.random() * quotes.size());

        return new ResponseEntity<>(quotes.get(randomNumber), HttpStatus.OK);
    }
}
