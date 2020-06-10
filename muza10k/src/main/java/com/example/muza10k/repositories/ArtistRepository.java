package com.example.muza10k.repositories;

import com.example.muza10k.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
