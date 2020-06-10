package com.example.muza10k.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class SongCommandToSong implements Converter<com.example.muza10k.commands.SongCommand, com.example.muza10k.model.Song> {

    private com.example.muza10k.repositories.PublisherRepository publisherRepository;
    private com.example.muza10k.repositories.ArtistRepository artistRepository;

    public SongCommandToSong(com.example.muza10k.repositories.PublisherRepository publisherRepository, com.example.muza10k.repositories.ArtistRepository artistRepository) {
        this.publisherRepository = publisherRepository;
        this.artistRepository = artistRepository;
    }

    @Synchronized
    @Nullable
    @Override
    public com.example.muza10k.model.Song convert(com.example.muza10k.commands.SongCommand source) {
        if (source == null) {
            return null;
        }

        final com.example.muza10k.model.Song song = new com.example.muza10k.model.Song();
        song.setId(source.getId());
        song.setTitle(source.getTitle());
        song.setGenre(source.getGenre());
        song.setYear(source.getYear());
        song.setIsmn(source.getIsmn());

        Optional<com.example.muza10k.model.Publisher> publisher = publisherRepository.findById(source.getPublisherId());

        if (publisher.isPresent()) {
            song.setPublisher(publisher.get());
        } else {
            song.setPublisher(publisherRepository.getPublisherByName("Unknown").get());
        }

        Optional<com.example.muza10k.model.Artist> artist = artistRepository.findById(source.getArtistId());

        if (artist.isPresent()) {
            song.getArtists().add(artist.get());
        }

        return song;
    }
}
