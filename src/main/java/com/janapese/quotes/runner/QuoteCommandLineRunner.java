package com.janapese.quotes.runner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.janapese.quotes.model.Quote;
import com.janapese.quotes.repository.QuoteRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuoteCommandLineRunner implements CommandLineRunner {
    private final QuoteRepository quoteRepository;

    public QuoteCommandLineRunner(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createFromFile(getClass().getClassLoader().getResourceAsStream("quotes.txt"));
    }

    private void createFromFile(InputStream inputStream) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 2) {
                    String quote = parts[0].trim().replace("\"", "");
                    String author = parts[1].trim().replace("\"", "");

                    this.quoteRepository.save(new Quote(quote, author));
                }
            }
        }
    }
}
