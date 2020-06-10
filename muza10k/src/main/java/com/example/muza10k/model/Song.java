package com.example.muza10k.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String genre;
    private String ismn;
    private String year;
    private String publisher;

    @ManyToMany
    private Set<Artist> artists = new HashSet<>();

    public Song() {
    }

    public Song(String title, String genre, String ismn, String year, String publisher) {
        this.title = title;
        this.genre = genre;
        this.ismn = ismn;
        this.year = year;
        this.publisher = publisher;
    }

    public Song(String title, String genre, String ismn, String year, Set<Artist> artists) {
        this.title = title;
        this.genre = genre;
        this.ismn = ismn;
        this.year = year;
        this.publisher = publisher;
        this.artists = artists;
    }

    public Collection<Artist> getArtists() {
        return null;
    }
}