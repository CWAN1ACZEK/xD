package com.example.muza10k.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArtistRepository extends CrudRepository<com.example.muza10k.model.Artist, Long> {
    Optional<com.example.muza10k.model.Artist> getFirstByFirstNameAndLastName(String firstName, String lastName);
    Optional<com.example.muza10k.model.Artist> getFirstByFirstName(String firstName);
}
