package com.janapese.quotes.repository;

import com.janapese.quotes.model.Quote;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
}
