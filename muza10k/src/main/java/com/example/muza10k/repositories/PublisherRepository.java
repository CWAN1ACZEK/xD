package com.example.muza10k.repositories;

import com.example.muza10k.model.Publisher;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    Optional<Publisher> getPublisherByName(String name);
}