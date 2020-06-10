package com.example.muza10k.repositories;

import com.example.muza10k.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {

    List<Song> getAllByArtistsIsContaining(com.example.muza10k.model.Artist artist);
    Optional<Song> getFirstByIsmn(String ismn);

}